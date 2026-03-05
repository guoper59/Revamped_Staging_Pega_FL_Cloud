/**
 * ============================================================================
 * Test Case ID : 259398
 * Title         : Verify Commercial Worksheet Additional Authority
 * Folder        : Scripts/Worksheets/259398_VerifyCommercialWorksheetAdditionalAuthority
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

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.testdata.helper.UWWorksheet

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

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


WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_InsuredName'), 'Bayer')


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Search'))


for (int i = 1; i < 5; i++) {
    String uniqueIdentifierUI = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_UniqueIdentifier', 
            [('index') : i]))


    WebUI.verifyEqual(uniqueIdentifierUI, uniqueIdentifierList[(i - 1)])
	KeywordUtil.logInfo(uniqueIdentifierUI)
	KeywordUtil.logInfo(uniqueIdentifierList[(i - 1)])
}

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Select'))


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelected', [('fieldName') : 'Index for Price Change Comparison'
            , ('selected') : 'S&P Euro 350']), GlobalVariable.timeOutValue)


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelectedText', [('fieldName') : 'Currency'
            , ('selected') : 'Euro']), GlobalVariable.timeOutValue)


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelectedText', [('fieldName') : 'Magnitude'
            , ('selected') : 'Millions']), GlobalVariable.timeOutValue)


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Connect'))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_CollapseAll1'), 120)
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

String insuredID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Insured ID']))

if (insuredID.contains(InsuredID)) {
    KeywordUtil.logInfo('Insured ID is present')
}

String WorksheetID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Worksheet ID']))

if (WorksheetID.contains(worksheetID)) {
    KeywordUtil.logInfo('Worksheet ID  W-XXXX is present')
}

String SPCompanyName = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Company Name']))

WebUI.verifyEqual(SPCompanyName, companyName)

String SPUniqueIdentifier = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Unique Identifier']))

WebUI.verifyEqual(SPUniqueIdentifier, uniqueIdentifierList[0])

String SPRefreshUser = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Refresh User']))

WebUI.verifyEqual(SPRefreshUser, refreshUser)

String todayDate = new SimpleDateFormat('dd/MM/yyyy').format(new Date())

String SPDataRefreshDate = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Data Refresh Date']))

String[] SPDataRefreshDateOf = SPDataRefreshDate.split(' ')

WebUI.verifyEqual(SPDataRefreshDateOf[0], todayDate)


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


WebUI.verifyEqual(yearEstablished, '1863')

String shortCompanyDecsription = WebUI.getText(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Short company description']))

if (shortCompanyDecsription.contains(companyDescription)) {
    KeywordUtil.logInfo('Correct Company Description is present')
}

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Is the Company part of a larger Group?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']), 
    'Test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']), 
    'Test')


for (int i = 1; i < 4; i++) {
    String currencyValue = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Currency']))


    WebUI.verifyEqual(currencyValue, 'EUR')
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

KeywordUtil.logInfo('Comment section is visible under ADR Exposure')

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


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : addItem_Button]), 
    GlobalVariable.timeOutValue)


for (int i = 1; i <= expiringProgramStructureHeaderList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_WithHeader_Div', 
            [('headerName') : 'Expiring Program Structure', ('fieldName') : expiringProgramStructureHeaderList[(i - 1)]]))
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


for (int i = 1; i <= pricingOptionsHeaderList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_WithHeader_Div', 
            [('headerName') : 'Pricing Options', ('fieldName') : pricingOptionsHeaderList[(i - 1)]]))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName', [('headerName') : 'Final Program Structure'
            , ('buttonText') : 'Copy Expiring PS']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName', [('headerName') : 'Final Program Structure'
            , ('buttonText') : 'Copy Pricing Ops']))


for (int i = 1; i <= finalProgramStructureHeaderList.size(); i++) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_WithHeader_Div', 
            [('headerName') : 'Final Program Structure', ('fieldName') : finalProgramStructureHeaderList[(i - 1)]]))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Final', ('button') : delete_Button]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Final', ('button') : addItem_Button]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : addItem_Button]))


WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 1]), 
    'EUR', false)


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : addItem_Button]), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : addItem_Button]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : addItem_Button]))


for (int i = 1; i < 3; i++) {
    WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLayerLimit']))


	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i + 
                '$pLayerLimit']))
    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i + 
                '$pLayerLimit']), layerLimitValueList[(i - 1)])


    WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pUL']))


	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
		'$pUL']))
    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i + 
                '$pUL']), pUlValueList[(i - 1)])


    WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLayerGWP']))


	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
		'$pLayerGWP']))
    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i + 
                '$pLayerGWP']), pGWPValueList[(i - 1)])


    WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLeadName']))


	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
		'$pLeadName']))
    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i + 
                '$pLeadName']), pLeadNameValueList[(i - 1)])


    WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLeadPercent']))

	
	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
		'$pLeadPercent']))
    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i + 
                '$pLeadPercent']), pLeadPercentValueList[(i - 1)])


    WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pTMHCCPercnt']))


	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
		'$pTMHCCPercnt']))
    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i + 
                '$pTMHCCPercnt']), pTMHCCPercentValueList[(i - 1)])


    WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pCom']))


	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
		'$pCom']))
    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i + 
                '$pCom']), pComValueList[(i - 1)])

}


WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Expiring', ('fieldName') : 'Position'
            , ('index') : 3]))
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : delete_Button]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName', [('headerName') : 'Pricing Options'
            , ('buttonText') : 'Copy Expiring PS']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Within Underwriter´s Authority?'
            , ('option') : option_No]))


WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'UW Authority'
            , ('index') : 1]), UWAuthority, false)


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Authority Approval Method'
            , ('option') : option_Online]))


WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Referral account? '
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Referral account? '
            , ('option') : option_No]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Attach Worksheet as PDF?'
            , ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Attach Worksheet as PDF?'
            , ('option') : option_No]))

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelectedText', [('fieldName') : 'Industry Champions/Crypto Taskforce referral'
            , ('selected') : 'Not Applicable']), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Referral account? '
            , ('option') : option_No]))
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Attach Worksheet as PDF?'
            , ('option') : option_No]))
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'FL Manager '
            , ('index') : 1]), 'Paul Rayner', false)


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Submit', [('index') : 1]))


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_PendingAuthorityStatus', [('fieldName') : 'Pending - Authority']), 
    20)

WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_Status'), 30)

String Status = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_Status'))

WebUI.verifyMatch(Status, 'UW Authority Required', false)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Save', [('index') : '7']))


WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/webElement_Attachment'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/webElement_Attachment'))


WebUI.callTestCase(findTestCase('Test Cases/Worksheets/259398_SubTestCase_Part1'), [('testData') : testData, ('rowNumber') : rowNumber], 
    FailureHandling.STOP_ON_FAILURE)