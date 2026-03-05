/**
 * ============================================================================
 * Test Case ID : 262211
 * Title         : Verify UW Worksheet Workbasket
 * Folder        : Scripts/Worksheets/262211_VerifyUWWorksheetWorkbasket
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
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

//Finding Row number from Test Data.
int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

String timeStamp = GenericUtils.getCurrentTimestamp()

String brokerContactName = 'Auto_' + timeStamp

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

//Loggedin to Pega with valid DNO User credentials
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData1).getValue('Role', rowNumber1))

KeywordUtil.logInfo('Loggedin to Pega with valid UWA User credentials ')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : underwritingWorksheetLink]))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.click(findTestObject('Object Repository/SubmissionSearch/more_Filters'))

//Navigated to Underwriting Worksheet
KeywordUtil.logInfo('Navigated to Underwriting Worksheet')

//Verify Elements Present
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']), 
    GlobalVariable.timeoutShort)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Worksheet ID']), 
    GlobalVariable.timeoutShort)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Multi-LOB Programme ID']), 
    GlobalVariable.timeoutShort)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Policy Reference']), 
    GlobalVariable.timeoutShort)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/button_FieldName', [('fieldName') : 'RefreshUWWorksheetFilters']), 
    GlobalVariable.timeoutShort)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/button_FieldName', [('fieldName') : 'SaveWorksheetFiltersForUser']), 
    GlobalVariable.timeoutShort)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'), GlobalVariable.timeoutShort)


WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Worksheet Type']), 
    GlobalVariable.timeoutShort)


WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Year of Account']), 
    GlobalVariable.timeoutShort)


WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Underwriter']), 
    GlobalVariable.timeoutShort)


WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Underwriting Authority']), 
    GlobalVariable.timeoutShort)



WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Producing Team']), 
    GlobalVariable.timeoutShort)


WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Worksheet Status']), 
    GlobalVariable.timeoutShort)


WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Underwriting Authority Status']), 
    GlobalVariable.timeoutShort)


WebUI.verifyElementNotChecked(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'ExcludeResolvedCases']), 
    GlobalVariable.timeoutShort)


WebUI.verifyElementNotChecked(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'ExcludeUnlinkedCases']), 
    GlobalVariable.timeoutShort)


WebUI.click(findTestObject('Object Repository/Page_Worksheets/button_FieldName', [('fieldName') : 'RefreshUWWorksheetFilters']))


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'), GlobalVariable.timeOutValue)


//
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Year of Account']), 
    findTestData(testData).getValue('YearsofAccount', rowNumber), false)


WebUI.click(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']))

// Find the test object for the policy reference field on the Pega Case Manager Portal
WebUI.sendKeys(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']), findTestData(
        testData).getValue('Insured Name', rowNumber))


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : findTestData(
                testData).getValue('Insured Name', rowNumber)]), GlobalVariable.timeOutValue)


WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : findTestData(
                testData).getValue('Insured Name', rowNumber)]))


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))


WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', [('fieldName') : 'Insured Name']), 
    GlobalVariable.timeOutValue)

String insuredName = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Insured Name']), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Insured Name: ' + insuredName)

String worksheetID = WebUI.getText(findTestObject('Object Repository/SubmissionSearch/webElement_forValidation'), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Worksheet ID Value: ' + worksheetID)

KeywordUtil.logInfo('Insured NAme from Sheet: ' + findTestData(testData).getValue('Insured Name', rowNumber))

String multiLOB = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Multi-LOB ID']), FailureHandling.STOP_ON_FAILURE)

String policyRef = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Policy Reference']), FailureHandling.STOP_ON_FAILURE)

String year = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', [('fieldName') : 'Year']), 
    FailureHandling.STOP_ON_FAILURE)

String majorClass = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Major Class']), FailureHandling.STOP_ON_FAILURE)

String worksheetStatus = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Worksheet Status']), FailureHandling.STOP_ON_FAILURE)

String worksheetType = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Worksheet Type']), FailureHandling.STOP_ON_FAILURE).trim()

KeywordUtil.logInfo(worksheetType)

String completionDue = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Completion Due']), FailureHandling.STOP_ON_FAILURE)

//Verify if the insured name matches the expected value.
GenericUtils.verifyMatch('Insured Name is matched', insuredName, findTestData(testData).getValue('Insured Name', rowNumber), 
    'EQUAL')

//Verify if the Worksheet ID  matches the expected value.
GenericUtils.verifyMatch('Worksheet ID is matched', worksheetID, findTestData(testData).getValue('Worksheet ID', rowNumber), 
    'EQUAL')

//Verify if the policy REf matches the expected value.
GenericUtils.verifyMatch('Policy Reference is matched', policyRef, findTestData(testData).getValue('Policy Reference', rowNumber), 
    'EQUAL')

//Verify if the Year matches the expected value.
GenericUtils.verifyMatch('Year is matched', year, findTestData(testData).getValue('YearsofAccount', rowNumber), 'EQUAL')

//Verify if the Major Class matches the expected value.
GenericUtils.verifyMatch('Major Class is matched', majorClass, findTestData(testData).getValue('Major Class', rowNumber), 
    'EQUAL')

//Verify if the Worksheet Status matches the expected value.
GenericUtils.verifyMatch('Worksheet Status is matched', worksheetStatus, findTestData(testData).getValue('Worksheet Status', 
        rowNumber), 'EQUAL')

//Verify MultiLOB Value
GenericUtils.verifyMatch('Multi LOB is matched', multiLOB, findTestData(testData).getValue('Multi LOB', rowNumber), 'EQUAL')

//Verify Worksheet Type Value
GenericUtils.verifyMatch('Worksheet Type is matched', worksheetType.trim(), findTestData(testData).getValue('Worksheet Type', 
        rowNumber), 'EQUAL')

//Verify Completion Due Value
GenericUtils.verifyMatch('Completion Due is matched', completionDue, findTestData(testData).getValue('Completion Due', rowNumber), 
    'EQUAL')

String uwAuthority = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'UW Authority']), FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('UW Authority is matched', uwAuthority, findTestData(testData).getValue('UW Authority', rowNumber), 
    'EQUAL')

String producingTeam = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Producing Team']), FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('Producing Team is matched', producingTeam, findTestData(testData).getValue('Producing Team', rowNumber), 
    'EQUAL')

String underWriter = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Underwriter']), FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('Underwriter is matched', underWriter, findTestData(testData).getValue('Underwriter', rowNumber), 
    'EQUAL')

String onlineApproval = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Online Approval']), FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('Online Approval is matched', onlineApproval, findTestData(testData).getValue('Online Approval', 
        rowNumber), 'EQUAL')

String uwAuthorityStatus = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'UW Authority Status']), FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('UW Authority Status is matched', uwAuthorityStatus, findTestData(testData).getValue('UW Authority Status', 
        rowNumber), 'EQUAL')

//Finding Row number from Test Data.
int rowNumber2 = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID + '_1')

WebUI.click(findTestObject('Object Repository/Page_Worksheets/button_FieldName', [('fieldName') : 'RefreshUWWorksheetFilters']))


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'), GlobalVariable.timeOutValue)

//
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Year of Account']), 
    findTestData(testData).getValue('YearsofAccount', rowNumber2), false)

WebUI.click(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Worksheet ID']))

// Find the test object for the policy reference field on the Pega Case Manager Portal
WebUI.sendKeys(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Worksheet ID']), findTestData(
        testData).getValue('Worksheet ID', rowNumber2))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : findTestData(
                testData).getValue('Worksheet ID', rowNumber2)]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : findTestData(
                testData).getValue('Worksheet ID', rowNumber2)]))


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', [('fieldName') : 'Insured Name']), 
    GlobalVariable.timeOutValue)

String insuredName1 = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Insured Name']), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Insured Name: ' + insuredName1)

String worksheetID1 = WebUI.getText(findTestObject('Object Repository/SubmissionSearch/webElement_forValidation'), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Worksheet ID Value: ' + worksheetID)

KeywordUtil.logInfo('Insured NAme from Sheet: ' + findTestData(testData).getValue('Insured Name', rowNumber2))

String multiLOB1 = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Multi-LOB ID']), FailureHandling.STOP_ON_FAILURE)

String policyRef1 = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Policy Reference']), FailureHandling.STOP_ON_FAILURE)

String year1 = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', [('fieldName') : 'Year']), 
    FailureHandling.STOP_ON_FAILURE)

String majorClass1 = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Major Class']), FailureHandling.STOP_ON_FAILURE)

String worksheetStatus1 = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Worksheet Status']), FailureHandling.STOP_ON_FAILURE)

String worksheetType1 = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Worksheet Type']), FailureHandling.STOP_ON_FAILURE).trim()

KeywordUtil.logInfo(worksheetType)

String completionDue1 = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Completion Due']), FailureHandling.STOP_ON_FAILURE)

//Verify if the insured name matches the expected value.

//Verify if the Worksheet ID  matches the expected value.
GenericUtils.verifyMatch('Worksheet ID is matched', worksheetID1, findTestData(testData).getValue('Worksheet ID', rowNumber2), 
    'EQUAL')

//Verify if the policy REf matches the expected value.
GenericUtils.verifyMatch('Policy Reference is matched', policyRef1, findTestData(testData).getValue('Policy Reference', 
        rowNumber2), 'EQUAL')

//Verify if the Year matches the expected value.
GenericUtils.verifyMatch('Year is matched', year1, findTestData(testData).getValue('YearsofAccount', rowNumber2), 'EQUAL')

//Verify if the Major Class matches the expected value.
GenericUtils.verifyMatch('Major Class is matched', majorClass1, findTestData(testData).getValue('Major Class', rowNumber2), 
    'EQUAL')

//Verify if the Worksheet Status matches the expected value.
GenericUtils.verifyMatch('Worksheet Status is matched', worksheetStatus1, findTestData(testData).getValue('Worksheet Status', 
        rowNumber2), 'EQUAL')

//Verify MultiLOB Value
GenericUtils.verifyMatch('Multi LOB is matched', multiLOB1, findTestData(testData).getValue('Multi LOB', rowNumber2), 'EQUAL')

//Verify Worksheet Type Value
GenericUtils.verifyMatch('Worksheet Type is matched', worksheetType1.trim(), findTestData(testData).getValue('Worksheet Type', 
        rowNumber2), 'EQUAL')

//Verify Completion Due Value
GenericUtils.verifyMatch('Completion Due is matched', completionDue1, findTestData(testData).getValue('Completion Due', 
        rowNumber2), 'EQUAL')

String uwAuthority1 = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'UW Authority']), FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('UW Authority is matched', uwAuthority1, findTestData(testData).getValue('UW Authority', rowNumber2), 
    'EQUAL')


String producingTeam1 = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Producing Team']), FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('Producing Team is matched', producingTeam1, findTestData(testData).getValue('Producing Team', 
        rowNumber2), 'EQUAL')

String underWriter1 = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Underwriter']), FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('Underwriter is matched', underWriter1, findTestData(testData).getValue('Underwriter', rowNumber2), 
    'EQUAL')

String onlineApproval1 = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Online Approval']), FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('Online Approval is matched', onlineApproval1, findTestData(testData).getValue('Online Approval', 
        rowNumber2), 'EQUAL')

String uwAuthorityStatus1 = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'UW Authority Status']), FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('UW Authority Status is matched', uwAuthorityStatus1, findTestData(testData).getValue('UW Authority Status', 
        rowNumber2), 'EQUAL')

//Finding Row number from Test Data.
int rowNumber3 = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID + '_2')

WebUI.click(findTestObject('Object Repository/Page_Worksheets/button_FieldName', [('fieldName') : 'RefreshUWWorksheetFilters']))


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'), GlobalVariable.timeOutValue)


//
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Year of Account']), 
    findTestData(testData).getValue('YearsofAccount', rowNumber3), false)


// Find the test object for the policy reference field on the Pega Case Manager Portal
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Underwriter']), 
    findTestData(testData).getValue('Underwriter', rowNumber3), false)


WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Worksheet Status']), 
    findTestData(testData).getValue('Worksheet Status', rowNumber3), false)


WebUI.click(findTestObject('Object Repository/Page_Worksheets/button_FieldName', [('fieldName') : 'SaveWorksheetFiltersForUser']))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_SubmissionSearchOrCreation'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_SubmissionSearchOrCreation'))


WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

//Wait for the specified element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : underwritingWorksheetLink]))

//Navigated to Underwriting Worksheet
KeywordUtil.logInfo('Navigated to Underwriting Worksheet')

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))
//Verify Elements Present
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Page_Worksheets/button_FieldName', [('fieldName') : 'RefreshUWWorksheetFilters']))


WebUI.click(findTestObject('Object Repository/SubmissionSearch/more_Filters'))

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Insured Name']), 
    'value', '', GlobalVariable.timeoutShort)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Worksheet ID']), 
    'value', '', GlobalVariable.timeoutShort)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Multi-LOB Programme ID']), 
    'value', '', GlobalVariable.timeoutShort)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_Worksheets/input_FieldName', [('fieldName') : 'Policy Reference']), 
    'value', '', GlobalVariable.timeoutShort)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/button_FieldName', [('fieldName') : 'RefreshUWWorksheetFilters']), 
    GlobalVariable.timeoutShort)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/button_FieldName', [('fieldName') : 'SaveWorksheetFiltersForUser']), 
    GlobalVariable.timeoutShort)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'), GlobalVariable.timeoutShort)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Worksheet Type']), 
    GlobalVariable.timeoutShort)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Year of Account']), 
    GlobalVariable.timeoutShort)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Underwriting Authority']),
	GlobalVariable.timeoutShort)



WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Producing Team']),
	GlobalVariable.timeoutShort)


WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Worksheet Status']),
	GlobalVariable.timeoutShort)


WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Worksheets/select_DropdownFieldName', [('fieldName') : 'Underwriting Authority Status']),
	GlobalVariable.timeoutShort)
