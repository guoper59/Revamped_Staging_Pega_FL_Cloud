/**
 * ============================================================================
 * Test Case ID : 300728
 * Title         : Sub Test Case Part1
 * Folder        : Scripts/Endorsements/300728_SubTestCasePart1
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
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable as GlobalVariable

String testData = 'Endorsements'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

//Logging in with Underwriter Assistant
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Hbakker', GlobalVariable.Hbakker, findTestData(testData).getValue('Role', rowNumber))
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Peer Review']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

//checkbox not coming

//Filtering the policy
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_PolicyReferenceFilter'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_PolicyReferenceFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_ClearFilterPeerReview'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_SearchTextPeerReview', [('fieldName') : 'Search Text']),
	GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_ApplyPeerReview'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_TaskID'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_TaskID'))

WebUI.check(findTestObject('Object Repository/NewBusiness/checkBox_SelectedResult'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Underwriter Reviewer']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Underwriter Reviewer']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Underwriter Reviewer']),
	underWriterName, false)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_DynamicTextPeerReview', [('buttonName') : 'Assign for Peer Review']))

String peerReviewSuccessMessage = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PeerReviewSuccessMessage'))

GenericUtils.verifyMatch('Peer Review Assignee Message', peerReviewSuccessMessage, 'Selected tasks have been assigned successfully',
	'EQUAL')

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))

//Logging in with Underwriter Assistant
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('abohle', GlobalVariable.Abohle, findTestData(testData).getValue('Role', rowNumber))
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Peer Review']))

//Filtering the policy
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_PolicyReferenceFilter'), GlobalVariable.timeOutValue)

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/webElement_PolicyReferenceFilter'), 5)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_PolicyReferenceFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_ClearFilterPeerReview'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_SearchTextPeerReview', [('fieldName') : 'Search Text']),
	GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_ApplyPeerReview'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_TaskID'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_TaskID'))

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'Peer Review Completed - Fully Agree With Rationale']),
	GlobalVariable.timeOutValue)) {
	KeywordUtil.markPassed('Fully Agree with Rationale radio button is visible')
}

if (WebUI.verifyElementPresent(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'Peer Review Completed - Reserve on Rationale']),
	GlobalVariable.timeOutValue)) {
	KeywordUtil.markPassed('Reserve on Rationale radio button is visible')
}

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/text_CommentsSection', [('commentField') : 'Comments']), 'Test test test')

WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/input_FullyAgree'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/button_Submit'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Submit'))

String underWriterSuccessMessage = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_SuccessMessage'))

GenericUtils.verifyMatch('Success Message displayed is ', underWriterSuccessMessage, 'Your action has been completed.',
	'EQUAL')

WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))

//Logging in with Underwriter Assistant
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
		[('optionToSelect') : 'Submission Search']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Submission Search']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Actions'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Actions'))

WebUI.click(findTestObject('Object Repository/Endorsements/button_CreateEndorsement'))

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

KeywordUtil.logInfo('Endorsement Inception Date is :: ' + endorsmentInceptionDate)

String endorsmentExpiryDate = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/input_FieldName', [('fieldName') : 'Endorsement Expiry Date ']), 
    'value')

KeywordUtil.logInfo('Endorsement Expiry Date is :: ' + endorsmentExpiryDate)

String endorsmentPeriod = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_ReadDynamicValues', [('headerName') : 'Endorsement Period']))

KeywordUtil.logInfo('Endorsement Period is :: ' + endorsmentPeriod)

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'Yes']), 
    10)

WebUI.verifyElementChecked(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'Yes']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

String country = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'Country']))

KeywordUtil.logInfo('Country Name Displayed is :: ' + country)

String brokerContactNameInsuredDetails = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'AgentId']))

KeywordUtil.logInfo('Broker Contact Name Displayed is :: ' + brokerContactNameInsuredDetails)

String selectedBroker = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadBrokerSelectedAutoComplete'), 
    'value')

KeywordUtil.logInfo('Selected Broker is :: ' + selectedBroker)

WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/button_Continue'), 180)

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/button_Continue'), 180)
WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Premium Type']), 180)

WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Premium Type']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Premium Type']), 
    findTestData(testData).getValue('EndorsementType', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/input_FieldName', [('fieldName') : 'Layer Gross Premium ']), 
    findTestData(testData).getValue('EndorsementGrossPremium', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/input_FieldName', [('fieldName') : 'Layer Gross Premium ']), 
    Keys.chord(Keys.TAB))

String tmhccGrossPremiumEndorsement = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_ReadPremiumInformationValues_Span', 
        [('headerName') : 'TMHCC Gross Premium']))

GenericUtils.verifyMatch('TMHCC Gross Premium Value is', tmhccGrossPremiumEndorsement, '0.01', 'EQUAL')

String tmhccNetPremiumEndorsement = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_ReadPremiumInformationValues_Span', 
        [('headerName') : 'TMHCC Net Premium']))

GenericUtils.verifyMatch('TMHCC Net Premium Value is', tmhccNetPremiumEndorsement, '0.01', 'EQUAL')

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/button_CompleteQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/button_CompleteQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Endorsements/button_CompleteQuote'))

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

String openBoundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', openBoundStatus, 'Open Bound', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

String taxApplicable = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [
            ('dropDownName') : 'TaxApplicable']))

KeywordUtil.logInfo(taxApplicable)

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

WebUI.enhancedClick(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'No']))

WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Reason for not sending the Underwriting Quality Check']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Reason for not sending the Underwriting Quality Check']), 
    findTestData(testData).getValue('Reason', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/text_CommentsSection', [('commentField') : 'Comments']), 'Test test test test')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))

//Status Validations to be added
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_InitiateContractCertanity'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/btn_Save1'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Documentation/btn_Save1'), 25)
WebUI.click(findTestObject('Object Repository/Documentation/btn_Save1'))

WebUI.scrollToElement(findTestObject('Object Repository/Documentation/btn_Submit1'), 25)
WebUI.click(findTestObject('Object Repository/Documentation/btn_Submit1'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Finalise'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Finalise'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

String signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', signedStatus, 'Signed', 'EQUAL')

//
//
////Verifying Data Validation field names
//
//
//
//
//
//
//
//
//
//
//
////Verifying Data Validation field names
//
//
//
//
//
//
//
//
//
////GenericUtils.compareLists(actualEndorsementTableValues, expectedValues)
//

//
//
//
