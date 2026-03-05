/**
 * ============================================================================
 * Test Case ID : 262184
 * Title         : Verify Worksheetdetailscollapsibleheaderwithoutconnectingto SP Company Part1
 * Folder        : Scripts/Worksheets/262184_VerifyWorksheetdetailscollapsibleheaderwithoutconnectingtoSPCompany_Part1
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

import static com.kms.katalon.core.model.FailureHandling.CONTINUE_ON_FAILURE
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.testdata.helper.UWWorksheet

import internal.GlobalVariable
import internal.GlobalVariable as Keys
import org.openqa.selenium.Keys

//Programme Structure and Authority
UWWorksheet.verifyStructureTableHeaderDetails('Expiring Program Structure')

WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/select_DropdownYesUWAuthority'), GlobalVariable.timeoutShort)


WebUI.enhancedClick(findTestObject('Object Repository/UWWorksheet/select_DropdownYesUWAuthority'))


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_StatusAuthorityCompleted'), GlobalVariable.timeoutShort)


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/select_DropdownYesUWAuthority'), GlobalVariable.timeoutShort)


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/select_AdditionalAuthorityRequired'), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
            , ('button') : addItem_Button]), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
            , ('button') : delete_Button]), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
            , ('button') : ' Refresh']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Pricing Options'
            , ('fieldName') : 'Currency']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Pricing Options'
            , ('button') : 'Copy Expiring PS']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Pricing Options'
            , ('fieldName') : 'Option']), GlobalVariable.timeOutValue)

UWWorksheet.verifyStructureTableHeaderDetails('Pricing Options')

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Pricing Options'
            , ('button') : addItem_Button]), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Pricing Options'
            , ('button') : delete_Button]), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Pricing Options'
            , ('button') : ' Refresh']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Pricing Options'
            , ('fieldName') : 'Underwriter ']), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Within Underwriter´s Authority?'
            , ('option') : option_Yes]))

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Final Program Structure'
            , ('fieldName') : 'Currency']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure'
            , ('button') : 'Copy Expiring PS']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure'
            , ('button') : 'Copy Pricing Ops']), GlobalVariable.timeOutValue)

UWWorksheet.verifyStructureTableHeaderDetails('Final Program Structure')

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure'
            , ('button') : addItem_Button]), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure'
            , ('button') : delete_Button]), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure'
            , ('button') : ' Refresh']), GlobalVariable.timeOutValue)

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'Currency']), currencyType, false)


WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
            , ('button') : addItem_Button]))


UWWorksheet.enterDataStructureTableDetails('Expiring Program Structure', expiringProgramStructureList, 1)

UWWorksheet.verifyStructureTableDetails('Expiring Program Structure', EPSNewList, 1)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
            , ('button') : addItem_Button]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
	, ('button') : addItem_Button]))

UWWorksheet.enterDataStructureTableDetails('Expiring Program Structure', expiringProgramStructureList1, 2)


//Pricing Options
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Pricing Options'
            , ('fieldName') : 'Currency']), currencyType, false)


WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Pricing Options', ('button') : 'Copy Expiring PS']))




WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Within Underwriter´s Authority?'
            , ('option') : option_Yes]))

//Pricing Options
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Final Program Structure'
            , ('fieldName') : 'Currency']), currencyType, false)


WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure', ('button') : 'Copy Expiring PS']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Save', [('index') : index1]))


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the Worksheet been completed?'
            , ('option') : option_Yes]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the Worksheet been completed?'
            , ('option') : option_Yes]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Submit', [('index') : index1]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Continue'))


String successMessage = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SuccessMessage'))

GenericUtils.verifyMatch('Success Message Displayed', successMessage, 'Your action has been completed.', 'EQUAL')

WebUI.switchToDefaultContent()

KeywordUtil.logInfo('Switched back to the main application window.')
WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_Close'), 25)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Close'))
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Submission Search']))

//This is to avoid 2 policyref fields
WebUI.refresh()


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownYearsofAccount1'), 
    'Unknown', false)


WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference1'), GlobalVariable.PolicyRef)


WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch1'))

