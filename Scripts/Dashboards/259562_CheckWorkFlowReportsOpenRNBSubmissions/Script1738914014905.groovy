/**
 * ============================================================================
 * Test Case ID  : 259562
 * Title         : Check for Work Flow Reports — Open RNB Submissions
 * Path          : Test Cases/Dashboards/259562_CheckWorkFlowReportsOpenRNBSubmissions
 * ============================================================================
 *
 * DESCRIPTION:
 *   Validates the Dashboard Workflow Reports section for "Open RNB Submissions".
 *   Creates two RNB (Renewal) submissions via the CreateSubmissionUsingKeyword
 *   and RenewalAgent test cases. Navigates to Dashboard, verifies all section
 *   layouts (Search Filter, Data Validation, Renewal), clicks "Open RNB
 *   Submissions", then:
 *     (a) Filters by GlobalVariable.insuredName, closes that submission with
 *         Declined Reason → verifies success message → confirms it no longer
 *         appears.
 *     (b) Bulk-selects insuredName1 and insuredName2 and closes both →
 *         verifies success message.
 *
 * HIGH-LEVEL STEPS (from TestPack — 62 steps):
 *   1.    Login as LNARDOCCI
 *   2-3.  Create first open submission via keyword, run RenewalAgent
 *   4.    Navigate to Dashboard → verify sections → click "Open RNB Submissions"
 *   5-14. Filter by insuredName, close single submission (Declined),
 *         verify success message, confirm not in list
 *   15.   Login again, create second and third submissions + RenewalAgent
 *   16-25. Navigate to Dashboard → Open RNB Submissions
 *         Filter bulk select insuredName1 & 2, close, verify
 *
 * PRECONDITIONS:
 *   - Valid test data in 'CreateSubmission' data file for test case 259562
 *   - Valid credentials data in 'Credentials' data file
 *   - Application URL and credentials configured in GlobalVariable
 *
 * ============================================================================
 */

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

// ── Setup ──────────────────────────────────────────────────────────────────────
String testData = 'CreateSubmission'

int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

String testData1 = 'Credentials'

int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

// ── Steps 2-3: Create first submission + RenewalAgent ──────────────────────────
WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('LNARDOCCI', GlobalVariable.Lnardocci, findTestData(testData1).getValue('Role', rowNumber1))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), 25)

GlobalVariable.PolicyRef = WebUI.callTestCase(findTestCase('Test Cases/TestData/CreateSubmissionUsingKeyword'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

WebUI.openBrowser(null)

WebUI.maximizeWindow()

String renewedPolicy = WebUI.callTestCase(findTestCase('Test Cases/TestData/RenewalAgent'), [('testData') : testData, ('rowNumber') : rowNumber],
    FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser(null)

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('LNARDOCCI', GlobalVariable.Lnardocci, findTestData(testData1).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), 25)

// ── Step 4: Navigate to Dashboard ──────────────────────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/hoverSidebar'), GlobalVariable.timeOutValue)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
        [('optionToSelect') : 'Dashboard']), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Dashboard']))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue)

WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

// Verify Search Filter field names
List<WebElement> fieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFields'),
    GlobalVariable.timeOutValue)

List<WebElement> fieldList = new ArrayList<String>()

for (WebElement f : fieldNames) {
    fieldList.add(f.getText())
}

GenericUtils.compareLists(fieldList, expectedList)

// Verify Data Validation field names
List<WebElement> dataValidationFieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFieldsUnderDataValidation'),
    GlobalVariable.timeOutValue)

List<WebElement> dataValidationFieldList = new ArrayList<String>()

for (WebElement f : dataValidationFieldNames) {
    dataValidationFieldList.add(f.getText())
}

GenericUtils.compareLists(dataValidationFieldList, expectedDataValidationList)

// Verify Renewal field names
List<WebElement> renewalFieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFieldsRenewal'),
    GlobalVariable.timeOutValue)

List<WebElement> renewalFieldList = new ArrayList<String>()

for (WebElement j : renewalFieldNames) {
    renewalFieldList.add(j.getText())
}

GenericUtils.compareLists(renewalFieldList, expectedWorkFlowList)

WebUI.switchToDefaultContent()

// ── Steps 5-14: Click "Open RNB Submissions" → close single ─────────────────────
WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect') : 'Open RNB Submissions']),
    GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect') : 'Open RNB Submissions']))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/button_ExportToExcel'), GlobalVariable.timeOutValue)

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_InsuredNameFilter'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_InsuredNameFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'Search Text']),
    GlobalVariable.insuredName)

WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/button_Apply'), 20)

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Apply'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Apply'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_SelectInsuredName', [('insuredName') : GlobalVariable.insuredName]),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_SelectInsuredName', [('insuredName') : GlobalVariable.insuredName]))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_CloseSubmission'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Dashboards/button_CloseSubmission'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Declined Reason']),
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Declined Reason']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Declined Reason']),
    findTestData(testData).getValue('DeclinedReason', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Declined Reason']),
    'Test Comments')

WebUI.sendKeys(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Declined Reason']),
    Keys.chord(Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Submit'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Dashboards/button_Submit'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_SucessMessage'), GlobalVariable.timeOutValue)

String actualMessage = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_SucessMessage'))

GenericUtils.verifyMatch('Success Message displayed is ', actualMessage, findTestData(testData).getValue('expectedMessage',
        rowNumber), 'EQUAL')

// Verify submission no longer in list
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_InsuredNameFilter'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_InsuredNameFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'Search Text']),
    GlobalVariable.insuredName)

WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/button_Apply'), 10)

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Apply'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Apply'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_NoItemsMessage'), GlobalVariable.timeoutShort)

String actualNoItemsMessage = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_NoItemsMessage'))

GenericUtils.verifyMatch('No items Message displayed is ', actualNoItemsMessage, findTestData(testData).getValue('expectedNoItemsMessage',
        rowNumber), 'EQUAL')

// ── Step 15: Create two more submissions + RenewalAgent ─────────────────────────
WebUI.closeBrowser()

WebUI.openBrowser(null)

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('LNARDOCCI', GlobalVariable.Lnardocci, findTestData(testData1).getValue('Role', rowNumber))

String policyRef1 = WebUI.callTestCase(findTestCase('Test Cases/TestData/CreateSubmissionUsingKeyword'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.PolicyRef = policyRef1
String insuredName1 = GlobalVariable.insuredName

WebUI.closeBrowser()

WebUI.openBrowser(null)

WebUI.maximizeWindow()

String renewedPolicy1 = WebUI.callTestCase(findTestCase('Test Cases/TestData/RenewalAgent'), [('testData') : testData, ('rowNumber') : rowNumber],
    FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser(null)

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('LNARDOCCI', GlobalVariable.Lnardocci, findTestData(testData1).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

String policyRef2 = WebUI.callTestCase(findTestCase('Test Cases/TestData/CreateSubmissionUsingKeyword'), [:], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.PolicyRef = policyRef2
String insuredName2 = GlobalVariable.insuredName

WebUI.closeBrowser()

WebUI.openBrowser(null)

WebUI.maximizeWindow()

String renewedPolicy2 = WebUI.callTestCase(findTestCase('Test Cases/TestData/RenewalAgent'), [('testData') : testData, ('rowNumber') : rowNumber],
    FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser(null)

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('LNARDOCCI', GlobalVariable.Lnardocci, findTestData(testData1).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

// ── Steps 16-25: Navigate → Dashboard → Open RNB → Bulk close insuredName1 & 2 ─
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/hoverSidebar'), GlobalVariable.timeoutShort)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
        [('optionToSelect') : 'Dashboard']), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Dashboard']))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect') : 'Open RNB Submissions']),
	GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect') : 'Open RNB Submissions']))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/button_ExportToExcel'), GlobalVariable.timeOutValue)

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_InsuredNameFilter'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_InsuredNameFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_SelectDynamicInsuredName', [('insuredName') : insuredName1]),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/webElement_SelectDynamicInsuredName', [('insuredName') : insuredName1]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_SelectDynamicInsuredName', [('insuredName') : insuredName1]))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_SelectDynamicInsuredName', [('insuredName') : insuredName2]),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/webElement_SelectDynamicInsuredName', [('insuredName') : insuredName2]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_SelectDynamicInsuredName', [('insuredName') : insuredName2]))

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

WebUI.sendKeys(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Declined Reason']),
    'test test test')

WebUI.sendKeys(findTestObject('Object Repository/Dashboards/webElement_CommentSection', [('commentField') : 'Declined Reason']),
    Keys.chord(Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Submit'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Dashboards/button_Submit'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_SucessMessage'), GlobalVariable.timeOutValue)

String actualMessageBulk = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_SucessMessage'))

GenericUtils.verifyMatch('Success Message displayed is ', actualMessageBulk, findTestData(testData).getValue('expectedMessage',
        rowNumber), 'EQUAL')

// Verify insuredName1 and insuredName2 no longer in list
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_InsuredNameFilter'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_InsuredNameFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementNotPresent(findTestObject('Object Repository/Dashboards/webElement_SelectInsuredName', [('insuredName') : insuredName1]),
    GlobalVariable.timeoutShort)) {
    KeywordUtil.markPassed(insuredName1 + ' is not visible under the submissions to select')
} else {
    KeywordUtil.markFailed(insuredName1 + ' is still visible under the Submissions to select')
}

if (WebUI.verifyElementNotPresent(findTestObject('Object Repository/Dashboards/webElement_SelectInsuredName', [('insuredName') : insuredName2]),
    GlobalVariable.timeoutShort)) {
    KeywordUtil.markPassed(insuredName2 + ' is not visible under the submissions to select')
} else {
    KeywordUtil.markFailed(insuredName2 + ' is still visible under the Submissions to select')
}
