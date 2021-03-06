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

package org.jetbrains.kotlin.idea.decompiler.navigation;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.GlobalSearchScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.kotlin.descriptors.ClassDescriptor;
import org.jetbrains.kotlin.descriptors.ClassOrPackageFragmentDescriptor;
import org.jetbrains.kotlin.descriptors.DeclarationDescriptor;
import org.jetbrains.kotlin.descriptors.PackageFragmentDescriptor;
import org.jetbrains.kotlin.idea.decompiler.DecompilerPackage;
import org.jetbrains.kotlin.idea.decompiler.KotlinClsFileBase;
import org.jetbrains.kotlin.idea.stubindex.JetSourceFilterScope;
import org.jetbrains.kotlin.idea.vfilefinder.JsVirtualFileFinderFactory;
import org.jetbrains.kotlin.load.kotlin.JvmVirtualFileFinderFactory;
import org.jetbrains.kotlin.load.kotlin.VirtualFileFinder;
import org.jetbrains.kotlin.load.kotlin.VirtualFileFinderFactory;
import org.jetbrains.kotlin.name.ClassId;
import org.jetbrains.kotlin.psi.JetDeclaration;
import org.jetbrains.kotlin.resolve.DescriptorUtils;
import org.jetbrains.kotlin.serialization.js.KotlinJavascriptPackageFragment;
import org.jetbrains.kotlin.types.ErrorUtils;
import org.jetbrains.kotlin.types.expressions.ExpressionTypingUtils;

import static org.jetbrains.kotlin.load.kotlin.PackageClassUtils.getPackageClassId;
import static org.jetbrains.kotlin.resolve.descriptorUtil.DescriptorUtilPackage.getClassId;

public final class DecompiledNavigationUtils {

    @Nullable
    public static JetDeclaration getDeclarationFromDecompiledClassFile(
            @NotNull Project project,
            @NotNull DeclarationDescriptor referencedDescriptor
    ) {
        if (DescriptorUtils.isLocal(referencedDescriptor)) return null;
        VirtualFile virtualFile = findVirtualFileContainingDescriptor(project, referencedDescriptor);

        if (virtualFile == null ||
            !DecompilerPackage.isKotlinJvmCompiledFile(virtualFile) &&
            !DecompilerPackage.isKotlinJsMetaFile(virtualFile)) return null;

        PsiFile psiFile = PsiManager.getInstance(project).findFile(virtualFile);
        if (!(psiFile instanceof KotlinClsFileBase)) {
            return null;
        }

        return ((KotlinClsFileBase) psiFile).getDeclarationForDescriptor(referencedDescriptor);
    }

    /*
        Find virtual file which contains the declaration of descriptor we're navigating to.
     */
    @Nullable
    private static VirtualFile findVirtualFileContainingDescriptor(
            @NotNull Project project,
            @NotNull DeclarationDescriptor referencedDescriptor
    ) {
        if (ErrorUtils.isError(referencedDescriptor)) return null;

        ClassId containerClassId = getContainerClassId(referencedDescriptor);
        if (containerClassId == null) return null;

        GlobalSearchScope scopeToSearchIn = JetSourceFilterScope.kotlinSourceAndClassFiles(GlobalSearchScope.allScope(project), project);

        VirtualFileFinderFactory virtualFileFinderFactory;
        if (isFromKotlinJavasriptMetadata(referencedDescriptor)) {
            virtualFileFinderFactory = JsVirtualFileFinderFactory.SERVICE.getInstance(project);
        }
        else {
            virtualFileFinderFactory = JvmVirtualFileFinderFactory.SERVICE.getInstance(project);
        }

        VirtualFileFinder fileFinder = virtualFileFinderFactory.create(scopeToSearchIn);
        return fileFinder.findVirtualFileWithHeader(containerClassId);
    }

    private static boolean isFromKotlinJavasriptMetadata(@NotNull DeclarationDescriptor referencedDescriptor) {
        PackageFragmentDescriptor packageFragmentDescriptor =
                DescriptorUtils.getParentOfType(referencedDescriptor, PackageFragmentDescriptor.class, false);
        return packageFragmentDescriptor instanceof KotlinJavascriptPackageFragment;
    }

    //TODO: navigate to inner classes
    @Nullable
    private static ClassId getContainerClassId(@NotNull DeclarationDescriptor referencedDescriptor) {
        ClassOrPackageFragmentDescriptor
                containerDescriptor = DescriptorUtils.getParentOfType(referencedDescriptor, ClassOrPackageFragmentDescriptor.class, false);
        if (containerDescriptor instanceof PackageFragmentDescriptor) {
            return getPackageClassId(((PackageFragmentDescriptor) containerDescriptor).getFqName());
        }
        if (containerDescriptor instanceof ClassDescriptor) {
            if (containerDescriptor.getContainingDeclaration() instanceof ClassDescriptor
                || ExpressionTypingUtils.isLocal(containerDescriptor.getContainingDeclaration(), containerDescriptor)) {
                return getContainerClassId(containerDescriptor.getContainingDeclaration());
            }
            return getClassId((ClassDescriptor) containerDescriptor);
        }
        return null;
    }

    private DecompiledNavigationUtils() {
    }
}
