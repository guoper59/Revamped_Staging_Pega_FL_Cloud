/**
 * ============================================================================
 * Test Case ID : 262224
 * Title         : Re Open NTU Quote TRI
 * Folder        : Scripts/Quote/262224_ReOpenNTUQuoteTRI
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

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable

String testData = 'CreateSubmission'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

String timeStamp = GenericUtils.getCurrentTimestamp()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('ebello', GlobalVariable.Ebello, findTestData(testData).getValue('Role', rowNumber))

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

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'),
	GlobalVariable.timeOutValue)

WebUI.callTestCase(findTestCase('Test Cases/TestData/262224_CreatePolicy'), [('testData') : testData , ('rowNumber') : rowNumber], FailureHandling.STOP_ON_FAILURE)

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

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TMHCCWrittenParticipation'),
	findTestData(testData).getValue('TMHCC Written Participation%', rowNumber))
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'), findTestData(
		testData).getValue('Layer AGG Limit', rowNumber))
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'),
	GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'),
	findTestData(testData).getValue('Commission', rowNumber))
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

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']),
	findTestData(testData).getValue('Territorial Scope', rowNumber), false)

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ApplicableLaw'), findTestData(
		testData).getValue('Applicable Law', rowNumber))
for (int i = 1; i < 2; i++) {
	WebUI.click(findTestObject('Object Repository/NewBusiness/button_AddItemTRI'))
	WebUI.setText(findTestObject('Object Repository/NewBusiness/webElement_DeMinimisField', [('attributeName') : 'De Minimis Amount'
				, ('fieldName') : i + '$pDeMinimisAmount']), deMinimisAmountList[(i - 1)])
	WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_DeMinimisField', [('attributeName') : 'De Minimis Details'
				, ('fieldName') : i + '$pDeMinimisDetails']))
	WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_DeMinimisField', [('attributeName') : 'De Minimis Details'
				, ('fieldName') : i + '$pDeMinimisDetails']), deMinimisDetailsList[(i - 1)])
}

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Maximum Limit Quoted']),
	findTestData(testData).getValue('Maximum Limit Quoted', rowNumber))
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_OtherCommisionAddItem'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_OtherCommisionAddItem'))
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Payable To']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Payable To']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Payable To']),
	findTestData(testData).getValue('Payable To', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Fee Type']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Fee Type']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Fee Type']),
	findTestData(testData).getValue('Fee Type', rowNumber), false)
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Fee %']),
	GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Fee %']), findTestData(
		testData).getValue('Fee%', rowNumber))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']),
	findTestData(testData).getValue('Territorial Scope', rowNumber), false)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Subjectivities']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Sublimit']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Deductibles']), GlobalVariable.timeoutShort)

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Applicable Jurisdiction'])).isEmpty()) {
	KeywordUtil.logInfo('Applicable Jurisdiction is empty')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Contract Start Date'])).isEmpty()) {
	KeywordUtil.logInfo('Contract Start Date is empty')
}

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Notes']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Additional Insureds']), GlobalVariable.timeoutShort)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'))

String qoutedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

//step 30 to 40

WebUI.click(findTestObject('Object Repository/Qoute/btn_NotTakeUpQuote'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Qoute/select_NotTakeUpReason'),
	findTestData(testData).getValue('NotTakeUpReason', rowNumber), false)
WebUI.sendKeys(findTestObject('Object Repository/Qoute/select_NotTakeUpReason'),
	findTestData(testData).getValue('NotTakeUpReason', rowNumber))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Qoute/select_NotTakenUpSubRationale'),
	findTestData(testData).getValue('SubRationale', rowNumber), false)
WebUI.sendKeys(findTestObject('Object Repository/Qoute/select_NotTakenUpSubRationale'),
	findTestData(testData).getValue('SubRationale', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Qoute/input_NotTakenUpDesc'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Qoute/input_NotTakenUpDesc'))
WebUI.sendKeys(findTestObject('Object Repository/Qoute/input_NotTakenUpDesc'), findTestData(
	testData).getValue('NotTakenUpDesc', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Qoute/btn_Submit'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Qoute/btn_Submit'))

WebUI.click(findTestObject('Object Repository/Qoute/btn_Submit'))
String NTUStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('NTU Status Value is', NTUStatus, 'NTU', 'EQUAL')

String caseID = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_CaseID'))

//added for non-interactive agent//////////////////////////////////
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector', [('tabName') : 'Closed Reasons']))

WebUI.click(findTestObject('Object Repository/Qoute/webElement_expandIcon', [('name') : '']))

WebUI.switchToFrame(findTestObject('Object Repository/Qoute/iframe_PegaGadget1Ifr'), GlobalVariable.timeoutShort)

WebUI.verifyTextPresent('Broker/Buyer lost business', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('NotTakeUpReason', rowNumber), false)

WebUI.switchToDefaultContent()

WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
		[('optionToSelect') : 'Submission Search']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Submission Search']))

//
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.PolicyRef)
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Actions'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Actions'))

WebUI.click(findTestObject('Object Repository/Qoute/btn_Modify'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Qoute/btn_CaptureQuoteDetails'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Qoute/btn_CaptureQuoteDetails'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Qoute/btn_ReOpen'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Qoute/btn_ReOpen'))

String openQuoteStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', openQuoteStatus, 'Open Quote', 'EQUAL')

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_UpdateTarget'), 25)

String openBoundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', openBoundStatus, 'Open Bound', 'EQUAL')

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']),
	findTestData(testData).getValue('UW Authority', rowNumber), false)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownCyberCoverage'),
	findTestData(testData).getValue('Cyber Coverage', rowNumber), false)
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownCyberCoverage'),
	findTestData(testData).getValue('Cyber Coverage', rowNumber))
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Completion Date']),
	GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Completion Date']), findTestData(
		testData).getValue('Completion Date', rowNumber))
WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Buyer']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Buyer']),
	findTestData(testData).getValue('BuyerCountry', rowNumber), false)
WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Seller']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Seller']),
	findTestData(testData).getValue('SellerCountry', rowNumber), false)
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Buyer']),
	GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Buyer']), findTestData(
		testData).getValue('Buyer', rowNumber))
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Seller']),
	GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Seller']), findTestData(
		testData).getValue('Seller', rowNumber))

WebUI.uncheck(findTestObject('Object Repository/NewBusiness/checkBox_EstimatedDate'))

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Working Status']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Working Status']),
	'Bound', false)
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_Comments', [('commentField') : 'Working Status Note']),
	'Test Test')

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Contract Start Date'])).isEmpty()) {
	KeywordUtil.logInfo('Contract Start Date is empty')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'External Policy Reference'])).isEmpty()) {
	KeywordUtil.logInfo('External Policy Reference is empty')
}

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckboxLabelBefore',
	[('labelName') : 'FAC Out Indicator']), GlobalVariable.timeoutShort)

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Primary Total Layer Limit'])).isEmpty()) {
	KeywordUtil.logInfo('Primary Total Layer Limit is empty')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Primary Total Layer Premium'])).isEmpty()) {
	KeywordUtil.logInfo('Primary Total Layer Premium is empty')
}

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), 25)

WebUI.clearText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), findTestData(testData).getValue('input_Lead',
	rowNumber))

String currentText =  findTestData(testData).getValue('input_Lead', rowNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]), GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_Comments', [('commentField') : 'Cyber Wording comments'])).isEmpty()) {
	KeywordUtil.logInfo('Cyber Wording comments section is empty')
}
String financialTypeText = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_FinancialTypeDefaultDropDown'))

GenericUtils.verifyMatch('Financial Type Value is', financialTypeText, 'Please Select...', 'EQUAL')

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'New Breach Date'])).isEmpty()) {
	KeywordUtil.logInfo('New Breach Date')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Retention Tipping Point'])).isEmpty()) {
	KeywordUtil.logInfo('Retention Tipping Point')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Retention Dropping Point'])).isEmpty()) {
	KeywordUtil.logInfo('Retention Dropping Point')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'SPA Title'])).isEmpty()) {
	KeywordUtil.logInfo('SPA Title')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Buyer Name'])).isEmpty()) {
	KeywordUtil.logInfo('Buyer Name')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Seller Name'])).isEmpty()) {
	KeywordUtil.logInfo('Seller Name')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Buyer NIF No.'])).isEmpty()) {
	KeywordUtil.logInfo('Buyer NIF No.')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Seller NIF No.'])).isEmpty()) {
	KeywordUtil.logInfo('Buyer NIF No.')
}

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
	GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
	findTestData(testData).getValue('Tax Applicable', rowNumber), false)
WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
		[('optionToSelect') : 'Surplus Lines Broker']))
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Broker Name']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Broker Name']),
	findTestData(testData).getValue('Broker Name', rowNumber), false)
String licenceState = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SelectedDropDownOption', [('dropDownName') : 'State']))

GenericUtils.verifyMatch('Licence State Value is', licenceState, expectedStateName, 'EQUAL')

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
		testData).getValue('Due Date', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
		Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 60)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'),
	GlobalVariable.timeOutValue)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
		[('optionToSelect') : 'Yes']), GlobalVariable.timeOutValue)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
	[('optionToSelect') : 'Yes']), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
		[('optionToSelect') : 'Yes']))
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))
WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']),
	10, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']))
WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Finalise'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_Finalise'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Finalise'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

WebUI.scrollToElement(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'),GlobalVariable.timeOutValue)

String signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', signedStatus, 'Signed', 'EQUAL')

String peerReview = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PeerReviewNumber'))

KeywordUtil.logInfo('Peer Review Case generate for this is : ' + peerReview)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))
WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))

WebUI.callTestCase(findTestCase('Test Cases/TestData/262224_UW_QualityCheck'), [('testData') : testData , ('rowNumber') : rowNumber], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/TestData/262224_PeerReviewCase'), [('testData') : testData , ('rowNumber') : rowNumber], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Eclipse/262224_EclipseValidation'), [('testData') : testData , ('rowNumber') : rowNumber], FailureHandling.STOP_ON_FAILURE)
