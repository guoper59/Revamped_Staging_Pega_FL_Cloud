/**
 * ============================================================================
 * Test Case ID : 265923
 * Title         : Create Tri Insured
 * Folder        : Scripts/PartyManagement/265923_CreateTriInsured
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
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
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

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.mouseOver(findTestObject('Object Repository/Page_Login_Page/webElement_SwitchApps'))

WebUI.click(findTestObject('Object Repository/Page_Login_Page/webElement_FinancialLines'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Loggedin to Pega with valid Business Admin credentials ')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : partyManagementLink]))

KeywordUtil.logInfo('Navigated to Party Management')
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : insuredLink]))

//Navigated to Insured
KeywordUtil.logInfo('Navigated to Insured')

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'searchName')]), insuredName)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))

//Insured is showing "No Data Found" right now

KeywordUtil.logInfo('Verified that no element items exist with given name')

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_CreateNew'))

//Entering all the required data to create Insured
KeywordUtil.logInfo('Entering all the required data to create Insured')

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/radioButton_InsuredType', 
        [('insuredType') : findTestData(testData).getValue('InsuredType', rowNumber)]), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/radioButton_InsuredType', [('insuredType') : findTestData(
                testData).getValue('InsuredType', rowNumber)]))

WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_MinimumCharacters', 
        [('input') : labelName.getAt('targetName')]), GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'actualInsuredName')]), findTestData(testData).getValue('ActualInsuredName', rowNumber))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'addressLine1')]))

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

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : dropDownName.getAt(
                'divisionDropDown')]))

WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
        [('dropDownLabel') : dropDownName.getAt('divisionDropDown')]), findTestData(testData).getValue('NAICDivision', rowNumber), 
    false)

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
        [('projectName') : findTestData(testData).getValue('ProjectName', rowNumber)]), GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_AutoCompleteResult', 
        [('projectName') : findTestData(testData).getValue('ProjectName', rowNumber)]))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_AutoCompleteResult', [('projectName') : findTestData(
                testData).getValue('ProjectName', rowNumber)]))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_MinimumCharacters', [('input') : labelName.getAt(
                'targetName')]), findTestData(testData).getValue('TargetName', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_MinimumCharacters', [('input') : labelName.getAt(
                'targetName')]), Keys.chord(Keys.BACK_SPACE))

String currentText =  findTestData(testData).getValue('TargetName', rowNumber).substring(0, findTestData(testData).getValue('TargetName', rowNumber).length()-1)

WebUI.mouseOver(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_AutoCompleteResult', [('projectName') : currentText ] ))

WebUI.enhancedClick(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/webElement_AutoCompleteResult', [('projectName') : currentText ] ))

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

KeywordUtil.logInfo('Verifying if correct values are displayed')

String insuredNameValue = WebUI.getAttribute(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', 
        [('fieldName') : labelName.getAt('insuredName')]), 'value')

WebUI.verifyMatch(insuredNameValue, insuredName, false)

String actualAddressLine = WebUI.getAttribute(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', 
        [('fieldName') : labelName.getAt('addressLine1')]), 'value')

WebUI.verifyMatch(actualAddressLine, findTestData(testData).getValue('AddressLine1', rowNumber), false)

String actualCityName = WebUI.getAttribute(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', 
        [('fieldName') : labelName.getAt('cityName')]), 'value')

WebUI.verifyMatch(actualCityName, findTestData(testData).getValue('CityName', rowNumber), false)

String actualZipCode = WebUI.getAttribute(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_FieldName', 
        [('fieldName') : labelName.getAt('postCode')]), 'value')

WebUI.verifyMatch(actualZipCode, findTestData(testData).getValue('ZipCode', rowNumber), false)

String actualCountry = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/webElement_SelectedOption', 
        [('dropDownName') : dropDownName.getAt('countryDropDown')]))

WebUI.verifyMatch(actualCountry, findTestData(testData).getValue('SelectCountry', rowNumber), false)

String actualDivision = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/webElement_SelectedOption', 
        [('dropDownName') : dropDownName.getAt('divisionDropDown')]))

WebUI.verifyMatch(actualDivision, findTestData(testData).getValue('NAICDivision', rowNumber), false)

String actualDescription = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/webElement_SelectedOption', 
        [('dropDownName') : dropDownName.getAt('descriptionDropDown')]))

WebUI.verifyMatch(actualDescription, findTestData(testData).getValue('NAICDescription', rowNumber), false)

String actualSelected = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/webElement_SelectedOption', 
        [('dropDownName') : dropDownName.getAt('publicPrivateDropDown')]))

WebUI.verifyMatch(actualSelected, findTestData(testData).getValue('PublicPrivate', rowNumber), false)

//Verifying correct status
KeywordUtil.logInfo('Verifying correct status')

String actualStatus = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/webElement_ApprovedStatus'))

WebUI.verifyMatch(actualStatus, findTestData(testData).getValue('ExpectedStatus', rowNumber), false)