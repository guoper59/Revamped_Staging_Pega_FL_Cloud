/**
 * ============================================================================
 * Test Case ID : 259914
 * Title         : Create Renewal Non Bureau Proportional Facility Cyber
 * Folder        : Scripts/Renewals/259914_CreateRenewalNonBureauProportionalFacilityCyber
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

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/TestData/259914_CreatePolicy'), [('testData') : testData, ('rowNumber') : rowNumber], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_OK'))

//Enter details in Uw worksheet
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'), 
    findTestData(testData).getValue('UW Authority', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBaseCurrencyCode'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBaseCurrencyCode'), 
    findTestData(testData).getValue('Original Currency', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TMHCCWrittenParticipation'), 
    findTestData(testData).getValue('TMHCC Written Participation%', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TMHCCWrittenParticipation'), 
    Keys.chord(Keys.TAB))

//Validate the TMHCC Signed Participation and Calculated Line % values.
List<WebElement> calculatedValues = WebUI.findWebElements(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_TMHCCSignedParticipation'), 
    GlobalVariable.timeoutShort)

WebUI.switchToFrame(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/iframe_PegaGadget1Ifr'), 
    GlobalVariable.timeoutShort)

for (int i = 0; i < (calculatedValues.size() - 1); i++) {
    String THMCCSigned_Actual = calculatedValues.get(i).getAttribute('value')

    GenericUtils.verifyMatch('TMHCC Signed Participation & Calculated Line value is ', THMCCSigned_Actual, findTestData(
            testData).getValue('TMHCC Written Participation%', rowNumber) + '.00000', 'EQUAL')
}

WebUI.switchToDefaultContent()

//Enter Commission value
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'), 
    GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'), 
    findTestData(testData).getValue('Commission', rowNumber))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_PremiumCalculate'))

for (int i = 1; i < 2; i++) {
    WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_OtherCommisionAddItem'), GlobalVariable.timeOutValue)

    WebUI.click(findTestObject('Object Repository/NewBusiness/button_OtherCommisionAddItem'))

    WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', 
            [('headerName') : 'Payable To', ('fieldName') : i + '$ppyNote']), GlobalVariable.timeOutValue)

    WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', [('headerName') : 'Payable To'
                , ('fieldName') : i + '$ppyNote']))

    WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', [('headerName') : 'Payable To'
                , ('fieldName') : i + '$ppyNote']), payableToList[(i - 1)], false)

    WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', 
            [('headerName') : 'Fee Type', ('fieldName') : i + '$pFeeType']), GlobalVariable.timeOutValue)

    WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', [('headerName') : 'Fee Type'
                , ('fieldName') : i + '$pFeeType']))

    WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', [('headerName') : 'Fee Type'
                , ('fieldName') : i + '$pFeeType']), feeTypeList[(i - 1)], false)

    WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
                , ('fieldName') : i + '$pFeePercentage']), GlobalVariable.timeOutValue)

    WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
                , ('fieldName') : i + '$pFeePercentage']), feePercentList[(i - 1)])

    WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
                , ('fieldName') : i + '$pFeePercentage']), Keys.chord(Keys.TAB))
}

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'), 
    findTestData(testData).getValue('IsTacitRenewal', rowNumber), false)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Cyber War Exclusions']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Cyber War Exclusions']), 
    findTestData(testData).getValue('Cyber Coverage', rowNumber), false)

String layerGrossPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'Layer Gross Premium ']))

GenericUtils.verifyMatch('Layer Gross Premium Value is', layerGrossPremium, layerGrossPremiumValue, 'EQUAL')

String layerNetPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'Layer Net Premium ']))

GenericUtils.verifyMatch('Layer Net Premium Value is', layerNetPremium, layerNetPremiumValue, 'EQUAL')

String tmhccGrossPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Gross Premium']))

GenericUtils.verifyMatch('TMHCC Gross Premium Value is', tmhccGrossPremium, tmhccGrossPremiumValue, 'EQUAL')

String tmhccNetPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Net Premium']))

GenericUtils.verifyMatch('TMHCC Net Premium Value is', tmhccNetPremium, tmhccNetPremiumValue, 'EQUAL')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    findTestData(testData).getValue('Tax Applicable', rowNumber), false)

SubmissionHelper.enterTaxDetails(testData, rowNumber)

WebUI.closeBrowser()

WebUI.openBrowser(null)

WebUI.maximizeWindow()

String renewedPolicy = WebUI.callTestCase(findTestCase('Test Cases/TestData/RenewalAgent'), [('testData') : testData, ('rowNumber') : rowNumber], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser(null)

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData).getValue('Role', rowNumber))

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

WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue)

if (WebUI.verifyTextPresent(findTestData(testData).getValue('VariousInsured', rowNumber), false)) {
    KeywordUtil.logInfo('Correct Insured Name present ::' + findTestData(testData).getValue('VariousInsured', rowNumber))
}

WebUI.switchToDefaultContent()

String reinsuredNameSelected = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'Reinsured']))

KeywordUtil.logInfo('Country Name Displayed is :: ' + reinsuredNameSelected)

String reInsuredValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'Yes']), 
    'value')

GenericUtils.verifyMatch('Reinsured Information check box value is ::', reInsuredValue, 'Yes', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Renewal/button_Continue'))

String noBrokerValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'No Broker']), 
    'value')

GenericUtils.verifyMatch('No Broker check box value is ::', noBrokerValue, 'NoBroker', 'EQUAL')

String brokerSelected = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'Direct']))

KeywordUtil.logInfo('No Broker under drop down displayed is :: ' + brokerSelected)

String businessProviderSelected = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'BusinessProvider']))

KeywordUtil.logInfo('Business Provider under drop down displayed is :: ' + businessProviderSelected)

String contactNameValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'CoverHolderContact$pContactName']), 'value')

KeywordUtil.logInfo('Contact Name Value displayed is :: ' + contactNameValue)

String contactEmailValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'CoverHolderContact$pEmail']), 'value')

KeywordUtil.logInfo('Contact Email Value displayed is :: ' + contactEmailValue)

String jobPositionValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'CoverHolderContact$pPosition']), 'value')

KeywordUtil.logInfo('Job Position Value displayed is :: ' + jobPositionValue)

WebUI.scrollToElement(findTestObject('Object Repository/Renewal/button_Continue'), 20)

WebUI.click(findTestObject('Object Repository/Renewal/button_Continue'))

String majorClassValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue1', 
        [('dropDownName') : 'Major Class ']))

GenericUtils.verifyMatch('Major Class Value selected is', majorClassValue, findTestData(testData).getValue('Major Class', 
        rowNumber), 'EQUAL')

String minorClassValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'MinorClass']))

GenericUtils.verifyMatch('Minor Class Value selected is', minorClassValue, findTestData(testData).getValue('Minor Class', 
        rowNumber), 'EQUAL')

String classValue = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/webElement_SelectedOption', 
        [('dropDownName') : 'Class ']))

GenericUtils.verifyMatch('Class Value selected is', classValue, findTestData(testData).getValue('Class', rowNumber), 'EQUAL')

String placingTypeValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'pPlacingBasis']))

GenericUtils.verifyMatch('Placing Type Value selected is', placingTypeValue, findTestData(testData).getValue('Placing Type', 
        rowNumber), 'EQUAL')

String placingBasisValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'SubPlacingBasis']))

GenericUtils.verifyMatch('Placing Basis Value selected is', placingBasisValue, findTestData(testData).getValue('Sub Placing Type', 
        rowNumber), 'EQUAL')

String underwriterValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'Underwriter']))

GenericUtils.verifyMatch('Underwriter Value selected is', underwriterValue, findTestData(testData).getValue('Underwriter', 
        rowNumber), 'EQUAL')

String underWritingAssistantValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'pAssistant']))

GenericUtils.verifyMatch('Underwriting Assistant Value selected is', underWritingAssistantValue, findTestData(testData).getValue(
        'Underwriting Assistant', rowNumber), 'EQUAL')

String producingTeamValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'ProducingTeam']))

GenericUtils.verifyMatch('Producing Team Value selected is', producingTeamValue, findTestData(testData).getValue('Producing Team', 
        rowNumber), 'EQUAL')

String primaryExcessValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'PrimaryOrExcess']))

GenericUtils.verifyMatch('Primary Excess Value selected is', primaryExcessValue, findTestData(testData).getValue('ISPrimary', 
        rowNumber), 'EQUAL')

String entityValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'Entity']))

GenericUtils.verifyMatch('Entity Value selected is', entityValue, findTestData(testData).getValue('Entity', rowNumber), 
    'EQUAL')

String legalBranchValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'LegalBranch']))

GenericUtils.verifyMatch('Legal Branch Value selected is', legalBranchValue, findTestData(testData).getValue('Legal Branch', 
        rowNumber), 'EQUAL')

String inceptionDateValue = WebUI.getAttribute(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'), 
    'value')

GenericUtils.verifyMatch('Inception Date Value selected is', inceptionDateValue, renewedInceptionDateValue, 'EQUAL')

String expirationDateValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_FieldName', [('fieldName') : 'Expiry Date ']), 
    'value')

GenericUtils.verifyMatch('Expirated Date Value selected is', expirationDateValue, renewedExpiryDateValue, 'EQUAL')

String policyPeriodValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Policy Period ']), 'value')

GenericUtils.verifyMatch('Policy Period Value is', policyPeriodValue, renewedPolicyPeriodValue, 'EQUAL')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

String uwAuthorityValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'pUWAuthorityOperator']))

GenericUtils.verifyMatch('UW Authority Value selected is', uwAuthorityValue, findTestData(testData).getValue('UW Authority', 
        rowNumber), 'EQUAL')

String baseCurrencyValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'BaseCurrencyCode']))

GenericUtils.verifyMatch('Original Currency Value selected is', baseCurrencyValue, findTestData(testData).getValue('Original Currency', 
        rowNumber), 'EQUAL')

String orderPercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'OrderPercent']), 'value')

KeywordUtil.logInfo('Order Percent Value displayed is :: ' + orderPercentValue)

String estimatedSigningPercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'EstimatedSigning']), 'value')

KeywordUtil.logInfo('Estimated Signing Percent Value displayed is :: ' + estimatedSigningPercentValue)

String writtenParticipationPercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'pTMHCCWrittenPartPercent']), 'value')

KeywordUtil.logInfo('Written Participation Percent Value displayed is :: ' + writtenParticipationPercentValue)

String signedParticipationPercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'pTMHCCSignedPartPercent']), 'value')

KeywordUtil.logInfo('Signed Participation Percent Value displayed is :: ' + signedParticipationPercentValue)

String calculatedLinePercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'pCalculatedLinePercent']), 'value')

KeywordUtil.logInfo('Calculated Line Participation Percent Value displayed is :: ' + calculatedLinePercentValue)

String commissionPercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'pCommissionPercentage']), 'value')

KeywordUtil.logInfo('Commission Percent Value displayed is :: ' + commissionPercentValue)

String tmhccBrokerCommissionValueRenewed = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Broker Commission Amount']))

GenericUtils.verifyMatch('TMHCC Broker Commission Value is', tmhccBrokerCommissionValueRenewed, '0.00', 'EQUAL')

String layerCommissionValueRenewed = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'Layer Broker Commission Amount']))

GenericUtils.verifyMatch('Layer Commission Value is', layerCommissionValueRenewed, '0.00', 'EQUAL')

String tmhccGrossPremiumRenewed = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Gross Premium']))

GenericUtils.verifyMatch('TMHCC Gross Premium Value is', tmhccGrossPremiumRenewed, '0.00', 'EQUAL')

String tmhccNetPremiumRenewed = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Net Premium']))

GenericUtils.verifyMatch('TMHCC Net Premium Value is', tmhccNetPremiumRenewed, '0.00', 'EQUAL')

String layerGrossPremiumRenewed = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'Layer Gross Premium ']))

GenericUtils.verifyMatch('Layer Gross Premium Value is', layerGrossPremiumRenewed, '0.00', 'EQUAL')

String layerNetPremiumRenewed = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'Layer Net Premium ']))

GenericUtils.verifyMatch('Layer Net Premium Value is', layerNetPremiumRenewed, '0.00', 'EQUAL')

String payableToSelected = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'pAcquisitionFees$l1$ppyNote']))

KeywordUtil.logInfo('Payable To drop down displayed is :: ' + payableToSelected)

String feeTypeSelected = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'pAcquisitionFees$l1$pFeeType']))

KeywordUtil.logInfo('Fee Type selected drop down displayed is :: ' + feeTypeSelected)

String feePercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'FeePercentage']), 'value')

KeywordUtil.logInfo('Fee Percent Value displayed is :: ' + feePercentValue)

String actualLayerFeeAmount = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionReadValues', 
        [('fieldName') : 'Layer Fee Amount']))

String actualTMHCCFeeAmount = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_DynamicHeaderField', 
        [('fieldName') : 'TMHCC Fee Amount']))

GenericUtils.verifyMatch('TMHCC Fee Amount is : ', actualTMHCCFeeAmount, '0.00', 'EQUAL')

SubmissionHelper.generateInstallments(testData, rowNumber)

String newsignedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

KeywordUtil.logInfo(newsignedStatus)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))

//Loggging in with Underwriter
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Xmarguinaud', GlobalVariable.Xmarguinaud, 'Underwriter')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Quality Check']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/checkbox_ViewAllCases'))

//Filtering the policy
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_ClearFilter'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_SearchTextInFilter', [('fieldName') : 'Search Text']), 
    GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Apply'))

//Clicking on task link
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'))

WebUI.check(findTestObject('Object Repository/OutwardsPolicy/checkbox_UnderwriterDecision', [('optionToSelect') : 'Yes']))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Approve'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Approve'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))

//Logging in with Underwriter Assistant
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData).getValue('Role', rowNumber))

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Quality Check']))

WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/checkbox_ViewAllCases'))

//Filtering the policy
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_ClearFilter'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_SearchTextInFilter', [('fieldName') : 'Search Text']), 
    GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Apply'))

//Clicking on task link
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Complete'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Complete'))

WebUI.verifyElementPresent(findTestObject('Object Repository/OutwardsPolicy/webElement_SuccessMessage'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', 
        [('optionToSelect') : 'Submission Search']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Submission Search']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/button_SubmissionSearch'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Actions'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Actions'))

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_View'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_View'))

WebUI.callTestCase(findTestCase('Test Cases/Eclipse/259914_EclipseValidation'), [('testData') : testData, ('rowNumber') : rowNumber], 
    FailureHandling.STOP_ON_FAILURE)