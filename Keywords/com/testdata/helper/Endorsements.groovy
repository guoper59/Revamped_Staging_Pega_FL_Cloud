package com.testdata.helper

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Endorsements {
	
	public static void enterAndVerifyEndorsementDetails(String testData,int rowNumber) {
		try {
			WebUI.waitForPageLoad(GlobalVariable.timeoutShort)
			
			WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']),
				GlobalVariable.timeOutValue)
			
			WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']))
			
			WebUI.delay(GlobalVariable.timeOutValue)
			
			WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']),
				findTestData(testData).getValue('Territorial Scope', rowNumber), false)
			
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ApplicableLaw'),
				GlobalVariable.timeOutValue)
			
			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ApplicableLaw'), findTestData(
					testData).getValue('Applicable Law', rowNumber))
			
			WebUI.delay(GlobalVariable.timeOutValue)
			
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
			
			WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), 25)
			
			WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'))
			
			WebUI.delay(GlobalVariable.timeOutValue)
			
			WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_MultiQuote'), 25)
			
			WebUI.click(findTestObject('Object Repository/NewBusiness/button_MultiQuote'))
			
			//WebUI.click(findTestObject('Object Repository/NewBusiness/button_MultiQuote'))
			WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OpenQuote'), 25)
			
			WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OpenQuote'))
			
			WebUI.delay(GlobalVariable.timeoutShort)
			
			//Verifying the values
			String inceptionDate = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
					[('labelName') : 'Inception Date ']), 'value')
			
			GenericUtils.verifyMatch('Inception Date Value is', inceptionDate, '01/03/2023', 'EQUAL')
			
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
			
			WebUI.delay(GlobalVariable.timeOutValue)
			
			WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
			
			WebUI.delay(GlobalVariable.timeoutShort)
	
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	
	public static void verifyEndorsementFields(String insuredName,String testData,int rowNumber) {
		try {
			WebUI.verifyElementPresent(findTestObject('Object Repository/Endorsements/webElement_FieldDetails', [('fieldName') : 'Name'
				, ('fieldValue') : insuredName]), GlobalVariable.timeOutValue)
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Endorsements/webElement_FieldDetails', [('fieldName') : 'Actual Insured'
				, ('fieldValue') : findTestData(testData).getValue('ActualInsured', rowNumber)]), GlobalVariable.timeOutValue)
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Endorsements/webElement_FieldDetails', [('fieldName') : 'Address line 1'
				, ('fieldValue') : findTestData(testData).getValue('Addressline', rowNumber)]), GlobalVariable.timeOutValue)
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Endorsements/webElement_FieldDetails', [('fieldName') : 'City'
				, ('fieldValue') : findTestData(testData).getValue('City', rowNumber)]), GlobalVariable.timeOutValue)
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Endorsements/webElement_FieldDetails', [('fieldName') : 'Post Code'
				, ('fieldValue') : findTestData(testData).getValue('PostCode', rowNumber)]), GlobalVariable.timeOutValue)
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Endorsements/webElement_FieldDetails', [('fieldName') : 'Country'
				, ('fieldValue') : findTestData(testData).getValue('Country', rowNumber)]), GlobalVariable.timeOutValue)
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Endorsements/webElement_FieldDetails', [('fieldName') : 'NAIC Division'
				, ('fieldValue') : findTestData(testData).getValue('NAIC Division', rowNumber)]), GlobalVariable.timeOutValue)
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Endorsements/webElement_FieldDetails', [('fieldName') : 'NAIC Description'
				, ('fieldValue') : findTestData(testData).getValue('NAIC Description', rowNumber)]), GlobalVariable.timeOutValue)
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Endorsements/webElement_FieldDetails', [('fieldName') : 'Public/Private'
				, ('fieldValue') : findTestData(testData).getValue('Public/Private', rowNumber)]), GlobalVariable.timeOutValue)
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/Endorsements/webElement_FieldDetails', [('fieldName') : 'Status'
				, ('fieldValue') : 'Approved']), GlobalVariable.timeOutValue)
	
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}

}
