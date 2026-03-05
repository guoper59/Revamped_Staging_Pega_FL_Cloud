/**
 * ============================================================================
 * Test Case ID : 262223
 * Title         : Create New Surplus Lines Broker
 * Folder        : Scripts/PartyManagement/262223_CreateNewSurplusLinesBroker
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

String brokerName = 'Auto_' + timeStamp

//Navigating to Pega Financial Lines

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('llbusinessadmin', GlobalVariable.llbusinessadmin, findTestData(testData).getValue('Role', rowNumber))

//Loggedin to Pega with valid EBELLO User credentials

KeywordUtil.logInfo('Loggedin to Pega with valid EBELLO User credentials')
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : partyManagementLink]))

KeywordUtil.logInfo('Navigated to Party Management')

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : surplusLineBrokerLink]))

//Navigated to Broker Contact

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


KeywordUtil.logInfo('Navigated to Broker Contact')

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBroker/input_FieldName', [('fieldName') : labelName.getAt(
				'searchName')]), brokerName)

//Entered random broker name to search

KeywordUtil.logInfo('Entered random broker name to search')
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBroker/button_Search'))
String actualNoItemsMessage = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/webElement_NoItemsMessage'))

//verify No Items Message

WebUI.verifyMatch(findTestData(testData).getValue('ExpectedNoItemsMessage', rowNumber), actualNoItemsMessage, false)

KeywordUtil.logInfo('Verified that no element items exist with given name')

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_CreateNew'))
//Entering all the required data to create Surplus Broker

KeywordUtil.logInfo('Entering all the required data to create Surplus Broker')

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBroker/input_FieldName', [('fieldName') : labelName.getAt(
				'firstName')]), brokerName)
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'address')]), findTestData(testData).getValue('AddressLine1', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBroker/input_City', [('fieldName') : labelName.getAt(
				'cityName')]), findTestData(testData).getValue('CityName', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'postCode')]), findTestData(testData).getValue('ZipCode', rowNumber))
WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBroker/select_DynamicDropDown',
		[('dropDownLabel') : labelName.getAt('country')]), findTestData(testData).getValue('SelectCountry', rowNumber),
	false)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBrokerContact/webElement_AddItem'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBrokerContact/webElement_TableHeaderDropDown',
		[('tableHeader') : 'Licence State']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBrokerContact/webElement_TableHeaderDropDown',
		[('tableHeader') : 'Licence State']), findTestData(testData).getValue('LicenseState', rowNumber), false)
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBrokerContact/webElement_TableHeaderInput',
		[('tableHeader') : 'State Licence Number']), findTestData(testData).getValue('StateLicenceNumber', rowNumber))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBrokerContact/button_Save'))

WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/webElement_SuccessMessage'),
	GlobalVariable.timeOutValue)

String expectedMessage = brokerName + ' created successfully'
String successMessage = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/webElement_SuccessMessage'))
//verify broker created successfully

WebUI.verifyMatch(expectedMessage, successMessage, false)

KeywordUtil.logInfo('Searching for Created Surplus broker')
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBroker/button_Search'))
//Read Re insured Values
