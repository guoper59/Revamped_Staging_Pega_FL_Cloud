/**
 * ============================================================================
 * Test Case ID : 262185
 * Title         : Sub Test Case Part1
 * Folder        : Scripts/Worksheets/262185_SubTestCase_Part1
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
import java.text.SimpleDateFormat as SimpleDateFormat
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.login.helper.LoginHelper as LoginHelper
import com.submission.helper.SubmissionHelper as SubmissionHelper
import com.testdata.helper.UWWorksheet as UWWorksheet
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBaseCurrencyCode'),
	currencyType, false)
WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TMHCCWrittenParticipation'),
	TMHCCWrittenParticipation)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerPosition'), LayerPosition)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerEELLimit'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerEELLimit'), LayerEELLimit)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'), LayerAGGLimit)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ExcessLimit'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ExcessLimit'), ExcessLimit)


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'),
	Commission)


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'))


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
	Keys.chord(Keys.CONTROL, 'a'))


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
	Keys.chord(Keys.CONTROL, 'a'))


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
	LayerGrossPremium)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_PremiumCalculate'))


WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTerritorialScope'),
	TerritorialScope, false)

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ApplicableLaw'), ApplicableLaw)


//Click on complete the quote.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CompleteQuote'))

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


WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'),
	UWAuthority, false)


WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'),
	IsTacitRenewal, false)


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TacItRenewalDate'),
	tacitRenewalDate)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownCyberCoverage'),
	CyberCoverage, false)


WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown',
		[('dropDownLabel') : 'ADR Exposure ']), ADRExposure, false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LocalMarketCap'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LocalMarketCap'), LocalMarketCap)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_EntitysTotalAsset'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_EntitysTotalAsset'),
	EntitysTotalAssets)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_PolicyHolderTurnover'))
WebUI.waitForPageLoad(GlobalVariable.timeoutShort)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_PolicyHolderTurnover'),
	FeeIncome)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'))


WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_CryptoExposure'),
	'Yes', false)


//Click on continue.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

//Click On Continue button


WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
	TaxApplicable, false)


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), DueDate)
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
		Keys.TAB))

//Double clicks on a button to generate installments.

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

 
//Waits for a button to be clickable, then clicks on it to create underwriting.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))


//Clicks on a button to initiate contract certainty.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_InitiateContractCertanity'))
//Waits for a dropdown menu to be clickable, selects an option based on test data.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPolicySlipInsurance'),
	GlobalVariable.timeOutValue)

//Clicks on the dropdown element specified by the test object.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPolicySlipInsurance'))
//Selects an option with the label retrieved from the test data at the specified row.
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPolicySlipInsurance'),
	PolicySlip, false)


WebUI.click(findTestObject('Object Repository/NewBusiness/checkBox_SelectYesContract'))
// Click on a button to save the form in a web application.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Save'))


int maxRetries = 20;
int retryCount = 0;

while(WebUI.verifyElementPresent(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_ContractCertainityErrorMessage'),
					GlobalVariable.timeOutValue, FailureHandling.OPTIONAL) && (retryCount < maxRetries)) {

	WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_InitiateContractCertanity1'), GlobalVariable.timeoutShort)
	WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_InitiateContractCertanity1'))
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPolicySlipInsurance'),
			findTestData(testData).getValue('PolicySlip', rowNumber), false)

	WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Save'), GlobalVariable.timeoutShort)
	WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Save'))
	retryCount++;
	
}

//Click on the close button at the top of the page
WebUI.click(findTestObject('Object Repository/NewBusiness/button_CloseContractCertainty'))
//Click on the close button at the top of the page
WebUI.click(findTestObject('Object Repository/NewBusiness/button_CloseContractCertainty'),  FailureHandling.OPTIONAL)
// Wait for a specific element related to case content options to be visible within 10 seconds.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions',
		[('linkToClick') : 'Bind Policy']), 30, FailureHandling.STOP_ON_FAILURE)

//Click on a link within the case content options.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions', [('linkToClick') : 'Bind Policy']))
// Wait for the finalise policy button to be visible based on a specified timeout value.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

//Click on the finalise policy button.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'))
// Wait for the 'Finalise Policy' prompt to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Click on the 'Proceed' button.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))
//Clicking Dashboard option from left side menu
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Quality Check']))


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/checkbox_ViewAllCases'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_PolicyFilter'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_PolicyFilter'))
WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_ClearFilter'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_SearchTextInFilter', [('fieldName') : 'Search Text']),
	policyRef)


WebUI.click(findTestObject('Object Repository/NewBusiness/button_Apply'))
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_TaskLink'), GlobalVariable.timeoutShort)


WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_TaskLink'))

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectYesContract'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Approve'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Approve'))


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_CloseTop'))

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_TaskLink'))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_Complete'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Complete'))


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_SuccessMessage1'), GlobalVariable.timeoutShort,
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_CloseTop'))

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
		[('optionToSelect') : 'Submission Search']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Submission Search']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference1'), GlobalVariable.timeoutShort,
	FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference1'), policyRef)
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch1'))
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Actions'))
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_CreateEndorsement'))


WebUI.selectOptionByLabel(findTestObject('Object Repository/UnderwritingWorksheet/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Requested By']),
	endorsementRequestBy, false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/UnderwritingWorksheet/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Type']),
	endorsementType, false)
WebUI.sendKeys(findTestObject('Object Repository/UnderwritingWorksheet/input_FieldName', [('fieldName') : 'Endorsement Inception Date ']),
	endorsementInceptionDate)
WebUI.sendKeys(findTestObject('Object Repository/UnderwritingWorksheet/input_FieldName', [('fieldName') : 'Endorsement Expiry Date ']),
	endorsementExpiryDate)
WebUI.sendKeys(findTestObject('Object Repository/UnderwritingWorksheet/text_CommentsSection', [('commentField') : 'Endorsement Notes']),
	endorsementNote)
WebUI.click(findTestObject('Object Repository/UWWorksheet/link_PostBind'))

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_DueDate'), DueDate)
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_DueDate'), Keys.chord(Keys.TAB))


//Double clicks on a button to generate installments.

WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/btn_GenerateInstallments'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/btn_GenerateInstallments'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/UWWorksheet/btn_GenerateInstallments'))


//Waits for a button to be clickable, then clicks on it to create underwriting.
WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/btn_CreateUnderwriting'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/btn_CreateUnderwriting'))


//Clicks on a button to initiate contract certainty.
WebUI.click(findTestObject('Object Repository/UWWorksheet/btn_InitiateContractCertanity'))
//Waits for a dropdown menu to be clickable, selects an option based on test data.
WebUI.waitForElementClickable(findTestObject('Object Repository/UnderwritingWorksheet/select_DropdownPolicySlipInsurance'),
	GlobalVariable.timeOutValue)

//Clicks on the dropdown element specified by the test object.
WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/select_DropdownPolicySlipInsurance'))
//Selects an option with the label retrieved from the test data at the specified row.
WebUI.selectOptionByLabel(findTestObject('Object Repository/UnderwritingWorksheet/select_DropdownPolicySlipInsurance'),
	PolicySlip, false)

// Click on a button to save the form in a web application.
WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/btn_Save'))


maxRetries = 20;
retryCount = 0;

while(WebUI.verifyElementPresent(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_ContractCertainityErrorMessage'),
					GlobalVariable.timeOutValue, FailureHandling.OPTIONAL) && (retryCount < maxRetries)) {

	WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_InitiateContractCertanity1'), GlobalVariable.timeoutShort)
	WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_InitiateContractCertanity1'))
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPolicySlipInsurance'),
			findTestData(testData).getValue('PolicySlip', rowNumber), false)

	WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Save'), GlobalVariable.timeoutShort)
	WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Save'))
	retryCount++;
	
}


//Click on the close button at the top of the page
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_CloseTop'))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Bind'))


WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
		[('optionToSelect') : 'Submission Search']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)


//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Submission Search']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.clearText(findTestObject('Object Repository/SubmissionSearch/input_PolicyReference1'))


WebUI.sendKeys(findTestObject('Object Repository/SubmissionSearch/input_PolicyReference1'), GlobalVariable.PolicyRef)


WebUI.click(findTestObject('Object Repository/SubmissionSearch/btn_SubmissionSearch1'))
WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_Actions1'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Actions1'))
WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_ViewFinal'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_ViewFinal'))
