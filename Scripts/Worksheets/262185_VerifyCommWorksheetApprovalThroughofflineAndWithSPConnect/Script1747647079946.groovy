/**
 * ============================================================================
 * Test Case ID : 262185
 * Title         : Verify Comm Worksheet Approval Throughoffline And With SP Connect
 * Folder        : Scripts/Worksheets/262185_VerifyCommWorksheetApprovalThroughofflineAndWithSPConnect
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

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData).getValue('Role', rowNumber))

String insuredName = UWWorksheet.createSubmission(testData, rowNumber)


WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)

String policyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

GlobalVariable.PolicyRef = policyRef
//Click on the 'OK' element on the page.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'), 60)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))

String caseID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/link_UWWorkSheetStage'))
WebUI.click(findTestObject('Object Repository/UWWorksheet/link_UWWorkSheetStage'))

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'Overview']), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'UW Worksheet']), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/link_OptionName', [('option') : 'History']), 25)
WebUI.waitForElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']), 25, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_CaseContentsOptions', [('linkToClick') : 'UW Worksheet']))
String insuredNameOf = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_InsuredName'), 'value')

WebUI.verifyEqual(insuredNameOf, insuredName)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/toolTip_InsuredName'), 25)
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
WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_CollapseAll'), 60)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_CollapseAll'))

for (int i = 1; i <= 10; i++) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [('header') : collapseAllHeaderList[
                (i - 1)]]), GlobalVariable.timeOutValue)

    String expanded = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [
                ('header') : collapseAllHeaderList[(i - 1)]]), 'aria-expanded')

    WebUI.verifyEqual(expanded, 'false')
}

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_ExpandAll'))

for (int i = 1; i <= 10; i++) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [('header') : collapseAllHeaderList[
                (i - 1)]]), GlobalVariable.timeOutValue)

    String expanded = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/webElement_CollapseAllHeaders', [
                ('header') : collapseAllHeaderList[(i - 1)]]), 'aria-expanded')


    WebUI.verifyEqual(expanded, 'true')
}

KeywordUtil.logInfo('Worksheet Details')

String multiLOBID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Programme ID']))

if (multiLOBID.contains('M')) {
	KeywordUtil.logInfo('MultiLOB MYYXXXXX is present')
}

String WorksheetID = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Worksheet ID']))

if (WorksheetID.contains('W-')) {
	KeywordUtil.logInfo('Worksheet ID  W-XXXX is present')
}

String SPCompanyName = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Company Name']))

WebUI.verifyEqual(SPCompanyName, sPCompanyName)
String SPUniqueIdentifier = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Unique Identifier']))
WebUI.verifyEqual(SPUniqueIdentifier, uniqueIdentifierList[0])

String SPRefreshUser = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Refresh User']))
WebUI.verifyEqual(SPRefreshUser, user)

String todayDate = new SimpleDateFormat('dd/MM/yyyy').format(new Date())
String SPDataRefreshDate = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'S & P Data Refresh Date']))
String[] SPDataRefreshDateOf = SPDataRefreshDate.split(' ')
WebUI.verifyEqual(SPDataRefreshDateOf[0], todayDate)

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
WebUI.verifyEqual(PolicyReference, policyRef)

String Broker = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Broker']))
WebUI.verifyEqual(Broker, findTestData(testData).getValue('Broker', rowNumber))

String BrokerContact = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Broker Contact']))
WebUI.verifyEqual(BrokerContact, findTestData(testData).getValue('Broker Contact', rowNumber))

String Underwriter = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Underwriter']))
WebUI.verifyEqual(Underwriter, findTestData(testData).getValue('Underwriter', rowNumber))

String PlacingType = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Placing Type']))
WebUI.verifyEqual(PlacingType, findTestData(testData).getValue('Placing Type', rowNumber))

String Reinsured = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Reinsured']))
WebUI.verifyEqual(Reinsured, reinsured)

String MajorClass = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Major Class']))
WebUI.verifyEqual(MajorClass, majorClass)

String MinorClass = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Minor Class']))
WebUI.verifyEqual(MinorClass, findTestData(testData).getValue('Minor Class', rowNumber))

String EffectiveDate = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Effective Date']))
WebUI.verifyEqual(EffectiveDate, findTestData(testData).getValue('Inception Date', rowNumber))

String ExpirationDate = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnText', [('fieldName') : 'Expiration Date']))
WebUI.verifyEqual(ExpirationDate, date)

String Entity = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Entity']))
WebUI.verifyEqual(Entity, entity)

String LegalBranch = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Legal Branch']))
WebUI.verifyEqual(LegalBranch, findTestData(testData).getValue('Legal Branch', rowNumber))

String SubmissionStatus = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Submission Status']))
WebUI.verifyEqual(SubmissionStatus, submissionStatus)


String yearEstablished = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'Year Established']), 
    'value')
WebUI.verifyEqual(yearEstablished, '1919')

String RiskIndustry = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Risk Industry']))
WebUI.verifyEqual(RiskIndustry, riskIndustry)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Is the Company part of a larger Group?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']),
	'Test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Is the Company part of a larger Group?']),
	'Test')
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any comments about the shareholders?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Any comments about the shareholders?']))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Any comments about the shareholders?']),
	'Test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Any comments about the shareholders?']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaComments', [('fieldName') : 'Any comments about the shareholders?']),
	'Test')

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Save', [('index') : index1]))

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

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/button_CalculateRatios'), 25)
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
            , ('fieldName') : 'Currency']), 25)
UWWorksheet.verifyStructureTableHeaderDetails('Expiring Program Structure')

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
            , ('button') : addItem_Button]), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
            , ('button') : delete_Button]), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
            , ('button') : ' Refresh']), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Pricing Options'
            , ('fieldName') : 'Currency']), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Pricing Options'
            , ('button') : 'Copy Expiring PS']), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_TableHeader', [('section') : 'Pricing Options'
            , ('fieldName') : 'Option']), 25)
UWWorksheet.verifyStructureTableHeaderDetails('Pricing Options')

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Pricing Options'
            , ('button') : addItem_Button]), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Pricing Options'
            , ('button') : delete_Button]), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Pricing Options'
            , ('button') : ' Refresh']), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Pricing Options'
            , ('fieldName') : 'Underwriter ']), 25)
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Within Underwriter´s Authority?'
            , ('option') : option_Yes]))
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Final Program Structure'
            , ('fieldName') : 'Currency']), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure'
            , ('button') : 'Copy Expiring PS']), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure'
            , ('button') : 'Copy Pricing Ops']), 25)
UWWorksheet.verifyStructureTableHeaderDetails('Final Program Structure')
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure'
            , ('button') : addItem_Button]), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure'
            , ('button') : delete_Button]), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure'
            , ('button') : ' Refresh']), 25)
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Expiring Program Structure'
            , ('fieldName') : 'Currency']), currencyType, false)
WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
            , ('button') : addItem_Button]))
UWWorksheet.enterDataStructureTableDetails('Expiring Program Structure', expiringProgramStructureList, 1)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Expiring Program Structure'
            , ('button') : addItem_Button]))

UWWorksheet.enterDataStructureTableDetails('Expiring Program Structure', expiringProgramStructureList1, 2)
//Pricing Options
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Pricing Options'
            , ('fieldName') : 'Currency']), currencyType, false)
WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Pricing Options', ('button') : 'Copy Expiring PS']))
///UWWorksheet.verifyPricingOptionsStructureTableDetails(EPSNewList1, 2)
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Within Underwriter´s Authority?'
            , ('option') : option_No]))
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Pricing Options'
            , ('fieldName') : 'UW Authority']), 'Henk Bakker', false)
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Authority Approval Method'
            , ('option') : 'Offline']))
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the UW Authority Email been attached?'
            , ('option') : option_Yes]), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the UW Authority Email been attached?'
            , ('option') : option_No]), 25)
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the UW Authority Email been attached?'
            , ('option') : option_Yes]))
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Additional Authority Required?'
            , ('option') : option_Yes]), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Additional Authority Required?'
            , ('option') : option_No]), 25)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Save', [('index') : index1]))

//Final Program Structure
WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/webElement_DropDown', [('section') : 'Final Program Structure'
            , ('fieldName') : 'Currency']), currencyType, false)
WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_Button', [('section') : 'Final Program Structure', ('button') : 'Copy Pricing Ops']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on the ESG profile of the company']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on the ESG profile of the company']), "Test ESG")
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on the ESG profile of the company']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on the ESG profile of the company']), "Test ESG")

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on any Cyber exposure']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on any Cyber exposure']), "Test Cyber")
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on any Cyber exposure']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on any Cyber exposure']), "Test Cyber")

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: Last Year´s comments']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: Last Year´s comments']), "Test Last Year´s comments")
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: Last Year´s comments']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: Last Year´s comments']), "Test Last Year´s comments")
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: This Year´s comments']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: This Year´s comments']), "Test This Year´s comments")
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: This Year´s comments']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: This Year´s comments']), "Test This Year´s comments")

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Points of attention for next renewal, if any']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Points of attention for next renewal, if any']), "Test points of attention")
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Points of attention for next renewal, if any']))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Points of attention for next renewal, if any']), "Test points of attention")
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Rater & Tearsheet Attached?'
            , ('option') : option_Yes]), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Rater & Tearsheet Attached?'
            , ('option') : option_No]), 25)
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Rater & Tearsheet Attached?'
            , ('option') : option_Yes]))
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the Worksheet been completed?'
            , ('option') : option_Yes]), 25)
WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the Worksheet been completed?'
            , ('option') : option_No]), 25)
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the Worksheet been completed?'
            , ('option') : option_Yes]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Submit', [('index') : index1]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Continue'))


GenericUtils.verifyMatch('Success Message Displayed', WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SuccessMessage')), FailureHandling.STOP_ON_FAILURE, 
    'Your action has been completed.', 'EQUAL')



// Wait for the PDF to download
// Close the pop-up window



// Switch back to the main application window
WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Close'))


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
WebUI.callTestCase(findTestCase('Test Cases/Worksheets/262185_SubTestCase_Part1'), [('policyRef'):policyRef],FailureHandling.STOP_ON_FAILURE)
