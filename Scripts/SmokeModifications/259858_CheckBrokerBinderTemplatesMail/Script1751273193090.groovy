/**
 * ============================================================================
 * Test Case ID : 259858
 * Title         : Check Broker Binder Templates Mail
 * Folder        : Scripts/SmokeModifications/259858_CheckBrokerBinderTemplatesMail
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
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper as SubmissionHelper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

rowNumberforTestData = rowNumber

KeywordUtil.logInfo(GlobalVariable.testCaseID)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)


CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))


WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

SubmissionHelper.enterInsuredDetails(testData, rowNumber)


WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'No']))


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))


SubmissionHelper.enterBrokerDetails(testData, rowNumber)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))


SubmissionHelper.enterGeneralData(testData, rowNumber)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))


WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'), 
    GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)

String policyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

KeywordUtil.logInfo(policyRef)

GlobalVariable.PolicyRef = policyRef

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))

//Uw Worksheet
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))


SubmissionHelper.enterDetailsUWSheet(testData, rowNumber)


//Verifying the values
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
//
//
//
//
//
//
//

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CompleteQuote'))



String qoutedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

KeywordUtil.logInfo(qoutedStatus)
//TODO: 540274: Remove the Quote Doc and Broker Bind Doc stage from the Pega data entry workflow



////Click on continue.
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

KeywordUtil.logInfo(openBoundStatus)

SubmissionHelper.enterDetailsUW(testData, rowNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'ADR Exposure ']), GlobalVariable.timeoutShort)

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', 
        [('labelName') : 'Local Market Cap ']), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Local Market Cap ']))


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Local Market Cap ']), 
    findTestData(testData).getValue('LocalMarketCap', rowNumber))


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', [('dropDownLabel') : 'ADR Exposure ']))


WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'ADR Exposure ']), findTestData(testData).getValue('ADRExposure', rowNumber), false)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicValues', [('labelName') : 'Assets Under Management (AUM)']))

WebUI.click(findTestObject('Object Repository/Documentation/btn_Save'))


String boundStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

KeywordUtil.logInfo(boundStatus)


WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_GenerateBrokerBind'), 
    GlobalVariable.timeoutShort, FailureHandling.OPTIONAL)


WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_GenerateBrokerBind'), 
    20, FailureHandling.OPTIONAL)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/button_GenerateBrokerBind'), FailureHandling.OPTIONAL)


WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'Select Format']), rowNumber)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', [('dropDownLabel') : 'Select Format']))


WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'Select Format']), findTestData(testData).getValue('Email', rowNumber), false)


WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'Select Language']), rowNumber)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', [('dropDownLabel') : 'Select Language']))


WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'Select Language']), findTestData(testData).getValue('Language', rowNumber), false)


WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'Select Template']), rowNumber)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', [('dropDownLabel') : 'Select Template']))


WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', 
        [('dropDownLabel') : 'Select Template']), findTestData(testData).getValue('Template', rowNumber), false)


WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/button_Submit'), 60)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Submit'))


// Switch to the new window (assuming it's the second one)
WebUI.switchToWindowIndex(1)


WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_SendMailLabel'), GlobalVariable.timeOutValue)

//Verifying Data Validation field names
List<WebElement> emailHeaderName = WebUI.findWebElements(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_ListMailHeader'), 
    GlobalVariable.timeOutValue)


List<WebElement> emailHeaderList = new ArrayList<String>()

for (WebElement e : emailHeaderName) {
    emailHeaderList.add(e.getText())
}

GenericUtils.compareLists(emailHeaderList, expectedHeaderList)

String mailContentHeaderText = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_MailHeaderMessage'))

List<WebElement> emailContentName = WebUI.findWebElements(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_MailValueContent'), 
    GlobalVariable.timeOutValue)

List<WebElement> FinalList = emailContentName.subList(0, 10)

List<WebElement> emailContentList = new ArrayList<String>()

for (WebElement e : FinalList) {
    if (!(e.getText().equals(''))) {
        emailContentList.add(e.getText())
    }
}

WebUI.verifyTextPresent('Policyholder Address:', false)

WebUI.verifyTextPresent('We are pleased to confirm the terms of our binding agreement as follows:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Addressline', rowNumber), false)

WebUI.verifyTextPresent((findTestData(testData).getValue('PostCode', rowNumber) + ' ') + findTestData(testData).getValue(
        'City', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Country', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Broker', rowNumber), false)

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

//Perform actions 
WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

//Validations for Emial 
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))


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
////Verifying if Order Form is available in the attachment
//
//
////Verifying if Order Form is available in the attachment
//
//
//
//
////WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector', [('tabName') : 'Policy Docs']))
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
//
//
//
//
//
//
