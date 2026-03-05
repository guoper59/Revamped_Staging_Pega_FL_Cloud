/**
 * ============================================================================
 * Title        : SubTestCase03 262200
 * Title         : SubTestCase03 262200
 * Folder        : Scripts/NewBusiness/SubTestCase03_262200
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

WebUI.switchToDefaultContent()

WebUI.check(findTestObject('Object Repository/NewBusiness/checkbox_UnderwriterDecision', [('optionToSelect') : 'Yes']))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Approve'), 25)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Approve'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Close'), 25)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Close'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_TaskLink'), 25)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_TaskLink'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Complete'), 25)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Complete'))
WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_SuccessMessage'), 15)
WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_SuccessMessage'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Close'))


WebUI.callTestCase(findTestCase('Test Cases/TestData/262200_AttachmentsValidation'), [('testData') : testData, ('rowNumber') : rowNumber],
	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Eclipse/262200_EclipseValidations'), [('testData') : testData, ('rowNumber') : rowNumber],
	FailureHandling.STOP_ON_FAILURE)