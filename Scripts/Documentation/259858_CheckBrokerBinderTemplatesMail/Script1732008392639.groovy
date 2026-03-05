/**
 * ============================================================================
 * Test Case ID : 259858
 * Title         : Check Broker Binder Templates Mail
 * Folder        : Scripts/Documentation/259858_CheckBrokerBinderTemplatesMail
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

rowNumberforTestData = rowNumber

KeywordUtil.logInfo(GlobalVariable.testCaseID)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

SubmissionHelper.enterInsuredDetails(testData, rowNumber)

WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'No']))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 25)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

SubmissionHelper.enterBrokerDetails(testData, rowNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 25)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

SubmissionHelper.enterGeneralData(testData, rowNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 25)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'), 
    GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

String policyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

KeywordUtil.logInfo(policyRef)

GlobalVariable.PolicyRef = policyRef

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))
//Uw Worksheet
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

SubmissionHelper.enterDetailsUWSheet(testData, rowNumber)

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

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CompleteQuote'))

String qoutedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

KeywordUtil.logInfo(qoutedStatus)
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

String openBoundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

KeywordUtil.logInfo(openBoundStatus)

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

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Assets Under Management (AUM)']))

WebUI.click(findTestObject('Object Repository/Documentation/btn_Save'))

String boundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

KeywordUtil.logInfo(boundStatus)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_GenerateBrokerBind'),
	GlobalVariable.timeoutShort)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_GenerateBrokerBind'),
	20)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_GenerateBrokerBind'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'Select Format']), rowNumber)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', [('dropDownLabel') : 'Select Format']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'Select Format']), findTestData(testData).getValue('Email', rowNumber), false)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'Select Language']), rowNumber)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', [('dropDownLabel') : 'Select Language']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'Select Language']), findTestData(testData).getValue('Language', rowNumber), false)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'Select Template']), rowNumber)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', [('dropDownLabel') : 'Select Template']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'Select Template']), findTestData(testData).getValue('Template', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/button_Submit'),60)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Submit'))

// Switch to the new window (assuming it's the second one)
WebUI.switchToWindowIndex(1)

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_SendMailLabel'), GlobalVariable.timeOutValue)

//Verifying Data Validation field names
List<WebElement> emailHeaderName = WebUI.findWebElements(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ListMailHeader'), 
    GlobalVariable.timeOutValue)

List<WebElement> emailHeaderList = new ArrayList<String>()

for (WebElement e : emailHeaderName) {
    emailHeaderList.add(e.getText())
}

GenericUtils.compareLists(emailHeaderList, expectedHeaderList)

String mailContentHeaderText = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_MailHeaderMessage'))

List<WebElement> emailContentName = WebUI.findWebElements(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_MailValueContent'), 
    GlobalVariable.timeOutValue)

List<WebElement> FinalList = emailContentName.subList(0, 10)

List<WebElement> emailContentList = new ArrayList<String>()

for (WebElement e : FinalList) {
    if (!(e.getText().equals(''))) {
        emailContentList.add(e.getText())
    }
}

WebUI.verifyTextPresent('Policyholder Address:', false)

WebUI.verifyTextPresent('We are pleased to confirm the terms of our binding agreement as follows:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Addressline', rowNumber), false)

WebUI.verifyTextPresent((findTestData(testData).getValue('PostCode', rowNumber) + ' ') + findTestData(testData).getValue(
        'City', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Country', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Broker', rowNumber), false)

WebUI.verifyTextPresent('Continuity Date:', false)

WebUI.verifyTextPresent('Retroactive Date:', false)

WebUI.verifyTextPresent('Layer:', false)

WebUI.verifyTextPresent('1st Excess', false)

WebUI.verifyTextPresent('Currency:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Original Currency', rowNumber), false)

WebUI.verifyTextPresent('Layer Limit:', false)

WebUI.verifyTextPresent('Underlying Limit (if applicable):', false)

WebUI.verifyTextPresent('Premium for the Policy Period:', false)

WebUI.verifyTextPresent('Lead Insurer:', false)

WebUI.verifyTextPresent('Share:', false)

WebUI.verifyTextPresent('Limit of Liability:', false)

WebUI.verifyTextPresent('Broker Commission:', false)

WebUI.verifyTextPresent('Broker:', false)

WebUI.verifyTextPresent('10,000.00 plus applicable insurance premium tax', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Entity', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('TMHCC Written Participation%', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('TMHCC EEL Limit', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Commission', rowNumber), false)

WebUI.verifyTextPresent('Insurer:', false)

WebUI.verifyTextPresent((((findTestData(testData).getValue('Entity', rowNumber) + ' ') + 'S.A.') + ' ') + findTestData(testData).getValue(
        'Legal Branch', rowNumber), false)

WebUI.verifyTextPresent('Torre Diagonal Mar, Josep Pla 2, Planta 10', false)

WebUI.verifyTextPresent('08019 Barcelona, Spain', false)

//Perform actions 
WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

//Validations for Emial 
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    findTestData(testData).getValue('Tax Applicable', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	findTestData(testData).getValue('Tax code', rowNumber))

WebUI.clearText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']))

WebUI.setText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	findTestData(testData).getValue('Tax code', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']), Keys.chord(Keys.BACK_SPACE))

String currentText =  findTestData(testData).getValue('Tax code', rowNumber).substring(0, findTestData(testData).getValue('Tax code', rowNumber).length()-1)

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

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions', 
        [('linkToClick') : 'Bind Policy']), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions', [('linkToClick') : 'Bind Policy']))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector', 
        [('tabName') : 'Policy Docs']), 10, FailureHandling.STOP_ON_FAILURE)

String signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

KeywordUtil.logInfo(signedStatus)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector', [('tabName') : 'Policy Docs']))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/link_Generate'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/link_Generate'))

WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Verifying Data Validation field names
List<WebElement> policyDocsName = WebUI.findWebElements(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_PolicyDocsOptions'), 
    GlobalVariable.timeOutValue)

List<WebElement> policyDocsOptionsList = new ArrayList<String>()

for (WebElement e : policyDocsName) {
    policyDocsOptionsList.add(e.getText())
}

GenericUtils.compareLists(policyDocsOptionsList, expectedPolicyDocsList)

List<WebElement> expectedContentList = new ArrayList<String>()

expectedContentList.add('Policy Number:')

expectedContentList.add(GlobalVariable.PolicyRef)

expectedContentList.add('Line of Business:')

expectedContentList.add(GlobalVariable.LineOfBusiness)

expectedContentList.add('Policyholder:')

expectedContentList.add(GlobalVariable.insuredName)

expectedContentList.add('Inception Date:')

expectedContentList.add(GlobalVariable.InceptionDate)

expectedContentList.add('Expiration Date:')

expectedContentList.add(GlobalVariable.ExpirationDate)

GenericUtils.compareLists(emailContentList, expectedContentList)