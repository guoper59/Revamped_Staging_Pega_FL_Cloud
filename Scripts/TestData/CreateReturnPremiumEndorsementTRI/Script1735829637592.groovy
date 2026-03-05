/**
 * ============================================================================
 * Title        : CreateReturnPremiumEndorsementTRI
 * Title         : CreateReturnPremiumEndorsementTRI
 * Folder        : Scripts/TestData/CreateReturnPremiumEndorsementTRI
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

String testData = 'Endorsements'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'))
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

KeywordUtil.logInfo('Endorsement Inception Date is :: '+endorsmentInceptionDate)

String endorsmentExpiryDate = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/input_FieldName', [('fieldName') : 'Endorsement Expiry Date ']), 
    'value')

KeywordUtil.logInfo('Endorsement Expiry Date is :: '+endorsmentExpiryDate)

String endorsmentPeriod = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_ReadDynamicValues', [('headerName') : 'Endorsement Period']))

KeywordUtil.logInfo('Endorsement Period is :: '+endorsmentPeriod)

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'Yes']), 10)
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'Yes']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

String country = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'Country']))

KeywordUtil.logInfo('Country Name Displayed is :: '+country)

String brokerContactNameInsuredDetails = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'AgentId']))

KeywordUtil.logInfo('Broker Contact Name Displayed is :: '+brokerContactNameInsuredDetails)

String selectedBroker = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadBrokerSelectedAutoComplete'), 
    'value')

KeywordUtil.logInfo('Selected Broker is :: '+selectedBroker)
WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/button_Continue'), 10)
WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/button_Continue'), 10)
WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Premium Type']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Premium Type']), 
    findTestData(testData).getValue('EndorsementType', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/input_FieldName', [('fieldName') : 'Layer Gross Premium ']), 
    findTestData(testData).getValue('EndorsementGrossPremium', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/input_FieldName', [('fieldName') : 'Layer Gross Premium ']), 
    Keys.chord(Keys.TAB))

String tmhccGrossPremiumEndorsement = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_ReadPremiumInformationValues_Span', 
        [('headerName') : 'TMHCC Gross Premium']))

GenericUtils.verifyMatch('TMHCC Gross Premium Value is', tmhccGrossPremiumEndorsement, '-0.01', 'EQUAL')

String tmhccNetPremiumEndorsement = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_ReadPremiumInformationValues_Span', 
        [('headerName') : 'TMHCC Net Premium']))

GenericUtils.verifyMatch('TMHCC Net Premium Value is', tmhccNetPremiumEndorsement, '-0.01', 'EQUAL')

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/button_CompleteQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/button_CompleteQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Endorsements/button_CompleteQuote'))

String quotedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', quotedStatus, 'Quoted', 'EQUAL')

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/button_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/button_TakeUpQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Endorsements/button_TakeUpQuote'))

String openBoundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', openBoundStatus, 'Open Bound', 'EQUAL')

String enterpriseValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_ReadDynamicValues', [('headerName') : 'Enterprise Value']))

KeywordUtil.logInfo('Enterprise Value displayed is :: '+enterpriseValue)

String evCurrencyValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'EVCurrency']))

KeywordUtil.logInfo('EV Currency Value displayed is :: '+evCurrencyValue)

String buyerCounselName = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'BuyersCounsel']), 'value')

KeywordUtil.logInfo('Buyer Counsel Name Value displayed is :: '+buyerCounselName)

String sellerCounselName = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'SellersCounsel']), 'value')

KeywordUtil.logInfo('Seller Counsel Name Value displayed is :: '+sellerCounselName)

String inceptioDateValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'EffectiveDate']), 'value')
KeywordUtil.logInfo('Inception Date Value displayed is :: '+inceptioDateValue)

String expiryDateValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'ExpirationDate']), 'value')

KeywordUtil.logInfo('Expiry Date Value displayed is :: '+expiryDateValue)

String policyPeriodValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'PolicyDuration']), 'value')

KeywordUtil.logInfo('Policy Period Value displayed is :: '+policyPeriodValue)

String orderPercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'OrderPercent']), 'value')
KeywordUtil.logInfo('Order Percent Value displayed is :: '+orderPercentValue)

String estimatedSigningValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'EstimatedSigning']), 'value')

KeywordUtil.logInfo('Estimated Signing Value displayed is :: '+estimatedSigningValue)

String tmhccParticipationPercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'TMHCCWrittenPartPercent']), 'value')

KeywordUtil.logInfo('TMHCC Participation Value displayed is :: '+tmhccParticipationPercentValue)

String calculatedLinePercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'CalculatedLinePercent']), 'value')

KeywordUtil.logInfo('Calculated Line Percent Value displayed is :: '+calculatedLinePercentValue)

String layerAggLimitValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'LayerAGGLimit']), 'value')

KeywordUtil.logInfo('Layer AGG Limit Value displayed is :: '+layerAggLimitValue)

String deMinimisAmountValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'DeMinimisAmount']), 'value')

KeywordUtil.logInfo('De Minimis Amount Value displayed is :: '+deMinimisAmountValue)

String deMinimisDetailsValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'DeMinimisDetails']), 'value')
KeywordUtil.logInfo('De Minimis Details Value displayed is :: '+deMinimisDetailsValue)

String maximumLimitValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'MaximumLimitQuoted']), 'value')

KeywordUtil.logInfo('Maximum Limit Value displayed is :: '+maximumLimitValue)

String commissionPercentValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'CommissionPercentage']), 'value')
KeywordUtil.logInfo('Commiossion Percent Value displayed is :: '+commissionPercentValue)

String layerGrossPremiumValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'LayerGrossPremium']), 'value')

KeywordUtil.logInfo('Layer Gross Premium Value displayed is :: '+layerGrossPremiumValue)

String layerNetPremiumValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'LayerNetPremium']), 'value')
KeywordUtil.logInfo('Layer Net Premium Value displayed is :: '+layerNetPremiumValue)

String applicableLawValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue', 
        [('labelName') : 'ApplicableLaw']), 'value')
KeywordUtil.logInfo('Applicable Law Value displayed is :: '+applicableLawValue)

String completionDateValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue',
	[('labelName') : 'endDate']), 'value')

KeywordUtil.logInfo('Completion Date Value displayed is :: '+completionDateValue)

String retentionValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue',
	[('labelName') : 'RetentionEnterpriseValue']), 'value')
KeywordUtil.logInfo('Retention Value displayed is :: '+retentionValue)

String spaDateValue = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/webElement_ReadCounselFieldValue',
	[('labelName') : 'SPADate']), 'value')
KeywordUtil.logInfo('SPA Date Value displayed is :: '+spaDateValue)

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Applicable Jurisdiction'])).isEmpty()) {
    KeywordUtil.logInfo('Applicable Jurisdiction is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Contract Start Date'])).isEmpty()) {
	KeywordUtil.logInfo('Contract Start Date is empty')
}

if(WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckboxLabelBefore',
	[('labelName') : 'Estimated Date']), GlobalVariable.timeoutShort)) {
KeywordUtil.logInfo('Estimated Date tick box is NOT checked')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'New Breach Date'])).isEmpty()) {
	KeywordUtil.logInfo('New Breach Date is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Retention Tipping Point'])).isEmpty()) {
	KeywordUtil.logInfo('Retention Tipping Point is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Retention Dropping Point'])).isEmpty()) {
	KeywordUtil.logInfo('Retention Dropping Point is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 's Representative'])).isEmpty()) {
	KeywordUtil.logInfo('Insured Representative is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 's Email'])).isEmpty()) {
	KeywordUtil.logInfo('Insured Representative mail is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'SPA Title'])).isEmpty()) {
	KeywordUtil.logInfo('SPA Title is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'SPA Date'])).isEmpty()) {
	KeywordUtil.logInfo('SPA Date is empty')
}
if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Buyer Name'])).isEmpty()) {
	KeywordUtil.logInfo('Buyer Name is empty')
}
if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Buyer NIF No.'])).isEmpty()) {
	KeywordUtil.logInfo('Buyer NIF No. is empty')
}

if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Seller Name'])).isEmpty()) {
	KeywordUtil.logInfo('Seller Name is empty')
}
if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Seller NIF No.'])).isEmpty()) {
	KeywordUtil.logInfo('Seller NIF No. is empty')
}

String buyerCounselCountry = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'BuyersCounsel']))
KeywordUtil.logInfo('Buyer Counsel Country Value displayed is :: '+buyerCounselCountry)

String sellerCounselCountry = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'SellersCounsel']))
KeywordUtil.logInfo('Seller Counsel Country Value displayed is :: '+sellerCounselCountry)

String underwriterName = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'Underwriter']))
KeywordUtil.logInfo('UnderWriter Name Value displayed is :: '+underwriterName)

String underWritingAssistant = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'Assistant']))
KeywordUtil.logInfo('UnderWriting Assistant Value displayed is :: '+underWritingAssistant)

String producingTeamValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'ProducingTeam']))
KeywordUtil.logInfo('Producing Team Value displayed is :: '+producingTeamValue)

String uwAuthorityValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'UWAuthorityOperator']))
KeywordUtil.logInfo('UW Authority Value displayed is :: '+uwAuthorityValue)

String entityValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'Entity']))
KeywordUtil.logInfo('Entity Value displayed is :: '+entityValue)

String legalBranchValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'LegalBranch']))
KeywordUtil.logInfo('Legal Branch Value displayed is :: '+legalBranchValue)

String originalCurrencyValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'BaseCurrencyCode']))
KeywordUtil.logInfo('Original Currency Value displayed is :: '+originalCurrencyValue)

String premiumTypeValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'PremiumType']))
KeywordUtil.logInfo('Premium Type Value displayed is :: '+premiumTypeValue)

String territorialScopeValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'TerritorialScope']))
KeywordUtil.logInfo('Territorial Scope Value displayed is :: '+territorialScopeValue)

String cyberCoverageValue = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'CyberCoverage']))
KeywordUtil.logInfo('Cyber Coverage Value displayed is :: '+cyberCoverageValue)

String actualTargetName = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicValues', [('fieldName') : 'Target Name ']),
	FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Target Name Value displayed is :: '+actualTargetName)

String actualTargetDomicile = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicValues',
		[('fieldName') : 'Target Domicile']), FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Target Domicile Value displayed is :: '+actualTargetDomicile)

String actualTargetNAIC = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicValues', [('fieldName') : 'Target NAIC']),
	FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Target NAIC Value displayed is :: '+actualTargetNAIC)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.clearText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), findTestData(testData).getValue('input_Lead', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), Keys.chord(Keys.BACK_SPACE))

String currentText =  findTestData(testData).getValue('input_Lead', rowNumber).substring(0, findTestData(testData).getValue('input_Lead', rowNumber).length()-1)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]), GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))

String taxApplicable = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_SelectedDropDownValue', [('dropDownName') : 'TaxApplicable']))
KeywordUtil.logInfo(taxApplicable)

KeywordUtil.logInfo('Retention Value displayed is :: '+retentionValue)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
        testData).getValue('Due Date', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
        Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

 

String actualGenerateInstallmentMessage = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_GenerateInstallmentsMessage'))

KeywordUtil.logInfo('Retention Value displayed is :: '+retentionValue)

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

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Finalise'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Finalise'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

String signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', signedStatus, 'Signed', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Endorsements/button_ExpandItems'))
WebUI.click(findTestObject('Object Repository/Endorsements/webElement_TabSelectorAfterExpansion', [('tabName') : 'Endorsements']))

String endorsementNumber = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_EndorsementNumber', [('attributeName') : 'Endorsement Number', ('version') : version]))
return endorsementNumber