/**
 * ============================================================================
 * Test Case ID : 262197
 * Title         : Create Outwards FAC Policy1
 * Folder        : Scripts/OutwardsFACRI/262197_CreateOutwardsFACPolicy1
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
import com.kms.katalon.core.mobile.keyword.builtin.VerifyElementCheckedKeyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.testobject.TestObject

int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)


//Loggging in with Underwriter
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('prayner', GlobalVariable.Prayner, findTestData(testData).getValue('Role', rowNumber))


WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Quality Check']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_NewDynamicDropDown', [('dropDownLabel') : 'Quality Check Type']),
	GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_NewDynamicDropDown', [('dropDownLabel') : 'Quality Check Type']))


WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_NewDynamicDropDown', [('dropDownLabel') : 'Quality Check Type']),
	findTestData(testData).getValue('TypeOfQualitycheck', rowNumber), false)


//Filtering the policy
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'))


WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_ClearFilter'), 60,
	FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_SearchTextInFilter', [('fieldName') : 'Search Text']),
	GlobalVariable.PolicyRef)


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Apply'))


//Clicking on task link
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'), 60)


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'))


WebUI.check(findTestObject('Object Repository/OutwardsPolicy/checkbox_UnderwriterDecision', [('optionToSelect') : 'Yes']))


WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Approve'), 60)
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Approve'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('ybiancini', GlobalVariable.ybiancini, findTestData(testData).getValue('Role', rowNumber))


WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Quality Check']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/checkbox_ViewAllCases'))

if ( !WebUI.verifyElementChecked(findTestObject('Object Repository/OutwardsPolicy/checkbox_ViewAllCases'), 10 )) {
	WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/checkbox_ViewAllCases'))
}

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'), 60)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyFilter'))
WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_ClearFilter'), 60,
	FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/OutwardsPolicy/input_SearchTextInFilter', [('fieldName') : 'Search Text']),
	GlobalVariable.PolicyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Apply'))
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'), GlobalVariable.timeoutShort)


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_TaskLink'))

WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Complete'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Complete'))
WebUI.verifyElementPresent(findTestObject('Object Repository/OutwardsPolicy/webElement_SuccessMessage'), GlobalVariable.timeoutShort,
	FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Dashboards/button_Close'))
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
		[('optionToSelect') : 'Submission Search']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Submission Search']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.PolicyRef)
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/button_Actions'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Actions'))
WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/button_Modify'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Modify'))
WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Fac RI Order Form Case']),
	10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Fac RI Order Form Case']))
WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_SubmitFAC'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_SubmitFAC'))
WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_Status'), 10, FailureHandling.STOP_ON_FAILURE)

//Verifying the final status message
String finalStatus = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_FinalSuccessMessage'))

GenericUtils.verifyMatch('Final status is ', finalStatus, findTestData(testData).getValue('ExpectedFinalStatus', rowNumber),
	'EQUAL')

//Verifying the final status
String resolveStatus = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_Status'))

GenericUtils.verifyMatch('Task status is ', resolveStatus, findTestData(testData).getValue('ResolveStatus', rowNumber),
	'EQUAL')

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/button_CloseTop'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_CloseTop'))
//Verifying if Order Form is available in the attachment
WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/link_TaskInAttachment'), GlobalVariable.timeoutShort)
