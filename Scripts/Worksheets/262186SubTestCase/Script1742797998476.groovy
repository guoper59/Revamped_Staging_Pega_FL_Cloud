/**
 * ============================================================================
 * Title        : 262186SubTestCase
 * Title         : 262186SubTestCase
 * Folder        : Scripts/Worksheets/262186SubTestCase
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

import java.text.SimpleDateFormat

import org.openqa.selenium.Keys

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.testdata.helper.UWWorksheet

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

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

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on the ESG profile of the company']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on the ESG profile of the company']), "Test ESG")
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on the ESG profile of the company']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on the ESG profile of the company']), "Test ESG")

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on any Cyber exposure']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on any Cyber exposure']), "Test Cyber")
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on any Cyber exposure']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on any Cyber exposure']), "Test Cyber")

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: Last Year´s comments']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: Last Year´s comments']), "Test Last Year´s comments")
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: Last Year´s comments']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: Last Year´s comments']), "Test Last Year´s comments")

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: This Year´s comments']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: This Year´s comments']), "Test This Year´s comments")
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: This Year´s comments']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: This Year´s comments']), "Test This Year´s comments")

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Points of attention for next renewal, if any']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Points of attention for next renewal, if any']), "Test points of attention")
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Points of attention for next renewal, if any']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Points of attention for next renewal, if any']), "Test points of attention")

UWWorksheet.verifyFinalProgramStructureTableDetails_IFrame1(EPSNewList, 1)

UWWorksheet.verifyFinalProgramStructureTableDetails_IFrame1(EPSNewList1, 2)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Rater & Tearsheet Attached?'
			, ('option') : option_Yes]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Savewithiframe1', [('index') : '8']))

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Close'))

CustomKeywords.'com.login.helper.LoginHelper.logOffApplication'()

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : underwritingWorksheetLink]))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/button_ResetSearch'), 25)
WebUI.click(findTestObject('Object Repository/Endorsements/button_ResetSearch'))

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

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_ExpandAll1'))

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Submit', [('index') : '1']))

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Close'))

CustomKeywords.'com.login.helper.LoginHelper.logOffApplication'()

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Hbakker', GlobalVariable.Hbakker, findTestData(testData).getValue('Role', rowNumber))

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : underwritingWorksheetLink]))

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

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_ExpandAll1'))

WebUI.verifyElementPresent(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Approved by Underwriting Authority?'
			, ('option') : option_Yes]), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Approved by Underwriting Authority?'
			, ('option') : option_Yes]))

String todayDate = new SimpleDateFormat('dd/MM/yyyy').format(new Date())

String SPDataRefreshDate = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldTextwithIframe1', [('fieldName') : 'Date']))

String[] SPDataRefreshDateOf = SPDataRefreshDate.split(' ')

KeywordUtil.logInfo('Date is : ' + todayDate)

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Comments from Underwriting Authority?']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Comments from Underwriting Authority?']), "Test Test Test Test")
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Comments from Underwriting Authority?']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Comments from Underwriting Authority?']), "Test Test Test Test")

WebUI.check(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/webElement_TableColumnField', [('section') : 'Pricing Options'
			, ('fieldName') : 'pApproved', ('index') : '2']))
WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Submit', [('index') : '1']))

WebUI.verifyElementPresent(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the Worksheet been completed?'
			, ('option') : option_Yes]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the Worksheet been completed?'
			, ('option') : option_Yes]))
WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Submit', [('index') : '1']))

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

String successMessage = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_SuccessMessage'))

GenericUtils.verifyMatch('Success Message Displayed', successMessage, 'Your action has been completed.', 'EQUAL')

// Switch to the pop-up window

WebUI.switchToDefaultContent()

KeywordUtil.logInfo('Switched back to the main application window.')

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Close'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))
// Find the test object for the policy reference field on the Pega Case Manager Portal
WebUI.scrollToElement(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']),
   GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']))
WebUI.sendKeys(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']), Keys.chord(
	   Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']), GlobalVariable.insuredName)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : GlobalVariable.insuredName]),
   GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : GlobalVariable.insuredName]))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))

WebUI.click(findTestObject('Object Repository/UWWorksheet/link_WCase'))

String attachmentFile1 = WebUI.getAttribute(findTestObject('Object Repository/Pega_CreateInsured/webElement_Attachment_Frame1'),
   'title')

//
//// Find the test object for the policy reference field on the Pega Case Manager Portal
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

//
//
