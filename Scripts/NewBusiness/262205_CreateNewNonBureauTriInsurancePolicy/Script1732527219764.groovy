/**
 * ============================================================================
 * Test Case ID : 262205
 * Title         : Create New Non Bureau Tri Insurance Policy
 * Folder        : Scripts/NewBusiness/262205_CreateNewNonBureauTriInsurancePolicy
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
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper as SubmissionHelper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

String stateValue = findTestData(testData).getValue('State', rowNumber)
String taxCodeValue = findTestData(testData).getValue('Tax code', rowNumber)

String testData = 'NewBusiness'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

String timeStamp = GenericUtils.getCurrentTimestamp()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('ebello', GlobalVariable.Ebello, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), 60, 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Creating a Submission')
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Click on the 'Create' button.
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'), 25)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

//Wait for the 'Insured' element to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

SubmissionHelper.enterInsuredDetails(testData, rowNumber)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'No']), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'No']))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'), 
    GlobalVariable.timeOutValue)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
        'Country', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']), 
    findTestData(testData).getValue('Broker', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : stateValue]), 
    GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : stateValue]))

WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : stateValue]))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'), 
    findTestData(testData).getValue('Broker Contact', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

SubmissionHelper.enterGeneralData(testData, rowNumber)

String currentDate = new SimpleDateFormat('dd/MM/yyyy').format(Calendar.getInstance().time)

String submissionReceivedDate = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Submission Received Date']), 
    'data-value')

GenericUtils.verifyMatch('Submission Received Date Value is', submissionReceivedDate, currentDate, 'EQUAL')

String caseID = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseID'))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Enterprise Value']), findTestData(
        testData).getValue('EnterpriseValue', rowNumber))

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'EV Currency ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'EV Currency ']), 
    findTestData(testData).getValue('EVCurrency', rowNumber), false)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Working Status']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Working Status']), 
    findTestData(testData).getValue('WorkingStatus', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_Comments', [('commentField') : 'Working Status Note']), 
    'Test Test')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.waitForElementPresent(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyReference'), 180)

String policyRef = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyReference'))

GlobalVariable.PolicyRef = policyRef

KeywordUtil.logInfo(policyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_OK'))

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

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_OtherCommisionAddItem'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_OtherCommisionAddItem'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Payable To']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Payable To']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Payable To']), 
    findTestData(testData).getValue('PayableTo', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Fee Type']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Fee Type']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Fee Type']), 
    findTestData(testData).getValue('FeeType', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Fee %']), 
    GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Fee %']), findTestData(
        testData).getValue('Fee%', rowNumber))

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']), 
    findTestData(testData).getValue('Territorial Scope', rowNumber), false)

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

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_UpdateTarget'), GlobalVariable.timeOutValue)

String openBoundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', openBoundStatus, 'Open Bound', 'EQUAL')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_UpdateTarget'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'), 
    GlobalVariable.timeOutValue)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'), 
    'Public', false)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Submit'), 25)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))

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

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea'), GlobalVariable.timeOutValue)

String actualLayerFeeAmount = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', 
        [('fieldName') : 'Layer Fee Amount']), 'value')

GenericUtils.verifyMatch('Layer Fee Amount is : ', actualLayerFeeAmount, findTestData(testData).getValue('LayerFeeAmount', 
        rowNumber), 'EQUAL')

String actualTMHCCFeeAmount = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_DynamicHeaderField', 
        [('fieldName') : 'TMHCC Fee Amount']))

GenericUtils.verifyMatch('TMHCC Fee Amount is : ', actualTMHCCFeeAmount, findTestData(testData).getValue('TMHCCFeeAmount', 
        rowNumber), 'EQUAL')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 60)

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    findTestData(testData).getValue('Tax Applicable', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	taxCodeValue)

WebUI.clearText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']))

WebUI.setText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']),
	taxCodeValue)

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Tax Code']), Keys.chord(Keys.BACK_SPACE))

String currentText =  taxCodeValue.substring(0, taxCodeValue.length()-1)

WebUI.mouseOver(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.enhancedClick(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AutoCompleteResult', [('optionToSelect') : currentText ] ))

WebUI.sendKeys(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_InputTaxesDetail', [('fieldName') : 'Premium']), 
    findTestData(testData).getValue('Tax Premium', rowNumber))

WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'Surplus Lines Broker']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Broker Name']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Broker Name']), 
    findTestData(testData).getValue('Broker Name', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
        testData).getValue('Due Date', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
        Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_GenerateInstallmentsMessage'), 60)

String actualGenerateInstallmentMessage = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_GenerateInstallmentsMessage'))

GenericUtils.verifyMatch('Warning message is : ', actualGenerateInstallmentMessage, findTestData(testData).getValue('GenerateInstallmentMessage', 
        rowNumber), 'EQUAL')

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

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'),     25)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'Yes']), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'Yes']))

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector2', [('tabName') : 'Attachments']))

if (WebUI.waitForElementPresent(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_AttachmentsName',
	[('attachmentName') : 'Underwriting Quality Check']), GlobalVariable.timeOutValue)) {
	KeywordUtil.markPassed('Attachment is present')
}

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector2', [('tabName') : 'Overview']))

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
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('AVAZQUEZ', GlobalVariable.Avazquez, 'Underwriter')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Quality Check']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/checkbox_ViewAllCases'))

//Filtering the policy
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_ClearFilter'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_SearchTextInFilter', [('fieldName') : 'Search Text']), 
    policyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Apply'))

//Clicking on task link
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'))

WebUI.switchToFrame(findTestObject('Object Repository/OutwardsPolicy/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

//Verifying Data Validation field names
WebUI.callTestCase(findTestCase('Test Cases/NewBusiness/262205_SubTestCase_Part1'), [('policyRef') : policyRef, ('rowNumber') : rowNumber], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Eclipse/262205_EclipseValidation'), [('testData') : testData, ('rowNumber') : rowNumber], 
    FailureHandling.STOP_ON_FAILURE)

