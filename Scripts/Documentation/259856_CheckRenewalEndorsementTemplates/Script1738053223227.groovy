/**
 * ============================================================================
 * Test Case ID : 259856
 * Title         : Check Renewal Endorsement Templates
 * Folder        : Scripts/Documentation/259856_CheckRenewalEndorsementTemplates
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

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

String testData = 'Documentation'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

rowNumberforTestData = rowNumber

KeywordUtil.logInfo(GlobalVariable.testCaseID)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), 25, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

SubmissionHelper.enterInsuredDetails(testData, rowNumber)

WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'No']))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

SubmissionHelper.enterBrokerDetails(testData, rowNumber)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

SubmissionHelper.enterGeneralData(testData, rowNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 60)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 60, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'), 
    GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180, FailureHandling.OPTIONAL)

String policyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

KeywordUtil.logInfo(policyRef)

GlobalVariable.PolicyRef = policyRef

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))

//Uw Worksheet
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

SubmissionHelper.enterDetailsUWSheet(testData, rowNumber)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CompleteQuote'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CompleteQuote'), FailureHandling.OPTIONAL)

String qoutedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

KeywordUtil.logInfo('Status on this stage is ::' + qoutedStatus)

//TODO: 540274: Remove the Quote Doc and Broker Bind Doc stage from the Pega data entry workflow

////Click on takeup the quote.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))
//TODO: 540276 Generate a Quote Letter document and to Take Up a Quote version to the Bind stage to be amended and moved to the Underwriting stage
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'), 25)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))

String openBoundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

KeywordUtil.logInfo('Status on this stage is ::' + openBoundStatus)

SubmissionHelper.enterDetailsUW(testData, rowNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'ADR Exposure ']), GlobalVariable.timeoutShort)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', 
        [('labelName') : 'Local Market Cap ']), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Local Market Cap ']))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Local Market Cap ']), 
    findTestData(testData).getValue('LocalMarketCap', rowNumber))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', [('dropDownLabel') : 'ADR Exposure ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'ADR Exposure ']), findTestData(testData).getValue('ADRExposure', rowNumber), false)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'),
	findTestData(testData).getValue('CryptoExposure', rowNumber), false)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.clearText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), findTestData(testData).getValue('input_Lead', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), Keys.chord(Keys.BACK_SPACE))

String currentText =  findTestData(testData).getValue('input_Lead', rowNumber).substring(0, findTestData(testData).getValue('input_Lead', rowNumber).length()-1)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]), GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

String boundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

KeywordUtil.logInfo('Status on this stage is ::' + boundStatus)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    GlobalVariable.timeoutShort)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 25)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    findTestData(testData).getValue('Tax Applicable', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	findTestData(testData).getValue('Tax code', rowNumber))

WebUI.clearText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']))

WebUI.setText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	findTestData(testData).getValue('Tax code', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']), Keys.chord(Keys.BACK_SPACE))

currentText =  findTestData(testData).getValue('Tax code', rowNumber).substring(0, findTestData(testData).getValue('Tax code', rowNumber).length()-1)

WebUI.mouseOver(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.enhancedClick(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Premium']), 
    findTestData(testData).getValue('Tax Premium', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
        testData).getValue('Due Date', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
        Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), 
    GlobalVariable.timeoutShort)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions', 
        [('linkToClick') : 'Bind Policy']), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions', [('linkToClick') : 'Bind Policy']))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'), 60, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'))

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'), FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'), 
    25, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

String signedStatusNew = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', signedStatusNew, 'Signed', 'EQUAL')

String peerReview = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PeerReviewNumber'))

KeywordUtil.logInfo('Peer Review Case generate for this is : ' + peerReview)

WebUI.closeBrowser()

WebUI.openBrowser(null)

WebUI.maximizeWindow()

String renewedPolicy = WebUI.callTestCase(findTestCase('Test Cases/TestData/RenewalAgent'), [('testData') : testData, ('rowNumber') : rowNumber], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser(null)

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Dashboard']))

WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Verifying Search Filter field names
List<WebElement> fieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFields'), 
    GlobalVariable.timeOutValue)

List<WebElement> fieldList = new ArrayList<String>()

for (WebElement f : fieldNames) {
    fieldList.add(f.getText())
}

GenericUtils.compareLists(fieldList, expectedList)

//Verifying Data Validation field names
List<WebElement> dataValidationFieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFieldsUnderDataValidation'), 
    GlobalVariable.timeOutValue)

List<WebElement> dataValidationFieldList = new ArrayList<String>()

for (WebElement f : dataValidationFieldNames) {
    dataValidationFieldList.add(f.getText())
}

GenericUtils.compareLists(dataValidationFieldList, expectedDataValidationList)

//Verifying Renewal field names
List<WebElement> renewalFieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFieldsRenewal'), 
    GlobalVariable.timeOutValue)

List<WebElement> renewalFieldList = new ArrayList<String>()

for (WebElement j : renewalFieldNames) {
    renewalFieldList.add(j.getText())
}

GenericUtils.compareLists(renewalFieldList, expectedWorkFlowList)

WebUI.switchToDefaultContent()

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_RenewalLinks', [('optionToSelect') : 'Renewal Work Basket']), 
    GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Selecting policy under Renewal Work Basket
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_RenewalLinks', [('optionToSelect') : 'Renewal Work Basket']))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/button_ExportToExcel'), GlobalVariable.timeOutValue)

//Clicking on Filter option for Qoute Reference ID
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_RenewedFromPolicyFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

//Searching for the Case ID created above
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'Search Text']), 
    GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/Dashboards/button_Apply'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_QuoteReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_QuoteReference'))

WebUI.click(findTestObject('Object Repository/Renewal/button_Continue'))

WebUI.click(findTestObject('Object Repository/Renewal/button_Continue'))

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.click(findTestObject('Object Repository/Renewal/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'), 
    GlobalVariable.timeOutValue)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPremiumType'), 
    'Original Premium', false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'), 
    Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'), 
    findTestData(testData).getValue('Layer Gross Premium', rowNumber))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_PremiumCalculate'))

WebUI.click(findTestObject('Object Repository/Dashboards/button_CompleteQuote'))

//TODO: 540274: Remove the Quote Doc and Broker Bind Doc stage from the Pega data entry workflow

////Click on takeup the quote.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))
//TODO: 540276 Generate a Quote Letter document and to Take Up a Quote version to the Bind stage to be amended and moved to the Underwriting stage
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'), 25)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TacItRenewalDate'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TacItRenewalDate'), 
    Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TacItRenewalDate'), 
    findTestData(testData).getValue('TacitRenewalDate2', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'ADR Exposure ']), GlobalVariable.timeoutShort)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', 
        [('labelName') : 'Local Market Cap ']), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Local Market Cap ']))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Local Market Cap ']), 
    findTestData(testData).getValue('LocalMarketCap', rowNumber))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', [('dropDownLabel') : 'ADR Exposure ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'ADR Exposure ']), findTestData(testData).getValue('ADRExposure', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 's Total Assets']))

WebUI.sendKeys(findTestObject('Object Repository/Page_Broker/input_FieldName', [('fieldName') : 's Total Assets']), findTestData(
        testData).getValue('Entitys Total Assets', rowNumber), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
	GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
	'Single Territory Taxes apply - no split', false)

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	findTestData(testData).getValue('Tax code', rowNumber))

WebUI.clearText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']))

WebUI.setText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	findTestData(testData).getValue('Tax code', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']), Keys.chord(Keys.BACK_SPACE))

currentText =  findTestData(testData).getValue('Tax code', rowNumber).substring(0, findTestData(testData).getValue('Tax code', rowNumber).length()-1)

WebUI.mouseOver(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.enhancedClick(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Premium']))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Premium']), 
    Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Premium']), 
    findTestData(testData).getValue('Tax Premium', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
        Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
        testData).getValue('DueDate2', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
        Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

//Installments Validations
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/webElement_tblValue', 
        [('tableName') : 'Instalment']), 25)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions', 
        [('linkToClick') : 'Bind Policy']), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions', [('linkToClick') : 'Bind Policy']))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'), 25, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'))

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'), FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'), 
    25, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_ExpandTabs'), 25)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_ExpandTabs'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector', 
        [('tabName') : 'Payments']), GlobalVariable.timeOutValue)

WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/webElement_TabSelectorAfterExpansion', [('tabName') : 'Payments']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Endorsements/webElement_TabSelectorAfterExpansion', [('tabName') : 'Payments']))

//Verifying if Order Form is available in the attachment
//Verifying if Order Form is available in the attachment

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_ExpandTabs'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_ExpandTabs'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/webElement_TabSelectorAfterExpansion', [('tabName') : 'Policy Docs']), 
    GlobalVariable.timeOutValue)

WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/webElement_TabSelectorAfterExpansion', [('tabName') : 'Policy Docs']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Endorsements/webElement_TabSelectorAfterExpansion', [('tabName') : 'Policy Docs']))

//Wait for a specific element to be visible within a specified timeout.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/link_Generate'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

//Click on a link to generate something.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/link_Generate'))

//Switch to a specific frame on the web page within a specified timeout.
WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Verifying Data Validation field names
List<WebElement> policyDocsName = WebUI.findWebElements(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_PolicyDocsOptions'), 
    GlobalVariable.timeOutValue)

List<WebElement> policyDocsOptionsList = new ArrayList<String>()

for (WebElement e : policyDocsName) {
    policyDocsOptionsList.add(e.getText())
}

GenericUtils.compareLists(policyDocsOptionsList, expectedPolicyDocsList)

policyDocsName.get(2).click()

WebUI.switchToDefaultContent()

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLanguage'), 60)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLanguage'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLanguage'), 
    findTestData(testData).getValue('Language', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTemplate'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTemplate'), 
    findTestData(testData).getValue('Template', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/input_FieldName', [('fieldName') : 'Contract Basis 1']), 'NA')

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/input_FieldName', [('fieldName') : 'Contract Basis 2']), 'NA')

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/input_FieldName', [('fieldName') : 'Contract Basis 2']), Keys.chord(
        Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_Submit'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_Submit'))
