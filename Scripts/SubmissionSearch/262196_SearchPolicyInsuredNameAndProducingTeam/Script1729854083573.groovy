/**
 * ============================================================================
 * Test Case ID : 262196
 * Title         : Search Policy Insured Name And Producing Team
 * Folder        : Scripts/SubmissionSearch/262196_SearchPolicyInsuredNameAndProducingTeam
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

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

String testData1 = testData1

//Finding Row number from Test Data.
int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Lnardocci', GlobalVariable.Lnardocci, findTestData(testData1).getValue('Role', rowNumber1))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), 25, 
    FailureHandling.STOP_ON_FAILURE)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownYearsofAccount'), 
    'Unknown', false)
// Find the test object for the Insured field on the Pega Case Manager Portal
WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_Insuredname'), findTestData(testData).getValue(
        'Insured Name', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult0', [('projectName') : insuredNameValue, ('state') : 'P5216']),
GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult0', [('projectName') : insuredNameValue, ('state') : 'P5216']))

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult0', [('projectName') : insuredNameValue, ('state') : 'P5216']))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownProducingTeam'), 
    GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownProducingTeam'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownProducingTeam'), findTestData(
        testData).getValue('Producing Team', rowNumber), false)

// Click on the search button in the Pega Case Manager Portal.
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', [('fieldName') : 'Insured Name']), 
    GlobalVariable.timeOutValue)
String insuredName = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Insured Name']), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Insured Name: ' + insuredName)

String producingTeam = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Producing Team']), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Producing Team Value: ' + producingTeam)

KeywordUtil.logInfo('Insured NAme from Sheet: ' + findTestData(testData).getValue('Insured Name', rowNumber))

//Verify if the insured name matches the expected value.

//Verify if the producing team matches the expected value.
GenericUtils.verifyMatch('Producing Team is matched', producingTeam, findTestData(testData).getValue('Producing Team', rowNumber), 
    'EQUAL')

GenericUtils.convertWebElementsListToStringListAndSort(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Inception Date']), 'DESC')