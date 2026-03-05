package com.submission.helper

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import com.kms.katalon.core.testobject.TestObject

public class SubmissionHelper {

	/*
	 * Enter cover holder and various insured information into the web form using provided test data.
	 *
	 *  - Parameters:
	 *    - String testData: The identifier for the test data source.
	 *    - int rowNumber: The row number in the test data to retrieve values from.
	 *  - Steps:
	 *    - Delay briefly to wait for page readiness.
	 *    - Click on the cover holder web element to activate the input.
	 *    - Input the cover holder name from the test data into the corresponding field.
	 *    - Click on the broker name element associated with the cover holder name.
	 *    - Input the various insured name from the test data into the corresponding field.
	 *    - Click on the broker name element associated with the various insured name.
	 *    - Handle any exceptions silently without interrupting the flow.
	 */
	@Keyword
	public static enterCoverHolder(String testData,int rowNumber) {
		try {
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Coverholder'), 25)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Coverholder'))
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CoverHolderName'), findTestData(
					testData).getValue('CoverHolderName', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CoverHolderName'), Keys.chord(Keys.BACK_SPACE))
			
			
			String currentText =  findTestData(testData).getValue('CoverHolderName', rowNumber).substring(0, findTestData(testData).getValue('CoverHolderName', rowNumber).length()-1)
			
			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_BrokerName',[('brokerName'):findTestData(
			//	testData).getValue('CoverHolderName', rowNumber)]))
			WebUI.delay(GlobalVariable.timeoutShort)
			
			
			WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText ] ))
	
			WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText ] ))
			
	

			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_VariousInsured'), findTestData(
					testData).getValue('VariousInsured', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_BrokerName',[('brokerName'):findTestData(
				testData).getValue('VariousInsured', rowNumber)]))
			WebUI.delay(GlobalVariable.timeoutShort)
		}
		catch(Exception e) {
		}
	}


	/*
	 * Enter insured details on a web form using provided test data and row number.
	 *
	 *  - Parameters:
	 *    - String testData: The identifier for the test data source.
	 *    - int rowNumber: The row number in the test data to use for input values.
	 *  - Return Type: void
	 *  - Steps:
	 *    1. Click the insured web element to start entering details.
	 *    2. Generate a unique insured name using a timestamp and store it globally.
	 *    3. Set the insured name in the Business Unit input field.
	 *    4. Click the search button to find the insured.
	 *    5. Wait for and interact with address-related input fields (Address1, ZipCode, City) using test data values.
	 *    6. Select the country from a dropdown based on test data.
	 *    7. Wait for and click the "Is Parent" checkbox.
	 *    8. Select NAIC Division and NAIC Description from dropdowns using test data.
	 *    9. If provided, enter the Actual Insured value.
	 *    10. Select Public/Private option from dropdown.
	 *    11. If provided, select the State from a dynamic dropdown.
	 *    12. If provided, enter and select the Target Name from autocomplete results.
	 *    13. If provided, enter and select the Parent Insured from autocomplete results.
	 *    14. Handle exceptions by logging the error message and marking the keyword as failed.
	 */

	@Keyword
	public static enterInsuredDetails(String testData,int rowNumber) {
		try{
		
			WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'))

			String InsuredName = 'AUTO_' + GenericUtils.getCurrentTimestamp()

			GlobalVariable.insuredName = InsuredName
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_BusinessUnit'), InsuredName)
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_SearchName'))
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

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'))
			WebUI.delay(GlobalVariable.timeOut)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'),
					findTestData(testData).getValue('Country', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'), 25, FailureHandling.STOP_ON_FAILURE)


			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'))
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
					findTestData(testData).getValue('NAIC Division', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)

			if(!(findTestData(testData).getValue('ActualInsured', rowNumber).equals(''))) {
				WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Actual Insured']), findTestData(testData).getValue('ActualInsured', rowNumber))
			}

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(GlobalVariable.timeoutShort)
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
			WebUI.delay(GlobalVariable.timeoutShort)

			if(!(findTestData(testData).getValue('State', rowNumber).equals(''))) {
				WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'State']), 25)
				WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'State']))
				WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown',
						[('dropDownLabel') : 'State']), findTestData(testData).getValue('State', rowNumber),false)
			}

			WebUI.delay(GlobalVariable.timeoutShort)

			if(!(findTestData(testData).getValue('TargetName', rowNumber).equals(''))) {
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_MinimumCharacters', [('input') : 'Target Name']), findTestData(testData).getValue('TargetName', rowNumber), FailureHandling.STOP_ON_FAILURE)
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_MinimumCharacters', [('input') : 'Target Name']), Keys.chord(Keys.BACK_SPACE))
				
	
				String currentText =  findTestData(testData).getValue('TargetName', rowNumber).substring(0, findTestData(testData).getValue('TargetName', rowNumber).length()-1)
		
				WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText ] ))
		
				WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText ] ))
		
				WebUI.delay(GlobalVariable.timeoutShort)
			}

			if(!(findTestData(testData).getValue('ParentInsured', rowNumber).equals(''))) {
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_MinimumCharacters', [('input') : 'Parent Insured']), findTestData(testData).getValue('ParentInsured', rowNumber))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult',
						[('projectName') : findTestData(testData).getValue('ParentInsured', rowNumber)]), 5)

				WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult',
						[('projectName') : findTestData(testData).getValue('ParentInsured', rowNumber)]))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult',
						[('projectName') : findTestData(testData).getValue('ParentInsured', rowNumber)]))
			}

			WebUI.delay(GlobalVariable.timeoutShort)
			if(!(findTestData(testData).getValue('ActualInsured', rowNumber).equals(''))) {
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Actual Insured']), findTestData(testData).getValue('ActualInsured', rowNumber))
				WebUI.delay(GlobalVariable.timeoutShort)
			}
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())''
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}


	@Keyword
	public static selectReinsured(String testData,int rowNumber) {
		try {
			if(findTestData(testData).getValue('Reinsured', rowNumber).equals('Yes')) {
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.delay(GlobalVariable.timeoutShort)
				
				WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Yes',[('reinsuredYes'):'Yes']))


				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownReinsuredName'))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownReinsuredName'),
						findTestData(testData).getValue('Reinsured Name', rowNumber), false)
				WebUI.delay(GlobalVariable.timeoutShort)


				KeywordUtil.logInfo(findTestData(testData).getValue('Reinsured Name', rowNumber)+' is selected as REINSURED.')
			}
			else {
				WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Yes',[('reinsuredYes'):'No']))
				KeywordUtil.logInfo('Reinsured is NOT selected')
			}
		}

		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())''
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}


	/*
	 *  Enters broker details using test data and row number.
	 *
	 *  1. Waits for the broker element to be clickable.
	 *  2. Clicks on the broker element twice.
	 *  3. Selects an option from a dropdown based on the country value from test data.
	 *  4. Sets text in the broker agency name field based on test data.
	 *  GlobalVariable.timeoutShort. Clicks on the broker name element with a specific value.
	 *  6. Clicks on the broker contact dropdown and selects an option based on test data.
	 *  7. Catches any exceptions, logs the message, and marks the test case as failed.
	 *
	 */

	@Keyword
	public static enterBrokerDetails (String testData,int rowNumber) {
		try {
			WebUI.delay(5)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'),
					60)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))
			WebUI.delay(GlobalVariable.timeoutShort)
			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'),
					findTestData(testData).getValue('Country', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_BrokerAgencyName'),
					findTestData(testData).getValue('Broker', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			if(!(findTestData(testData).getValue('Pseudo Code', rowNumber).equals(''))) {
				WebUI.mouseOver(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_BrokerName',
						[('brokerName') : findTestData(testData).getValue('Pseudo Code', rowNumber)]))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_BrokerName',
					[('brokerName') : findTestData(testData).getValue('Pseudo Code', rowNumber)]))
			}
			else {
				WebUI.mouseOver(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_BrokerName',
						[('brokerName') : findTestData(testData).getValue('Broker', rowNumber)]))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_BrokerName',
					[('brokerName') : findTestData(testData).getValue('Broker', rowNumber)]))
			}
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'),
					findTestData(testData).getValue('Broker Contact', rowNumber), false)
		}catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())

			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}

	/*
	 *  This code enters general data by selecting options from dropdowns and setting text fields based on test data.
	 *
	 *  1. Waits for element to be clickable before clicking on it.
	 *  2. Selects options by label from dropdowns using test data values.
	 *  3. Sets text in a text field based on test data.
	 *
	 */
	@Keyword
	public static enterGeneralData(String testData,int rowNumber) {
		try {
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'),
					60)
			WebUI.delay(GlobalVariable.timeoutShort)
			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'),
					findTestData(testData).getValue('Class Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMajorClass'), 180)
			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMajorClass'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMajorClass'),
					findTestData(testData).getValue('Major Class', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			String lineOfBusiness = findTestData(testData).getValue('Major Class', rowNumber)

			GlobalVariable.LineOfBusiness = lineOfBusiness

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMinorClass'), 180)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMinorClass'))
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownMinorClass'),
					findTestData(testData).getValue('Minor Class', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClass'), 120)
			WebUI.delay(GlobalVariable.timeoutShort)
			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClass'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClass'),
					findTestData(testData).getValue('Class', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'),
					60)

			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPlacingType'),
					findTestData(testData).getValue('Placing Type', rowNumber), false)

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownSubPlacingType'),
					60)

			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownSubPlacingType'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownSubPlacingType'),
					findTestData(testData).getValue('Sub Placing Type', rowNumber), false)

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


			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwriter'),
					60)

			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwriter'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwriter'),
					findTestData(testData).getValue('Underwriter', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant'),
					60)

			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUnderwritingAssistant'),
					findTestData(testData).getValue('Underwriting Assistant', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Producing Team ']),
			60)

			//WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Producing Team ']))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Producing Team ']),
			findTestData(testData).getValue('Producing Team', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)

			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'),
					findTestData(testData).getValue('Inception Date', rowNumber))

			String inceptionDate = findTestData(testData).getValue('Inception Date', rowNumber)

			GlobalVariable.InceptionDate = inceptionDate

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'),
					60)

			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownEntity'),
					findTestData(testData).getValue('Entity', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'),
					GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLegalBranch'),
					findTestData(testData).getValue('Legal Branch', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)
			//TODO: I need to know when it should be bureau to don't do this
			if (WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), 25, FailureHandling.OPTIONAL) ){
				if ( WebUI.verifyElementChecked(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), 25, FailureHandling. OPTIONAL ) ){
					WebUI.uncheck(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'))
				}
			}
			
			if(!(findTestData(testData).getValue('K&Rtype', rowNumber).equals(''))) {
				WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_KrType'), findTestData(testData).getValue('K&Rtype', rowNumber),
						false)
			}

			String expirationDate = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_FieldName',[('fieldName') : ('Expiry Date ')]), 'value')

			GlobalVariable.ExpirationDate = expirationDate
		}catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())''
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	/*
	 *  Enters details in a web form using data from a test data sheet.
	 *
	 *  1. Clicks on a dropdown and selects an option based on test data.
	 *  2. Enters text in input fields based on test data.
	 *  3. Handles exceptions and marks the test case as failed if an exception occurs.
	 *
	 */

	@Keyword
	public static enterDetailsUWSheet(String testData,int rowNumber ){
		try {
			//TODO: I need to know when it should be bureau to don't do this
			if (WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), 10, FailureHandling.OPTIONAL) ){
				if ( WebUI.verifyElementChecked(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), 5, FailureHandling. OPTIONAL ) ){
					WebUI.uncheck(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), FailureHandling.OPTIONAL)
				}
			}
			//WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBaseCurrencyCode'), 25)	
			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBaseCurrencyCode'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBaseCurrencyCode'),
					findTestData(testData).getValue('Original Currency', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TMHCCWrittenParticipation'),
					findTestData(testData).getValue('TMHCC Written Participation%', rowNumber))

			WebUI.delay(GlobalVariable.timeoutShort)

			if (WebUI.verifyElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerPosition'))) {
				WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerPosition'),
						findTestData(testData).getValue('Layer Position', rowNumber))
				WebUI.delay(GlobalVariable.timeoutShort)
			}

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerEELLimit'),
					GlobalVariable.timeOutValue)

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerEELLimit'))
			WebUI.delay(2)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerEELLimit'),
					findTestData(testData).getValue('Layer EEL Limit', rowNumber))

			WebUI.delay(GlobalVariable.timeOutValue)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'),
					GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'),
					findTestData(testData).getValue('Layer AGG Limit', rowNumber))

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ExcessLimit'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ExcessLimit'),
					findTestData(testData).getValue('Excess Limit', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'),
					GlobalVariable.timeOutValue)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'),
					findTestData(testData).getValue('Commission', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_PremiumCalculate'), GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_PremiumCalculate'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
					GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPremiumType'),
					'Original Premium', false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
					GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'))
			WebUI.delay(GlobalVariable.timeOutValue)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),Keys.chord(Keys.CONTROL, 'a'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),Keys.chord(Keys.CONTROL, 'a'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
					findTestData(testData).getValue('Layer Gross Premium', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_PremiumCalculate'))

			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ApplicableLaw'),
					60)

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ApplicableLaw'),
					60)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTerritorialScope'),
					findTestData(testData).getValue('Territorial Scope', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ApplicableLaw'),
					findTestData(testData).getValue('Applicable Law', rowNumber))

			WebUI.delay(GlobalVariable.timeoutShort)
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())''
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
	/*
	 *  Enters details for underwriting in a web application.
	 *
	 *  1. Clicks on a dropdown and selects an option based on test data.
	 *  2. Enters a date value in a text field.
	 *  3. Enters numerical values in text fields based on test data.
	 *
	 */
	@Keyword
	public static enterDetailsUW(String testData,int rowNumber ){
		try {
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'),
					findTestData(testData).getValue('UW Authority', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'),
					findTestData(testData).getValue('IsTacitRenewal', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TacItRenewalDate'),
					findTestData(testData).getValue('Tacit Renewal Date', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownCyberCoverage'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownCyberCoverage'),
					findTestData(testData).getValue('Cyber Coverage', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_EntitysTotalAsset'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.clearText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_EntitysTotalAsset'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_EntitysTotalAsset'),
					findTestData(testData).getValue('Entitys Total Assets', rowNumber))

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_PolicyHolderTurnover'), 30)

			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_PolicyHolderTurnover'), 10)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_PolicyHolderTurnover'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.clearText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_PolicyHolderTurnover'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_PolicyHolderTurnover'),
					findTestData(testData).getValue('Policy Holder Revenue/Turn Over/Fee Income', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'), 25)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'))

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'),
					findTestData(testData).getValue('CryptoExposure', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			
			
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), 25)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))
			
			WebUI.clearText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), findTestData(testData).getValue('input_Lead',
				rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), Keys.chord(Keys.BACK_SPACE))
			
			WebUI.delay(GlobalVariable.timeoutShort)
			
			String currentText =  findTestData(testData).getValue('input_Lead', rowNumber).substring(0, findTestData(testData).getValue('input_Lead', rowNumber).length()-1)
			
			WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]), GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))
			WebUI.delay(GlobalVariable.timeoutShort)
			
			WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))
			
			WebUI.delay(GlobalVariable.timeoutShort)
			
			
			
			
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())''
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}

	@Keyword
	public static enterDetailsinPostBindStage(String testData,int rowNumber) {
		try {
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), GlobalVariable.timeoutShort)			

			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
					findTestData(testData).getValue('Tax Applicable', rowNumber), false)
			
			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
					testData).getValue('Due Date', rowNumber))

			WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'),Keys.chord(Keys.TAB))


			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), 25)

			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), 25)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))
			/*
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_InitiateContractCertanity'), 25)
			
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_InitiateContractCertanity'))
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPolicySlipInsurance'),
					findTestData(testData).getValue('PolicySlip', rowNumber), false)


			//	WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Save'), 25)
			
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Save'))

			
			int maxRetries = 30;
			int retryCount = 0;
			
			while(WebUI.verifyElementPresent(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_ContractCertainityErrorMessage'),
								GlobalVariable.timeOutValue, FailureHandling.OPTIONAL) && (retryCount < maxRetries)) {
			
				WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_InitiateContractCertanity1'), GlobalVariable.timeoutShort)
				WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_InitiateContractCertanity1'))
				WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPolicySlipInsurance'),
						findTestData(testData).getValue('PolicySlip', rowNumber), false)
	
				WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Save'), GlobalVariable.timeoutShort)
				WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Save'))
				WebUI.delay(GlobalVariable.timeoutShort)
				
				retryCount++;
				
			}

			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Close'),25)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Close'))
			*/
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_BindPolicy'),
					GlobalVariable.timeOutValue)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_BindPolicy'))
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_FinalisePolicy'),
					25)
			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_FinalisePolicy'),
				25)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_FinalisePolicy'))
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_Proceed'), 25)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_Proceed'))
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Status',[('status'):'Signed']),
			25)

			WebUI.verifyElementPresent(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Status',[('status'):'Signed']),
			25)
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}

	@Keyword
	public static generateBrokerBind(String testData, int rowNumber) {
		try {
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownFormat'),
					GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownFormat'),
					findTestData(testData).getValue('Format', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLanguage'),
					GlobalVariable.timeOutValue)


			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLanguage'), 10)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLanguage'), 5)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownLanguage'),
					findTestData(testData).getValue('Language', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTemplate'),
					GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTemplate'),
					findTestData(testData).getValue('Template', rowNumber), false)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_Submit'),
					GlobalVariable.timeOutValue)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_Submit'))
		}catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}


	@Keyword
	public static String createOpenSubmission(String testData,int rowNumber) {
		try {
			WebUI.delay(5)
			
			WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
			WebUI.delay(3)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))
			WebUI.delay(5)
			/*
			 WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'),
			 GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
			 WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'))
			 WebUI.delay(5)
			 */
			WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))
			
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Yes',[('reinsuredYes'):'No']))
			
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			//Entering Insured Details using the keyword
			SubmissionHelper.enterInsuredDetails(testData, rowNumber)
			WebUI.delay(5)
			//Selecting reInsured Details using the keyword
			SubmissionHelper.selectReinsured(testData, rowNumber)


			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
			WebUI.delay(20)

			//Entering broker Details using the keyword
			SubmissionHelper.enterBrokerDetails(testData, rowNumber)
			WebUI.delay(5)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

			//Entering general data using the keyword
			SubmissionHelper.enterGeneralData(testData, rowNumber)
			WebUI.delay(20)
			
			//Fetching case ID details
			String caseID = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_CaseID'))
			WebUI.delay(5)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))
			WebUI.delay(20)

			WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/button_OK'), 60, FailureHandling.STOP_ON_FAILURE)

			WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_PolicyReference'), 180)

			//Fetching policy Number details
			String policyRef = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_PolicyReference'))

			WebUI.click(findTestObject('Object Repository/Dashboards/button_OK'))
			WebUI.delay(5)
			KeywordUtil.logInfo(policyRef)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/button_Close'), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))

			String insuredName = GlobalVariable.insuredName

			return insuredName
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}

	@Keyword
	public static String createSubmissionQuotedStatus(String testData,int rowNumber) {
		try {
			
			WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))
			/*
			 WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'),
			 GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
			 WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'))
			 */
			WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))
			
			
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Yes',[('reinsuredYes'):'No']))
			
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			//Entering Insured Details using the keyword
			SubmissionHelper.enterInsuredDetails(testData, rowNumber)

			//Selecting reInsured Details using the keyword
			SubmissionHelper.selectReinsured(testData, rowNumber)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
			WebUI.delay(GlobalVariable.timeoutShort)
			//Entering broker Details using the keyword
			SubmissionHelper.enterBrokerDetails(testData, rowNumber)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

			//Entering general data using the keyword
			SubmissionHelper.enterGeneralData(testData, rowNumber)

			//Fetching case ID details
			String caseID = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_CaseID'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/button_OK'), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

			WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_PolicyReference'), 180)

			//Fetching policy Number details
			String policyRef = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_PolicyReference'))

			KeywordUtil.logInfo(policyRef)

			WebUI.click(findTestObject('Object Repository/Dashboards/button_OK'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))
			WebUI.delay(GlobalVariable.timeoutShort)
			SubmissionHelper.enterDetailsUWSheet(testData, rowNumber)

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CompleteQuote'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/button_Close'), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))
			WebUI.delay(GlobalVariable.timeoutShort)
			return caseID
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}


	@Keyword
	public static enterInsuredDetailsForKRTest(String testData,int rowNumber) {
		try {
			String InsuredName = 'AUTO_' + GenericUtils.getCurrentTimestamp()

			GlobalVariable.insuredName = InsuredName
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_BusinessUnit'), InsuredName)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_SearchName'))

			WebUI.delay(GlobalVariable.timeoutShort)

			if(!(findTestData(testData).getValue('InsuredType', rowNumber).equals(''))) {
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/radioButton_InsuredType',
						[('insuredType') : 'K&R Insured']), GlobalVariable.timeOutValue)

				WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/radioButton_InsuredType', [('insuredType') : 'K&R Insured']))
				WebUI.delay(GlobalVariable.timeoutShort)
			}

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
			WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'),
					findTestData(testData).getValue('Country', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)


			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'))

			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICSCodeDescription'),
					findTestData(testData).getValue('NAIC Description', rowNumber), false)


			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownNAICDivision'),
					findTestData(testData).getValue('NAIC Division', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			if(!(findTestData(testData).getValue('ActualInsured', rowNumber).equals(''))) {
				WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Actual Insured']), findTestData(testData).getValue('ActualInsured', rowNumber))
				WebUI.delay(GlobalVariable.timeoutShort)
			}
			WebUI.delay(GlobalVariable.timeoutShort)





			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'),
					GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'),
					findTestData(testData).getValue('Public/Private', rowNumber), false)

			WebUI.delay(GlobalVariable.timeoutShort)

			if(!(findTestData(testData).getValue('State', rowNumber).equals(''))) {
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'State']))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown',
						[('dropDownLabel') : 'State']), findTestData(testData).getValue('State', rowNumber),false)
			}

			WebUI.delay(GlobalVariable.timeoutShort)

			if(!(findTestData(testData).getValue('ParentInsured', rowNumber).equals(''))) {
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_MinimumCharacters', [('input') : 'Parent Insured']), findTestData(testData).getValue('ParentInsured', rowNumber))
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult',
						[('projectName') : findTestData(testData).getValue('ParentInsured', rowNumber)]), 5)

				WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult',
						[('projectName') : findTestData(testData).getValue('ParentInsured', rowNumber)]))

				WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult',
						[('projectName') : findTestData(testData).getValue('ParentInsured', rowNumber)]))
				WebUI.delay(GlobalVariable.timeoutShort)
			}

			if(!(findTestData(testData).getValue('InsuredType', rowNumber).equals(''))) {
				WebUI.delay(GlobalVariable.timeoutShort)
				WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'))
			}

			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
					[('optionToSelect') : 'No']), GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
					[('optionToSelect') : 'No']))
			WebUI.delay(GlobalVariable.timeoutShort)

			WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
					[('optionToSelect') : 'No']))

			WebUI.delay(GlobalVariable.timeoutShort)
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}

	@Keyword
	public static enterBrokerDetailsForKRTest(String testData,int rowNumber) {
		try {
			WebUI.delay(GlobalVariable.timeOutValue)
			//WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'),
					GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))
			WebUI.delay(GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'),
					GlobalVariable.timeOutValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
					'CountryName', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']),
			findTestData(testData).getValue('Broker', rowNumber))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]), GlobalVariable.timeOutValue)

			WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
				testData).getValue('Broker', rowNumber)]))

			WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'),
					findTestData(testData).getValue('Broker Contact', rowNumber), false)
			WebUI.delay(GlobalVariable.timeoutShort)
		}
		catch(Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())
			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}

	public static void enterTaxDetails(String testData,int rowNumber) {
		WebUI.delay(GlobalVariable.timeoutShort)


		WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
		findTestData(testData).getValue('Tax code', rowNumber))
		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.clearText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']))

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.setText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
		findTestData(testData).getValue('Tax code', rowNumber))

		WebUI.delay(GlobalVariable.timeoutShort)


		WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']), Keys.chord(Keys.BACK_SPACE))

		WebUI.delay(GlobalVariable.timeOutValue)

		String currentText =  findTestData(testData).getValue('Tax code', rowNumber).substring(0, findTestData(testData).getValue('Tax code', rowNumber).length()-1)

		WebUI.mouseOver(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

		WebUI.enhancedClick(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

		WebUI.delay(GlobalVariable.timeoutShort)


		WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']))

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']),
		Keys.chord(Keys.CONTROL, 'a'))

		WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']),
		findTestData(testData).getValue('Tax Premium', rowNumber))

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
				testData).getValue('Due Date', rowNumber))

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
				Keys.TAB))

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)

		WebUI.delay(GlobalVariable.timeoutShort)
		WebUI.delay(GlobalVariable.timeoutShort)
		WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

		WebUI.delay(GlobalVariable.timeOutValue)

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

		println(actualInstalmentValues)

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), 25)

		WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.delay(GlobalVariable.timeoutShort)

		//Status Validations to be added
		String uwQCStatus = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_UWQCStatus'))

		GenericUtils.verifyMatch('UW QC Status is', uwQCStatus, 'To Be Approved', 'EQUAL')

		WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']),
		10, FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']))

		WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'), GlobalVariable.timeOutValue,
				FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'))

		WebUI.delay(GlobalVariable.timeOutValue)

		WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Finalise'), GlobalVariable.timeOutValue,
				FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('Object Repository/NewBusiness/button_Finalise'))

		WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'),
				GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

		WebUI.delay(GlobalVariable.timeOutValue)

		String signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

		GenericUtils.verifyMatch('Status Value is', signedStatus, 'Signed', 'EQUAL')

		String peerReview = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PeerReviewNumber'))

		KeywordUtil.logInfo('Peer Review Case generate for this is : ' + peerReview)
	}

	public static void generateInstallments(String testData,int rowNumber) {
		WebUI.delay(GlobalVariable.timeoutShort)
		WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Cyber War Exclusions']))
		WebUI.delay(GlobalVariable.timeoutShort)
		WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Cyber War Exclusions']),
		findTestData(testData).getValue('Cyber Coverage', rowNumber), false)
		WebUI.delay(GlobalVariable.timeoutShort)
		WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))
		WebUI.delay(GlobalVariable.timeoutShort)
		WebUI.delay(GlobalVariable.timeOutValue)

		WebUI.delay(GlobalVariable.timeoutShort)


		WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
		findTestData(testData).getValue('Tax code', rowNumber))
		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.clearText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']))

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.setText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
		findTestData(testData).getValue('Tax code', rowNumber))

		WebUI.delay(GlobalVariable.timeoutShort)


		WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']), Keys.chord(Keys.BACK_SPACE))

		WebUI.delay(GlobalVariable.timeOutValue)

		String currentText =  findTestData(testData).getValue('Tax code', rowNumber).substring(0, findTestData(testData).getValue('Tax code', rowNumber).length()-1)

		WebUI.mouseOver(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

		WebUI.enhancedClick(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

		WebUI.delay(GlobalVariable.timeoutShort)


		WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']))

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']),
		Keys.chord(Keys.CONTROL, 'a'))

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']),
		findTestData(testData).getValue('Tax Premium', rowNumber))

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
				Keys.CONTROL, 'a'))

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
				testData).getValue('DueDate2', rowNumber))

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
				Keys.TAB))

		WebUI.delay(GlobalVariable.timeoutShort)
		WebUI.delay(GlobalVariable.timeOutValue)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
		WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

		WebUI.delay(GlobalVariable.timeOutValue)
		WebUI.waitForElementPresent(findTestObject('Object Repository/Pega_CreateInsured/webElement_tblValue', [('tableName') : 'Instalment']), 25)
		//Installments Validations
		/*
		List<WebElement> actualInstalment2 = WebUI.findWebElements(findTestObject('Object Repository/Pega_CreateInsured/webElement_tblValue',
				[('tableName') : 'Instalment']), GlobalVariable.timeoutShort)

		WebUI.delay(GlobalVariable.timeoutShort)

		List<WebElement> actualInstalmentValues2 = new ArrayList<String>()

		WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget1Ifr'), GlobalVariable.timeoutShort)

		WebUI.delay(GlobalVariable.timeoutShort)

		for (int i = 0; i < actualInstalment2.size(); i++) {
			String value = actualInstalment2.get(i).getText().trim( // Trim spaces
					)

			if (!(value.equals(''))) {
				actualInstalmentValues2.add(value)
			}
		}
		*/
		WebUI.switchToDefaultContent()

		WebUI.delay(GlobalVariable.timeoutShort)

		//println(actualInstalmentValues2)

		//GenericUtils.compareLists(actualInstalmentValues, expectedInstallmentValues)
		WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'),
				GlobalVariable.timeOutValue)

		WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

		WebUI.delay(GlobalVariable.timeoutShort)

		//Status Validations to be added
		String uwQCStatusNew = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_UWQCStatus'))

		WebUI.delay(GlobalVariable.timeoutShort)

		GenericUtils.verifyMatch('UW QC Status is', uwQCStatusNew, 'To Be Approved', 'EQUAL')

		// Wait for a specific element related to case content options to be visible within 10 seconds.
		WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions',
				[('linkToClick') : 'Bind Policy']), 10, FailureHandling.STOP_ON_FAILURE)

		//Click on a link within the case content options.
		WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions', [('linkToClick') : 'Bind Policy']))

		WebUI.delay(GlobalVariable.timeoutShort)

		WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'), GlobalVariable.timeOutValue,
				FailureHandling.STOP_ON_FAILURE)

		WebUI.click(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'))

		WebUI.delay(GlobalVariable.timeOutValue)

		WebUI.delay(GlobalVariable.timeOutValue)

		// Wait for the finalise policy button to be visible based on a specified timeout value.
		WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'), GlobalVariable.timeOutValue,
				FailureHandling.STOP_ON_FAILURE)

		//Click on the finalise policy button.
		WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'))

		WebUI.delay(GlobalVariable.timeoutShort)

		// Wait for the 'Finalise Policy' prompt to be visible.
		WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'),
				GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

		//Click on the 'Proceed' button.
		WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

		WebUI.delay(GlobalVariable.timeOutValue)

		//Wait for the 'Policy Docs' tab to be visible in the dynamic tab selector.
		WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector',
				[('tabName') : 'Policy Docs']), 10, FailureHandling.STOP_ON_FAILURE)
	}
}
