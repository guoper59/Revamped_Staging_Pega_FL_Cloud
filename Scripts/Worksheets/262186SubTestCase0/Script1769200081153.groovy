/**
 * ============================================================================
 * Title        : 262186SubTestCase0
 * Title         : 262186SubTestCase0
 * Folder        : Scripts/Worksheets/262186SubTestCase0
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
import java.text.SimpleDateFormat as SimpleDateFormat
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.login.helper.LoginHelper as LoginHelper
import com.submission.helper.SubmissionHelper as SubmissionHelper
import com.testdata.helper.UWWorksheet as UWWorksheet
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

//			, ('option') : option_No]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Approved by Underwriting Authority?'
			, ('option') : option_No]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Comments from Underwriting Authority?']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Comments from Underwriting Authority?']), "Test test test test")
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Comments from Underwriting Authority?']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Comments from Underwriting Authority?']), "Test test test test")

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Submit', [('index') : '1']))




WebUI.refresh()

CustomKeywords.'com.login.helper.LoginHelper.logOffApplication'()


CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Avazquez', GlobalVariable.Avazquez, findTestData(testData).getValue('Role', rowNumber))


WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : underwritingWorksheetLink]))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

// Find the test object for the policy reference field on the Pega Case Manager Portal
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']),
	insuredName)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : insuredName]),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : insuredName]))


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', [('fieldName') : 'Insured Name']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/link_WCase', [('ID') : caseID]))
WebUI.verifyElementPresent(findTestObject('Object Repository/UnderwritingWorksheet/link_OptionName', [('option') : 'Overview']),
	GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UnderwritingWorksheet/link_OptionName', [('option') : 'UW Worksheet']),
	GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UnderwritingWorksheet/link_OptionName', [('option') : 'History']),
	GlobalVariable.timeOutValue)

WebUI.waitForElementVisible(findTestObject('Object Repository/UnderwritingWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']))
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UnderwritingWorksheet/text_FieldText', [('fieldName') : 'S & P Company Name'])),
	'Air France-KLM SA')


//Final Program Structure
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/select_DropDown', [('section') : 'Final Program Structure'
			, ('fieldName') : 'Currency']), currencyType, false)
WebUI.click(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/webElement_Button', [('section') : 'Final Program Structure'
			, ('button') : 'Copy Expiring PS']))

