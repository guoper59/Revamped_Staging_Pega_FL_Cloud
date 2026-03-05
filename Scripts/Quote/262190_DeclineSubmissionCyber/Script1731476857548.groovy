/**
 * ============================================================================
 * Test Case ID : 262190
 * Title         : Decline Submission Cyber
 * Folder        : Scripts/Quote/262190_DeclineSubmissionCyber
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

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)


//Finding Row number from Test Data.
int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData1).getValue('Role', rowNumber1))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Creating a Submission')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Click on the 'Create' button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


//Wait for the 'Insured' element to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

// Enter insured details using the provided test data for a specific row number.
SubmissionHelper.enterInsuredDetails(testData, rowNumber)

// Select reinsured data based on the specified row number from the test data.
SubmissionHelper.selectReinsured(testData, rowNumber)

// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// Enter broker details using the provided test data and row number.
SubmissionHelper.enterBrokerDetails(testData, rowNumber)

// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// Enter details in General Data using the provided test data and row number.
SubmissionHelper.enterGeneralData(testData, rowNumber)

// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

// Wait for the 'OK' element to be visible on the page.
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'),
	GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Get the text of the 'sPolicyReference' element and store it in 'PolicyRef' variable.
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)

GlobalVariable.PolicyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

KeywordUtil.logInfo(GlobalVariable.PolicyRef)

//Click on the 'OK' element on the page.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))

//Uw Worksheet
// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// Call a custom keyword to log off the application.
CustomKeywords.'com.login.helper.LoginHelper.logOffApplication'()
//Calling Get API to validate response
ResponseObject response = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetProgramPackage'), null)
// Extract the text content of a specific element from a response.
String statusPolicy = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyLines[0].LineStatus')
KeywordUtil.logInfo(statusPolicy)
KeywordUtil.logInfo('Policy Status from SBS'+statusPolicy)

// Verify if the status of a policy matches a specific value.
GenericUtils.verifyMatch('Verify Status of Policy', 'INCOM'.toLowerCase(), statusPolicy.toLowerCase(), 'EQUAL')

//Login to the Application again
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData1).getValue('Role', rowNumber1))

//Wait for the specified element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

// Retrieve the value of 'Policy Reference' from Global Variable.
String policyRef = GlobalVariable.PolicyRef

// Enters the value '1234567890' in the policy reference field on the Pega Case Manager Portal
WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), policyRef)

// Click on the search button in the Pega Case Manager Portal.
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))

//Get the text from a web element on the page and stores it in a variable/
String policyQuote = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation',
		[('fieldName') : 'Policy Reference']), FailureHandling.STOP_ON_FAILURE)

// Verify if the actual policy reference matches with the expected policy quote.
GenericUtils.verifyMatch('Search Policy By Reference is Successful', policyRef, policyQuote, 'EQUAL')

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/button_Actions'))

//Wait for the specified element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_ModifySubmission'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Click on the "Modify Submission" button.
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_ModifySubmission'))

//Wait for the "Capture Quote Details" element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_CaptureQuoteDetails'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Click on the "Capture Quote Details" button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_CaptureQuoteDetails'))

// Wait for the "Other Actions" button to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_OtherActions'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Click on the "Other Actions" button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_OtherActions'))

//Wait for the "Decline Submission" element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_DeclineSubmission'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Click on the "Decline Submission" button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_DeclineSubmission'))

//Wait for the "Dropdown Declined Reason" select element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownDeclinedReason'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Select the option "Bad Financials of Insured" from the dropdown.
//Select the option "Bad Financials of Insured" from the dropdown.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownDeclinedReason'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownDeclinedReason'),
	'Bad Financials of Insured', false)

//Enters text in Decline Description.
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DeclineDescription'),
	'Test test test test')

//Click on the 'Submit' button again
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownDeclinedReason'))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_Submit'))

//Wait for the 'Submit' button not Present
WebUI.waitForElementNotPresent(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_Submit'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Switch to  frame
WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget1Ifr'), GlobalVariable.timeoutShort)

//Verify that below text is  present on the page
WebUI.verifyTextPresent('Your action has been completed.', false, FailureHandling.STOP_ON_FAILURE)

//Switch back to the default content of the page.
WebUI.switchToDefaultContent()
//Calling Get API to validate response---SBS ECLIPSE
ResponseObject response1 = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetProgramPackage'), null)

//Retrieve the policy status from the response
String policyStatus = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].LineStatus')

KeywordUtil.logInfo(policyStatus)

//Verify if the policy status matches the expected value 'Decline'
GenericUtils.verifyMatch('Verify Status of Policy', expectedPolicyStatus, policyStatus, 'EQUAL')