/**
 * ============================================================================
 * Test Case ID  : 259912
 * Title         : Check for Data Validation Reports — Sanctions Check Directors Unresolved
 * Path          : Test Cases/Dashboards/259912_CheckDataValidationReportsSanctionsCheckDirectorsUnresolved
 * ============================================================================
 *
 * DESCRIPTION:
 *   Validates the Dashboard Data Validation Reports section for "Sanctions
 *   Check Directors Unresolved". Creates a submission that triggers a sanction
 *   check error message on Continue. Discards the error, navigates to
 *   Dashboard, verifies the section layout, clicks "Sanctions Check Directors
 *   Unresolved", verifies the sanction field names in the table, filters by
 *   caseID, selects the case, resolves the sanction via "Underwriter Action"
 *   dropdown, and then navigates through CollectSubmissionDetails to verify
 *   the UW Worksheet stage is visible.
 *
 * HIGH-LEVEL STEPS (from TestPack — 40 steps):
 *   1.    Login as LNARDOCCI
 *   2-6.  Create insured → select reinsured → continue → enter broker details
 *   7-10. General Data → verify submission received date, policy period
 *   11-12. Continue → sanction error message appears → verify message
 *   13-14. Close error → Discard → navigate to Dashboard
 *   15-17. Click "Sanctions Check Directors Unresolved" → verify sanction fields
 *   18-20. Filter by caseID, select case, set Underwriter Action (declined),
 *          enter comment, submit
 *   21-22. Verify success message
 *   23-26. Click case ID link → CollectSubmissionDetails → Continue
 *          → verify policy reference → verify UW Worksheet stage visible
 *
 * PRECONDITIONS:
 *   - Valid test data in 'Dashboards' data file for test case 259912
 *   - Application URL and credentials configured in GlobalVariable
 *
 * ============================================================================
 */

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat as SimpleDateFormat
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement

import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper as SubmissionHelper

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

// ── Setup ──────────────────────────────────────────────────────────────────────
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testDataName, GlobalVariable.testCaseID)

KeywordUtil.logInfo('Test Case ID: ' + GlobalVariable.testCaseID)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('LNARDOCCI', GlobalVariable.Lnardocci, findTestData(testDataName).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

// ── Steps 2-6: Create Submission ───────────────────────────────────────────────
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Yes', [('reinsuredYes') : 'No']))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

SubmissionHelper.enterInsuredDetails(testDataName, rowNumber)

SubmissionHelper.selectReinsured(testDataName, rowNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// Broker details (manual entry — not using helper for this script)
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'),
    GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testDataName).getValue(
        'CountryName', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']),
    findTestData(testDataName).getValue('Broker', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : brokerValue]), GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : brokerValue]))

WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : brokerValue]))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'),
    findTestData(testDataName).getValue('Broker Contact', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// ── Steps 7-10: General Data ───────────────────────────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'),
    GlobalVariable.timeOutValue)

SubmissionHelper.enterGeneralData(testDataName, rowNumber)

String caseID = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_CaseID'))

String currentDate = new SimpleDateFormat('dd/MM/yyyy').format(Calendar.getInstance().time)

String submissionReceivedDate = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Submission Received Date']),
    'data-value')

GenericUtils.verifyMatch('Submission Received Date Value is', submissionReceivedDate, currentDate, 'EQUAL')

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Quote Due Date'])).isEmpty()) {
    KeywordUtil.logInfo('Quote Date is empty')
}

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
        [('labelName') : 'Notes']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
        [('labelName') : 'Is Master']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
        [('labelName') : 'Is Local']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
        [('labelName') : 'Is Tied In']), GlobalVariable.timeoutShort)

String policyPeriod = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
        [('labelName') : 'Policy Period ']), 'value')

GenericUtils.verifyMatch('Policy Period Value is', policyPeriod, findTestData(testDataName).getValue('PolicyPeriod', rowNumber),
    'EQUAL')

// ── Steps 11-12: Continue → Sanction Error ─────────────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'),
    GlobalVariable.timeOutValue)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 10)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_SanctionErrorMessage'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

String sanctionMessage = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_SanctionErrorMessage'))

KeywordUtil.logInfo('Sanction Message Displayed is ::' + sanctionMessage)

WebUI.verifyElementVisible(findTestObject('Object Repository/Dashboards/webElement_SanctionErrorMessage'))

// ── Steps 13-14: Close Error → Discard → Dashboard ─────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Close'), GlobalVariable.timeOutValue)
WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/button_Close'), 10)

WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Discard'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Discard'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/hoverSidebar'), GlobalVariable.timeoutShort)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
        [('optionToSelect') : 'Dashboard']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Dashboard']))

// ── Steps 15-17: Click "Sanctions Check Directors Unresolved" → verify fields ───
WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect') : 'Sanctions Check Directors Unresolved']),
    GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect') : 'Sanctions Check Directors Unresolved']))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/button_ExportToExcel'), GlobalVariable.timeOutValue)

WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

// Verify sanction field names
List<WebElement> sanctionsFieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfSanctionFields'),
    GlobalVariable.timeOutValue)

List<WebElement> sanctionFieldList = new ArrayList<String>()

for (int i = 2; i < 8; i++) {
    String value = sanctionsFieldNames.get(i).getText().trim()
    if (!(value.equals(''))) {
        sanctionFieldList.add(value)
    }
}

KeywordUtil.logInfo('Sanction field list: ' + sanctionFieldList)

GenericUtils.compareLists(sanctionFieldList, expectedSanctionList)

WebUI.switchToDefaultContent()

// ── Steps 18-22: Filter → select → Underwriter Action → submit ─────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_Filter'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_Filter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'Search Text']),
    caseID)

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Apply'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Apply'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_SelectQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_SelectQuote'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Underwriter Action ']),
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Underwriter Action ']))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Underwriter Action ']),
    GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Underwriter Action ']),
    findTestData(testDataName).getValue('DeclinedReason', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/text_CommentsSection', [('commentField') : 'Comments']),
    GlobalVariable.timeOutValue)
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/text_CommentsSection', [('commentField') : 'Comments']), 'test test test')

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/text_CommentsSection', [('commentField') : 'Comments']), Keys.chord(
        Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/button_Submit'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/button_Submit'))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_SuccessMessageDeclinedReason'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

String successMessage = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SuccessMessageDeclinedReason'))

GenericUtils.verifyMatch('Success Message Displayed is ', successMessage, 'Your action has been completed.', 'EQUAL')

// ── Steps 23-26: CollectSubmissionDetails → Policy Reference → UW Worksheet ────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_CaseIDLink'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_CaseIDLink'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_CaseContentOptions', [('linkToClick') : 'CollectSubmissionDetails']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_CaseContentOptions', [('linkToClick') : 'CollectSubmissionDetails']))

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_sPolicyReference'), 180)

String policyRef = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_sPolicyReference'))

KeywordUtil.logInfo('Policy Reference: ' + policyRef)

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/button_OK'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Endorsements/button_OK'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/link_UWWorkSheetStage'),
    GlobalVariable.timeOutValue, FailureHandling.OPTIONAL)

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Dashboards/link_UWWorkSheetStage'), FailureHandling.OPTIONAL)) {
    KeywordUtil.markPassed('UW Worksheet Stage is visible')
} else {
    KeywordUtil.markFailedAndStop('UW Worksheet Stage is NOT visible')
}