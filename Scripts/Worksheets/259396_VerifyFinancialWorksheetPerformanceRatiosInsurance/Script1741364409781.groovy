/**
 * ============================================================================
 * Test Case ID : 259396
 * Title         : Verify Financial Worksheet Performance Ratios Insurance
 * Folder        : Scripts/Worksheets/259396_VerifyFinancialWorksheetPerformanceRatiosInsurance
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
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'), 60)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))

WebUI.waitForElementVisible(findTestObject('Object Repository/UWWorksheet/link_UWWorkSheetStage'), 60)
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



WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'S&P Unique Identifier']), 
        'value'), '')

WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'City']), 
        'value'), '')

WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'Country']), 
        'value'), '')


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_SPData'))


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


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Is the Company part of a larger Group?'
	, ('option') : option_Yes]), 25)

WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Is the Company part of a larger Group?'
	, ('option') : option_Yes]), 25)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Is the Company part of a larger Group?'
            , ('option') : option_Yes]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']), 
    'Test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']), 
    'Test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_HyperLink', [('index') : 4]))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_EnterLink', [('index') : 2]), 'https://hccins.visualstudio.com/Product%20Team%20-%20Financial%20Lines/_search?text=447798&type=workitem&pageSize=25&filters=Projects%7BProduct%20Team%20-%20Financial%20Lines%7D')

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_OK_Span', [('fieldName') : 'OK', ('index') : 1]))

for (int i = 1; i <= companyInformationList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Label', [('fieldName') : companyInformationList[
                (i - 1)]]))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Span', [('fieldName') : 'Risk Industry']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Label', [('fieldName') : 'Full Time Employees (actual) (Y)']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Label', [('fieldName') : 'Part-Time Employees (actual) (Y)']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Label', [('fieldName') : 'Local Currency LT']))

for (int i = 1; i <= shareHolderList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_WithHeader_Div1', 
            [('headerName') : 'Top 5 Share Holders', ('fieldName') : shareHolderList[(i - 1)]]))
}

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Save', [('index') : index1]))

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
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_AddItem'), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'SegmentName']), 
    SegmentName)


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income', ('index') : index1]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income'
            , ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income'
			, ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'NetIncome']), 
    NetIncome)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'NetIncome']), 
    Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Revenues', ('index') : index1]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Revenues', ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Revenues', ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'Premiums']), 
    revenues)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'Premiums']), 
    Keys.chord(Keys.TAB))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'BusinessSegments', ('button') : addItem_Button]), FailureHandling.OPTIONAL)

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'MergersNAcquisitions'
            , ('button') : delete_Button]))


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'SegmentName']), 
    SegmentName1)


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income', ('index') : index2]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income'
            , ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income'
			, ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'NetIncome']), 
    NetIncome1)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'NetIncome']), 
    Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Revenues', ('index') : index2]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Revenues', ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Revenues', ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'Premiums']), 
    revenues1)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'Premiums']), 
    Keys.chord(Keys.TAB))


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'GeographySegments'
            , ('button') : addItem_Button]), GlobalVariable.timeoutShort)

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'GeographySegments'
            , ('button') : delete_Button]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'GeographySegments', ('button') : addItem_Button]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'SegmentName']), 
    SegmentName2)


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income', ('index') : index3]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income'
            , ('index') : index3]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income'
			, ('index') : index3]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'NetIncome']), 
    NetIncome2)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'NetIncome']), 
    Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Revenues', ('index') : index3]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Revenues', ('index') : index3]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Revenues', ('index') : index3]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'Premiums']), 
    revenues2)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName', [('SegmentTextField') : 'Premiums']), 
    Keys.chord(Keys.TAB))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'GeographySegments', ('button') : addItem_Button]))


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'SegmentName']), 
    SegmentName3)


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income', ('index') : index4]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income'
            , ('index') : index4]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income'
			, ('index') : index4]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'NetIncome']), 
    NetIncome3)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'NetIncome']), 
    Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Revenues', ('index') : index4]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Revenues', ('index') : index4]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Revenues', ('index') : index4]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'Premiums']), 
    revenues3)

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_GeographySegmentFieldName1', [('SegmentTextField') : 'Premiums']), 
    Keys.chord(Keys.TAB))


WebUI.check(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any exposure larger than 10% of revenue or Assets in high risk countries?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Save', [('index') : index1]), FailureHandling.OPTIONAL)


//Key Financials
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : index3]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Magnitude', ('index') : index2]))

//Key Financials
for (int i = 1; i <= keyFinancialsList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/text_FieldName', [('fieldName') : keyFinancialsList[
                (i - 1)]]))
}


for (int i = 1; i < 4; i++) {
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' +
		i, ('headerName') : 'FY2022']), 25, FailureHandling.OPTIONAL)
    WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' + 
                i, ('headerName') : 'FY2022']), FailureHandling.OPTIONAL)


	    WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' + 
                i, ('headerName') : 'FY2022']), FailureHandling.OPTIONAL)

	WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' +
		i, ('headerName') : 'FY2022']), FailureHandling.OPTIONAL)
	WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' +
		i, ('headerName') : 'FY2022']), FailureHandling.OPTIONAL)
	
    WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('KeyFinancialsData$l' + 
                i) + '$pSecondYearValue']), keyFinancialInputDataListYear2022[(i - 1)])

    WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('KeyFinancialsData$l' + 
                i) + '$pSecondYearValue']), Keys.chord(Keys.TAB))

}

for (int i = 1; i < 4; i++) {
	WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' +
		i, ('headerName') : 'FY2023']), 25)

    WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' + 
                i, ('headerName') : 'FY2023']), FailureHandling.OPTIONAL)
	
	

    WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' + 
                i, ('headerName') : 'FY2023']), FailureHandling.OPTIONAL)

	WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' +
		i, ('headerName') : 'FY2023']), FailureHandling.OPTIONAL)

	
    WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('KeyFinancialsData$l' + 
                i) + '$pThirdYearValue']), keyFinancialInputDataListYear2023[(i - 1)])

    WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('KeyFinancialsData$l' + 
                i) + '$pThirdYearValue']), Keys.chord(Keys.TAB))

}

//Performance Ratios Section
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : index4]))

//Performance Ratios List
for (int i = 1; i <= performanceRatiosList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/text_FieldName', [('fieldName') : performanceRatiosList[
                (i - 1)]]))
}


WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Close Date'
            , ('index') : index2]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Year', ('index') : index2]))


WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Close Date', ('index') : index1]), 
    '3 Months', false)


WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Year', ('index') : index1]), 
    '2023', false)


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


//M&A Section
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 5]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Magnitude', ('index') : 3]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any significant M&A in the past 2 years?'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any significant M&A in the past 2 years?'
            , ('option') : option_No]))


for (int i = 1; i <= acquisitionsHeaderList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_WithHeader_Div1', 
            [('headerName') : 'M&A/ Acquisitions/ Sales/ Divestitures ( EUR - Millions)', ('fieldName') : acquisitionsHeaderList[
                (i - 1)]]))
}


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any significant M&A in the past 2 years?'
            , ('option') : option_Yes]))


//Corporate Govt Sections
for (int i = 1; i <= corporateGovernanceHeaderList.size(); i++) {
	WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : corporateGovernanceHeaderList[
		(i - 1)]]), 25)
	
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : corporateGovernanceHeaderList[
                (i - 1)]]))
}

for (int i = 1; i <= corporateGovernanceRowList.size(); i++) {
	WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Span', [('fieldName') : corporateGovernanceRowList[
		(i - 1)]]), 25)
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Span', [('fieldName') : corporateGovernanceRowList[
                (i - 1)]]))
}


WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
            , ('option') : option_No]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
            , ('option') : option_Yes]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_OtherActions'))

WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/webElement_OtherActionsOption', [('optionToSelect') : 'Navigate To']))

WebUI.waitForElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_OtherActionsOption', [('optionToSelect') : 'S&P Company Search']), 
    GlobalVariable.timeoutShort)

WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/webElement_OtherActionsOption', [('optionToSelect') : 'S&P Company Search']))

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_OtherActionsOption', [('optionToSelect') : 'S&P Company Search']))


WebUI.clearText(findTestObject('Object Repository/UWWorksheet/input_InsuredName'))


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_InsuredName'), 'AXA SA')


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Search'))


for (int i = 1; i < 5; i++) {
    String uniqueIdentifierUI = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_UniqueIdentifier', 
            [('index') : i]))


    WebUI.verifyEqual(uniqueIdentifierUI, uniqueIdentifierList[(i - 1)])
}

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Select'))


WebUI.callTestCase(findTestCase('Test Cases/Worksheets/259396_SubTestCase_Part1'), [('testData') : testData, ('rowNumber') : rowNumber], 
    FailureHandling.STOP_ON_FAILURE)