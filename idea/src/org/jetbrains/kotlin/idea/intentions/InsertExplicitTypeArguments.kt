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

package org.jetbrains.kotlin.idea.intentions

import com.intellij.openapi.editor.Editor
import org.jetbrains.kotlin.psi.JetCallExpression
import org.jetbrains.kotlin.psi.JetPsiFactory
import org.jetbrains.kotlin.types.ErrorUtils
import org.jetbrains.kotlin.idea.util.ShortenReferences
import org.jetbrains.kotlin.resolve.calls.callUtil.getResolvedCall
import org.jetbrains.kotlin.psi.JetTypeArgumentList
import org.jetbrains.kotlin.idea.util.IdeDescriptorRenderers
import org.jetbrains.kotlin.idea.caches.resolve.analyze

public class InsertExplicitTypeArguments : JetSelfTargetingIntention<JetCallExpression>(javaClass(), "Add explicit type arguments") {
    override fun isApplicableTo(element: JetCallExpression, caretOffset: Int): Boolean {
        if (!element.getTypeArguments().isEmpty()) return false
        val callee = element.getCalleeExpression() ?: return false
        if (!callee.getTextRange().containsOffset(caretOffset)) return false

        val resolvedCall = element.getResolvedCall(element.analyze()) ?: return false
        val typeArgs = resolvedCall.getTypeArguments()
        return !typeArgs.isEmpty() && typeArgs.values().none { ErrorUtils.containsErrorType(it) }
    }

    override fun applyTo(element: JetCallExpression, editor: Editor) {
        val argumentList = createTypeArguments(element)!!

        val callee = element.getCalleeExpression()!!
        val newArgumentList = element.addAfter(argumentList, callee) as JetTypeArgumentList

        ShortenReferences.DEFAULT.process(newArgumentList)
    }

    companion object {
        public fun createTypeArguments(element: JetCallExpression): JetTypeArgumentList? {
            val resolvedCall = element.getResolvedCall(element.analyze()) ?: return null

            val args = resolvedCall.getTypeArguments()
            val types = resolvedCall.getCandidateDescriptor().getTypeParameters()

            val text = types.map { IdeDescriptorRenderers.SOURCE_CODE.renderType(args[it]!!) }.joinToString(", ", "<", ">")

            return JetPsiFactory(element).createTypeArguments(text)
        }
    }
}
