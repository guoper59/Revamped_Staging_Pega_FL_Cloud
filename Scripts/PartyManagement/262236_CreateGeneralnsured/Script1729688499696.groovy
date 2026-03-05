/**
 * ============================================================================
 * Test Case ID : 262236
 * Title         : Create Generalnsured
 * Folder        : Scripts/PartyManagement/262236_CreateGeneralnsured
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
	
	//Verifying if correct values are displayed or not

    KeywordUtil.logInfo('Navigating to Pega Financial Lines')

    WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

    CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('llbusinessadmin', GlobalVariable.llbusinessadmin, findTestData(testData).getValue('Role', rowNumber))

    KeywordUtil.logInfo('Loggedin to Pega with valid Business Admin credentials ')

	
	WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : partyManagementLink]))

    //Navigated to Party Management
	WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : insuredLink]), 25)
	WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : insuredLink]))

    KeywordUtil.logInfo('Navigated to Insured')
	
	WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))
	
	WebUI.waitForElementNotHasAttribute(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
		'searchName')]), "disabled", 25)
    WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                    'searchName')]), insuredName)
    KeywordUtil.logInfo('Entered random insured name to search')

	WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'), 60)
	WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))
	
	WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/webElement_NoItemsMessage'), 60)	

    //Verified that no element items exist with given name
	KeywordUtil.logInfo('Verified that no element items exist with given name')

    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_CreateNew'))

    KeywordUtil.logInfo('Entering all the required data to create Insured')

    WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/radioButton_InsuredType', 
            [('insuredType') : findTestData(testData).getValue('InsuredType', rowNumber)]), 20)
    WebUI.enhancedClick(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/radioButton_InsuredType', [('insuredType') : findTestData(
                    testData).getValue('InsuredType', rowNumber)]))
    WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                    'addressLine1')]), findTestData(testData).getValue('AddressLine1', rowNumber))
    WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                    'cityName')]), findTestData(testData).getValue('CityName', rowNumber))
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
    String parentInsuredID = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement__ParentInsuredId'))

    KeywordUtil.logInfo('Parent Insured ID generated is : ' + parentInsuredID)

    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/button_Submit'))

    String actualMessage = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_SuccessMessage'))

    WebUI.verifyMatch(findTestData(testData).getValue('ExpectedSuccessMessage', rowNumber), actualMessage, false)
	
	//Verified the correct message displayed

    KeywordUtil.logInfo('Verified the correct message displayed')

    WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_InsuredTaskLink'), 
        10)

    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_InsuredTaskLink'))

    KeywordUtil.logInfo('Clicked on Insured Task')

	