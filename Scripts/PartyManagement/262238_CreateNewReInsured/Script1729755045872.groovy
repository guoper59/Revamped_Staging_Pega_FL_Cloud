/**
 * ============================================================================
 * Test Case ID : 262238
 * Title         : Create New Re Insured
 * Folder        : Scripts/PartyManagement/262238_CreateNewReInsured
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

String reInsuredName = 'Auto_' + timeStamp

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('llbusinessadmin', GlobalVariable.llbusinessadmin, findTestData(testData).getValue('Role', rowNumber))

KeywordUtil.logInfo('Loggedin to Pega with valid Business Admin credentials ')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : partyManagementLink]))

KeywordUtil.logInfo('Navigated to Party Management')
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : reInsuredLink]))

KeywordUtil.logInfo('Navigated to Reinsured')

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'searchReInsuredName')]), reInsuredName)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_SearchReinsured'))

WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/webElement_NoItemsMessage'), GlobalVariable.timeOutValue)

String actualNoItemsMessage = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/webElement_NoItemsMessage'))


KeywordUtil.logInfo('Verified that no element items exist with given name')

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_CreateNew'), 25)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_CreateNew'))

KeywordUtil.logInfo('Entering all the required data to create Reinsured')

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'insuredName')]), reInsuredName)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'addressLine1')]), findTestData(testData).getValue('AddressLine1', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'cityName')]), findTestData(testData).getValue('CityName', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'postCode')]), findTestData(testData).getValue('ZipCode', rowNumber))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/select_DynamicDropDown', [('dropDownLabel') : labelName.getAt('country')]))

WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/select_DynamicDropDown',
		[('dropDownLabel') : labelName.getAt('country')]), findTestData(testData).getValue('SelectCountry', rowNumber), false)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/button_CreateNew'))
WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateReInsured/webElement_SuccessMessage'), 60)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'searchReInsuredName')]))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'searchReInsuredName')]), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'searchReInsuredName')]), Keys.chord(Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
				'searchReInsuredName')]), reInsuredName)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/button_SearchReinsured'))

