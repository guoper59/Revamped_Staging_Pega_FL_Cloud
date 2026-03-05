/**
 * ============================================================================
 * Test Case ID  : 262212
 * Title         : Check for Data Validation Reports — Broker Company to be Approved
 * Path          : Test Cases/Dashboards/262212_CheckForDataValidationReportsBrokerCompanyToBeApproved
 * ============================================================================
 *
 * DESCRIPTION:
 *   Validates the Dashboard Data Validation Reports section for "Broker Company
 *   to be Approved". Creates a submission with a brand-new broker company that
 *   hasn't yet been approved (using SROSS credentials). The new broker company
 *   is created inline during the submission. After saving, navigates to
 *   Dashboard, clicks "Broker Company to be Approved", and verifies the case
 *   appears in the list. The test then resolves the approval by navigating
 *   through the case link, completing the broker approval workflow, and
 *   confirming the case is no longer listed.
 *
 * HIGH-LEVEL STEPS (from TestPack — 34 steps):
 *   1.    Login as SROSS
 *   2.    Create Insured (unique name via UUID timestamp)
 *   3.    Select Reinsured → Continue
 *   4.    Create new Broker Company inline (name, address, contact details)
 *   5-8.  Continue through General Data → Inception Date → Entity → Legal Branch
 *          → Continue → Close (submission saved in Open status)
 *   9.    Navigate to Dashboard, click "Broker Company to be Approved"
 *   10-14. Filter by insured name, verify case listed, click to open,
 *           approve broker company, verify success message
 *   15.   Re-filter, verify case no longer listed
 *
 * PRECONDITIONS:
 *   - Valid test data in 'Dashboards' data file for test case 262212
 *   - brokerCompanyName, firstName, surname, eMail variables passed in
 *   - Application URL and SROSS credentials configured in GlobalVariable
 *
 * ============================================================================
 */

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat as SimpleDateFormat
import org.openqa.selenium.Keys as Keys
import java.util.UUID as UUID

import com.submission.helper.SubmissionHelper as SubmissionHelper
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject as TestObject

// ── Setup ──────────────────────────────────────────────────────────────────────
String testData = 'Dashboards'

int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

KeywordUtil.logInfo('Test Case ID: ' + GlobalVariable.testCaseID)
KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
    FailureHandling.STOP_ON_FAILURE)

// ── Step 2: Create Insured ──────────────────────────────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/hoverSidebar'), GlobalVariable.timeOutValue)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_UserName'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
    GlobalVariable.timeOutValue)
WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'))

String InsuredName = 'TMHCC Broker Comp approved' + "${new SimpleDateFormat('MMddHHmmss').format(new Date())}_${UUID.randomUUID().toString()}"
GlobalVariable.insuredName = InsuredName

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_BusinessUnit'), InsuredName)

WebUI.waitForPageLoad(GlobalVariable.timeoutShort)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_SearchName'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_SearchName'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'),
    GlobalVariable.timeOutValue)
WebUI.check(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'),
    findTestData(testData).getValue('Addressline', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'),
    findTestData(testData).getValue('PostCode', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'),
    findTestData(testData).getValue('City', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownCountry'),
    GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownCountry'),
    findTestData(testData).getValue('Country', rowNumber), false)

WebUI.waitForPageLoad(GlobalVariable.timeoutShort)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
    findTestData(testData).getValue('NAIC Division', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Name']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Name']))
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Name']), InsuredName)

WebUI.waitForPageLoad(GlobalVariable.timeoutShort)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
    findTestData(testData).getValue('NAIC Description', rowNumber), false)

WebUI.waitForPageLoad(GlobalVariable.timeoutShort)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'),
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'),
    findTestData(testData).getValue('Public/Private', rowNumber), false)

WebUI.waitForPageLoad(GlobalVariable.timeoutShort)

if (!(findTestData(testData).getValue('State', rowNumber).equals(''))) {
    WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'State']),
        GlobalVariable.timeOutValue)
    WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'State']))
    WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'State']),
        findTestData(testData).getValue('State', rowNumber), false)
}

WebUI.waitForPageLoad(GlobalVariable.timeoutShort)

// ── Step 3: Select Reinsured → Continue ────────────────────────────────────────
SubmissionHelper.selectReinsured(testData, rowNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// ── Step 4: Create new Broker Company inline ────────────────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'),
    GlobalVariable.timeOutValue)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Broker/button_CreateNewBroker'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Page_Broker/button_CreateNewBroker'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'Broker Company Name']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'Broker Company Name']))
WebUI.sendKeys(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'Broker Company Name']),
    brokerCompanyName, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'Address Line 1']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'Address Line 1']))
WebUI.sendKeys(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'Address Line 1']),
    findTestData(testData).getValue('Addressline', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Broker/input_FieldNameByIndex', [('fieldName') : 'City', ('index') : '2']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Page_Broker/input_FieldNameByIndex', [('fieldName') : 'City', ('index') : '2']))
WebUI.sendKeys(findTestObject('Object Repository/Page_Broker/input_FieldNameByIndex', [('fieldName') : 'City', ('index') : '2']),
    findTestData(testData).getValue('City', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'Postcode']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'Postcode']))
WebUI.sendKeys(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'Postcode']),
    findTestData(testData).getValue('PostCode', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Broker/select_DropdownCountry', [('index') : '2']),
    GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Broker/select_DropdownCountry', [('index') : '2']),
    findTestData(testData).getValue('Country', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'First Name']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'First Name']))
WebUI.sendKeys(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'First Name']),
    firstName, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'SurName']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'SurName']))
WebUI.sendKeys(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'SurName']), surname)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'Email']),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'Email']))
WebUI.sendKeys(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 'Email']), eMail)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Broker/select_DropdownCountry', [('index') : '3']),
    GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Broker/select_DropdownCountry', [('index') : '3']),
    findTestData(testData).getValue('Country', rowNumber), false)

// ── Steps 5-8: Continue through General Data → Close ───────────────────────────
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 25, FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), FailureHandling.OPTIONAL)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 25, FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), FailureHandling.OPTIONAL)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'), 60)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'),
    findTestData(testData).getValue('Class Type', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMajorClass'),
    GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMajorClass'),
    findTestData(testData).getValue('Major Class', rowNumber), false)

String lineOfBusiness = findTestData(testData).getValue('Major Class', rowNumber)
GlobalVariable.LineOfBusiness = lineOfBusiness

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMinorClass'),
    GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMinorClass'),
    findTestData(testData).getValue('Minor Class', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClass'),
    GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClass'),
    findTestData(testData).getValue('Class', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'),
    GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'),
    findTestData(testData).getValue('Placing Type', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownSubPlacingType'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownSubPlacingType'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownSubPlacingType'),
    findTestData(testData).getValue('Sub Placing Type', rowNumber), false)

if (!(findTestData(testData).getValue('TMHCC Placing Title', rowNumber).equals(''))) {
    WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement',
            [('fieldtoSelect') : 'TMHCCPlacingTitle']), findTestData(testData).getValue('TMHCC Placing Title', rowNumber), false)
}

if (!(findTestData(testData).getValue('ISPrimary', rowNumber).equals(''))) {
    WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement',
            [('fieldtoSelect') : 'pIsPrimaryOrExcess']), findTestData(testData).getValue('ISPrimary', rowNumber), false)
}

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwriter'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwriter'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwriter'),
    findTestData(testData).getValue('Underwriter', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant'),
    findTestData(testData).getValue('Underwriting Assistant', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Producing Team ']),
    GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Producing Team ']),
    findTestData(testData).getValue('Producing Team', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'))
WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'),
    findTestData(testData).getValue('Inception Date', rowNumber))

String inceptionDate = findTestData(testData).getValue('Inception Date', rowNumber)
GlobalVariable.InceptionDate = inceptionDate

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'),
    GlobalVariable.timeoutShort)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'),
    findTestData(testData).getValue('Entity', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'),
    GlobalVariable.timeoutShort)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'),
    findTestData(testData).getValue('Legal Branch', rowNumber), false)

if (!(findTestData(testData).getValue('K&Rtype', rowNumber).equals(''))) {
    WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_KrType'),
        findTestData(testData).getValue('K&Rtype', rowNumber), false)
}

WebUI.waitForPageLoad(GlobalVariable.timeoutShort)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'),
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Close'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))