/**
 * ============================================================================
 * Title        : CancelAnEndorsement
 * Title         : CancelAnEndorsement
 * Folder        : Scripts/TestData/CancelAnEndorsement
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

import static com.kms.katalon.core.model.FailureHandling.CONTINUE_ON_FAILURE
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

WebUI.comment('RowNumber: ' + rowNumber)

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_CreateEndorsement'))


WebUI.switchToFrame(findTestObject('Object Repository/Endorsements/CancelEndorsement/iframe_PegaGadget2Ifr'), GlobalVariable.timeOutValue, 
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


WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Requested By']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Requested By']), 
    findTestData(testData).getValue('EndorsementRequested', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Type']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Type']), 
    findTestData(testData).getValue('EndorsementType', rowNumber), false)


WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/text_CommentsSection', [('commentField') : 'Endorsement Notes']), 
    'Test test test test test test')

String endorsmentInceptionDate = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_FieldName', 
        [('fieldName') : 'Endorsement Inception Date ']), 'value')

KeywordUtil.logInfo(endorsmentInceptionDate)

String endorsmentExpiryDate = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_FieldName', 
        [('fieldName') : 'Endorsement Expiry Date ']), 'value')

KeywordUtil.logInfo(endorsmentExpiryDate)

String endorsmentPeriod = WebUI.getText(findTestObject('Object Repository/Endorsements/CancelEndorsement/webElement_ReadDynamicValues', 
        [('headerName') : 'Endorsement Period']))

KeywordUtil.logInfo(endorsmentPeriod)

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))


WebUI.verifyElementChecked(findTestObject('Object Repository/Endorsements/CancelEndorsement/radio_DynamicRadioButton', [
            ('radioButtonLabel') : 'Yes']), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))


String country = WebUI.getText(findTestObject('Object Repository/Endorsements/CancelEndorsement/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'Country']))

String brokerContactNameInsuredDetails = WebUI.getText(findTestObject('Object Repository/Endorsements/CancelEndorsement/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'AgentId']))

String selectedBroker = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/CancelEndorsement/webElement_ReadBrokerSelectedAutoComplete'), 
    'value')

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'), 25)

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'), 25)

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))


WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_DynamicDropDown', [('dropDownLabel') : 'Premium Type']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_DynamicDropDown', [('dropDownLabel') : 'Premium Type']), 
    findTestData(testData).getValue('EndorsementType', rowNumber), false)


WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_FieldName', [('fieldName') : 'Layer Gross Premium ']), 
    findTestData(testData).getValue('EndorsementGrossPremium', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_FieldName', [('fieldName') : 'Layer Gross Premium ']), 
    Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/button_CompleteQuote2'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/button_CompleteQuote2'), 25)
WebUI.click(findTestObject('Object Repository/Endorsements/button_CompleteQuote2'))



WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_Status'), 60)

String quotedStatus1 = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_Status'))

KeywordUtil.logInfo(quotedStatus1)
GenericUtils.verifyMatch('Status Value is', quotedStatus1, 'Quoted', 'EQUAL')


//TODO: 540274: Remove the Quote Doc and Broker Bind Doc stage from the Pega data entry workflow


////Click on takeup the quote.
WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_TakeUpQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_TakeUpQuote'))
//TODO: 540276 Generate a Quote Letter document and to Take Up a Quote version to the Bind stage to be amended and moved to the Underwriting stage
WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_QuoteCheckbox'), 25)

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_QuoteCheckbox'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_TakeUpQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_TakeUpQuote'))


String openBoundStatus = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', openBoundStatus, 'Open Bound', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))


String taxApplicable = WebUI.getText(findTestObject('Object Repository/Endorsements/CancelEndorsement/webElement_SelectedDropDownValue', 
        [('dropDownName') : 'TaxApplicable']))

KeywordUtil.logInfo(taxApplicable)

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_DueDate'), findTestData(testData).getValue(
        'Due Date', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_DueDate'), Keys.chord(Keys.TAB))


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments1'), 25, CONTINUE_ON_FAILURE)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments1'), GlobalVariable.timeOutValue, CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments1'), CONTINUE_ON_FAILURE)


String actualGenerateInstallmentMessage = WebUI.getText(findTestObject('Object Repository/Endorsements/CancelEndorsement/webElement_GenerateInstallmentsMessage'))


WebUI.click(findTestObject('Object Repository/Endorsements/button_OtherActions'))

if ( WebUI.verifyElementVisible(findTestObject('Object Repository/Documentation/btn_Cancel'), FailureHandling.OPTIONAL )) {
	WebUI.click(findTestObject('Object Repository/Documentation/btn_Cancel'))
	WebUI.click(findTestObject('Object Repository/Endorsements/button_OtherActions'))
}

WebUI.click(findTestObject('Object Repository/Endorsements/webElement_OtherActionsOption', [('optionToSelect') : 'Cancel Endorsement']))


String warningMessage = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_CancelEndorsementMessage'))

KeywordUtil.logInfo(warningMessage)

WebUI.click(findTestObject('Object Repository/Endorsements/button_OK'))
WebUI.click(findTestObject('Object Repository/Endorsements/webElement_HeaderTabSelector', [('tabName') : 'Bind']))


WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_FieldName', [('fieldName') : 'Layer Gross Premium ']), 
    Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_FieldName', [('fieldName') : 'Layer Gross Premium ']), 
    findTestData(testData).getValue('UpdatedEndorsementGrossPremium', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_FieldName', [('fieldName') : 'Layer Gross Premium ']), 
    Keys.chord(Keys.TAB))
WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Save'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Save'))


WebUI.click(findTestObject('Object Repository/Endorsements/webElement_HeaderTabSelector', [('tabName') : 'Post Bind']))


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments1'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments1'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments1'))


WebUI.click(findTestObject('Object Repository/Endorsements/button_OtherActions'))
WebUI.click(findTestObject('Object Repository/Endorsements/webElement_OtherActionsOption', [('optionToSelect') : 'Cancel Endorsement']))


String textMessage = WebUI.getText(findTestObject('Object Repository/Endorsements/CancelEndorsement/webElement_EndorsementCancellationInformation'))

KeywordUtil.logInfo(textMessage)

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Cancel Reason']))


WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Cancel Reason']), 
    findTestData(testData).getValue('CancelReason', rowNumber), false)


WebUI.sendKeys(findTestObject('Object Repository/Endorsements/text_CommentsSection1', [('commentField') : 'Cancel Reason Description ']), 
    'Test test test test')


WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Submit'))


String successMessage = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_SuccessMessage'))

GenericUtils.verifyMatch('Success Message Displayed', successMessage, expectedSuccessMessage, 'EQUAL')

String cancelledStatus = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', cancelledStatus, 'Cancelled', 'EQUAL')

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/button_ExpandItems_Frame2'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Endorsements/button_ExpandItems_Frame2'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/webElement_TabSelectorExpansion_Frame2', [('tabName') : 'Endorsements']),
	GlobalVariable.timeOutValue)

WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/webElement_TabSelectorExpansion_Frame2', [('tabName') : 'Endorsements']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Endorsements/webElement_TabSelectorExpansion_Frame2', [('tabName') : 'Endorsements']))





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





WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/button_ExpandItems_Frame2'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Endorsements/button_ExpandItems_Frame2'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/webElement_TabSelectorExpansion_Frame2', [('tabName') : 'Post Bind']),
	GlobalVariable.timeOutValue)

WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/webElement_TabSelectorExpansion_Frame2', [('tabName') : 'Post Bind']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Endorsements/webElement_TabSelectorExpansion_Frame2', [('tabName') : 'Post Bind']))


//Validations
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Close'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Close'))


WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/button_Actions'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Endorsements/button_Actions'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Endorsements/button_CreateEndorsement1'))