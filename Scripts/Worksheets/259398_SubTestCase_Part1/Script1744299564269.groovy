/**
 * ============================================================================
 * Test Case ID : 259398
 * Title         : Sub Test Case Part1
 * Folder        : Scripts/Worksheets/259398_SubTestCase_Part1
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

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

int currentTab = WebUI.getWindowIndex()

KeywordUtil.logInfo(currentTab)

WebUI.switchToWindowIndex(currentTab + 1)

WebUI.verifyTextPresent(('UW Authority needed for: ' + GlobalVariable.insuredName) + ' - D&O - 2023 - Commercial D&O Worksheet', 
    false)

WebUI.switchToFrame(findTestObject('Object Repository/UWWorksheet/webElement_AttachmentIframe'), GlobalVariable.timeoutShort)

WebUI.verifyTextPresent('Dear UW Authority, ' + UWAuthority, false)

WebUI.verifyTextPresent('Please complete the UW Authority Approval Process for the Worksheet of : ' + GlobalVariable.insuredName, 
    false)

WebUI.verifyTextPresent('Major Class : D&O', false)

WebUI.verifyTextPresent('Year : 2023', false)

WebUI.verifyTextPresent('Please click directly on the hyperlink to open the case', false)

WebUI.verifyTextPresent('or access the Worksheet from the Underwriting Worksheet Workbasket in Pega available from the navigation bar.', 
    false)

WebUI.verifyTextPresent('Please note that this is a mandatory step and that the Worksheet cannot be finalized until the UW Authority approval process has been completed.', 
    false)

WebUI.closeWindowIndex(currentTab + 1)

WebUI.switchToWindowIndex(currentTab)


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))


//Logging in with Underwriter Assistant

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Hbakker', GlobalVariable.Hbakker, 'UW1')
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Clicking Underwriting Worksheet option from left side menu

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Underwriting Worksheet']))


// Find the test object for the policy reference field on the Pega Case Manager Portal
WebUI.setText(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']), GlobalVariable.insuredName)
WebUI.sendKeys(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']), Keys.chord(Keys.BACK_SPACE))

String insured = GlobalVariable.insuredName

String currentText =  insured.substring(0, insured.length()-1)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult0', [('projectName') : currentText ] ))

WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult0', [('projectName') : currentText ] ))


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', [('fieldName') : 'Insured Name']), 
    GlobalVariable.timeOutValue)

String insuredNameVisible = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Insured Name']), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Insured Name: ' + insuredNameVisible)

String worksheetID = WebUI.getText(findTestObject('Object Repository/SubmissionSearch/webElement_forValidation'), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Worksheet ID Value: ' + worksheetID)

KeywordUtil.logInfo('Insured Name from Sheet: ' + GlobalVariable.insuredName)

String multiLOB = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Multi-LOB ID']), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Multi LOB ID Value: ' + multiLOB)

String policyRef = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Policy Reference']), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Policy Ref Value: ' + policyRef)

String year = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', [('fieldName') : 'Year']), 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Year Value: ' + year)

String majorClass = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Major Class']), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Major Class Value: ' + majorClass)

String worksheetStatus = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Worksheet Status']), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Worksheet Status Value: ' + worksheetStatus)

String worksheetType = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Worksheet Type']), FailureHandling.STOP_ON_FAILURE).trim()

KeywordUtil.logInfo('Worksheet Type Value: ' + worksheetType)

WebUI.click(findTestObject('Object Repository/UWWorksheet/link_WCase'))
WebUI.waitForElementVisible(findTestObject('Object Repository/UnderwritingWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']))
WebUI.scrollToElement(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Approved by Underwriting Authority?'
            , ('option') : option_Yes]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Approved by Underwriting Authority?'
            , ('option') : option_Yes]))
String currentDate = new SimpleDateFormat('dd/MM/yyyy').format(Calendar.getInstance().time)

String submissionReceivedDate = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Date']), 
    'value')

GenericUtils.verifyMatch('Date Value is', submissionReceivedDate, currentDate, 'EQUAL')

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Option']), 
    '1', false)


WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the Worksheet been completed?'
            , ('option') : option_Yes]))


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_ApprovedCheckBox', [('index') : 2]), GlobalVariable.timeOutValue)

WebUI.check(findTestObject('Object Repository/UWWorksheet/webElement_ApprovedCheckBox', [('index') : 2]))


WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Submit', [('index') : 1]))




WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))


//Logging in with Underwriter Assistant

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Avazquez', GlobalVariable.Avazquez, 'UW2')
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Clicking Underwriting Worksheet option from left side menu

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Underwriting Worksheet']))


// Find the test object for the policy reference field on the Pega Case Manager Portal
WebUI.setText(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']), GlobalVariable.insuredName)
WebUI.sendKeys(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']), Keys.chord(Keys.BACK_SPACE))


WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult0', [('projectName') : currentText ] ))

WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult0', [('projectName') : currentText ] ))


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', [('fieldName') : 'Insured Name']), 
    GlobalVariable.timeOutValue)

String insuredNameVisible2 = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Insured Name']), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Insured Name: ' + insuredNameVisible2)

WebUI.click(findTestObject('Object Repository/UWWorksheet/link_WCase'))

WebUI.waitForElementVisible(findTestObject('Object Repository/UnderwritingWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']))


WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Additional Authority Required?'
            , ('option') : option_Yes]))


String authorityStatus1 = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_Status1'))

WebUI.verifyMatch(authorityStatus1, 'UW Authority Completed', false)

WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/select_DropDown_1', [('fieldName') : 'Currency', ('index') : 3]), 5)
WebUI.click(findTestObject('Object Repository/UWWorksheet/select_DropDown_1', [('fieldName') : 'Currency', ('index') : 3]))
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown_1', [('fieldName') : 'Currency', ('index') : 3]), 
    'EUR', false)


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName_1', [('headerName') : 'Final Program Structure'
            , ('buttonText') : 'Copy Pricing Ops']))


WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Rater & Tearsheet Attached?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Within Underwriter´s Authority?'
            , ('option') : option_Yes]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on the ESG profile of the company']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on the ESG profile of the company']), 
    'Test ESG')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on the ESG profile of the company']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on the ESG profile of the company']), 
    'Test ESG')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on any Cyber exposure']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on any Cyber exposure']), 
    'Test Cyber')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on any Cyber exposure']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Please comment on any Cyber exposure']), 
    'Test Cyber')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: Last Year´s comments']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: Last Year´s comments']), 
    'Test Last Year´s comments')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: Last Year´s comments']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: Last Year´s comments']), 
    'Test Last Year´s comments')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: This Year´s comments']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: This Year´s comments']), 
    'Test This Year´s comments')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: This Year´s comments']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Rationale: This Year´s comments']), 
    'Test This Year´s comments')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Points of attention for next renewal, if any']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Points of attention for next renewal, if any']), 
    'Test points of attention')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Points of attention for next renewal, if any']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea1', [('fieldName') : 'Points of attention for next renewal, if any']), 
    'Test points of attention')

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Savewithiframe1', [('index') : 8]))


WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the Worksheet been completed?'
            , ('option') : option_Yes]))

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Submit', [('index') : 1]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName', [('fieldName') : 'Have all the necessary UW Authority Approvals been received? Click Continue to proceed.']))

WebUI.switchToFrame(findTestObject('Object Repository/NewBusiness/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue)

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_ContinueText'))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_ContinueText'))

WebUI.switchToDefaultContent()


WebUI.waitForElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName', [('fieldName') : 'Your action has been completed.']), 
    GlobalVariable.timeOutValue)

String successMessage = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName', [('fieldName') : 'Your action has been completed.']))

GenericUtils.verifyMatch('Success Message Displayed', successMessage, 'Your action has been completed.', 'EQUAL')

String status = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_statusOnTop_Frame1', [('status') : 'Resolved-Completed']))

GenericUtils.verifyMatch('Status Displayed', status, 'Resolved-Completed', 'EQUAL')

String attachmentFile = WebUI.getAttribute(findTestObject('Object Repository/Pega_CreateInsured/webElement_Attachment_Frame1'), 
    'title')

GenericUtils.verifyMatch('Attachment file Displayed', attachmentFile, 'Com. Wkt - Vers 1', 'CONTAINS')

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_ToolsActions_Frame1', [('actionName') : 'Print this work item'
            , ('index') : 2]))

WebUI.switchToWindowIndex(currentTab + 1)

WebUI.closeWindowIndex(currentTab + 1)

WebUI.switchToWindowIndex(currentTab)


WebUI.scrollToElement(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/button_Close'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/button_Close'))

