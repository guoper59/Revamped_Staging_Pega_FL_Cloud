/**
 * ============================================================================
 * Test Case ID : 259913
 * Title         : Create Renewal For Non Bureau Insurance Policy TME Spanish Branch Cyber
 * Folder        : Scripts/SmokeModifications/259913_CreateRenewalForNonBureauInsurancePolicyTMESpanishBranchCyber
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
import com.submission.helper.NewSubmission
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

String testData = 'Renewals'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))

String insuredName = NewSubmission.createSubmission(testData, rowNumber)

WebUI.waitForElementPresent(findTestObject('Object Repository/NewBusiness/webElement_PolicyReference'), 180)

String policyRef = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PolicyReference'))

KeywordUtil.logInfo(policyRef)
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_OK'), 60)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_OK'))
// Click on continue button.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 60)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_DynamicText', [('buttonName') : 'Collapse all']),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_CreateMultipleTitle'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_CreateMultiQuote'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

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

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'),
	findTestData(testData).getValue('UW Authority', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'),
	findTestData(testData).getValue('IsTacitRenewal', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TacItRenewalDate'),
	findTestData(testData).getValue('Tacit Renewal Date', rowNumber))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Policy Holder Revenue/Turn Over/Fee Income ']))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Policy Holder Revenue/Turn Over/Fee Income ']),
	findTestData(testData).getValue('Policy Holder Revenue/Turn Over/Fee Income', rowNumber))

WebUI.click(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'PCS offered – Limit']))
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'PCS offered – Limit']),
	findTestData(testData).getValue('PCS Offered', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Number of Employees']),
	findTestData(testData).getValue('NumberOfEmployees', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Self-Insured Retention (SIR)']),
	findTestData(testData).getValue('SIR', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Number of customers']),
	findTestData(testData).getValue('NumberOfCustomers', rowNumber))

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Subsidiaries in US']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Subsidiaries in US']),
	findTestData(testData).getValue('Subsidiaries', rowNumber), false)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Cyber War Exclusions']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Cyber War Exclusions']),
	findTestData(testData).getValue('Cyber Coverage', rowNumber), false)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_BIWaitingDropDown'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_BIWaitingDropDown'), findTestData(testData).getValue(
		'BiHoursSelect', rowNumber), false)

WebUI.click(findTestObject('Object Repository/NewBusiness/input_BIWaitingPeriod'))
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_BIWaitingPeriod'), findTestData(testData).getValue('BiHours',
		rowNumber))
WebUI.check(findTestObject('Object Repository/NewBusiness/webElement_ContigentApplicable'))

WebUI.click(findTestObject('Object Repository/NewBusiness/select_CBIWaitingDropDown'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_CBIWaitingDropDown'), findTestData(testData).getValue(
		'CbiHoursSelect', rowNumber), false)
WebUI.click(findTestObject('Object Repository/NewBusiness/input_CBIWaitingPeriod'))
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_CBIWaitingPeriod'), findTestData(testData).getValue('CbiHours',
		rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_SublimitSingle'), sublimitList[0])

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.clearText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), findTestData(testData).getValue('input_Lead', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), Keys.chord(Keys.BACK_SPACE))

String currentText =  findTestData(testData).getValue('input_Lead', rowNumber).substring(0, findTestData(testData).getValue('input_Lead', rowNumber).length()-1)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]), GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckboxLabelBefore',
		[('labelName') : 'FAC Out Indicator']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckboxLabelBefore',
		[('labelName') : 'No Claim Bonus']), GlobalVariable.timeoutShort)

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Primary Total Layer Limit'])).isEmpty()) {
	KeywordUtil.logInfo('Primary Total Layer Limit is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Primary Total Layer Premium'])).isEmpty()) {
	KeywordUtil.logInfo('Primary Total Layer Premium is empty')
}

String financialTypeText = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_FinancialTypeDefaultDropDown'))

GenericUtils.verifyMatch('Financial Type Value is', financialTypeText, 'Please Select...', 'EQUAL')

String tacitRenewalDays = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Tacit Renewal Days']), 'value')

KeywordUtil.logInfo('tacit Renewal Days: '+tacitRenewalDays)
GenericUtils.verifyMatch('Tacit Renewal Days Value is', tacitRenewalDays, '59', 'EQUAL')

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Applicable Jurisdiction'])).isEmpty()) {
	KeywordUtil.logInfo('Applicable Jurisdiction is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Retroactivity Date'])).isEmpty()) {
	KeywordUtil.logInfo('Retroactivity Date is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Continuity Date'])).isEmpty()) {
	KeywordUtil.logInfo('Continuity Date is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Contract Start Date'])).isEmpty()) {
	KeywordUtil.logInfo('Contract Start Date is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'External Policy Reference'])).isEmpty()) {
	KeywordUtil.logInfo('External Policy Reference is empty')
}

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
		[('labelName') : 'Notes']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
		[('labelName') : 'Additional Insureds']), GlobalVariable.timeoutShort)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Documentation/PolicyCreation/select_DynamicDropDown',
		[('dropDownLabel') : 'OSP Type ']), 'Non IT OSP', false)

WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/button_Continue'), 10)
WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

//TODO: 540274: Remove the Quote Doc and Broker Bind Doc stage from the Pega data entry workflow

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
	GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
	findTestData(testData).getValue('Tax Applicable', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	findTestData(testData).getValue('Tax code', rowNumber))

currentText =  findTestData(testData).getValue('Tax code', rowNumber).substring(0, findTestData(testData).getValue('Tax code', rowNumber).length()-1)

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']), Keys.chord(Keys.BACK_SPACE))

WebUI.setText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	currentText)

WebUI.mouseOver(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.enhancedClick(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']))
WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']),
	Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']),
	findTestData(testData).getValue('Tax Premium', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
		testData).getValue('Due Date', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
		Keys.TAB))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/webElement_tblValue',
		[('tableName') : 'Instalment']), GlobalVariable.timeoutShort)
//Installments Validations

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

//Status Validations to be added
String uwQCStatus = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_UWQCStatus'))

GenericUtils.verifyMatch('UW QC Status is', uwQCStatus, 'To Be Approved', 'EQUAL')

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']),
	10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Finalise'), 25,
	FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Finalise'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'), 25)
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

String signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', signedStatus, 'Signed', 'EQUAL')

String peerReview = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PeerReviewNumber'))

KeywordUtil.logInfo('Peer Review Case generate for this is : ' + peerReview)

WebUI.closeBrowser()

WebUI.openBrowser(null)

WebUI.maximizeWindow()

GlobalVariable.PolicyRef = policyRef

String renewedPolicy = WebUI.callTestCase(findTestCase('Test Cases/TestData/RenewalAgent'), [('testData') : testData, ('rowNumber') : rowNumber],
	FailureHandling.STOP_ON_FAILURE)

WebUI.openBrowser(null)

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Clicking Dashboard option from left side menu
WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Dashboard']), 25)
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Dashboard']))

WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), 25)
WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
//Verifying Search Filter field names

WebUI.switchToDefaultContent()

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_RenewalLinks', [('optionToSelect') : 'Renewal Work Basket']), 25, FailureHandling.STOP_ON_FAILURE)

//Selecting policy under Renewal Work Basket
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_RenewalLinks', [('optionToSelect') : 'Renewal Work Basket']))
WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/button_ExportToExcel'), GlobalVariable.timeOutValue)

//Clicking on Filter option for Qoute Reference ID
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_RenewedFromPolicyFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

//Searching for the Case ID created above
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'Search Text']),
	GlobalVariable.PolicyRef)
WebUI.click(findTestObject('Object Repository/Dashboards/button_Apply'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_QuoteReference'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_QuoteReference'))

WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue)
if (WebUI.verifyTextPresent(findTestData(testData).getValue('Addressline', rowNumber), false)) {
	KeywordUtil.logInfo('Address Line present ::' + findTestData(testData).getValue('Addressline', rowNumber))
}

if (WebUI.verifyTextPresent(findTestData(testData).getValue('PostCode', rowNumber), false)) {
	KeywordUtil.logInfo('Post Code present ::' + findTestData(testData).getValue('PostCode', rowNumber))
}

if (WebUI.verifyTextPresent(findTestData(testData).getValue('City', rowNumber), false)) {
	KeywordUtil.logInfo('City Name present ::' + findTestData(testData).getValue('City', rowNumber))
}

if (WebUI.verifyTextPresent(findTestData(testData).getValue('NAIC Division', rowNumber), false)) {
	KeywordUtil.logInfo('NAIC Division present ::' + findTestData(testData).getValue('NAIC Division', rowNumber))
}

if (WebUI.verifyTextPresent(findTestData(testData).getValue('Public/Private', rowNumber), false)) {
	KeywordUtil.logInfo('Public / Private  present ::' + findTestData(testData).getValue('Public/Private', rowNumber))
}

if (WebUI.verifyTextPresent('Approved', false)) {
	KeywordUtil.logInfo('Status  present ::' + 'Approved')
}

WebUI.switchToDefaultContent()

String reInsuredValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'Yes']),
	'value')

GenericUtils.verifyMatch('Reinsured Information check box value is ::', reInsuredValue, 'Yes', 'EQUAL')

String reinsuredSelectedValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue',
		[('dropDownName') : 'Reinsured']))

KeywordUtil.logInfo('reinsuredSelectedValue under drop down displayed is :: ' + reinsuredSelectedValue)

WebUI.click(findTestObject('Object Repository/Renewal/button_Continue'))

String brokerValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'Broker']),
	'value')

GenericUtils.verifyMatch('Broker check box value is ::', brokerValue, 'Broker', 'EQUAL')

WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue)

WebUI.switchToDefaultContent()

String brokerContactSelected = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue',
		[('dropDownName') : 'AgentId']))

KeywordUtil.logInfo('Broker Contact under drop down displayed is :: ' + brokerContactSelected)

WebUI.click(findTestObject('Object Repository/Renewal/button_Continue'))

WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue)

if (WebUI.verifyTextPresent(findTestData(testData).getValue('Class Type', rowNumber), false)) {
	KeywordUtil.logInfo('Class Type present ::' + findTestData(testData).getValue('Class Type', rowNumber))
}

if (WebUI.verifyTextPresent(findTestData(testData).getValue('Major Class', rowNumber), false)) {
	KeywordUtil.logInfo('Major Class present ::' + findTestData(testData).getValue('Major Class', rowNumber))
}

if (WebUI.verifyTextPresent(findTestData(testData).getValue('Placing Type', rowNumber), false)) {
	KeywordUtil.logInfo('Placing Type present ::' + findTestData(testData).getValue('Placing Type', rowNumber))
}

if (WebUI.verifyTextPresent(findTestData(testData).getValue('Sub Placing Type', rowNumber), false)) {
	KeywordUtil.logInfo('Placing Basis Value present ::' + findTestData(testData).getValue('Sub Placing Type', rowNumber))
}

if (WebUI.verifyTextPresent(findTestData(testData).getValue('Underwriter', rowNumber), false)) {
	KeywordUtil.logInfo('Underwriter present ::' + findTestData(testData).getValue('Underwriter', rowNumber))
}

if (WebUI.verifyTextPresent(findTestData(testData).getValue('Underwriting Assistant', rowNumber), false)) {
	KeywordUtil.logInfo('Underwriting Assistant Value present ::' + findTestData(testData).getValue('Underwriting Assistant',
			rowNumber))
}

if (WebUI.verifyTextPresent(findTestData(testData).getValue('Producing Team', rowNumber), false)) {
	KeywordUtil.logInfo('Producing Team present ::' + findTestData(testData).getValue('Producing Team', rowNumber))
}

if (WebUI.verifyTextPresent(findTestData(testData).getValue('Entity', rowNumber), false)) {
	KeywordUtil.logInfo('Entity Value Present is ::' + findTestData(testData).getValue('Entity', rowNumber))
}

if (WebUI.verifyTextPresent(findTestData(testData).getValue('Legal Branch', rowNumber), false)) {
	KeywordUtil.logInfo('Legal Branch Value Present is ::' + findTestData(testData).getValue('Legal Branch', rowNumber))
}

WebUI.switchToDefaultContent()

String inceptionDateValue = WebUI.getAttribute(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'),
	'value')

KeywordUtil.logInfo('inception Date Value: '+inceptionDateValue)

String expirationDateValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_FieldName', [('fieldName') : 'Expiry Date ']),
	'value')

KeywordUtil.logInfo('expiration Date Value: '+expirationDateValue)

String policyPeriodValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues',
		[('labelName') : 'Policy Period ']), 'value')

KeywordUtil.logInfo('policy Period Value: '+policyPeriodValue)
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), 180)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), 180)

WebUI.click(findTestObject('Object Repository/Renewal/button_Continue'))
String baseCurrencyValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue',
		[('dropDownName') : 'BaseCurrencyCode']))

KeywordUtil.logInfo('Original Currency Value displayed is :: ' + baseCurrencyValue)

String orderPercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue',
		[('labelName') : 'OrderPercent']), 'value')

KeywordUtil.logInfo('Order Percent Value displayed is :: ' + orderPercentValue)

String estimatedSigningPercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue',
		[('labelName') : 'EstimatedSigning']), 'value')

KeywordUtil.logInfo('Estimated Signing Percent Value displayed is :: ' + estimatedSigningPercentValue)

String writtenParticipationPercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue',
		[('labelName') : 'pTMHCCWrittenPartPercent']), 'value')

KeywordUtil.logInfo('Written Participation Percent Value displayed is :: ' + writtenParticipationPercentValue)

String commissionPercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue',
		[('labelName') : 'pCommissionPercentage']), 'value')

KeywordUtil.logInfo('Commission Percent Value displayed is :: ' + commissionPercentValue)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
	GlobalVariable.timeOutValue)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPremiumType'),
	'Original Premium', false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
	Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
	findTestData(testData).getValue('Layer Gross Premium', rowNumber))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_PremiumCalculate'))

String tmhccBrokerCommissionValueRenewed = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue',
		[('headerName') : 'TMHCC Broker Commission Amount']))

KeywordUtil.logInfo('TMHCC Broker Commission Renewed Value displayed is :: ' + tmhccBrokerCommissionValueRenewed)

String layerCommissionValueRenewed = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue',
		[('headerName') : 'Layer Broker Commission Amount']))

KeywordUtil.logInfo('Layer Broker Commission Renewed Value displayed is :: ' + layerCommissionValueRenewed)

WebUI.click(findTestObject('Object Repository/Dashboards/button_CompleteQuote'))

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

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Cyber War Exclusions']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Cyber War Exclusions']),
	findTestData(testData).getValue('Cyber Coverage', rowNumber), false)
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TacItRenewalDate'),
	Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TacItRenewalDate'),
	findTestData(testData).getValue('TacitRenewalDate2', rowNumber))
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	findTestData(testData).getValue('Tax code', rowNumber))

currentText =  findTestData(testData).getValue('Tax code', rowNumber).substring(0, findTestData(testData).getValue('Tax code', rowNumber).length()-1)

WebUI.setText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	currentText)

WebUI.mouseOver(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.enhancedClick(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']))
WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']),
	Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'PremiumPercentage']),
	findTestData(testData).getValue('Tax Premium', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
		Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
		testData).getValue('DueDate2', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
		Keys.TAB))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

//Status Validations to be added
uwQCStatus = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_UWQCStatus'))

GenericUtils.verifyMatch('UW QC Status is', uwQCStatus, 'To Be Approved', 'EQUAL')

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))
WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))

WebUI.callTestCase(findTestCase('Test Cases/SmokeModifications/259913_SubTestCase_Part1'), [('testData') : testData, ('rowNumber') : rowNumber, ('policyRef'):policyRef],
	FailureHandling.STOP_ON_FAILURE)

GlobalVariable.PolicyRef = GlobalVariable.RenewedPolicy

