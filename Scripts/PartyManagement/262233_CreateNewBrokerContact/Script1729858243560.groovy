/**
 * ============================================================================
 * Test Case ID : 262233
 * Title         : Create New Broker Contact
 * Folder        : Scripts/PartyManagement/262233_CreateNewBrokerContact
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

String brokerName = 'Auto_' + timeStamp

//Navigating to Pega Financial Line
KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('dnouser', GlobalVariable.Dnouser, findTestData(testData).getValue('Role', rowNumber))

//Loggedin to Pega with valid DNO User credentials

KeywordUtil.logInfo('Loggedin to Pega with valid DNO User credentials ')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : partyManagementLink]))

KeywordUtil.logInfo('Navigated to Party Management')
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : brokerContactLink]))

//Navigated to Broker Contact

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

KeywordUtil.logInfo('Navigated to Broker Contact')
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'searchName')]), brokerName)

KeywordUtil.logInfo('Entered random broker name to search')

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_Search'))

String actualNoItemsMessage = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/webElement_NoItemsMessage'))

WebUI.verifyMatch(findTestData(testData).getValue('ExpectedNoItemsMessage', rowNumber), actualNoItemsMessage, false)

//Verified that no element items exist with given name

KeywordUtil.logInfo('Verified that no element items exist with given name')

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_CreateNew'))

KeywordUtil.logInfo('Entering all the required data to create Broker Contact')

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'firstName')]), brokerName)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'surName')]), findTestData(testData).getValue('Surname', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'email')]), findTestData(testData).getValue('Email', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'address')]), findTestData(testData).getValue('Address', rowNumber))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/select_DynamicDropDown', [('dropDownLabel') : labelName.getAt(
                'country')]))
WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/select_DynamicDropDown', 
        [('dropDownLabel') : labelName.getAt('country')]), findTestData(testData).getValue('SelectCountry', rowNumber), 
    false)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateBrokerContact/input_MinimumCharacters', [('input') : labelName.getAt(
                'brokerCompanyName')]), findTestData(testData).getValue('ProjectName', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_CreateBrokerContact/webElement_AutoCompleteResult', 
        [('projectName') : findTestData(testData).getValue('ProjectName', rowNumber)]), GlobalVariable.timeOutValue)
WebUI.mouseOver(findTestObject('Object Repository/PartyManagement/Page_CreateBrokerContact/webElement_AutoCompleteResult', 
        [('projectName') : findTestData(testData).getValue('ProjectName', rowNumber)]))

WebUI.enhancedClick(findTestObject('Object Repository/PartyManagement/Page_CreateBrokerContact/webElement_AutoCompleteResult', 
        [('projectName') : findTestData(testData).getValue('ProjectName', rowNumber)]))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/button_CreateNew'))
String expectedMessage = brokerName + ' Created SuccessFully'

String successMessage = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/webElement_SuccessMessage'))

KeywordUtil.logInfo('Verifying correct values are displayed or not')
