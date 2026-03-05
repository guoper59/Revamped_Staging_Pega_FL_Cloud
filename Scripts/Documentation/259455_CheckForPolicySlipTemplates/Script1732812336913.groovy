/**
 * ============================================================================
 * Test Case ID : 259455
 * Title         : Check For Policy Slip Templates
 * Folder        : Scripts/Documentation/259455_CheckForPolicySlipTemplates
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
import com.kms.katalon.core.testobject.TestObject as TestObject

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

//Click on the 'Create' button.
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

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
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// Enter broker details using the provided test data and row number.
SubmissionHelper.enterBrokerDetails(testData, rowNumber)

// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
// Enter details in General Data using the provided test data and row number.
SubmissionHelper.enterGeneralData(testData, rowNumber)

// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))
// Wait for the 'OK' element to be visible on the page.
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'), 
    60, FailureHandling.STOP_ON_FAILURE)

//Get the text of the 'sPolicyReference' element and store it in 'PolicyRef' variable.
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)

GlobalVariable.PolicyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

KeywordUtil.logInfo(GlobalVariable.PolicyRef)

//Click on the 'OK' element on the page.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))
//Uw Worksheet
// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBaseCurrencyCode'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBaseCurrencyCode'), 
    findTestData(testData).getValue('Original Currency', rowNumber), false)

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TMHCCWrittenParticipation'), 
    findTestData(testData).getValue('TMHCC Written Participation%', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerEELLimit'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerEELLimit'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerEELLimit'), findTestData(
        testData).getValue('Layer EEL Limit', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'), findTestData(
        testData).getValue('Layer AGG Limit', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'), 
    GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'), 
    findTestData(testData).getValue('Commission', rowNumber))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_PremiumCalculate'))

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

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ApplicableLaw'), 
    GlobalVariable.timeOutValue)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTerritorialScope'), 
    findTestData(testData).getValue('Territorial Scope', rowNumber), false)

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ApplicableLaw'), findTestData(
        testData).getValue('Applicable Law', rowNumber))

//Verifying the values
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

//Click on complete the quote.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CompleteQuote'))

//Get the text of a status element.
String qoutedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

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

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.clearText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), findTestData(testData).getValue('input_Lead', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), Keys.chord(Keys.BACK_SPACE))

String currentText =  findTestData(testData).getValue('input_Lead', rowNumber).substring(0, findTestData(testData).getValue('input_Lead', rowNumber).length()-1)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]), GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

//Click on continue.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector2', [('tabName') : 'Policy Docs']))

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

WebUI.verifyTextPresent('LOCAL', false)

WebUI.verifyTextPresent('POLICY DOCUMENT', false)

WebUI.verifyTextPresent('Directors’ and Officers’ Insurance', false)

WebUI.verifyTextPresent('PLEASE NOTE:', false)

WebUI.verifyTextPresent('THIS IS A CLAIMS MADE POLICY.', false)

WebUI.verifyTextPresent('THE COVER PROVIDED BY THIS LOCAL POLICY IS AFFORDED SOLELY WITH RESPECT TO', false)

WebUI.verifyTextPresent('CLAIMS', false)

WebUI.verifyTextPresent('FIRST', false)

WebUI.verifyTextPresent('MADE AGAINST AN', false)

WebUI.verifyTextPresent('INSURED', false)

WebUI.verifyTextPresent('DURING THE', false)

WebUI.verifyTextPresent('POLICY PERIOD', false)

WebUI.verifyTextPresent('OR ANY', false)

WebUI.verifyTextPresent('DISCOVERY PERIOD', false)

WebUI.verifyTextPresent('PURCHASED.', false)

WebUI.verifyTextPresent('THIS LOCAL POLICY IS PART OF AN INTERNATIONAL D&O INSURANCE PROGRAMME.', false)

WebUI.verifyTextPresent('THE', false)

WebUI.verifyTextPresent('LIMIT OF', false)

WebUI.verifyTextPresent('LIABILITY', false)

WebUI.verifyTextPresent('OF THIS LOCAL POLICY COULD BE PARTIALLY OR TOTALLY ERODED BY THE PAYMENTS', false)

WebUI.verifyTextPresent('MADE UNDER THE MASTER POLICY AND/OR ANY OTHER LOCAL POLICY (IF APPLICABLE) OF THE SAME', false)

WebUI.verifyTextPresent('INTERNATIONAL D&O INSURANCE PROGRAMME', false)

WebUI.verifyTextPresent('TO: TORRE', false)

WebUI.verifyTextPresent('DIAGONAL MAR,', false)

WebUI.verifyTextPresent('JOSEP PLA 2,', false)

WebUI.verifyTextPresent('PLANTA 10', false)

WebUI.verifyTextPresent('08019 BARCELONA, SPAIN', false)

WebUI.verifyTextPresent(GlobalVariable.PolicyRef, false)

WebUI.switchToDefaultContent()

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

String boundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

//Click On Continue button
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    findTestData(testData).getValue('Tax Applicable', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	findTestData(testData).getValue('Tax Code', rowNumber))

WebUI.clearText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']))

WebUI.setText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	findTestData(testData).getValue('Tax Code', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']), Keys.chord(Keys.BACK_SPACE))

currentText =  findTestData(testData).getValue('Tax Code', rowNumber).substring(0, findTestData(testData).getValue('Tax Code', rowNumber).length()-1)

WebUI.mouseOver(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.enhancedClick(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']), 
    findTestData(testData).getValue('Tax Premium', rowNumber))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'))

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
        [('tabName') : 'Policy Docs']), 10, FailureHandling.OPTIONAL)

//Get the text of a specific element on the web page.
String signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

//Wait for the 'Policy Docs' tab to be visible in the dynamic tab selector.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector', 
        [('tabName') : 'Policy Docs']), 10, FailureHandling.OPTIONAL)

//Get the text of a specific element on the web page.
signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

//Click on a dynamic tab selector for Policy Docs.
WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/button_ExpandItems_Frame1'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Endorsements/button_ExpandItems_Frame1'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/webElement_TabSelectorExpansion', [('tabName') : 'Policy Docs']),
	GlobalVariable.timeOutValue)

WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/webElement_TabSelectorExpansion', [('tabName') : 'Policy Docs']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Endorsements/webElement_TabSelectorExpansion', [('tabName') : 'Policy Docs']))

//Wait for a specific element to be visible within a specified timeout.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/link_Generate'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

//Click on a link to generate something.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/link_Generate'))

//Switch to a specific frame on the web page within a specified timeout.
WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Verifying Data Validation field names
List<WebElement> policyDocsName1 = WebUI.findWebElements(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_PolicyDocsOptions'), 
    GlobalVariable.timeOutValue)

List<WebElement> policyDocsOptionsList1 = new ArrayList<String>()

for (WebElement e : policyDocsName1) {
    policyDocsOptionsList1.add(e.getText())
}

GenericUtils.compareLists(policyDocsOptionsList1, expectedPolicyDocsList)

policyDocsName1.get(2).click()

WebUI.switchToDefaultContent()

WebUI.switchToDefaultContent()

SubmissionHelper.generateBrokerBind(testData, rowNumber)

WebUI.switchToWindowIndex(1)

WebUI.switchToFrame(findTestObject('Object Repository/Pega_CreateInsured/iframePdfViewer'), GlobalVariable.timeOutValue)

WebUI.verifyTextPresent('LOCAL', false)

WebUI.verifyTextPresent('POLICY DOCUMENT', false)

WebUI.verifyTextPresent('Directors’ and Officers’ Insurance', false)

WebUI.verifyTextPresent('PLEASE NOTE:', false)

WebUI.verifyTextPresent('THIS IS A CLAIMS MADE POLICY.', false)

WebUI.verifyTextPresent('THE COVER PROVIDED BY THIS LOCAL POLICY IS AFFORDED SOLELY WITH RESPECT TO', false)

WebUI.verifyTextPresent('CLAIMS', false)

WebUI.verifyTextPresent('FIRST', false)

WebUI.verifyTextPresent('MADE AGAINST AN', false)

WebUI.verifyTextPresent('INSURED', false)

WebUI.verifyTextPresent('DURING THE', false)

WebUI.verifyTextPresent('POLICY PERIOD', false)

WebUI.verifyTextPresent('OR ANY', false)

WebUI.verifyTextPresent('DISCOVERY PERIOD', false)

WebUI.verifyTextPresent('PURCHASED.', false)

WebUI.verifyTextPresent('THIS LOCAL POLICY IS PART OF AN INTERNATIONAL D&O INSURANCE PROGRAMME.', false)

WebUI.verifyTextPresent('THE', false)

WebUI.verifyTextPresent('LIMIT OF', false)

WebUI.verifyTextPresent('LIABILITY', false)

WebUI.verifyTextPresent('OF THIS LOCAL POLICY COULD BE PARTIALLY OR TOTALLY ERODED BY THE PAYMENTS', false)

WebUI.verifyTextPresent('MADE UNDER THE MASTER POLICY AND/OR ANY OTHER LOCAL POLICY (IF APPLICABLE) OF THE SAME', false)

WebUI.verifyTextPresent('INTERNATIONAL D&O INSURANCE PROGRAMME', false)

WebUI.verifyTextPresent('THE', false)

WebUI.verifyTextPresent('NAMED COMPANY', false)

WebUI.verifyTextPresent('IS REQUESTED TO READ THIS LOCAL POLICY AND SCHEDULE CAREFULLY. IF', false)

WebUI.verifyTextPresent('IT IS INCORRECT PLEASE RETURN IT IMMEDIATELY FOR ALTERATION', false)

WebUI.verifyTextPresent('TO: TORRE', false)

WebUI.verifyTextPresent('DIAGONAL MAR,', false)

WebUI.verifyTextPresent('JOSEP PLA 2,', false)

WebUI.verifyTextPresent('PLANTA 10', false)

WebUI.verifyTextPresent('08019 BARCELONA, SPAIN', false)

WebUI.verifyTextPresent('Local', false)

WebUI.verifyTextPresent('Policy No', false)

WebUI.verifyTextPresent(GlobalVariable.PolicyRef, false)

WebUI.switchToDefaultContent()

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

