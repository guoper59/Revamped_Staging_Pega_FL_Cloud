/**
 * ============================================================================
 * Test Case ID : 259914
 * Title         : Create Policy
 * Folder        : Scripts/TestData/259914_CreatePolicy
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

import com.kms.katalon.core.testobject.TestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable

KeywordUtil.logInfo('Creating a Submission')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Click on the 'Create' button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


//Wait for the 'Insured' element to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

// Enter cover holder information into the submission helper using the provided test data and row number.
SubmissionHelper.enterCoverHolder(testData, rowNumber)

// Select reinsured data based on the specified row number using the SubmissionHelper class.
SubmissionHelper.selectReinsured(testData, rowNumber)

// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
// Enter broker details using the provided test data and row number.
//Entering required fields for No Broker option
WebUI.waitForElementPresent(findTestObject('Object Repository/OutwardsPolicy/radio_DynamicRadioButton', [('radioButtonLabel') : 'No Broker']), 
    GlobalVariable.timeOutValue)


WebUI.enhancedClick(findTestObject('Object Repository/OutwardsPolicy/radio_DynamicRadioButton', [('radioButtonLabel') : 'No Broker']))
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Direct']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Direct']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Direct']), 
    findTestData(testData).getValue('Broker', rowNumber), false)
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Other Business Provider']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Other Business Provider']), 
    findTestData(testData).getValue('BusinessProviderOption', rowNumber), false)
for (int i = 1; i < 4; i++) {

    WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_ContactDetails', [('fieldName') : 'CoverHolderContact$p' + 
                (contactFieldList[(i - 1)])]))
    WebUI.setText(findTestObject('Object Repository/NewBusiness/webElement_ContactDetails', [('fieldName') : 'CoverHolderContact$p' + 
                (contactFieldList[(i - 1)])]), contactDetailsList[(i - 1)])
}


WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Continue'))
// Click on continue button.


SubmissionHelper.enterGeneralData(testData, rowNumber)
String policyPeriod = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Policy Period ']), 'value')
GenericUtils.verifyMatch('Policy Period Value is', policyPeriod, findTestData(testData).getValue('PolicyPeriod', rowNumber), 
    'EQUAL')

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Is Primary/Excess']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Is Primary/Excess']), 
    findTestData(testData).getValue('ISPrimary', rowNumber), false)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))
WebUI.waitForElementPresent(findTestObject('Object Repository/NewBusiness/webElement_PolicyReference'), 180)

String policyRef = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_PolicyReference'))
KeywordUtil.logInfo(policyRef)

GlobalVariable.PolicyRef = policyRef

return policyRef