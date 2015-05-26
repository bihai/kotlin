/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.idea.quickfix

import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveElementVisitor
import org.jetbrains.kotlin.analyzer.analyzeInContext
import org.jetbrains.kotlin.descriptors.*
import org.jetbrains.kotlin.idea.caches.resolve.ResolutionFacade
import org.jetbrains.kotlin.idea.core.collectElementsOfType
import org.jetbrains.kotlin.idea.imports.canBeReferencedViaImport
import org.jetbrains.kotlin.idea.imports.importableFqName
import org.jetbrains.kotlin.idea.util.IdeDescriptorRenderers
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.name.FqNameUnsafe
import org.jetbrains.kotlin.name.Name
import org.jetbrains.kotlin.psi.*
import org.jetbrains.kotlin.psi.psiUtil.getReceiverExpression
import org.jetbrains.kotlin.psi.psiUtil.replaced
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.FunctionDescriptorUtil
import org.jetbrains.kotlin.resolve.calls.callUtil.getResolvedCall
import org.jetbrains.kotlin.resolve.descriptorUtil.isExtension
import org.jetbrains.kotlin.resolve.scopes.*
import org.jetbrains.kotlin.resolve.scopes.receivers.ThisReceiver
import org.jetbrains.kotlin.utils.Printer
import org.jetbrains.kotlin.utils.addIfNotNull
import org.jetbrains.kotlin.utils.addToStdlib.firstIsInstanceOrNull
import java.util.*

//TODO: use ReplaceWith from package kotlin
data class ReplaceWith(val expression: String, vararg val imports: String)

object ReplaceWithAnnotationAnalyzer {
    public data class ReplacementExpression(
            val expression: JetExpression,
            val imports: Collection<FqName>,
            val parameterUsages: Map<ValueParameterDescriptor, Collection<JetExpression>>
    )

    public fun analyze(
            annotation: ReplaceWith,
            symbolDescriptor: CallableDescriptor,
            resolutionFacade: ResolutionFacade,
            file: JetFile/*TODO: drop it*/,
            project: Project
    ): ReplacementExpression {
        val psiFactory = JetPsiFactory(project)
        var expression = psiFactory.createExpression(annotation.expression)

        val importFqNames = annotation.imports
                .filter { FqNameUnsafe.isValid(it) }
                .map { FqNameUnsafe(it) }
                .filter { it.isSafe() }
                .mapTo(LinkedHashSet<FqName>()) { it.toSafe() }

        val symbolScope = getResolutionScope(symbolDescriptor)
        val explicitlyImportedSymbols = importFqNames.flatMap { resolutionFacade.resolveImportReference(file, it) }
        val scope = ChainedScope(symbolDescriptor, "ReplaceWith resolution scope", ExplicitImportsScope(explicitlyImportedSymbols), symbolScope)

        val bindingContext = expression.analyzeInContext(scope)

        val thisType = symbolDescriptor.getExtensionReceiverParameter()?.getType()
                       ?: (symbolDescriptor.getContainingDeclaration() as? ClassifierDescriptor)?.getDefaultType()

        val receiversToAdd = ArrayList<Pair<JetExpression, String>>()

        val parameterUsageKey = Key<ValueParameterDescriptor>("parameterUsageKey")

        expression.accept(object : JetVisitorVoid(){
            override fun visitSimpleNameExpression(expression: JetSimpleNameExpression) {
                val target = bindingContext[BindingContext.REFERENCE_TARGET, expression] ?: return

                if (target.canBeReferencedViaImport()) {
                    if (target.isExtension || expression.getReceiverExpression() == null) {
                        importFqNames.addIfNotNull(target.importableFqName)
                    }
                }

                if (expression.getReceiverExpression() == null) {
                    if (target is ValueParameterDescriptor && target.getContainingDeclaration() == symbolDescriptor) {
                        expression.putCopyableUserData(parameterUsageKey, target)
                    }

                    val resolvedCall = expression.getResolvedCall(bindingContext)
                    if (resolvedCall != null && resolvedCall.getStatus().isSuccess()) {
                        val receiver = if (resolvedCall.getResultingDescriptor().isExtension)
                            resolvedCall.getExtensionReceiver()
                        else
                            resolvedCall.getDispatchReceiver()
                        if (receiver is ThisReceiver) {
                            if (receiver.getType() == thisType) {
                                receiversToAdd.add(expression to "this")
                            }
                            else {
                                val descriptor = receiver.getDeclarationDescriptor()
                                if (descriptor is ClassDescriptor && descriptor.isCompanionObject()) {
                                    receiversToAdd.add(expression to IdeDescriptorRenderers.SOURCE_CODE.renderClassifierName(descriptor))
                                }
                            }
                        }
                    }
                }
            }

            override fun visitJetElement(element: JetElement) {
                element.acceptChildren(this)
            }
        })

        for ((expr, receiverText) in receiversToAdd) {
            val expressionToReplace = expr.getParent() as? JetCallExpression ?: expr
            val newExpr = expressionToReplace.replaced(psiFactory.createExpressionByPattern("$receiverText.$0", expressionToReplace))
            if (expressionToReplace == expression) {
                expression = newExpr
            }
        }

        val parameterUsages = symbolDescriptor.getValueParameters()
                .map { parameter -> parameter to expression.collectElementsOfType<JetExpression> { it.getCopyableUserData(parameterUsageKey) == parameter } }
                .toMap()

        expression.accept(object : PsiRecursiveElementVisitor() {
            override fun visitElement(element: PsiElement) {
                element.putCopyableUserData(parameterUsageKey, null)
            }
        })

        return ReplacementExpression(expression, importFqNames, parameterUsages)
    }

    private fun getResolutionScope(descriptor: DeclarationDescriptor): JetScope {
        return when (descriptor) {
            is PackageFragmentDescriptor -> {
                val moduleDescriptor = descriptor.getContainingDeclaration()
                getResolutionScope(moduleDescriptor.getPackage(descriptor.fqName)!!)
            }

            is PackageViewDescriptor ->
                descriptor.getMemberScope()

            is ClassDescriptorWithResolutionScopes ->
                descriptor.getScopeForMemberDeclarationResolution()

            is FunctionDescriptor ->
                FunctionDescriptorUtil.getFunctionInnerScope(getResolutionScope(descriptor.getContainingDeclaration()),
                                                             descriptor, RedeclarationHandler.DO_NOTHING)

            is PropertyDescriptor ->
                JetScopeUtils.getPropertyDeclarationInnerScope(descriptor,
                                                               getResolutionScope(descriptor.getContainingDeclaration()!!),
                                                               RedeclarationHandler.DO_NOTHING)

            else -> throw IllegalArgumentException("Cannot find resolution scope for $descriptor")
        }
    }

    private class ExplicitImportsScope(val descriptors: Collection<DeclarationDescriptor>) : JetScope {
        override fun getClassifier(name: Name) = descriptors.filter { it.getName() == name }.firstIsInstanceOrNull<ClassifierDescriptor>()

        override fun getPackage(name: Name)= descriptors.filter { it.getName() == name }.firstIsInstanceOrNull<PackageViewDescriptor>()

        override fun getProperties(name: Name) = descriptors.filter { it.getName() == name }.filterIsInstance<VariableDescriptor>()

        override fun getLocalVariable(name: Name): VariableDescriptor? = null

        override fun getFunctions(name: Name) = descriptors.filter { it.getName() == name }.filterIsInstance<FunctionDescriptor>()

        override fun getContainingDeclaration() = throw UnsupportedOperationException()

        override fun getDeclarationsByLabel(labelName: Name) = emptyList<DeclarationDescriptor>()

        override fun getDescriptors(kindFilter: DescriptorKindFilter, nameFilter: (Name) -> Boolean) = descriptors

        override fun getImplicitReceiversHierarchy() = emptyList<ReceiverParameterDescriptor>()

        override fun getOwnDeclaredDescriptors() = emptyList<DeclarationDescriptor>()

        override fun printScopeStructure(p: Printer) {
            p.println(javaClass.getName())
        }
    }
}