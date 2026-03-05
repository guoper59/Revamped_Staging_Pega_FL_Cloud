/**
 * ============================================================================
 * Title        : SubTestCase01 260078
 * Title         : SubTestCase01 260078
 * Folder        : Scripts/NewBusiness/SubTestCase01_260078
 * ============================================================================
 *
 * DESCRIPTION:
 *   Automated Katalon Studio test case. Refer to TestPack_for_NotebookLM.md
 *   for full step-by-step documentation.
 *
 * PRECONDITIONS:
 *   - Valid test data configured in GlobalVariable
 *   - Application URL and credentials set in GlobalVariable
 *
 * ============================================================================
 */

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


//Logging in with Underwriter Assistant
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('abohle', GlobalVariable.Abohle, findTestData(testData).getValue(
		'Role', rowNumber))


WebUI.refresh()

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Peer Review']))


//Filtering the policy
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_PolicyReferenceFilter'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_PolicyReferenceFilter'))


WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_ClearFilterPeerReview'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_SearchTextPeerReview', [('fieldName') : 'Search Text']), 
    GlobalVariable.PolicyRef)


WebUI.click(findTestObject('Object Repository/NewBusiness/button_ApplyPeerReview'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_TaskID'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_TaskID'))


if (WebUI.verifyElementPresent(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'Peer Review Completed - Fully Agree With Rationale']), 
    GlobalVariable.timeOutValue)) {
    KeywordUtil.markPassed('Fully Agree with Rationale radio button is visible')
}

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'Peer Review Completed - Reserve on Rationale']), 
    GlobalVariable.timeOutValue)) {
    KeywordUtil.markPassed('Reserve on Rationale radio button is visible')
}


WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/text_CommentsSection', [('commentField') : 'Comments']), 'Test test test')


WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/input_FullyAgree'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/button_Submit'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Submit'))


String successMessageFinal = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_SuccessMessage'))


GenericUtils.verifyMatch('Success Message Displayed', successMessageFinal, 'Your action has been completed.', 'EQUAL')


