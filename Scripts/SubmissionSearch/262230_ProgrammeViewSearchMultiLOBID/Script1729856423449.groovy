/**
 * ============================================================================
 * Test Case ID : 262230
 * Title         : Programme View Search Multi LOBID
 * Folder        : Scripts/SubmissionSearch/262230_ProgrammeViewSearchMultiLOBID
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
import common.WebTableUtils as WebTableUtils
import internal.GlobalVariable as GlobalVariable


//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)


//Finding Row number from Test Data.
int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Lnardocci', GlobalVariable.Lnardocci, findTestData(testData1).getValue('Role', rowNumber1))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'),  GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownYearsofAccount'), 
    'Unknown', false)
// Find the test object for the Insured field on the Pega Case Manager Portal
WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_Insuredname'), findTestData(testData).getValue(
        'Insured Name', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : findTestData(
                testData).getValue('Insured Name', rowNumber)]),  GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : findTestData(
                testData).getValue('Insured Name', rowNumber)]))
WebUI.click(findTestObject('Object Repository/SubmissionSearch/more_Filters'))
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownProgrammeView'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownProgrammeView'), findTestData(
        testData).getValue('ProgrammeView', rowNumber), false)

// Click on the search button in the Pega Case Manager Portal.
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', [('fieldName') : 'Insured Name']), 
     GlobalVariable.timeOutValue)

String insuredName = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Insured Name']), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Insured Name: ' + insuredName)

//verify single lob id, multi lob id, insured name

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', [('fieldName') : 'Multi LOB Id']), 
     GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', [('fieldName') : 'Single LOB Id']), 
     GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_tableSubmissionSearchResults'), 'Insured Name', findTestData(testData).getValue('Insured Name', rowNumber))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_tableSubmissionSearchResults'), 'Multi LOB Id','' )