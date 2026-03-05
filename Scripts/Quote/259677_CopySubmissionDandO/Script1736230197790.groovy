/**
 * ============================================================================
 * Test Case ID : 259677
 * Title         : Copy Submission Dand O
 * Folder        : Scripts/Quote/259677_CopySubmissionDandO
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

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
// Navigated to Financial Line Submission/Open Submission page
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Entering Insured Details using the keyword
SubmissionHelper.enterInsuredDetails(testData, rowNumber)

//Selecting reInsured Details using the keyword
SubmissionHelper.selectReinsured(testData, rowNumber)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
        'CountryName', rowNumber), false)


WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']),
	findTestData(testData).getValue('Broker', rowNumber))
	WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
		testData).getValue('Broker', rowNumber)]))

	WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_KRAutoCompleteResult', [('projectName') : findTestData(
		testData).getValue('Broker', rowNumber)]))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'), 
    findTestData(testData).getValue('Broker Contact', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))


//Entering general data using the keyword
SubmissionHelper.enterGeneralData(testData, rowNumber)

String currentDate = new SimpleDateFormat('dd/MM/yyyy').format(Calendar.getInstance().time)

String submissionReceivedDate = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Submission Received Date']), 
    'data-value')

GenericUtils.verifyMatch('Submission Received Date Value is', submissionReceivedDate, currentDate, 'EQUAL')

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Quote Due Date'])).isEmpty()) {
    KeywordUtil.logInfo('Quote Date is empty')
}


WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Notes']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Is Master']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Is Local']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Is Tied In']), GlobalVariable.timeoutShort)

String policyPeriod = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Policy Period ']), 'value')

GenericUtils.verifyMatch('Policy Period Value is', policyPeriod, expectedPolicyPeriod, 'EQUAL')

String bureauIndicator = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_BureauIndicator'), 'alt')

GenericUtils.verifyMatch('Bureau Indicator is ticked ', bureauIndicator, 'False','EQUAL')


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_OtherActions'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_OtherActionsOption', [('optionToSelect') : 'Copy Submission']))


if (WebUI.verifyElementPresent(findTestObject('Object Repository/Qoute/webElement_CopySubmissionText'), GlobalVariable.timeOutValue)) {
    KeywordUtil.logInfo('Copy Submission Header is visible')
}

String popUpMessage = WebUI.getText(findTestObject('Object Repository/Qoute/webElement_PopUpMessage'))

KeywordUtil.logInfo(popUpMessage)
WebUI.waitForElementClickable(findTestObject('Object Repository/Qoute/button_Continue'), 60)
WebUI.click(findTestObject('Object Repository/Qoute/button_Continue'))


WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_CaseID'),60)
//Validation
String caseID = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_CaseID'))

KeywordUtil.logInfo('Case ID is : ' + caseID)

String status = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

KeywordUtil.logInfo('Status Value is : ' + status)

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget1Ifr'), 30)

if (WebUI.verifyTextPresent(GlobalVariable.insuredName, false)) {
    KeywordUtil.logInfo('Copied Insured Name is : ' + GlobalVariable.insuredName)
}
WebUI.switchToDefaultContent()


String classType = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption',
	[('dropDownName') : 'ClassType']))

GenericUtils.verifyMatch('Entity Value is', classType, findTestData(testData).getValue('Class Type', rowNumber), 'EQUAL')

String majorClass = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption',
	[('dropDownName') : 'MajorClass']))

GenericUtils.verifyMatch('Major Class Value is', majorClass, findTestData(testData).getValue('Major Class', rowNumber), 'EQUAL')
//
String minorClass = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption',
	[('dropDownName') : 'MinorClass']))

GenericUtils.verifyMatch('Minor Class Value is', minorClass, findTestData(testData).getValue('Minor Class', rowNumber), 'EQUAL')

String placingType = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption',
	[('dropDownName') : 'PlacingBasis']))

GenericUtils.verifyMatch('Placing Type Value is', placingType, findTestData(testData).getValue('Placing Type', rowNumber), 'EQUAL')

String subPlacingType = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption',
	[('dropDownName') : 'SubPlacingBasis']))

GenericUtils.verifyMatch('Sub Placing Type Value is', subPlacingType, findTestData(testData).getValue('Sub Placing Type', rowNumber), 'EQUAL')

String underWriter = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption',
	[('dropDownName') : 'Underwriter']))

GenericUtils.verifyMatch('Underwriter Value is', underWriter, findTestData(testData).getValue('Underwriter', rowNumber), 'EQUAL')

String underWritingAssistant = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption',
	[('dropDownName') : 'Assistant']))

GenericUtils.verifyMatch('Underwriting Assistant Value is', underWritingAssistant, findTestData(testData).getValue('Underwriting Assistant', rowNumber), 'EQUAL')

String producingTeam = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption',
	[('dropDownName') : 'ProducingTeam']))

GenericUtils.verifyMatch('Producing Team Value is', producingTeam, findTestData(testData).getValue('Producing Team', rowNumber), 'EQUAL')

String entity = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption',
	[('dropDownName') : 'Entity']))

GenericUtils.verifyMatch('Entity Value is', entity, findTestData(testData).getValue('Entity', rowNumber), 'EQUAL')

String legalBranch = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption',
	[('dropDownName') : 'LegalBranch']))

GenericUtils.verifyMatch('Legal Branch Value is', legalBranch, findTestData(testData).getValue('Legal Branch', rowNumber), 'EQUAL')


WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Year of Account']), 
    GlobalVariable.timeOutValue)

//Selecting declined reason
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Year of Account']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Year of Account']), 
    'Unknown', false)


// Find the test object for the policy reference field on the Pega Case Manager Portal
WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_Insuredname'), GlobalVariable.insuredName)


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : GlobalVariable.insuredName]), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : GlobalVariable.insuredName]))


WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))
