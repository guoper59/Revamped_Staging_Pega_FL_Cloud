/**
 * ============================================================================
 * Test Case ID : 262197
 * Title         : Create Outwards FAC Policy
 * Folder        : Scripts/OutwardsFACRI/262197_CreateOutwardsFACPolicy
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
import org.openqa.selenium.WebElement as WebElement
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

String timeStamp = GenericUtils.getCurrentTimestamp()

String inceptionDate = GenericUtils.getCurrentDate()

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

//Logging in with Underwriter
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Clicking on Create Button
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'), 
    10, FailureHandling.STOP_ON_FAILURE)

//Searching for Insured
WebUI.setText(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Search Name']), insuredName)

//Clicking on Search Button
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_SearchName'))

//Selecting the correct insured name from the list
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_SelectFromList', [('fieldName') : 'Insured Name'
            , ('insuredName') : insuredName]))

//Reading Values
String addressLine1 = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_ReadInsuredInformation', 
        [('fieldName') : 'Address line']))

GenericUtils.verifyMatch('Address Line1 is ::', addressLine1, expectedAddress, 'EQUAL')

String postCode = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_ReadInsuredInformation', [('fieldName') : 'Post Code']))

GenericUtils.verifyMatch('Post Code is ::', postCode, expectedPostCode, 'EQUAL')

String city = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_ReadInsuredInformation', [('fieldName') : 'City']))

GenericUtils.verifyMatch('City is ::', city, expectedCity, 'EQUAL')

String country = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_ReadInsuredInformation', [('fieldName') : 'Country']))

GenericUtils.verifyMatch('Country is ::', country, expectedCountry, 'EQUAL')

String NAICDivision = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_ReadInsuredInformation', 
        [('fieldName') : 'NAIC Division']))

GenericUtils.verifyMatch('NAIC Division is ::', NAICDivision, expectedNAICDivision, 'EQUAL')

String NAICDescription = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_ReadInsuredInformation', 
        [('fieldName') : 'NAIC Description']))

GenericUtils.verifyMatch('NAIC Description is ::', NAICDescription, expectedNAICDescription, 'EQUAL')

String privateValue = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_ReadInsuredInformation', 
        [('fieldName') : 'Public/Private']))

GenericUtils.verifyMatch('Public/Private is ::', privateValue, expectedPrivateValue, 'EQUAL')

String status = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_ReadInsuredInformation', [('fieldName') : 'Status']))

GenericUtils.verifyMatch('Status is ::', status, expectedStatus, 'EQUAL')

WebUI.waitForElementPresent(findTestObject('Object Repository/OutwardsPolicy/radio_DynamicRadioButton', [('radioButtonLabel') : 'No']), 
    GlobalVariable.timeOutValue)

//Validations to be added
WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/radio_DynamicRadioButton', [('radioButtonLabel') : 'No']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Continue'))

//Entering required fields for No Broker option
WebUI.waitForElementPresent(findTestObject('Object Repository/OutwardsPolicy/radio_DynamicRadioButton', [('radioButtonLabel') : 'No Broker']), 
    GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/radio_DynamicRadioButton', [('radioButtonLabel') : 'No Broker']))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Direct']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Direct']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Direct']), 
    findTestData(testData).getValue('NoBrokerOption', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_FieldName', [('fieldName') : 'Name ']), findTestData(
        testData).getValue('Name', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_FieldName', [('fieldName') : 'Email ']), findTestData(
        testData).getValue('Email', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_FieldName', [('fieldName') : 'Job Position ']), findTestData(
        testData).getValue('JobPosition', rowNumber))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Continue'))

//Entering general data
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Class Type ']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Class Type ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Class Type ']), 
    findTestData(testData).getValue('ClassType', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Major Class ']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Major Class ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Major Class ']), 
    findTestData(testData).getValue('MajorClass', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Minor Class ']), 
    60)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Minor Class ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Minor Class ']), 
    findTestData(testData).getValue('MinorClass', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Sub Placing Type ']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Sub Placing Type ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Sub Placing Type ']), 
    findTestData(testData).getValue('SubPlacingType', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Underwriter ']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Underwriter ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Underwriter ']), 
    findTestData(testData).getValue('Underwriter', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Underwriting Assistant ']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Underwriting Assistant ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Underwriting Assistant ']), 
    findTestData(testData).getValue('UnderwritingAssistant', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Producing Team ']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Producing Team ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Producing Team ']), 
    findTestData(testData).getValue('ProducingTeam', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Inception Date ']), 
    GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Inception Date ']), 
    findTestData(testData).getValue('InceptionDate', rowNumber))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Entity ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Entity ']), 
    findTestData(testData).getValue('Entity', rowNumber), false)

WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Legal Branch ']), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Legal Branch ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Legal Branch ']), 
    findTestData(testData).getValue('LegalBranch', rowNumber), false)

String policyPeriod = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Policy Period ']), 
    'value')

GenericUtils.verifyMatch('Policy period is', policyPeriod, findTestData(testData).getValue('PolicyPeriod', rowNumber), 'EQUAL')

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_ContinueGeneral'), 60)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_ContinueGeneral'))

if (WebUI.verifyElementPresent(findTestObject('Object Repository/OutwardsPolicy/button_AllowSubmission'), 25, 
    FailureHandling.OPTIONAL)) {
	WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_AllowSubmission'), 60)
    WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_AllowSubmission'))
	WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_AllowSubmission'), FailureHandling.OPTIONAL)
	
} else {
    KeywordUtil.logInfo('There is no duplicate submission for this criteria')
}

WebUI.waitForElementPresent(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyReference'), 180)

String policyRef = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyReference'))

KeywordUtil.logInfo(policyRef)

GlobalVariable.PolicyRef = policyRef
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_OK'), 60)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_OK'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Continue'))

//Entering the required data
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Original Currency ']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Original Currency ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Original Currency ']), 
    findTestData(testData).getValue('OriginalCurrency', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'TMHCC Written Participation %']), 
    findTestData(testData).getValue('WrittenParticipation', rowNumber))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_LimitInformation', [('headerName') : 'Layer EEL Limit']))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/webElement_LimitInformation', [('headerName') : 'Layer EEL Limit']), 
    findTestData(testData).getValue('EelLimit', rowNumber))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_LimitInformation', [('headerName') : 'Layer AGG Limit']))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/webElement_LimitInformation', [('headerName') : 'Layer AGG Limit']), 
    findTestData(testData).getValue('AggLimit', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/radio_LimitInformationOptions', [('labelName') : 'Reinstatements']), 
    GlobalVariable.timeOutValue)

WebUI.scrollToElement(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Reinstatements']), GlobalVariable.timeoutShort)

WebUI.check(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Reinstatements']))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_ReinstatementsOption', [('headerName') : 'ReinstatementType']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_ReinstatementsOption', [('headerName') : 'ReinstatementType']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/webElement_ReinstatementsOption', [('headerName') : 'ReinstatementType']), 
    findTestData(testData).getValue('ReinstatementType', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_ReinstatementsOption', [('headerName') : 'No. Of Reinstatements']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_ReinstatementsOption', [('headerName') : 'No. Of Reinstatements']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/webElement_ReinstatementsOption', [('headerName') : 'No. Of Reinstatements']), 
    findTestData(testData).getValue('NoOfReinstatements', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Commission % ']), 
    findTestData(testData).getValue('Commission', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Layer Gross Premium ']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Layer Gross Premium ']))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Layer Gross Premium ']), 
    findTestData(testData).getValue('GrossPremium', rowNumber))
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']), 
    findTestData(testData).getValue('TerritorialScope', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Applicable Law ']), 
    findTestData(testData).getValue('ApplicableLaw', rowNumber))

//Verifying the values
String orderValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Order %']), 
    'value')

GenericUtils.verifyMatch('Order Value is', orderValue, findTestData(testData).getValue('Order%', rowNumber), 'EQUAL')

String estimatedSigningValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', 
        [('labelName') : 'Estimated Signing %']), 'value')

GenericUtils.verifyMatch('Estimated Signing Value is', estimatedSigningValue, findTestData(testData).getValue('Estimated Signing %', 
        rowNumber), 'EQUAL')

String calculatedLineValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [
            ('labelName') : 'Calculated Line %']), 'value')

GenericUtils.verifyMatch('Calculated line Value is', calculatedLineValue, findTestData(testData).getValue('Calculated Line %', 
        rowNumber), 'EQUAL')

String tmhccLimitValue = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_ReadLimitInformation', 
        [('headerName') : 'TMHCC EEL Limit']))

GenericUtils.verifyMatch('TMHCC EEL Limit Value is', tmhccLimitValue, findTestData(testData).getValue('TMHCC EEL Limit', 
        rowNumber), 'EQUAL')

String tmhccAggLimitValue = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_ReadLimitInformation', 
        [('headerName') : 'TMHCC AGG Limit']))

GenericUtils.verifyMatch('TMHCC Agg Limit Value is', tmhccAggLimitValue, findTestData(testData).getValue('TMHCC AGG Limit', 
        rowNumber), 'EQUAL')

String layerCommissionValue = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'Layer Broker Commission Amount']))

GenericUtils.verifyMatch('Layer Commission Value is', layerCommissionValue, findTestData(testData).getValue('LayerBrokerCommissionAmount', 
        rowNumber), 'EQUAL')

String tmhccBrokerCommissionValue = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Broker Commission Amount']))

GenericUtils.verifyMatch('TMHCC Broker Commission Value is', tmhccBrokerCommissionValue, findTestData(testData).getValue(
        'TMHCCBrokerCommissionAmount', rowNumber), 'EQUAL')

String tmhccGrossPremium = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Gross Premium']))

GenericUtils.verifyMatch('TMHCC Gross Premium Value is', tmhccGrossPremium, findTestData(testData).getValue('TMHCCGrossPremium', 
        rowNumber), 'EQUAL')

String tmhccNetPremium = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Net Premium']))

GenericUtils.verifyMatch('TMHCC Net Premium Value is', tmhccNetPremium, findTestData(testData).getValue('TMHCCNetPremium', 
        rowNumber), 'EQUAL')

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_CompleteQuote'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Continue'), GlobalVariable.timeOutValue)

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

//Entering the required details
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']), 
    findTestData(testData).getValue('UWAuthority', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'IsTacit Renewal']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'IsTacit Renewal']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'IsTacit Renewal']), 
    findTestData(testData).getValue('TacitRenewal', rowNumber), false)
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Cyber Coverage ']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Cyber Coverage ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Cyber Coverage ']), 
    findTestData(testData).getValue('CyberCoverage', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/radio_LimitInformationOptions', [('labelName') : 'FAC Out Indicator']), 
    GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/radio_LimitInformationOptions', [('labelName') : 'FAC Out Indicator']))

WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'ADR Exposure ']), 25)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'ADR Exposure ']), 
    25)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'ADR Exposure ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'ADR Exposure ']), 
    findTestData(testData).getValue('ADRExposure', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Local Market Cap ']), 
    25)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Entity’s Total Assets ']),
	25)

WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Entity’s Total Assets ']),
	25)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Entity’s Total Assets ']))

WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Local Market Cap ']), 25)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Local Market Cap ']))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Local Market Cap ']), 
    findTestData(testData).getValue('LocalMarketCap', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Entity’s Total Assets ']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Entity’s Total Assets ']))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Entity’s Total Assets ']), 
    findTestData(testData).getValue('EntityTotalAsset', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Policy Holder Revenue/Turn Over/Fee Income ']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Policy Holder Revenue/Turn Over/Fee Income ']))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Policy Holder Revenue/Turn Over/Fee Income ']), 
    findTestData(testData).getValue('PolicyHolderRevenue', rowNumber))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_ContinueGeneral'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_OtherActions'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_OtherActionsOption', [('optionToSelect') : 'Create FAC RI Case']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Fac RI Order Form Case']))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : 'Broker Company ']), 
    GlobalVariable.timeoutShort)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : 'Broker Company ']), 
    findTestData(testData).getValue('Name', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : 'Email Address']), 
    findTestData(testData).getValue('Email', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : 'Broker Contact']), 
    findTestData(testData).getValue('JobPosition', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/radio_ThirPartyBroker', [('labelName') : '3rd party broker?']), 
    GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/radio_ThirPartyBroker', [('labelName') : '3rd party broker?']))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : 'Deductions(%)']), 
    findTestData(testData).getValue('Deductions', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/input_NewDynamicValues', [('labelName') : 'Settlement Due Date']), 
    GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_NewDynamicValues', [('labelName') : 'Settlement Due Date']), 
    findTestData(testData).getValue('SettlementDate', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/input_NewDynamicValues', [('labelName') : 'Settlement of Fac amount ']), 
    GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_NewDynamicValues', [('labelName') : 'Settlement of Fac amount ']), 
    findTestData(testData).getValue('SettlementDate', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : 'RI Layer Premium Rate ']), 
    findTestData(testData).getValue('PremiumRate', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : '% Of Signed Line / Reinsured Amount ']), 
    findTestData(testData).getValue('ReinsuredAmount', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/webElement_InputSecurityInfoField', [('fieldName') : 'Security' , ('index') : 1]), 
    findTestData(testData).getValue('Security', rowNumber))

//added extra clear text and sendkey as sometimes first time sendkeys does not work
WebUI.clearText(findTestObject('Object Repository/OutwardsPolicy/webElement_InputSecurityInfoField', [('fieldName') : 'Security' , ('index') : 1]))
WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/webElement_InputSecurityInfoField', [('fieldName') : 'Security' , ('index') : 1]),
	findTestData(testData).getValue('Security', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_AutoCompleteResult', [('optionToSelect') : securityfieldvalueValue]), GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/OutwardsPolicy/webElement_AutoCompleteResult', [('optionToSelect') : securityfieldvalueValue]))

WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/webElement_AutoCompleteResult', [('optionToSelect') : securityfieldvalueValue]))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/webElement_InputSecurityInfoField', [('fieldName') : 'Percentage', ('index') : 1]), 
    findTestData(testData).getValue('Percentage', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_FacilitiesDropDown'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_FacilitiesDropDown'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/webElement_FacilitiesDropDown'), findTestData(
        testData).getValue('Facilities', rowNumber), false)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_InputSecurityInfoField', [('fieldName') : 'Percentage', ('index') : 2]))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/webElement_InputSecurityInfoField', [('fieldName') : 'Percentage', ('index') : 2]), 
    findTestData(testData).getValue('Percentage', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/text_CommentsSection', [('commentField') : 'Internal']), 
    findTestData(testData).getValue('Comments', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/text_CommentsSection', [('commentField') : 'External']), 
    findTestData(testData).getValue('Comments', rowNumber))

//Verifying values are correct
String facCaseID = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_FacCaseID'))

KeywordUtil.logInfo('FAC Case ID : '+facCaseID)
String originalAssuredValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [
            ('fieldName') : 'Original Assured']), 'value')

String originalPeriodValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : 'Original Period ']), 
    'value')

GenericUtils.verifyMatch('Original Period Value is', originalPeriodValue, findTestData(testData).getValue('Original Period', 
        rowNumber), 'EQUAL')

String layerLimitValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : 'Layer Limit']), 
    'value')

GenericUtils.verifyMatch('Layer Limit Value is', layerLimitValue, findTestData(testData).getValue('Layer Limit', rowNumber), 
    'EQUAL')

String layerPremiumValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : 'Layer Premium ']), 
    'value')

GenericUtils.verifyMatch('Layer Premium Value is', layerPremiumValue, findTestData(testData).getValue('LayerPremium', rowNumber), 
    'EQUAL')

String estSigningValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : 'Est signing (%) ']), 
    'value')

GenericUtils.verifyMatch('Est Signing Value is', estSigningValue, findTestData(testData).getValue('EstSigning', rowNumber), 
    'EQUAL')

String deductionsValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : 'Deductions(%)']), 
    'value')

GenericUtils.verifyMatch('Deductions Value is', deductionsValue, findTestData(testData).getValue('Deductions', rowNumber), 
    'EQUAL')

String settlementDateValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : 'Settlement Due Date']), 
    'value')

GenericUtils.verifyMatch('Settlement Due Date Value is', settlementDateValue, findTestData(testData).getValue('SettlementDueDate', 
        rowNumber), 'EQUAL')

String settlementAmountValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', 
        [('fieldName') : 'Settlement of Fac amount ']), 'value')

GenericUtils.verifyMatch('Settlement Amount Value is', settlementAmountValue, findTestData(testData).getValue('SettlementAmount', 
        rowNumber), 'EQUAL')

String riLimitValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : 'Layer RI Limit ']), 
    'value')

GenericUtils.verifyMatch('Layer RI Limit Value is', riLimitValue, findTestData(testData).getValue('LayerRiLimit', rowNumber), 
    'EQUAL')

String riPremiumValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : 'RI Layer Premium Rate ']), 
    'value')

GenericUtils.verifyMatch('Layer Premium Value is', riPremiumValue, findTestData(testData).getValue('LayerRiPremium', rowNumber), 
    'EQUAL')

String signedLineValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_NewFieldName', [('fieldName') : '% Of Signed Line / Reinsured Amount ']), 
    'value')

GenericUtils.verifyMatch('Signed Line Value is', signedLineValue, findTestData(testData).getValue('SignedLine', rowNumber), 
    'EQUAL')

String originalInterestValue = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_FacTextValue', 
        [('fieldName') : 'Original Interest ']))

GenericUtils.verifyMatch('Original Interest Value is', originalInterestValue, findTestData(testData).getValue('OriginalInterest', 
        rowNumber), 'EQUAL')

String riInterestValue = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_FacTextValue', [('fieldName') : 'RI Interest ']))

GenericUtils.verifyMatch('RI Interest Value is', riInterestValue, findTestData(testData).getValue('RiInterest', rowNumber), 
    'EQUAL')

String riPeriodValue = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_FacTextValue', [('fieldName') : 'RI Period ']))

GenericUtils.verifyMatch('RI Period Value is', riPeriodValue, findTestData(testData).getValue('RiPeriod', rowNumber), 'EQUAL')

String warningMessage = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_WarningMessage'))

GenericUtils.verifyMatch('Warning Message Value is', warningMessage, findTestData(testData).getValue('WarningMessage', rowNumber), 
    'EQUAL')

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_FacQualityCheck'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))

WebUI.callTestCase(findTestCase('Test Cases/OutwardsFACRI/262197_CreateOutwardsFACPolicy1'), null, FailureHandling.STOP_ON_FAILURE)