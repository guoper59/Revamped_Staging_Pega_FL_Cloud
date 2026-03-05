/**
 * ============================================================================
 * Test Case ID : 262225
 * Title         : Create New Bureau Proportional Treaty
 * Folder        : Scripts/NewBusiness/262225_CreateNewBureauProportionalTreaty
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

import static com.kms.katalon.core.model.FailureHandling.CONTINUE_ON_FAILURE
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import common.WebTableUtils
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

String testData = 'CreateSubmission'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

String testData1 = 'Credentials'

//Finding Row number from Test Data.
int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData1).getValue('Role', rowNumber1))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Creating a Submission')
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Click on the 'Create' button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

//TODO: Make it work without UX changes
if (WebUI.verifyElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'), FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_StartFinancialLinesSubmission'))
}

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

//Wait for the 'Insured' element to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

// Enter cover holder information into the submission helper using the provided test data and row number.
SubmissionHelper.enterCoverHolder(testData, rowNumber)

// Select reinsured data based on the specified row number using the SubmissionHelper class.
SubmissionHelper.selectReinsured(testData, rowNumber)

// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// Enter broker details using the provided test data and row number.
SubmissionHelper.enterBrokerDetails(testData, rowNumber)

// Click on continue button.
WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

if (WebUI.verifyElementNotPresent(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'),
	GlobalVariable.timeoutShort, FailureHandling.OPTIONAL)) {
	// Click on continue button.
	WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
}

//Enter Details in General Data Tab
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'),
	GlobalVariable.timeoutShort)

SubmissionHelper.enterGeneralData(testData, rowNumber)

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
//Enter details in Uw worksheet
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'),
	findTestData(testData).getValue('UW Authority', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBaseCurrencyCode'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBaseCurrencyCode'),
	findTestData(testData).getValue('Original Currency', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TMHCCWrittenParticipation'),
	findTestData(testData).getValue('TMHCC Written Participation%', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TMHCCWrittenParticipation'),
	Keys.chord(Keys.TAB))

//Validate the TMHCC Signed Participation and Calculated Line % values.
List<WebElement> calculatedValues = WebUI.findWebElements(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_TMHCCSignedParticipation'),
	GlobalVariable.timeoutShort)

WebUI.switchToFrame(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/iframe_PegaGadget1Ifr'),
	GlobalVariable.timeoutShort)

for (int i = 0; i < (calculatedValues.size() - 1); i++) {
	String THMCCSigned_Actual = calculatedValues.get(i).getAttribute('value')

	GenericUtils.verifyMatch('TMHCC Signed Participation & Calculated Line value is ', THMCCSigned_Actual, findTestData(
			testData).getValue('TMHCC Written Participation%', rowNumber), 'EQUAL')
}

WebUI.switchToDefaultContent()

//Verifying the values
String orderValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Order %']), 'value')

GenericUtils.verifyMatch('Order Value is', orderValue, findTestData(testData).getValue('Order%', rowNumber), 'EQUAL')

String estimatedSigningValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Estimated Signing %']), 'value')

GenericUtils.verifyMatch('Estimated Signing Value is', estimatedSigningValue, findTestData(testData).getValue('Estimated Signing %',
		rowNumber), 'EQUAL')

int ordervalue = Integer.parseInt(orderValue.replace('.00000', ''))

int estSignedValue = Integer.parseInt(estimatedSigningValue.replace('.00000', ''))

int tmhccValue = Integer.parseInt(findTestData(testData).getValue('TMHCC Written Participation%', rowNumber).replace('.00000',
		''))

int expectedcalculatedLineValue = (((((ordervalue / 100) * estSignedValue) / 100) * tmhccValue) / 100) * 100

KeywordUtil.logInfo(expectedcalculatedLineValue)

String calculatedLineValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Calculated Line %']), 'value')

GenericUtils.verifyMatch('Calculated line Value is', calculatedLineValue, expectedcalculatedLineValue.toString().concat(
		'.00000'), 'EQUAL')

//Enter Commission value
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'),
	GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'),
	findTestData(testData).getValue('Commission', rowNumber))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_PremiumCalculate'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'),
	findTestData(testData).getValue('IsTacitRenewal', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TacItRenewalDate'),
	findTestData(testData).getValue('Tacit Renewal Date', rowNumber))

//Verify Element Present Coinsurance
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
		[('labelName') : 'Coinsurance?']), GlobalVariable.timeoutShort)

//Verify Element Value Lead
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
			[('labelName') : 'Lead ']), 'value'), findTestData(testData).getValue('Entity', rowNumber), false)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'), FailureHandling.OPTIONAL )

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/webElement_AddItem'), 20)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/webElement_AddItem'))

WebUI.waitForElementNotHasAttribute(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement',
	[('fieldToEnter') : labelName.get('premiumPercent1')]), 'disabled', 60, FailureHandling.OPTIONAL )			

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement',
		[('fieldToEnter') : labelName.get('premiumPercent1')]), findTestData(testData).getValue('PremiumPercentage', rowNumber))

WebUI.selectOptionByValue(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownElement',
		[('fieldtoSelect') : labelName.get('llyodsRiskCode1')]), findTestData(testData).getValue('LlyodsRiskCode1', rowNumber),
	false)
String layerCommissionValue = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue',
		[('headerName') : 'Layer Broker Commission Amount']))

GenericUtils.verifyMatch('Layer Commission Value is', layerCommissionValue, findTestData(testData).getValue('LayerBrokerCommissionAmount',
		rowNumber), 'EQUAL')

String tmhccBrokerCommissionValue = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue',
		[('headerName') : 'TMHCC Broker Commission Amount']))

GenericUtils.verifyMatch('TMHCC Broker Commission Value is', tmhccBrokerCommissionValue, findTestData(testData).getValue(
		'TMHCCBrokerCommissionAmount', rowNumber), 'EQUAL')

String tmhccGrossPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue',
		[('headerName') : 'TMHCC Gross Premium']))

GenericUtils.verifyMatch('TMHCC Gross Premium Value is', tmhccGrossPremium, findTestData(testData).getValue('TMHCCGrossPremium',
		rowNumber), 'EQUAL')

String tmhccNetPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue',
		[('headerName') : 'TMHCC Net Premium']))

GenericUtils.verifyMatch('TMHCC Net Premium Value is', tmhccNetPremium, findTestData(testData).getValue('TMHCCNetPremium',
		rowNumber), 'EQUAL')

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckboxLabelBefore',
		[('labelName') : 'FAC Out Indicator']), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckboxLabelBefore',
		[('labelName') : 'No Claim Bonus']), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

String totalLayerValue = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue',
		[('headerName') : 'Primary Total Layer Limit']))

GenericUtils.verifyMatch('TotalLayerLimit Value is', totalLayerValue, '', 'EQUAL')

String totalLayerPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue',
		[('headerName') : 'Primary Total Layer Premium']))

GenericUtils.verifyMatch('TotalLayerPremium Value is', totalLayerPremium, '', 'EQUAL')

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 60, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), FailureHandling.OPTIONAL)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', [('fieldToEnter') : labelName.get('brokerRefernce')]), 25)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement',
		[('fieldToEnter') : labelName.get('brokerRefernce')]), findTestData(testData).getValue('BrokerReference', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement',
		[('fieldToEnter') : labelName.get('benchmarkLossRatio')]), Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement',
		[('fieldToEnter') : labelName.get('benchmarkLossRatio')]), findTestData(testData).getValue('SBF Benchmark Loss Ratio',
		rowNumber))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', [('fieldToEnter') : labelName.get(
				'pricedTechPremium')]))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement',
		[('fieldToEnter') : labelName.get('pricedTechPremium')]), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement',
		[('fieldToEnter') : labelName.get('pricedTechPremium')]), findTestData(testData).getValue('PricedTechPremium', rowNumber))

String originalCurrency = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/WebElement_Currency'))

GenericUtils.verifyMatch('originalCurrency Value is', originalCurrency, findTestData(testData).getValue('Original Currency', rowNumber), 'EQUAL')

String taxBureau = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_TaxBureau'))

WebUI.verifyMatch(taxBureau, 'Bureau', false)

WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Documentation/PolicyCreation/select_DynamicDropDown',
		[('dropDownLabel') : 'Settlement Currency']), findTestData(testData).getValue('Original Currency', rowNumber), false,
	GlobalVariable.timeoutShort)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
		testData).getValue('Due Date', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
		Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_BindPolicy'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_BindPolicy'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_FinalisePolicy'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_FinalisePolicy'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_Proceed'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_Proceed'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Status',
		[('status') : 'Written']), 60)

// Call a custom keyword to log off the application.
CustomKeywords.'com.login.helper.LoginHelper.logOffApplication'()

//Finding Row number from Test Data.
int rowNumber2 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID + '_1')

//Login to the Application again
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Hbakker', GlobalVariable.Hbakker, findTestData(testData1).getValue('Role', rowNumber2))

//Wait for the specified element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), 25,
	FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//NAvigate to UW/Fac RI Quality Check
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : "Quality Check"]))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Underwriter/checkBox_ViewAllDACases'), GlobalVariable.timeoutShort)

WebUI.enhancedClick(findTestObject('Object Repository/Page_Underwriter/checkBox_ViewAllDACases'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Underwriter/webElement_TaskID'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

GenericUtils.filterColumnByValue('Policy Number', GlobalVariable.PolicyRef)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Underwriter/webElement_TaskID'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_Underwriter/webElement_TaskID'))

if ( WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Underwriter/input_SelectAllYes'), FailureHandling.OPTIONAL ) ) {
	 
	WebUI.click(findTestObject('Object Repository/Page_Underwriter/input_SelectAllYes'))
	
	
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Underwriter/button_Approve'), GlobalVariable.timeOutValue,
		FailureHandling.STOP_ON_FAILURE)
	
	WebUI.click(findTestObject('Object Repository/Page_Underwriter/button_Approve'))
}

// Call a custom keyword to log off the application.
CustomKeywords.'com.login.helper.LoginHelper.logOffApplication'()

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData1).getValue('Role', rowNumber1))

//Wait for the specified element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//NAvigate to UW/Fac RI Quality Check

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : "Quality Check"]))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Underwriter/checkBox_ViewAllDACases'), GlobalVariable.timeoutShort)

WebUI.enhancedClick(findTestObject('Object Repository/Page_Underwriter/checkBox_ViewAllDACases'))
GenericUtils.filterColumnByValue('Policy Number', GlobalVariable.PolicyRef)

WebUI.scrollToElement(findTestObject('Object Repository/Page_Underwriter/webElement_TaskID'), 25)

WebUI.click(findTestObject('Object Repository/Page_Underwriter/webElement_TaskID'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Underwriter/button_Complete'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Page_Underwriter/button_Complete'))

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_SuccessMessageDeclinedReason'), 10)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/button_close'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/button_close'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_SubmissionSearchOrCreation'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_SubmissionSearchOrCreation'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

//Wait for the specified element to be visible.
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_SubmissionSearchOrCreation'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

//Wait for the specified element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

// Retrieve the value of 'Policy Reference' from Global Variable.
String policyRef = GlobalVariable.PolicyRef

// Enters the value '1234567890' in the policy reference field on the Pega Case Manager Portal
WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), policyRef)
// Click on the search button in the Pega Case Manager Portal.
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/button_SubmissionSearch'))
//Get the text from a web element on the page and stores it in a variable/
String policyQuote = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation',
		[('fieldName') : 'Policy Reference']), FailureHandling.STOP_ON_FAILURE)

// Verify if the actual policy reference matches with the expected policy quote.
GenericUtils.verifyMatch('Search Policy By Reference is Successful', policyRef, policyQuote, 'EQUAL')
//NAvigate to View Policy
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/button_Actions'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/WebElement_View'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/WebElement_View'))

WebUI.switchToDefaultContent()

//Calling Get API to validate response---SBS ECLIPSE
ResponseObject response1 = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetProgramPackage'), null)

//Retrieve the policy status from the response
String policyStatus = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].LineStatus')

KeywordUtil.logInfo('Policy Status Value is ::' + policyStatus)

//Verify if the policy status matches the expected value 'Written'
GenericUtils.verifyMatch('Verify Status of Policy', 'Written', policyStatus, 'EQUAL')

//In the General Section, check the following information:
String bureauSettled = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.BureauSettledInd')

KeywordUtil.logInfo('Bureau Settled ::' + bureauSettled)

String interestValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Interest')

KeywordUtil.logInfo('Interest Value is ::' + interestValue)

String placingTypeValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.PlacingType')

KeywordUtil.logInfo('Placing Type Value is ::' + placingTypeValue)

GenericUtils.verifyMatch('Verify Bureau Settled', 'true', bureauSettled, 'EQUAL')

String assureds = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Assureds.Organization[0].LegalName')

KeywordUtil.logInfo('Assured value is ::' + assureds)

String reAssured = WS.getElementText(response1, 'ResponseWrapper.Policies[0].ReAssureds.Organization[0].LegalName')

KeywordUtil.logInfo('ReAssured value is ::' + reAssured)

String inceptionDateFormat = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.InceptionDate')

KeywordUtil.logInfo('Inception Date value is ::' + inceptionDateFormat)

Date date = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss').parse(inceptionDateFormat)

String inceptionDate = new SimpleDateFormat('dd/MM/yyyy').format(date)

KeywordUtil.logInfo('Inception Date value is ::' + inceptionDate)

GenericUtils.verifyMatch('Verify Inception Date is ::', inceptionDate, findTestData(testData).getValue('Inception Date',
		rowNumber), 'EQUAL')

String expiryDateFormat = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.ExpiryDate')

KeywordUtil.logInfo('Expiry Date value is ::' + expiryDateFormat)

Date date1 = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss').parse(expiryDateFormat)

String expirationDate = new SimpleDateFormat('dd/MM/yyyy').format(date1)

KeywordUtil.logInfo('Expiration Date value is ::' + expirationDate)

String mainClass = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Class4')

KeywordUtil.logInfo('Main Class Value is ::' + mainClass)

String majorClassName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Class1')

KeywordUtil.logInfo('Major Class Value is ::' + majorClassName)

String minorClassName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Class2')

KeywordUtil.logInfo('Minor Class Value is ::' + minorClassName)

String class1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Class3')

KeywordUtil.logInfo('Class Value is ::' + class1)

String policyPremium = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyPremiums[0].PolicyPremIncome')

KeywordUtil.logInfo('Policy Premium Value is ::' + policyPremium)

String findTestData(testData).getValue('Original Currency', rowNumber) = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyPremiums[0].PremCcyISO')

KeywordUtil.logInfo('Original Currency Value is ::' + findTestData(testData).getValue('Original Currency', rowNumber))

String producingTeam = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].ProducingTeam')

KeywordUtil.logInfo('Producing Team Value is ::' + producingTeam)

String lineStatus = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].LineStatus')

KeywordUtil.logInfo('Line Status Value is ::' + lineStatus)

String writtenOrder = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].WrittenOrder')

KeywordUtil.logInfo('Written Order Value is ::' + writtenOrder)

String writtenLine = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].WrittenLine')

KeywordUtil.logInfo('Written Line Value is ::' + writtenLine)

String entityValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].LegalBranch')

KeywordUtil.logInfo('Entity Value is ::' + entityValue)

String leaderName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].CompanyLeaders.Organization[0].LegalName')

KeywordUtil.logInfo('Leader Name Value is ::' + leaderName)

//Risk Code
String riskCodeValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].RiskCodes[0].CodeValue')

KeywordUtil.logInfo('Risk Code value is ::' + riskCodeValue)

String premiumSplit = WS.getElementText(response1, 'ResponseWrapper.Policies[0].RiskCodes[0].PremSplit')

KeywordUtil.logInfo('Premium Split value is ::' + premiumSplit)

//Review Type
String reviewType = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyReviews[0].ReviewType')

KeywordUtil.logInfo('Review Type value is ::' + reviewType)

String reviewDateFormat = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyReviews[0].ReviewDate')

KeywordUtil.logInfo('Review Date value is ::' + reviewDateFormat)

Date reviewDate = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss').parse(reviewDateFormat)

String reviewDateCorrect = new SimpleDateFormat('dd/MM/yyyy').format(reviewDate)

KeywordUtil.logInfo('Review Date value is ::' + reviewDateCorrect)

String brokerName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Placers[0].BrokerName')

KeywordUtil.logInfo('Broker Name Value is ::' + brokerName)

String brokerContactName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Placers[0].ContactName')

KeywordUtil.logInfo('Broker Contact Name Value is ::' + brokerContactName)

String settlementRiskCode = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].RiskCode')

KeywordUtil.logInfo('Settlement Risk Code Value is ::' + settlementRiskCode)

String installmentType = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].InstalmentType')

KeywordUtil.logInfo('Installment Type Value is ::' + installmentType)

String statusValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].Completed')

KeywordUtil.logInfo('Status Value is ::' + statusValue)

String OrigCcyIso = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigCcyISO')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigCcyIso)

String OrigGross = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigGross')

KeywordUtil.logInfo('Original Gross Value is ::' + OrigGross)

String OrigNet = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigNet')

KeywordUtil.logInfo('Original Net Value is ::' + OrigNet)

String postToLedgerValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].PostToLedger')

KeywordUtil.logInfo('Post to ledger Value is ::' + postToLedgerValue)

String ledgerAccountID = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].LedgerAccountId')

KeywordUtil.logInfo('Ledger account ID is ::' + ledgerAccountID)

String settlementType = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].Type')

KeywordUtil.logInfo('Settlement Type Value is ::' + settlementType)

String settlementAdditionIndicator = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].Addition')

KeywordUtil.logInfo('Settlement Indicator Value is ::' + settlementAdditionIndicator)

String settlementTotalAmount = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].TotalAmt')

KeywordUtil.logInfo('Settlement Total Amount Value is ::' + settlementTotalAmount)

String settlementLedgerAccountID = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].LedgerAccountId')

KeywordUtil.logInfo('Settlement Ledger Account ID is ::' + settlementLedgerAccountID)

