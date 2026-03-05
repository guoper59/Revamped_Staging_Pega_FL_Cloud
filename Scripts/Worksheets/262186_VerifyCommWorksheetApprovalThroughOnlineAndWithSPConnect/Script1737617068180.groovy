/**
 * ============================================================================
 * Test Case ID : 262186
 * Title         : Verify Comm Worksheet Approval Through Online And With SP Connect
 * Folder        : Scripts/Worksheets/262186_VerifyCommWorksheetApprovalThroughOnlineAndWithSPConnect
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
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.login.helper.LoginHelper as LoginHelper
import com.submission.helper.SubmissionHelper as SubmissionHelper
import com.testdata.helper.UWWorksheet as UWWorksheet
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))


String insuredName = UWWorksheet.createSubmission(testData, rowNumber)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)

GlobalVariable.PolicyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

KeywordUtil.logInfo(GlobalVariable.PolicyRef)

//Click on the 'OK' element on the page.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))


String caseID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/link_UWWorkSheetStage'))

WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/link_UWWorkSheetStage'), 25)
WebUI.click(findTestObject('Object Repository/UWWorksheet/link_UWWorkSheetStage'))


WebUI.waitForElementVisible(findTestObject('Object Repository/UWWorksheet/label_InsuredName'), 25)


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'Overview']), 25)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'UW Worksheet']), 
    GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'History']), GlobalVariable.timeOutValue)
WebUI.waitForElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']))
String insuredNameOf = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_InsuredName'), 'value')

WebUI.verifyEqual(insuredNameOf, insuredName)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/toolTip_InsuredName'), GlobalVariable.timeOutValue)

String uniqueIdentifier = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'S&P Unique Identifier']), 
    'value')

WebUI.verifyEqual(uniqueIdentifier, '')

String city = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'City']), 
    'value')

WebUI.verifyEqual(city, '')

String countryName = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'Country']), 
    'value')

WebUI.verifyEqual(countryName, '')

WebUI.clearText(findTestObject('Object Repository/UWWorksheet/input_InsuredName'))
WebUI.setText(findTestObject('Object Repository/UWWorksheet/input_InsuredName'), searchText)
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Search'))


for (int i = 1; i < 5; i++) {
    String uniqueIdentifierUI = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_UniqueIdentifier', 
            [('index') : i]))

    WebUI.verifyEqual(uniqueIdentifierUI, uniqueIdentifierList[(i - 1)])
}

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Select'))


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelected', [('fieldName') : 'Index for Price Change Comparison'
            , ('selected') : 'S&P Euro 350']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelectedText', [('fieldName') : 'Currency'
            , ('selected') : 'Euro']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelectedText', [('fieldName') : 'Magnitude'
            , ('selected') : 'Millions']), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Connect'))

WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_CollapseAll'), 120)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_CollapseAll'))


for (int i = 1; i <= 10; i++) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [('header') : collapseAllHeaderList[
                (i - 1)]]), GlobalVariable.timeOutValue)

    String expanded = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [
                ('header') : collapseAllHeaderList[(i - 1)]]), 'aria-expanded')

    KeywordUtil.logInfo('When user collapsed all then expanded is false')

    WebUI.verifyEqual(expanded, 'false')
}


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_ExpandAll'))


KeywordUtil.logInfo('Worksheet Details')
String multiLOBID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Programme ID']))

if(multiLOBID.contains(multiLobID)) {
	print('MultiLOB MYYXXXXX is present')
}

String insuredID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Insured ID']))

if(insuredID.contains(InsuredID)) {
	print('Insured ID is present')
}

String WorksheetID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Worksheet ID']))

if(WorksheetID.contains(worksheetID)) {
	print('Worksheet ID  W-XXXX is present')
}


String SPCompanyName = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Company Name']))

WebUI.verifyEqual(SPCompanyName, 'Air France-KLM SA')

String SPUniqueIdentifier = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Unique Identifier']))

WebUI.verifyEqual(SPUniqueIdentifier, uniqueIdentifierList[0])

String SPRefreshUser = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Refresh User']))

WebUI.verifyEqual(SPRefreshUser, 'SROSS')

String todayDate = new SimpleDateFormat('dd/MM/yyyy').format(new Date())

String SPDataRefreshDate = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Data Refresh Date']))

String[] SPDataRefreshDateOf = SPDataRefreshDate.split(' ')

WebUI.verifyEqual(SPDataRefreshDateOf[0], todayDate)

//IS parent
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_IsParent'), 10)

String insuredNameOfWD = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Insured Name']))
WebUI.verifyEqual(insuredNameOfWD, insuredName)

String NAICDivision = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'NAIC Division']))
WebUI.verifyEqual(NAICDivision, findTestData(testData).getValue('NAIC Division', rowNumber))

String NAICDescription = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'NAIC Description']))
WebUI.verifyEqual(NAICDescription, findTestData(testData).getValue('NAIC Description', rowNumber))

String country = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Country']))
WebUI.verifyEqual(country, findTestData(testData).getValue('Country', rowNumber))

String publicOrPrivate = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Public/Private']))
WebUI.verifyEqual(publicOrPrivate, findTestData(testData).getValue('Public/Private', rowNumber))

String PolicyReference = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Policy Reference']))
WebUI.verifyEqual(PolicyReference, GlobalVariable.PolicyRef)

String Broker = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Broker']))
WebUI.verifyEqual(Broker, findTestData(testData).getValue('Broker', rowNumber))

//Single LOB ID 
String singleLOBID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Broker']))
if(singleLOBID.contains('SDO2')) {
	print('Single LOB ID present SDO2XXXXXXX')
}

String BrokerContact = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Broker Contact']))
WebUI.verifyEqual(BrokerContact, findTestData(testData).getValue('Broker Contact', rowNumber))

String Underwriter = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Underwriter']))
WebUI.verifyEqual(Underwriter, findTestData(testData).getValue('Underwriter', rowNumber))

String PlacingType = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Placing Type']))
WebUI.verifyEqual(PlacingType, findTestData(testData).getValue('Placing Type', rowNumber))

String Reinsured = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Reinsured']))
WebUI.verifyEqual(Reinsured, 'N/A')

String MajorClass = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Major Class']))
WebUI.verifyEqual(MajorClass, 'D&O')

String MinorClass = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Minor Class']))
WebUI.verifyEqual(MinorClass, findTestData(testData).getValue('Minor Class', rowNumber))

String EffectiveDate = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Effective Date']))
WebUI.verifyEqual(EffectiveDate, findTestData(testData).getValue('Inception Date', rowNumber))

String ExpirationDate = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnText', [('fieldName') : 'Expiration Date']))
WebUI.verifyEqual(ExpirationDate, '01/03/2024')

String Entity = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Entity']))
WebUI.verifyEqual(Entity, 'TME')

String LegalBranch = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Legal Branch']))
WebUI.verifyEqual(LegalBranch, findTestData(testData).getValue('Legal Branch', rowNumber))

String SubmissionStatus = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Submission Status']))
WebUI.verifyEqual(SubmissionStatus, 'Open Quote')

KeywordUtil.logInfo('Company Information')

String yearEstablished = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'Year Established']), 
    'value')

WebUI.verifyEqual(yearEstablished, '1919')


String shortCompanyDecsription = WebUI.getText(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Short company description']))

if(shortCompanyDecsription.contains('Air France-KLM SA, together with its subsidiaries, provides passenger and cargo transportation services and'))
{
	print('verified short company desription present')
}

String additionalCompanyDecsription = WebUI.getText(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Additional Company Description']))

if(additionalCompanyDecsription.contains(''))
{
	print('verified additional company desription')
}

String RiskIndustry = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Risk Industry']))
WebUI.verifyEqual(RiskIndustry, 'Crop Farming')

print('High Risk Industry Populated with No')

String
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Is the Company part of a larger Group?'
            , ('option') : option_Yes]))
//added
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Save', [('index') : '1']))
String Currency = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_FieldText', [('section') : 'PriceChange'
            , ('fieldName') : 'Currency']))
WebUI.verifyEqual(Currency, currencyType)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any Abnormality in the share price?'
            , ('option') : option_Yes]))
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any ADR exposure?'
            , ('option') : option_Yes]))
Currency = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_FieldText', [('section') : 'SegmentAnalysis'
            , ('fieldName') : 'Currency']))
WebUI.verifyEqual(Currency, currencyType)

String Magnitude = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('section') : 'SegmentAnalysis'
            , ('fieldName') : 'Magnitude']))
WebUI.verifyEqual(Magnitude, 'Millions')

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any exposure larger than 10% of revenue or Assets in high risk countries?'
            , ('option') : option_Yes]))
Currency = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_FieldText', [('section') : 'SNPDataDisplay'
            , ('fieldName') : 'Currency']))
WebUI.verifyEqual(Currency, currencyType)

Magnitude = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_FieldText', [('section') : 'SNPDataDisplay'
            , ('fieldName') : 'Magnitude']))

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about profitability?'
            , ('option') : option_Yes]))
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about liquidity?'
            , ('option') : option_Yes]))
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about solvency?'
            , ('option') : option_Yes]))
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any significant M&A in the past 2 years?'
            , ('option') : option_Yes]))
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
            , ('option') : option_Yes]))


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'Currency']), GlobalVariable.timeOutValue)

UWWorksheet.verifyStructureTableHeaderDetails('Expiring Program Structure')

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
            , ('button') : 'Add item']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
            , ('button') : 'Delete']), GlobalVariable.timeOutValue)
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
            , ('button') : 'Add item']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Pricing Options'
            , ('button') : 'Delete']), GlobalVariable.timeOutValue)
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

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Final Program Structure'
            , ('fieldName') : 'Position']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Final Program Structure'
            , ('fieldName') : 'Layer Limit']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Final Program Structure'
            , ('fieldName') : 'U/L']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Final Program Structure'
            , ('fieldName') : 'Layer GWP']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Final Program Structure'
            , ('fieldName') : 'Name of Lead']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Final Program Structure'
            , ('fieldName') : 'Coverage']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Final Program Structure'
            , ('fieldName') : 'Lead in %']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Final Program Structure'
            , ('fieldName') : 'TMHCC %']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Final Program Structure'
            , ('fieldName') : 'TMHCC Gross Limit']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Final Program Structure'
            , ('fieldName') : 'TMHCC Gross Premium']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Final Program Structure'
            , ('fieldName') : 'Fac Limit']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Final Program Structure'
            , ('fieldName') : 'Com']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Final Program Structure'
            , ('fieldName') : 'ROL']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Final Program Structure'
            , ('fieldName') : '% of UL']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure'
            , ('button') : 'Add item']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure'
            , ('button') : 'Delete']), GlobalVariable.timeOutValue)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure'
            , ('button') : ' Refresh']), GlobalVariable.timeOutValue)
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'Currency']), currencyType, false)
WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
            , ('button') : 'Add item']))
WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pLayerLimit', ('index') : '1']), expiringProgramStructureList[0])
WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pUL', ('index') : '1']), expiringProgramStructureList[1])
WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pLayerGWP', ('index') : '1']), expiringProgramStructureList[2])
WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pLeadName', ('index') : '1']))
WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pLeadName', ('index') : '1']), expiringProgramStructureList[4])
WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pLeadPercent', ('index') : '1']), expiringProgramStructureList[5])

WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pTMHCCPercnt', ('index') : '1']), expiringProgramStructureList[6])
WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pCom', ('index') : '1']))
WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pCom', ('index') : '1']), expiringProgramStructureList[7])

UWWorksheet.verifyStructureTableDetails('Expiring Program Structure', EPSNewList, 1)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
            , ('button') : 'Add item']))

WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pLayerLimit', ('index') : '2']), expiringProgramStructureList1[0])
WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pLayerGWP', ('index') : '2']))
WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pLayerGWP', ('index') : '2']), expiringProgramStructureList1[2])

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pLeadName', ('index') : '2']))
WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pLeadName', ('index') : '2']), expiringProgramStructureList1[4])

WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pLeadPercent', ('index') : '2']), expiringProgramStructureList1[5])
WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pTMHCCPercnt', ('index') : '2']), expiringProgramStructureList1[6])
WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pCom', ('index') : '2']), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pCom', ('index') : '2']))
WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnField', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'pCom', ('index') : '2']), expiringProgramStructureList1[7])


UWWorksheet.verifyStructureTableDetails('Expiring Program Structure', EPSNewList1, 2)

//Pricing Options
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Pricing Options'
            , ('fieldName') : 'Currency']), currencyType, false)
WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Pricing Options', ('button') : 'Copy Expiring PS']))


UWWorksheet.verifyPricingOptionsStructureTableDetails(EPSNewList, 1)

UWWorksheet.verifyPricingOptionsStructureTableDetails(EPSNewList1, 2)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Within Underwriter´s Authority?'
            , ('option') : option_No]))


WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Pricing Options'
            , ('fieldName') : 'UW Authority']), 'Henk Bakker', false)
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Authority Approval Method'
            , ('option') : 'Online']))
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Referral account? '
            , ('option') : option_Yes]), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Referral account? '
            , ('option') : option_No]), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelectedText', [('fieldName') : 'Industry Champions/Crypto Taskforce referral'
            , ('selected') : 'Not Applicable']), 25)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Attach Worksheet as PDF?'
            , ('option') : option_Yes]), 25)

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Attach Worksheet as PDF?'
            , ('option') : option_No]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Referral account? '
            , ('option') : option_No]))
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Pricing Options'
            , ('fieldName') : 'FL Manager ']), 'Paul Rayner', false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Pricing Options'
            , ('fieldName') : 'Industry Champions/Crypto Taskforce referral']), 'Real Estate', false)


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Submit', [('index') : '1']))
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_PendingAuthorityStatus', [('fieldName') : 'Pending - Authority']), 20)

WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_Status'), 30)
String Status = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_Status'))

WebUI.verifyMatch(Status, 'UW Authority Required', false)
WebUI.scrollToElement(findTestObject('Object Repository/UnderwritingWorksheet/button_Save', [('index') : '7']), 30)
WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/button_Save', [('index') : '7']))

CustomKeywords.'com.login.helper.LoginHelper.logOffApplication'()


CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Hbakker', GlobalVariable.Hbakker, findTestData(testData).getValue('Role', rowNumber))

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : underwritingWorksheetLink]))
//Navigated to Underwriting Worksheet
KeywordUtil.logInfo('Navigated to Underwriting Worksheet')

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

WebUI.waitForElementVisible(findTestObject('Object Repository/UnderwritingWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']))
WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UnderwritingWorksheet/text_FieldText', [('fieldName') : 'S & P Company Name'])), 
    'Air France-KLM SA')

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UnderwritingWorksheet/text_FieldText', [('fieldName') : 'S & P Unique Identifier'])), 
    uniqueIdentifierList[0])

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UnderwritingWorksheet/text_FieldText', [('fieldName') : 'S & P Refresh User'])), 
    'SROSS')

SPDataRefreshDate = WebUI.getText(findTestObject('Object Repository/UnderwritingWorksheet/text_FieldText', [('fieldName') : 'S & P Data Refresh Date']))

SPDataRefreshDateOf = SPDataRefreshDate.split(' ')

WebUI.verifyEqual(SPDataRefreshDateOf[0], todayDate)

WebUI.verifyEqual(WebUI.getText(findTestObject('Object Repository/UnderwritingWorksheet/text_FieldText', [('fieldName') : 'Insured Name'])), 
    insuredName)


WebUI.callTestCase(findTestCase('Test Cases/Worksheets/262186SubTestCase0'), [('testData') : testData, ('rowNumber') : rowNumber, ('currencyType') : currencyType, ('underwritingWorksheetLink') : underwritingWorksheetLink, 
	('insuredName'): insuredName,('caseID') : caseID],FailureHandling.STOP_ON_FAILURE)


WebUI.callTestCase(findTestCase('Test Cases/Worksheets/262186SubTestCase'), [('insuredName'):insuredName,('caseID') : caseID], FailureHandling.STOP_ON_FAILURE)