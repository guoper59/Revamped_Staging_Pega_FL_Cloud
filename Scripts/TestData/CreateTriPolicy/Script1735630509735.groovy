/**
 * ============================================================================
 * Title        : CreateTriPolicy
 * Title         : CreateTriPolicy
 * Folder        : Scripts/TestData/CreateTriPolicy
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
import com.kms.katalon.core.testobject.TestObject

String stateValue = findTestData(testDataName).getValue('State', rowNumber)

String timeStamp = GenericUtils.getCurrentTimestamp()

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'(username, password, findTestData(testDataName).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Creating a Submission')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Click on the 'Create' button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

//Wait for the 'Insured' element to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

SubmissionHelper.enterInsuredDetails(testDataName, rowNumber)
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'No']), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/radioButton_ReinsuredInformation', 
        [('optionToSelect') : 'No']))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Broker'))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/select_DropdownCountry'), findTestData(testDataName).getValue(
        'Country', rowNumber), false)
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_UpdateInsured/input_MinimumCharacters', [('input') : 'Broker']), 
    findTestData(testDataName).getValue('Broker', rowNumber))
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : stateValue]), 
    GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : stateValue]))

WebUI.enhancedClick(findTestObject('Object Repository/NewBusiness/webElement_BrokerAutoCompleteResult', [('projectName') : brokerValue, ('state') : stateValue]))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBrokerContact'), 
    findTestData(testDataName).getValue('Broker Contact', rowNumber), false)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
SubmissionHelper.enterGeneralData(testDataName, rowNumber)
String currentDate = new SimpleDateFormat('dd/MM/yyyy').format(Calendar.getInstance().time)

String submissionReceivedDate = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Submission Received Date']), 
    'data-value')

GenericUtils.verifyMatch('Submission Received Date Value is', submissionReceivedDate, currentDate, 'EQUAL')

String caseID = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseID'))

WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Enterprise Value']), findTestData(
        testDataName).getValue('EnterpriseValue', rowNumber))
WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'EV Currency ']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'EV Currency ']), 
    findTestData(testDataName).getValue('EVCurrency', rowNumber), false)
WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Working Status']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Working Status']), 
    findTestData(testDataName).getValue('WorkingStatus', rowNumber), false)
WebUI.sendKeys(findTestObject('Object Repository/NewBusiness/webElement_Comments', [('commentField') : 'Working Status Note']), 
    'Test Test')
String actualTargetName = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicValues', [('fieldName') : 'Target Name ']), 
    FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('Target Name Is : ', actualTargetName, findTestData(testDataName).getValue('TargetName', rowNumber), 
    'EQUAL')

String actualTargetDomicile = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicValues', 
        [('fieldName') : 'Target Domicile']), FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('Target Domicile Is : ', actualTargetDomicile, findTestData(testDataName).getValue('TargetDomicile', 
        rowNumber), 'EQUAL')

String actualTargetNAIC = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicValues', [('fieldName') : 'Target NAIC']), 
    FailureHandling.STOP_ON_FAILURE)

GenericUtils.verifyMatch('Target NAIC Is : ', actualTargetNAIC, findTestData(testDataName).getValue('TargetNAIC', rowNumber), 
    'EQUAL')

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))
WebUI.waitForElementPresent(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyReference'), 180)

String policyRef = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyReference'))

GlobalVariable.PolicyRef = policyRef

KeywordUtil.logInfo(policyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_OK'))
return policyRef