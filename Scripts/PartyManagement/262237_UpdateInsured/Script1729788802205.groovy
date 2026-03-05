/**
 * ============================================================================
 * Test Case ID : 262237
 * Title         : Update Insured
 * Folder        : Scripts/PartyManagement/262237_UpdateInsured
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

//Navigating to Pega Financial Line
KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('dnouser', GlobalVariable.Dnouser, findTestData(testData).getValue('Role', rowNumber))

KeywordUtil.logInfo('Loggedin to Pega with valid DNO User credentials ')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : partyManagementLink]))

KeywordUtil.logInfo('Navigated to Party Management')
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : insuredLink]))
KeywordUtil.logInfo('Navigated to Insured')

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt('searchName')]))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'searchName')]), insuredName)

//Entered random insured name to search

KeywordUtil.logInfo('Entered random insured name to search')
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))
WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/webElement_NoItemsMessage'), GlobalVariable.timeOutValue)

KeywordUtil.logInfo('Verified that no element items exist with given name')

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_CreateNew'))
//Entering all the required data to create Insured

KeywordUtil.logInfo('Entering all the required data to create Insured')

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'addressLine1')]), findTestData(testData).getValue('AddressLine1', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'cityName')]), findTestData(testData).getValue('CityName', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'postCode')]), findTestData(testData).getValue('ZipCode', rowNumber))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : dropDownName.getAt(
                'countryDropDown')]))
WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
        [('dropDownLabel') : dropDownName.getAt('countryDropDown')]), findTestData(testData).getValue('SelectCountry', rowNumber), 
    false)
WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : dropDownName.getAt(
	'divisionDropDown')]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : dropDownName.getAt(
                'divisionDropDown')]))
WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
        [('dropDownLabel') : dropDownName.getAt('divisionDropDown')]), findTestData(testData).getValue('NAICDivision', rowNumber), 
    false)
WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : dropDownName.getAt(
	'descriptionDropDown')]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : dropDownName.getAt(
                'descriptionDropDown')]))
WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
        [('dropDownLabel') : dropDownName.getAt('descriptionDropDown')]), findTestData(testData).getValue('NAICDescription', 
        rowNumber), false)
WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : dropDownName.getAt(
	'publicPrivateDropDown')]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : dropDownName.getAt(
                'publicPrivateDropDown')]))
WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
        [('dropDownLabel') : dropDownName.getAt('publicPrivateDropDown')]), findTestData(testData).getValue('PublicPrivate', 
        rowNumber), false)
WebUI.check(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_IsParent'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/button_Submit'))

WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_SuccessMessage'), GlobalVariable.timeOutValue)

String actualMessage = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_SuccessMessage'))

WebUI.verifyMatch(findTestData(testData).getValue('ExpectedSuccessMessage', rowNumber), actualMessage, false)

//Verified the correct message displayed

KeywordUtil.logInfo('Verified the correct message displayed')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : insuredLink]))

KeywordUtil.logInfo('Navigated to Insured')
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

//added this click to close the sidebar
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'searchName')]), insuredName)
KeywordUtil.logInfo('Entered random insured name to search')

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))
WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_InsuredTaskLink'), 
    10)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_InsuredTaskLink'))
//Clicked on Insured Task
KeywordUtil.logInfo('Clicked on Insured Task')

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'postCode')]), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'postCode')]), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'postCode')]), findTestData(testData).getValue('UpdatedZipCode', rowNumber))

WebUI.uncheck(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_IsParent'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : labelName.getAt(
                'parentInsuredName')]))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : labelName.getAt(
                'parentInsuredName')]), findTestData(testData).getValue('ProjectName', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/webElement_AutoCompleteResult', 
        [('projectName') : findTestData(testData).getValue('ProjectName', rowNumber)]), GlobalVariable.timeOutValue)
WebUI.mouseOver(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/webElement_AutoCompleteResult', [('projectName') : findTestData(
                testData).getValue('ProjectName', rowNumber)]))
WebUI.enhancedClick(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/webElement_AutoCompleteResult', 
        [('projectName') : findTestData(testData).getValue('ProjectName', rowNumber)]))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'cityName')]), findTestData(testData).getValue('ZipCode', rowNumber))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'cityName')]))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'cityName')]), Keys.chord(Keys.CONTROL, 'a'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'cityName')]))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'cityName')]), Keys.chord(Keys.BACK_SPACE))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'cityName')]))
WebUI.clearText(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'cityName')]))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'cityName')]), findTestData(testData).getValue('UpdatedCityName', rowNumber))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/button_Submit'))
WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/webElement_ActionCompletedMessage'), 20)

String actualCompletedMessage = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/webElement_ActionCompletedMessage'))

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/button_Close'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/button_Close'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))
//Verify Updated City Name

