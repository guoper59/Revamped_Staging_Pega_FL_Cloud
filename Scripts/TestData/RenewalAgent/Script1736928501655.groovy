/**
 * ============================================================================
 * Title        : RenewalAgent
 * Title         : RenewalAgent
 * Folder        : Scripts/TestData/RenewalAgent
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

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


//Calling Get API to validate response---SBS ECLIPSE
ResponseObject response = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetRenewalDate'), null)

String renewalCreationDate = WS.getElementText(response, 'PolicyEnquiryResponse.PolicyEnquiryResult[0].RenewalCreationDate')

KeywordUtil.logInfo('Renewal Creation Date value is ::'+renewalCreationDate)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.renewalAgentUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'(findTestData(testData).getValue('Username', rowNumber), 
    findTestData(testData).getValue('Password', rowNumber), findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Renewal/webElement_RecordsLink'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Renewal/webElement_RecordsLink'))


WebUI.click(findTestObject('Object Repository/Renewal/webElement_TechnicalOption'))


WebUI.click(findTestObject('Object Repository/Renewal/webElement_ActivityOption'))


WebUI.click(findTestObject('Object Repository/Renewal/webElement_SelectRuleSet'))


WebUI.scrollToElement(findTestObject('Object Repository/Renewal/webElement_Scroll'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Renewal/webElement_Expand'))

WebUI.click(findTestObject('Object Repository/Renewal/input_CreationDate'))

WebUI.sendKeys(findTestObject('Object Repository/Renewal/input_CreationDate'), Keys.chord(Keys.CONTROL,'a'))

WebUI.sendKeys(findTestObject('Object Repository/Renewal/input_CreationDate'), "\"$renewalCreationDate\"")


WebUI.verifyElementVisible(findTestObject('Object Repository/Renewal/input_CreationDateFrom'))

WebUI.scrollToElement(findTestObject('Object Repository/Renewal/webElement_Scroll'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Renewal/input_CreationDateFrom'))

WebUI.sendKeys(findTestObject('Object Repository/Renewal/input_CreationDateFrom'), Keys.chord(Keys.CONTROL,'a'))

WebUI.sendKeys(findTestObject('Object Repository/Renewal/input_CreationDateFrom'), "\"$renewalCreationDate\"")

WebUI.click(findTestObject('Object Repository/Renewal/button_Save'))


WebUI.click(findTestObject('Object Repository/Renewal/button_ActionsExpand'))

WebUI.click(findTestObject('Object Repository/Renewal/button_Run'))

WebUI.switchToWindowIndex(1)

WebUI.verifyElementClickable(findTestObject('Object Repository/Renewal/button_RunAgent'))

WebUI.sendKeys(findTestObject('Object Repository/Renewal/input_PolicyRef'), GlobalVariable.PolicyRef)


WebUI.click(findTestObject('Object Repository/Renewal/button_RunAgent'))


WebUI.switchToWindowIndex(2)

String renewedPolicy = WebUI.getText(findTestObject('Object Repository/Renewal/webElement_RenewedPolicy'))

KeywordUtil.logInfo('Renewed Policy generated is ::'+renewedPolicy)

WebUI.closeBrowser()
