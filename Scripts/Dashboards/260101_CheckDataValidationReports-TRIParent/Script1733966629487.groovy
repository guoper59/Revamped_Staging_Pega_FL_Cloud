/**
 * ============================================================================
 * Test Case ID  : 260101
 * Title         : Check for Data Validation Reports — TRI Parent Check
 * Path          : Test Cases/Dashboards/260101_CheckDataValidationReports-TRIParent
 * ============================================================================
 *
 * DESCRIPTION:
 *   Validates the Dashboard Data Validation Reports section for "TRI Parent
 *   Check". Creates a TRI (Transactional Risk Insurance) submission using
 *   Ebello credentials, skips quoting via the SkipQuote checkbox. Finalises
 *   the policy, navigates to Dashboard, clicks "TRI Parent Check", filters by
 *   policy reference, and resolves the TRI parent check by assigning a parent
 *   insured via Party Management. Then verifies the parent insured is reflected.
 *
 * HIGH-LEVEL STEPS (from TestPack — 46 steps):
 *   1.    Login as Ebello
 *   2-4.  Create insured → select reinsured → broker details
 *   5-10. General Data — EV Currency, Working Status, Skip Quote,
 *         Target Name/Domicile/NAIC, Continue
 *   11.   Policy Reference → OK
 *   12-18. UW Worksheet (enterprise value, participation, limits, commission,
 *           premium, territorial scope, applicable law, max limit, cyber coverage,
 *           completion date, buyer, seller, estimated date, UW authority, currency,
 *           lead value)
 *   19.   Continue → Tax details → instalments → UWQC
 *   20.   Bind Policy → Finalise → Proceed → Signed
 *   21.   Navigate to Dashboard → TRI Parent Check → filter by policy ref
 *   22.   Click insured task link → set Parent Insured → submit
 *   23.   Close → Party Management → Insured → search → verify parent insured
 *
 * PRECONDITIONS:
 *   - Valid test data in the variable 'testData' data file for test case 260101
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

String inputLeadValue = findTestData(testData).getValue('input_Lead', rowNumber)
String projectnameValue = findTestData(testData).getValue('ProjectName', rowNumber)

// ── Setup ──────────────────────────────────────────────────────────────────────
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

KeywordUtil.logInfo('RowNumber: ' + rowNumber)

String timeStamp = GenericUtils.getCurrentTimestamp()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Ebello', GlobalVariable.Ebello, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Creating a Submission')

// ── Steps 2-4: Create insured ───────────────────────────────────────────────────
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_UserName'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

SubmissionHelper.enterInsuredDetails(testData, rowNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'),
    GlobalVariable.timeOutValue)

SubmissionHelper.selectReinsured(testData, rowNumber)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
        'Country', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']),
    GlobalVariable.timeOutValue)
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']),
    findTestData(testData).getValue('Broker', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : brokerValue]), GlobalVariable.timeOutValue)
WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : brokerValue]))
WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : brokerValue]))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'),
    findTestData(testData).getValue('Broker Contact', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// ── Steps 5-10: General Data ───────────────────────────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'),
    GlobalVariable.timeOutValue)
SubmissionHelper.enterGeneralData(testData, rowNumber)

String caseID = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseID'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'EV Currency ']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'EV Currency ']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'EV Currency ']),
    findTestData(testData).getValue('EVCurrency', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Working Status']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Working Status']))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_SkipQuote'), GlobalVariable.timeOutValue)
WebUI.check(findTestObject('Object Repository/NewBusiness/webElement_SkipQuote'))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicValues', [('fieldName') : 'Target Name ']),
    GlobalVariable.timeOutValue)
String actualTargetName = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicValues', [('fieldName') : 'Target Name ']),
    FailureHandling.STOP_ON_FAILURE)
GenericUtils.verifyMatch('Target Name Is : ', actualTargetName, findTestData(testData).getValue('TargetName', rowNumber), 'EQUAL')

String actualTargetDomicile = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicValues', [('fieldName') : 'Target Domicile']),
    FailureHandling.STOP_ON_FAILURE)
GenericUtils.verifyMatch('Target Domicile Is : ', actualTargetDomicile, findTestData(testData).getValue('TargetDomicile', rowNumber), 'EQUAL')

String actualTargetNAIC = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicValues', [('fieldName') : 'Target NAIC']),
    FailureHandling.STOP_ON_FAILURE)
GenericUtils.verifyMatch('Target NAIC Is : ', actualTargetNAIC, findTestData(testData).getValue('TargetNAIC', rowNumber), 'EQUAL')

// ── Step 11: Continue → Policy Reference ───────────────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NewBusiness/webElement_PolicyReference'), 180)
String policyRef = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PolicyReference'))
KeywordUtil.logInfo('Policy Reference: ' + policyRef)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_OK'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_OK'))

// ── Steps 12-18: UW Worksheet ──────────────────────────────────────────────────
WebUI.waitForElementPresent(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Enterprise Value']),
    GlobalVariable.timeOutValue)
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Enterprise Value']),
    findTestData(testData).getValue('EnterpriseValue', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TMHCCWrittenParticipation'),
    GlobalVariable.timeOutValue)
WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TMHCCWrittenParticipation'),
    findTestData(testData).getValue('TMHCC Written Participation%', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'),
    findTestData(testData).getValue('Layer AGG Limit', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'),
    GlobalVariable.timeOutValue)
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'),
    findTestData(testData).getValue('Commission', rowNumber))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPremiumType'),
    'Original Premium', false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'), Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
    findTestData(testData).getValue('Layer Gross Premium', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']),
    findTestData(testData).getValue('Territorial Scope', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Applicable Law']),
    GlobalVariable.timeOutValue)
WebUI.setText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Applicable Law']),
    findTestData(testData).getValue('Applicable Law', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Maximum Limit Quoted']),
    GlobalVariable.timeOutValue)
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Maximum Limit Quoted']),
    findTestData(testData).getValue('Maximum Limit Quoted', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownCyberCoverage'),
    GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownCyberCoverage'),
    findTestData(testData).getValue('Cyber Coverage', rowNumber), false)
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownCyberCoverage'),
    findTestData(testData).getValue('Cyber Coverage', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Completion Date']),
    GlobalVariable.timeOutValue)
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Completion Date']),
    findTestData(testData).getValue('Completion Date', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Buyer']),
    GlobalVariable.timeOutValue)
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Buyer']),
    findTestData(testData).getValue('Buyer', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Seller']),
    GlobalVariable.timeOutValue)
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Seller']),
    findTestData(testData).getValue('Seller', rowNumber))

WebUI.uncheck(findTestObject('Object Repository/NewBusiness/checkBox_EstimatedDate'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'),
    findTestData(testData).getValue('UW Authority', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBaseCurrencyCode'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBaseCurrencyCode'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBaseCurrencyCode'),
    findTestData(testData).getValue('Original Currency', rowNumber), false)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), 25)
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))
WebUI.clearText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))
WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), inputLeadValue)
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), Keys.chord(Keys.BACK_SPACE))

String currentText = inputLeadValue.substring(0, inputLeadValue.length() - 1)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]),
    GlobalVariable.timeOutValue)
WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))
WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

// ── Step 19: Continue → Tax → Instalments → UWQC ──────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
    GlobalVariable.timeoutShort)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
    findTestData(testData).getValue('Tax Applicable', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'),
    GlobalVariable.timeOutValue)
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'),
    findTestData(testData).getValue('Due Date', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
        [('optionToSelect') : 'Yes']), GlobalVariable.timeOutValue)
WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
        [('optionToSelect') : 'Yes']))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Submit'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))

// ── Step 20: Bind Policy → Finalise → Signed ───────────────────────────────────
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions',
        [('linkToClick') : 'Bind Policy']), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions', [('linkToClick') : 'Bind Policy']))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'), 60,
    FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'), 60, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'),
    60, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'), 60)
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'), 60)
String signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))
KeywordUtil.logInfo('Policy status: ' + signedStatus)

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Close'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))

// ── Step 21: Navigate to Dashboard → TRI Parent Check ──────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/hoverSidebar'), GlobalVariable.timeoutShort)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
        [('optionToSelect') : 'Dashboard']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Dashboard']))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue)
WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

// Verify Dashboard sections
List<WebElement> fieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFields'), GlobalVariable.timeOutValue)
List<WebElement> fieldList = new ArrayList<String>()
for (WebElement f : fieldNames) { fieldList.add(f.getText()) }
GenericUtils.compareLists(fieldList, expectedList)

List<WebElement> dataValidationFieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFieldsUnderDataValidation'), GlobalVariable.timeOutValue)
List<WebElement> dataValidationFieldList = new ArrayList<String>()
for (WebElement f : dataValidationFieldNames) { dataValidationFieldList.add(f.getText()) }
GenericUtils.compareLists(dataValidationFieldList, expectedDataValidationList)

List<WebElement> renewalFieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFieldsRenewal'), GlobalVariable.timeOutValue)
List<WebElement> renewalFieldList = new ArrayList<String>()
for (WebElement j : renewalFieldNames) { renewalFieldList.add(j.getText()) }
GenericUtils.compareLists(renewalFieldList, expectedWorkFlowList)

WebUI.switchToDefaultContent()

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect') : 'TRI Parent Check']),
    GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect') : 'TRI Parent Check']))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/button_ExportToExcel'), GlobalVariable.timeOutValue)

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue)
WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

// Verify headers
List<WebElement> headerNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfHeaders'), GlobalVariable.timeOutValue)
List<WebElement> headerList = new ArrayList<String>()
for (WebElement k : headerNames) { headerList.add(k.getText()) }
GenericUtils.compareLists(headerList, expectedHeaderList)

WebUI.switchToDefaultContent()

// Filter by policy reference
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_Filter'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_Filter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'Search Text']), policyRef)

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Apply'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Apply'))

// ── Step 22: Click insured task link → assign Parent Insured ────────────────────
WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_InsuredTaskLink'), 10)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_InsuredTaskLink'))

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_IsParent'),
    GlobalVariable.timeOutValue)
WebUI.uncheck(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_IsParent'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Parent Insured']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Parent Insured']))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Parent Insured']),
    projectnameValue)

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/webElement_AutoCompleteResult',
        [('projectName') : projectnameValue]), GlobalVariable.timeOutValue)
WebUI.enhancedClick(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/webElement_AutoCompleteResult',
        [('projectName') : projectnameValue]))

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/button_Submit'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/button_Submit'))

WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/webElement_ActionCompletedMessage'), 20)

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/button_Close'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/button_Close'))

// ── Step 23: Party Management → Insured → search and verify ─────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/hoverSidebar'), GlobalVariable.timeoutShort)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
        [('optionToSelect') : 'Party Management']), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Party Management']))

KeywordUtil.logInfo('Navigated to Party Management')

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/hoverSidebar'), GlobalVariable.timeoutShort)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
        [('optionToSelect') : 'Insured']), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Insured']))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_UserName'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

KeywordUtil.logInfo('Navigated to Insured')

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'Insured Name']),
    GlobalVariable.timeOutValue)
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'Insured Name']),
    GlobalVariable.insuredName)

KeywordUtil.logInfo('Entered random insured name to search')

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/webElement_ReadValues',
        [('fieldName') : 'Parent Insured Name', ('columnNumber') : 10]), GlobalVariable.timeOutValue, FailureHandling.OPTIONAL)