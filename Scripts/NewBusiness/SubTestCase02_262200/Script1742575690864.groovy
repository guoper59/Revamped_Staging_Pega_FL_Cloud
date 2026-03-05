/**
 * ============================================================================
 * Title        : SubTestCase02 262200
 * Title         : SubTestCase02 262200
 * Folder        : Scripts/NewBusiness/SubTestCase02_262200
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
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
	Keys.chord(Keys.CONTROL, 'a'))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerGrossPremium'),
	findTestData(testData).getValue('Layer Gross Premium', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'), 25)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'))

if (WebUI.verifyElementVisible(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'))) {
	WebUI.click(findTestObject('Object Repository/NewBusiness/button_CompleteQuote'))
}

//TODO: 540274: Remove the Quote Doc and Broker Bind Doc stage from the Pega data entry workflow
////Click on takeup the quote.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 60)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))
//TODO: 540276 Generate a Quote Letter document and to Take Up a Quote version to the Bind stage to be amended and moved to the Underwriting stage
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'), 25)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'UW Authority ']),
	findTestData(testData).getValue('UW Authority', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'),
	findTestData(testData).getValue('IsTacitRenewal', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_LayerAGGLimit'), findTestData(
		testData).getValue('Layer AGG Limit', rowNumber))

WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.clearText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'))

WebUI.setText(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), findTestData(testData).getValue('input_Lead', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/webElement_LeadValue'), Keys.chord(Keys.BACK_SPACE))

String currentText =  findTestData(testData).getValue('input_Lead', rowNumber).substring(0, findTestData(testData).getValue('input_Lead', rowNumber).length()-1)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]), GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_AutoCompleteResult', [('projectName') : currentText]))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), 60)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_Continue'), 60)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))
WebUI.waitForElementNotVisible(findTestObject('Object Repository/NewBusiness/button_Save'), 60)

WebUI.waitForPageLoad(60);
WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_Status', [('status') : 'Bound']), 60, FailureHandling.OPTIONAL)

WebUI.waitForElementNotVisible(findTestObject('Object Repository/NewBusiness/button_Continue'), 25)
if ( WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_Continue'), 25, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))
	WebUI.waitForElementNotVisible(findTestObject('Object Repository/NewBusiness/button_Continue'), 60)
	
}

WebUI.waitForElementNotVisible(findTestObject('Object Repository/NewBusiness/button_Continue'), 25)
if ( WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/button_Continue'), 25, FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))
	WebUI.waitForElementNotVisible(findTestObject('Object Repository/NewBusiness/button_Continue'), 60)
	
}

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'), 60)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownTaxApplicable'),
	findTestData(testData).getValue('Tax Applicable', rowNumber), false)