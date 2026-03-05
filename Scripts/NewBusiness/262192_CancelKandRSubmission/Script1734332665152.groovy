/**
 * ============================================================================
 * Test Case ID : 262192
 * Title         : Cancel Kand R Submission
 * Folder        : Scripts/NewBusiness/262192_CancelKandRSubmission
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
import java.text.SimpleDateFormat as SimpleDateFormat
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.NewSubmission as NewSubmission
import com.submission.helper.SubmissionHelper as SubmissionHelper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

String timeStamp = GenericUtils.getCurrentTimestamp()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData).getValue('Role', rowNumber))

NewSubmission.enterGeneralDetails(testData, rowNumber)

SubmissionHelper.enterGeneralData(testData, rowNumber)

String currentDate = new SimpleDateFormat('dd/MM/yyyy').format(Calendar.getInstance().time)

String submissionReceivedDate = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Submission Received Date']), 
    'data-value')

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Quote Due Date'])).isEmpty()) {
    KeywordUtil.logInfo('Quote Date is empty')
}

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Notes']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Is Master']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Is Local']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Is Tied In']), GlobalVariable.timeoutShort)

String policyPeriod = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Policy Period ']), 'value')

GenericUtils.verifyMatch('Policy Period Value is', policyPeriod, findTestData(testData).getValue('PolicyPeriod', rowNumber), 
    'EQUAL')

//TODO: I need to know when it should be bureau to don't do this
if (WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), 25, FailureHandling.OPTIONAL) ){
	if ( WebUI.verifyElementChecked(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), 25, FailureHandling. OPTIONAL ) ){
		WebUI.uncheck(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'))
	}
}

String caseID = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseID'))

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.waitForElementPresent(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyReference'), 180)

String policyRef = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyReference'))

GlobalVariable.PolicyRef = policyRef

KeywordUtil.logInfo(policyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_OK'))

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_CreateMultipleTitle'), 60, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_CreateMultiQuote'), 60, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_DynamicText', [('buttonName') : 'Collapse all']), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_DynamicText', [('buttonName') : 'Expand all']), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_OpenQuote'), 60, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Original Currency']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Original Currency']), 
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

for (int i = 1; i < 17; i++) {
	
	WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/webElement_DeMinimisField', [('attributeName') : 'Sublimit %'
                , ('fieldName') : i + '$pSublimitPercentage']), 20)
    WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_DeMinimisField', [('attributeName') : 'Sublimit %'
                , ('fieldName') : i + '$pSublimitPercentage']))

    WebUI.setText(findTestObject('Object Repository/NewBusiness/webElement_DeMinimisField', [('attributeName') : 'Sublimit %'
                , ('fieldName') : i + '$pSublimitPercentage']), sublimitList[(i - 1)])

}
//New Code for 452876 K&R Enhancements: Update prepopulated fields in Pega
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/checkbox_Dynamic', [('labelName') : 'Deductibles']),
	GlobalVariable.timeOutValue)

WebUI.scrollToElement(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Deductibles']), GlobalVariable.timeoutShort)

WebUI.check(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Deductibles']))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Deductibles %']), 25)

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Deductibles %']), 25)
WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Deductibles %']))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Deductibles %']),
	findTestData(testData).getValue('Deductibles%', rowNumber))

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Deductibles Amount']), 25)
WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Deductibles Amount']))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Deductibles Amount']), 	'100,000.00')

// EEL
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DeductiblesDropDown', [('headerName') : 'Deductible Basis']), 'EEL', false)
//
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_DeductiblesDropDown', [('headerName') : 'Deductibles Type']), 25)
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DeductiblesDropDown', [('headerName') : 'Deductibles Type']), 'Deductible for Ransom', false)

//End New Code for 452876 K&R Enhancements: Update prepopulated fields in Pega

for (int i = 1; i < 2; i++) {

    WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
                , ('fieldName') : i + '$pFeePercentage']), GlobalVariable.timeOutValue)

    WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
                , ('fieldName') : i + '$pFeePercentage']), feePercentList[(i - 1)])

}

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Commission %']))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Commission %']), findTestData(
        testData).getValue('Commission', rowNumber))

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_PremiumCalculate'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_PremiumCalculate'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'), 
    Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'), 
    findTestData(testData).getValue('Layer Gross Premium', rowNumber))

for (int i = 1; i < 6; i++) {
    WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : premiumBreakDownList[
                (i - 1)]]))

    WebUI.setText(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : premiumBreakDownList[
                (i - 1)]]), premiumBreakDownValueList[(i - 1)])

}

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_AddItemKR'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_AddItemKR'))

for (int i = 1; i < 3; i++) {

    WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', 
            [('headerName') : 'R Endorsements', ('fieldName') : i + '$ppyLabel']), GlobalVariable.timeOutValue)

    WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', [('headerName') : 'R Endorsements'
                , ('fieldName') : i + '$ppyLabel']))

    WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', [('headerName') : 'R Endorsements'
                , ('fieldName') : i + '$ppyLabel']), endorsementsList[(i - 1)], false)

}

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']), 
    findTestData(testData).getValue('Territorial Scope', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ApplicableLaw'), 
    GlobalVariable.timeOutValue)

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

String actualPreventionAllowance = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues', 
        [('fieldName') : 'Prevention allowance (%)']), 'value')

GenericUtils.verifyMatch('Prevention Allowance Value is', actualPreventionAllowance, findTestData(testData).getValue('PreventionAllowance', 
        rowNumber), 'EQUAL')

String actualThreatResponseDays = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues', 
        [('fieldName') : 'Threat Response Expense Indemnity Period (days)']), 'value')

GenericUtils.verifyMatch('Threat Response Days Value is', actualThreatResponseDays, findTestData(testData).getValue('ThreatResponseDays', 
        rowNumber), 'EQUAL')

String actualThreatResponseHours = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues', 
        [('fieldName') : 'Threat Response Expense Waiting Period (hours)']), 'value')

GenericUtils.verifyMatch('Threat Response Hours Value is', actualThreatResponseHours, findTestData(testData).getValue('ThreatResponseHours', 
        rowNumber), 'EQUAL')

String actualDisappearanceDays = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues', 
        [('fieldName') : 'Disappearance & Investigation Expense Indemnity Period (days)']), 'value')

GenericUtils.verifyMatch('Disappearance & Investigation Expense Days Value is', actualDisappearanceDays, findTestData(testData).getValue(
        'DisappearanceDays', rowNumber), 'EQUAL')

String actualDisappearanceHours = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues', 
        [('fieldName') : 'Disappearance & Investigation Expense Waiting Period (hours)']), 'value')

GenericUtils.verifyMatch('Disappearance & Investigation Expense Hours Value is', actualDisappearanceHours, findTestData(
        testData).getValue('DisappearanceHours', rowNumber), 'EQUAL')

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), 60)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), 60)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_Status', [('status') : 'Quoted']), 60, FailureHandling.OPTIONAL)
String quotedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', quotedStatus, expectedquotedStatus, 'EQUAL')

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

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']), 
    findTestData(testData).getValue('UW Authority', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'), 
    findTestData(testData).getValue('IsTacitRenewal', rowNumber), false)

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

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'External Policy Reference'])).isEmpty()) {
    KeywordUtil.logInfo('External Policy Reference is empty')
}

String financialTypeText = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_FinancialTypeDefaultDropDown'))

GenericUtils.verifyMatch('Financial Type Value is', financialTypeText, 'Please Select...', 'EQUAL')

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), 60)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), 25, FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'), FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_Status', [('status') : 'Bound']), 60, FailureHandling.OPTIONAL)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 60)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    findTestData(testData).getValue('Tax Applicable', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']), 
    findTestData(testData).getValue('Tax code', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']), Keys.chord(Keys.BACK_SPACE))

currentText =  findTestData(testData).getValue('Tax code', rowNumber).substring(0, findTestData(testData).getValue('Tax code', rowNumber).length()-1)

WebUI.mouseOver(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.enhancedClick(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']), 
    findTestData(testData).getValue('Tax Premium', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']), 
    Keys.chord(Keys.TAB))

String actualPolicyPremiumAmount = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_DynamicHeaderField', 
        [('fieldName') : 'Policy Premium Amount']))

GenericUtils.verifyMatch('Policy Premium Amount is : ', actualPolicyPremiumAmount, findTestData(testData).getValue('PolicyPremiumAmount', 
        rowNumber), 'EQUAL')

String actualTmhccPremiumAmount = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_DynamicHeaderField', 
        [('fieldName') : 'TMHCC Premium Amount']))

GenericUtils.verifyMatch('TMHCC Premium Amount is : ', actualTmhccPremiumAmount, findTestData(testData).getValue('TMHCCPremiumAmount', 
        rowNumber), 'EQUAL')

String policyTaxAmount = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_DynamicHeaderField', [('fieldName') : 'Policy Tax Amount']))

GenericUtils.verifyMatch('Policy Tax Amount is : ', policyTaxAmount, expectedpolicyTaxAmount, 'EQUAL')

String actualWithholding = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_Withholding'))

GenericUtils.verifyMatch('Withholding value is : ', actualWithholding, findTestData(testData).getValue('Withholding', rowNumber), 
    'EQUAL')

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
        testData).getValue('Due Date', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
        Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 60)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/webElement_tblValue', [('tableName') : 'Instalment']), 60)
//Installments Validations
List<WebElement> actualInstalment = WebUI.findWebElements(findTestObject('Object Repository/Pega_CreateInsured/webElement_tblValue', 
        [('tableName') : 'Instalment']), GlobalVariable.timeoutShort)

List<WebElement> actualInstalmentValues = new ArrayList<String>()

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget1Ifr'), 60)

for (int i = 0; i < actualInstalment.size(); i++) {
    String value = actualInstalment.get(i).getText().trim( // Trim spaces
        )

    if (!(value.equals(''))) {
        actualInstalmentValues.add(value)
    }
}

WebUI.switchToDefaultContent()

KeywordUtil.logInfo(actualInstalmentValues)

GenericUtils.compareLists(expectedInstalmentValues, actualInstalmentValues)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), 60)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_OtherActions'), 60)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_OtherActions'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_OtherActionsOption', [('optionToSelect') : 'Cancel Submission']), 60)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_OtherActionsOption', [('optionToSelect') : 'Cancel Submission']))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_PolicyCancellationMessage'), 60)
String policyCancellationMessage = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PolicyCancellationMessage'))

GenericUtils.verifyMatch('Policy Cancellation message is', policyCancellationMessage, expectedPolicyCencallationMessage, 
    'EQUAL')

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_DynamicDropDown', [('dropDownLabel') : 'Submission Cancel Reason']), 
    GlobalVariable.timeOutValue)

//Selecting declined reason
WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_DynamicDropDown', [('dropDownLabel') : 'Submission Cancel Reason']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/webElement_DynamicDropDown', [('dropDownLabel') : 'Submission Cancel Reason']), 
    findTestData(testData).getValue('SubmissionCancelReason', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_CommentSection', [('commentField') : 'Cancel Reason Description']), 
    'Test test test test')

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_CommentSection', [('commentField') : 'Cancel Reason Description']), 
    Keys.chord(Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Submit'), GlobalVariable.timeOutValue)

//Submitting the case close details
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_SuccessMessageDeclinedReason'), GlobalVariable.timeOutValue)

//Verifying correct message after submission closure
String actualMessage = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SuccessMessageDeclinedReason'))

GenericUtils.verifyMatch('Success Message displayed is ', actualMessage, successMessage, 'EQUAL')

String cancelledStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Latest Status is ', cancelledStatus, expectedcancelledStatus, 'EQUAL')

//Click on a dynamic tab selector for Policy Docs.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector', [('tabName') : 'Post Bind']))

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_LabelExpansion', [('labelToExpand') : 'Instalments']))

String originalPremiumPolicyGrossOriginal = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_OriginalPremiumSelector', 
        [('columnNumber') : '1', ('columnName') : 'Policy Gross Amount - Original']))

GenericUtils.verifyMatch('Original Premium for Policy Gross Amount - Original is ', originalPremiumPolicyGrossOriginal, 
    expectedPremiumPolicyGrossOriginal, 'EQUAL')

String originalPremiumTMHCCGrossOriginal = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_OriginalPremiumSelector', 
        [('columnNumber') : '2', ('columnName') : 'TMHCC Gross Amount - Original']))

GenericUtils.verifyMatch('Original Premium for TMHCC Gross Amount - Original is ', originalPremiumTMHCCGrossOriginal, expectedPremiumTMHCCGrossOriginal, 
    'EQUAL')

String originalPremiumPolicySettlementOriginal = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_OriginalPremiumSelector', 
        [('columnNumber') : '4', ('columnName') : 'Policy Gross Amount - Settlement']))

GenericUtils.verifyMatch('Original Premium for Policy Gross Settlement - Original is ', originalPremiumPolicySettlementOriginal, 
    expectedPremiumPolicySettlementOriginal, 'EQUAL')

String originalPremiumTMHCCSettlementOriginal = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_OriginalPremiumSelector', 
        [('columnNumber') : '5', ('columnName') : 'TMHCC Gross Amount - Settlement']))

GenericUtils.verifyMatch('Original Premium for TMHCC Gross Settlement - Original is ', originalPremiumTMHCCSettlementOriginal, 
    expectedPremiumTMHCCSettlementOriginal, 'EQUAL')

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/button_ExpandItems_Frame1'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Endorsements/button_ExpandItems_Frame1'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_TabSelectorAfterExpansion', [('tabName') : 'Closed Reasons']), 
    GlobalVariable.timeOutValue)

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/webElement_TabSelectorAfterExpansion', [('tabName') : 'Closed Reasons']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_TabSelectorAfterExpansion', [('tabName') : 'Closed Reasons']))

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget1Ifr'), GlobalVariable.timeoutShort)

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/webElement_ClosedReasonHeaders'), 60)
//Reason Validations
List<WebElement> actualCloseReasonHeader = WebUI.findWebElements(findTestObject('Object Repository/NewBusiness/webElement_ClosedReasonHeaders'), 60)

List<WebElement> actualCloseReasonHeaderValues = new ArrayList<String>()

for (int i = 0; i < actualCloseReasonHeader.size(); i++) {
    String value = actualCloseReasonHeader.get(i).getText().trim( // Trim spaces
        )

    KeywordUtil.logInfo(value)

    if (!(value.equals(''))) {
        actualCloseReasonHeaderValues.add(value)
    }
}

KeywordUtil.logInfo(actualCloseReasonHeaderValues)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/webElement_ClosedReasonValues'), 60)
List<WebElement> CloseReasonValues = WebUI.findWebElements(findTestObject('Object Repository/NewBusiness/webElement_ClosedReasonValues'), 60)

List<WebElement> CloseReasonValuesList = new ArrayList<String>()

for (int i = 0; i < CloseReasonValues.size(); i++) {
    String value = CloseReasonValues.get(i).getText().trim( // Trim spaces
        )

    if (!(value.equals(''))) {
        CloseReasonValuesList.add(value)
    }
}

WebUI.switchToDefaultContent()

List<WebElement> expectedClosedReasonValuesList = new ArrayList<String>()

expectedClosedReasonValuesList.add(caseID)

expectedClosedReasonValuesList.add(findTestData(testData).getValue('SubmissionCancelReason', rowNumber))

expectedClosedReasonValuesList.add('Test test test test')
GenericUtils.compareLists(actualCloseReasonHeaderValues, expectedCloseReasonHeaderValues)

GenericUtils.compareLists(expectedClosedReasonValuesList, CloseReasonValuesList)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', 
        [('optionToSelect') : 'Submission Search']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Clicking Submission Search option from left side menu
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Submission Search']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Policy Reference']), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Policy Reference']), policyRef)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_SubmissionSearch'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Actions'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Actions'))

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_ViewFinal'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_ViewFinal'))

//Calling Get API to validate response---SBS ECLIPSE
ResponseObject response1 = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetProgramPackage'), null)

//Retrieve the policy status from the response
String policyStatus = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].LineStatus')

KeywordUtil.logInfo(policyStatus)

//Verify if the policy status matches the expected value 'Decline'
GenericUtils.verifyMatch('Verify Status of Policy', expectedPolicyStatus, policyStatus, 'EQUAL')