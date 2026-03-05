/**
 * ============================================================================
 * Test Case ID : 259399
 * Title         : Verify Financial Worksheet Approval Through Online And With SP Connect
 * Folder        : Scripts/Worksheets/259399_VerifyFinancialWorksheetApprovalThroughOnlineAndWithSPConnect
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
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.testdata.helper.UWWorksheet as UWWorksheet
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

int rowNumbertestData = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID + '_1')

int rowNumbertestDataN = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID + '_2')

KeywordUtil.logInfo(GlobalVariable.testCaseID)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Emueller', GlobalVariable.Emueller, findTestData(testData).getValue('Role', rowNumber))

KeywordUtil.logInfo('Creating a Submission')

String insuredName = UWWorksheet.createFinancialSubmission(testData, rowNumber)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)

GlobalVariable.PolicyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

KeywordUtil.logInfo(GlobalVariable.PolicyRef)

//Click on the 'OK' element on the page.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Click on the 'Create' button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.focus(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForPageLoad(GlobalVariable.timeoutShort)

WebUI.switchToFrame(findTestObject('Object Repository/NewBusiness/iframe_PegaGadget2Ifr'), GlobalVariable.timeoutShort)

WebUI.setText(findTestObject('Object Repository/NewBusiness/input_BusinessUnit'), insuredName)

WebUI.waitForPageLoad(GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/btn_SearchName'))

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/radioButton_ReinsuredInformation', [('optionToSelect') : option_No]), 
    GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/radioButton_ReinsuredInformation', [('optionToSelect') : option_No]))

WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_TableField', [('fieldName') : 'Insured name']), 60)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableField', [('fieldName') : 'Insured name']))

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableField', [('fieldName') : 'Insured name']))

WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_ContinueText'), 60)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_ContinueText'))

WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_Broker'),60)

UWWorksheet.updateFinancialSubmission(testData, rowNumbertestData)

WebUI.waitForElementVisible(findTestObject('Object Repository/UWWorksheet/button_OK'), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Click on the 'OK' element on the page.
WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_OK'), 60)
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_OK'))

WebUI.switchToDefaultContent()

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

//Click on the 'Create' button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

//Wait for the 'Start Financial Lines Submission' element to be visible.

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.switchToFrame(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/iframe_PegaGadget3lfr'), 
    GlobalVariable.timeoutShort)

WebUI.setText(findTestObject('Object Repository/NewBusiness/input_BusinessUnit'), insuredName)

WebUI.click(findTestObject('Object Repository/NewBusiness/btn_SearchName'))

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/radioButton_ReinsuredInformation', [('optionToSelect') : option_Yes]), 
    GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/radioButton_ReinsuredInformation', [('optionToSelect') : option_Yes]))

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropdownReinsuredName'), findTestData(testData).getValue(
        'Reinsured Name', rowNumbertestDataN), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_TableField', [('fieldName') : 'Insured name']), 60)
WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableField', [('fieldName') : 'Insured name']))

WebUI.switchToDefaultContent()
WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_ContinueText1'), 60)
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_ContinueText1'))

WebUI.switchToFrame(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/iframe_PegaGadget3lfr'), 60)

UWWorksheet.updateFinancialSubmission(testData, rowNumbertestDataN)

//Click on the 'OK' element on the page.
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_OK3'))

WebUI.switchToDefaultContent()

String caseID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/link_UWWorkSheetStage1'))

KeywordUtil.logInfo('Case ID : ' + caseID)

WebUI.click(findTestObject('Object Repository/UWWorksheet/link_UWWorkSheetStage1'))

WebUI.switchToDefaultContent()

WebUI.switchToFrame(findTestObject('Object Repository/UWWorksheet/iframe_PageGrade4'), GlobalVariable.timeOutValue)

WebUI.switchToDefaultContent()

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName1', [('option') : 'Overview']), 
    GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName1', [('option') : 'UW Worksheet']), 
    GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName1', [('option') : 'History']), GlobalVariable.timeOutValue)

WebUI.waitForElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_CaseContentsOptions1', [('linkToClick') : 'UW Worksheet']), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_CaseContentsOptions1', [('linkToClick') : 'UW Worksheet']))

WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_InsuredName1'), 'value'), insuredName)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/toolTip_InsuredName1'), GlobalVariable.timeOutValue)

WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText1', [('fieldName') : 'S&P Unique Identifier']), 
        'value'), '')

WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText1', [('fieldName') : 'City']), 
        'value'), '')

WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText1', [('fieldName') : 'Country']), 
        'value'), '')

WebUI.clearText(findTestObject('Object Repository/UWWorksheet/input_InsuredName1'))

WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_InsuredName1'), searchText)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Search1'))

WebUI.waitForElementVisible(findTestObject('Object Repository/UWWorksheet/button_SelectIdentifierWithIndex', [('index') : 1]),
	60)
WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_SelectIdentifierWithIndex', [('index') : 1]),
	60)
WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_SelectIdentifierWithIndex', [('index') : 1]), 
    60)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_SelectIdentifierWithIndex', [('index') : 1]))

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelected1', [('fieldName') : 'Index for Price Change Comparison'
            , ('selected') : indexForPriceChangeComparison]), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelectedText1', [('fieldName') : 'Currency'
            , ('selected') : currency]), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelectedText1', [('fieldName') : 'Magnitude'
            , ('selected') : Millions]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Connect1'))

WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_CollapseAll2'), 60)

WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_CollapseAll2'), 25)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_CollapseAll2'))

//
for (int i = 1; i <= collapseAllHeaderList.size(); i++) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders4', [('header') : collapseAllHeaderList[
                (i - 1)]]), GlobalVariable.timeOutValue)

    String expanded = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_getAttributeHeaders', 
            [('header') : collapseAllHeaderList[(i - 1)]]), 'aria-expanded')

    KeywordUtil.logInfo('When user collapsed all then expanded is false')

    WebUI.verifyEqual(expanded, 'false')
}

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_ExpandAll2'))

for (int i = 1; i <= collapseAllHeaderList.size(); i++) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders4', [('header') : collapseAllHeaderList[
                (i - 1)]]), GlobalVariable.timeOutValue)

    String expanded = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_getAttributeHeaders', 
            [('header') : collapseAllHeaderList[(i - 1)]]), 'aria-expanded')

    KeywordUtil.logInfo('When user expanded all then expanded is true')

    WebUI.verifyEqual(expanded, 'true')
}

KeywordUtil.logInfo('Worksheet Details')

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText1', [('fieldName') : 'S & P Company Name'])), 
    'Aberdeen Group Plc')

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText1', [('fieldName') : 'S & P Unique Identifier'])), 
    uniqueIdentifierList[0])

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText1', [('fieldName') : 'S & P Refresh User'])), 
    'EMUELLER')

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText1', [('fieldName') : 'Insured Name'])), 
    insuredName)

UWWorksheet.verifyWorkSheetDetailsFor_259399(testData, rowNumber)

KeywordUtil.logInfo('Company Information')

WebUI.callTestCase(findTestCase('Test Cases/Worksheets/259399_SubTestCase_Part0'), [('testData') : testData, ('rowNumber') : rowNumber], 
    FailureHandling.STOP_ON_FAILURE)

//Pricing Options
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Crime', ('section') : 'Pricing Options'
            , ('fieldName') : 'Currency']), currencyType, false)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Crime', ('section') : 'Pricing Options'
            , ('button') : 'Copy Expiring PS']))

UWWorksheet.verifyPricingOptionsStructureDetails('Crime', EPSNewList, 1)

UWWorksheet.verifyPricingOptionsStructureDetails('Crime', EPSNewList1, 2)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Crime', ('fieldName') : 'Within Underwriter´s Authority?'
            , ('option') : option_No]))

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Crime', ('section') : 'Pricing Options'
            , ('fieldName') : 'UW Authority']), 'Paul Rayner', false)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Crime', ('fieldName') : 'Authority Approval Method'
            , ('option') : 'Online']))

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Crime'
            , ('fieldName') : 'Referral account? ', ('option') : option_Yes]), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Crime'
            , ('fieldName') : 'Referral account? ', ('option') : option_No]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Crime', ('fieldName') : 'Referral account? '
            , ('option') : option_Yes]))

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Crime', ('section') : 'Pricing Options'
            , ('fieldName') : 'FL Manager ']), 'Paul Rayner', false)

WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_Submit1', [('index') : indexOne]), 60)
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Submit1', [('index') : indexOne]))

WebUI.waitForElementNotHasAttribute(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Crime', ('section') : 'Final Program Structure'
            , ('fieldName') : 'Currency']), 'disabled', 60, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.scrollToPosition(200, 200)
WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Crime', ('section') : 'Final Program Structure'
            , ('fieldName') : 'Currency']), 10)
WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Crime', ('section') : 'Final Program Structure'
            , ('fieldName') : 'Currency']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Crime', ('section') : 'Final Program Structure'
            , ('fieldName') : 'Currency']), currencyType, false)

WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Crime', ('section') : 'Final Program Structure'
	, ('button') : 'Copy Pricing Ops']), 60)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Crime', ('section') : 'Final Program Structure'
            , ('button') : 'Copy Pricing Ops']))

UWWorksheet.verifyFinalProgramStructureTableDetails_IFrame4('Crime', EPSNewList, 1)

UWWorksheet.verifyFinalProgramStructureTableDetails_IFrame4('Crime', EPSNewList1, 2)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_SelectTab', [('section') : 'Programme Structure and Authority'
            , ('fieldName') : 'Professional Indemnity']))

UWWorksheet.verifyStructureDetails_Iframe4('Professional Indemnity', 'Expiring Program Structure')

UWWorksheet.verifyStructureTableHeaderDetails_Iframe4('Expiring Program Structure')

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Professional Indemnity'
            , ('section') : 'Pricing Options', ('button') : 'Copy Expiring PS']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : 'Pricing Options'
            , ('fieldName') : 'Option']), GlobalVariable.timeOutValue)

UWWorksheet.verifyStructureDetails_Iframe4('Professional Indemnity', 'Pricing Options')

UWWorksheet.verifyStructureTableHeaderDetails_Iframe4('Pricing Options')

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Professional Indemnity'
            , ('section') : 'Pricing Options', ('fieldName') : 'Underwriter ']), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Professional Indemnity'
            , ('fieldName') : 'Within Underwriter´s Authority?', ('option') : option_Yes]))

UWWorksheet.verifyCopyExpiringPSAndCopyPricingOpsButtons('Professional Indemnity', 'Final Program Structure')

UWWorksheet.verifyStructureDetails_Iframe4('Professional Indemnity', 'Final Program Structure')

UWWorksheet.verifyStructureTableHeaderDetails_Iframe4('Final Program Structure')

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Professional Indemnity'
            , ('section') : 'Expiring Program Structure', ('fieldName') : 'Currency']), currencyType, false)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Professional Indemnity', ('section') : 'Expiring Program Structure'
            , ('button') : 'Add item']))

UWWorksheet.enterDataStructureFieldTableDetails('Professional Indemnity', 'Expiring Program Structure', expiringProgramStructureList, 
    1)

UWWorksheet.verifyStructureTableDetails_iframe4('Professional Indemnity', 'Expiring Program Structure', EPSNewList, 1)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Professional Indemnity', ('section') : 'Expiring Program Structure'
            , ('button') : 'Add item']))

UWWorksheet.enterDataStructureFieldTableDetails('Professional Indemnity', 'Expiring Program Structure', expiringProgramStructureList1, 
    2)

UWWorksheet.verifyStructureTableDetails_iframe4('Professional Indemnity', 'Expiring Program Structure', EPSNewList1, 2)

//Pricing Options
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Professional Indemnity'
            , ('section') : 'Pricing Options', ('fieldName') : 'Currency']), currencyType, false)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Professional Indemnity', ('section') : 'Pricing Options'
            , ('button') : 'Copy Expiring PS']))

UWWorksheet.verifyPricingOptionsStructureDetails('Professional Indemnity', EPSNewList, 1)

UWWorksheet.verifyPricingOptionsStructureDetails('Professional Indemnity', EPSNewList1, 2)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Professional Indemnity'
            , ('fieldName') : 'Within Underwriter´s Authority?', ('option') : option_No]))

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Professional Indemnity'
            , ('section') : 'Pricing Options', ('fieldName') : 'UW Authority']), 'Adam Bohle', false)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Professional Indemnity'
            , ('fieldName') : 'Authority Approval Method', ('option') : 'Online']))

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Professional Indemnity'
            , ('fieldName') : 'Referral account? ', ('option') : option_Yes]), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Professional Indemnity'
            , ('fieldName') : 'Referral account? ', ('option') : option_No]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Professional Indemnity'
            , ('fieldName') : 'Referral account? ', ('option') : option_Yes]))

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Professional Indemnity'
            , ('section') : 'Pricing Options', ('fieldName') : 'FL Manager ']), 'Paul Rayner', false)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Submit1', [('index') : indexOne]))

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Professional Indemnity'
            , ('section') : 'Final Program Structure', ('fieldName') : 'Currency']), currencyType, false)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Professional Indemnity', ('section') : 'Final Program Structure'
            , ('button') : 'Copy Pricing Ops']))

UWWorksheet.verifyFinalProgramStructureTableDetails_IFrame4('Professional Indemnity', EPSNewList, 1)

UWWorksheet.verifyFinalProgramStructureTableDetails_IFrame4('Professional Indemnity', EPSNewList1, 2)

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Please comment on the ESG profile of the company']))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Please comment on the ESG profile of the company']), 
    'Test ESG')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Please comment on the ESG profile of the company']))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Please comment on the ESG profile of the company']), 
    'Test ESG')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Please comment on any Cyber exposure']))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Please comment on any Cyber exposure']), 
    'Test Cyber')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Please comment on any Cyber exposure']))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Please comment on any Cyber exposure']), 
    'Test Cyber')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Rationale: Last Year´s comments']))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Rationale: Last Year´s comments']), 
    'Test Last Year´s comments')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Rationale: Last Year´s comments']))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Rationale: Last Year´s comments']), 
    'Test Last Year´s comments')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Rationale: This Year´s comments']))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Rationale: This Year´s comments']), 
    'Test This Year´s comments')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Rationale: This Year´s comments']))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Rationale: This Year´s comments']), 
    'Test This Year´s comments')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Points of attention for next renewal, if any']))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Points of attention for next renewal, if any']), 
    'Test points of attention')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Points of attention for next renewal, if any']))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Points of attention for next renewal, if any']), 
    'Test points of attention')

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName1', [('fieldName') : 'Rater & Tearsheet Attached?'
            , ('option') : option_Yes]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Save1', [('index') : indexOne]))

WebUI.switchToDefaultContent()

CustomKeywords.'com.login.helper.LoginHelper.logOffApplication'()

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Prayner', GlobalVariable.Prayner, findTestData(testData).getValue('Role', rowNumber))

KeywordUtil.logInfo('Loggedin to Pega with valid UWA User credentials ')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : underwritingWorksheetLink]))
//Navigated to Underwriting Worksheet
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.click(findTestObject('Object Repository/SubmissionSearch/more_Filters'))

KeywordUtil.logInfo('Navigated to Underwriting Worksheet')
WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/input_FieldName', [('fieldName') : 'Multi-LOB Programme ID']), 25)
WebUI.click(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/input_FieldName', [('fieldName') : 'Multi-LOB Programme ID']))
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

WebUI.scrollToElement(findTestObject('Object Repository/UnderwritingWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']))

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UnderwritingWorksheet/text_FieldText', [('fieldName') : 'S & P Company Name'])), 
    'Aberdeen Group Plc')

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UnderwritingWorksheet/text_FieldText', [('fieldName') : 'S & P Unique Identifier'])), 
    uniqueIdentifierList[0])

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UnderwritingWorksheet/text_FieldText', [('fieldName') : 'S & P Refresh User'])), 
    'EMUELLER')

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UnderwritingWorksheet/text_FieldText', [('fieldName') : 'Insured Name'])), 
    insuredName)

WebUI.scrollToElement(findTestObject('Object Repository/UnderwritingWorksheet/webElement_DynamicLOBSpecificTabs', [('headerName') : 'Programme Structure and Authority'
            , ('tabName') : 'Crime']), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/webElement_DynamicLOBSpecificTabs', [('headerName') : 'Programme Structure and Authority'
            , ('tabName') : 'Crime']))

WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_ApprovedCheckBox', [('index') : 2]), GlobalVariable.timeOutValue)

WebUI.check(findTestObject('Object Repository/UWWorksheet/webElement_ApprovedCheckBox', [('index') : 2]))

WebUI.scrollToElement(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Approved by Underwriting Authority?'
            , ('option') : option_Yes]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Approved by Underwriting Authority?'
            , ('option') : option_Yes]))

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Submit', [('index') : 1]))

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the Worksheet been completed?'
            , ('option') : option_Yes]))

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Submit', [('index') : 1]))

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_PendingAuthorityStatus1', [('fieldName') : 'Pending - Authority']), 
    20)

CustomKeywords.'com.login.helper.LoginHelper.logOffApplication'()

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Abohle', GlobalVariable.Abohle, findTestData(testData).getValue('Role', rowNumber))

KeywordUtil.logInfo('Loggedin to Pega with valid UWA User credentials ')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : underwritingWorksheetLink]))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.click(findTestObject('Object Repository/SubmissionSearch/more_Filters'))

//Navigated to Underwriting Worksheet
KeywordUtil.logInfo('Navigated to Underwriting Worksheet')
WebUI.click(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/input_FieldName', [('fieldName') : 'Multi-LOB Programme ID']))
// Find the test object for the policy reference field on the Pega Case Manager Portal

WebUI.click(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']))
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

WebUI.callTestCase(findTestCase('Test Cases/Worksheets/259399_SubTestCase_Part1'), [('testData') : testData, ('rowNumber') : rowNumber], 
    FailureHandling.STOP_ON_FAILURE)

