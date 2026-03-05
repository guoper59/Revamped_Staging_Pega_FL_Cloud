/**
 * ============================================================================
 * Test Case ID : 262217
 * Title         : Create Policy Period Change Endorsement Sub Test Case Part1
 * Folder        : Scripts/Endorsements/262217_CreatePolicyPeriodChangeEndorsement_SubTestCase_Part1
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
import com.testdata.helper.Endorsements

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject


//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Quality Check']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/checkbox_ViewAllCases'))

//Filtering the policy
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_PolicyFilter'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_PolicyFilter'))


WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_ClearFilter'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_SearchTextInFilter', [('fieldName') : 'Search Text']),
	GlobalVariable.PolicyRef)


WebUI.click(findTestObject('Object Repository/NewBusiness/button_Apply'))


//Clicking on task link
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_TaskLink'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_TaskLink'))


WebUI.check(findTestObject('Object Repository/NewBusiness/checkbox_UnderwriterDecision', [('optionToSelect') : 'Yes']))

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_Approve'), 10)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Approve'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Close'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Close'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_TaskLink'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_TaskLink'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Complete'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Complete'))


WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_SuccessMessage'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)


WebUI.click(findTestObject('Object Repository/NewBusiness/button_Close'))


WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Clicking Submission Search/Creation from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Submission Search']))


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownYearsofAccount1'), 25)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownYearsofAccount1'))

//Selects an option in a dropdown menu by Years of Account
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownYearsofAccount1'), 
    'Unknown', false)

WebUI.scrollToElement(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch1'), 25)

// Enters the value in the policy reference field on the Pega Case Manager Portal
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference1'))
WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference1'), GlobalVariable.PolicyRef)


// Click on the search button in the Pega Case Manager Portal.
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch1'))


//Get the text from a web element on the page and stores it in a variable/
String policyQuote = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation1', 
        [('fieldName') : 'Policy Reference']), FailureHandling.STOP_ON_FAILURE)

// Verify if the actual policy reference matches with the expected policy quote.

WebUI.click(findTestObject('Object Repository/SubmissionSearch/button_Actions1'))


WebUI.click(findTestObject('Object Repository/Endorsements/button_CreateEndorsement1'))


WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown1', [('dropDownLabel') : 'Endorsement Requested By']), 
    endorsementRequestBy, false)


WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown1', [('dropDownLabel') : 'Endorsement Type']), 
    endorsementType, false)


WebUI.sendKeys(findTestObject('Object Repository/Endorsements/input_FieldName1', [('fieldName') : 'Endorsement Inception Date ']), 
    endorsementInceptionDate)


WebUI.clearText(findTestObject('Object Repository/Endorsements/input_FieldName1', [('fieldName') : 'Endorsement Expiry Date ']))
WebUI.sendKeys(findTestObject('Object Repository/Endorsements/input_FieldName1', [('fieldName') : 'Endorsement Expiry Date ']), 
    endorsementExpiryDate)


WebUI.click(findTestObject('Object Repository/Endorsements/text_CommentsSection1', [('commentField') : 'Endorsement Notes']))
WebUI.sendKeys(findTestObject('Object Repository/Endorsements/text_CommentsSection1', [('commentField') : 'Endorsement Notes']), 
    endorsementNote)
WebUI.click(findTestObject('Object Repository/Endorsements/text_CommentsSection1', [('commentField') : 'Endorsement Notes']))
WebUI.sendKeys(findTestObject('Object Repository/Endorsements/text_CommentsSection1', [('commentField') : 'Endorsement Notes']), 
    endorsementNote)


WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue1'))


Endorsements.verifyEndorsementFields(GlobalVariable.insuredName, testData, rowNumber)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown1', [('dropDownLabel') : 'Insured Persons']), 
    insuredPersons, false)


WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue1'))


WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue1'))


WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue1'))


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Label', [('fieldName') : 'The Expiry Date will be updated with the Endorsement Expiry Date. Please manually amend the Expiry Date if you do not want this change to apply']), 
    60)

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_ContinueText'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_CompleteQuote1'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_CompleteQuote1'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote1'))


//TODO: 540274: Remove the Quote Doc and Broker Bind Doc stage from the Pega data entry workflow


////Click on takeup the quote.
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote1'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote1'), 25)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote1'))
//TODO: 540276 Generate a Quote Letter document and to Take Up a Quote version to the Bind stage to be amended and moved to the Underwriting stage
WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_QuoteCheckbox'), 25)
WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_QuoteCheckbox'))
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote1'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote1'), 25)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote1'))


String Status = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status1'))

GenericUtils.verifyMatch('Endorsement Status is', Status, 'Open Bound', 'EQUAL')

WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : 'The Expiry Date has been updated with the Endorsement Expiry Date. Please manually amend the Expiry Date if you do not want this change to apply.']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue1'))


WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue1'), FailureHandling.OPTIONAL)


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : 'The Expiry Date has been updated with the Endorsement Expiry Date. Please manually amend the Expiry Date if you do not want this change to apply.']), 
    GlobalVariable.timeoutShort)

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_DueDate'), endorsementInstallmentDueDate)
WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_DueDate'), Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments1'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments1'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments1'))


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/btn_CreateUnderwriting'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/btn_CreateUnderwriting'))


WebUI.enhancedClick(findTestObject('Object Repository/Endorsements/CancelEndorsement/radio_DynamicRadioButton', [('radioButtonLabel') : 'Yes']))


WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Submit'))


//Clicks on a button to initiate contract certainty.
WebUI.click(findTestObject('Object Repository/UWWorksheet/btn_InitiateContractCertanity'))


WebUI.selectOptionByLabel(findTestObject('Object Repository/UnderwritingWorksheet/select_DropdownPolicySlipInsurance'), 
    policySlipOption, false)

WebUI.waitForPageLoad(GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/checkBox_SelectYesContract'))


// Click on a button to save the form in a web application.
WebUI.click(findTestObject('Object Repository/UnderwritingWorksheet/btn_Save'))


String successMessage = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SuccessMessage3'))

//Click on the close button at the top of the page
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_CloseContractCertainty1'), 25)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_CloseContractCertainty1'))

WebUI.click(findTestObject('Object Repository/NewBusiness/button_CloseContractCertainty1'), FailureHandling.OPTIONAL)

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_CaseContentOptions', [('linkToClick') : 'Post Bind']), 
    30, FailureHandling.STOP_ON_FAILURE)

//Click on a link within the case content options.
WebUI.click(findTestObject('Object Repository/Dashboards/webElement_CaseContentOptions', [('linkToClick') : 'Post Bind']))



WebUI.waitForElementVisible(findTestObject('Object Repository/Endorsements/button_SubmitPostBind'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Endorsements/button_SubmitPostBind'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt1'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed1'))


//Click on the close button at the top of the page
WebUI.click(findTestObject('Object Repository/Endorsements/button_CloseTop'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))


//Logging in with Underwriter Assistant
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('SSchroeder', GlobalVariable.SSchroeder, findTestData(testData).getValue('Role', rowNumber))
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Quality Check']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/checkbox_ViewAllCases'))

//Filtering the policy
WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/webElement_PolicyFilter'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Endorsements/webElement_PolicyFilter'))


WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_ClearFilter'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_SearchTextInFilter', [('fieldName') : 'Search Text']), 
    GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Apply'))


//Clicking on task link
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'))
WebUI.check(findTestObject('Object Repository/OutwardsPolicy/checkbox_UnderwriterDecision', [('optionToSelect') : 'Yes']))
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Approve'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Approve'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Close'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))


//Logging in with Underwriter Assistant
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData).getValue('Role', rowNumber))
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.executeJavaScript("document.body.style.zoom='60%'", null)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Quality Check']))

WebUI.executeJavaScript("document.body.style.zoom='100%'", null)
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/checkbox_ViewAllCases'))
//Filtering the policy
WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/webElement_PolicyFilter'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Endorsements/webElement_PolicyFilter'))


WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_ClearFilter'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_SearchTextInFilter', [('fieldName') : 'Search Text']), 
    GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Apply'))


//Clicking on task link
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'))


WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Complete'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Complete'))


WebUI.verifyElementPresent(findTestObject('Object Repository/OutwardsPolicy/webElement_SuccessMessage'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)


WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))

//Calling Get API to validate response---SBS ECLIPSE
ResponseObject response = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetProgramPackage'), null)

//Verify all endorsement details in response
String ENumber = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].EndorsementNumber')

WebUI.comment(ENumber)

KeywordUtil.logInfo('Endorsement Number value is ::' + ENumber)

GenericUtils.verifyMatch('Endorsement Number Value is ', ENumber, '1', 'EQUAL')

String EDate = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].EffectiveDate')

Date date = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss').parse(EDate)

String effectiveDate = new SimpleDateFormat('dd/MM/yyyy').format(date)

WebUI.comment(effectiveDate)

KeywordUtil.logInfo('Effective Date value is ::' + effectiveDate)

GenericUtils.verifyMatch('Verify Effective Date is ::', effectiveDate, findTestData(testData).getValue('Inception Date', 
        rowNumber), 'EQUAL')

String EStatus = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].EndorsementStatus')

WebUI.comment(EStatus)

KeywordUtil.logInfo('Endorsement Status value is ::' + EStatus)

GenericUtils.verifyMatch('Endorsement Status Value is ', EStatus, 'Closed', 'EQUAL')

String EType = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].Type')

WebUI.comment(EType)

GenericUtils.verifyMatch('Endorsement Type Value is ', EType, 'POL', 'EQUAL')

String ENotes = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].Notes')

WebUI.comment(ENotes)

KeywordUtil.logInfo('Notes value is ::' + ENotes)

GenericUtils.verifyMatch('Endorsement Notes Value is ', ENotes, 'test test test testtest test test test', 'EQUAL')