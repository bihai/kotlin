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

package org.jetbrains.kotlin.idea.completion.test;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.JUnit3RunnerWithInners;
import org.jetbrains.kotlin.test.JetTestUtils;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("idea/idea-completion/testData/keywords")
@TestDataPath("$PROJECT_ROOT")
@RunWith(JUnit3RunnerWithInners.class)
public class KeywordCompletionTestGenerated extends AbstractKeywordCompletionTest {
    @TestMetadata("AfterClassProperty.kt")
    public void testAfterClassProperty() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/AfterClassProperty.kt");
        doTest(fileName);
    }

    @TestMetadata("AfterClasses.kt")
    public void testAfterClasses() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/AfterClasses.kt");
        doTest(fileName);
    }

    @TestMetadata("AfterDot.kt")
    public void testAfterDot() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/AfterDot.kt");
        doTest(fileName);
    }

    @TestMetadata("AfterFuns.kt")
    public void testAfterFuns() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/AfterFuns.kt");
        doTest(fileName);
    }

    @TestMetadata("AfterSafeDot.kt")
    public void testAfterSafeDot() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/AfterSafeDot.kt");
        doTest(fileName);
    }

    @TestMetadata("AfterSpaceAndDot.kt")
    public void testAfterSpaceAndDot() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/AfterSpaceAndDot.kt");
        doTest(fileName);
    }

    public void testAllFilesPresentInKeywords() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), new File("idea/idea-completion/testData/keywords"), Pattern.compile("^(.+)\\.kt$"), false);
    }

    @TestMetadata("BeforeDelegationCall.kt")
    public void testBeforeDelegationCall() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/BeforeDelegationCall.kt");
        doTest(fileName);
    }

    @TestMetadata("BreakContinue.kt")
    public void testBreakContinue() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/BreakContinue.kt");
        doTest(fileName);
    }

    @TestMetadata("BreakWithLabel.kt")
    public void testBreakWithLabel() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/BreakWithLabel.kt");
        doTest(fileName);
    }

    @TestMetadata("CommaExpected.kt")
    public void testCommaExpected() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/CommaExpected.kt");
        doTest(fileName);
    }

    @TestMetadata("CompanionObjectBeforeObject.kt")
    public void testCompanionObjectBeforeObject() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/CompanionObjectBeforeObject.kt");
        doTest(fileName);
    }

    @TestMetadata("ContinueWithLabel.kt")
    public void testContinueWithLabel() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/ContinueWithLabel.kt");
        doTest(fileName);
    }

    @TestMetadata("FileKeyword.kt")
    public void testFileKeyword() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/FileKeyword.kt");
        doTest(fileName);
    }

    @TestMetadata("GlobalPropertyAccessors.kt")
    public void testGlobalPropertyAccessors() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/GlobalPropertyAccessors.kt");
        doTest(fileName);
    }

    @TestMetadata("InArgumentList.kt")
    public void testInArgumentList() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InArgumentList.kt");
        doTest(fileName);
    }

    @TestMetadata("InBlockComment.kt")
    public void testInBlockComment() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InBlockComment.kt");
        doTest(fileName);
    }

    @TestMetadata("InChar.kt")
    public void testInChar() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InChar.kt");
        doTest(fileName);
    }

    @TestMetadata("InClassBeforeFun.kt")
    public void testInClassBeforeFun() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InClassBeforeFun.kt");
        doTest(fileName);
    }

    @TestMetadata("InClassNoCompletionInValName.kt")
    public void testInClassNoCompletionInValName() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InClassNoCompletionInValName.kt");
        doTest(fileName);
    }

    @TestMetadata("InClassProperty.kt")
    public void testInClassProperty() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InClassProperty.kt");
        doTest(fileName);
    }

    @TestMetadata("InClassScope.kt")
    public void testInClassScope() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InClassScope.kt");
        doTest(fileName);
    }

    @TestMetadata("InClassTypeParameters.kt")
    public void testInClassTypeParameters() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InClassTypeParameters.kt");
        doTest(fileName);
    }

    @TestMetadata("InCodeBlock.kt")
    public void testInCodeBlock() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InCodeBlock.kt");
        doTest(fileName);
    }

    @TestMetadata("InFunctionExpressionBody.kt")
    public void testInFunctionExpressionBody() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InFunctionExpressionBody.kt");
        doTest(fileName);
    }

    @TestMetadata("InFunctionName.kt")
    public void testInFunctionName() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InFunctionName.kt");
        doTest(fileName);
    }

    @TestMetadata("InFunctionRecieverType.kt")
    public void testInFunctionRecieverType() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InFunctionRecieverType.kt");
        doTest(fileName);
    }

    @TestMetadata("InFunctionTypePosition.kt")
    public void testInFunctionTypePosition() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InFunctionTypePosition.kt");
        doTest(fileName);
    }

    @TestMetadata("InGetterExpressionBody.kt")
    public void testInGetterExpressionBody() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InGetterExpressionBody.kt");
        doTest(fileName);
    }

    @TestMetadata("InMemberFunParametersList.kt")
    public void testInMemberFunParametersList() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InMemberFunParametersList.kt");
        doTest(fileName);
    }

    @TestMetadata("InModifierListInsideClass.kt")
    public void testInModifierListInsideClass() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InModifierListInsideClass.kt");
        doTest(fileName);
    }

    @TestMetadata("InNotFinishedGenericWithFunAfter.kt")
    public void testInNotFinishedGenericWithFunAfter() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InNotFinishedGenericWithFunAfter.kt");
        doTest(fileName);
    }

    @TestMetadata("InParameterDefaultValue.kt")
    public void testInParameterDefaultValue() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InParameterDefaultValue.kt");
        doTest(fileName);
    }

    @TestMetadata("InPropertyInitializer.kt")
    public void testInPropertyInitializer() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InPropertyInitializer.kt");
        doTest(fileName);
    }

    @TestMetadata("InPropertyTypeReference.kt")
    public void testInPropertyTypeReference() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InPropertyTypeReference.kt");
        doTest(fileName);
    }

    @TestMetadata("InString.kt")
    public void testInString() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InString.kt");
        doTest(fileName);
    }

    @TestMetadata("InTopFunParametersList.kt")
    public void testInTopFunParametersList() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InTopFunParametersList.kt");
        doTest(fileName);
    }

    @TestMetadata("InTopScopeAfterPackage.kt")
    public void testInTopScopeAfterPackage() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/InTopScopeAfterPackage.kt");
        doTest(fileName);
    }

    @TestMetadata("LabeledLambdaThis.kt")
    public void testLabeledLambdaThis() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/LabeledLambdaThis.kt");
        doTest(fileName);
    }

    @TestMetadata("LineComment.kt")
    public void testLineComment() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/LineComment.kt");
        doTest(fileName);
    }

    @TestMetadata("NoBreak1.kt")
    public void testNoBreak1() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/NoBreak1.kt");
        doTest(fileName);
    }

    @TestMetadata("NoBreak2.kt")
    public void testNoBreak2() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/NoBreak2.kt");
        doTest(fileName);
    }

    @TestMetadata("NoCompletionForCapitalPrefix.kt")
    public void testNoCompletionForCapitalPrefix() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/NoCompletionForCapitalPrefix.kt");
        doTest(fileName);
    }

    @TestMetadata("NoContinue.kt")
    public void testNoContinue() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/NoContinue.kt");
        doTest(fileName);
    }

    @TestMetadata("NoFinalInParameterList.kt")
    public void testNoFinalInParameterList() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/NoFinalInParameterList.kt");
        doTest(fileName);
    }

    @TestMetadata("NotInNotIs.kt")
    public void testNotInNotIs() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/NotInNotIs.kt");
        doTest(fileName);
    }

    @TestMetadata("PrefixMatcher.kt")
    public void testPrefixMatcher() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/PrefixMatcher.kt");
        doTest(fileName);
    }

    @TestMetadata("PropertyAccessors.kt")
    public void testPropertyAccessors() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/PropertyAccessors.kt");
        doTest(fileName);
    }

    @TestMetadata("PropertyAccessors2.kt")
    public void testPropertyAccessors2() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/PropertyAccessors2.kt");
        doTest(fileName);
    }

    @TestMetadata("PropertySetter.kt")
    public void testPropertySetter() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/PropertySetter.kt");
        doTest(fileName);
    }

    @TestMetadata("QualifiedThis.kt")
    public void testQualifiedThis() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/QualifiedThis.kt");
        doTest(fileName);
    }

    @TestMetadata("QualifiedThisInAccessor.kt")
    public void testQualifiedThisInAccessor() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/QualifiedThisInAccessor.kt");
        doTest(fileName);
    }

    @TestMetadata("Return1.kt")
    public void testReturn1() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/Return1.kt");
        doTest(fileName);
    }

    @TestMetadata("Return2.kt")
    public void testReturn2() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/Return2.kt");
        doTest(fileName);
    }

    @TestMetadata("Return3.kt")
    public void testReturn3() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/Return3.kt");
        doTest(fileName);
    }

    @TestMetadata("Return4.kt")
    public void testReturn4() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/Return4.kt");
        doTest(fileName);
    }

    @TestMetadata("Return5.kt")
    public void testReturn5() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/Return5.kt");
        doTest(fileName);
    }

    @TestMetadata("Return6.kt")
    public void testReturn6() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/Return6.kt");
        doTest(fileName);
    }

    @TestMetadata("Return7.kt")
    public void testReturn7() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/Return7.kt");
        doTest(fileName);
    }

    @TestMetadata("Return8.kt")
    public void testReturn8() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/Return8.kt");
        doTest(fileName);
    }

    @TestMetadata("Return9.kt")
    public void testReturn9() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/Return9.kt");
        doTest(fileName);
    }

    @TestMetadata("This.kt")
    public void testThis() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/This.kt");
        doTest(fileName);
    }

    @TestMetadata("ThisPrefixMatching.kt")
    public void testThisPrefixMatching() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/ThisPrefixMatching.kt");
        doTest(fileName);
    }

    @TestMetadata("TopScope.kt")
    public void testTopScope() throws Exception {
        String fileName = JetTestUtils.navigationMetadata("idea/idea-completion/testData/keywords/TopScope.kt");
        doTest(fileName);
    }
}
