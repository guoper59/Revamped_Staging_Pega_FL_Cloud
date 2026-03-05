/**
 * ============================================================================
 * Test Case ID : 262222
 * Title         : Create New Surplus Broker Contact
 * Folder        : Scripts/PartyManagement/262222_CreateNewSurplusBrokerContact
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

String brokerContactName = 'Auto_' + timeStamp

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

//Loggedin to Pega with valid DNO User credentials

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('dnouser', GlobalVariable.Dnouser, findTestData(testData).getValue('Role', rowNumber))

KeywordUtil.logInfo('Loggedin to Pega with valid DNO User credentials ')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : partyManagementLink]))

//Navigated to Party Management

KeywordUtil.logInfo('Navigated to Party Management')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : surplusBrokerContactLink]))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

KeywordUtil.logInfo('Navigated to Broker Contact')
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'searchName')]), brokerContactName)
KeywordUtil.logInfo('Entered random broker name to search')

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))
String actualNoItemsMessage = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/webElement_NoItemsMessage'))

WebUI.verifyMatch(findTestData(testData).getValue('ExpectedNoItemsMessage', rowNumber), actualNoItemsMessage, false)

//Verified that no element items exist with given name

KeywordUtil.logInfo('Verified that no element items exist with given name')

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_CreateNew'))
KeywordUtil.logInfo('Entering all the required data to create Broker Contact')

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'firstName')]), brokerContactName)
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'surname')]), findTestData(testData).getValue('Surname', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'email')]), findTestData(testData).getValue('Email', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateBrokerContact/input_MinimumCharacters', [('input') : labelName.getAt(
                'surplusProjectName')]), findTestData(testData).getValue('ProjectName', rowNumber))
WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_CreateBrokerContact/webElement_AutoCompleteResult', 
        [('projectName') : findTestData(testData).getValue('ProjectName', rowNumber)]), GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/PartyManagement/Page_CreateBrokerContact/webElement_AutoCompleteResult', 
        [('projectName') : findTestData(testData).getValue('ProjectName', rowNumber)]))

WebUI.enhancedClick(findTestObject('Object Repository/PartyManagement/Page_CreateBrokerContact/webElement_AutoCompleteResult', 
        [('projectName') : findTestData(testData).getValue('ProjectName', rowNumber)]))
WebUI.waitForElementClickable((findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBrokerContact/webElement_AddItem'))
, GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBrokerContact/webElement_AddItem'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBrokerContact/webElement_TableHeaderDropDown', 
        [('tableHeader') : 'Licence State']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBrokerContact/webElement_TableHeaderDropDown', 
        [('tableHeader') : 'Licence State']), findTestData(testData).getValue('CityName', rowNumber), false)
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBrokerContact/webElement_TableHeaderInput', 
        [('tableHeader') : 'State Licence Number']), findTestData(testData).getValue('StateLicenceNumber', rowNumber))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateSurplusLinesBrokerContact/button_Create'))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'searchName')]), Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'searchName')]), Keys.chord(Keys.BACK_SPACE))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'searchName')]), brokerContactName)

//Entered random broker name to search
KeywordUtil.logInfo('Entered random broker name to search')

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))
//Verifying if correct values are displayed or not

KeywordUtil.logInfo('Verifying if correct values are displayed or not')
