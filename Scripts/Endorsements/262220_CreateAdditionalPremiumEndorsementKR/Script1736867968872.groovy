/**
 * ============================================================================
 * Test Case ID : 262220
 * Title         : Create Additional Premium Endorsement KR
 * Folder        : Scripts/Endorsements/262220_CreateAdditionalPremiumEndorsementKR
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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

String inputLeadValue = findTestData(testData).getValue('input_Lead', rowNumber)
String taxCodeValue = findTestData(testData).getValue('Tax code', rowNumber)

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

String timeStamp = GenericUtils.getCurrentTimestamp()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData).getValue('Role', rowNumber))

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

if (!(findTestData(testData).getValue('ActualInsured', rowNumber).equals(''))) {
	WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Actual Insured']),
		findTestData(testData).getValue('ActualInsured', rowNumber))
}

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
	GlobalVariable.timeOutValue, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
	findTestData(testData).getValue('NAIC Division', rowNumber), false)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
	GlobalVariable.timeOutValue, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
	findTestData(testData).getValue('NAIC Description', rowNumber), false)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'),
	findTestData(testData).getValue('Public/Private', rowNumber), false)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
		[('optionToSelect') : 'No']), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
		[('optionToSelect') : 'No']))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

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

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

SubmissionHelper.enterGeneralData(testData, rowNumber)

String currentDate = new SimpleDateFormat('dd/MM/yyyy').format(Calendar.getInstance().time)

String submissionReceivedDate = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Submission Received Date']),
	'data-value')

KeywordUtil.logInfo('Submission Received Date Value: ' +submissionReceivedDate)

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

String bureauIndicator = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_BureauIndicator'), 'alt')

GenericUtils.verifyMatch('Bureau Indicator is not ticked ', bureauIndicator, 'False','EQUAL')

String caseID = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseID'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), 60)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.waitForElementPresent(findTestObject('Object Repository/NewBusiness/webElement_PolicyReference'), 180)

String policyRef = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PolicyReference'))

GlobalVariable.PolicyRef = policyRef

KeywordUtil.logInfo(policyRef)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_OK'))

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_CreateMultipleTitle'), 25,
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_CreateMultiQuote'), 25,
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_DynamicText', [('buttonName') : 'Collapse all']),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_DynamicText', [('buttonName') : 'Expand all']),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_OpenQuote'), 25,
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

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'), 25)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'),
	GlobalVariable.timeOutValue)

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
WebUI.waitForElementNotHasAttribute(findTestObject('Object Repository/NewBusiness/select_DeductiblesDropDown', [('headerName') : 'Deductibles Type']), "disabled", 60)
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
	
	WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : premiumBreakDownList[
		(i - 1)]]), 25)

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

GenericUtils.verifyMatch('TMHCC Net Premium Value is', tmhccNetPremium, findTestData(testData).getValue('TMHCCNetPremium',
		rowNumber), 'EQUAL')

String layerNetPremium = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Layer Net Premium']), 'data-value')

GenericUtils.verifyMatch('Layer Net Premium default to', layerNetPremium, findTestData(testData).getValue('Layer Net Premium',
	rowNumber)+'.00', 'EQUAL')

String actualPreventionAllowance = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues',
	[('fieldName') : 'Prevention allowance (%)']),'value')

GenericUtils.verifyMatch('Prevention Allowance Value is', actualPreventionAllowance, findTestData(testData).getValue('PreventionAllowance',
	rowNumber), 'EQUAL')

String actualThreatResponseDays = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues',
	[('fieldName') : 'Threat Response Expense Indemnity Period (days)']),'value')

GenericUtils.verifyMatch('Threat Response Days Value is', actualThreatResponseDays, findTestData(testData).getValue('ThreatResponseDays',
	rowNumber), 'EQUAL')

String actualThreatResponseHours = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues',
	[('fieldName') : 'Threat Response Expense Waiting Period (hours)']),'value')

GenericUtils.verifyMatch('Threat Response Hours Value is', actualThreatResponseHours, findTestData(testData).getValue('ThreatResponseHours',
	rowNumber), 'EQUAL')

String actualDisappearanceDays = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues',
	[('fieldName') : 'Disappearance & Investigation Expense Indemnity Period (days)']),'value')

GenericUtils.verifyMatch('Disappearance & Investigation Expense Days Value is', actualDisappearanceDays, findTestData(testData).getValue('DisappearanceDays',
	rowNumber), 'EQUAL')

String actualDisappearanceHours = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues',
	[('fieldName') : 'Disappearance & Investigation Expense Waiting Period (hours)']),'value')

GenericUtils.verifyMatch('Disappearance & Investigation Expense Hours Value is', actualDisappearanceHours, findTestData(testData).getValue('DisappearanceHours',
	rowNumber), 'EQUAL')

WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Verifying Data Validation field names
List<WebElement> layerSublimitValue = WebUI.findWebElements(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicTableValues',
		[('headerName') : 'Layer Sublimit']), GlobalVariable.timeOutValue)

List<WebElement> layerSublimitList = new ArrayList<String>()

for (WebElement e : layerSublimitValue) {
	layerSublimitList.add(e.getAttribute('value'))
}

KeywordUtil.logInfo(layerSublimitList)
GenericUtils.compareLists(layerSublimitList, expectedLayerSublimitList)

List<WebElement> sublimitPercentValue = WebUI.findWebElements(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicTableValues',
	[('headerName') : 'Sublimit %']), GlobalVariable.timeOutValue)

List<WebElement> sublimitPercentList = new ArrayList<String>()

for (WebElement e : sublimitPercentValue) {
	sublimitPercentList.add(e.getAttribute('value'))
}
KeywordUtil.logInfo(sublimitPercentList)
GenericUtils.compareLists(sublimitPercentList, expectedSublimitPercentList)

List<WebElement> perInsuredEventValue = WebUI.findWebElements(findTestObject('Object Repository/NewBusiness/webElement_CAEndorsementValue',
	[('headerName') : 'Per Insured Event']), GlobalVariable.timeOutValue)

List<WebElement> perInsuredEventList = new ArrayList<String>()

for (WebElement e : perInsuredEventValue) {
	perInsuredEventList.add(e.getAttribute('value'))
}
KeywordUtil.logInfo(perInsuredEventList)
GenericUtils.compareLists(perInsuredEventList, expectedPerInsuredEventList)

List<WebElement> inTheAggValue = WebUI.findWebElements(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicTableValues',
	[('headerName') : 'In the AGG']), GlobalVariable.timeOutValue)

List<WebElement> aggValueList = new ArrayList<String>()

for (WebElement e : inTheAggValue) {
	aggValueList.add(e.getAttribute('value'))
}
KeywordUtil.logInfo(aggValueList)
GenericUtils.compareLists(aggValueList, expectedAggValueList)
WebUI.switchToDefaultContent()

String deductibleBasis = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_DeductibleSelectedDropDown',[('dropDownName') : 'DeductibleBasis']))
GenericUtils.verifyMatch('Deductibles Basis Value is', deductibleBasis, expectedDeductibleBasis, 'EQUAL')

String deductibleType = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_DeductibleSelectedDropDown',[('dropDownName') : 'DeductibleType']))

GenericUtils.verifyMatch('Deductibles Type Value is', deductibleType, expectedDeductibleType, 'EQUAL')

String actualDeductiblesAmount = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Deductibles Amount']), 'value')

GenericUtils.verifyMatch('Deductibles Amount Value is', actualDeductiblesAmount, findTestData(testData).getValue('DeductiblesAmountValue',
	rowNumber), 'EQUAL')

String actualAATpercentage = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues',
	[('fieldName') : 'AAT Percentage (%)']),'value')

GenericUtils.verifyMatch('AAT Percentage Value is', actualAATpercentage, findTestData(testData).getValue('AatPercentage',
	rowNumber), 'EQUAL')
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerEELLimit'),
	GlobalVariable.timeOutValue)

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), 60, FailureHandling.OPTIONAL)
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), 60, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'), 60)

String qoutedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))
KeywordUtil.logInfo(qoutedStatus)

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

String financialTypeText = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_FinancialTypeDefaultDropDown'))
GenericUtils.verifyMatch('Financial Type Value is', financialTypeText, 'Please Select...', 'EQUAL')

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), 60)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_Continue'), 60)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))
WebUI.waitForElementNotVisible(findTestObject('Object Repository/NewBusiness/button_Save'), 60)
WebUI.waitForElementNotVisible(findTestObject('Object Repository/NewBusiness/webElement_Status', [('status') : 'Open Bound']), 60, FailureHandling.OPTIONAL)

WebUI.waitForPageLoad(60);
WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_Status', [('status') : 'Bound']), 60, FailureHandling.OPTIONAL)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), 60, FailureHandling.OPTIONAL)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_Continue'), 60, FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'), FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)

WebUI.waitForElementNotVisible(findTestObject('Object Repository/NewBusiness/button_Continue'), 60, FailureHandling.OPTIONAL)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 25)

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

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Premium']),
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
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/webElement_tblValue', [('tableName') : 'Instalment']), 25)

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'))

WebUI.callTestCase(findTestCase('Test Cases/Endorsements/SubTestCase01_262220'), [('testData') : testData , ('rowNumber') : rowNumber, ('policyRef') : policyRef], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/TestData/262220_CreateAdditionalPremium'), [:],FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/TestData/262220_ValidateEndorsementDetails'), [('testData') : testData , ('rowNumber') : rowNumber], FailureHandling.STOP_ON_FAILURE)