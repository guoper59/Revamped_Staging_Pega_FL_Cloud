/**
 * ============================================================================
 * Test Case ID : 262227
 * Title         : Search Policy Insured Name Brokerand Status
 * Folder        : Scripts/SubmissionSearch/262227_SearchPolicyInsuredNameBrokerandStatus
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
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.genericutils.helper.GenericUtils as GenericUtils

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)


//Finding Row number from Test Data.
int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Lnardocci', GlobalVariable.Lnardocci, findTestData(testData1).getValue('Role', rowNumber1))

GlobalVariable.PolicyRef = WebUI.callTestCase(findTestCase('Test Cases/TestData/CreateSubmissionUsingKeyword'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_SubmissionSearchOrCreation'), 
     GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_SubmissionSearchOrCreation'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'),  GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)


WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownYearsofAccount'), 
    'Unknown', false)
// Find the test object for the policy reference field on the Pega Case Manager Portal
WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_Insuredname'),GlobalVariable.insuredName)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : GlobalVariable.insuredName]),  GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : GlobalVariable.insuredName]))
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_StatusMaginifier'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_MajorClass', [('majorClass') : findTestData(
                testData).getValue('Status', rowNumber)]),  GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_MajorClass', [('majorClass') : findTestData(
                testData).getValue('Status', rowNumber)]))
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/button_OK'))

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', [('fieldName') : 'Insured Name']), 
     GlobalVariable.timeOutValue)

String actualInsuredName = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Insured Name']), FailureHandling.STOP_ON_FAILURE)

String actualStatus = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Status']), FailureHandling.STOP_ON_FAILURE)

String actualPolicyRef = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Policy Reference']), FailureHandling.STOP_ON_FAILURE)

String actualBrokerName = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Broker']), FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('Insured Name is matched', actualInsuredName, GlobalVariable.insuredName, 
    'EQUAL')

GenericUtils.verifyMatch('Status is matched', actualStatus, findTestData(testData).getValue('Status', rowNumber), 'EQUAL')

GenericUtils.verifyMatch('Policy Ref is matched', actualPolicyRef, GlobalVariable.PolicyRef, 'EQUAL')
