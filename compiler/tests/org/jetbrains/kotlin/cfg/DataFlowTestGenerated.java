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

package org.jetbrains.kotlin.cfg;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.jet.JUnit3RunnerWithInners;
import org.jetbrains.jet.JetTestUtils;
import org.jetbrains.jet.test.InnerTestClasses;
import org.jetbrains.jet.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/cfg-variables")
@TestDataPath("$PROJECT_ROOT")
@InnerTestClasses({DataFlowTestGenerated.Basic.class, DataFlowTestGenerated.Bugs.class, DataFlowTestGenerated.LexicalScopes.class})
@RunWith(JUnit3RunnerWithInners.class)
public class DataFlowTestGenerated extends AbstractDataFlowTest {
    public void testAllFilesPresentInCfg_variables() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/cfg-variables"), Pattern.compile("^(.+)\\.kt$"), true);
    }

    @TestMetadata("compiler/testData/cfg-variables/basic")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Basic extends AbstractDataFlowTest {
        public void testAllFilesPresentInBasic() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/cfg-variables/basic"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("IfWithUninitialized.kt")
        public void testIfWithUninitialized() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/basic/IfWithUninitialized.kt");
            doTest(fileName);
        }

        @TestMetadata("InitializedNotDeclared.kt")
        public void testInitializedNotDeclared() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/basic/InitializedNotDeclared.kt");
            doTest(fileName);
        }

        @TestMetadata("UsageInFunctionLiteral.kt")
        public void testUsageInFunctionLiteral() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/basic/UsageInFunctionLiteral.kt");
            doTest(fileName);
        }

        @TestMetadata("VariablesInitialization.kt")
        public void testVariablesInitialization() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/basic/VariablesInitialization.kt");
            doTest(fileName);
        }

        @TestMetadata("VariablesUsage.kt")
        public void testVariablesUsage() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/basic/VariablesUsage.kt");
            doTest(fileName);
        }
    }

    @TestMetadata("compiler/testData/cfg-variables/bugs")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class Bugs extends AbstractDataFlowTest {
        public void testAllFilesPresentInBugs() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/cfg-variables/bugs"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("referenceToPropertyInitializer.kt")
        public void testReferenceToPropertyInitializer() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/bugs/referenceToPropertyInitializer.kt");
            doTest(fileName);
        }

        @TestMetadata("varInitializationInIf.kt")
        public void testVarInitializationInIf() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/bugs/varInitializationInIf.kt");
            doTest(fileName);
        }

        @TestMetadata("varInitializationInIfInCycle.kt")
        public void testVarInitializationInIfInCycle() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/bugs/varInitializationInIfInCycle.kt");
            doTest(fileName);
        }
    }

    @TestMetadata("compiler/testData/cfg-variables/lexicalScopes")
    @TestDataPath("$PROJECT_ROOT")
    @RunWith(JUnit3RunnerWithInners.class)
    public static class LexicalScopes extends AbstractDataFlowTest {
        public void testAllFilesPresentInLexicalScopes() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("compiler/testData/cfg-variables/lexicalScopes"), Pattern.compile("^(.+)\\.kt$"), true);
        }

        @TestMetadata("doWhileScope.kt")
        public void testDoWhileScope() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/lexicalScopes/doWhileScope.kt");
            doTest(fileName);
        }

        @TestMetadata("forScope.kt")
        public void testForScope() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/lexicalScopes/forScope.kt");
            doTest(fileName);
        }

        @TestMetadata("functionLiteralScope.kt")
        public void testFunctionLiteralScope() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/lexicalScopes/functionLiteralScope.kt");
            doTest(fileName);
        }

        @TestMetadata("ifScope.kt")
        public void testIfScope() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/lexicalScopes/ifScope.kt");
            doTest(fileName);
        }

        @TestMetadata("localClass.kt")
        public void testLocalClass() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/lexicalScopes/localClass.kt");
            doTest(fileName);
        }

        @TestMetadata("localFunctionScope.kt")
        public void testLocalFunctionScope() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/lexicalScopes/localFunctionScope.kt");
            doTest(fileName);
        }

        @TestMetadata("localFunctionScopeWithoutBody.kt")
        public void testLocalFunctionScopeWithoutBody() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/lexicalScopes/localFunctionScopeWithoutBody.kt");
            doTest(fileName);
        }

        @TestMetadata("localObject.kt")
        public void testLocalObject() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/lexicalScopes/localObject.kt");
            doTest(fileName);
        }

        @TestMetadata("objectLiteralScope.kt")
        public void testObjectLiteralScope() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/lexicalScopes/objectLiteralScope.kt");
            doTest(fileName);
        }

        @TestMetadata("propertyAccessorScope.kt")
        public void testPropertyAccessorScope() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/lexicalScopes/propertyAccessorScope.kt");
            doTest(fileName);
        }

        @TestMetadata("tryScope.kt")
        public void testTryScope() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/lexicalScopes/tryScope.kt");
            doTest(fileName);
        }

        @TestMetadata("whileScope.kt")
        public void testWhileScope() throws Exception {
            String fileName = JetTestUtils.navigationMetadata("compiler/testData/cfg-variables/lexicalScopes/whileScope.kt");
            doTest(fileName);
        }
    }
}