package com.submission.helper

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import com.kms.katalon.core.testobject.TestObject

public class NewSubmission {
	@Keyword
	public static String createSubmissionQuoted(String testData,int rowNumber) {
		try {
			
			WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
			//Click on the 'Create' button.
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))
			WebUI.delay(GlobalVariable.timeoutShort)
			//Wait for the 'Start Financial Lines Submission' element to be visible.
			/*
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			//Click on the 'Start Financial Lines Submission' element.
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'))
*/
			WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))
			
			WebUI.delay(GlobalVariable.timeoutShort)
			//Wait for the 'Insured' element to be visible
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'))
			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'))
			//WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			String InsuredName = 'Non Bureau KandR Payment Tab' + "${ new SimpleDateFormat('MMddHHmmss').format(new Date())}_${UUID.randomUUID().toString()}"


			GlobalVariable.insuredName = InsuredName

			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_BusinessUnit'), InsuredName)
			WebUI.delay(GlobalVariable.timeoutShort)


			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_SearchName'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/radioButton_InsuredType', [('insuredType') : 'K&R Insured']))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'),
					GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'), findTestData(
					testData).getValue('Addressline', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'), findTestData(
					testData).getValue('PostCode', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'), findTestData(
					testData).getValue('City', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
					'Country', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
					findTestData(testData).getValue('NAIC Division', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			if (!(findTestData(testData).getValue('ActualInsured', rowNumber).equals(''))) {
				WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Actual Insured']),
				findTestData(testData).getValue('ActualInsured', rowNumber))
				WebUI.delay(GlobalVariable.timeoutShort)
			}

			WebUI.click(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Name']))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Name']), InsuredName)

			WebUI.delay(GlobalVariable.timeoutShort)


			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
					findTestData(testData).getValue('NAIC Description', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'),
					findTestData(testData).getValue('Public/Private', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			if (!(findTestData(testData).getValue('State', rowNumber).equals(''))) {
				WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'State']))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'State']),
				findTestData(testData).getValue('State', rowNumber), false)
				WebUI.delay(GlobalVariable.timeoutShort)
			}

			WebUI.delay(GlobalVariable.timeoutShort)

			if (!(findTestData(testData).getValue('TargetName', rowNumber).equals(''))) {
				WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_MinimumCharacters', [('input') : 'Target Name']),
				findTestData(testData).getValue('TargetName', rowNumber), FailureHandling.STOP_ON_FAILURE)
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : findTestData(
					testData).getValue('TargetName', rowNumber)]), GlobalVariable.timeOutValue)

				WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : findTestData(
					testData).getValue('TargetName', rowNumber)]))

				WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : findTestData(
					testData).getValue('TargetName', rowNumber)]))
				WebUI.delay(GlobalVariable.timeoutShort)
			}
			WebUI.delay(GlobalVariable.timeoutShort)
			if (!(findTestData(testData).getValue('ParentInsured', rowNumber).equals(''))) {
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_MinimumCharacters', [('input') : 'Parent Insured']),
				findTestData(testData).getValue('ParentInsured', rowNumber))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : findTestData(
					testData).getValue('ParentInsured', rowNumber)]), 5)

				WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : findTestData(
					testData).getValue('ParentInsured', rowNumber)]))

				WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : findTestData(
					testData).getValue('ParentInsured', rowNumber)]))
				WebUI.delay(GlobalVariable.timeoutShort)
			}else {

				WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'),
						GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.delay(GlobalVariable.timeoutShort)

				WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'))
				WebUI.delay(GlobalVariable.timeoutShort)
			}

			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
					[('optionToSelect') : 'No']), GlobalVariable.timeOutValue)

			WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
					[('optionToSelect') : 'No']))
			WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
					[('optionToSelect') : 'No']))
			WebUI.delay(GlobalVariable.timeOutValue)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'),
					GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
					'CountryName', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']),
			findTestData(testData).getValue('Broker', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]))

			WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]))

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'),
					findTestData(testData).getValue('Broker Contact', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
			WebUI.delay(GlobalVariable.timeoutShort)
			SubmissionHelper.enterGeneralData(testData, rowNumber)

			WebUI.delay(GlobalVariable.timeoutShort)

			//Fetching case ID details
			String caseID = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_CaseID'))

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/button_OK'), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

			WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_PolicyReference'), 180)

			return caseID
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String createSubmission(String testData,int rowNumber) {
		try {
			WebUI.delay(GlobalVariable.timeoutShort)
		
			WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))
			WebUI.delay(GlobalVariable.timeoutShort)
			/*
			//Wait for the 'Start Financial Lines Submission' element to be visible.
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			//Click on the 'Start Financial Lines Submission' element.
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'))
			WebUI.delay(GlobalVariable.timeoutShort)
			*/
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Yes',[('reinsuredYes'):'No']))
			
			//Wait for the 'Insured' element to be visible
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'))
			WebUI.delay(GlobalVariable.timeoutShort)
			String InsuredName = 'Non Bureau Fac RI Cyber Renewal' + "${ new SimpleDateFormat('MMddHHmmss').format(new Date())}_${UUID.randomUUID().toString()}"

			GlobalVariable.insuredName = InsuredName

			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_BusinessUnit'), InsuredName)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForPageLoad(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_SearchName'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'),
					GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'), findTestData(
					testData).getValue('Addressline', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'), findTestData(
					testData).getValue('PostCode', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'), findTestData(
					testData).getValue('City', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
					'Country', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)


			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
					findTestData(testData).getValue('NAIC Division', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			if (!(findTestData(testData).getValue('ActualInsured', rowNumber).equals(''))) {
				WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Actual Insured']),
				findTestData(testData).getValue('ActualInsured', rowNumber))
			}
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'))

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'))
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
					findTestData(testData).getValue('NAIC Description', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'),
					findTestData(testData).getValue('Public/Private', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			if (!(findTestData(testData).getValue('State', rowNumber).equals(''))) {
				WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'State']))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'State']),
				findTestData(testData).getValue('State', rowNumber), false)
			}

			WebUI.delay(GlobalVariable.timeoutShort)

			SubmissionHelper.selectReinsured(testData, rowNumber)

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'), 10)
			
			WebUI.check(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'))

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 60)
			
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
			WebUI.delay(GlobalVariable.timeOutValue)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'),
					60)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))
			WebUI.delay(GlobalVariable.timeoutShort)
			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
					'CountryName', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']),
			findTestData(testData).getValue('Broker', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]), GlobalVariable.timeOutValue)

			WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'),
					findTestData(testData).getValue('Broker Contact', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'),
					findTestData(testData).getValue('Class Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)


			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMajorClass'),
					findTestData(testData).getValue('Major Class', rowNumber), false)

			String lineOfBusiness = findTestData(testData).getValue('Major Class', rowNumber)

			GlobalVariable.LineOfBusiness = lineOfBusiness

			WebUI.delay(GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeOutValue)
			

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMinorClass'),
					findTestData(testData).getValue('Minor Class', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClass'), 25)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClass'),
					findTestData(testData).getValue('Class', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'), 25)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'),
					findTestData(testData).getValue('Placing Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownSubPlacingType'), 25)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownSubPlacingType'),
					findTestData(testData).getValue('Sub Placing Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)

			if(!(findTestData(testData).getValue('TMHCC Placing Title', rowNumber).equals(''))) {
				WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement',
						[('fieldtoSelect') : 'TMHCCPlacingTitle']), findTestData(testData).getValue('TMHCC Placing Title', rowNumber),
						false)
				WebUI.delay(GlobalVariable.timeoutShort)
			}

			if(!(findTestData(testData).getValue('ISPrimary', rowNumber).equals(''))) {
				WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement',
						[('fieldtoSelect') : 'pIsPrimaryOrExcess']), findTestData(testData).getValue('ISPrimary', rowNumber),
						false)
				WebUI.delay(GlobalVariable.timeoutShort)
			}

			WebUI.delay(GlobalVariable.timeoutShort)



			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwriter'),
					findTestData(testData).getValue('Underwriter', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)


			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant'),
					findTestData(testData).getValue('Underwriting Assistant', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)


			WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Producing Team ']),
			findTestData(testData).getValue('Producing Team', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			//WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
			//		[('labelName') : 'Is SME']), GlobalVariable.timeoutShort)

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
			//WebUI.verifyElementNotChecked(findTestObject('Object Repository/OutwardsPolicy/radioButton_FieldName',[("fieldName"):'Is SME']), GlobalVariable.timeOutValue)
			WebUI.verifyElementNotChecked(findTestObject('Object Repository/OutwardsPolicy/radioButton_FieldName',[("fieldName"):'Is Master']), GlobalVariable.timeOutValue)
			WebUI.verifyElementNotChecked(findTestObject('Object Repository/OutwardsPolicy/radioButton_FieldName',[("fieldName"):'Is Local']), GlobalVariable.timeOutValue)
			WebUI.verifyElementNotChecked(findTestObject('Object Repository/OutwardsPolicy/radioButton_FieldName',[("fieldName"):'Is Tied In']), GlobalVariable.timeOutValue)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'))

			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'),
					findTestData(testData).getValue('Inception Date', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			String inceptionDate = findTestData(testData).getValue('Inception Date', rowNumber)

			GlobalVariable.InceptionDate = inceptionDate

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'),
					findTestData(testData).getValue('Entity', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'),
					findTestData(testData).getValue('Legal Branch', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			//TODO: I need to know when it should be bureau to don't do this
			if (WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), 25, FailureHandling.OPTIONAL) ){
				if ( WebUI.verifyElementChecked(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), 25, FailureHandling. OPTIONAL ) ){
					WebUI.uncheck(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), FailureHandling.OPTIONAL)
				}
			}
			
			if(!(findTestData(testData).getValue('K&Rtype', rowNumber).equals(''))) {
				WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_KrType'), findTestData(testData).getValue('K&Rtype', rowNumber),
						false)
				WebUI.delay(GlobalVariable.timeoutShort)
			}

			WebUI.waitForPageLoad(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

			WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/button_OK'), 180, FailureHandling.STOP_ON_FAILURE)

			WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_PolicyReference'), 180)

			return InsuredName
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String createSubmissionKAndR(String testData,int rowNumber) {
		try {
			
			WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
			//Click on the 'Create' button.
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))
			WebUI.delay(GlobalVariable.timeoutShort)
			//Wait for the 'Start Financial Lines Submission' element to be visible.
			/*
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			//Click on the 'Start Financial Lines Submission' element.
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'))
			*/
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Yes',[('reinsuredYes'):'No']))
			
			WebUI.delay(GlobalVariable.timeoutShort)
			//Wait for the 'Insured' element to be visible
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'))
			WebUI.delay(GlobalVariable.timeoutShort)
			String InsuredName = 'K&R Policy Period Endorsement ' + "${ new SimpleDateFormat('MMddHHmmss').format(new Date())}_${UUID.randomUUID().toString()}"

			GlobalVariable.insuredName = InsuredName

			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_BusinessUnit'), InsuredName)

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_SearchName'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/radioButton_InsuredType', [('insuredType') : 'K&R Insured']))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'),
					GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'), findTestData(
					testData).getValue('Addressline', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'), findTestData(
					testData).getValue('PostCode', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'), findTestData(
					testData).getValue('City', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
					'Country', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
					findTestData(testData).getValue('NAIC Division', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			if (!(findTestData(testData).getValue('ActualInsured', rowNumber).equals(''))) {
				WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Actual Insured']),
				findTestData(testData).getValue('ActualInsured', rowNumber))
			}

			WebUI.click(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Name']))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Name']), InsuredName)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForPageLoad(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'))

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
					findTestData(testData).getValue('NAIC Description', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'),
					findTestData(testData).getValue('Public/Private', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)

			if (!(findTestData(testData).getValue('State', rowNumber).equals(''))) {
				WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'State']))

				WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'State']),
				findTestData(testData).getValue('State', rowNumber), false)
			}

			WebUI.delay(GlobalVariable.timeoutShort)

			if (!(findTestData(testData).getValue('TargetName', rowNumber).equals(''))) {
				WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_MinimumCharacters', [('input') : 'Target Name']),
				findTestData(testData).getValue('TargetName', rowNumber), FailureHandling.STOP_ON_FAILURE)
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : findTestData(
					testData).getValue('TargetName', rowNumber)]), GlobalVariable.timeOutValue)

				WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : findTestData(
					testData).getValue('TargetName', rowNumber)]))

				WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : findTestData(
					testData).getValue('TargetName', rowNumber)]))
				WebUI.delay(GlobalVariable.timeoutShort)
			}

			SubmissionHelper.selectReinsured(testData, rowNumber)

			WebUI.waitForPageLoad(GlobalVariable.timeoutShort)
			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), GlobalVariable.timeOutValue)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'),
					GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
					'CountryName', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']),
			findTestData(testData).getValue('Broker', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]))

			WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]))

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'),
					findTestData(testData).getValue('Broker Contact', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

			SubmissionHelper.enterGeneralData(testData, rowNumber)

			WebUI.waitForPageLoad(GlobalVariable.timeoutShort)

			//Fetching case ID details
			String caseID = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_CaseID'))

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/button_OK'), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

			WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_PolicyReference'), 180)

			return InsuredName
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}


	public static void enterGeneralDetails(String testData,int rowNumber) {
		try {
			
			WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
			//Click on the 'Create' button.
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))
			WebUI.delay(GlobalVariable.timeoutShort)
			/*
			//Wait for the 'Start Financial Lines Submission' element to be visible.
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			//Click on the 'Start Financial Lines Submission' element.
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'))
			*/
			//TODO: Make it work without UX changes
			if (WebUI.verifyElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'), FailureHandling.OPTIONAL)) {
				WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'))
			}
			
			WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))
			
			
			
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Yes',[('reinsuredYes'):'No']))
			
			WebUI.delay(GlobalVariable.timeoutShort)
			//Wait for the 'Insured' element to be visible
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'))
			WebUI.delay(GlobalVariable.timeoutShort)
			String InsuredName = 'AUTO_' + GenericUtils.getCurrentTimestamp()

			GlobalVariable.insuredName = InsuredName

			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_BusinessUnit'), InsuredName)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_SearchName'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/radioButton_InsuredType', [('insuredType') : 'K&R Insured']),
			GlobalVariable.timeOutValue)

			WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/radioButton_InsuredType', [('insuredType') : 'K&R Insured']))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'),
					GlobalVariable.timeOutValue)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'), findTestData(
					testData).getValue('Addressline', rowNumber))

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'), findTestData(
					testData).getValue('PostCode', rowNumber))

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'), findTestData(
					testData).getValue('City', rowNumber))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
					'Country', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			if (!(findTestData(testData).getValue('ActualInsured', rowNumber).equals(''))) {
				WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Actual Insured']),
				findTestData(testData).getValue('ActualInsured', rowNumber))
			}

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
					findTestData(testData).getValue('NAIC Division', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)



			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
					findTestData(testData).getValue('NAIC Description', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'),
					findTestData(testData).getValue('Public/Private', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
					[('optionToSelect') : 'No']), GlobalVariable.timeOutValue)

			WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
					[('optionToSelect') : 'No']))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'),
					GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
					'CountryName', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']),
			findTestData(testData).getValue('Broker', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]), GlobalVariable.timeOutValue)

			WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]))

			WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'),
					findTestData(testData).getValue('Broker Contact', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

			WebUI.delay(GlobalVariable.timeoutShort)
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
}
