/**
 * ============================================================================
 * Test Case ID : 259399
 * Title         : Sub Test Case Part0
 * Folder        : Scripts/Worksheets/259399_SubTestCase_Part0
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

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.testdata.helper.UWWorksheet

import internal.GlobalVariable as GlobalVariable

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText1', [('fieldName') : 'Risk Industry'])), 
    'Funds')

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName1', [('fieldName') : 'Is the Company part of a larger Group?'
            , ('option') : option_Yes]))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Is the Company part of a larger Group?']), 
    'Test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Is the Company part of a larger Group?']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments_Frame4', [('fieldName') : 'Is the Company part of a larger Group?']), 
    'Test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_HyperLink_Frame4', [('index') : 4]))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_EnterLink_Frame4', [('index') : 2]), 'https://hccins.visualstudio.com/Product%20Team%20-%20Financial%20Lines/_search?text=447798&type=workitem&pageSize=25&filters=Projects%7BProduct%20Team%20-%20Financial%20Lines%7D')


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_OK_Span_Frame4', [('fieldName') : 'OK', ('index') : 1]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Save1', [('index') : indexOne]))


WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_FieldText1', [('section') : 'PriceChange'
                , ('fieldName') : 'Currency'])), currencyType)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName1', [('fieldName') : 'Any Abnormality in the share price?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName1', [('fieldName') : 'Any ADR exposure?'
            , ('option') : option_Yes]))


WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_FieldText1', [('section') : 'SNPDataDisplay'
                , ('fieldName') : 'Currency'])), currencyType)

Magnitude = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_FieldText1', [('section') : 'SNPDataDisplay'
            , ('fieldName') : 'Magnitude']))
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName1', [('fieldName') : 'Do you have any comments/concerns about profitability?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName1', [('fieldName') : 'Do you have any comments/concerns about liquidity?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName1', [('fieldName') : 'Do you have any comments/concerns about solvency?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName1', [('fieldName') : 'Any significant M&A in the past 2 years?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName1', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
            , ('option') : option_Yes]))


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_SelectTab', [('section') : 'LOB Specific'
            , ('fieldName') : 'Crime']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_SelectTab', [('section') : 'LOB Specific'
            , ('fieldName') : 'Professional Indemnity']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_SelectTab', [('section') : 'LOB Specific'
            , ('fieldName') : 'Directors & Officers´ Liability']), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_SelectTab', [('section') : 'LOB Specific', ('fieldName') : 'Crime']))


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_SelectTab', [('section') : 'Programme Structure and Authority'
            , ('fieldName') : 'Blended']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_SelectTab', [('section') : 'Programme Structure and Authority'
            , ('fieldName') : 'Crime']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_SelectTab', [('section') : 'Programme Structure and Authority'
            , ('fieldName') : 'Professional Indemnity']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_SelectTab', [('section') : 'Programme Structure and Authority'
            , ('fieldName') : 'Directors & Officers´ Liability']), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_SelectTab', [('section') : 'Programme Structure and Authority'
            , ('fieldName') : 'Directors & Officers´ Liability']))


UWWorksheet.verifyStructureTableHeaderDetails_Iframe4('Expiring Program Structure')
UWWorksheet.verifyStructureDetails_Iframe4('Directors & Officers´ Liability', 'Expiring Program Structure')
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Directors & Officers´ Liability'
            , ('section') : 'Pricing Options', ('button') : 'Copy Expiring PS']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : 'Pricing Options'
            , ('fieldName') : 'Option']), GlobalVariable.timeOutValue)

UWWorksheet.verifyStructureTableHeaderDetails_Iframe4('Pricing Options')

UWWorksheet.verifyStructureDetails_Iframe4('Directors & Officers´ Liability', 'Pricing Options')

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Directors & Officers´ Liability'
            , ('section') : 'Pricing Options', ('fieldName') : 'Underwriter ']), GlobalVariable.timeOutValue)

UWWorksheet.verifyCopyExpiringPSAndCopyPricingOpsButtons('Directors & Officers´ Liability', 'Final Program Structure')

UWWorksheet.verifyStructureTableHeaderDetails_Iframe4('Final Program Structure')

UWWorksheet.verifyStructureDetails_Iframe4('Directors & Officers´ Liability', 'Final Program Structure')

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Directors & Officers´ Liability'
            , ('section') : 'Expiring Program Structure', ('fieldName') : 'Currency']), currencyType, false)


WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Directors & Officers´ Liability'
            , ('section') : 'Expiring Program Structure', ('button') : 'Add item']))


UWWorksheet.enterDataStructureFieldTableDetails('Directors & Officers´ Liability', 'Expiring Program Structure', expiringProgramStructureList, 
    1)


//    1)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Directors & Officers´ Liability'
            , ('section') : 'Expiring Program Structure', ('button') : 'Add item']))


UWWorksheet.enterDataStructureFieldTableDetails('Directors & Officers´ Liability', 'Expiring Program Structure', expiringProgramStructureList1, 
    2)
//    2)

//Pricing Options
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Directors & Officers´ Liability'
            , ('section') : 'Pricing Options', ('fieldName') : 'Currency']), currencyType, false)


WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Directors & Officers´ Liability'
            , ('section') : 'Pricing Options', ('button') : 'Copy Expiring PS']))


UWWorksheet.verifyPricingOptionsStructureDetails('Directors & Officers´ Liability', EPSNewList, 1)
UWWorksheet.verifyPricingOptionsStructureDetails('Directors & Officers´ Liability', EPSNewList1, 2)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Directors & Officers´ Liability'
            , ('fieldName') : 'Within Underwriter´s Authority?', ('option') : option_No]))


WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Directors & Officers´ Liability'
            , ('section') : 'Pricing Options', ('fieldName') : 'UW Authority']), 'Adam Bohle', false)


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Directors & Officers´ Liability'
            , ('fieldName') : 'Authority Approval Method', ('option') : 'Online']))


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Directors & Officers´ Liability'
            , ('fieldName') : 'Referral account? ', ('option') : option_Yes]), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Directors & Officers´ Liability'
            , ('fieldName') : 'Referral account? ', ('option') : option_No]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Directors & Officers´ Liability'
            , ('fieldName') : 'Referral account? ', ('option') : option_Yes]))


WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Directors & Officers´ Liability'
            , ('section') : 'Pricing Options', ('fieldName') : 'FL Manager ']), 'Paul Rayner', false)


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Submit1', [('index') : indexOne]))


WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Directors & Officers´ Liability'
            , ('section') : 'Final Program Structure', ('fieldName') : 'Currency']), currencyType, false)


WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Directors & Officers´ Liability'
            , ('section') : 'Final Program Structure', ('button') : 'Copy Pricing Ops']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_SelectTab', [('section') : 'Programme Structure and Authority'
            , ('fieldName') : 'Crime']))


UWWorksheet.verifyStructureDetails_Iframe4('Crime', 'Expiring Program Structure')

UWWorksheet.verifyStructureTableHeaderDetails_Iframe4('Expiring Program Structure')

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Crime', ('section') : 'Pricing Options'
            , ('button') : 'Copy Expiring PS']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader1', [('section') : 'Pricing Options'
            , ('fieldName') : 'Option']), GlobalVariable.timeOutValue)

UWWorksheet.verifyStructureTableHeaderDetails_Iframe4('Pricing Options')

UWWorksheet.verifyStructureDetails_Iframe4('Crime', 'Pricing Options')

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Crime', ('section') : 'Pricing Options'
            , ('fieldName') : 'Underwriter ']), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName2', [('header') : 'Crime', ('fieldName') : 'Within Underwriter´s Authority?'
            , ('option') : option_Yes]))


UWWorksheet.verifyCopyExpiringPSAndCopyPricingOpsButtons('Crime', 'Final Program Structure')

UWWorksheet.verifyStructureDetails_Iframe4('Crime', 'Final Program Structure')

UWWorksheet.verifyStructureTableHeaderDetails_Iframe4('Final Program Structure')

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown1', [('header') : 'Crime', ('section') : 'Expiring Program Structure'
            , ('fieldName') : 'Currency']), currencyType, false)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Crime', ('section') : 'Expiring Program Structure'
            , ('button') : 'Add item']))


UWWorksheet.enterDataStructureFieldTableDetails('Crime', 'Expiring Program Structure', expiringProgramStructureList, 1)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button1', [('header') : 'Crime', ('section') : 'Expiring Program Structure'
            , ('button') : 'Add item']))


UWWorksheet.enterDataStructureFieldTableDetails('Crime', 'Expiring Program Structure', expiringProgramStructureList1, 2)
UWWorksheet.verifyStructureTableDetails_iframe4('Crime', 'Expiring Program Structure', EPSNewList1, 2)