/**
 * ============================================================================
 * Test Case ID : 262204
 * Title         : Create Endorsement Cancellation From Inception DO
 * Folder        : Scripts/Endorsements/262204_CreateEndorsementCancellationFromInceptionDO
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

				testData).getValue('Broker', rowNumber)
String pseudoCodeValue = findTestData(testData).getValue('Pseudo Code', rowNumber)

String testData = 'Endorsements'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

String brokerValue = findTestData(

WebUI.comment('RowNumber: ' + rowNumber)

String timeStamp = GenericUtils.getCurrentTimestamp()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'(findTestData(testData).getValue('UserName', rowNumber),
	findTestData(testData).getValue('Password', rowNumber), findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Creating a Submission')
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Click on the 'Create' button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.click(WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/label_Title'))
)

// Enter cover holder information into the submission helper using the provided test data and row number.
SubmissionHelper.enterInsuredDetails(testData, rowNumber)

// Select reinsured data based on the specified row number using the SubmissionHelper class.
SubmissionHelper.selectReinsured(testData, rowNumber)

// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// Enter broker details using the provided test data and row number.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
		'CountryName', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']),
	findTestData(testData).getValue('Broker', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : pseudoCodeValue]),
	GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : pseudoCodeValue]))

WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : pseudoCodeValue]))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'),
	findTestData(testData).getValue('Broker Contact', rowNumber), false)

// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// Enter details in General Data using the provided test data and row number.
SubmissionHelper.enterGeneralData(testData, rowNumber)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
		[('labelName') : 'Is SME ?']), GlobalVariable.timeoutShort)

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

GenericUtils.verifyMatch('Policy Period Value is', policyPeriod, findTestData(testData).getValue('PolicyPeriod', rowNumber),
'EQUAL')

String bureauIndicator = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_BureauIndicator'),
	'alt')

GenericUtils.verifyMatch('Bureau Indicator is not ticked ', bureauIndicator, 'False', 'EQUAL')

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

// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_CreateMultipleTitle'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_CreateMultiQuote'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_DynamicText', [('buttonName') : 'Collapse all']),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_DynamicText', [('buttonName') : 'Expand all']),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_OpenQuote'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

// Enter details in UWSheet using the provided test data and row number.
SubmissionHelper.enterDetailsUWSheet(testData, rowNumber)

//Verifying the values
String orderValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Order %']), 'value')

GenericUtils.verifyMatch('Order Value is', orderValue, findTestData(testData).getValue('Order%', rowNumber), 'EQUAL')

String estimatedSigningValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Estimated Signing %']), 'value')

GenericUtils.verifyMatch('Estimated Signing Value is', estimatedSigningValue, findTestData(testData).getValue('Estimated Signing %',
		rowNumber), 'EQUAL')

String calculatedLineValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Calculated Line %']), 'value')

GenericUtils.verifyMatch('Calculated line Value is', calculatedLineValue, findTestData(testData).getValue('Calculated Line %',
		rowNumber), 'EQUAL')

String tmhccAggLimitValue = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadLimitInformation',
		[('headerName') : 'TMHCC AGG Limit']))

GenericUtils.verifyMatch('TMHCC Agg Limit Value is', tmhccAggLimitValue, findTestData(testData).getValue('TMHCC AGG Limit',
		rowNumber), 'EQUAL')

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

WebUI.click(findTestObject('Object Repository/Dashboards/button_CompleteQuote'))

String qoutedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Qouted Status Value is', qoutedStatus, 'Quoted', 'EQUAL')

WebUI.switchToFrame(findTestObject('Object Repository/NewBusiness/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Verifying Data Validation field names
List<WebElement> tableHeadersName = WebUI.findWebElements(findTestObject('Object Repository/NewBusiness/webElement_HeadersCompleteQoute'),
	GlobalVariable.timeOutValue)

List<WebElement> FinalList=tableHeadersName.subList(0, 7);

List<WebElement> tableHeadersList = new ArrayList<String>()

for (int i = 0; i<7; i++) {
	String value = FinalList.get(i).getText().trim( // Trim spaces
	)

if (!(value.equals(''))) {
	tableHeadersList.add(value)
}}

KeywordUtil.logInfo(tableHeadersList)
GenericUtils.compareLists(tableHeadersList, expectedHeadersList)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_TakeUpQuote'))

String openBoundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Open Bound Status Value is', openBoundStatus, 'Open Bound', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'),
	findTestData(testData).getValue('UW Authority', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'),
	findTestData(testData).getValue('IsTacitRenewal', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TacItRenewalDate'),
	findTestData(testData).getValue('Tacit Renewal Date', rowNumber))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownCyberCoverage'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownCyberCoverage'),
	findTestData(testData).getValue('Cyber Coverage', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'ADR Exposure ']),
	GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'ADR Exposure ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'ADR Exposure ']),
	findTestData(testData).getValue('ADR Exposure', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Local Market Cap ']),
	GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Local Market Cap ']))

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_DynamicValues', [('labelName') : 'Local Market Cap ']),
	findTestData(testData).getValue('Local Market Cap', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_EntitysTotalAsset'),
	findTestData(testData).getValue('Entitys Total Assets', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_PolicyHolderTurnover'),
	findTestData(testData).getValue('Policy Holder Revenue/Turn Over/Fee Income', rowNumber))

String leadName = WebUI.getAttribute(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), 'value')

KeywordUtil.logInfo('Lead Value: ' +leadName)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_TMHCCLeadIndicator'), GlobalVariable.timeOutValue)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'FAC Out Indicator']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'No Claim Bonus']), GlobalVariable.timeoutShort)

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Primary Total Layer Limit'])).isEmpty()) {
	KeywordUtil.logInfo('Primary Total Layer Limit is empty')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Primary Total Layer Premium'])).isEmpty()) {
	KeywordUtil.logInfo('Primary Total Layer Premium is empty')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_Comments', [('commentField') : 'Cyber Wording comments'])).isEmpty()) {
	KeywordUtil.logInfo('Cyber Wording comments section is empty')
}
String financialTypeText = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_FinancialTypeDefaultDropDown'))

GenericUtils.verifyMatch('Financial Type Value is', financialTypeText, 'Please Select...', 'EQUAL')

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Automatic Discovery Period']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Optional Discovery Period']), GlobalVariable.timeoutShort)

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'US Market Cap (in USD)'])).isEmpty()) {
	KeywordUtil.logInfo('US Market Cap (in USD) is empty')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Entity’s US Assets (in USD)'])).isEmpty()) {
	KeywordUtil.logInfo('Entity’s US Assets (in USD) is empty')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Assets Under Management (AUM)'])).isEmpty()) {
	KeywordUtil.logInfo('Assets Under Management (AUM) is empty')
}

String tacitRenewalDays = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
	[('labelName') : 'Tacit Renewal Days']), 'value')

GenericUtils.verifyMatch('Tacit Renewal Days Value is', tacitRenewalDays, '29', 'EQUAL')

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Applicable Jurisdiction'])).isEmpty()) {
	KeywordUtil.logInfo('Applicable Jurisdiction is empty')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Retroactivity Date'])).isEmpty()) {
	KeywordUtil.logInfo('Retroactivity Date is empty')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Continuity Date'])).isEmpty()) {
	KeywordUtil.logInfo('Continuity Date is empty')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Contract Start Date'])).isEmpty()) {
	KeywordUtil.logInfo('Contract Start Date is empty')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'External Policy Reference'])).isEmpty()) {
	KeywordUtil.logInfo('External Policy Reference is empty')
}

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Notes']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Additional Insureds']), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_ContinueGeneral'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Broker Reference (UMR) ']), findTestData(testData).getValue('UMR', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
	testData).getValue('Due Date', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
	Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

//Installments Validations
List<WebElement> actualInstalment = WebUI.findWebElements(findTestObject('Object Repository/Pega_CreateInsured/webElement_tblValue',
	[('tableName') : 'Instalment']), GlobalVariable.timeoutShort)

List<WebElement> actualInstalmentValues = new ArrayList<String>()

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget1Ifr'), GlobalVariable.timeoutShort)

for (int i = 0; i < actualInstalment.size(); i++) {
String value = actualInstalment.get(i).getText().trim( // Trim spaces
	)

if (!(value.equals(''))) {
	actualInstalmentValues.add(value)
}
}

WebUI.switchToDefaultContent()

KeywordUtil.logInfo(actualInstalmentValues)

GenericUtils.compareLists(expectedInstallmentValues, actualInstalmentValues)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'),
GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

//Status Validations to be added
String uwQCStatus = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_UWQCStatus'))

GenericUtils.verifyMatch('UW QC Status is', uwQCStatus, expecteduwQCStatus, 'EQUAL')

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_InitiateContractCertanity'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPolicySlipInsurance'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPolicySlipInsurance'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPolicySlipInsurance'),
	findTestData(testData).getValue('PolicySlip', rowNumber), false)

WebUI.check(findTestObject('Object Repository/NewBusiness/checkBox_SelectYesContract'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Save'))

String successMessage = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SuccessMessage'))

GenericUtils.verifyMatch('Success Message Displayed', successMessage, 'Your action has been completed.', 'EQUAL')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_CloseContractCertainty'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']),
	10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Finalise'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Finalise'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

String signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', signedStatus, 'Written', 'EQUAL')

String peerReview = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PeerReviewNumber'))

KeywordUtil.logInfo('Peer Review Case generate for this is : ' + peerReview)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))

//Loggging in with Underwriter
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'(findTestData(testData).getValue('UnderwriterUserName',
		rowNumber), findTestData(testData).getValue('Password', rowNumber), 'Underwriter')
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
	[('optionToSelect') : 'Quality Check']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Quality Check']))

WebUI.check(findTestObject('Object Repository/OutwardsPolicy/checkbox_ViewAllCases'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_ClearFilter'), GlobalVariable.timeOutValue,
FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_SearchTextInFilter', [('fieldName') : 'Search Text']),
	GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Apply'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'))

WebUI.check(findTestObject('Object Repository/OutwardsPolicy/checkbox_UnderwriterDecision', [('optionToSelect') : 'Yes']))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Approve'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Approve'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'(findTestData(testData).getValue('UserName', rowNumber),
	findTestData(testData).getValue('Password', rowNumber), findTestData(testData).getValue('Role', rowNumber))
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
	[('optionToSelect') : 'Quality Check']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Quality Check']))

WebUI.check(findTestObject('Object Repository/OutwardsPolicy/checkbox_ViewAllCases'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_ClearFilter'), GlobalVariable.timeOutValue,
FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_SearchTextInFilter', [('fieldName') : 'Search Text']),
	GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Apply'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Complete'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Complete'))

WebUI.verifyElementPresent(findTestObject('Object Repository/OutwardsPolicy/webElement_SuccessMessage'), GlobalVariable.timeOutValue,
FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
	[('optionToSelect') : 'Submission Search']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Submission Search']))

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/label_Title'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Actions'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Actions'))

WebUI.click(findTestObject('Object Repository/Endorsements/button_CreateEndorsement'))

WebUI.switchToFrame(findTestObject('Object Repository/Endorsements/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

////Verifying Data Validation field names
List<WebElement> endorsementTabs = WebUI.findWebElements(findTestObject('Object Repository/Endorsements/webElement_EndorsementTabs'),
	GlobalVariable.timeOutValue)

List<WebElement> endorsementTabsList = new ArrayList<String>()

for (WebElement e : endorsementTabs) {

	endorsementTabsList.add(e.getText())
}

KeywordUtil.logInfo(endorsementTabsList)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Requested By']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Requested By']),
	findTestData(testData).getValue('EndorsementRequested', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Type']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Type']),
	findTestData(testData).getValue('EndorsementType', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/text_CommentsSection', [('commentField') : 'Endorsement Notes']),
	'Test test test test test test')

String endorsmentInceptionDate = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/input_FieldName', [('fieldName') : 'Endorsement Inception Date ']),
	'value')

KeywordUtil.logInfo(endorsmentInceptionDate)

String endorsmentExpiryDate = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/input_FieldName', [('fieldName') : 'Endorsement Expiry Date ']),
	'value')

KeywordUtil.logInfo(endorsmentExpiryDate)

String endorsmentPeriod = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_ReadDynamicValues', [('headerName') : 'Endorsement Period']))

KeywordUtil.logInfo(endorsmentPeriod)

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
	findTestData(testData).getValue('Layer Gross Premium2', rowNumber))

WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Premium Type']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Premium Type']),
	findTestData(testData).getValue('Premium Type', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_CompleteQuote1'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_CompleteQuote1'))

String quotedStatus1 = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', quotedStatus1, 'Quoted', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote'))

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

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

WebUI.check(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'No']))

WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Reason for not sending the Underwriting Quality Check']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Reason for not sending the Underwriting Quality Check']),
	findTestData(testData).getValue('Reason', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/text_CommentsSection', [('commentField') : 'Comments']), 'Test test test test')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))

//Clicks on a button to initiate contract certainty.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_InitiateContractCertanity'))

// Click on a button to save the form in a web application.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Save'))

//Click on the close button at the top of the page
WebUI.click(findTestObject('Object Repository/NewBusiness/button_CloseContractCertainty'))

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Finalise'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Finalise'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

String signedStatus1 = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', signedStatus1, 'Signed', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Cancel Reason ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Cancel Reason ']),
	findTestData(testData).getValue('CancelReason', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/text_CommentsSection', [('commentField') : 'Cancel Reason Description ']), 'Test test test test')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit_1'))

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit_1'))

String signedStatus2 = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', signedStatus2, 'Cancelled', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Endorsements/webElement_DynamicTabSelector', [('tabName') : 'Endorsements']))

WebUI.switchToFrame(findTestObject('Object Repository/Endorsements/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

//Verifying Data Validation field names
List<WebElement> endorsementTableHeadersName = WebUI.findWebElements(findTestObject('Object Repository/Endorsements/webElement_ListOfEndorsementVersionTableHeaders'),
	GlobalVariable.timeOutValue)

List<WebElement> actualEndorsementHeaderValues = new ArrayList<String>()

for (int i = 0; i < endorsementTableHeadersName.size(); i++) {
	String value = endorsementTableHeadersName.get(i).getText().trim( // Trim spaces
		)

	if (!(value.equals(''))) {
		actualEndorsementHeaderValues.add(value)
	}
}

KeywordUtil.logInfo(actualEndorsementHeaderValues)

//Verifying Data Validation field names
List<WebElement> endorsementTableValues = WebUI.findWebElements(findTestObject('Object Repository/Endorsements/webElement_ListOfTableValues',[('version') : 1]),
	GlobalVariable.timeOutValue)

List<WebElement> actualEndorsementTableValues = new ArrayList<String>()

for (int i = 0; i < endorsementTableValues.size(); i++) {
	String value = endorsementTableValues.get(i).getText().trim( // Trim spaces
		)

	if (!(value.equals(''))) {
		actualEndorsementTableValues.add(value)
	}
}

KeywordUtil.logInfo(actualEndorsementTableValues)

WebUI.switchToDefaultContent()

String endorsementNumber = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_EndorsementNumber', [('attributeName') : 'Endorsement Number', ('version') : 1]))

WebUI.click(findTestObject('Object Repository/Endorsements/webElement_DynamicTabSelector', [('tabName') : 'Post Bind']))

findTestObject('Object Repository/Endorsements/webElement_Instalments')

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/webElement_Instalments'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Endorsements/webElement_Instalments'))

String OriginalPremium = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_OriginalPremium'))

OriginalPremium = OriginalPremium.replace(',','')

String ReturnPremium = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_ReturnPremium'))

ReturnPremium = ReturnPremium.replace(',','')

float sumofPremiums = Float.parseFloat(OriginalPremium) + Float.parseFloat(ReturnPremium)

KeywordUtil.logInfo(sumofPremiums)

String sum = String.valueOf(sumofPremiums);

GenericUtils.verifyMatch('Sum of Original + Return Premium is', sum, '0.0', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))

return endorsementNumber

return ReturnPremium

return OriginalPremium

