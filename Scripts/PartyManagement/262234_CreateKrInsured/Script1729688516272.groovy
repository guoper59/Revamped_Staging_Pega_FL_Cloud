/**
 * ============================================================================
 * Test Case ID : 262234
 * Title         : Create Kr Insured
 * Folder        : Scripts/PartyManagement/262234_CreateKrInsured
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

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

    //Finding Row number from Test Data.
    int rowNumber = common.FileUtils.findRowNumber(testDataFilePath, GlobalVariable.testCaseID)

    WebUI.comment('RowNumber: ' + rowNumber)

    String timeStamp = GenericUtils.getCurrentTimestamp()

    String insuredName = 'Auto_' + timeStamp
	
	//Navigating to Pega Financial Lines

    KeywordUtil.logInfo('Navigating to Pega Financial Lines')

    WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

    CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('llbusinessadmin', GlobalVariable.llbusinessadmin, findTestData(testData).getValue('Role', rowNumber))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
		FailureHandling.STOP_ON_FAILURE)
    KeywordUtil.logInfo('Loggedin to Pega with valid Business Admin credentials ')

	WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
	
    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : "Party Management"]))
	
    //Navigated to Party Management
	KeywordUtil.logInfo('Navigated to Party Management')
    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : "Insured"]))
    KeywordUtil.logInfo('Navigated to Insured')
	WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))
	
    WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                    'searchName')]), insuredName)

    //Entered random insured name to search
	WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))
	
	KeywordUtil.logInfo('Entered random insured name to search')
	WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'), 25)
    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/webElement_NoItemsMessage'), 20)

    KeywordUtil.logInfo('Verified that no element items exist with given name')

    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_CreateNew'))

    //Entering all the required data to create Insured
	KeywordUtil.logInfo('Entering all the required data to create Insured')

    WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/radioButton_InsuredType', 
            [('insuredType') : findTestData(testData).getValue('InsuredType', rowNumber)]), GlobalVariable.timeOutValue)

    WebUI.enhancedClick(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/radioButton_InsuredType', [('insuredType') : findTestData(
                    testData).getValue('InsuredType', rowNumber)]))

	WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                    'actualInsuredName')]), GlobalVariable.timeoutShort)

	WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                    'actualInsuredName')]))
    WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                    'actualInsuredName')]), findTestData(testData).getValue('ActualInsuredName', rowNumber))
	WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
		'addressLine1')]), GlobalVariable.timeoutShort)
	WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
					'addressLine1')]))
	WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
					'addressLine1')]), findTestData(testData).getValue('AddressLine1', rowNumber))
	WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
		'postCode')]), GlobalVariable.timeoutShort)
	WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                    'postCode')]))
    WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                    'postCode')]), findTestData(testData).getValue('ZipCode', rowNumber))
    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : dropDownName.getAt(
                    'countryDropDown')]))
    WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
            [('dropDownLabel') : dropDownName.getAt('countryDropDown')]), findTestData(testData).getValue('SelectCountry', 
            rowNumber), false)
    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : dropDownName.getAt(
                    'divisionDropDown')]))
    WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
            [('dropDownLabel') : dropDownName.getAt('divisionDropDown')]), findTestData(testData).getValue('NAICDivision', 
            rowNumber), false)
    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : dropDownName.getAt(
                    'descriptionDropDown')]))
    WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
            [('dropDownLabel') : dropDownName.getAt('descriptionDropDown')]), findTestData(testData).getValue('NAICDescription', 
            rowNumber), false)
    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : dropDownName.getAt(
                    'publicPrivateDropDown')]))
    WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
            [('dropDownLabel') : dropDownName.getAt('publicPrivateDropDown')]), findTestData(testData).getValue('PublicPrivate', 
            rowNumber), false)
    WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_MinimumCharacters', [('input') : labelName.getAt(
                    'parentInsuredName')]), findTestData(testData).getValue('ProjectName', rowNumber))

    WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_AutoCompleteResult', 
            [('projectName') : findTestData(testData).getValue('ProjectName', rowNumber)]), 5)

    WebUI.mouseOver(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_AutoCompleteResult', 
            [('projectName') : findTestData(testData).getValue('ProjectName', rowNumber)]))

    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_AutoCompleteResult', 
            [('projectName') : findTestData(testData).getValue('ProjectName', rowNumber)]))
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
		'cityName')]), GlobalVariable.timeoutShort)

	WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
					'cityName')]), findTestData(testData).getValue('CityName', rowNumber))

    String parentInsuredID = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement__ParentInsuredId'))

    KeywordUtil.logInfo('Parent Insured ID generated is : ' + parentInsuredID)

    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/button_Submit'))
	
	WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_SuccessMessage'), 20)

    String actualMessage = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_SuccessMessage'))

    WebUI.verifyMatch(findTestData(testData).getValue('ExpectedSuccessMessage', rowNumber), actualMessage, false)
	
	//Verified the correct message displayed

    KeywordUtil.logInfo('Verified the correct message displayed')

    WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_InsuredTaskLink'), 
        10)

    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_InsuredTaskLink'))

    KeywordUtil.logInfo('Clicked on Insured Task')

    KeywordUtil.logInfo('Verifying if correct values are displayed')
