/**
 * ============================================================================
 * Test Case ID : 259857
 * Title         : Check Named Insured Endorsement Templates
 * Folder        : Scripts/Documentation/259857_CheckNamedInsuredEndorsementTemplates
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

import static com.kms.katalon.core.model.FailureHandling.CONTINUE_ON_FAILURE
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

String inputLeadValue = findTestData(testData).getValue('input_Lead', rowNumber)
String taxCodeValue = findTestData(testData).getValue('Tax code', rowNumber)

String testData = 'Documentation'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

String timeStamp = GenericUtils.getCurrentTimestamp()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData).getValue('Role', rowNumber))

//Click on the 'Create' button.
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

//Wait for the 'Insured' element to be visible

//TODO: Make it work without UX changes
if (WebUI.verifyElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'))
}

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'))

String InsuredName = 'AUTO_' + GenericUtils.getCurrentTimestamp()

GlobalVariable.insuredName = InsuredName

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_BusinessUnit'), InsuredName)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_SearchName'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/radioButton_InsuredType', [('insuredType') : 'K&R Insured']), 
    GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/radioButton_InsuredType', [('insuredType') : 'K&R Insured']))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'), findTestData(
        testData).getValue('Addressline', rowNumber))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'), findTestData(
        testData).getValue('PostCode', rowNumber))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'), findTestData(
        testData).getValue('City', rowNumber))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
        'Country', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'), 
    findTestData(testData).getValue('NAIC Division', rowNumber), false)
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Actual Insured']), findTestData(
        testData).getValue('ActualInsured', rowNumber))
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'), 
    findTestData(testData).getValue('NAIC Description', rowNumber), false)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'), 
    findTestData(testData).getValue('Public/Private', rowNumber), false)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'No']), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'No']))
WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
	[('optionToSelect') : 'No']))
WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
	[('optionToSelect') : 'No']))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
        'CountryName', rowNumber), false)
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']), 
    findTestData(testData).getValue('Broker', rowNumber))
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : brokerValue]), GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : brokerValue]))

WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : brokerValue]))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'), 
    findTestData(testData).getValue('Broker Contact', rowNumber), false)
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 60)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
SubmissionHelper.enterGeneralData(testData, rowNumber)

String currentDate = new SimpleDateFormat('dd/MM/yyyy').format(Calendar.getInstance().time)
			
String submissionReceivedDate = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Submission Received Date']), 'data-value')

GenericUtils.verifyMatch('Submission Received Date Value is', submissionReceivedDate, currentDate, 'EQUAL')

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Quote Due Date'])).isEmpty()) {
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

String bureauIndicator = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_BureauIndicator'),
	'alt')

GenericUtils.verifyMatch('Bureau Indicator is not ticked ', bureauIndicator, 'False', 'EQUAL')

String policyPeriod = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
	[('labelName') : 'Policy Period ']), 'value')

GenericUtils.verifyMatch('Policy Period Value is', policyPeriod, findTestData(testData).getValue('PolicyPeriod', rowNumber), 'EQUAL')

String caseID = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseID'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), 60)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))
WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_PolicyReference'), 180)
String PolicyRef = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_PolicyReference'))

KeywordUtil.logInfo(PolicyRef)

GlobalVariable.PolicyRef = PolicyRef

WebUI.click(findTestObject('Object Repository/Dashboards/button_OK'))

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_DynamicText', [('buttonName') : 'Collapse all']),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_DynamicText', [('buttonName') : 'Expand all']),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_OpenQuote'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Original Currency']), 25)
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
    WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_DeMinimisField', [('attributeName') : 'Sublimit %'
                , ('fieldName') : i + '$pSublimitPercentage']))

    WebUI.setText(findTestObject('Object Repository/NewBusiness/webElement_DeMinimisField', [('attributeName') : 'Sublimit %'
                , ('fieldName') : i + '$pSublimitPercentage']), sublimitList[(i - 1)])
	}
//New Code for 452876 K&R Enhancements: Update prepopulated fields in Pega
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
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DeductiblesDropDown', [('headerName') : 'Deductibles Type']), 'Deductible for Ransom', false)

//End New Code for 452876 K&R Enhancements: Update prepopulated fields in Pega

for (int i = 1; i < 2; i++) {
	//New Code for 452876 K&R Enhancements: Update prepopulated fields in Pega
	
	//No need to click because it is prepopulated

	//No need to click because it is prepopulated

	//            , ('fieldName') : i + '$ppyNote']))
	//            , ('fieldName') : i + '$ppyNote']), payableToList[(i - 1)], false)
	
	//End New Code for 452876 K&R Enhancements: Update prepopulated fields in Pega
	
	
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
				, ('fieldName') : i + '$pFeePercentage']), GlobalVariable.timeOutValue)
	
	WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
				, ('fieldName') : i + '$pFeePercentage']))

	WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
				, ('fieldName') : i + '$pFeePercentage']), feePercentList[(i - 1)])
}

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'), 
    GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'), 
    findTestData(testData).getValue('Commission', rowNumber))

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

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerEELLimit'),
	GlobalVariable.timeOutValue)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), 60)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), 25, FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), FailureHandling.OPTIONAL)

String qoutedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

KeywordUtil.logInfo(qoutedStatus)
//No Bind DOC
//TODO: 540274: Remove the Quote Doc and Broker Bind Doc stage from the Pega data entry workflow

//Click on takeup the quote.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'), 25)
WebUI.click(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))

String openBoundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

KeywordUtil.logInfo(openBoundStatus)

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

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'External Policy Reference'])).isEmpty()) {
	KeywordUtil.logInfo('External Policy Reference is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Applicable Jurisdiction'])).isEmpty()) {
	KeywordUtil.logInfo('Applicable Jurisdiction is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Retroactivity Date'])).isEmpty()) {
	KeywordUtil.logInfo('Retroactivity Date is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Continuity Date'])).isEmpty()) {
	KeywordUtil.logInfo('Continuity Date is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Contract Start Date'])).isEmpty()) {
	KeywordUtil.logInfo('Contract Start Date is empty')
}

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
		[('labelName') : 'Notes']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
		[('labelName') : 'Additional Insureds']), GlobalVariable.timeoutShort)

String financialTypeText = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_FinancialTypeDefaultDropDown'))

GenericUtils.verifyMatch('Financial Type Value is', financialTypeText, 'Please Select...', 'EQUAL')
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), 25)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

String boundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

KeywordUtil.logInfo(boundStatus)

//TODO: 540274: Remove the Quote Doc and Broker Bind Doc stage from the Pega data entry workflow
////Click on takeup the quote.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), FailureHandling.OPTIONAL)
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    findTestData(testData).getValue('Tax Applicable', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	taxCodeValue)

WebUI.clearText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']))

WebUI.setText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	taxCodeValue)

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']), Keys.chord(Keys.BACK_SPACE))

currentText =  taxCodeValue.substring(0, taxCodeValue.length()-1)

WebUI.mouseOver(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.enhancedClick(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']), 
    findTestData(testData).getValue('Tax Premium', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Number of Instalments']), 
    Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Number of Instalments']), 
    findTestData(testData).getValue('Installments', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Number of Instalments']), 
    Keys.chord(Keys.TAB))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
        testData).getValue('Due Date', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
        Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

WebUI.switchToDefaultContent()

WebUI.callTestCase(findTestCase('Test Cases/Documentation/259857_CheckNamedInsuredEndorsementTemplates_1'), [:], FailureHandling.STOP_ON_FAILURE)