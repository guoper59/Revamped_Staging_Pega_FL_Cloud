/**
 * ============================================================================
 * Test Case ID : 262193
 * Title         : Create New Non Bureau Bordereau Facility Major Class TRI
 * Folder        : Scripts/NewBusiness/262193_CreateNewNonBureauBordereauFacilityMajorClassTRI
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

import java.text.SimpleDateFormat

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable as GlobalVariable

String testData = 'NewBusiness'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('ebello', GlobalVariable.Ebello, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Creating a Submission')
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Click on the 'Create' button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

//Wait for the 'Insured' element to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

// Enter cover holder information into the submission helper using the provided test data and row number.
SubmissionHelper.enterCoverHolder(testData, rowNumber)

// Select reinsured data based on the specified row number using the SubmissionHelper class.
SubmissionHelper.selectReinsured(testData, rowNumber)

// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// Enter broker details using the provided test data and row number.
//Entering required fields for No Broker option
WebUI.waitForElementPresent(findTestObject('Object Repository/OutwardsPolicy/radio_DynamicRadioButton', [('radioButtonLabel') : 'No Broker']), 
    GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/radio_DynamicRadioButton', [('radioButtonLabel') : 'No Broker']))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Direct']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Direct']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Direct']), 
    findTestData(testData).getValue('NoBrokerOption', rowNumber), false)

for (int i = 1; i < 4; i++) {

    WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_ContactDetails', [('fieldName') : 'CoverHolderContact$p' + 
                (contactFieldList[(i - 1)])]))

    WebUI.setText(findTestObject('Object Repository/NewBusiness/webElement_ContactDetails', [('fieldName') : 'CoverHolderContact$p' + 
                (contactFieldList[(i - 1)])]), contactDetailsList[(i - 1)])
}

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Continue'))

//Enter Details in General Data Tab
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'), 
    GlobalVariable.timeoutShort)

SubmissionHelper.enterGeneralData(testData, rowNumber)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Is Primary/Excess']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Is Primary/Excess']), 
    findTestData(testData).getValue('ISPrimary', rowNumber), false)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_SkipQouteIndicator'), GlobalVariable.timeOutValue)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Notes']), GlobalVariable.timeoutShort)

String policyPeriod = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Policy Period ']), 'value')

GenericUtils.verifyMatch('Policy Period Value is', policyPeriod, findTestData(testData).getValue('PolicyPeriod', rowNumber), 
    'EQUAL')

String bureauIndicator = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_BureauIndicator'), 
    'alt')

GenericUtils.verifyMatch('Bureau Indicator is not ticked ', bureauIndicator, 'False', 'EQUAL')
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), 60)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'), 
    60, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)
String policyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

GlobalVariable.PolicyRef = policyRef

KeywordUtil.logInfo(policyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_OK'))

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

//Verifying the values
String orderValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Order %']), 'value')

GenericUtils.verifyMatch('Order Value is', orderValue, findTestData(testData).getValue('Order%', rowNumber), 'EQUAL')

String estimatedSigningValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Estimated Signing %']), 'value')

GenericUtils.verifyMatch('Estimated Signing Value is', estimatedSigningValue, findTestData(testData).getValue('Estimated Signing %', 
        rowNumber), 'EQUAL')

int ordervalue = Integer.parseInt(orderValue.replace('.00000', ''))

int estSignedValue = Integer.parseInt(estimatedSigningValue.replace('.00000', ''))

int tmhccValue = Integer.parseInt(findTestData(testData).getValue('TMHCC Written Participation%', rowNumber).replace('.00000', 
        ''))

int expectedcalculatedLineValue = (((((ordervalue / 100) * estSignedValue) / 100) * tmhccValue) / 100) * 100

KeywordUtil.logInfo(expectedcalculatedLineValue)

String calculatedLineValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Calculated Line %']), 'value')

GenericUtils.verifyMatch('Calculated line Value is', calculatedLineValue, expectedcalculatedLineValue.toString().concat(
        '.00000'), 'EQUAL')

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

//verify the policy details
String actualLayerFeeAmount = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionReadValues', 
        [('fieldName') : 'Layer Fee Amount']))

GenericUtils.verifyMatch('Layer Fee Amount is : ', actualLayerFeeAmount, findTestData(testData).getValue('LayerFeeAmount', 
        rowNumber), 'EQUAL')

String actualTMHCCFeeAmount = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_DynamicHeaderField', 
        [('fieldName') : 'TMHCC Fee Amount']))

GenericUtils.verifyMatch('TMHCC Fee Amount is : ', actualTMHCCFeeAmount, findTestData(testData).getValue('TMHCCFeeAmount', 
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

String layerGrossPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'Layer Gross Premium ']))

GenericUtils.verifyMatch('Layer Gross Premium Value is', layerGrossPremium, findTestData(testData).getValue('Layer Gross Premium', 
        rowNumber), 'EQUAL')

String layerNetPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'Layer Net Premium ']))

GenericUtils.verifyMatch('Layer Net Premium Value is', layerNetPremium, findTestData(testData).getValue('Layer Net Premium', 
        rowNumber), 'EQUAL')

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.clearText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), findTestData(testData).getValue('input_Lead', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), Keys.chord(Keys.BACK_SPACE))

String currentText =  findTestData(testData).getValue('input_Lead', rowNumber).substring(0, findTestData(testData).getValue('input_Lead', rowNumber).length()-1)

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

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    findTestData(testData).getValue('Tax Applicable', rowNumber), false)

WebUI.setText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	findTestData(testData).getValue('Tax code', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']), Keys.chord(Keys.BACK_SPACE))

currentText =  findTestData(testData).getValue('Tax code', rowNumber).substring(0, findTestData(testData).getValue('Tax code', rowNumber).length()-1)

WebUI.mouseOver(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.enhancedClick(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']))
WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']), 
    Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']), 
    findTestData(testData).getValue('Tax Premium', rowNumber))

String actualPolicyPremiumAmount = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_DynamicHeaderField', 
        [('fieldName') : 'Policy Premium Amount']))

GenericUtils.verifyMatch('Policy Premium Amount is : ', actualPolicyPremiumAmount, findTestData(testData).getValue('PolicyPremiumAmount', 
        rowNumber), 'EQUAL')

String actualTmhccPremiumAmount = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_DynamicHeaderField', 
        [('fieldName') : 'TMHCC Premium Amount']))

GenericUtils.verifyMatch('TMHCC Premium Amount is : ', actualTmhccPremiumAmount, findTestData(testData).getValue('TMHCCPremiumAmount', 
        rowNumber), 'EQUAL')

String actualWithholding = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_Withholding'))

GenericUtils.verifyMatch('Withholding value is : ', actualWithholding, findTestData(testData).getValue('Withholding', rowNumber), 
    'EQUAL')

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
        testData).getValue('Due Date', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
        Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

//Validate the Installments
List<WebElement> actualInstalment = WebUI.findWebElements(findTestObject('Object Repository/Pega_CreateInsured/webElement_tblValue', 
        [('tableName') : 'Instalment']), GlobalVariable.timeoutShort)
List<WebElement> actualInstalmentValues = new ArrayList<String>()

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget1Ifr'), GlobalVariable.timeoutShort)

for (int i = 0; i < actualInstalment.size(); i++) {
    String value = actualInstalment.get(i).getText().trim()

    if (!(value.equals(''))) {
        actualInstalmentValues.add(value)
    }
}

WebUI.switchToDefaultContent()

KeywordUtil.logInfo(actualInstalmentValues)

GenericUtils.compareLists(expectedInstalmentValues, actualInstalmentValues)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

//Status Validations to be added
String uwQCStatus = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_UWQCStatus'))

GenericUtils.verifyMatch('UW QC Status is', uwQCStatus, 'To Be Approved', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector2', [('tabName') : 'Attachments']))

WebUI.waitForElementPresent(findTestObject('Object Repository/NewBusiness/webElement_AttachmentsDetails', [('attachmentName') : 'Underwriting Quality Check']), 
    GlobalVariable.timeOutValue)

if (WebUI.waitForElementPresent(findTestObject('Object Repository/NewBusiness/webElement_AttachmentsDetails', [('attachmentName') : 'Underwriting Quality Check']), 
    GlobalVariable.timeOutValue)) {
    KeywordUtil.markPassed('Attachments is present')
}

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector2', [('tabName') : 'Overview']))
WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']), 
    10, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']), 10)
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Finalise'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Finalise'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

String signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', signedStatus, 'Signed', 'EQUAL')

String peerReview = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PeerReviewNumber'))

KeywordUtil.logInfo('Peer Review Case generate for this is : ' + peerReview)

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', 
        [('optionToSelect') : 'Submission Search']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Clicking Submission Search option from left side menu
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Submission Search']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Policy Reference']), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Policy Reference']), policyRef)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_SubmissionSearch'))
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Actions'), GlobalVariable.timeoutShort)

//Wait for the specified element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

//Get the text from a web element on the page and stores it in a variable/
String policyQuote = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_forValidation', [('fieldName') : 'Policy Reference']), 
    FailureHandling.STOP_ON_FAILURE)

// Verify if the actual policy reference matches with the expected policy quote.
GenericUtils.verifyMatch('Search Policy By Reference is Successful', policyRef, policyQuote, 'EQUAL')

WebUI.callTestCase(findTestCase('Test Cases/Eclipse/262193_EclipseValidation'), [('testData') : testData , ('rowNumber') : rowNumber], FailureHandling.STOP_ON_FAILURE)