package com.testdata.helper

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable
import com.kms.katalon.core.testobject.TestObject


public class UWWorksheet {
	@Keyword
	public static String createSubmission(String testData,int rowNumber) {
		try {
			WebUI.delay(5)
			WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
			//Click on the 'Create' button.
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))
			WebUI.delay(5)
			/*
			//Wait for the 'Start Financial Lines Submission' element to be visible.
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			//Click on the 'Start Financial Lines Submission' element.
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'))
			*/
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Yes',[('reinsuredYes'):'No']))
			
			WebUI.delay(5)
			//Wait for the 'Insured' element to be visible
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'))
			WebUI.delay(5)
			String InsuredName = 'TMHCC Test Worksheet commercial' + "${ new SimpleDateFormat('MMddHHmmss').format(new Date())}_${UUID.randomUUID().toString()}"

			GlobalVariable.insuredName = InsuredName
			WebUI.delay(5)
			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_BusinessUnit'), InsuredName)
			WebUI.delay(5)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(5)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_SearchName'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'),
					GlobalVariable.timeOutValue)
			WebUI.delay(5)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'), findTestData(
					testData).getValue('Addressline', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'), findTestData(
					testData).getValue('PostCode', rowNumber))
			WebUI.delay(5)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'), findTestData(
					testData).getValue('City', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
					'Country', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
					findTestData(testData).getValue('NAIC Division', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'))

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'))
			
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
					25, FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'))
			WebUI.delay(GlobalVariable.timeoutShort)
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
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 25)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'),
					25)

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
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'),
					GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'),
					findTestData(testData).getValue('Class Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMajorClass'), 60)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMajorClass'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMajorClass'),
					findTestData(testData).getValue('Major Class', rowNumber), false)

			String lineOfBusiness = findTestData(testData).getValue('Major Class', rowNumber)

			GlobalVariable.LineOfBusiness = lineOfBusiness

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMinorClass'), 60)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMinorClass'))

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMinorClass'),
					findTestData(testData).getValue('Minor Class', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClass'), GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClass'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClass'),
					findTestData(testData).getValue('Class', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'),
					GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'))

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'),
					findTestData(testData).getValue('Placing Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownSubPlacingType'),
					GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownSubPlacingType'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownSubPlacingType'),
					findTestData(testData).getValue('Sub Placing Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)

			if(!(findTestData(testData).getValue('TMHCC Placing Title', rowNumber).equals(''))) {
				WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement',
						[('fieldtoSelect') : 'TMHCCPlacingTitle']), findTestData(testData).getValue('TMHCC Placing Title', rowNumber),
						false)
			}
			WebUI.delay(GlobalVariable.timeoutShort)
			if(!(findTestData(testData).getValue('ISPrimary', rowNumber).equals(''))) {
				WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement',
						[('fieldtoSelect') : 'pIsPrimaryOrExcess']), findTestData(testData).getValue('ISPrimary', rowNumber),
						false)
			}

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwriter'),
					GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwriter'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwriter'),
					findTestData(testData).getValue('Underwriter', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant'),
					GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant'),
					findTestData(testData).getValue('Underwriting Assistant', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Producing Team ']),
			GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Producing Team ']))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Producing Team ']),
			findTestData(testData).getValue('Producing Team', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.verifyElementNotChecked(findTestObject('Object Repository/OutwardsPolicy/radioButton_FieldName',[("fieldName"):'Is SME']), GlobalVariable.timeOutValue)
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

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'),
					GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'))

			WebUI.delay(2)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'),
					findTestData(testData).getValue('Entity', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'),
					GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'),
					findTestData(testData).getValue('Legal Branch', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			if(!(findTestData(testData).getValue('K&Rtype', rowNumber).equals(''))) {
				WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_KrType'), findTestData(testData).getValue('K&Rtype', rowNumber),
						false)
			}
			WebUI.delay(GlobalVariable.timeoutShort)
			//TODO: I need to know when it should be bureau to don't do this
			if (WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), 25, FailureHandling.OPTIONAL) ){
				if ( WebUI.verifyElementChecked(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), 25, FailureHandling. OPTIONAL ) ){
					WebUI.uncheck(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'))
				}
			}

			WebUI.delay(GlobalVariable.timeoutShort)

			// Click on continue button.
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 60)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))
			WebUI.delay(GlobalVariable.timeOutValue)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 60, FailureHandling.OPTIONAL)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), FailureHandling.OPTIONAL)

			WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/button_OK'), 60, FailureHandling.STOP_ON_FAILURE)

			WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_PolicyReference'), 180)

			return InsuredName
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
		public static String verifyStructureTableDetails(String structureName,def list,int index) {
		try {
			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : structureName, ('fieldName') : 'pLayerLimit', ('index') : index]), 'value'), list[
						0])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : structureName, ('fieldName') : 'pUL', ('index') : index]), 'value'), list[
						1])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : structureName, ('fieldName') : 'pLayerGWP', ('index') : index]), 'value'), list[
						2])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : structureName, ('fieldName') : 'pLeadName', ('index') : index]), 'value'), list[
						3])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : structureName, ('fieldName') : 'pLeadPercent', ('index') : index]), 'value'), list[
						4])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : structureName, ('fieldName') : 'pTMHCCPercnt', ('index') : index]), 'value'), list[
						5])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText', [('section') : structureName
				, ('fieldName') : 'TMHCC Gross Limit', ('index') : index])), list[9])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText', [('section') : structureName
				, ('fieldName') : 'TMHCC Gross Premium', ('index') : index])), list[10])

			WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pCom', ('index') : index]), GlobalVariable.timeOutValue)

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : structureName, ('fieldName') : 'pCom', ('index') : index]), 'value'), list[
						6])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : structureName, ('fieldName') : 'pCom', ('index') : index]), 'value'), list[
						6])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText', [('section') : structureName
				, ('fieldName') : 'ROL', ('index') : index])), list[7])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText', [('section') : structureName
				, ('fieldName') : '% of UL', ('index') : index])), list[8])
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String verifyStructureTableHeaderDetails(String structureName) {
		try {
			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : structureName
				, ('fieldName') : 'Position']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : structureName
				, ('fieldName') : 'Layer Limit']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : structureName
				, ('fieldName') : 'U/L']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : structureName
				, ('fieldName') : 'Layer GWP']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : structureName
				, ('fieldName') : 'Name of Lead']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : structureName
				, ('fieldName') : 'Coverage']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : structureName
				, ('fieldName') : 'Lead in %']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : structureName
				, ('fieldName') : 'TMHCC %']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : structureName
				, ('fieldName') : 'TMHCC Gross Limit']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : structureName
				, ('fieldName') : 'TMHCC Gross Premium']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : structureName
				, ('fieldName') : 'Fac Limit']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : structureName
				, ('fieldName') : 'Com']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : structureName
				, ('fieldName') : 'ROL']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : structureName
				, ('fieldName') : '% of UL']), GlobalVariable.timeOutValue)
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String verifyPricingOptionsStructureTableDetails(def list,int index) {
		try {
			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Pricing Options', ('fieldName') : 'pLayerLimit', ('index') : index]), 'value'), list[
						0])
			int i
			if(index==2) {
				i=3
			}else {
				i= index
			}

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Pricing Options', ('fieldName') : 'pUL', ('index') : i]), 'value'), list[
						1])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Pricing Options', ('fieldName') : 'pLayerGWP', ('index') : index]), 'value'), list[
						2])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Pricing Options', ('fieldName') : 'pLeadName', ('index') : index]), 'value'), list[
						3])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Pricing Options', ('fieldName') : 'pLeadPercent', ('index') : index]), 'value'), list[
						4])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Pricing Options', ('fieldName') : 'pTMHCCPercnt', ('index') : index]), 'value'), list[
						5])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText', [('section') : 'Pricing Options'
				, ('fieldName') : 'TMHCC Gross Limit', ('index') : index])), list[9])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText', [('section') : 'Pricing Options'
				, ('fieldName') : 'TMHCC Gross Premium', ('index') : index])), list[10])

			WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Pricing Options'
				, ('fieldName') : 'pCom', ('index') : index]), GlobalVariable.timeOutValue)

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Pricing Options', ('fieldName') : 'pCom', ('index') : index]), 'value'), list[
						6])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText', [('section') : 'Pricing Options'
				, ('fieldName') : 'ROL', ('index') : index])), list[7])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Pricing Options', ('fieldName') : 'pULPercent', ('index') : index]), 'value'), list[
						8])
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String verifyUIdetails(String insuredName, String testData, int rowNumber) {
		try {
			WebUI.delay(GlobalVariable.timeoutShort)
			String progID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_WorksheetDetailsFields', [('fieldName') : 'Programme ID']))

			if (progID.substring(0).matches('M')) {
				KeywordUtil.logInfo(('Multi Programm ID ' + progID) + ' displayed in correct format')
			}

			String workSheetID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_WorksheetDetailsFields', [('fieldName') : 'Worksheet ID']))

			if (workSheetID.substring(0).matches('W-')) {
				KeywordUtil.logInfo(('Worksheet ID ' + workSheetID) + ' displayed in correct format')
			}

			String sandpUniqueIdentifier = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_WorksheetDetailsFields',
					[('fieldName') : 'S & P Unique Identifier']))

			if (sandpUniqueIdentifier.equals('')) {
				KeywordUtil.logInfo('S & P Unique Identifier is displayed correctly')
			}

			String sandpCompanyName = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_WorksheetDetailsFields',
					[('fieldName') : 'S & P Company Name']))

			if (sandpCompanyName.equals('')) {
				KeywordUtil.logInfo('S & P Company Name is displayed correctly')
			}

			String sandpRefreshUser = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_WorksheetDetailsFields',
					[('fieldName') : 'S & P Refresh User']))

			if (sandpRefreshUser.equals('')) {
				KeywordUtil.logInfo('S & P Refresh User is displayed correctly')
			}

			String sandpDataRefreshDate = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_WorksheetDetailsFields',
					[('fieldName') : 'S & P Data Refresh Date']))

			if (sandpDataRefreshDate.equals('')) {
				KeywordUtil.logInfo('S & P Data Refresh Date is displayed correctly')
			}
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_IsParent'), GlobalVariable.timeoutShort)

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Insured Name'])),
			insuredName)

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'NAIC Division'])),
			findTestData(testData).getValue('NAIC Division', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'NAIC Description'])),
			findTestData(testData).getValue('NAIC Description', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Country'])),
			findTestData(testData).getValue('Country', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Public/Private'])),
			findTestData(testData).getValue('Public/Private', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Policy Reference'])),
			GlobalVariable.PolicyRef)

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Broker'])),
			findTestData(testData).getValue('Broker', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Broker Contact'])),
			findTestData(testData).getValue('Broker Contact', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Underwriter'])),
			findTestData(testData).getValue('Underwriter', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Placing Type'])),
			findTestData(testData).getValue('Placing Type', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Minor Class'])),
			findTestData(testData).getValue('Minor Class', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Effective Date'])),
			findTestData(testData).getValue('Inception Date', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Legal Branch'])),
			findTestData(testData).getValue('Legal Branch', rowNumber))

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/label_CompanyInformationFields', [('fieldName') : 'Year Established']),
			GlobalVariable.timeoutShort)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/label_CompanyInformationFields', [('fieldName') : 'Short company description']),
			GlobalVariable.timeoutShort)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/label_CompanyInformationFields', [('fieldName') : 'Additional Company Description']),
			GlobalVariable.timeoutShort)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/label_CompanyInformationFields', [('fieldName') : 'Points of attention from expiring coverage?']),
			GlobalVariable.timeoutShort)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/label_CompanyInformationFields', [('fieldName') : 'Is the Company part of a larger Group?']),
			GlobalVariable.timeoutShort)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/label_CompanyInformationFields', [('fieldName') : 'Is the Company part of a larger Group?']),
			GlobalVariable.timeoutShort)
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}


	@Keyword
	public static String verifyUIFields(String insuredName, String status, List<String> collapseAllHeaderList) {
		try {
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/UWWorksheet/link_UWWorkSheetStage'))

			WebUI.delay(GlobalVariable.timeoutShort)
			/*
			WebUI.verifyTextPresent(insuredName, false)

			WebUI.verifyTextPresent(status, false)
			*/
			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'Overview']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'UW Worksheet']),
			GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'History']), GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']),
			GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_InsuredName'), 'value'), insuredName)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/toolTip_InsuredName'), GlobalVariable.timeOutValue)

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'S&P Unique Identifier']),
			'value'), '')

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'City']),
			'value'), '')

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'Country']),
			'value'), '')

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/UWWorksheet/button_SPData'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/UWWorksheet/button_CollapseAll'))

			WebUI.delay(GlobalVariable.timeoutShort)

			List<WebElement> collapsableHeader = WebUI.findWebElements(findTestObject('Object Repository/UWWorksheet/webElement_CollapsableHeadersList'),
					GlobalVariable.timeOutValue)

			List<WebElement> collapsableHeaderNames = new ArrayList<String>()

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.switchToFrame(findTestObject('Object Repository/Page_Worksheets/iframe_PegaGadget2Ifr'), GlobalVariable.timeoutShort)

			WebUI.delay(GlobalVariable.timeoutShort)

			for (WebElement e : collapsableHeader) {
				collapsableHeaderNames.add(e.getText())
			}

			GenericUtils.compareLists(collapsableHeaderNames, collapseAllHeaderList)

			WebUI.switchToDefaultContent()

			WebUI.delay(GlobalVariable.timeoutShort)

			for (int i = 1; i <= collapseAllHeaderList.size(); i++) {
				WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [('header') : collapseAllHeaderList[
						(i - 1)]]), GlobalVariable.timeOutValue)

				String expanded = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [
					('header') : collapseAllHeaderList[(i - 1)]]), 'aria-expanded')

				KeywordUtil.logInfo('When user collapsed all then expanded is false')

				WebUI.verifyEqual(expanded, 'false')
			}

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/UWWorksheet/button_ExpandAll'))

			WebUI.delay(GlobalVariable.timeoutShort)

			for (int i = 1; i <= collapseAllHeaderList.size(); i++) {
				WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [('header') : collapseAllHeaderList[
						(i - 1)]]), GlobalVariable.timeOutValue)

				String expanded = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [
					('header') : collapseAllHeaderList[(i - 1)]]), 'aria-expanded')

				KeywordUtil.logInfo('When user expanded all then expanded is true')

				WebUI.verifyEqual(expanded, 'true')
			}

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_WorksheetDetailsFields', [('fieldName') : 'Programme ID']),
			GlobalVariable.timeoutShort)
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}

	@Keyword
	public static void enterData2022And23Table(List<String> keyFuturesYear2022List,List<String> keyFuturesYear2023List) {
		try {

			WebUI.delay(5)
			List<WebElement> keyFigures = WebUI.findWebElements(findTestObject('Object Repository/UWWorksheet/webElement_ColumnKeyFigures'),
					GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			List<WebElement> keyFiguresList = new ArrayList<String>()

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.switchToFrame(findTestObject('Object Repository/Page_Worksheets/iframe_PegaGadget2Ifr'), GlobalVariable.timeoutShort)

			
			WebUI.delay(GlobalVariable.timeoutShort)

			for (WebElement e : keyFigures) {
				keyFiguresList.add(e.getText())
			}

			WebUI.delay(GlobalVariable.timeoutShort)
			
			KeywordUtil.logInfo('Verifying the fields displayed in Key Figures table')

			GenericUtils.compareLists(keyFiguresList, keyFiguresList)

			WebUI.switchToDefaultContent()
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFigures', [('rowIndex') : 2, ('colIndex') : 5]), GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			for (int i = 2; i <= keyFuturesYear2022List.size(); i++) {
				WebUI.delay(3)
			
				WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFigures', [('rowIndex') : i, ('colIndex') : 5]), 5)
			
				WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFigures', [('rowIndex') : i, ('colIndex') : 5]))
			
				WebUI.delay(GlobalVariable.timeoutShort)
			
				
				WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFigures', [('rowIndex') : i, ('colIndex') : 5]))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFiguresInput', [('rowIndex') : i, ('colIndex') : 5]))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFiguresInput', [('rowIndex') : i, ('colIndex') : 5]),
					keyFuturesYear2022List[(i - 2)])
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFiguresInput', [('rowIndex') : i, ('colIndex') : 5]))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFiguresInput', [('rowIndex') : i
							, ('colIndex') : 5]), Keys.chord(Keys.TAB))
			}

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFigures', [('rowIndex') : 11, ('colIndex') : 5]), 5)

			WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFigures', [('rowIndex') : 11, ('colIndex') : 5]))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFigures', [('rowIndex') : 11, ('colIndex') : 5]))
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFiguresInput', [('rowIndex') : 11, ('colIndex') : 5]))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFiguresInput', [('rowIndex') : 11, ('colIndex') : 5]),
			'-3,383.00')
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFiguresInput', [('rowIndex') : 11, ('colIndex') : 5]))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFiguresInput', [('rowIndex') : 11, ('colIndex') : 5]),
			Keys.chord(Keys.TAB))
			WebUI.delay(GlobalVariable.timeoutShort)
			for (int i = 2; i <= keyFuturesYear2023List.size(); i++) {
				WebUI.delay(3)

				WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFigures', [('rowIndex') : i, ('colIndex') : 6]),5)

				WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFigures', [('rowIndex') : i, ('colIndex') : 6]))

				WebUI.delay(GlobalVariable.timeoutShort)

				WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFigures', [('rowIndex') : i, ('colIndex') : 6]))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFiguresInput', [('rowIndex') : i, ('colIndex') : 6]),
				keyFuturesYear2023List[(i - 2)])
				WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFiguresInput', [('rowIndex') : i, ('colIndex') : 6]))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFiguresInput', [('rowIndex') : i
					, ('colIndex') : 6]), Keys.chord(Keys.TAB))
				WebUI.delay(GlobalVariable.timeoutShort)
			}

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFigures', [('rowIndex') : 11, ('colIndex') : 6]),5)

			WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFigures', [('rowIndex') : 11, ('colIndex') : 6]))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFigures', [('rowIndex') : 11, ('colIndex') : 6]))
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFiguresInput', [('rowIndex') : 11, ('colIndex') : 6]),
			'-3,383.00')
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFigures', [('rowIndex') : 11, ('colIndex') : 6]))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_TableCellKeyFiguresInput', [('rowIndex') : 11, ('colIndex') : 6]),
			Keys.chord(Keys.TAB))

			WebUI.delay(GlobalVariable.timeoutShort)
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}



	@Keyword
	public static String verifyFinalProgramStructureTableDetails(def list,int index) {
		try {
			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pLayerLimit', ('index') : index]), 'value'), list[
						0])
			int i
			if(index==2) {
				i=3
			}else {
				i= index
			}

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pUL', ('index') : i]), 'value'), list[
						1])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pLayerGWP', ('index') : index]), 'value'), list[
						2])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pLeadName', ('index') : index]), 'value'), list[
						3])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pLeadPercent', ('index') : index]), 'value'), list[
						4])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pTMHCCPercnt', ('index') : index]), 'value'), list[
						5])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText', [('section') : 'Final Program Structure'
				, ('fieldName') : 'TMHCC Gross Limit', ('index') : index])), list[9])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText', [('section') : 'Final Program Structure'
				, ('fieldName') : 'TMHCC Gross Premium', ('index') : index])), list[10])

			WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Final Program Structure'
				, ('fieldName') : 'pCom', ('index') : index]), GlobalVariable.timeOutValue)

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pCom', ('index') : index]), 'value'), list[
						6])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText', [('section') : 'Pricing Options'
				, ('fieldName') : 'ROL', ('index') : index])), list[7])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pULPercent', ('index') : index]), 'value'), list[
						8])
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String createFinancialSubmission(String testData,int rowNumber) {
		try {
			WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
			//Click on the 'Create' button.
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'), 60)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

			WebUI.delay(GlobalVariable.timeoutShort)
/*
			//Wait for the 'Start Financial Lines Submission' element to be visible.
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
			String InsuredName = 'TMHCC Test Worksheet 2' + "${ new SimpleDateFormat('MMddHHmmss').format(new Date())}_${UUID.randomUUID().toString()}"

			GlobalVariable.insuredName = InsuredName

			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_BusinessUnit'), InsuredName)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_SearchName'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'),
					25, FailureHandling.STOP_ON_FAILURE)

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

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
					findTestData(testData).getValue('NAIC Division', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'))

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'))
			
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
					60, FailureHandling.STOP_ON_FAILURE)
			WebUI.waitForElementNotHasAttribute(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'), 'disabled', 60, FailureHandling.CONTINUE_ON_FAILURE)
			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'), 60)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'), 60)
						WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
					findTestData(testData).getValue('NAIC Description', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)


			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'),
					25, FailureHandling.STOP_ON_FAILURE)

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
				WebUI.delay(GlobalVariable.timeoutShort)
			}

			WebUI.waitForPageLoad(GlobalVariable.timeOutValue)

			SubmissionHelper.selectReinsured(testData, rowNumber)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 60)
			
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'), 60)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))
			WebUI.delay(GlobalVariable.timeoutShort)
			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))
			WebUI.waitForPageLoad(GlobalVariable.timeOutValue)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
					'CountryName', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']),
			findTestData(testData).getValue('Broker', rowNumber))

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]), 25)

			WebUI.delay(GlobalVariable.timeOutValue)

			//WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
			//	testData).getValue('Broker', rowNumber)]))

			WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]))

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.mouseOver(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'),
					findTestData(testData).getValue('Broker Contact', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'))
			WebUI.mouseOver(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'))
			
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'),
					findTestData(testData).getValue('Class Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)


			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMajorClass'),
					findTestData(testData).getValue('Major Class', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			String lineOfBusiness = findTestData(testData).getValue('Major Class', rowNumber)
			GlobalVariable.LineOfBusiness = lineOfBusiness

			WebUI.delay(GlobalVariable.timeOutValue)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMinorClass'), 60)
			
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMinorClass'))
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMinorClass'),
					findTestData(testData).getValue('Minor Class', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClass'))
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClass'),
					findTestData(testData).getValue('Class', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)


			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'),
					findTestData(testData).getValue('Placing Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)


			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownSubPlacingType'),
					findTestData(testData).getValue('Sub Placing Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			if(!(findTestData(testData).getValue('TMHCC Placing Title', rowNumber).equals(''))) {
				WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement',
						[('fieldtoSelect') : 'TMHCCPlacingTitle']), findTestData(testData).getValue('TMHCC Placing Title', rowNumber),
						false)
			}

			if(!(findTestData(testData).getValue('ISPrimary', rowNumber).equals(''))) {
				WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement',
						[('fieldtoSelect') : 'pIsPrimaryOrExcess']), findTestData(testData).getValue('ISPrimary', rowNumber),
						false)
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

			WebUI.verifyElementNotChecked(findTestObject('Object Repository/OutwardsPolicy/radioButton_FieldName',[("fieldName"):'Is SME']), GlobalVariable.timeOutValue)
			WebUI.verifyElementNotChecked(findTestObject('Object Repository/OutwardsPolicy/radioButton_FieldName',[("fieldName"):'Is Master']), GlobalVariable.timeOutValue)
			WebUI.verifyElementNotChecked(findTestObject('Object Repository/OutwardsPolicy/radioButton_FieldName',[("fieldName"):'Is Local']), GlobalVariable.timeOutValue)
			WebUI.verifyElementNotChecked(findTestObject('Object Repository/OutwardsPolicy/radioButton_FieldName',[("fieldName"):'Is Tied In']), GlobalVariable.timeOutValue)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'))

			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'),
					findTestData(testData).getValue('Inception Date', rowNumber))

			String inceptionDate = findTestData(testData).getValue('Inception Date', rowNumber)

			GlobalVariable.InceptionDate = inceptionDate

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'),
					60)
			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'),
				60)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'),
					findTestData(testData).getValue('Entity', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'),
					60)
			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'),
				25)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'),
					findTestData(testData).getValue('Legal Branch', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			if(!(findTestData(testData).getValue('K&Rtype', rowNumber).equals(''))) {
				WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_KrType'), findTestData(testData).getValue('K&Rtype', rowNumber),
						false)
			}
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 60)
			
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), FailureHandling.OPTIONAL)
			
			WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/button_OK'), 60, FailureHandling.STOP_ON_FAILURE)

			WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_PolicyReference'), 60)

			return InsuredName
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String updateFinancialSubmission(String testData,int rowNumber) {
		try {
			
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_Broker'), 60)
			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Broker'))
			
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropdownCountry'), findTestData(testData).getValue(
					'CountryName', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_MinimumCharacters', [('input') : 'Broker']), findTestData(
			testData).getValue('Broker', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)

			if(findTestData(testData).getValue('Broker', rowNumber)=='Aon UK Limited') {
				WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_KRAutoCompleteResult', [('projectName') : '/1526']),
				GlobalVariable.timeOutValue)

				WebUI.delay(GlobalVariable.timeoutShort)

				WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/webElement_KRAutoCompleteResult', [('projectName') : '/1526']))

				WebUI.enhancedClick(findTestObject('Object Repository/UWWorksheet/webElement_KRAutoCompleteResult', [('projectName') : '/1526']))
			}else {
				WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
					testData).getValue('Broker', rowNumber)]),
				GlobalVariable.timeOutValue)
				WebUI.delay(GlobalVariable.timeoutShort)

				WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
					testData).getValue('Broker', rowNumber)]))

				WebUI.enhancedClick(findTestObject('Object Repository/UWWorksheet/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
					testData).getValue('Broker', rowNumber)]))
			}

			WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropdownBrokerContact'), findTestData(
					testData).getValue('Broker Contact', rowNumber), false)
			WebUI.delay(GlobalVariable.timeOutValue)
			WebUI.click(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/button_Continue'))
			WebUI.delay(GlobalVariable.timeOutValue)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropdownClassType'), findTestData(
					testData).getValue('Class Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropdownMajorClass'), findTestData(
					testData).getValue('Major Class', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)
			//WebUI.click(findTestObject('Object Repository/UWWorksheet/select_DropdownMinorClass'))
			WebUI.waitForElementNotHasAttribute(findTestObject('Object Repository/UWWorksheet/select_DropdownMinorClass'), 'disabled', 60, FailureHandling.OPTIONAL )
			WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropdownMinorClass'), findTestData(
					testData).getValue('Minor Class', rowNumber), false)
			WebUI.delay(GlobalVariable.timeOutValue)
			WebUI.waitForElementNotHasAttribute(findTestObject('Object Repository/UWWorksheet/select_DropdownClass'), 'disabled', 60, FailureHandling.OPTIONAL )
			
			WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropdownClass'), findTestData(
					testData).getValue('Class', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)
			WebUI.waitForElementNotHasAttribute(findTestObject('Object Repository/UWWorksheet/select_DropdownPlacingType'), 'disabled', 60, FailureHandling.OPTIONAL )
			
			WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropdownPlacingType'), findTestData(
					testData).getValue('Placing Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementNotHasAttribute(findTestObject('Object Repository/UWWorksheet/select_DropdownSubPlacingType'), 'disabled', 60, FailureHandling.OPTIONAL )
			
			WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropdownSubPlacingType'), findTestData(
					testData).getValue('Sub Placing Type', rowNumber),
					false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropdownUnderwriter'), findTestData(testData).getValue(
					'Underwriter', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropdownUnderwritingAssistant'), findTestData(
					testData).getValue('Underwriting Assistant', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DynamicDropDown', [('dropDownLabel') : 'Producing Team ']),
			findTestData(testData).getValue('Producing Team', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.verifyElementNotChecked(findTestObject('Object Repository/UWWorksheet/radioButton_FieldName',[("fieldName"):'Is SME']), GlobalVariable.timeOutValue)
			WebUI.verifyElementNotChecked(findTestObject('Object Repository/UWWorksheet/radioButton_FieldName',[("fieldName"):'Is Master']), GlobalVariable.timeOutValue)
			WebUI.verifyElementNotChecked(findTestObject('Object Repository/UWWorksheet/radioButton_FieldName',[("fieldName"):'Is Local']), GlobalVariable.timeOutValue)
			WebUI.verifyElementNotChecked(findTestObject('Object Repository/UWWorksheet/radioButton_FieldName',[("fieldName"):'Is Tied In']), GlobalVariable.timeOutValue)
			WebUI.click(findTestObject('Object Repository/UWWorksheet/input_InceptionDate'))

			WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_InceptionDate'), findTestData(testData).getValue('Inception Date', rowNumber))

			WebUI.delay(GlobalVariable.timeOutValue)
			
			WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropdownEntity'), findTestData(testData).getValue('Entity', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)
			WebUI.waitForElementNotHasAttribute(findTestObject('Object Repository/UWWorksheet/select_DropdownLegalBranch'), 'disabled', 60, FailureHandling.OPTIONAL )			
			WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropdownLegalBranch'), findTestData(testData).getValue('Legal Branch', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)
			//TODO: I need to know when it should be bureau to don't do this
			if (WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), 25, FailureHandling.OPTIONAL) ){
				if ( WebUI.verifyElementChecked(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), 25, FailureHandling. OPTIONAL ) ){
					WebUI.uncheck(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'))
				}
			}
			WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/button_Continue'), 60)
			WebUI.click(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/button_Continue'))
			WebUI.waitForPageLoad(GlobalVariable.timeOutValue)
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String createSubmissionForWorkSheet(String testData,int rowNumber) {
		try {
			//Click on the 'Create' button.
			WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
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
			String InsuredName = 'TMHCC Com Wkt no SnP ' + "${ new SimpleDateFormat('MMddHHmmss').format(new Date())}_${UUID.randomUUID().toString()}"

			GlobalVariable.insuredName = InsuredName

			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_BusinessUnit'), InsuredName)

			WebUI.delay(GlobalVariable.timeoutShort)

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
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'))

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'))
			
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
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

			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
					[('optionToSelect') : 'No']), GlobalVariable.timeOutValue)

			WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
					[('optionToSelect') : 'No']))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'),
					GlobalVariable.timeOutValue)

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

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'),
					findTestData(testData).getValue('Broker Contact', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'),
					findTestData(testData).getValue('Class Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMajorClass'),
					findTestData(testData).getValue('Major Class', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			String lineOfBusiness = findTestData(testData).getValue('Major Class', rowNumber)

			GlobalVariable.LineOfBusiness = lineOfBusiness

			WebUI.delay(GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMinorClass'),
					findTestData(testData).getValue('Minor Class', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClass'),
					findTestData(testData).getValue('Class', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'),
					findTestData(testData).getValue('Placing Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)


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
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant'),
					findTestData(testData).getValue('Underwriting Assistant', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Producing Team ']),
			findTestData(testData).getValue('Producing Team', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/radioButton_FieldName',[("fieldName"):'Is SME']))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.verifyElementChecked(findTestObject('Object Repository/OutwardsPolicy/radioButton_FieldName',[("fieldName"):'Is SME']), GlobalVariable.timeOutValue)
			WebUI.verifyElementNotChecked(findTestObject('Object Repository/OutwardsPolicy/radioButton_FieldName',[("fieldName"):'Is Master']), GlobalVariable.timeOutValue)
			WebUI.verifyElementNotChecked(findTestObject('Object Repository/OutwardsPolicy/radioButton_FieldName',[("fieldName"):'Is Local']), GlobalVariable.timeOutValue)
			WebUI.verifyElementNotChecked(findTestObject('Object Repository/OutwardsPolicy/radioButton_FieldName',[("fieldName"):'Is Tied In']), GlobalVariable.timeOutValue)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'))
			WebUI.delay(GlobalVariable.timeoutShort)
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

			if(!(findTestData(testData).getValue('K&Rtype', rowNumber).equals(''))) {
				WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_KrType'), findTestData(testData).getValue('K&Rtype', rowNumber),
						false)
			}

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 25)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))
			WebUI.delay(GlobalVariable.timeOutLong)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), FailureHandling.OPTIONAL)
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
	@Keyword
	public static String verifyFinalProgramStructureDetails(def list,int index) {
		try {
			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pLayerLimit', ('index') : index]), 'value'), list[
						0])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pUL', ('index') : index]), 'value'), list[
						1])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pLayerGWP', ('index') : index]), 'value'), list[
						2])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pLeadName', ('index') : index]), 'value'), list[
						3])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pLeadPercent', ('index') : index]), 'value'), list[
						4])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pTMHCCPercnt', ('index') : index]), 'value'), list[
						5])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText', [('section') : 'Final Program Structure'
				, ('fieldName') : 'TMHCC Gross Limit', ('index') : index])), list[9])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText', [('section') : 'Final Program Structure'
				, ('fieldName') : 'TMHCC Gross Premium', ('index') : index])), list[10])

			WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Final Program Structure'
				, ('fieldName') : 'pCom', ('index') : index]), GlobalVariable.timeOutValue)

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pCom', ('index') : index]), 'value'), list[
						6])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText', [('section') : 'Final Program Structure'
				, ('fieldName') : 'ROL', ('index') : index])), list[7])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText', [('section') : 'Final Program Structure'
				, ('fieldName') : '% of UL', ('index') : index])), list[8])
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}

	@Keyword
	public static String verifyFinalProgramStructureTableDetails_IFrame1(def list,int index) {
		try {
			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pLayerLimit', ('index') : index]), 'value'), list[
						0])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pUL', ('index') : index]), 'value'), list[
						1])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pLayerGWP', ('index') : index]), 'value'), list[
						2])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pLeadName', ('index') : index]), 'value'), list[
						3])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pLeadPercent', ('index') : index]), 'value'), list[
						4])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pTMHCCPercnt', ('index') : index]), 'value'), list[
						5])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/webElement_TableFieldText', [('section') : 'Final Program Structure'
				, ('fieldName') : 'TMHCC Gross Limit', ('index') : index])), list[9])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/webElement_TableFieldText', [('section') : 'Final Program Structure'
				, ('fieldName') : 'TMHCC Gross Premium', ('index') : index])), list[10])

			WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/webElement_TableColumnField', [('section') : 'Final Program Structure'
				, ('fieldName') : 'pCom', ('index') : index]), GlobalVariable.timeOutValue)

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/webElement_TableColumnField',
					[('section') : 'Final Program Structure', ('fieldName') : 'pCom', ('index') : index]), 'value'), list[
						6])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/webElement_TableFieldText', [('section') : 'Final Program Structure'
				, ('fieldName') : 'ROL', ('index') : index])), list[7])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/webElement_TableFieldText', [('section') : 'Final Program Structure'
				, ('fieldName') : '% of UL', ('index') : index])), list[8])
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String enterDataStructureTableDetails(String structureName,def list,int index) {
		try {
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pLayerLimit', ('index') : index]), GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pLayerLimit', ('index') : index]), list[0])
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pUL', ('index') : index]))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pUL', ('index') : index]), list[1])
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pLayerGWP', ('index') : index]))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pLayerGWP', ('index') : index]), list[2])
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pLeadName', ('index') : index]))
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pLeadName', ('index') : index]), list[4])
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pLeadPercent', ('index') : index]))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pLeadPercent', ('index') : index]), list[5])
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pTMHCCPercnt', ('index') : index]))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pTMHCCPercnt', ('index') : index]), list[6])
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pCom', ('index') : index]))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pCom', ('index') : index]), list[7])
			WebUI.delay(GlobalVariable.timeoutShort)
			//added this to move the cursor from the above field
			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : structureName
				, ('fieldName') : 'pFacLimit', ('index') : index]))
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String verifyPricingOptionsStructureDetails(String headerName,def list,int index) {
		try {
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Pricing Options', ('fieldName') : 'pLayerLimit', ('index') : index]), 'value'), list[
						0])
			int i
			if(index==2) {
				i=3
			}else {
				i= index
			}

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Pricing Options', ('fieldName') : 'pUL', ('index') : i]), 'value'), list[
						1])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Pricing Options', ('fieldName') : 'pLayerGWP', ('index') : index]), 'value'), list[
						2])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Pricing Options', ('fieldName') : 'pLeadName', ('index') : index]), 'value'), list[
						3])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Pricing Options', ('fieldName') : 'pLeadPercent', ('index') : index]), 'value'), list[
						4])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Pricing Options', ('fieldName') : 'pTMHCCPercnt', ('index') : index]), 'value'), list[
						5])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText1', [('header') : headerName,('section') : 'Pricing Options'
				, ('fieldName') : 'TMHCC Gross Limit', ('index') : index])), list[9])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText1', [('header') : headerName,('section') : 'Pricing Options'
				, ('fieldName') : 'TMHCC Gross Premium', ('index') : index])), list[10])

			WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : 'Pricing Options'
				, ('fieldName') : 'pCom', ('index') : index]), GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Pricing Options', ('fieldName') : 'pCom', ('index') : index]), 'value'), list[
						6])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText1', [('header') : headerName,('section') : 'Pricing Options'
				, ('fieldName') : 'ROL', ('index') : index])), list[7])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Pricing Options', ('fieldName') : 'pULPercent', ('index') : index]), 'value'), list[
						8])
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String verifyStructureTableHeaderDetails_Iframe4(String structureName) {
		try {
			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : structureName
				, ('fieldName') : 'Position']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : structureName
				, ('fieldName') : 'Layer Limit']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : structureName
				, ('fieldName') : 'U/L']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : structureName
				, ('fieldName') : 'Layer GWP']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : structureName
				, ('fieldName') : 'Name of Lead']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : structureName
				, ('fieldName') : 'Coverage']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : structureName
				, ('fieldName') : 'Lead in %']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : structureName
				, ('fieldName') : 'TMHCC %']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : structureName
				, ('fieldName') : 'TMHCC Gross Limit']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : structureName
				, ('fieldName') : 'TMHCC Gross Premium']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : structureName
				, ('fieldName') : 'Fac Limit']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : structureName
				, ('fieldName') : 'Com']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : structureName
				, ('fieldName') : 'ROL']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : structureName
				, ('fieldName') : '% of UL']), GlobalVariable.timeOutValue)
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String verifyFinalProgramStructureTableDetails_IFrame4(String headerName,def list,int index) {
		try {
			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Final Program Structure', ('fieldName') : 'pLayerLimit', ('index') : index]), 'value'), list[
						0])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Final Program Structure', ('fieldName') : 'pUL', ('index') : index]), 'value'), list[
						1])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Final Program Structure', ('fieldName') : 'pLayerGWP', ('index') : index]), 'value'), list[
						2])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Final Program Structure', ('fieldName') : 'pLeadName', ('index') : index]), 'value'), list[
						3])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Final Program Structure', ('fieldName') : 'pLeadPercent', ('index') : index]), 'value'), list[
						4])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Final Program Structure', ('fieldName') : 'pTMHCCPercnt', ('index') : index]), 'value'), list[
						5])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText1', [('header') : headerName,('section') : 'Final Program Structure'
				, ('fieldName') : 'TMHCC Gross Limit', ('index') : index])), list[9])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText1', [('header') : headerName,('section') : 'Final Program Structure'
				, ('fieldName') : 'TMHCC Gross Premium', ('index') : index])), list[10])

			WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : 'Final Program Structure'
				, ('fieldName') : 'pCom', ('index') : index]), GlobalVariable.timeOutValue)

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : 'Final Program Structure', ('fieldName') : 'pCom', ('index') : index]), 'value'), list[
						6])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText1', [('header') : headerName,('section') : 'Final Program Structure'
				, ('fieldName') : 'ROL', ('index') : index])), list[7])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText1', [('header') : headerName,('section') : 'Final Program Structure'
				, ('fieldName') : '% of UL', ('index') : index])), list[8])
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}

	@Keyword
	public static String verifyStructureTableDetails_iframe4(String headerName,String structureName,def list,int index) {
		try {
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : structureName, ('fieldName') : 'pLayerLimit', ('index') : index]), 'value'), list[
						0])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : structureName, ('fieldName') : 'pUL', ('index') : index]), 'value'), list[
						1])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : structureName, ('fieldName') : 'pLayerGWP', ('index') : index]), 'value'), list[
						2])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : structureName, ('fieldName') : 'pLeadName', ('index') : index]), 'value'), list[
						3])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : structureName, ('fieldName') : 'pLeadPercent', ('index') : index]), 'value'), list[
						4])
			
			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : structureName, ('fieldName') : 'pTMHCCPercnt', ('index') : index]), 'value'), list[
						5])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'TMHCC Gross Limit', ('index') : index])), list[9])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'TMHCC Gross Premium', ('index') : index])), list[10])

			WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'pCom', ('index') : index]), GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : structureName, ('fieldName') : 'pCom', ('index') : index]), 'value'), list[
						6])

			WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1',
					[('header') : headerName,('section') : structureName, ('fieldName') : 'pCom', ('index') : index]), 'value'), list[
						6])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'ROL', ('index') : index])), list[7])

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldText1', [('header') : headerName,('section') : structureName
				, ('fieldName') : '% of UL', ('index') : index])), list[8])
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String enterDataStructureFieldTableDetails(String headerName,String structureName,def list,int index) {
		try {
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.clearText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'pLayerLimit', ('index') : index]))
			WebUI.delay(2)
			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'pLayerLimit', ('index') : index]), list[0])
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.clearText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'pUL', ('index') : index]))
			WebUI.delay(2)
			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'pUL', ('index') : index]), list[1])
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.clearText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'pLayerGWP', ('index') : index]))
			WebUI.delay(2)
			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'pLayerGWP', ('index') : index]), list[2])
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'pLeadName', ('index') : index]))
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'pLeadName', ('index') : index]), list[4])
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'pLeadPercent', ('index') : index]), list[5])
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'pTMHCCPercnt', ('index') : index]), list[6])
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'pCom', ('index') : index]))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField1', [('header') : headerName,('section') : structureName
				, ('fieldName') : 'pCom', ('index') : index]), list[7])
			WebUI.delay(GlobalVariable.timeoutShort)
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String verifyWorkSheetDetailsFor_259399(String testData,int rowNumber) {
		try {
			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText1', [('fieldName') : 'NAIC Division'])),
			findTestData(testData).getValue('NAIC Division', rowNumber))
			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText1', [('fieldName') : 'NAIC Description'])),
			findTestData(testData).getValue('NAIC Description', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText1', [('fieldName') : 'Country'])),
			findTestData(testData).getValue('Country', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText1', [('fieldName') : 'Public/Private'])),
			findTestData(testData).getValue('Public/Private', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue1', [('fieldName') : 'Policy Reference'])),
			GlobalVariable.PolicyRef)

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue1', [('fieldName') : 'Broker'])),
			findTestData(testData).getValue('Broker', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue1', [('fieldName') : 'Broker Contact'])),
			findTestData(testData).getValue('Broker Contact', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue1', [('fieldName') : 'Underwriter'])),
			findTestData(testData).getValue('Underwriter', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue1', [('fieldName') : 'Placing Type'])),
			findTestData(testData).getValue('Placing Type', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue1', [('fieldName') : 'Reinsured'])),
			'AIG Europe Limited')

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue1', [('fieldName') : 'Major Class'])),
			'D&O')

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue1', [('fieldName') : 'Minor Class'])),
			findTestData(testData).getValue('Minor Class', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue1', [('fieldName') : 'Effective Date'])),
			findTestData(testData).getValue('Inception Date', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnText1', [('fieldName') : 'Expiration Date'])),
			'01/03/2024')

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue1', [('fieldName') : 'Entity'])),
			'TME')

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue1', [('fieldName') : 'Legal Branch'])),
			findTestData(testData).getValue('Legal Branch', rowNumber))

			WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue1', [('fieldName') : 'Submission Status'])),
			'Open Quote')
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String verifyStructureDetails_Iframe4(String header,String section) {
		try {
			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : header
				, ('section') : section, ('fieldName') : 'Currency']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : header
				, ('section') : section, ('button') : 'Add item']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : header
				, ('section') : section, ('button') : 'Delete']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : header
				, ('section') : section, ('button') : ' Refresh']), GlobalVariable.timeOutValue)
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	@Keyword
	public static String verifyCopyExpiringPSAndCopyPricingOpsButtons(String header,String section) {
		try {
			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : header
				, ('section') : section, ('button') : 'Copy Expiring PS']), GlobalVariable.timeOutValue)

			WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : header
				, ('section') : section, ('button') : 'Copy Pricing Ops']), GlobalVariable.timeOutValue)
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
}
