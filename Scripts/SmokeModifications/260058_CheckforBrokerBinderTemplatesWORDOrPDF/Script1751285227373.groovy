/**
 * ============================================================================
 * Test Case ID : 260058
 * Title         : Checkfor Broker Binder Templates WORD Or PDF
 * Folder        : Scripts/SmokeModifications/260058_CheckforBrokerBinderTemplatesWORDOrPDF
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

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
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


CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData1).getValue('Role', rowNumber1))

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

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 180)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// Enter broker details using the provided test data and row number.
SubmissionHelper.enterBrokerDetails(testData, rowNumber)

// Click on continue button.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 180)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// Enter details in General Data using the provided test data and row number.
SubmissionHelper.enterGeneralData(testData, rowNumber)

// Click on continue button.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 180)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))
// Wait for the 'OK' element to be visible on the page.
//Get the text of the 'sPolicyReference' element and store it in 'PolicyRef' variable.
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)

GlobalVariable.PolicyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))
KeywordUtil.logInfo(GlobalVariable.PolicyRef)

//Click on the 'OK' element on the page.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))
//Uw Worksheet
// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
SubmissionHelper.enterDetailsUWSheet(testData, rowNumber)


//Verifying the values
String orderValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Order %']), 'value')
GenericUtils.verifyMatch('Order Value is', orderValue, findTestData(testData).getValue('Order%', rowNumber), 'EQUAL')

String estimatedSigningValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Estimated Signing %']), 'value')

GenericUtils.verifyMatch('Estimated Signing Value is', estimatedSigningValue, findTestData(testData).getValue('Estimated Signing %',
		rowNumber), 'EQUAL')
		
String tmhccLimitValue = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadLimitInformation',
		[('headerName') : 'TMHCC EEL Limit']))

GenericUtils.verifyMatch('TMHCC EEL Limit Value is', tmhccLimitValue, findTestData(testData).getValue('TMHCC EEL Limit',
		rowNumber), 'EQUAL')

String tmhccAggLimitValue = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadLimitInformation',
		[('headerName') : 'TMHCC AGG Limit']))
GenericUtils.verifyMatch('TMHCC Agg Limit Value is', tmhccAggLimitValue, findTestData(testData).getValue('TMHCC AGG Limit',
		rowNumber), 'EQUAL')
		

String tmhccGrossPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue',
		[('headerName') : 'TMHCC Gross Premium']))

GenericUtils.verifyMatch('TMHCC Gross Premium Value is', tmhccGrossPremium, findTestData(testData).getValue('TMHCCGrossPremium',
		rowNumber), 'EQUAL')

String tmhccNetPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue',
		[('headerName') : 'TMHCC Net Premium']))

GenericUtils.verifyMatch('TMHCC Net Premium Value is', tmhccNetPremium, findTestData(testData).getValue('TMHCCNetPremium',
		rowNumber), 'EQUAL')

//Click on complete the quote.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CompleteQuote'))


//Get the text of a status element.
String qoutedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

////Click on continue.
//TODO: 540274: Remove the Quote Doc and Broker Bind Doc stage from the Pega data entry workflow

////Click on takeup the quote.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))
//TODO: 540276 Generate a Quote Letter document and to Take Up a Quote version to the Bind stage to be amended and moved to the Underwriting stage
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'), 25)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))


//Enter details for underwriting.
SubmissionHelper.enterDetailsUW(testData, rowNumber)


////Click on save.
WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/btn_Save'), 25)
WebUI.click(findTestObject('Object Repository/Documentation/btn_Save'))

//Generate Broker Binder
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_GenerateBrokerBind'), 60)
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_GenerateBrokerBind'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_GenerateBrokerBind'))
// Generate a broker bind using the provided test data
SubmissionHelper.generateBrokerBind(testData, rowNumber)


WebUI.switchToWindowIndex(1)

WebUI.switchToFrame(findTestObject('Object Repository/Pega_CreateInsured/iframePdfViewer'), GlobalVariable.timeOutValue)

WebUI.verifyTextPresent('Binder', false)

WebUI.verifyTextPresent('We are pleased to conf irm the terms of our binding agreement as f ollows:', false)

WebUI.verifyTextPresent('Policy Number:', false)

WebUI.verifyTextPresent(GlobalVariable.PolicyRef, false)

WebUI.verifyTextPresent('Line of Business:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Major Class', rowNumber), false)

WebUI.verifyTextPresent('Policyholder', false)


WebUI.verifyTextPresent('Address:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Addressline', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('PostCode', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('City', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Country', rowNumber), false)

WebUI.verifyTextPresent('Inception Date:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Inception Date', rowNumber), false)

WebUI.verifyTextPresent('Expiration Date:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Expiry Date', rowNumber), false)

WebUI.verifyTextPresent('Continuity Date:', false)

WebUI.verifyTextPresent('', false)

WebUI.verifyTextPresent('Retroactive Date', false)

WebUI.verifyTextPresent('', false)

WebUI.verifyTextPresent('Layer:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('ISPrimary', rowNumber), false)

WebUI.verifyTextPresent('Currency:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Original Currency', rowNumber), false)

WebUI.verifyTextPresent('Layer Limit:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Layer EEL Limit', rowNumber), false)

WebUI.verifyTextPresent('Underlying Limit (if applicable):', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Excess Limit', rowNumber), false)

WebUI.verifyTextPresent('Layer', false)

WebUI.verifyTextPresent('Premium:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Layer Gross Premium', rowNumber), false)

WebUI.verifyTextPresent('plus applicable insurance premium tax', false)

WebUI.verifyTextPresent('Lead Insurer', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Entity', rowNumber), false)

WebUI.verifyTextPresent('Insurer:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Entity', rowNumber) + ' S.A.', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Legal Branch', rowNumber), false)

WebUI.verifyTextPresent('Share:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('TMHCC Written Participation%', rowNumber), false)

WebUI.verifyTextPresent('Limit of Liability:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('TMHCC EEL Limit', rowNumber), false)

WebUI.verifyTextPresent('Broker', false)

WebUI.verifyTextPresent('Commission:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Commission', rowNumber), false)

WebUI.verifyTextPresent('Broker', false)

WebUI.switchToDefaultContent()

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)


String boundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

//Click On Continue button




//Non-interactive
//Wait for a specific element to be visible within a specified timeout.

//for Interactive

//comment bell
