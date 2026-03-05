/**
 * ============================================================================
 * Title        : UnderwriterApproval
 * Title         : UnderwriterApproval
 * Folder        : Scripts/TestData/UnderwriterApproval
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

//Login to the Application again
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'(findTestData(testData1).getValue('UserName', rowNumber2),
	findTestData(testData1).getValue('Password', rowNumber2), findTestData(testData1).getValue('Role', rowNumber2))


//Wait for the specified element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

//NAvigate to UW/Fac RI Quality Check

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : uwTab]))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement',[('fieldToEnter'):labelName.get('checkBoxViewAll')]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement',[('fieldToEnter'):labelName.get('checkBoxViewAll')]))

GenericUtils.filterColumnByValue("Policy Number", GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/Page_Underwriter/webElement_TaskID'))

WebUI.click(findTestObject('Object Repository/Page_Underwriter/input_SelectAllYes'))

WebUI.click(findTestObject('Object Repository/Page_Underwriter/button_Approve'))


CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'(findTestData(testData1).getValue('UserName', rowNumber1),
	findTestData(testData1).getValue('Password', rowNumber1), findTestData(testData1).getValue('Role', rowNumber1))


//Wait for the specified element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

//NAvigate to UW/Fac RI Quality Check

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : uwTab]))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement',[('fieldToEnter'):labelName.get('checkBoxViewAll')]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DynamicWebElement',[('fieldToEnter'):labelName.get('checkBoxViewAll')]))

GenericUtils.filterColumnByValue("Policy Number", GlobalVariable.PolicyRef)


WebUI.click(findTestObject('Object Repository/Page_Underwriter/webElement_TaskID'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Underwriter/button_Complete'), GlobalVariable.timeoutShort)
WebUI.click(findTestObject('Object Repository/Page_Underwriter/button_Complete'))


	


