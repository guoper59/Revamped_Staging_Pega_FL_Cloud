/**
 * ============================================================================
 * Test Case ID : 259917
 * Title         : Create New Bureau BLD Policy Lloyds4141
 * Folder        : Scripts/SmokeModifications/259917_CreateNewBureauBLDPolicyLloyds4141
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
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper as SubmissionHelper
import java.text.SimpleDateFormat as SimpleDateFormat
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

String pseudoCodeValue = findTestData(testData).getValue('Pseudo Code', rowNumber)
String inputLeadValue = findTestData(testData).getValue('input_Lead', rowNumber)

String testData = 'NewBusiness'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

String timeStamp = GenericUtils.getCurrentTimestamp()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Click on the 'Create' button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

//
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

//Wait for the 'Insured' element to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'))

SubmissionHelper.enterInsuredDetails(testData, rowNumber)

SubmissionHelper.selectReinsured(testData, rowNumber)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
        'Country', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']), 
    findTestData(testData).getValue('Broker', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : pseudoCodeValue]), 
    GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : pseudoCodeValue]))

WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : pseudoCodeValue]))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'), 
    findTestData(testData).getValue('Broker Contact', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'), 
    findTestData(testData).getValue('Class Type', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMajorClass'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMajorClass'), 
    findTestData(testData).getValue('Major Class', rowNumber), false)

WebUI.waitForElementNotHasAttribute(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement',
		[('fieldtoSelect') : labelName.get('majorClass1')]), 'disabled', 25)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement', 
        [('fieldtoSelect') : labelName.get('majorClass1')]), findTestData(testData).getValue('MajorClass1', rowNumber), 
    false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement', 
        [('fieldtoSelect') : labelName.get('minorClass1')]), findTestData(testData).getValue('MinorClass1', rowNumber), 
    false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement', 
        [('fieldtoSelect') : labelName.get('class1')]), findTestData(testData).getValue('Class1', rowNumber), false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement', 
        [('fieldtoSelect') : labelName.get('majorClass2')]), findTestData(testData).getValue('MajorClass2', rowNumber), 
    false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement', 
        [('fieldtoSelect') : labelName.get('minorClass2')]), findTestData(testData).getValue('MinorClass2', rowNumber), 
    false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement', 
        [('fieldtoSelect') : labelName.get('class2')]), findTestData(testData).getValue('Class2', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'), 
    findTestData(testData).getValue('Placing Type', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownSubPlacingType'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownSubPlacingType'), 
    findTestData(testData).getValue('Sub Placing Type', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwriter'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwriter'), 
    findTestData(testData).getValue('Underwriter', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant'), 
    findTestData(testData).getValue('Underwriting Assistant', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownProducingTeam'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownProducingTeam'), 
    findTestData(testData).getValue('Producing Team', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'))

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'), findTestData(
        testData).getValue('Inception Date', rowNumber))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'), 
    findTestData(testData).getValue('Entity', rowNumber), false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'), 
    findTestData(testData).getValue('Legal Branch', rowNumber), false)

String expirationDate = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_FieldName', [('fieldName') : 'Expiry Date ']), 
    'value')

GlobalVariable.ExpirationDate = expirationDate

String caseID = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseID'))

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_SkipQouteIndicator'), GlobalVariable.timeOutValue)

String currentDate = new SimpleDateFormat('dd/MM/yyyy').format(Calendar.getInstance().time)

//
//
//
//
//
//
//
//
//

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 60)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

// Wait for the 'OK' element to be visible on the page.
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'), 
    GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Get the text of the 'sPolicyReference' element and store it in 'PolicyRef' variable.
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)

GlobalVariable.PolicyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

KeywordUtil.logInfo(GlobalVariable.PolicyRef)

//Click on the 'OK' element on the page.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

//Enter details in Uw worksheet
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'), 
    findTestData(testData).getValue('UW Authority', rowNumber), false)

//
//
//
//
//
//
//                , ('fieldName') : i + '$ppyNote']))
//
//
//                , ('fieldName') : i + '$ppyNote']), payableToList[(i - 1)], false)
//
//
//
//                , ('fieldName') : i + '$pFeeType']))
//
//
//                , ('fieldName') : i + '$pFeeType']), feeTypeList[(i - 1)], false)
//
//
//                , ('fieldName') : i + '$pFeePercentage']), GlobalVariable.timeOutValue)
//
//
//                , ('fieldName') : i + '$pFeePercentage']), feePercentList[(i - 1)])
//

SubmissionHelper.enterDetailsUWSheet(testData, rowNumber)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'), 
    findTestData(testData).getValue('IsTacitRenewal', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TacItRenewalDate'), 
    findTestData(testData).getValue('Tacit Renewal Date', rowNumber))

String layerGrossPremium = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Layer Gross Premium ']), 'value')

GenericUtils.verifyMatch('Layer Gross Premium Value is', layerGrossPremium, findTestData(testData).getValue('Layer Gross Premium', 
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

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', [('fieldToEnter') : labelName.get(
                'premiumPercent1')]))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', 
        [('fieldToEnter') : labelName.get('premiumPercent1')]), findTestData(testData).getValue('PremiumPercentage1', rowNumber))

WebUI.selectOptionByValue(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement', 
        [('fieldtoSelect') : labelName.get('llyodsRiskCode1')]), findTestData(testData).getValue('LlyodsRiskCode1', rowNumber), 
    false)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', 
        [('fieldToEnter') : labelName.get('premiumPercent2')]), findTestData(testData).getValue('PremiumPercentage2', rowNumber))

WebUI.selectOptionByValue(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement', 
        [('fieldtoSelect') : labelName.get('llyodsRiskCode2')]), findTestData(testData).getValue('LlyodsRiskCode2', rowNumber), 
    false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'ADR Exposure ']), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', [('dropDownLabel') : 'ADR Exposure ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'ADR Exposure ']), findTestData(testData).getValue('ADR Exposure', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'ADR Exposure ']), Keys.chord(Keys.TAB))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Local Market Cap ']))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Local Market Cap ']), 
    findTestData(testData).getValue('Local Market Cap', rowNumber))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Entity’s Total Assets ']))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Entity’s Total Assets ']), 
    findTestData(testData).getValue('Entity’s Total Assets', rowNumber))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Policy Holder Revenue/Turn Over/Fee Income ']))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Policy Holder Revenue/Turn Over/Fee Income ']), 
    findTestData(testData).getValue('Policy Holder Revenue/Turn Over/Fee Income', rowNumber))

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_TotalAssetsValue'))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_TotalAssetsValue'), findTestData(testData).getValue(
        'Entity’s Total Assets', rowNumber))

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_PolicyHolderValue'))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_PolicyHolderValue'), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_PolicyHolderValue'), findTestData(testData).getValue(
        'Policy Holder Revenue/Turn Over/Fee Income', rowNumber))

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'))
 
 
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'),
	findTestData(testData).getValue('CryptoExposure', rowNumber), false)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.clearText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), inputLeadValue)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), Keys.chord(Keys.BACK_SPACE))

String currentText =  inputLeadValue.substring(0, inputLeadValue.length()-1)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]), GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckboxLabelBefore', 
        [('labelName') : 'FAC Out Indicator']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckboxLabelBefore', 
        [('labelName') : 'No Claim Bonus']), GlobalVariable.timeoutShort)

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Primary Total Layer Limit'])).isEmpty()) {
    KeywordUtil.logInfo('Primary Total Layer Limit is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Primary Total Layer Premium'])).isEmpty()) {
    KeywordUtil.logInfo('Primary Total Layer Premium is empty')
}

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

////Click on continue.
//TODO: 540274: Remove the Quote Doc and Broker Bind Doc stage from the Pega data entry workflow

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', 
        [('fieldToEnter') : labelName.get('brokerRefernce')]), findTestData(testData).getValue('BrokerReference', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', 
        [('fieldToEnter') : labelName.get('benchmarkLossRatio')]), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', 
        [('fieldToEnter') : labelName.get('benchmarkLossRatio')]), findTestData(testData).getValue('SBF Benchmark Loss Ratio', 
        rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    GlobalVariable.timeoutShort)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
        testData).getValue('Due Date', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
        Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

//Status Validations to be added
String uwQCStatus = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_UWQCStatus'))

GenericUtils.verifyMatch('UW QC Status is', uwQCStatus, 'To Be Approved', 'EQUAL')

//
////Verifying if Order Form is available in the attachment
//
//
//
//

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']), 
    10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/button_PostBindSettlement'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_PostBindSettlement'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_PostBindSettlement'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_FinalisePolicy'), 
    60)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_FinalisePolicy'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_Proceed'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_Proceed'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Status', 
        [('status') : 'Written']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Status', 
        [('status') : 'Written']), GlobalVariable.timeOutValue)