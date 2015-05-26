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

package org.jetbrains.kotlin.idea.decompiler.stubBuilder

import com.intellij.openapi.vfs.VirtualFile
import org.jetbrains.kotlin.idea.decompiler.textBuilder.buildDecompiledTextFromJsMetadata
import org.jetbrains.kotlin.idea.js.KotlinJavaScriptLibraryManager
import org.jetbrains.kotlin.idea.test.KotlinStdJSProjectDescriptor
import org.jetbrains.kotlin.idea.vfilefinder.JsVirtualFileFinder
import org.jetbrains.kotlin.load.kotlin.VirtualFileFinder
import org.jetbrains.kotlin.name.FqName
import kotlin.properties.Delegates

public class KotlinJavaScriptStubConsistencyTest : StubConsistencyBaseTest() {

    override val packages: List<FqName> = listOf(
            "java.util", "jquery", "jquery.ui", "kotlin", "kotlin.browser", "kotlin.dom", "kotlin.js"
    ).map { FqName(it) }

    override fun setUp() {
        super.setUp()
        KotlinJavaScriptLibraryManager.getInstance(getProject()).syncUpdateProjectLibrary()
    }

    override val virtualFileFinder: VirtualFileFinder by Delegates.lazy() {
        JsVirtualFileFinder.SERVICE.getInstance(getProject())
    }

    override fun createStubBuilder() = KotlinJavaScriptStubBuilder()

    override fun getDecompiledText(packageFile: VirtualFile): String = buildDecompiledTextFromJsMetadata(packageFile).text

    override fun getProjectDescriptor() = KotlinStdJSProjectDescriptor.instance
}
