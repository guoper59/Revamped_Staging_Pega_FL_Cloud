/**
 * ============================================================================
 * Test Case ID : 262184
 * Title         : Verify Worksheetdetailscollapsibleheaderwithoutconnectingto SP Company
 * Folder        : Scripts/Worksheets/262184_VerifyWorksheetdetailscollapsibleheaderwithoutconnectingtoSPCompany
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
import com.kms.katalon.core.testobject.TestObject

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

KeywordUtil.logInfo(GlobalVariable.testCaseID)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))

KeywordUtil.logInfo('Creating a Submission')

String insuredName = UWWorksheet.createSubmissionForWorkSheet(testData, rowNumber)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)

GlobalVariable.PolicyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

KeywordUtil.logInfo(GlobalVariable.PolicyRef)

//Click on the 'OK' element on the page.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))


String caseID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/link_UWWorkSheetStage'))

UWWorksheet.verifyUIFields(insuredName, status, collapseAllHeaderList)

UWWorksheet.verifyUIdetails(insuredName, testData, rowNumber)

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Reinsured'])), 
    reinsured)

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Major Class'])), 
    majorClass)

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnText', [('fieldName') : 'Expiration Date'])), 
    date)

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Entity'])), 
    entity)

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Submission Status'])), 
    submissionStatus)

//company information
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Risk Industry'])), 
    riskIndustry)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Is the Company part of a larger Group?'
            , ('option') : option_Yes]))


//price change
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

for (int i = 1; i <= segmentsOthersTableHeaderList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_TableHeaderText', [('section') : '.OtherSegments'
                , ('fieldName') : segmentsOthersTableHeaderList[(i - 1)]]))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any exposure larger than 10% of revenue or Assets in high risk countries?'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any exposure larger than 10% of revenue or Assets in high risk countries?'
            , ('option') : option_No]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_Save', [('index') : index2]))

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/dropdown_Magnitude'), findTestData(testData).getValue(
        'Magnitude', rowNumber), false)


//Segments By Line Of Business ( EUR - Millions)
WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_AddItem'), 25)
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_AddItem'))

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'SegmentName']))
WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'SegmentName']), 
    findTestData(testData).getValue('SegmentName1', rowNumber))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'OperatingIncome']))
WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'OperatingIncome']), 
    findTestData(testData).getValue('OperatingIncome1', rowNumber))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'OperatingIncome']), 
    Keys.chord(Keys.TAB))

WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
	, ('index') : index1]), 25, FailureHandling.OPTIONAL)

WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
	, ('index') : index1]), 25, FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
            , ('index') : index1]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
	, ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'TotalAssets']), 
    findTestData(testData).getValue('TotalAssets1', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'TotalAssets']), 
    Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Revenue'
	, ('index') : index1]), 25)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Revenue'
            , ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Revenue'
	, ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'RevenueIncome']), 
    findTestData(testData).getValue('RevenueIncome1', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'RevenueIncome']), 
  Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'EBITDA', ('index') : index1]), 25)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'EBITDA', ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'EBITDA', ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'EBITDA']), 
    findTestData(testData).getValue('EBITDA1', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'EBITDA']), Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income', ('index') : index1]), 25, FailureHandling.OPTIONAL)
WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income', ('index') : index1]), FailureHandling.OPTIONAL)
WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income'
            , ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'NetIncome']), 
    findTestData(testData).getValue('NetIncome1', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName', [('SegmentTextField') : 'NetIncome']), 
    Keys.chord(Keys.TAB))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'BusinessSegments', ('button') : addItem_Button]), FailureHandling.OPTIONAL)

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'MergersNAcquisitions'
            , ('button') : delete_Button]))


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'SegmentName']), 
    businessSegmentList2[0])


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'OperatingIncome']), 
    businessSegmentList2[1])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'OperatingIncome']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
            , ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
            , ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'TotalAssets']), 
    businessSegmentList2[2])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'TotalAssets']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Revenue'
            , ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Revenue'
            , ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'RevenueIncome']), 
    businessSegmentList2[3])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'RevenueIncome']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'EBITDA', ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'EBITDA', ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'EBITDA']), 
    businessSegmentList2[4])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'EBITDA']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income'
            , ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Net Income'
	, ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'NetIncome']))
WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'NetIncome']), 
    businessSegmentList2[5])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_BusinessSegmentFieldName1', [('SegmentTextField') : 'NetIncome']), 
    Keys.chord(Keys.TAB))


//Segments - Others ( EUR - Millions)
WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'OtherSegments'
            , ('button') : addItem_Button]), GlobalVariable.timeoutShort, FailureHandling.OPTIONAL)

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'OtherSegments'
            , ('button') : delete_Button]), FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'OtherSegments', ('button') : addItem_Button]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName', [('SegmentTextField') : 'SegmentName']), 
    otherSegmentList[0])


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName', [('SegmentTextField') : 'ReportedRevenue']), 
    otherSegmentList[1])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName', [('SegmentTextField') : 'ReportedRevenue']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
            , ('index') : index3]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
            , ('index') : index3]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName', [('SegmentTextField') : 'TotalAssets']), 
    otherSegmentList[2])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName', [('SegmentTextField') : 'TotalAssets']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Revenue / Total Revenue (%)'
            , ('index') : index1]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Revenue / Total Revenue (%)'
            , ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName', [('SegmentTextField') : 'TotalRevenuePercentage']), 
    otherSegmentList[3])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName', [('SegmentTextField') : 'TotalRevenuePercentage']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)'
            , ('index') : index1]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)'
            , ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName', [('SegmentTextField') : 'Pretaxpercentage']), 
    otherSegmentList[4])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName', [('SegmentTextField') : 'Pretaxpercentage']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Assets/ Assets (%)'
            , ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Assets/ Assets (%)'
            , ('index') : index1]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName', [('SegmentTextField') : 'AssetPercentage']), 
    otherSegmentList[5])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName', [('SegmentTextField') : 'AssetPercentage']), 
    Keys.chord(Keys.TAB))


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'OtherSegments'
            , ('button') : addItem_Button]), GlobalVariable.timeoutShort, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'OtherSegments', ('button') : addItem_Button]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName1', [('SegmentTextField') : 'SegmentName']), 
    otherSegmentList2[0])


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName1', [('SegmentTextField') : 'ReportedRevenue']), 
    otherSegmentList2[1])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName1', [('SegmentTextField') : 'ReportedRevenue']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
            , ('index') : '4']), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Total Assets'
            , ('index') : '4']), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName1', [('SegmentTextField') : 'TotalAssets']), 
    otherSegmentList2[2])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName1', [('SegmentTextField') : 'TotalAssets']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Revenue / Total Revenue (%)'
            , ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Revenue / Total Revenue (%)'
            , ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName1', [('SegmentTextField') : 'TotalRevenuePercentage']), 
    otherSegmentList2[3])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName1', [('SegmentTextField') : 'TotalRevenuePercentage']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)'
            , ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Pre-tax Profit/ Pre-tax Profit (%)'
            , ('index') : index2]), FailureHandling.OPTIONAL)


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName1', [('SegmentTextField') : 'Pretaxpercentage']), 
    otherSegmentList2[4])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName1', [('SegmentTextField') : 'Pretaxpercentage']), 
    Keys.chord(Keys.TAB))


WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Assets/ Assets (%)'
            , ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_TableFieldName', [('fieldName') : 'Segment Assets/ Assets (%)'
	, ('index') : index2]), FailureHandling.OPTIONAL)

WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName1', [('SegmentTextField') : 'AssetPercentage']), 
    otherSegmentList2[5])

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_OtherSegmentFieldName1', [('SegmentTextField') : 'AssetPercentage']), 
    Keys.chord(Keys.TAB))


WebUI.check(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any exposure larger than 10% of revenue or Assets in high risk countries?'
            , ('option') : option_Yes]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Save', [('index') : index1]), FailureHandling.OPTIONAL)


UWWorksheet.enterData2022And23Table(keyFuturesYear2022List, keyFuturesYear2023List)

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : index3]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Magnitude', ('index') : index2]))

//Key Figures
for (int i = 1; i <= keyFiguresList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/text_FieldName', [('fieldName') : keyFiguresList[
                (i - 1)]]))
}

//Profitability
for (int i = 1; i <= profitabilityTableList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/text_FieldName', [('fieldName') : profitabilityTableList[
                (i - 1)]]))
}

//Liquidity
for (int i = 1; i <= liquidityList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/text_FieldName', [('fieldName') : liquidityList[
                (i - 1)]]))
}

//Solvency
for (int i = 1; i <= solvency.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/text_FieldName', [('fieldName') : solvency[
                (i - 1)]]))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about profitability?'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about profitability?'
            , ('option') : option_No]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about liquidity?'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about liquidity?'
            , ('option') : option_No]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about solvency?'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about solvency?'
            , ('option') : option_No]))

//Year-to-Date
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Close Date'
            , ('index') : index1]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Year', ('index') : index1]))

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Close Date', ('index') : index1]), 
    '3 Months', false)


WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Year', ('index') : index1]), 
    '2023', false)


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about profitability?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about liquidity?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about solvency?'
            , ('option') : option_Yes]))

for (int i = 1; i <= keyFuturesYear2022List.size(); i++) {
	WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_YearField', [('year') : '3 Months 2022', ('index') : i]), 25)
	
    WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_YearField', [('year') : '3 Months 2022', ('index') : i]))
	
    WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_YearField', [('year') : '3 Months 2022', ('index') : i]))
	
	WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_YearField', [('year') : '3 Months 2022', ('index') : i]), FailureHandling.OPTIONAL)
	

    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_KeyFetures', [('year') : '3 Months 2022', ('index') : i
                , ('yearType') : 'Fourth']), keyFuturesYear2022List[(i - 1)])

   WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_KeyFetures', [('year') : '3 Months 2022', ('index') : i
                , ('yearType') : 'Fourth']), Keys.chord(Keys.TAB))

    WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_KeyFetures', [('year') : '3 Months 2023', ('index') : i
                , ('yearType') : 'Fifth']), Keys.chord(Keys.TAB))
}

for (int i = 1; i <= keyFuturesYear2023List.size(); i++) {

	WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_YearField', [('year') : '3 Months 2023', ('index') : i]),25)
	WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_YearField', [('year') : '3 Months 2023', ('index') : i]),25)
	
    WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_YearField', [('year') : '3 Months 2023', ('index') : i]))

    WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_YearField', [('year') : '3 Months 2023', ('index') : i]))

	WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_YearField', [('year') : '3 Months 2023', ('index') : i]), FailureHandling.OPTIONAL)
	

    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_KeyFetures', [('year') : '3 Months 2023', ('index') : i
                , ('yearType') : 'Fifth']), keyFuturesYear2023List[(i - 1)])

    WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_KeyFetures', [('year') : '3 Months 2023', ('index') : i
                , ('yearType') : 'Fifth']), Keys.chord(Keys.TAB))
}


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/button_CalculateRatios'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_CalculateRatios'))


//M&A
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : '4']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Magnitude', ('index') : index3]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any significant M&A in the past 2 years?'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any significant M&A in the past 2 years?'
            , ('option') : option_No]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'MergersNAcquisitions'
            , ('button') : addItem_Button]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'MergersNAcquisitions'
            , ('button') : delete_Button]))

for (int i = 1; i <= MATableHeaderList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_TableHeaderText', [('section') : '.MergersNAcquisitions'
                , ('fieldName') : MATableHeaderList[(i - 1)]]))
}

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any significant M&A in the past 2 years?'
            , ('option') : option_Yes]))

//Corporate Governance
//Position
for (int i = 1; i <= positionList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/text_FieldName', [('fieldName') : positionList[
                (i - 1)]]))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'CorporateGovernance'
            , ('button') : addItem_Button]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'CorporateGovernance'
            , ('button') : delete_Button]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
            , ('option') : option_No]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
            , ('option') : option_Yes]))

WebUI.callTestCase(findTestCase('Test Cases/Worksheets/262184_VerifyWorksheetdetailscollapsibleheaderwithoutconnectingtoSPCompany_Part1'), [('testData') : testData, ('rowNumber') : rowNumber], 
    FailureHandling.STOP_ON_FAILURE)