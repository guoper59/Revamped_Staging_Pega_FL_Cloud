/**
 * ============================================================================
 * Test Case ID : 262218
 * Title         : Create Policy
 * Folder        : Scripts/TestData/262218_CreatePolicy
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

import java.text.SimpleDateFormat

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable

String stateValue = findTestData(testData).getValue('State', rowNumber)

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Creating a Submission')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Click on the 'Create' button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

// Enter cover holder information into the submission helper using the provided test data and row number.
SubmissionHelper.enterInsuredDetails(testData, rowNumber)

// Select reinsured data based on the specified row number using the SubmissionHelper class.
SubmissionHelper.selectReinsured(testData, rowNumber)

// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// Enter broker details using the provided test data and row number.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testData).getValue(
        'CountryName', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']), 
    findTestData(testData).getValue('Broker', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : stateValue]), 
    GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : stateValue]))

WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : stateValue]))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'), 
    findTestData(testData).getValue('Broker Contact', rowNumber), false)

// Click on continue button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))

// Enter details in General Data using the provided test data and row number.
SubmissionHelper.enterGeneralData(testData, rowNumber)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Notes']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Is Master']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Is Local']), GlobalVariable.timeoutShort)

WebUI.verifyElementNotChecked(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValuesCheckbox', 
        [('labelName') : 'Is Tied In']), GlobalVariable.timeoutShort)

String policyPeriod = WebUI.getAttribute(findTestObject('Object Repository/Documentation/PolicyCreation/input_DynamicValues', 
        [('labelName') : 'Policy Period ']), 'value')

GenericUtils.verifyMatch('Policy Period Value is', policyPeriod, findTestData(testData).getValue('PolicyPeriod', rowNumber), 
    'EQUAL')

String currentDate = new SimpleDateFormat('dd/MM/yyyy').format(Calendar.getInstance().time)

String submissionReceivedDate = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Submission Received Date']), 
    'data-value')

GenericUtils.verifyMatch('Submission Received Date Value is', submissionReceivedDate, currentDate, 'EQUAL')

String caseID = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseID'))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Enterprise Value']), findTestData(
        testData).getValue('EnterpriseValue', rowNumber))

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'EV Currency ']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'EV Currency ']), 
    findTestData(testData).getValue('EVCurrency', rowNumber), false)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Working Status']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Working Status']), 
    findTestData(testData).getValue('WorkingStatus', rowNumber), false)

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_Comments', [('commentField') : 'Working Status Note']), 
    'Test Test')

String actualTargetName = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicValues', [('fieldName') : 'Target Name ']), 
    FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('Target Name Is : ', actualTargetName, findTestData(testData).getValue('TargetName', rowNumber), 
    'EQUAL')

String actualTargetDomicile = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicValues', 
        [('fieldName') : 'Target Domicile']), FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('Target Domicile Is : ', actualTargetDomicile, findTestData(testData).getValue('TargetDomicile', 
        rowNumber), 'EQUAL')

String actualTargetNAIC = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicValues', [('fieldName') : 'Target NAIC']), 
    FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('Target NAIC Is : ', actualTargetNAIC, findTestData(testData).getValue('TargetNAIC', rowNumber), 
    'EQUAL')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))

// Wait for the 'OK' element to be visible on the page.
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'), 
    GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)

//Get the text of the 'sPolicyReference' element and store it in 'PolicyRef' variable.
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)

String policyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

GlobalVariable.PolicyRef = policyRef

KeywordUtil.logInfo(GlobalVariable.PolicyRef)

return policyRef