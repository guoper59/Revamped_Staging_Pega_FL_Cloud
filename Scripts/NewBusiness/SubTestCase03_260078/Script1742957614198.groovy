/**
 * ============================================================================
 * Title        : SubTestCase03 260078
 * Title         : SubTestCase03 260078
 * Folder        : Scripts/NewBusiness/SubTestCase03_260078
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
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject


WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/button_Actions'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Actions'))


WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_View'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_View'))


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))


//Logging in with Underwriter Assistant
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('Hbakker', GlobalVariable.Hbakker, findTestData(testData).getValue('Role', rowNumber))

//Piece of code to handle hamburguer
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Work Basket']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Peer Review']))


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/checkBox_ViewAllPeerReview'))


//Filtering the policy
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/webElement_PolicyReferenceFilter'), 180)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_PolicyReferenceFilter'))


WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/webElement_ClearFilterPeerReview'), 180, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_SearchTextPeerReview', [('fieldName') : 'Search Text']), 
    GlobalVariable.PolicyRef)


WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_ApplyPeerReview'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_ApplyPeerReview'))


WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/webElement_TaskID'),180)

WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_TaskID'))


WebUI.check(findTestObject('Object Repository/NewBusiness/checkBox_SelectedResult'))

WebUI.scrollToElement(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Underwriter Reviewer']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Underwriter Reviewer']))


WebUI.selectOptionByLabel(findTestObject('Object Repository/Dashboards/webElement_DynamicDropDown', [('dropDownLabel') : 'Underwriter Reviewer']), 
    'Adam Bohle', false)


WebUI.click(findTestObject('Object Repository/NewBusiness/button_DynamicTextPeerReview', [('buttonName') : 'Assign for Peer Review']))


WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/webElement_PeerReviewSuccessMessage'), GlobalVariable.timeOutValue)

String peerReviewSuccessMessage = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PeerReviewSuccessMessage'))

GenericUtils.verifyMatch('Peer Review Assignee Message', peerReviewSuccessMessage, 'Selected tasks have been assigned successfully', 
    'EQUAL')


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.scrollToElement(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_LogOff'))

