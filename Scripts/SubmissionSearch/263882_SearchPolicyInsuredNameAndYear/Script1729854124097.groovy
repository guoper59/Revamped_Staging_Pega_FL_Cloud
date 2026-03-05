/**
 * ============================================================================
 * Test Case ID : 263882
 * Title         : Search Policy Insured Name And Year
 * Folder        : Scripts/SubmissionSearch/263882_SearchPolicyInsuredNameAndYear
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
import common.FileUtils as FileUtils
import common.WebTableUtils as WebTableUtils
import common.WebTableUtils as FileUtils


//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

int rowNumbertestData = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID + '_1')

List<String> rowcount = new ArrayList<String>()

rowcount.add(rowNumbertestData)

rowcount.add(rowNumber)

String testData1 = 'Credentials'

//Finding Row number from Test Data.
int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Lnardocci', GlobalVariable.Lnardocci, findTestData(testData1).getValue('Role', rowNumber1))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

for (int i = 0; i < rowcount.size(); i++) {
    WebUI.verifyElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), FailureHandling.STOP_ON_FAILURE)

    WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownYearsofAccount'), 
        findTestData(testData).getValue('YearsofAccount', rowcount.get(i)), false)
    WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_Insuredname'))

    WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_Insuredname'), findTestData(testData).getValue(
            'Insured Name', rowcount.get(i)))


    WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : findTestData(
                    testData).getValue('Insured Name', rowcount.get(i))]))
    WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'), GlobalVariable.timeOutValue)
    WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))
    WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
            [('fieldName') : 'Insured Name']), GlobalVariable.timeOutValue)
	
	//verify submission search results insured name, years of account

    WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_tableSubmissionSearchResults'), 
        'Insured Name', findTestData(testData).getValue('Insured Name', rowcount.get(i)))

    WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_tableSubmissionSearchResults'), 
        'Inception Date', findTestData(testData).getValue('YearsofAccount', rowcount.get(i)))

    WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_ResetSearch'))

    WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
            [('fieldName') : 'Insured Name']), GlobalVariable.timeOutValue)
}