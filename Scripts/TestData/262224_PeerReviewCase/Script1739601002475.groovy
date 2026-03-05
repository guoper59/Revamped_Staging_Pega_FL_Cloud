/**
 * ============================================================================
 * Test Case ID : 262224
 * Title         : Peer Review Case
 * Folder        : Scripts/TestData/262224_PeerReviewCase
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

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

//Logging in with Underwriter Authority
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Hbakker', GlobalVariable.Hbakker, findTestData(testData).getValue('Role', rowNumber))

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Peer Review']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/checkBox_ViewAllPeerReviewCases'))
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter_1'), GlobalVariable.timeoutShort)


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter_1'))


WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_ClearFilter'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_SearchTextInFilter', [('fieldName') : 'Search Text']), 
    GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Apply'))


WebUI.check(findTestObject('Object Repository/NewBusiness/checkBox_SelectedResult'))
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Underwriter Reviewer']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Underwriter Reviewer']), 
    underWriterName, false)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_DynamicTextPeerReview', [('buttonName') : 'Assign for Peer Review']))


String peerReviewSuccessMessage = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PeerReviewSuccessMessage'))

GenericUtils.verifyMatch('Peer Review Assignee Message', peerReviewSuccessMessage, 'Selected tasks have been assigned successfully', 
    'EQUAL')


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))
WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))


//Logging in with Underwriter Assistant

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Abohle', GlobalVariable.Abohle, findTestData(testData).getValue('Role', rowNumber))

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

