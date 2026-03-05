/**
 * ============================================================================
 * Test Case ID : 262200
 * Title         : Create Policy
 * Folder        : Scripts/TestData/262200_CreatePolicy
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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject


WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Click on the 'Create' button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

//Wait for the 'Start Financial Lines Submission' element to be visible.


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


//Wait for the 'Insured' element to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'))


SubmissionHelper.enterInsuredDetailsForKRTest(testData, rowNumber)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'), 
    GlobalVariable.timeOutValue)

SubmissionHelper.enterBrokerDetailsForKRTest(testData, rowNumber)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
SubmissionHelper.enterGeneralData(testData, rowNumber)


String placingTitle = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_SelectedOption', [('labelName') : 'TMHCC Placing Title']))
//

WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_SkipQouteIndicator'), GlobalVariable.timeOutValue)

String currentDate = new SimpleDateFormat('dd/MM/yyyy').format(Calendar.getInstance().time)

String submissionReceivedDate = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Submission Received Date']), 
    'data-value')


if (WebUI.getText(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Quote Due Date'])).isEmpty()) {
    KeywordUtil.logInfo('Quote Date is empty')
}

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Is SME']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Notes']), GlobalVariable.timeoutShort)

String caseID = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseID'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_Continue'), 25)
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))
WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'), FailureHandling.OPTIONAL)
WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/webElement_PolicyReference'), 180)

String policyRef = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_PolicyReference'))

KeywordUtil.logInfo(policyRef)

GlobalVariable.PolicyRef = policyRef