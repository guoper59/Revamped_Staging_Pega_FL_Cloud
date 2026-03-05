/**
 * ============================================================================
 * Test Case ID : 262220
 * Title         : Create Additional Premium
 * Folder        : Scripts/TestData/262220_CreateAdditionalPremium
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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

String testData = 'Endorsements'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

////Verifying Data Validation field names
List<WebElement> endorsementTabs = WebUI.findWebElements(findTestObject('Object Repository/Endorsements/webElement_EndorsementTabs'), 
    GlobalVariable.timeOutValue)

List<WebElement> endorsementTabsList = new ArrayList<String>()

for (WebElement e : endorsementTabs) {

    endorsementTabsList.add(e.getText())
}

KeywordUtil.logInfo(endorsementTabsList)

WebUI.switchToDefaultContent()


WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/select_DynamicDropDown1', [('dropDownLabel') : 'Endorsement Requested By']), 25)

WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown1', [('dropDownLabel') : 'Endorsement Requested By']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown1', [('dropDownLabel') : 'Endorsement Requested By']), 
    findTestData(testData).getValue('EndorsementRequested', rowNumber), false)


WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown1', [('dropDownLabel') : 'Endorsement Type']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown1', [('dropDownLabel') : 'Endorsement Type']), 
    findTestData(testData).getValue('EndorsementType', rowNumber), false)


WebUI.sendKeys(findTestObject('Object Repository/Endorsements/text_CommentsSection1', [('commentField') : 'Endorsement Notes']), 
    'Test test test test test test')

String endorsmentInceptionDate = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/input_FieldName1', [('fieldName') : 'Endorsement Inception Date ']), 
    'value')

KeywordUtil.logInfo(endorsmentInceptionDate)

String endorsmentExpiryDate = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/input_FieldName1', [('fieldName') : 'Endorsement Expiry Date ']), 
    'value')

KeywordUtil.logInfo(endorsmentExpiryDate)

String endorsmentPeriod = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_ReadDynamicValues1', [
            ('headerName') : 'Endorsement Period']))

KeywordUtil.logInfo(endorsmentPeriod)

WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue1'))


WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown1', [('dropDownLabel') : 'Insured Persons']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown1', [('dropDownLabel') : 'Insured Persons']), 
    findTestData(testData).getValue('InsuredPersons', rowNumber), false)


WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue1'))


WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue1'))


WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue1'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium1'), 
    GlobalVariable.timeOutValue)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium1'))


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium1'), 
    Keys.chord(Keys.CONTROL, 'a'))


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium1'), 
    findTestData(testData).getValue('Layer Gross Premium', rowNumber))


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_PremiumCalculate1'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/input_FeePercentage'), GlobalVariable.timeOutValue)

WebUI.clearText(findTestObject('Object Repository/Endorsements/input_FeePercentage'))


WebUI.sendKeys(findTestObject('Object Repository/Endorsements/input_FeePercentage'), findTestData(testData).getValue('Fee%', 
        rowNumber))


WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_CompleteQuote'), 25)
WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_CompleteQuote'))


////Click on takeup the quote.
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote1'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote1'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote1'))
//TODO: 540276 Generate a Quote Letter document and to Take Up a Quote version to the Bind stage to be amended and moved to the Underwriting stage
WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_QuoteCheckbox'), 25)

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_QuoteCheckbox'))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote1'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote1'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_TakeUpQuote1'))


WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue1'))




WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate1'), findTestData(
        testData).getValue('Due Date', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate1'), Keys.chord(
        Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments1'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments1'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments1'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting1'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting1'))


WebUI.enhancedClick(findTestObject('Object Repository/Endorsements/CancelEndorsement/radio_DynamicRadioButton', [('radioButtonLabel') : 'No']))

WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown1', [('dropDownLabel') : 'Reason for not sending the Underwriting Quality Check']))


WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown1', [('dropDownLabel') : 'Reason for not sending the Underwriting Quality Check']), 
    findTestData(testData).getValue('Reason', rowNumber), false)


WebUI.sendKeys(findTestObject('Object Repository/Endorsements/text_CommentsSection1', [('commentField') : 'Comments']), 
    'Test test test test')


WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit1'))


WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit1'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Submit1'), 25)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit1'), FailureHandling.OPTIONAL)


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Finalise1'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Finalise1'), FailureHandling.OPTIONAL)

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt1'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed1'), FailureHandling.OPTIONAL)


String signedStatus1 = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status1'))


GenericUtils.verifyMatch('Status Value is', signedStatus1, 'Signed', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Endorsements/webElement_DynamicTabSelector1', [('tabName') : 'Endorsements']))

WebUI.switchToFrame(findTestObject('Object Repository/Endorsements/iframe_PegaGadget2Ifr'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

//Verifying Data Validation field names
List<WebElement> endorsementTableHeadersName = WebUI.findWebElements(findTestObject('Object Repository/Endorsements/webElement_ListOfEndorsementVersionTableHeaders1'), 
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
List<WebElement> endorsementTableValues = WebUI.findWebElements(findTestObject('Object Repository/Endorsements/webElement_ListOfTableValues1', 
        [('version') : 1]), GlobalVariable.timeOutValue)

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

String endorsementNumber = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_EndorsementNumber1'))
KeywordUtil.logInfo(endorsementNumber)


return endorsementNumber