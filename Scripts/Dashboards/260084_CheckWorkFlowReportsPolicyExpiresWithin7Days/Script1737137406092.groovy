/**
 * ============================================================================
 * Test Case ID  : 260084
 * Title         : Check for Work Flow Reports — Policy Expires within 7 Days
 * Path          : Test Cases/Dashboards/260084_CheckWorkFlowReportsPolicyExpiresWithin7Days
 * ============================================================================
 *
 * DESCRIPTION:
 *   Validates the Dashboard Workflow Reports section for "Policy Expires within
 *   7 days". Creates a submission with an inception date calculated so that
 *   the policy expiry falls within 7 days of today (today - 366 + 7 days).
 *   Binds and finalises the policy to "Signed" status, then navigates to
 *   Dashboard, verifies all section layouts, clicks "Policy Expires within 7
 *   days", verifies table headers, filters by policy reference, and verifies
 *   the policy opens in the Overview Tab.
 *
 * HIGH-LEVEL STEPS (from TestPack — 48 steps):
 *   1.    Login with dnouser credentials
 *   2-6.  Create insured, select reinsured, enter broker, general data
 *   7-11. Calculate inception date (today - 366 + 7), set on form,
 *         verify checkboxes, policy period, bureau indicator
 *   12.   Continue → Policy Reference → OK
 *   13-14. UW Worksheet → Complete Quote → status: Quoted
 *   15-16. Take Up Quote → status: Open Bound
 *   17-22. Bind details (tacit renewal = today - 15, crypto, taxes,
 *          instalments, UWQC)
 *   23-25. Bind Policy → Finalise → Proceed → status: Signed
 *   26.   Navigate to Dashboard → verify sections
 *   27.   Click "Policy Expires within 7 days" → verify headers
 *   28-29. Filter by policy reference, select → verify Overview Tab
 *
 * PRECONDITIONS:
 *   - Valid test data in 'Dashboards' data file for test case 260084
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

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('dnouser', GlobalVariable.Dnouser, findTestData(testDataName).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

// ── Steps 2-6: Create Submission ───────────────────────────────────────────────
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_UserName'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

SubmissionHelper.enterInsuredDetails(testDataName, rowNumber)
SubmissionHelper.selectReinsured(testDataName, rowNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'),
    GlobalVariable.timeOutValue)

SubmissionHelper.enterBrokerDetails(testDataName, rowNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'),
    GlobalVariable.timeOutValue)
SubmissionHelper.enterGeneralData(testDataName, rowNumber)

// ── Steps 7-11: Inception date = today - 366 + 7 (expires in 7 days) ───────────
Date today = new Date()
KeywordUtil.logInfo('Today\'s Date: ' + new SimpleDateFormat('dd/MM/yyyy').format(today))

Calendar calendar = Calendar.getInstance()
calendar.time = today
calendar.add(Calendar.DAY_OF_YEAR, -366)
KeywordUtil.logInfo('After Subtracting 366 Days: ' + new SimpleDateFormat('dd/MM/yyyy').format(calendar.time))

calendar.add(Calendar.DAY_OF_YEAR, 7)
KeywordUtil.logInfo('After Adding 7 Days: ' + new SimpleDateFormat('dd/MM/yyyy').format(calendar.time))

Date inceptionDate = calendar.time
String formattedDate = new SimpleDateFormat('dd/MM/yyyy').format(inceptionDate)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'))
WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'), formattedDate)
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'), Keys.chord(Keys.TAB))

WebUI.waitForElementPresent(findTestObject('Object Repository/NewBusiness/webElement_SkipQouteIndicator'), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_SkipQouteIndicator'), GlobalVariable.timeOutValue)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
        [('labelName') : 'Notes']), GlobalVariable.timeoutShort)
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
        [('labelName') : 'Is Local']), GlobalVariable.timeoutShort)
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
        [('labelName') : 'Is Tied In']), GlobalVariable.timeoutShort)
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
        [('labelName') : 'Is Master']), GlobalVariable.timeoutShort)

String bureauIndicator = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_BureauIndicator'), 'alt')
GenericUtils.verifyMatch('Bureau Indicator is NOT ticked ', bureauIndicator, expectedBureauIndicator, 'EQUAL')

// ── Step 12: Continue → Policy Reference ───────────────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 60)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'),
    60, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)
String policyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))
KeywordUtil.logInfo('Policy Reference: ' + policyRef)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'), 60)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))

// ── Steps 13-14: UW Worksheet → Complete Quote ─────────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 60)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NewBusiness/webElement_CreateMultipleTitle'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_CreateMultiQuote'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_DynamicText', [('buttonName') : 'Collapse all']), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_DynamicText', [('buttonName') : 'Expand all']), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_OpenQuote'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

SubmissionHelper.enterDetailsUWSheet(testDataName, rowNumber)

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
        [('labelName') : 'Order %']), GlobalVariable.timeOutValue)

String orderValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
        [('labelName') : 'Order %']), 'value')
GenericUtils.verifyMatch('Order Value is', orderValue, findTestData(testDataName).getValue('Order%', rowNumber), 'EQUAL')

String estimatedSigningValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
        [('labelName') : 'Estimated Signing %']), 'value')
GenericUtils.verifyMatch('Estimated Signing Value is', estimatedSigningValue, findTestData(testDataName).getValue('Estimated Signing %', rowNumber), 'EQUAL')

String calculatedLineValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
        [('labelName') : 'Calculated Line %']), 'value')
GenericUtils.verifyMatch('Calculated line Value is', calculatedLineValue, findTestData(testDataName).getValue('Calculated Line %', rowNumber), 'EQUAL')

GenericUtils.verifyMatch('TMHCC Agg Limit Value is',
    WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadLimitInformation', [('headerName') : 'TMHCC AGG Limit'])),
    findTestData(testDataName).getValue('TMHCC AGG Limit', rowNumber), 'EQUAL')
GenericUtils.verifyMatch('Layer Commission Value is',
    WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', [('headerName') : 'Layer Broker Commission Amount'])),
    findTestData(testDataName).getValue('LayerBrokerCommissionAmount', rowNumber), 'EQUAL')
GenericUtils.verifyMatch('TMHCC Broker Commission Value is',
    WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', [('headerName') : 'TMHCC Broker Commission Amount'])),
    findTestData(testDataName).getValue('TMHCCBrokerCommissionAmount', rowNumber), 'EQUAL')
GenericUtils.verifyMatch('TMHCC Gross Premium Value is',
    WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', [('headerName') : 'TMHCC Gross Premium'])),
    findTestData(testDataName).getValue('TMHCCGrossPremium', rowNumber), 'EQUAL')
GenericUtils.verifyMatch('TMHCC Net Premium Value is',
    WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', [('headerName') : 'TMHCC Net Premium'])),
    findTestData(testDataName).getValue('TMHCCNetPremium', rowNumber), 'EQUAL')

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Applicable Jurisdiction'])).isEmpty()) {
    KeywordUtil.logInfo('Applicable Jurisdiction is empty')
}
if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Retroactivity Date'])).isEmpty()) {
    KeywordUtil.logInfo('Retroactivity Date is empty')
}
if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Continuity Date'])).isEmpty()) {
    KeywordUtil.logInfo('Continuity Date is empty')
}
if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Contract Start Date'])).isEmpty()) {
    KeywordUtil.logInfo('Contract Start Date is empty')
}

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', [('labelName') : 'Notes']), GlobalVariable.timeoutShort)
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', [('labelName') : 'Additional Insureds']), GlobalVariable.timeoutShort)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CompleteQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CompleteQuote'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
String quotedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))
GenericUtils.verifyMatch('Status Value is', quotedStatus, expectedQuotedStatus, 'EQUAL')

// ── Steps 15-16: Take Up Quote ─────────────────────────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'), 25)
WebUI.click(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
String openBoundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))
GenericUtils.verifyMatch('Status Value is', openBoundStatus, expectedOpenBoundStatus, 'EQUAL')

// ── Steps 17-22: Bind Details ──────────────────────────────────────────────────
SubmissionHelper.enterDetailsUW(testDataName, rowNumber)

// Tacit Renewal Date: today - 15 (expired)
Date current = new Date()
Calendar tacitCalendar = Calendar.getInstance()
tacitCalendar.time = current
tacitCalendar.add(Calendar.DAY_OF_YEAR, -15)
String tacitFormattedDate = new SimpleDateFormat('dd/MM/yyyy').format(tacitCalendar.time)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TacItRenewalDate'), tacitFormattedDate)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'), 25)
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'), GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'),
	findTestData(testDataName).getValue('CryptoExposure', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

// Post Bind: Taxes
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 25)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
    findTestData(testDataName).getValue('Tax Applicable', rowNumber), false)

// Instalment Due Date: today - 275 days
Calendar InstallmentDueDate = Calendar.getInstance()
InstallmentDueDate.time = new Date()
InstallmentDueDate.add(Calendar.DAY_OF_YEAR, -275)
String InstallmentFormattedDate = new SimpleDateFormat('dd/MM/yyyy').format(InstallmentDueDate.time)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), GlobalVariable.timeOutValue)
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), InstallmentFormattedDate)
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Pega_CreateInsured/webElement_tblValue', [('tableName') : 'Instalment']), GlobalVariable.timeOutValue)

List<WebElement> actualInstalment = WebUI.findWebElements(findTestObject('Object Repository/Pega_CreateInsured/webElement_tblValue',
        [('tableName') : 'Instalment']), GlobalVariable.timeoutShort)

List<WebElement> actualInstalmentValues = new ArrayList<String>()

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget1Ifr'), GlobalVariable.timeoutShort)

for (int i = 0; i < actualInstalment.size(); i++) {
    String value = actualInstalment.get(i).getText().trim()
    if (!(value.equals(''))) { actualInstalmentValues.add(value) }
}

WebUI.switchToDefaultContent()
KeywordUtil.logInfo('Instalment values: ' + actualInstalmentValues)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_UWQCStatus'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
String uwQCStatus = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_UWQCStatus'))
GenericUtils.verifyMatch('UW QC Status is', uwQCStatus, expecteduwQCStatus, 'EQUAL')

// ── Steps 23-25: Bind Policy → Finalise → Signed ───────────────────────────────
WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']),
    10, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Finalise'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Finalise'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
String signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))
GenericUtils.verifyMatch('Status Value is', signedStatus, expectedSignedStatus, 'EQUAL')

KeywordUtil.logInfo('Peer Review: ' + WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PeerReviewNumber')), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/button_close'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/button_close'))

// ── Step 26: Navigate to Dashboard → verify sections ───────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/hoverSidebar'), GlobalVariable.timeoutShort)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
        [('optionToSelect') : 'Dashboard']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Dashboard']))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue)
WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

List<WebElement> fieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFields'), GlobalVariable.timeOutValue)
List<WebElement> fieldList = new ArrayList<String>()
for (WebElement f : fieldNames) { fieldList.add(f.getText()) }
GenericUtils.compareLists(fieldList, expectedList)

List<WebElement> dataValidationFieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFieldsUnderDataValidation'), GlobalVariable.timeOutValue)
List<WebElement> dataValidationFieldList = new ArrayList<String>()
for (WebElement f : dataValidationFieldNames) { dataValidationFieldList.add(f.getText()) }
GenericUtils.compareLists(dataValidationFieldList, expectedDataValidationList)

List<WebElement> dataValidationLinkNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfLinks'), GlobalVariable.timeOutValue)
List<WebElement> dataValidationLinkList = new ArrayList<String>()
for (WebElement f : dataValidationLinkNames) { dataValidationLinkList.add(f.getText()) }
GenericUtils.compareLists(dataValidationLinkList, expectedDataLinkList)

List<WebElement> renewalFieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFieldsRenewal'), GlobalVariable.timeOutValue)
List<WebElement> renewalFieldList = new ArrayList<String>()
for (WebElement j : renewalFieldNames) { renewalFieldList.add(j.getText()) }
GenericUtils.compareLists(renewalFieldList, expectedWorkFlowList)

WebUI.switchToDefaultContent()

// ── Step 27: Click "Policy Expires within 7 days" ──────────────────────────────
WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect') : 'Policy Expires within 7 days']),
    GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect') : 'Policy Expires within 7 days']))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/button_ExportToExcel'), GlobalVariable.timeOutValue)
WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

List<WebElement> headerNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfHeaders'), GlobalVariable.timeOutValue)
List<WebElement> headerList = new ArrayList<String>()
for (WebElement k : headerNames) { headerList.add(k.getText()) }
headerList.remove(0)
headerList.remove(headerList.size() - 1)
GenericUtils.compareLists(headerList, expectedHeaderList)

WebUI.switchToDefaultContent()

// ── Steps 28-29: Filter and verify Overview Tab ─────────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_Filter'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_Filter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'Search Text']), policyRef)

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Apply'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Apply'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_SelectPolicyNumber'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_SelectPolicyNumber'))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_PeerReviewNumber'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

if (WebUI.verifyElementVisible(findTestObject('Object Repository/NewBusiness/webElement_PeerReviewNumber'))) {
    KeywordUtil.markPassed('Policy is opened in OverView Tab')
} else {
    KeywordUtil.markFailedAndStop('Policy is NOT opened in OverView Tab')
}