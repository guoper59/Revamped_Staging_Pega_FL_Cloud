/**
 * ============================================================================
 * Test Case ID : 259399
 * Title         : Sub Test Case Part1
 * Folder        : Scripts/Worksheets/259399_SubTestCase_Part1
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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

WebUI.waitForElementVisible(findTestObject('Object Repository/UnderwritingWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']))

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UnderwritingWorksheet/text_FieldText', [('fieldName') : 'S & P Company Name'])), 
    'Aberdeen Group Plc')


WebUI.scrollToElement(findTestObject('Object Repository/UnderwritingWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Directors & Officers´ Liability'
            , ('index') : 2]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Directors & Officers´ Liability'
            , ('index') : 2]))


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_ApprovedCheckBox', [('index') : 4]), GlobalVariable.timeOutValue)

WebUI.check(findTestObject('Object Repository/UWWorksheet/webElement_ApprovedCheckBox', [('index') : 4]))


WebUI.scrollToElement(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName_Index', [
            ('fieldName') : 'Approved by Underwriting Authority?', ('option') : option_Yes, ('index') : 2]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName_Index', [('fieldName') : 'Approved by Underwriting Authority?'
            , ('option') : option_Yes, ('index') : 2]))


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_PendingAuthorityStatus1', [('fieldName') : 'UW Authority Completed']), 
    20)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Submit', [('index') : 2]))


WebUI.scrollToElement(findTestObject('Object Repository/UnderwritingWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Professional Indemnity'
            , ('index') : 2]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Professional Indemnity'
            , ('index') : 2]))

WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_ApprovedCheckBox', [('index') : 2]), GlobalVariable.timeOutValue)

WebUI.check(findTestObject('Object Repository/UWWorksheet/webElement_ApprovedCheckBox', [('index') : 2]))

WebUI.scrollToElement(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName_Index', [
            ('fieldName') : 'Approved by Underwriting Authority?', ('option') : option_Yes, ('index') : 1]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName_Index', [('fieldName') : 'Approved by Underwriting Authority?'
            , ('option') : option_Yes, ('index') : 1]))

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Submit', [('index') : 1]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Savewithiframe1', [('index') : 11]))


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_PendingAuthorityStatus1', [('fieldName') : 'UW Authority Completed']), 
    20)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the Worksheet been completed?'
            , ('option') : option_Yes]))

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Submit', [('index') : 1]))


WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div_Frame1', [('fieldName') : 'Have all the necessary UW Authority Approvals been received? Click Continue to proceed.']))

WebUI.switchToFrame(findTestObject('Object Repository/NewBusiness/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue)

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_ContinueText'))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_ContinueText'))

WebUI.switchToDefaultContent()


WebUI.waitForElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div_Frame1', [
            ('fieldName') : 'Your action has been completed.']), GlobalVariable.timeOutValue)

String successMessage = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div_Frame1', 
        [('fieldName') : 'Your action has been completed.']))

GenericUtils.verifyMatch('Success Message Displayed', successMessage, 'Your action has been completed.', 'EQUAL')

String status = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_statusOnTop_Frame1', [('status') : 'Resolved-Completed']))

GenericUtils.verifyMatch('Status Displayed', status, 'Resolved-Completed', 'EQUAL')

String attachmentFile = WebUI.getAttribute(findTestObject('Object Repository/Pega_CreateInsured/webElement_Attachment_Frame1'), 
    'title')

GenericUtils.verifyMatch('Attachment file Displayed', attachmentFile, 'FI Wkt - Vers 1', 'CONTAINS')

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_ToolsActions_Frame1', [('actionName') : 'Print this work item'
            , ('index') : 2]))

KeywordUtil.markPassed('New Tab is opened with PDF file')