/**
 * ============================================================================
 * Test Case ID  : 259561
 * Title         : Check for Work Flow Reports — Submissions in Quoted Status
 * Path          : Test Cases/Dashboards/259561_CheckWorkFlowReports - Qouted Status
 * ============================================================================
 *
 * DESCRIPTION:
 *   Validates the Dashboard Workflow Reports section for "Submissions in Quoted
 *   Status". Creates four submissions in Quoted status using LNARDOCCI
 *   credentials. Navigates to Dashboard, clicks "Submissions in Quoted Status",
 *   then:
 *     (a) Filters by caseID1, selects and closes that single submission with
 *         "Not Taken Up" reason → verifies success message → confirms it no
 *         longer appears.
 *     (b) Bulk-selects caseID2/3/4 and closes all three → verifies success
 *         message → confirms they no longer appear.
 *
 * HIGH-LEVEL STEPS (from TestPack — 40 steps):
 *   1.    Login as LNARDOCCI
 *   2-5.  Create four submissions in Quoted status
 *   6.    Navigate to Dashboard, click "Submissions in Quoted Status"
 *   7-15. Filter by caseID1, select, close (Not Taken Up), verify
 *         success message, verify caseID1 not in list
 *   16-27. Bulk select caseID2/3/4, close, verify success message
 *   28-40. Verify caseID2/3/4 not in list
 *
 * PRECONDITIONS:
 *   - Valid test data in 'Dashboards' data file for test case 259561
 *   - Application URL and credentials configured in GlobalVariable
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

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('LNARDOCCI', GlobalVariable.Lnardocci, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

// ── Steps 2-5: Create four submissions in Quoted status ────────────────────────
String caseID1 = SubmissionHelper.createSubmissionQuotedStatus(testData, rowNumber)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

String caseID2 = SubmissionHelper.createSubmissionQuotedStatus(testData, rowNumber)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

String caseID3 = SubmissionHelper.createSubmissionQuotedStatus(testData, rowNumber)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

String caseID4 = SubmissionHelper.createSubmissionQuotedStatus(testData, rowNumber)

// ── Step 6: Navigate to Dashboard ──────────────────────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/hoverSidebar'), GlobalVariable.timeoutShort)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
        [('optionToSelect') : 'Dashboard']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Dashboard']))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_UserName'), GlobalVariable.timeoutShort)
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect') : 'Submissions in Quoted Status']),
    GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect') : 'Submissions in Quoted Status']))

// ── Steps 7-15: Filter by caseID1, close single submission ─────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_Filter'), 25)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_Filter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'Search Text']),
    caseID1)

WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/button_Apply'), 20)

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Apply'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Apply'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/checkbox_SelectPolicyRef', [('policyRef') : caseID1]),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Dashboards/checkbox_SelectPolicyRef', [('policyRef') : caseID1]))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_CloseSubmission'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Dashboards/button_CloseSubmission'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Not Taken Up Reason']),
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Not Taken Up Reason']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Not Taken Up Reason']),
    findTestData(testData).getValue('DeclinedReason', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Not Taken Up Description']),
    'test test test')

WebUI.sendKeys(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Not Taken Up Description']),
    Keys.chord(Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Submit'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Dashboards/button_Submit'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_SucessMessage'), GlobalVariable.timeOutValue)

String actualMessage = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_SucessMessage'))

GenericUtils.verifyMatch('Success Message displayed is ', actualMessage, findTestData(testData).getValue('expectedMessage',
        rowNumber), 'EQUAL')

// Verify caseID1 no longer in list
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_Filter'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_Filter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'Search Text']),
    caseID1)

WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/button_Apply'), 5)

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Apply'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Apply'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_NoItemsMessage'), GlobalVariable.timeoutShort)

String actualNoItemsMessage = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_NoItemsMessage'))

GenericUtils.verifyMatch('No items Message displayed is ', actualNoItemsMessage, findTestData(testData).getValue('expectedNoItemsMessage',
        rowNumber), 'EQUAL')

// ── Steps 16-27: Bulk select caseID2/3/4 → close all ──────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_Filter'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_Filter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : caseID2]),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : caseID2]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : caseID2]))

WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : caseID3]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : caseID3]))

WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : caseID4]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : caseID4]))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Apply'), GlobalVariable.timeoutShort)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Apply'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/radioButton_SelectAllResults'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/radioButton_SelectAllResults'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_CloseSubmission'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Dashboards/button_CloseSubmission'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Not Taken Up Reason']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Not Taken Up Reason']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Not Taken Up Reason']),
	findTestData(testData).getValue('DeclinedReason', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Not Taken Up Description']))

WebUI.sendKeys(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Not Taken Up Description']),
	'test test test')

WebUI.sendKeys(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Not Taken Up Description']),
	Keys.chord(Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Submit'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Dashboards/button_Submit'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_SucessMessage'), GlobalVariable.timeOutValue)

String actualMessageBulk = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_SucessMessage'))

GenericUtils.verifyMatch('Success Message displayed is ', actualMessageBulk, findTestData(testData).getValue('expectedMessage',
		rowNumber), 'EQUAL')

// ── Steps 28-40: Verify caseID2/3/4 no longer in list ──────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_Filter'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_Filter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementNotPresent(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : caseID2]), GlobalVariable.timeoutShort)) {
	KeywordUtil.markPassed(caseID2 + ' is not visible under the submissions to select')
} else {
	KeywordUtil.markFailed(caseID2 + ' is still visible under the Submissions to select')
}

if (WebUI.verifyElementNotPresent(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : caseID3]), GlobalVariable.timeoutShort)) {
	KeywordUtil.markPassed(caseID3 + ' is not visible under the submissions to select')
} else {
	KeywordUtil.markFailed(caseID3 + ' is still visible under the Submissions to select')
}

if (WebUI.verifyElementNotPresent(findTestObject('Object Repository/Dashboards/webElement_SelectCaseID', [('caseID') : caseID4]), GlobalVariable.timeoutShort)) {
	KeywordUtil.markPassed(caseID4 + ' is not visible under the submissions to select')
} else {
	KeywordUtil.markFailed(caseID4 + ' is still visible under the Submissions to select')
}
