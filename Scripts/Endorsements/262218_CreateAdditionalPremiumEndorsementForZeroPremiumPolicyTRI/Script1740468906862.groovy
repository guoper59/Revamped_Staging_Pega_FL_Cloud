/**
 * ============================================================================
 * Test Case ID : 262218
 * Title         : Create Additional Premium Endorsement For Zero Premium Policy TRI
 * Folder        : Scripts/Endorsements/262218_CreateAdditionalPremiumEndorsementForZeroPremiumPolicyTRI
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

import java.text.SimpleDateFormat

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable

String testData = 'Endorsements'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

String timeStamp = GenericUtils.getCurrentTimestamp()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'(findTestData(testData).getValue('UserName', rowNumber),
	findTestData(testData).getValue('Password', rowNumber), findTestData(testData).getValue('Role', rowNumber))

String PolicyRef = WebUI.callTestCase(findTestCase('Test Cases/TestData/259900_CreateTRIPolicy'), [('testData') : testData
	, ('rowNumber') : rowNumber], FailureHandling.STOP_ON_FAILURE)

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

for (int i = 1; i < 11; i++) {
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

if (WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
		[('labelName') : 'Subjectivities']), GlobalVariable.timeoutShort)) {
	KeywordUtil.logInfo('Subjectivities tick box is NOT checked')
}

if (WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
		[('labelName') : 'Notes']), GlobalVariable.timeoutShort)) {
	KeywordUtil.logInfo('Notes tick box is NOT checked')
}

if (WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
		[('labelName') : 'Additional Insureds']), GlobalVariable.timeoutShort)) {
	KeywordUtil.logInfo('Additional Insureds tick box is NOT checked')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Applicable Jurisdiction'])).isEmpty()) {
	KeywordUtil.logInfo('Applicable Jurisdiction is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Contract Start Date'])).isEmpty()) {
	KeywordUtil.logInfo('Contract Start Date is empty')
}

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'))

WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'))

String quotedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', quotedStatus, 'Quoted', 'EQUAL')

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_UpdateTarget'), GlobalVariable.timeOutValue)

String openBoundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', openBoundStatus, 'Open Bound', 'EQUAL')

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']),
	findTestData(testData).getValue('UW Authority', rowNumber), false)

for (int i = 1; i < 3; i++) {
	WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_OtherCommisionAddItem'), GlobalVariable.timeOutValue)

	WebUI.click(findTestObject('Object Repository/NewBusiness/button_OtherCommisionAddItem'))

	WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues',
			[('headerName') : 'Payable To', ('fieldName') : i + '$ppyNote']), GlobalVariable.timeOutValue)

	WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', [('headerName') : 'Payable To'
				, ('fieldName') : i + '$ppyNote']))

	WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', [('headerName') : 'Payable To'
				, ('fieldName') : i + '$ppyNote']), payableToList[(i - 1)], false)

	WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues',
			[('headerName') : 'Fee Type', ('fieldName') : i + '$pFeeType']), GlobalVariable.timeOutValue)

	WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', [('headerName') : 'Fee Type'
				, ('fieldName') : i + '$pFeeType']))

	WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionFieldValues', [('headerName') : 'Fee Type'
				, ('fieldName') : i + '$pFeeType']), feeTypeList[(i - 1)], false)
}

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

String leadName = WebUI.getAttribute(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), 'value')

KeywordUtil.logInfo('Lead Value: ' +leadName)

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_TMHCCLeadIndicator'), GlobalVariable.timeOutValue)

WebUI.clearText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_Lead'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_Lead'), findTestData(
	testData).getValue('input_Lead', rowNumber))

WebUI.click(findTestObject('Object Repository/Endorsements/match_Lead'))

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'FAC Out Indicator']), GlobalVariable.timeoutShort)

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Applicable Jurisdiction'])).isEmpty()) {
	KeywordUtil.logInfo('Applicable Jurisdiction is empty')
}

if(WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'External Policy Reference'])).isEmpty()) {
	KeywordUtil.logInfo('External Policy Reference is empty')
}

String retentionValue = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Retention as % of Enterprise Value']),
	'value')

GenericUtils.verifyMatch('Retention Percent Value is', retentionValue, '0.00000', 'EQUAL')

String spaValue = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'SPA Date']),
	'value')

GenericUtils.verifyMatch('SPA Value is', spaValue, findTestData(testData).getValue('Inception Date', rowNumber), 'EQUAL')

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Notes']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox',
	[('labelName') : 'Additional Insureds']), GlobalVariable.timeoutShort)

String financialTypeText = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_FinancialTypeDefaultDropDown'))

GenericUtils.verifyMatch('Financial Type Value is', financialTypeText, 'Please Select...', 'EQUAL')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
	GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
	findTestData(testData).getValue('Tax Applicable', rowNumber), false)

WebUI.check(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
		[('optionToSelect') : 'Surplus Lines Broker']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Broker Name']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Broker Name']),
	findTestData(testData).getValue('Broker Name', rowNumber), false)

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

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
		[('optionToSelect') : 'Yes']), GlobalVariable.timeOutValue)

WebUI.check(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation',
		[('optionToSelect') : 'Yes']))

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))

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

GenericUtils.verifyMatch('Status Value is', signedStatus, 'Signed', 'EQUAL')

String peerReview = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PeerReviewNumber'))

KeywordUtil.logInfo('Peer Review Case generate for this is : ' + peerReview)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))

//Loggging in with Underwriter
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'(findTestData(testData).getValue('UnderwriterUserName',
		rowNumber), findTestData(testData).getValue('Password', rowNumber), 'Underwriter')
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
	[('optionToSelect') : 'UW/Fac RI Quality Check']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'UW/Fac RI Quality Check']))

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
WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
	[('optionToSelect') : 'UW/Fac RI Quality Check']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'UW/Fac RI Quality Check']))

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

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), 60, FailureHandling.STOP_ON_FAILURE)

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

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Layer Fee Amount']),
	GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Layer Fee Amount']), findTestData(
		testData).getValue('LayerFeeAmount', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'))

String quotedStatus1 = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', quotedStatus1, 'Quoted', 'EQUAL')

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote'))

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

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Finalise'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Finalise'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

String signedStatus1 = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', signedStatus1, 'Signed', 'EQUAL')

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

String endorsementNumber = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_EndorsementNumber2', [('attributeName') : 'Endorsement Number', ('version') : 1]))
return endorsementNumber

WebUI.callTestCase(findTestCase('Test Cases/Eclipse/262218_EclipseValidation'), [('testData') : testData, ('rowNumber') : rowNumber],
	FailureHandling.STOP_ON_FAILURE)

		