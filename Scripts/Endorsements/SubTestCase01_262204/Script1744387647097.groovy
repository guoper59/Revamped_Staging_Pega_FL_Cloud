/**
 * ============================================================================
 * Title        : SubTestCase01 262204
 * Title         : SubTestCase01 262204
 * Folder        : Scripts/Endorsements/SubTestCase01_262204
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

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement

import com.kms.katalon.core.util.KeywordUtil

import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable

String quotedStatus1 = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

WebUI.comment(quotedStatus1)
GenericUtils.verifyMatch('Status Value is', quotedStatus1, 'Quoted', 'EQUAL')

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

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/button_Continue'), 260)
WebUI.click(findTestObject('Object Repository/Endorsements/button_Continue'))


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
	testData).getValue('Due Date', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
	Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'),
	GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))

WebUI.enhancedClick(findTestObject('Object Repository/Endorsements/radio_DynamicRadioButton', [('radioButtonLabel') : 'No']))

WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Reason for not sending the Underwriting Quality Check']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Reason for not sending the Underwriting Quality Check']),
	findTestData(testData).getValue('Reason', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/text_CommentsSection', [('commentField') : 'Comments']), 'Test test test test')

 
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_Submit'),
	25)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))
//Clicks on a button to initiate contract certainty.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_InitiateContractCertanity'))

// Click on a button to save the form in a web application.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Save'))

//Click on the close button at the top of the page
WebUI.click(findTestObject('Object Repository/NewBusiness/button_CloseContractCertainty'))

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_Finalise'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Finalise'))

WebUI.scrollToElement(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))

String signedStatus1 = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))
WebUI.comment(signedStatus1)
GenericUtils.verifyMatch('Status Value is', signedStatus1, 'Signed', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Cancel Reason ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/select_DynamicDropDown', [('dropDownLabel') : 'Cancel Reason ']),
	findTestData(testData).getValue('CancelReason', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/text_CommentsSection', [('commentField') : 'Cancel Reason Description ']), 'Test test test test')

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_Submit_1'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit_1'))

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit_1'))

String signedStatus2 = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))
WebUI.comment(signedStatus2)
GenericUtils.verifyMatch('Status Value is', signedStatus2, 'Cancelled', 'EQUAL')


WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector', [('tabName') : 'Endorsements']))


WebUI.switchToFrame(findTestObject('Object Repository/Endorsements/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

//Verifying Data Validation field names
List<WebElement> endorsementTableHeadersName = WebUI.findWebElements(findTestObject('Object Repository/Endorsements/webElement_ListOfEndorsementVersionTableHeaders'),
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
List<WebElement> endorsementTableValues = WebUI.findWebElements(findTestObject('Object Repository/Endorsements/webElement_ListOfTableValues',[('version') : 1]),
	GlobalVariable.timeOutValue)

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

String endorsementNumber = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_EndorsementNumber', [('attributeName') : 'Endorsement Number', ('version') : 1]))

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_DynamicTabSelector', [('tabName') :  'Post Bind']))


WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/webElement_Instalments'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Endorsements/webElement_Instalments'))


String OriginalPremium = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_OriginalPremium'))

OriginalPremium = OriginalPremium.replace(',','')

String ReturnPremium = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_ReturnPremium'))
ReturnPremium = ReturnPremium.replace(',','')

float sumofPremiums = Float.parseFloat(OriginalPremium) + Float.parseFloat(ReturnPremium)
KeywordUtil.logInfo(sumofPremiums)

String sum = String.valueOf(sumofPremiums);
GenericUtils.verifyMatch('Sum of Original + Return Premium is', sum, '0.0', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))

return endorsementNumber

return ReturnPremium

return OriginalPremium
