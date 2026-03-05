/**
 * ============================================================================
 * Test Case ID : 262200
 * Title         : Create New Non Bureau KR Insurance Policy German Branch
 * Folder        : Scripts/NewBusiness/262200_CreateNewNonBureauKRInsurancePolicyGermanBranch
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

import internal.GlobalVariable as GlobalVariable

String testData = 'NewBusiness'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

String timeStamp = GenericUtils.getCurrentTimestamp()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData).getValue('Role', rowNumber))

WebUI.callTestCase(findTestCase('Test Cases/NewBusiness/SubTestCase01_262200'), [('testData') : testData, ('rowNumber') : rowNumber],
	FailureHandling.STOP_ON_FAILURE)

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

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Deductibles %']),
	findTestData(testData).getValue('Deductibles%', rowNumber))

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Deductibles Amount']), 25)
WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Deductibles Amount']))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Deductibles Amount']), 	'100,000.00')
//AGG EEL
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DeductiblesDropDown', [('headerName') : 'Deductible Basis']), 'EEL', false)

//
WebUI.waitForElementNotHasAttribute(findTestObject('Object Repository/NewBusiness/select_DeductiblesDropDown', [('headerName') : 'Deductibles Type']), "disabled", 25)
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DeductiblesDropDown', [('headerName') : 'Deductibles Type']), 'Deductible for Ransom', false)

//End New Code for 452876 K&R Enhancements: Update prepopulated fields in Pega

for (int i = 1; i < 2; i++) {
	//New Code for 452876 K&R Enhancements: Update prepopulated fields in Pega
	
	//No need to click because it is prepopulated

    //No need to click because it is prepopulated

    //            , ('fieldName') : i + '$ppyNote']))
    //            , ('fieldName') : i + '$ppyNote']), payableToList[(i - 1)], false)
	
	//End New Code for 452876 K&R Enhancements: Update prepopulated fields in Pega
	
	

    WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', [('headerName') : 'Fee Type'
                , ('fieldName') : i + '$pFeeType']))

    WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', [('headerName') : 'Fee Type'
                , ('fieldName') : i + '$pFeeType']), feeTypeList[(i - 1)], false)
    WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
                , ('fieldName') : i + '$pFeePercentage']), GlobalVariable.timeOutValue)

	WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
		, ('fieldName') : i + '$pFeePercentage']))

    WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
                , ('fieldName') : i + '$pFeePercentage']), feePercentList[(i - 1)])
}

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'))
	

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

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ApplicableLaw'))

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

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_MultiQuote'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_MultiQuote'))
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OpenQuote'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OpenQuote'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues'), 25)

//Verifying the values
String inceptionDate = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Inception Date ']), 'value')

GenericUtils.verifyMatch('Inception Date Value is', inceptionDate, GlobalVariable.InceptionDate, 'EQUAL')

String expiryDate = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Expiry Date ']), 'value')

GenericUtils.verifyMatch('Expiration Date Value is', expiryDate, GlobalVariable.ExpirationDate, 'EQUAL')

String policyPeriod = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Policy Period ']), 'value')

GenericUtils.verifyMatch('Policy Period Value is', policyPeriod, findTestData(testData).getValue('PolicyPeriod', rowNumber),
	'EQUAL')

String entity = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption', [('dropDownName') : 'Entity']))

GenericUtils.verifyMatch('Entity Value is', entity, findTestData(testData).getValue('Entity', rowNumber), 'EQUAL')

String legalBranch = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption', [('dropDownName') : 'LegalBranch']))

GenericUtils.verifyMatch('Legal Branch Value is', legalBranch, findTestData(testData).getValue('Legal Branch', rowNumber),
	'EQUAL')

String originalCurrency = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption',
		[('dropDownName') : 'BaseCurrency']))

GenericUtils.verifyMatch('Base Currency Value is', originalCurrency, findTestData(testData).getValue('Original Currency',
		rowNumber), 'EQUAL')

String writtenParticipation = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'TMHCC Written Participation %']), 'value')

GenericUtils.verifyMatch('TMHCC Written Participation Value is', writtenParticipation, findTestData(testData).getValue('TMHCC Written Participation%',
		rowNumber) + '.00000', 'EQUAL')

String newOrderValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Order %']), 'value')

GenericUtils.verifyMatch('Copied Order Value is', newOrderValue, orderValue, 'EQUAL')

String newEstimatedSigningValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Estimated Signing %']), 'value')

GenericUtils.verifyMatch('Copied Estimated Signing Value is', newEstimatedSigningValue, estimatedSigningValue, 'EQUAL')

String newCalculatedLineValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Calculated Line %']), 'value')

GenericUtils.verifyMatch('Copied Calculated line Value is', newCalculatedLineValue, calculatedLineValue, 'EQUAL')

String newPreventionAllowance = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues',
		[('fieldName') : 'Prevention allowance (%)']), 'value')

GenericUtils.verifyMatch('Copied Prevention Allowance Value is', newPreventionAllowance, actualPreventionAllowance, 'EQUAL')

String newThreatResponseDays = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues',
		[('fieldName') : 'Threat Response Expense Indemnity Period (days)']), 'value')

GenericUtils.verifyMatch('Copied Threat Response Days Value is', newThreatResponseDays, actualThreatResponseDays, 'EQUAL')

String newThreatResponseHours = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues',
		[('fieldName') : 'Threat Response Expense Waiting Period (hours)']), 'value')

GenericUtils.verifyMatch('Copied Threat Response Hours Value is', newThreatResponseHours, actualThreatResponseHours, 'EQUAL')

String newDisappearanceDays = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues',
		[('fieldName') : 'Disappearance & Investigation Expense Indemnity Period (days)']), 'value')

GenericUtils.verifyMatch('Copied Disappearance & Investigation Expense Days Value is', newDisappearanceDays, actualDisappearanceDays,
	'EQUAL')

String newDisappearanceHours = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues',
		[('fieldName') : 'Disappearance & Investigation Expense Waiting Period (hours)']), 'value')

GenericUtils.verifyMatch('Disappearance & Investigation Expense Hours Value is', newDisappearanceHours, actualDisappearanceHours,
	'EQUAL')

String territorialScope = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption',
		[('dropDownName') : 'TerritorialScope']))

GenericUtils.verifyMatch('Territorial Scope Value is', territorialScope, findTestData(testData).getValue('Territorial Scope',
		rowNumber), 'EQUAL')

String applicableLawValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Applicable Law ']), 'value')

GenericUtils.verifyMatch('Applicable Law Value is', applicableLawValue, findTestData(testData).getValue('Applicable Law',
		rowNumber), 'EQUAL')

WebUI.callTestCase(findTestCase('Test Cases/TestData/262200_FieldValidations'), [('testData') : testData, ('rowNumber') : rowNumber],
	FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerEELLimit'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerEELLimit'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerEELLimit'), '2,000,000')

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'), findTestData(
		testData).getValue('Layer AGG Limit', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'),
	GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'),
	findTestData(testData).getValue('Commission', rowNumber))
WebUI.clearText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'),
	findTestData(testData).getValue('Commission', rowNumber))

for (int i = 1; i < 2; i++) {
	//New Code for 452876 K&R Enhancements: Update prepopulated fields in Pega
	
	//End New Code for 452876 K&R Enhancements: Update prepopulated fields in Pega
	WebUI.waitForElementNotHasAttribute(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
		, ('fieldName') : i + '$pFeePercentage']), 'disabled', 25)
	
    WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
                , ('fieldName') : i + '$pFeePercentage']), 25)

	WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
                , ('fieldName') : i + '$pFeePercentage']))
    WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionTextArea', [('headerName') : 'Fee %'
                , ('fieldName') : i + '$pFeePercentage']), feePercentList[(i - 1)])
}

WebUI.callTestCase(findTestCase('Test Cases/NewBusiness/SubTestCase02_262200'), [('testData') : testData, ('rowNumber') : rowNumber],
	FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	findTestData(testData).getValue('Tax code', rowNumber))

WebUI.clearText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']))

WebUI.setText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	findTestData(testData).getValue('Tax code', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']), Keys.chord(Keys.BACK_SPACE))

String currentText =  findTestData(testData).getValue('Tax code', rowNumber).substring(0, findTestData(testData).getValue('Tax code', rowNumber).length()-1)

WebUI.mouseOver(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.enhancedClick(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Premium']))
WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Premium']), 
    findTestData(testData).getValue('Tax Premium', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Number of Instalments']), 
    Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Number of Instalments']), 
    findTestData(testData).getValue('Installments', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Number of Instalments']), 
    Keys.chord(Keys.TAB))

for (int i = 1; i < 3; i++) {
    WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_MultipleDueDate', [('fieldName') : i + 
                '$pDueDate']), GlobalVariable.timeOutValue)

    WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_MultipleDueDate', [('fieldName') : i + '$pDueDate']), 
        installmentsDueDateList[(i - 1)])

    WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_MultipleDueDate', [('fieldName') : i + '$pDueDate']), 
        Keys.chord(Keys.TAB))	
}

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

//Installments Validations
List<WebElement> actualInstalment = WebUI.findWebElements(findTestObject('Object Repository/Pega_CreateInsured/webElement_tblValue', 
        [('tableName') : 'Instalment']), GlobalVariable.timeoutShort)
List<WebElement> actualInstalmentValues = new ArrayList<String>()

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget1Ifr'), GlobalVariable.timeoutShort)

for (int i = 0; i < actualInstalment.size(); i++) {
    String value = actualInstalment.get(i).getText().trim( // Trim spaces
        )

    if (!(value.equals(''))) {
        actualInstalmentValues.add(value)
    }
}

WebUI.switchToDefaultContent()
KeywordUtil.logInfo(actualInstalmentValues)

WebUI.callTestCase(findTestCase('Test Cases/TestData/262200_UnderWritingValidation'), [('testData') : testData, ('rowNumber') : rowNumber], 
    FailureHandling.STOP_ON_FAILURE)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Quality Check']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/checkbox_ViewAllCases'))
//Filtering the policy
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_PolicyFilter'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_PolicyFilter'))
WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_ClearFilter'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_SearchTextInFilter', [('fieldName') : 'Search Text']), 
    GlobalVariable.PolicyRef)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Apply'))

//Clicking on task link
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_TaskLink'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_TaskLink'))
WebUI.switchToFrame(findTestObject('Object Repository/OutwardsPolicy/iframe_PegaGadget2Ifr'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)
//Verifying Data Validation field names

WebUI.callTestCase(findTestCase('Test Cases/NewBusiness/SubTestCase03_262200'), [('testData') : testData, ('rowNumber') : rowNumber],
	FailureHandling.STOP_ON_FAILURE)

