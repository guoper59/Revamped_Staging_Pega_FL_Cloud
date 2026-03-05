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

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

///Calling Get API to validate response---SBS ECLIPSE
ResponseObject response = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetRenewalDate'), null)

String renewalCreationDate = WS.getElementText(response, 'PolicyEnquiryResponse.PolicyEnquiryResult[0].RenewalCreationDate')

KeywordUtil.logInfo('Renewal Creation Date value is ::' + renewalCreationDate)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.renewalAgentUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'(GlobalVariable.renewalUsername, GlobalVariable.vipin, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/RenewalAgent/webElement_RecordsLink'), 25)

WebUI.click(findTestObject('Object Repository/RenewalAgent/webElement_RecordsLink'))


WebUI.click(findTestObject('Object Repository/RenewalAgent/webElement_TechnicalOption'))


WebUI.click(findTestObject('Object Repository/RenewalAgent/webElement_ActivityOption'))

//Click on activity filter and pass "RetreiveRenewalPolicies"

WebUI.click(findTestObject('Object Repository/RenewalAgent/webElement_ActivityNameFilter'))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_ClearFilterPeerReview'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_SearchTextPeerReview', [('fieldName') : 'Search Text']),
	ActivityName)


WebUI.click(findTestObject('Object Repository/NewBusiness/button_ApplyPeerReview'))

WebUI.click(findTestObject('Object Repository/RenewalAgent/webElement_Sort'))


WebUI.click(findTestObject('Object Repository/RenewalAgent/webElement_SelectRuleSet'))


WebUI.click(findTestObject('Object Repository/RenewalAgent/webElement_Expand'))


WebUI.scrollToElement(findTestObject('Object Repository/RenewalAgent/Page_Pega Dev Studio/input_PropertiesValue_PRH_1ppyStepsl3ppyParamArrayl2pPropertiesValue'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/RenewalAgent/Page_Pega Dev Studio/input_PropertiesValue_PRH_1ppyStepsl3ppyParamArrayl2pPropertiesValue'))
WebUI.sendKeys(findTestObject('Object Repository/RenewalAgent/Page_Pega Dev Studio/input_PropertiesValue_PRH_1ppyStepsl3ppyParamArrayl2pPropertiesValue'), 
    Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/RenewalAgent/Page_Pega Dev Studio/input_PropertiesValue_PRH_1ppyStepsl3ppyParamArrayl2pPropertiesValue'), 
    "\"$renewalCreationDate\"")
WebUI.scrollToElement(findTestObject('Object Repository/RenewalAgent/Page_Pega Dev Studio/input_PropertiesValue_PRH_1ppyStepsl3ppyParamArrayl3pPropertiesValue'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/RenewalAgent/Page_Pega Dev Studio/input_PropertiesValue_PRH_1ppyStepsl3ppyParamArrayl3pPropertiesValue'))
WebUI.sendKeys(findTestObject('Object Repository/RenewalAgent/Page_Pega Dev Studio/input_PropertiesValue_PRH_1ppyStepsl3ppyParamArrayl3pPropertiesValue'), 
    Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/RenewalAgent/Page_Pega Dev Studio/input_PropertiesValue_PRH_1ppyStepsl3ppyParamArrayl3pPropertiesValue'), 
    "\"$renewalCreationDate\"")



WebUI.waitForElementClickable(findTestObject('Object Repository/RenewalAgent/button_ActionsExpand'), 25)
WebUI.click(findTestObject('Object Repository/RenewalAgent/button_ActionsExpand'))
WebUI.click(findTestObject('Object Repository/RenewalAgent/button_Run'))

WebUI.switchToWindowIndex(1)


WebUI.verifyElementClickable(findTestObject('Object Repository/Renewal/button_RunAgent'))

WebUI.sendKeys(findTestObject('Object Repository/Renewal/input_PolicyRef'), GlobalVariable.PolicyRef)

WebUI.waitForElementClickable(findTestObject('Object Repository/Renewal/button_RunAgent'), 25)
WebUI.click(findTestObject('Object Repository/Renewal/button_RunAgent'))


WebUI.switchToWindowIndex(2)
WebUI.waitForElementVisible(findTestObject('Object Repository/Renewal/webElement_RenewedPolicy'), 60)
String renewedPolicy = WebUI.getText(findTestObject('Object Repository/Renewal/webElement_RenewedPolicy'), FailureHandling.STOP_ON_FAILURE).split(
    '/').first()

KeywordUtil.logInfo('Renewed Policy generated is ::' + renewedPolicy)

GlobalVariable.RenewedPolicy = renewedPolicy

WebUI.closeBrowser()