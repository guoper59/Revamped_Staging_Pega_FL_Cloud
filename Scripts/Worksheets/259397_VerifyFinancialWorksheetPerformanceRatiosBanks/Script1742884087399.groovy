/**
 * ============================================================================
 * Test Case ID : 259397
 * Title         : Verify Financial Worksheet Performance Ratios Banks
 * Folder        : Scripts/Worksheets/259397_VerifyFinancialWorksheetPerformanceRatiosBanks
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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.testdata.helper.UWWorksheet as UWWorksheet
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


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'Overview']), 25)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'UW Worksheet']), 
    GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'History']), 25)

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


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_SPData'))


WebUI.switchToFrame(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/iframe_PegaGadget2Ifr'), GlobalVariable.timeoutShort)


WebUI.verifyTextPresent(status, false)

WebUI.verifyTextPresent('W-', false)

WebUI.verifyTextPresent('M', false)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_CollapseAll'))


for (int i = 1; i <= collapseAllHeaderList.size(); i++) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [('header') : collapseAllHeaderList[
                (i - 1)]]), GlobalVariable.timeOutValue)

    String expanded = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [
                ('header') : collapseAllHeaderList[(i - 1)]]), 'aria-expanded')

    KeywordUtil.logInfo('When user collapsed all then expanded is false')

    WebUI.verifyEqual(expanded, 'false')
}


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_ExpandAll'))


for (int i = 1; i <= collapseAllHeaderList.size(); i++) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [('header') : collapseAllHeaderList[
                (i - 1)]]), GlobalVariable.timeOutValue)

    String expanded = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [
                ('header') : collapseAllHeaderList[(i - 1)]]), 'aria-expanded')

    KeywordUtil.logInfo('When user expanded all then expanded is true')

    WebUI.verifyEqual(expanded, 'true')
}


KeywordUtil.logInfo('Worksheet Details')

String multiLOBID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Programme ID']))

if (multiLOBID.contains(multiLobID)) {
    KeywordUtil.logInfo('MultiLOB MYYXXXXX is present')
}

String WorksheetID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Worksheet ID']))

if (WorksheetID.contains(worksheetID)) {
    KeywordUtil.logInfo('Worksheet ID  W-XXXX is present')
}

String SPCompanyName = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Company Name']))

WebUI.verifyEqual(SPCompanyName, '')

String SPUniqueIdentifier = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Unique Identifier']))

WebUI.verifyEqual(SPUniqueIdentifier, '')

String SPRefreshUser = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Refresh User']))

WebUI.verifyEqual(SPRefreshUser, '')

String SPDataRefreshDate = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Data Refresh Date']))

String[] SPDataRefreshDateOf = SPDataRefreshDate.split(' ')

WebUI.verifyEqual(SPDataRefreshDateOf[0], '')

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

//company information
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Risk Industry'])), 
    riskIndustry)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Is the Company part of a larger Group?'
            , ('option') : option_Yes]))

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']), 
    'Test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']), 
    'Test')


for (int i = 1; i <= companyInformationList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Label', [('fieldName') : companyInformationList[
                (i - 1)]]))
}
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Span', [('fieldName') : 'Risk Industry']))

WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_Save', [('index') : index1]), 25)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Save', [('index') : index1]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Label', [('fieldName') : 'Full Time Employees (actual) (Y)']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Label', [('fieldName') : 'Part-Time Employees (actual) (Y)']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Label', [('fieldName') : 'Local Currency LT']))

for (int i = 1; i <= shareHolderList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_WithHeader_Div1', 
            [('headerName') : 'Top 5 Share Holders', ('fieldName') : shareHolderList[(i - 1)]]))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/dropdown_PriceChangeFY'))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/dropdown_PriceChangeCR'))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any Abnormality in the share price?'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any Abnormality in the share price?'
            , ('option') : option_No]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any ADR exposure?'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any ADR exposure?'
            , ('option') : option_No]))

for (int i = 1; i <= marketInformationList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_InputField', [('fieldName') : marketInformationList[
                (i - 1)]]))
}

for (int i = 1; i <= priceChangeTableHeaderList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_TableHeaderText', [('section') : '.SNPPriceChangeFunding'
                , ('fieldName') : priceChangeTableHeaderList[(i - 1)]]))
}

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/dropdown_PriceChangeFY'), findTestData(testData).getValue(
        'FinancialPricechange', rowNumber), false)


WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/dropdown_PriceChangeCR'), findTestData(testData).getValue(
        'CurrencyPricechange', rowNumber), false)


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any Abnormality in the share price?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any ADR exposure?'
            , ('option') : option_Yes]))

//segment

for (int i = 1; i <= segmentsByLineOfBusinessTableHeaderList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_TableHeaderText', [('section') : '.BusinessSegments'
                , ('fieldName') : segmentsByLineOfBusinessTableHeaderList[(i - 1)]]))
}

for (int i = 1; i <= segmentsByGeographyTableHeaderList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_TableHeaderText', [('section') : '.GeographySegments'
                , ('fieldName') : segmentsByGeographyTableHeaderList[(i - 1)]]))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any exposure larger than 10% of revenue or Assets in high risk countries?'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any exposure larger than 10% of revenue or Assets in high risk countries?'
            , ('option') : option_No]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_Save', [('index') : index2]))

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/dropdown_Magnitude'), findTestData(testData).getValue(
        'Magnitude', rowNumber), false)


//Segments By Line Of Business ( EUR - Millions)
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_AddItem'))


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'SegmentName']), 
    SegmentName)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Operating Income'
            , ('index') : index1]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Operating Income'
            , ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'OperatingIncome']), 
    OperatingIncome)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'OperatingIncome']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
            , ('index') : index1]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
            , ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'TotalAssets']), 
    TotalAssets)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'TotalAssets']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Operating Income/ Operating Income (%)'
            , ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Operating Income/ Operating Income (%)'
            , ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'OperatingIncomePercent']), 
    OperatingIncomePercent)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'OperatingIncomePercent']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)'
            , ('index') : index1]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)'
            , ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)'
	, ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'TotalTaxPercent']), 
    PreTaxProfit)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'TotalTaxPercent']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Assets/ Assets (%)'
            , ('index') : index1]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Assets/ Assets (%)'
            , ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Assets/ Assets (%)'
	, ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'TotalAssetsPercentage']), 
    SegmentAssets)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'TotalAssetsPercentage']), 
    Keys.chord(Keys.TAB))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_AddItem'), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'SegmentName']), 
    SegmentName1)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Operating Income'
            , ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Operating Income'
            , ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Operating Income'
	, ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'OperatingIncome']), 
    OperatingIncome1)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'OperatingIncome']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
            , ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
            , ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
	, ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'TotalAssets']), 
    TotalAssets1)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'TotalAssets']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Operating Income/ Operating Income (%)'
            , ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Operating Income/ Operating Income (%)'
            , ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'OperatingIncomePercent']), 
    OperatingIncomePercent1)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'OperatingIncomePercent']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)'
            , ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)'
            , ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'TotalTaxPercent']), 
    PreTaxProfit1)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'TotalTaxPercent']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Assets/ Assets (%)'
            , ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Assets/ Assets (%)'
            , ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'TotalAssetsPercentage']), 
    SegmentAssets1)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'TotalAssetsPercentage']), 
    Keys.chord(Keys.TAB))


String operatingIncomeTotal = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicTotal', 
        [('headerName') : 'Segments By Line Of Business ( EUR - Millions)', ('fieldName') : 'BSOperatingIncomeTotal']))

KeywordUtil.logInfo(operatingIncomeTotal)

String totalAssetsTotal = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicTotal', [('headerName') : 'Segments By Line Of Business ( EUR - Millions)'
            , ('fieldName') : 'BSTotalAssetsTotal']))

KeywordUtil.logInfo(totalAssetsTotal)

String operatingIncomePercentTotal = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicTotalSegmentFields', 
        [('headerName') : 'Segments By Line Of Business ( EUR - Millions)', ('fieldName') : 'BSFLBanksOperatingIncomePercentTotal']))

KeywordUtil.logInfo(operatingIncomePercentTotal)

String preTaxTotal = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicTotalSegmentFields', 
        [('headerName') : 'Segments By Line Of Business ( EUR - Millions)', ('fieldName') : 'BSFLBanksTotalTaxPercentTotal']))

KeywordUtil.logInfo(preTaxTotal)

String segmentAssetsTotal = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicTotalSegmentFields', 
        [('headerName') : 'Segments By Line Of Business ( EUR - Millions)', ('fieldName') : 'BSFLBanksTotalAssetsPercentageTotal']))

KeywordUtil.logInfo(segmentAssetsTotal)

WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Geography', ('button') : addItem_Button]), 25, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Geography', ('button') : addItem_Button]), FailureHandling.OPTIONAL)

//
WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'SegmentName']), 
    SegmentName)


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
	, ('fieldName') : 'Operating Income', ('index') : index1]), 25)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Operating Income', ('index') : index1]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Operating Income', ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'OperatingIncome']), 
    OperatingIncome)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'OperatingIncome']), 
    Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
	, ('fieldName') : 'Total Assets', ('index') : index1]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Total Assets', ('index') : index1]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Total Assets', ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'TotalAssets']), 
    TotalAssets)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'TotalAssets']), 
    Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
	, ('fieldName') : 'Segment Operating Income/ Operating Income (%)', ('index') : index1]), 25, FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Segment Operating Income/ Operating Income (%)', ('index') : index1]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Segment Operating Income/ Operating Income (%)', ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'OperatingIncomePercent']), 
    OperatingIncomePercent)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'OperatingIncomePercent']), 
    Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
	, ('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)', ('index') : index1]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)', ('index') : index1]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
	, ('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)', ('index') : index1]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
	, ('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)', ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'TotalTaxPercent']), 
    PreTaxProfit)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'TotalTaxPercent']), 
    Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
	, ('fieldName') : 'Segment Assets/ Assets (%)', ('index') : index1]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Segment Assets/ Assets (%)', ('index') : index1]), FailureHandling.OPTIONAL)
WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Segment Assets/ Assets (%)', ('index') : index1]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
	, ('fieldName') : 'Segment Assets/ Assets (%)', ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'TotalAssetsPercentage']), 
    SegmentAssets)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'TotalAssetsPercentage']), 
    Keys.chord(Keys.TAB))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Geography', ('button') : addItem_Button]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'SegmentName']), 
    SegmentName1)


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
			, ('fieldName') : 'Operating Income', ('index') : index2]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Operating Income', ('index') : index2]), FailureHandling.OPTIONAL)
WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Operating Income', ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'OperatingIncome']), 
    OperatingIncome1)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'OperatingIncome']), 
    Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
	, ('fieldName') : 'Total Assets', ('index') : index2]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Total Assets', ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Total Assets', ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'TotalAssets']), 
    TotalAssets1)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'TotalAssets']), 
    Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
	, ('fieldName') : 'Segment Operating Income/ Operating Income (%)', ('index') : index2]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Segment Operating Income/ Operating Income (%)', ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Segment Operating Income/ Operating Income (%)', ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'OperatingIncomePercent']), 
    OperatingIncomePercent1)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'OperatingIncomePercent']), 
    Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
	, ('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)', ('index') : index2]), 25, FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)', ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)', ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
	, ('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)', ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'TotalTaxPercent']), 
    PreTaxProfit1)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'TotalTaxPercent']), 
    Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
	, ('fieldName') : 'Segment Assets/ Assets (%)', ('index') : index2]), 25, FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Segment Assets/ Assets (%)', ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Segments By Geography ( EUR - Millions)'
            , ('fieldName') : 'Segment Assets/ Assets (%)', ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'TotalAssetsPercentage']), 
    SegmentAssets1)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'TotalAssetsPercentage']), 
    Keys.chord(Keys.TAB))


String operatingIncomeTotalNew = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicTotal', 
        [('headerName') : 'Segments By Line Of Business ( EUR - Millions)', ('fieldName') : 'BSOperatingIncomeTotal']))

KeywordUtil.logInfo('Operating Total Income Displayed Is :: ' + operatingIncomeTotalNew)

String totalAssetsTotalNew = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicTotal', [
            ('headerName') : 'Segments By Line Of Business ( EUR - Millions)', ('fieldName') : 'BSTotalAssetsTotal']))

KeywordUtil.logInfo('Total Assets Value Displayed Is :: ' + totalAssetsTotalNew)

String operatingIncomePercentTotalNew = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicTotalSegmentFields', 
        [('headerName') : 'Segments By Line Of Business ( EUR - Millions)', ('fieldName') : 'BSFLBanksOperatingIncomePercentTotal']))

KeywordUtil.logInfo('Total Operating Income Value Displayed Is :: ' + operatingIncomePercentTotalNew)

String preTaxTotalNew = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicTotalSegmentFields', 
        [('headerName') : 'Segments By Line Of Business ( EUR - Millions)', ('fieldName') : 'BSFLBanksTotalTaxPercentTotal']))

KeywordUtil.logInfo('Total Pre Tax Value Displayed Is :: ' + preTaxTotalNew)

String segmentAssetsTotalNew = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicTotalSegmentFields', 
        [('headerName') : 'Segments By Line Of Business ( EUR - Millions)', ('fieldName') : 'BSFLBanksTotalAssetsPercentageTotal']))

KeywordUtil.logInfo('Total Segment Assets Value Displayed Is :: ' + segmentAssetsTotalNew)

WebUI.callTestCase(findTestCase('Test Cases/Worksheets/259397_SubTestCase_Part1'), null)

WebUI.callTestCase(findTestCase('Test Cases/Worksheets/259397_SubTestCase_Part2'), null)