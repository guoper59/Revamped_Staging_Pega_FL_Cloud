/**
 * ============================================================================
 * Test Case ID : 259900
 * Title         : Check No Renewal Created For TRI Policy
 * Folder        : Scripts/Renewals/259900_CheckNoRenewalCreatedForTRIPolicy
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
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testDataName, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

String PolicyRef = WebUI.callTestCase(findTestCase('Test Cases/TestData/259900_CreateTRIPolicy'), [('testData') : testDataName
        , ('rowNumber') : rowNumber, ('username'):'ebello', ('password'):GlobalVariable.Ebello], FailureHandling.STOP_ON_FAILURE)

GlobalVariable.PolicyRef = PolicyRef

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TMHCCWrittenParticipation'), 
    findTestData(testDataName).getValue('TMHCC Written Participation%', rowNumber))


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'))


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'), findTestData(
        testDataName).getValue('Layer AGG Limit', rowNumber))


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'), 
    GlobalVariable.timeOutValue)


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'), 
    findTestData(testDataName).getValue('Commission', rowNumber))


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
    findTestData(testDataName).getValue('Layer Gross Premium', rowNumber))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']))


WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']), 
    findTestData(testDataName).getValue('Territorial Scope', rowNumber), false)


WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_ApplicableLaw'), findTestData(
        testDataName).getValue('Applicable Law', rowNumber))


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
    findTestData(testDataName).getValue('Maximum Limit Quoted', rowNumber))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_OtherCommisionAddItem'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_OtherCommisionAddItem'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Payable To']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Payable To']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Payable To']), 
    findTestData(testDataName).getValue('PayableTo', rowNumber), false)


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Fee Type']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Fee Type']))


WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/webElement_OtherCommissionDropDown', [('headerName') : 'Fee Type']), 
    findTestData(testDataName).getValue('FeeType', rowNumber), false)


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Fee %']), 
    GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', [('fieldName') : 'Fee %']), findTestData(
        testDataName).getValue('Fee%', rowNumber))


WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Territorial Scope ']), 
    findTestData(testDataName).getValue('Territorial Scope', rowNumber), false)


//Verifying the values
String orderValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Order %']), 'value')

GenericUtils.verifyMatch('Order Value is', orderValue, findTestData(testDataName).getValue('Order%', rowNumber), 'EQUAL')

String estimatedSigningValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Estimated Signing %']), 'value')


GenericUtils.verifyMatch('Estimated Signing Value is', estimatedSigningValue, findTestData(testDataName).getValue('Estimated Signing %', 
        rowNumber), 'EQUAL')

String calculatedLineValue = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Calculated Line %']), 'value')

GenericUtils.verifyMatch('Calculated line Value is', calculatedLineValue, findTestData(testDataName).getValue('Calculated Line %', 
        rowNumber), 'EQUAL')

String tmhccAggLimitValue = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadLimitInformation', 
        [('headerName') : 'TMHCC AGG Limit']))

GenericUtils.verifyMatch('TMHCC Agg Limit Value is', tmhccAggLimitValue, findTestData(testDataName).getValue('TMHCC AGG Limit', 
        rowNumber), 'EQUAL')

String layerCommissionValue = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'Layer Broker Commission Amount']))

GenericUtils.verifyMatch('Layer Commission Value is', layerCommissionValue, findTestData(testDataName).getValue('LayerBrokerCommissionAmount', 
        rowNumber), 'EQUAL')

String tmhccBrokerCommissionValue = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Broker Commission Amount']))

GenericUtils.verifyMatch('TMHCC Broker Commission Value is', tmhccBrokerCommissionValue, findTestData(testDataName).getValue(
        'TMHCCBrokerCommissionAmount', rowNumber), 'EQUAL')

String tmhccGrossPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Gross Premium']))

GenericUtils.verifyMatch('TMHCC Gross Premium Value is', tmhccGrossPremium, findTestData(testDataName).getValue('TMHCCGrossPremium', 
        rowNumber), 'EQUAL')

String tmhccNetPremium = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ReadBrokerCommissionValue', 
        [('headerName') : 'TMHCC Net Premium']))

GenericUtils.verifyMatch('TMHCC Net Premium Value is', tmhccNetPremium, findTestData(testDataName).getValue('TMHCCNetPremium', 
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

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'), 
    GlobalVariable.timeOutValue)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'))


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__Address1'), insuredAddress)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'))


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__ZipCode'), insuredPostCode)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'))


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input__City'), insuredCity)


WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownPrivatePublic'), 
    insuredPublicPrivate, false)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_IsParent'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Submit'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))


WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']))


WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']), 
    findTestData(testDataName).getValue('UW Authority', rowNumber), false)


WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownCyberCoverage'), 
    findTestData(testDataName).getValue('Cyber Coverage', rowNumber), false)


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownCyberCoverage'), 
    findTestData(testDataName).getValue('Cyber Coverage', rowNumber))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Completion Date']), 
    GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Completion Date']), findTestData(
        testDataName).getValue('Completion Date', rowNumber))


WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Buyer']))


WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Buyer']), 
    findTestData(testDataName).getValue('BuyerCountry', rowNumber), false)


WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Seller']))


WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Seller']), 
    findTestData(testDataName).getValue('SellerCountry', rowNumber), false)


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Buyer']), 
    GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Buyer']), findTestData(
        testDataName).getValue('Buyer', rowNumber))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Seller']), 
    GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Seller']), findTestData(
        testDataName).getValue('Seller', rowNumber))


WebUI.uncheck(findTestObject('Object Repository/NewBusiness/checkBox_EstimatedDate'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea'), GlobalVariable.timeOutValue)

String actualLayerFeeAmount = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', 
        [('fieldName') : 'Layer Fee Amount']), 'value')

GenericUtils.verifyMatch('Layer Fee Amount is : ', actualLayerFeeAmount, findTestData(testDataName).getValue('LayerFeeAmount', 
        rowNumber), 'EQUAL')

String actualTMHCCFeeAmount = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_DynamicHeaderField', 
        [('fieldName') : 'TMHCC Fee Amount']))

GenericUtils.verifyMatch('TMHCC Fee Amount is : ', actualTMHCCFeeAmount, findTestData(testDataName).getValue('TMHCCFeeAmount', 
        rowNumber), 'EQUAL')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 60)



WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 
    findTestData(testDataName).getValue('Tax Applicable', rowNumber), false)


WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'Surplus Lines Broker']))


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Broker Name']))


WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Broker Name']), 
    findTestData(testDataName).getValue('Broker Name', rowNumber), false)

//th[@aria-label='Licence State']//parent::tr//following-sibling::tr//td//select[contains(@name,'LinesLicence$l1$pState')]
//added steps for licence state and licence number
WebUI.selectOptionByLabel(findTestObject('Object Repository/Renewal/select_LicenceDetails',[('dropwonField'):'Licence State', ('option'):'LinesLicence$l1$pState' ]), 'New York', false)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
        testDataName).getValue('Due Date', rowNumber))


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
        Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'Yes']), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'Yes']))


WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))


WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']), 
    10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']))


WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'), 25, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Finalise'), 25, 
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
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Avazquez', GlobalVariable.Avazquez, 'Underwriter')

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
    GlobalVariable.PolicyRef)


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Apply'))

//Clicking on task link
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'), GlobalVariable.timeoutShort)


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'))


WebUI.switchToFrame(findTestObject('Object Repository/OutwardsPolicy/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

//Verifying Data Validation field names
List<WebElement> tableHeadersName = WebUI.findWebElements(findTestObject('Object Repository/OutwardsPolicy/webElement_TableHeaders'), 
    GlobalVariable.timeOutValue)

List<WebElement> FinalList = tableHeadersName.subList(0, 54)

List<WebElement> tableHeadersList = new ArrayList<String>()

for (int i = 0; i < 54; i++) {

    String value = FinalList.get(i).getText().trim( // Trim spaces
        )

    if (!(value.equals(''))) {
        tableHeadersList.add(value)
    }
}



WebUI.switchToDefaultContent()


WebUI.check(findTestObject('Object Repository/OutwardsPolicy/checkbox_UnderwriterDecision', [('optionToSelect') : 'Yes']))


WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Approve'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Approve'))



WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))


//Logging in with Underwriter Assistant
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('ebello', GlobalVariable.Ebello, findTestData(testDataName).getValue('Role', rowNumber))

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

WebUI.closeBrowser()

WebUI.openBrowser(null)

WebUI.maximizeWindow()

//Calling Get API to validate response---SBS ECLIPSE
ResponseObject response = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetRenewalDate'), null)

String renewalCreationDate = WS.getElementText(response, 'PolicyEnquiryResponse.PolicyEnquiryResult[0].RenewalCreationDate')

KeywordUtil.logInfo(renewalCreationDate)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.renewalAgentUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'(GlobalVariable.renewalUsername, GlobalVariable.vipin, findTestData(testDataName).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Renewal/webElement_RecordsLink'), 25)

WebUI.click(findTestObject('Object Repository/Renewal/webElement_RecordsLink'))


WebUI.click(findTestObject('Object Repository/Renewal/webElement_TechnicalOption'))


WebUI.click(findTestObject('Object Repository/Renewal/webElement_ActivityOption'))

//Click on activity filter and pass "RetreiveRenewalPolicies"

WebUI.click(findTestObject('Object Repository/RenewalAgent/webElement_ActivityNameFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_ClearFilterPeerReview'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_SearchTextPeerReview', [('fieldName') : 'Search Text']),
	ActivityName)


WebUI.click(findTestObject('Object Repository/NewBusiness/button_ApplyPeerReview'))

WebUI.click(findTestObject('Object Repository/RenewalAgent/webElement_Sort'))


WebUI.click(findTestObject('Object Repository/RenewalAgent/webElement_SelectRuleSet'))



//There are not an Obj-Browse
WebUI.scrollToElement(findTestObject('Object Repository/Renewal/webElement_Scroll'), 25)

WebUI.click(findTestObject('Object Repository/Renewal/webElement_Expand'))


WebUI.click(findTestObject('Object Repository/Renewal/input_CreationDate'))


WebUI.sendKeys(findTestObject('Object Repository/Renewal/input_CreationDate'), Keys.chord(Keys.CONTROL, 'a'))


WebUI.sendKeys(findTestObject('Object Repository/Renewal/input_CreationDate'), "\"$renewalCreationDate\"")


WebUI.verifyElementVisible(findTestObject('Object Repository/Renewal/input_CreationDateFrom'))

WebUI.scrollToElement(findTestObject('Object Repository/Renewal/webElement_Scroll'), GlobalVariable.timeOutValue)


WebUI.click(findTestObject('Object Repository/Renewal/input_CreationDateFrom'))


WebUI.sendKeys(findTestObject('Object Repository/Renewal/input_CreationDateFrom'), Keys.chord(Keys.CONTROL, 'a'))


WebUI.sendKeys(findTestObject('Object Repository/Renewal/input_CreationDateFrom'), "\"$renewalCreationDate\"")




WebUI.click(findTestObject('Object Repository/Renewal/button_ActionsExpand'))


WebUI.click(findTestObject('Object Repository/Renewal/button_Run'))
WebUI.switchToWindowIndex(1)


WebUI.verifyElementClickable(findTestObject('Object Repository/Renewal/button_RunAgent'))

WebUI.sendKeys(findTestObject('Object Repository/Renewal/input_PolicyRef'), GlobalVariable.PolicyRef)


WebUI.click(findTestObject('Object Repository/Renewal/button_RunAgent'))


WebUI.switchToWindowIndex(2)


if (WebUI.verifyTextPresent('The Operation completed successfully, but returned no content', false)) {
    KeywordUtil.markPassed('Renewal Agent ran but no policy is renewed')
} else {
    KeywordUtil.markFailed('Policy is renewed')
}