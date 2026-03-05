/**
 * ============================================================================
 * Test Case ID : 262195
 * Title         : Search Policy Insured Name And Major Class
 * Folder        : Scripts/SubmissionSearch/262195_SearchPolicyInsuredNameAndMajorClass
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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

String testData1 = testData1

//Finding Row number from Test Data.
int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Lnardocci', GlobalVariable.Lnardocci, findTestData(testData1).getValue('Role', rowNumber1))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'),  25, FailureHandling.STOP_ON_FAILURE)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownYearsofAccount'), 
    'Unknown', false)
// Find the test object for the policy reference field on the Pega Case Manager Portal
WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_Insuredname'), findTestData(testData).getValue(
        'Insured Name', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult0', [('projectName') : insuredNameValue, ('state') : 'P4887']),
GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult0', [('projectName') : insuredNameValue, ('state') : 'P4887']))

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult0', [('projectName') : insuredNameValue, ('state') : 'P4887']))

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_MajorClassMagnifier'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_MajorClass', [('majorClass') : majorClassValue]),  GlobalVariable.timeOutValue)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_MajorClass', [('majorClass') : majorClassValue]),  GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_MajorClass', [('majorClass') : majorClassValue]))
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/button_OK'))
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))

//verify insured name and class
String actualInsuredName = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Insured Name']), FailureHandling.STOP_ON_FAILURE)
String actualMajorClass = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Major Class']), FailureHandling.STOP_ON_FAILURE)

if(actualInsuredName.contains(findTestData(testData).getValue('Insured Name', rowNumber))) {
	return true
}
GenericUtils.verifyMatch('Major  Class is matched', actualMajorClass, findTestData(testData).getValue('Major Class', rowNumber), 
    'EQUAL')