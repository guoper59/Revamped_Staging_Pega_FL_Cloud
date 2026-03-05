/**
 * ============================================================================
 * Test Case ID : 262239
 * Title         : Create New Other Business Provider
 * Folder        : Scripts/PartyManagement/262239_CreateNewOtherBusinessProvider
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
import com.kms.katalon.core.testobject.TestObject

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber(testDataFilePath, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

String timeStamp = GenericUtils.getCurrentTimestamp()

String businessProviderName = 'Auto_' + timeStamp

//Navigating to Pega Financial Lines

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('llbusinessadmin', GlobalVariable.llbusinessadmin, findTestData(testData).getValue('Role', rowNumber))

//Loggedin to Pega with valid DNO User credentials

KeywordUtil.logInfo('Loggedin to Pega with valid DNO User credentials ')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : partyManagementLink]))
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
KeywordUtil.logInfo('Navigated to Party Management')
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : otherBusinessProviderlink]))

KeywordUtil.logInfo('Navigated to Other Business Provider')

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'searchName')]), businessProviderName)

//Entered random broker name to search

KeywordUtil.logInfo('Entered random broker name to search')
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))
String actualNoItemsMessage = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/webElement_NoItemsMessage'))

WebUI.verifyMatch(findTestData(testData).getValue('ExpectedNoItemsMessage', rowNumber), actualNoItemsMessage, false)

//Verified that no element items exist with given name

KeywordUtil.logInfo('Verified that no element items exist with given name')

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_CreateNew'))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'name')]), businessProviderName)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'addressLine1')]), findTestData(testData).getValue('AddressLine1', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'cityName')]), findTestData(testData).getValue('CityName', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'postCode')]), findTestData(testData).getValue('ZipCode', rowNumber))

WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown',
		[('dropDownLabel') : labelName.getAt('country')]), findTestData(testData).getValue('SelectCountry', rowNumber),
	false)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBrokerContact/button_Create'))

WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/webElement_SuccessMessage'),
	GlobalVariable.timeOutValue)

//verify business provider name saved successfully

String expectedMessage = businessProviderName + ' Saved Successfully'
String successMessage = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/webElement_SuccessMessage'))
WebUI.verifyMatch(expectedMessage, successMessage, false)

//Searching for Created Business Provider

KeywordUtil.logInfo('Searching for Created Business Provider')

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))


