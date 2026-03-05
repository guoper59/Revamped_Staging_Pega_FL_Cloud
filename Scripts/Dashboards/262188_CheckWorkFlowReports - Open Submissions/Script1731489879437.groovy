/**
 * ============================================================================
 * Test Case ID  : 262188
 * Title         : Check for Work Flow Reports — Open Submissions
 * Path          : Test Cases/Dashboards/262188_CheckWorkFlowReports - Open Submissions
 * ============================================================================
 *
 * DESCRIPTION:
 *   Validates the Dashboard Workflow Reports section for "Open Submissions".
 *   Creates four open submissions using SROSS credentials via
 *   SubmissionHelper.createOpenSubmission. Navigates to Dashboard, assigns an
 *   Underwriter/Assistant/Producing Team via the search panel, then:
 *     (a) Filters by insuredName1, closes that single submission with
 *         Declined Reason → verifies success message → confirms not in list.
 *     (b) Bulk-selects insuredName2/3/4 and closes all three → verifies
 *         success message → confirms they no longer appear.
 *
 * HIGH-LEVEL STEPS (from TestPack — 31 steps):
 *   1.    Login as SROSS
 *   2-5.  Create four open submissions (insuredName1..4)
 *   6.    Navigate to Dashboard → Open Submissions
 *   7-8.  Set Underwriter, UW Assistant, Producing Team → Apply search filter
 *   9-15. Filter by insuredName1, close (Declined), verify success,
 *         re-filter, verify not in list
 *   16-24. Bulk select insuredName2/3/4, close, verify success
 *   25-31. Verify insuredName2/3/4 not in list
 *
 * PRECONDITIONS:
 *   - Valid test data in 'Dashboards' data file for test case 262188
 *   - Application URL and SROSS credentials configured in GlobalVariable
 *
 * ============================================================================
 */

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

// ── Setup ──────────────────────────────────────────────────────────────────────
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

KeywordUtil.logInfo('Test Case ID: ' + GlobalVariable.testCaseID)
KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

// ── Steps 2-5: Create four open submissions ────────────────────────────────────
String insuredName1 = SubmissionHelper.createOpenSubmission(testData, rowNumber)
KeywordUtil.logInfo('First Insured Name is: ' + insuredName1)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

String insuredName2 = SubmissionHelper.createOpenSubmission(testData, rowNumber)
KeywordUtil.logInfo('Second Insured Name is: ' + insuredName2)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

String insuredName3 = SubmissionHelper.createOpenSubmission(testData, rowNumber)
KeywordUtil.logInfo('Third Insured Name is: ' + insuredName3)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

String insuredName4 = SubmissionHelper.createOpenSubmission(testData, rowNumber)
KeywordUtil.logInfo('Fourth Insured Name is: ' + insuredName4)

// ── Step 6: Navigate to Dashboard ──────────────────────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/hoverSidebar'), GlobalVariable.timeoutShort)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
        [('optionToSelect') : 'Dashboard']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Dashboard']))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_UserName'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

// ── Steps 7-8: Set Underwriter / UW Assistant / Producing Team ─────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwriter0'),
	GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwriter0'),
	findTestData(testData).getValue('Underwriter', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant0'),
	GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant0'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant0'),
	findTestData(testData).getValue('Underwriting Assistant', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/select_DynamicDropDown0', [('dropDownLabel') : 'Producing Team']),
    GlobalVariable.timeoutShort)
WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown0', [('dropDownLabel') : 'Producing Team']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown0', [('dropDownLabel') : 'Producing Team']),
    findTestData(testData).getValue('Producing Team', rowNumber), false)

WebUI.scrollToElement(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/button_SubmissionSearch'), 5)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/button_SubmissionSearch'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/button_SubmissionSearch'))

// ── Click "Open Submissions" link ──────────────────────────────────────────────
WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect') : 'Open Submissions']),
    GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect') : 'Open Submissions']))

// ── Steps 9-15: Filter by insuredName1 → close single submission ───────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_InsuredNameFilter'), 25)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_InsuredNameFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'Search Text']),
    insuredName1)

WebUI.scrollToElement(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'Search Text']), 10)

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Apply'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Apply'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/checkbox_SelectInsuredName', [('insuredName') : insuredName1]),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Dashboards/checkbox_SelectInsuredName', [('insuredName') : insuredName1]))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_CloseSubmission'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_CloseSubmission'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Declined Reason']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Declined Reason']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Declined Reason']),
    findTestData(testData).getValue('DeclinedReason', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Declined Reason']),
    GlobalVariable.timeOutValue)
WebUI.sendKeys(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Declined Reason']),
    'test test test')
WebUI.sendKeys(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Declined Reason']),
    Keys.chord(Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Submit'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Submit'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_SucessMessage'), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboards/webElement_SucessMessage'), GlobalVariable.timeOutValue)

String actualMessage = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_SucessMessage'))
GenericUtils.verifyMatch('Success Message displayed is ', actualMessage, findTestData(testData).getValue('expectedMessage',
        rowNumber), 'EQUAL')

// Verify insuredName1 no longer in list
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_InsuredNameFilter'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_InsuredNameFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'Search Text']),
    insuredName1)

WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/button_Apply'), 10)
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Apply'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Apply'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_NoItemsMessage'), GlobalVariable.timeoutShort)

String actualNoItemsMessage = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_NoItemsMessage'))
GenericUtils.verifyMatch('No items Message displayed is ', actualNoItemsMessage, findTestData(testData).getValue('expectedNoItemsMessage',
        rowNumber), 'EQUAL')

// ── Steps 16-24: Bulk select insuredName2/3/4 → close ─────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_InsuredNameFilter'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_InsuredNameFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : insuredName2]), GlobalVariable.timeoutShort)
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : insuredName2]), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : insuredName2]))

WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : insuredName3]), GlobalVariable.timeoutShort)
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : insuredName3]), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : insuredName3]))

WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : insuredName4]), GlobalVariable.timeoutShort)
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : insuredName4]), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : insuredName4]))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Apply'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Apply'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/radioButton_SelectAllResults'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/radioButton_SelectAllResults'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_CloseSubmission'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_CloseSubmission'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Declined Reason']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Declined Reason']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Declined Reason']),
    findTestData(testData).getValue('DeclinedReason', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Declined Reason']),
    GlobalVariable.timeOutValue)
WebUI.sendKeys(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Declined Reason']),
    'test test test')
WebUI.sendKeys(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Declined Reason']),
    Keys.chord(Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Submit'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Submit'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_SucessMessage'), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/Dashboards/webElement_SucessMessage'), GlobalVariable.timeOutValue)

String actualMessageBulk = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_SucessMessage'))
GenericUtils.verifyMatch('Success Message displayed is ', actualMessageBulk, findTestData(testData).getValue('expectedMessage',
        rowNumber), 'EQUAL')

// ── Steps 25-31: Verify insuredName2/3/4 not in list ───────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_Filter'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_Filter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementNotPresent(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : insuredName2]),
    GlobalVariable.timeoutShort)) {
    KeywordUtil.markPassed(insuredName2 + ' is not visible under the submissions to select')
} else {
    KeywordUtil.markFailed(insuredName2 + ' is still visible under the Submissions to select')
}

if (WebUI.verifyElementNotPresent(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : insuredName3]),
    GlobalVariable.timeoutShort)) {
    KeywordUtil.markPassed(insuredName3 + ' is not visible under the submissions to select')
} else {
    KeywordUtil.markFailed(insuredName3 + ' is still visible under the Submissions to select')
}

if (WebUI.verifyElementNotPresent(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : insuredName4]),
    GlobalVariable.timeoutShort)) {
    KeywordUtil.markPassed(insuredName4 + ' is not visible under the submissions to select')
} else {
    KeywordUtil.markFailed(insuredName4 + ' is still visible under the Submissions to select')
}