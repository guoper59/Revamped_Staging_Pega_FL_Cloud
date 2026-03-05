/**
 * ============================================================================
 * Test Case ID : 262200
 * Title         : Attachments Validation
 * Folder        : Scripts/TestData/262200_AttachmentsValidation
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


//adding this because on click on Task IN and Close button in the last steps , user not navigating to landing page for entering policy Reference

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', 
        [('optionToSelect') : 'Submission Search']), GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)
//Clicking Dashboard option from left side menu
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : 'Submission Search']))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/input_PolicyReference'), 25, 
    FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/NewBusiness/input_PolicyReference'))
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_PolicyReference') , GlobalVariable.PolicyRef)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_SubmissionSearch'))
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Actions'), 25)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Actions'))
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_ViewFinal'), GlobalVariable.timeoutShort)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_ViewFinal'))


