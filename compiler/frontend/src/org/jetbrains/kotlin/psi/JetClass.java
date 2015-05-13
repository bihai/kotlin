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

package org.jetbrains.kotlin.psi;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.navigation.ItemPresentationProviders;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.JetNodeTypes;
import org.jetbrains.kotlin.lexer.JetTokens;
import org.jetbrains.kotlin.name.FqName;
import org.jetbrains.kotlin.psi.stubs.KotlinClassStub;
import org.jetbrains.kotlin.psi.stubs.elements.JetStubElementTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JetClass extends JetTypeParameterListOwnerStub<KotlinClassStub> implements JetClassOrObject {

    public JetClass(@NotNull ASTNode node) {
        super(node);
    }

    public JetClass(@NotNull KotlinClassStub stub) {
        super(stub, JetStubElementTypes.CLASS);
    }

    @NotNull
    @Override
    public List<JetDeclaration> getDeclarations() {
        JetClassBody body = getBody();
        if (body == null) return Collections.emptyList();

        return body.getDeclarations();
    }

    @Override
    public <R, D> R accept(@NotNull JetVisitor<R, D> visitor, D data) {
        return visitor.visitClass(this, data);
    }

    @Nullable
    public JetPrimaryConstructor getPrimaryConstructor() {
        return getStubOrPsiChild(JetStubElementTypes.PRIMARY_CONSTRUCTOR);
    }

    @Nullable
    public JetParameterList getPrimaryConstructorParameterList() {
        JetPrimaryConstructor primaryConstructor = getPrimaryConstructor();
        return primaryConstructor != null ? primaryConstructor.getValueParameterList() : null;
    }

    @NotNull
    public List<JetParameter> getPrimaryConstructorParameters() {
        JetParameterList list = getPrimaryConstructorParameterList();
        if (list == null) return Collections.emptyList();
        return list.getParameters();
    }

    @NotNull
    public JetPrimaryConstructor createPrimaryConstructorIfAbsent() {
        JetPrimaryConstructor constructor = getPrimaryConstructor();
        if (constructor != null) return constructor;
        PsiElement anchor = getTypeParameterList();
        if (anchor == null) anchor = getNameIdentifier();
        if (anchor == null) anchor = getLastChild();
        return (JetPrimaryConstructor) addAfter(new JetPsiFactory(getProject()).createPrimaryConstructor(), anchor);
    }

    @NotNull
    public JetParameterList createPrimaryConstructorParameterListIfAbsent() {
        JetPrimaryConstructor constructor = createPrimaryConstructorIfAbsent();
        JetParameterList parameterList = constructor.getValueParameterList();
        if (parameterList != null) return parameterList;
        return (JetParameterList) constructor.add(new JetPsiFactory(getProject()).createParameterList("()"));
    }

    @Override
    @Nullable
    public JetDelegationSpecifierList getDelegationSpecifierList() {
        return getStubOrPsiChild(JetStubElementTypes.DELEGATION_SPECIFIER_LIST);
    }

    @Override
    @NotNull
    public List<JetDelegationSpecifier> getDelegationSpecifiers() {
        JetDelegationSpecifierList list = getDelegationSpecifierList();
        return list != null ? list.getDelegationSpecifiers() : Collections.<JetDelegationSpecifier>emptyList();
    }

    @Nullable
    public JetModifierList getPrimaryConstructorModifierList() {
        JetPrimaryConstructor primaryConstructor = getPrimaryConstructor();
        return primaryConstructor != null ? primaryConstructor.getModifierList() : null;
    }

    @Override
    @NotNull
    public List<JetClassInitializer> getAnonymousInitializers() {
        JetClassBody body = getBody();
        if (body == null) return Collections.emptyList();

        return body.getAnonymousInitializers();
    }

    public boolean hasExplicitPrimaryConstructor() {
        return getPrimaryConstructor() != null;
    }

    @Override
    public JetObjectDeclarationName getNameAsDeclaration() {
        return (JetObjectDeclarationName) findChildByType(JetNodeTypes.OBJECT_DECLARATION_NAME);
    }

    @Override
    public JetClassBody getBody() {
        return getStubOrPsiChild(JetStubElementTypes.CLASS_BODY);
    }

    @Nullable
    public PsiElement getColon() {
        return findChildByType(JetTokens.COLON);
    }

    public List<JetProperty> getProperties() {
        JetClassBody body = getBody();
        if (body == null) return Collections.emptyList();

        return body.getProperties();
    }

    public boolean isInterface() {
        KotlinClassStub stub = getStub();
        if (stub != null) {
            return stub.isInterface();
        }

        return findChildByType(JetTokens.TRAIT_KEYWORD) != null ||
               findChildByType(JetTokens.INTERFACE_KEYWORD) != null;
    }

    public boolean isEnum() {
        return hasModifier(JetTokens.ENUM_KEYWORD);
    }

    public boolean isAnnotation() {
        return hasModifier(JetTokens.ANNOTATION_KEYWORD);
    }

    public boolean isInner() {
        return hasModifier(JetTokens.INNER_KEYWORD);
    }

    @Override
    public boolean isEquivalentTo(PsiElement another) {
        if (super.isEquivalentTo(another)) {
            return true;
        }
        if (another instanceof JetClass) {
            String fq1 = getQualifiedName();
            String fq2 = ((JetClass) another).getQualifiedName();
            return fq1 != null && fq2 != null && fq1.equals(fq2);
        }
        return false;
    }

    @Nullable
    private String getQualifiedName() {
        KotlinClassStub stub = getStub();
        if (stub != null) {
            FqName fqName = stub.getFqName();
            return fqName == null ? null : fqName.asString();
        }

        List<String> parts = new ArrayList<String>();
        JetClassOrObject current = this;
        while (current != null) {
            parts.add(current.getName());
            current = PsiTreeUtil.getParentOfType(current, JetClassOrObject.class);
        }
        PsiFile file = getContainingFile();
        if (!(file instanceof JetFile)) return null;
        String fileQualifiedName = ((JetFile) file).getPackageFqName().asString();
        if (!fileQualifiedName.isEmpty()) {
            parts.add(fileQualifiedName);
        }
        Collections.reverse(parts);
        return StringUtil.join(parts, ".");
    }

    @Override
    public ItemPresentation getPresentation() {
        return ItemPresentationProviders.getItemPresentation(this);
    }

    @Override
    public boolean isTopLevel() {
        return getContainingFile() == getParent();
    }

    @Override
    public boolean isLocal() {
        KotlinClassStub stub = getStub();
        if (stub != null) {
            return stub.isLocal();
        }
        return JetPsiUtil.isLocal(this);
    }

    @NotNull
    public List<JetObjectDeclaration> getCompanionObjects() {
        JetClassBody body = getBody();
        if (body == null) {
            return Collections.emptyList();
        }
        return body.getAllCompanionObjects();
    }

    public boolean hasPrimaryConstructor() {
        return hasExplicitPrimaryConstructor() || !hasSecondaryConstructors();
    }

    private boolean hasSecondaryConstructors() {
        return !getSecondaryConstructors().isEmpty();
    }

    @NotNull
    public List<JetSecondaryConstructor> getSecondaryConstructors() {
        JetClassBody body = getBody();
        return body != null ? body.getSecondaryConstructors() : Collections.<JetSecondaryConstructor>emptyList();
    }

    @Nullable
    public PsiElement getClassOrInterfaceKeyword() {
        return findChildByType(TokenSet.create(JetTokens.CLASS_KEYWORD, JetTokens.INTERFACE_KEYWORD));
    }
}
