/**
 * ============================================================================
 * Test Case ID : 259909
 * Title         : Create Renewal Bureau Bordereau Facility BLD Lloyds4141 Part2
 * Folder        : Scripts/Renewals/259909_CreateRenewalBureauBordereauFacilityBLDLloyds4141_Part2
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

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

String testData = 'Renewals'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber for Test Data is: ' + rowNumber)

String testData1 = 'CreateSubmission'

//Finding Row number from Test Data.
int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

WebUI.comment('RowNumber1 for Test Data is: ' + rowNumber1)

GlobalVariable.PolicyRef = findTestData(testData).getValue('PolicyRef', rowNumber)

WebUI.openBrowser(null)

WebUI.maximizeWindow()

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
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Dashboard']))

WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Verifying Search Filter field names
List<WebElement> fieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFields'), 
    GlobalVariable.timeOutValue)

List<WebElement> fieldList = new ArrayList<String>()

for (WebElement f : fieldNames) {
    fieldList.add(f.getText())
}

GenericUtils.compareLists(fieldList, expectedList)

//Verifying Data Validation field names
List<WebElement> dataValidationFieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFieldsUnderDataValidation'), 
    GlobalVariable.timeOutValue)

List<WebElement> dataValidationFieldList = new ArrayList<String>()

for (WebElement f : dataValidationFieldNames) {
    dataValidationFieldList.add(f.getText())
}

GenericUtils.compareLists(dataValidationFieldList, expectedDataValidationList)

//Verifying Renewal field names
List<WebElement> renewalFieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfFieldsRenewal'), 
    GlobalVariable.timeOutValue)

List<WebElement> renewalFieldList = new ArrayList<String>()

for (WebElement j : renewalFieldNames) {
    renewalFieldList.add(j.getText())
}

GenericUtils.compareLists(renewalFieldList, expectedWorkFlowList)

WebUI.switchToDefaultContent()

WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_RenewalLinks', [('optionToSelect') : 'Renewal Work Basket']), 
    GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

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

if (WebUI.verifyTextPresent(findTestData(testData1).getValue('CoverHolderName', rowNumber1), false)) {
    KeywordUtil.logInfo('CoverHolder Name present ::' + findTestData(testData1).getValue('CoverHolderName', rowNumber1))
}

if (WebUI.verifyTextPresent(findTestData(testData1).getValue('VariousInsured', rowNumber1), false)) {
    KeywordUtil.logInfo('Various Insured Name present ::' + findTestData(testData1).getValue('VariousInsured', rowNumber1))
}

WebUI.switchToDefaultContent()

String reInsuredValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'No']), 
    'value')

GenericUtils.verifyMatch('Reinsured Information check box value is ::', reInsuredValue, 'No', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Renewal/button_Continue'))

String brokerValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'Broker']), 
    'value')

GenericUtils.verifyMatch('Broker check box value is ::', brokerValue, 'Broker', 'EQUAL')

WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue)

if (WebUI.verifyTextPresent(findTestData(testData1).getValue('Broker', rowNumber1), false)) {
    KeywordUtil.logInfo('Broker Name present ::' + findTestData(testData1).getValue('Broker', rowNumber1))
}

WebUI.switchToDefaultContent()

String brokerContactSelected = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'AgentId']))

KeywordUtil.logInfo('Broker Contact under drop down displayed is :: ' + brokerContactSelected)

WebUI.click(findTestObject('Object Repository/Renewal/button_Continue'))

WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue)

if (WebUI.verifyTextPresent(findTestData(testData1).getValue('Class Type', rowNumber1), false)) {
    KeywordUtil.logInfo('Class Type present ::' + findTestData(testData1).getValue('Class Type', rowNumber1))
}

if (WebUI.verifyTextPresent(findTestData(testData1).getValue('Major Class', rowNumber1), false)) {
    KeywordUtil.logInfo('Major Class present ::' + findTestData(testData1).getValue('Major Class', rowNumber1))
}

if (WebUI.verifyTextPresent(findTestData(testData1).getValue('Placing Type', rowNumber1), false)) {
    KeywordUtil.logInfo('Placing Type present ::' + findTestData(testData1).getValue('Placing Type', rowNumber1))
}

if (WebUI.verifyTextPresent(findTestData(testData1).getValue('Sub Placing Type', rowNumber1), false)) {
    KeywordUtil.logInfo('Placing Basis Value present ::' + findTestData(testData1).getValue('Sub Placing Type', rowNumber1))
}

if (WebUI.verifyTextPresent(findTestData(testData1).getValue('Underwriter', rowNumber1), false)) {
    KeywordUtil.logInfo('Underwriter present ::' + findTestData(testData1).getValue('Underwriter', rowNumber1))
}

if (WebUI.verifyTextPresent(findTestData(testData1).getValue('Underwriting Assistant', rowNumber1), false)) {
    KeywordUtil.logInfo('Underwriting Assistant Value present ::' + findTestData(testData1).getValue('Underwriting Assistant', 
            rowNumber1))
}

if (WebUI.verifyTextPresent(findTestData(testData1).getValue('Producing Team', rowNumber1), false)) {
    KeywordUtil.logInfo('Producing Team present ::' + findTestData(testData1).getValue('Producing Team', rowNumber1))
}

if (WebUI.verifyTextPresent(findTestData(testData1).getValue('Entity', rowNumber1), false)) {
    KeywordUtil.logInfo('Entity Value Present is ::' + findTestData(testData1).getValue('Entity', rowNumber1))
}

if (WebUI.verifyTextPresent(findTestData(testData1).getValue('Legal Branch', rowNumber1), false)) {
    KeywordUtil.logInfo('Legal Branch Value Present is ::' + findTestData(testData1).getValue('Legal Branch', rowNumber1))
}

WebUI.switchToDefaultContent()

String inceptionDateValue = WebUI.getAttribute(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_InceptionDate'), 
    'value')

GenericUtils.verifyMatch('Inception Date Value selected is', inceptionDateValue, renewedInceptionDateValue, 'EQUAL')

String expirationDateValue = WebUI.getAttribute(findTestObject('Object Repository/OutwardsPolicy/input_FieldName', [('fieldName') : 'Expiry Date ']), 
    'value')

GenericUtils.verifyMatch('Expirated Date Value selected is', expirationDateValue, renewedExpiryDateValue, 'EQUAL')

String policyPeriodValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Policy Period ']), 'value')

GenericUtils.verifyMatch('Policy Period Value is', policyPeriodValue, renewedPolicyPeriodValue, 'EQUAL')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

String uwAuthorityValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'pUWAuthorityOperator']))

KeywordUtil.logInfo('UW Authority Value displayed is :: ' + uwAuthorityValue)

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

String signedParticipationPercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'pTMHCCSignedPartPercent']), 'value')

KeywordUtil.logInfo('Signed Participation Percent Value displayed is :: ' + signedParticipationPercentValue)

String calculatedLinePercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'pCalculatedLinePercent']), 'value')

KeywordUtil.logInfo('Calculated Line Participation Percent Value displayed is :: ' + calculatedLinePercentValue)

String commissionPercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'pCommissionPercentage']), 'value')

KeywordUtil.logInfo('Commission Percent Value displayed is :: ' + commissionPercentValue)

String tmhccBrokerCommissionValueRenewed = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Broker Commission Amount']))

GenericUtils.verifyMatch('TMHCC Broker Commission Value is', tmhccBrokerCommissionValueRenewed, '0.00', 'EQUAL')

String layerCommissionValueRenewed = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'Layer Broker Commission Amount']))

GenericUtils.verifyMatch('Layer Commission Value is', layerCommissionValueRenewed, '0.00', 'EQUAL')

String tmhccGrossPremiumRenewed = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Gross Premium']))

GenericUtils.verifyMatch('TMHCC Gross Premium Value is', tmhccGrossPremiumRenewed, '0.00', 'EQUAL')

String tmhccNetPremiumRenewed = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Net Premium']))

GenericUtils.verifyMatch('TMHCC Net Premium Value is', tmhccNetPremiumRenewed, '0.00', 'EQUAL')

String layerGrossPremiumRenewed = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'Layer Gross Premium ']))

GenericUtils.verifyMatch('Layer Gross Premium Value is', layerGrossPremiumRenewed, '0.00', 'EQUAL')

String layerNetPremiumRenewed = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'Layer Net Premium ']))

GenericUtils.verifyMatch('Layer Net Premium Value is', layerNetPremiumRenewed, '0.00', 'EQUAL')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', 
        [('fieldToEnter') : labelName.get('brokerRefernce')]), findTestData(testData).getValue('BrokerReference', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', 
        [('fieldToEnter') : labelName.get('benchmarkLossRatio')]), Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', 
        [('fieldToEnter') : labelName.get('benchmarkLossRatio')]), findTestData(testData).getValue('SBF Benchmark Loss Ratio', 
        rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', 
        [('fieldToEnter') : 'pRiskAdjRateChangePercent']), riskAdjustedrateChangeValue)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', 
        [('fieldToEnter') : 'pRiskAdjRateChangePercent']), Keys.chord(Keys.TAB))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', 
        [('fieldToEnter') : 'pLimitAdjRateChangePercent']), riskDueToLimitChangeValue)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', 
        [('fieldToEnter') : 'pLimitAdjRateChangePercent']), Keys.chord(Keys.TAB))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', 
        [('fieldToEnter') : 'pCoverAdjRateChangePercent']), riskDueToCoverageChangeValue)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement', 
        [('fieldToEnter') : 'pCoverAdjRateChangePercent']), Keys.chord(Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    GlobalVariable.timeoutShort)

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

//Status Validations to be added
String uwQCStatus = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_UWQCStatus'))

GenericUtils.verifyMatch('UW QC Status is', uwQCStatus, 'To Be Approved', 'EQUAL')

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']), 
    10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/button_PostBindSettlement'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_PostBindSettlement'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_FinalisePolicy'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_FinalisePolicy'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_Proceed'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_Proceed'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Status', 
        [('status') : 'Written']), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Status', 
        [('status') : 'Written']), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/button_close'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))

//Logging in with Underwriter Assistant
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Abohle', GlobalVariable.Abohle, findTestData(testData).getValue('Role', rowNumber))

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Quality Check']))

WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/checkbox_ViewAllCases'))

//Filtering the policy
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_ClearFilter'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_SearchTextInFilter', [('fieldName') : 'Search Text']), 
    GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Apply'))

//Clicking on task link
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'))

WebUI.check(findTestObject('Object Repository/OutwardsPolicy/checkbox_UnderwriterDecision', [('optionToSelect') : 'Yes']))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Approve'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Approve'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))

//Logging in with Underwriter Assistant
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('sross', GlobalVariable.Sross, findTestData(testData).getValue('Role', rowNumber))

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Quality Check']))

WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/checkbox_ViewAllCases'))

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
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Submission Search']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Actions'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Actions'))

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_View'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_View'))

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector1', [('tabName') : 'Attachments']))

WebUI.executeJavaScript("document.body.style.zoom='60%'", null)

WebUI.waitForElementPresent(findTestObject('Object Repository/NewBusiness/webElement_AttachmentsName', [('attachmentName') : 'pdf']), 
    GlobalVariable.timeOutValue)

if (WebUI.waitForElementPresent(findTestObject('Object Repository/NewBusiness/webElement_AttachmentsName', [('attachmentName') : 'pdf']), 
    GlobalVariable.timeOutValue)) {
    KeywordUtil.markPassed('PDF Attachment is present')
}

if (WebUI.waitForElementPresent(findTestObject('Object Repository/NewBusiness/webElement_AttachmentsName', [('attachmentName') : 'QC Form Approved']), 
    GlobalVariable.timeOutValue)) {
    KeywordUtil.markPassed('Email Attachment is present')
}
WebUI.executeJavaScript("document.body.style.zoom='100%'", null)

//
////Verifying if Order Form is available in the attachment
//
//
//
//
//

WebUI.waitForElementClickable(findTestObject('Object Repository/Renewal/Page_Pega Case Manager Portal/button_ExpandItems'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_DynamicTabSelector', [('tabName') : 'Quality Checks']))
//Verifying if Order Form is available in the attachment

WebUI.callTestCase(findTestCase('Test Cases/Eclipse/259909_EclipseValidation'), [('testData') : testData, ('rowNumber') : rowNumber], 
    FailureHandling.STOP_ON_FAILURE)