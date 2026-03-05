/**
 * ============================================================================
 * Test Case ID : 259889
 * Title         : View Policy On Click On Insured Link From Submission Search
 * Folder        : Scripts/SmokeModifications/259889_ViewPolicyOnClickOnInsuredLinkFromSubmissionSearch
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

import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

KeywordUtil.logInfo('Navigating to Pega Financial Lines')


//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)


//Finding Row number from Test Data.
int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

// Navigate to a specified URL.
WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

//Perform a login operation using the provided username, password, and role from test data.

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('llbusinessadmin', GlobalVariable.llbusinessadmin, findTestData(testData1).getValue('Role', rowNumber1))

//Wait for the specified element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'),  GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

// Retrieve the value of 'Policy Reference' from test data using the specified row number.
String policyRef = findTestData(testData).getValue('Policy Reference', rowNumber)

//Selects an option in a dropdown menu by Years of Account
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownYearsofAccount'),
	'Unknown', false)
// Enters the value '1234567890' in the policy reference field on the Pega Case Manager Portal
WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), policyRef)

// Click on the search button in the Pega Case Manager Portal.
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))

//Get the text from a web element on the page and stores it in a variable/
String policyQuote = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation',
		[('fieldName') : 'Policy Reference']), FailureHandling.STOP_ON_FAILURE)

// Verify if the actual policy reference matches with the expected policy quote.
GenericUtils.verifyMatch('Search Policy By Reference is Successful', policyRef, policyQuote, 'EQUAL')

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_StatusFilter'))
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_ApplyFilter'))
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_SignedStatus'))
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/button_Apply'))
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/button_Actions'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/WebElement_View'),  GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/WebElement_View'))

