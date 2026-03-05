/**
 * ============================================================================
 * Test Case ID : 260006
 * Title         : Checkfor RI Slip Templates
 * Folder        : Scripts/Documentation/260006_CheckforRISlipTemplates
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
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper as SubmissionHelper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

//Finding Row number from Test Data.
int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData1).getValue('Role', rowNumber1))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Creating a Submission')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Click on the 'Create' button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

//Wait for the 'Insured' element to be visible

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

// Enter insured details using the provided test data for a specific row number.
SubmissionHelper.enterInsuredDetails(testData, rowNumber)

// Select reinsured data based on the specified row number from the test data.
SubmissionHelper.selectReinsured(testData, rowNumber)

// Click on continue button.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 25, FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), FailureHandling.OPTIONAL)

// Enter broker details using the provided test data and row number.
SubmissionHelper.enterBrokerDetails(testData, rowNumber)

// Click on continue button.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 180, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), FailureHandling.OPTIONAL)

// Enter details in General Data using the provided test data and row number.
SubmissionHelper.enterGeneralData(testData, rowNumber)

// Click on continue button.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 180, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), FailureHandling.OPTIONAL)

//Get the text of the 'sPolicyReference' element and store it in 'PolicyRef' variable.
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)

GlobalVariable.PolicyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

KeywordUtil.logInfo(GlobalVariable.PolicyRef)

//Click on the 'OK' element on the page.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))
//Uw Worksheet
// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

SubmissionHelper.enterDetailsUWSheet(testData, rowNumber)

//Verifying the values
String policyPeriod = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
	[('labelName') : 'Policy Period ']), 'value')

GenericUtils.verifyMatch('Policy Period Value is', policyPeriod, findTestData(testData).getValue('PolicyPeriod', rowNumber), 'EQUAL')

String orderValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Order %']), 'value')

GenericUtils.verifyMatch('Order Value is', orderValue, findTestData(testData).getValue('Order%', rowNumber), 'EQUAL')

String estimatedSigningValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Estimated Signing %']), 'value')

GenericUtils.verifyMatch('Estimated Signing Value is', estimatedSigningValue, findTestData(testData).getValue('Estimated Signing %', 
        rowNumber), 'EQUAL')

String calculatedLineValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Calculated Line %']), 'value')

GenericUtils.verifyMatch('Calculated line Value is', calculatedLineValue, findTestData(testData).getValue('Calculated Line %', 
        rowNumber), 'EQUAL')

String tmhccLimitValue = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadLimitInformation', 
        [('headerName') : 'TMHCC EEL Limit']))

GenericUtils.verifyMatch('TMHCC EEL Limit Value is', tmhccLimitValue, findTestData(testData).getValue('TMHCC EEL Limit', 
        rowNumber), 'EQUAL')

String tmhccAggLimitValue = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadLimitInformation', 
        [('headerName') : 'TMHCC AGG Limit']))

GenericUtils.verifyMatch('TMHCC Agg Limit Value is', tmhccAggLimitValue, findTestData(testData).getValue('TMHCC AGG Limit', 
        rowNumber), 'EQUAL')

String layerCommissionValue = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'Layer Broker Commission Amount']))

GenericUtils.verifyMatch('Layer Commission Value is', layerCommissionValue, findTestData(testData).getValue('LayerBrokerCommissionAmount', 
        rowNumber), 'EQUAL')

String tmhccBrokerCommissionValue = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Broker Commission Amount']))

GenericUtils.verifyMatch('TMHCC Broker Commission Value is', tmhccBrokerCommissionValue, findTestData(testData).getValue(
        'TMHCCBrokerCommissionAmount', rowNumber), 'EQUAL')

String tmhccGrossPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Gross Premium']))

GenericUtils.verifyMatch('TMHCC Gross Premium Value is', tmhccGrossPremium, findTestData(testData).getValue('TMHCCGrossPremium', 
        rowNumber), 'EQUAL')

String tmhccNetPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Net Premium']))

GenericUtils.verifyMatch('TMHCC Net Premium Value is', tmhccNetPremium, findTestData(testData).getValue('TMHCCNetPremium', 
        rowNumber), 'EQUAL')

String layerNetPremium = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Layer Net Premium']), 'data-value')

GenericUtils.verifyMatch('Layer Net Premium default to', layerNetPremium, findTestData(testData).getValue('Layer Net Premium',
	rowNumber)+'.00', 'EQUAL')

//Click on complete the quote.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CompleteQuote'))

//Get the text of a status element.
String qoutedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))
////Click on continue.

//TODO: 540274: Remove the Quote Doc and Broker Bind Doc stage from the Pega data entry workflow
////Click on takeup the quote.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))
//TODO: 540276 Generate a Quote Letter document and to Take Up a Quote version to the Bind stage to be amended and moved to the Underwriting stage
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'), 25)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))

//Enter details for underwriting.
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

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'), 60)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'),
	findTestData(testData).getValue('CryptoExposure', rowNumber), false)
////Click on continue.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 25)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

String boundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

//Click On Continue button
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    60)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
	60)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    findTestData(testData).getValue('Tax Applicable', rowNumber), false)

WebUI.setText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	findTestData(testData).getValue('Tax Code', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']), Keys.chord(Keys.BACK_SPACE))

String currentText =  findTestData(testData).getValue('Tax Code', rowNumber).substring(0, findTestData(testData).getValue('Tax Code', rowNumber).length()-1)

WebUI.mouseOver(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.enhancedClick(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']), 
    findTestData(testData).getValue('Tax Premium', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
        testData).getValue('Due Date', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
        Keys.TAB))

//Double clicks on a button to generate installments.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

//Waits for a button to be clickable, then clicks on it to create underwriting.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

// Wait for a specific element related to case content options to be visible within 10 seconds.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions', 
        [('linkToClick') : 'Bind Policy']), 10, FailureHandling.STOP_ON_FAILURE)

//Click on a link within the case content options.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions', [('linkToClick') : 'Bind Policy']))

// Wait for the finalise policy button to be visible based on a specified timeout value.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

//Click on the finalise policy button.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'))

// Wait for the 'Finalise Policy' prompt to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Click on the 'Proceed' button.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

//Wait for the 'Policy Docs' tab to be visible in the dynamic tab selector.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector', 
        [('tabName') : 'Policy Docs']), 10, FailureHandling.STOP_ON_FAILURE)

//Get the text of a specific element on the web page.
String signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector', [('tabName') : 'Policy Docs']))

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

SubmissionHelper.generateBrokerBind(testData, rowNumber)

WebUI.switchToWindowIndex(1)
WebUI.switchToFrame(findTestObject('Object Repository/Pega_CreateInsured/iframePdfViewer'), GlobalVariable.timeOutValue)
WebUI.verifyTextPresent('FACULTATIVE REINSURANCE', false)

WebUI.verifyTextPresent('CONTRACT', false)

WebUI.verifyTextPresent('This document details the contract terms entered into by the', false)

WebUI.verifyTextPresent('Reinsured and', false)

WebUI.verifyTextPresent('the Reinsurer', false)

WebUI.verifyTextPresent('and constitutes the contract document.', false)

WebUI.verifyTextPresent('SCHEDULE', false)

WebUI.verifyTextPresent('REINSURANCE', false)

WebUI.verifyTextPresent('CONTRACT', false)

WebUI.verifyTextPresent('REINSURANCE', false)

WebUI.verifyTextPresent('Contract', false)

WebUI.verifyTextPresent('Number:', false)

WebUI.verifyTextPresent(GlobalVariable.PolicyRef, false)

WebUI.verifyTextPresent('Reinsurance', false)

WebUI.verifyTextPresent('Period:', false)

WebUI.verifyTextPresent('From:', false)

WebUI.verifyTextPresent('01.03.2023', false)

WebUI.verifyTextPresent('To', false)

WebUI.verifyTextPresent('01.03.2024', false)

WebUI.verifyTextPresent('Both days at 0:01 at the', false)

WebUI.verifyTextPresent('Original', false)

WebUI.verifyTextPresent('Insured’s address stated below.', false)

WebUI.verifyTextPresent('Reinsurer:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Entity', rowNumber) + ' S.A.', false)

WebUI.verifyTextPresent('Torre Diagonal Mar, Josep Pla 2, Planta 10', false)

WebUI.verifyTextPresent('08019 Barcelona, Spain', false)

WebUI.verifyTextPresent('Reinsured', false)

WebUI.verifyTextPresent('Name', false)

WebUI.verifyTextPresent('AIG Europe Limited', false)

WebUI.verifyTextPresent('Address', false)

WebUI.verifyTextPresent('The AIG Building', false)

WebUI.verifyTextPresent('58 Fenchurch Street', false)

WebUI.verifyTextPresent('EC3M 4AB', false)

WebUI.verifyTextPresent('London', false)

WebUI.verifyTextPresent('United Kingdom', false)

WebUI.verifyTextPresent('Original Insured', false)

WebUI.verifyTextPresent('Address', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Addressline', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('PostCode', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('City', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Country', rowNumber), false)

WebUI.verifyTextPresent('Type of', false)

WebUI.verifyTextPresent('reinsurance', false)

WebUI.verifyTextPresent('Directors & Of', false)

WebUI.verifyTextPresent('icers Liability', false)

WebUI.verifyTextPresent('Facultative Reinsurance', false)

WebUI.verifyTextPresent('Excess of Loss', false)

WebUI.verifyTextPresent('Proportional', false)

WebUI.verifyTextPresent('Manual selection', false)

WebUI.verifyTextPresent('Reinsurance', false)

WebUI.verifyTextPresent('premium:', false)

WebUI.verifyTextPresent('EUR', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('TMHCCGrossPremium', rowNumber), false)

WebUI.verifyTextPresent('net of withholding tax, if applicable', false)

WebUI.verifyTextPresent('Premium Due Date:', false)

WebUI.verifyTextPresent('90 days f', false)

WebUI.verifyTextPresent('rom inception', false)

WebUI.verifyTextPresent('date indicated in', false)

WebUI.verifyTextPresent('ITEM', false)

WebUI.verifyTextPresent('1', false)

WebUI.verifyTextPresent('Reinsurance', false)

WebUI.verifyTextPresent('commission:', false)

WebUI.verifyTextPresent('%', false)

WebUI.verifyTextPresent('Retail brokerage', false)

WebUI.verifyTextPresent(':', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Commission', rowNumber), false)
//+'.00000'+'%'

WebUI.verifyTextPresent('liability', false)

WebUI.verifyTextPresent('Insurance', false)

WebUI.verifyTextPresent('EUR', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Layer EEL Limit', rowNumber)+'.00', false)

WebUI.verifyTextPresent('in the aggregate f', false)

WebUI.verifyTextPresent('or all insurance covers combined', false)

WebUI.verifyTextPresent('Reinsurance limit of', false)

WebUI.verifyTextPresent('liability', false)

WebUI.verifyTextPresent('EUR', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('TMHCC AGG Limit', rowNumber), false)

WebUI.switchToDefaultContent()

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)
