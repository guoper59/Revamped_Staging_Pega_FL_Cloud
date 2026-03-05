/**
 * ============================================================================
 * Test Case ID : 262187
 * Title         : Verify Financial Worksheet Approvalthrough Onlineandwith S Pconnect
 * Folder        : Scripts/Worksheets/262187_VerifyFinancialWorksheetApprovalthroughOnlineandwithSPconnect
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

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.testdata.helper.UWWorksheet

import internal.GlobalVariable as GlobalVariable

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

KeywordUtil.logInfo(GlobalVariable.testCaseID)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))

KeywordUtil.logInfo('Creating a Submission')


String insuredName = UWWorksheet.createFinancialSubmission(testData, rowNumber)


GlobalVariable.insuredName = insuredName
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)

GlobalVariable.PolicyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

KeywordUtil.logInfo(GlobalVariable.PolicyRef)

//Click on the 'OK' element on the page.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))


String caseID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/link_UWWorkSheetStage'))

WebUI.click(findTestObject('Object Repository/UWWorksheet/link_UWWorkSheetStage'))


WebUI.switchToFrame(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/iframe_PegaGadget2Ifr'), GlobalVariable.timeoutShort)


WebUI.verifyTextPresent(status, false)

WebUI.verifyTextPresent('W-', false)

WebUI.switchToDefaultContent()


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'Overview']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'UW Worksheet']), 
    GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'History']), GlobalVariable.timeOutValue)

WebUI.waitForElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']))


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/toolTip_InsuredName'), GlobalVariable.timeOutValue)

WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'S&P Unique Identifier']), 
        'value'), '')

WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'City']), 
        'value'), '')

WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'Country']), 
        'value'), '')


WebUI.clearText(findTestObject('Object Repository/UWWorksheet/input_InsuredName'))


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_InsuredName'), 'Royal Bank of Canada')


WebUI.clearText(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'S&P Unique Identifier']))


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'S&P Unique Identifier']), 
    '109809')


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Search'))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Select'))


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelected', [('fieldName') : 'Index for Price Change Comparison'
            , ('selected') : 'S&P Euro 350']), GlobalVariable.timeOutValue)


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelectedText', [('fieldName') : 'Currency'
            , ('selected') : 'Canadian Dollar']), GlobalVariable.timeOutValue)


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelectedText', [('fieldName') : 'Magnitude'
            , ('selected') : 'Millions']), GlobalVariable.timeOutValue)


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Connect'))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_CollapseAll1'), 60)
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_CollapseAll1'))


for (int i = 1; i <= collapseAllHeaderList.size(); i++) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [('header') : collapseAllHeaderList[
                (i - 1)]]), GlobalVariable.timeOutValue)

    String expanded = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [
                ('header') : collapseAllHeaderList[(i - 1)]]), 'aria-expanded')

    KeywordUtil.logInfo('When user collapsed all then expanded is false')

    WebUI.verifyEqual(expanded, 'false')
}


WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_ExpandAll1'))


for (int i = 1; i <= collapseAllHeaderList.size(); i++) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [('header') : collapseAllHeaderList[
                (i - 1)]]), GlobalVariable.timeOutValue)

    String expanded = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [
                ('header') : collapseAllHeaderList[(i - 1)]]), 'aria-expanded')

    KeywordUtil.logInfo('When user expanded all then expanded is true')

    WebUI.verifyEqual(expanded, 'true')
}


WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Insured Name'])), 
    insuredName)

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'NAIC Division'])), 
    findTestData(testData).getValue('NAIC Division', rowNumber))

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'NAIC Description'])), 
    findTestData(testData).getValue('NAIC Description', rowNumber))

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Country'])), 
    findTestData(testData).getValue('Country', rowNumber))

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Public/Private'])), 
    findTestData(testData).getValue('Public/Private', rowNumber))

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Policy Reference'])), 
    GlobalVariable.PolicyRef)

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Broker'])), 
    findTestData(testData).getValue('Broker', rowNumber))

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Broker Contact'])), 
    findTestData(testData).getValue('Broker Contact', rowNumber))

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Underwriter'])), 
    findTestData(testData).getValue('Underwriter', rowNumber))

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Placing Type'])), 
    findTestData(testData).getValue('Placing Type', rowNumber))

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Reinsured'])), 
    reinsured)

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Major Class'])), 
    majorClass)

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Minor Class'])), 
    findTestData(testData).getValue('Minor Class', rowNumber))

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Effective Date'])), 
    findTestData(testData).getValue('Inception Date', rowNumber))

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnText', [('fieldName') : 'Expiration Date'])), 
    date)

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Entity'])), 
    entity)

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Legal Branch'])), 
    findTestData(testData).getValue('Legal Branch', rowNumber))

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Submission Status'])), 
    submissionStatus)

String yearEstablished = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'Year Established']), 
    'value')


WebUI.verifyEqual(yearEstablished, '1864')

String shortCompanyDecsription = WebUI.getText(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Short company description']))

if (shortCompanyDecsription.contains(companyDescription)) {
    KeywordUtil.logInfo('Correct Company Description is present')
}


for (int i = 1; i < 4; i++) {
    String currencyValue = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Currency']))


    WebUI.verifyEqual(currencyValue, 'CAD')
}

for (int i = 1; i < 3; i++) {
    String magnitudeValue = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Magnitude']))


    WebUI.verifyEqual(magnitudeValue, 'Millions')
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any Abnormality in the share price?'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any Abnormality in the share price?'
            , ('option') : option_No]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any ADR exposure?'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any ADR exposure?'
            , ('option') : option_No]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any Abnormality in the share price?'
            , ('option') : option_Yes]))
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any ADR exposure?'
            , ('option') : option_Yes]))
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any exposure larger than 10% of revenue or Assets in high risk countries?'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any exposure larger than 10% of revenue or Assets in high risk countries?'
            , ('option') : option_No]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any exposure larger than 10% of revenue or Assets in high risk countries?'
            , ('option') : option_Yes]))

WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about profitability?'
            , ('option') : option_Yes]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about profitability?'
            , ('option') : option_Yes]))


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about liquidity?'
            , ('option') : option_Yes]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about liquidity?'
            , ('option') : option_Yes]))


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about solvency?'
            , ('option') : option_Yes]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about solvency?'
            , ('option') : option_Yes]))
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any significant M&A in the past 2 years?'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any significant M&A in the past 2 years?'
            , ('option') : option_No]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any significant M&A in the past 2 years?'
            , ('option') : option_Yes]))
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
            , ('option') : option_No]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
            , ('option') : option_Yes]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
	, ('option') : option_Yes]))


//LOB Specific
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Professional Indemnity'
            , ('index') : '1']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Crime'
            , ('index') : '1']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Directors & Officers´ Liability'
            , ('index') : '1']))

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Crime', ('headerName') : 'LOB Specific']))


WebUI.switchToFrame(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/iframe_PegaGadget2Ifr'), GlobalVariable.timeoutShort)
WebUI.verifyTextPresent('The LOB Specific Section is not applicable for this Major Class.', false)

WebUI.switchToDefaultContent()


WebUI.enhancedClick(findTestObject('Object Repository/UWWorksheet/radioButton_DynamicLabelWithIndexTabName', [('labelName') : 'Section Not Applicable'
            , ('tabName') : 'Crime', ('index') : 1]))


WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : 'This action will reveal the fields of this section. Click Continue to proceed.']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_Continue'))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Continue'))


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Crime'
            , ('headerName') : 'LOB Specific']), GlobalVariable.timeOutValue)


if (WebUI.verifyElementChecked(findTestObject('Object Repository/UWWorksheet/radioButton_DynamicLabelWithIndexTabName', 
        [('labelName') : 'Section Not Applicable', ('tabName') : 'Crime', ('index') : 1]), GlobalVariable.timeoutShort)) {
    WebUI.enhancedClick(findTestObject('Object Repository/UWWorksheet/radioButton_DynamicLabelWithIndexTabName', [('labelName') : 'Section Not Applicable'
                , ('tabName') : 'Crime', ('index') : 1]))


    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : 'This action will reveal the fields of this section. Click Continue to proceed.']))

    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_Continue'))

    WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Continue'))
}


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Blended'
            , ('headerName') : 'Programme Structure and Authority']), GlobalVariable.timeOutValue)


for (int i = 1; i <= crimeSectionRowList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLabelLOBSpecific', [('labelName') : crimeSectionRowList[
                (i - 1)]]))

    KeywordUtil.logInfo(crimeSectionRowList[(i - 1)])

}

//Program Structure and Authority
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Blended'
            , ('headerName') : 'Programme Structure and Authority']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Directors & Officers´ Liability'
            , ('headerName') : 'Programme Structure and Authority']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Crime'
            , ('headerName') : 'Programme Structure and Authority']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Professional Indemnity'
            , ('headerName') : 'Programme Structure and Authority']))


//h2/div[text()='LOB Specific']//ancestor::div[@class='collapsible  Expanded ']//following-sibling::div[@id='EXPAND-INNERDIV']//div[@aria-label='Professional Indemnity']
WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Directors & Officers´ Liability'
            , ('headerName') : 'Programme Structure and Authority']))
WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_DirectorsLiabilityProgramStr'))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 1]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 1]))


for (int i = 1; i <= expiringProgramStructureHeaderList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : expiringProgramStructureHeaderList[
                (i - 1)]]))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring'
            , ('button') : delete_Button]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring'
            , ('button') : addItem_Button]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName', [('headerName') : 'Pricing Options'
            , ('buttonText') : 'Copy Expiring PS']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Pricing'
            , ('button') : delete_Button]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Pricing'
            , ('button') : addItem_Button]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 2]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName', [('headerName') : 'Final Program Structure'
            , ('buttonText') : 'Copy Expiring PS']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName', [('headerName') : 'Final Program Structure'
            , ('buttonText') : 'Copy Pricing Ops']))

for (int i = 1; i <= finalProgramStructureHeaderList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : finalProgramStructureHeaderList[
                (i - 1)]]))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Final', ('button') : delete_Button]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Final', ('button') : addItem_Button]))

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 3]), 
    'EUR', false)


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : addItem_Button]), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : addItem_Button]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : addItem_Button]))


WebUI.callTestCase(findTestCase('Test Cases/Worksheets/262187_SubTestCase_Part1'), [('testData') : testData, ('rowNumber') : rowNumber], 
    FailureHandling.STOP_ON_FAILURE)