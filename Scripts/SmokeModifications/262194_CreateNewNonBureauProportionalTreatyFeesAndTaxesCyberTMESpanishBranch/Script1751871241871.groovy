/**
 * ============================================================================
 * Test Case ID : 262194
 * Title         : Create New Non Bureau Proportional Treaty Fees And Taxes Cyber TME Spanish Branch
 * Folder        : Scripts/SmokeModifications/262194_CreateNewNonBureauProportionalTreatyFeesAndTaxesCyberTMESpanishBranch
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

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

String testData = 'NewBusiness'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)


CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData).getValue('Role', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

KeywordUtil.logInfo('Creating a Submission')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//Click on the 'Create' button.
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))


//Wait for the 'Insured' element to be visible
//
WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Yes',[('reinsuredYes'):'No']))

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
    findTestData(testData).getValue('NoBrokerOption', rowNumber), false)
WebUI.waitForElementClickable(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Other Business Provider']), 
    GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Other Business Provider']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/OutwardsPolicy/select_DynamicDropDown', [('dropDownLabel') : 'Other Business Provider']), 
    findTestData(testData).getValue('BusinessProviderOption', rowNumber), false)
//verify broker related elements



for (int i = 1; i < 4; i++) {

    WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_ContactDetails', [('fieldName') : 'CoverHolderContact$p' + 
                (contactFieldList[(i - 1)])]))
    WebUI.setText(findTestObject('Object Repository/NewBusiness/webElement_ContactDetails', [('fieldName') : 'CoverHolderContact$p' + 
                (contactFieldList[(i - 1)])]), contactDetailsList[(i - 1)])
}

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_Continue'))

//Enter Details in General Data Tab
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownClassType'), 
    GlobalVariable.timeoutShort)

SubmissionHelper.enterGeneralData(testData, rowNumber)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Is Primary/Excess']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Is Primary/Excess']), 
    findTestData(testData).getValue('ISPrimary', rowNumber), false)
WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/webElement_SkipQouteIndicator'), GlobalVariable.timeOutValue)

String currentDate = new SimpleDateFormat('dd/MM/yyyy').format(Calendar.getInstance().time)

String submissionReceivedDate = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/input_FieldName', [('fieldName') : 'Submission Received Date']), 
    'data-value')

//








//TODO: I need to know when it should be bureau to don't do this
if (WebUI.verifyElementPresent(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), 25, FailureHandling.OPTIONAL) ){
	if ( WebUI.verifyElementChecked(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'), 25, FailureHandling. OPTIONAL ) ){
		WebUI.uncheck(findTestObject('Object Repository/NewBusiness/checkbox_BureauIndicator'))
	}
}

WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_Continue'), 10)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))
WebUI.waitForElementPresent(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyReference'), 180)

String policyRef = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_PolicyReference'))

GlobalVariable.PolicyRef = policyRef

KeywordUtil.logInfo(policyRef)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_OK'))

//Enter details in Uw worksheet
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownUWAuthority'), 
    findTestData(testData).getValue('UW Authority', rowNumber), false)


WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownBaseCurrencyCode'), 
    findTestData(testData).getValue('Original Currency', rowNumber), false)


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TMHCCWrittenParticipation'), 
    findTestData(testData).getValue('TMHCC Written Participation%', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_TMHCCWrittenParticipation'), 
    Keys.chord(Keys.TAB))


//Validate the TMHCC Signed Participation and Calculated Line % values.
List<WebElement> calculatedValues = WebUI.findWebElements(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_TMHCCSignedParticipation'), 
    GlobalVariable.timeoutShort)

WebUI.switchToFrame(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/iframe_PegaGadget1Ifr'), 
    GlobalVariable.timeoutShort)
for (int i = 0; i < (calculatedValues.size() - 1); i++) {

    String THMCCSigned_Actual = calculatedValues.get(i).getAttribute('value')

    GenericUtils.verifyMatch('TMHCC Signed Participation & Calculated Line value is ', THMCCSigned_Actual, findTestData(
            testData).getValue('TMHCC Written Participation%', rowNumber) + '.00000', 'EQUAL')
	

}

WebUI.switchToDefaultContent()

//Verifying the values
//
//
//
//
//
//
//
//
//
//

//Enter Commission value
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'), 
    GlobalVariable.timeOutValue)


WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_CommissionPercentage'), 
    findTestData(testData).getValue('Commission', rowNumber))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_PremiumCalculate'))

//
//
//
//                , ('fieldName') : i +'$ppyNote']))
//                , ('fieldName') :'$ppyNote']), payableToList[(i - 1)], false)
//
//                , ('fieldName') : i + '$pFeeType']))
//                , ('fieldName') : i + '$pFeeType']), feeTypeList[(i - 1)], false)
//                , ('fieldName') : i + '$pFeePercentage']), GlobalVariable.timeOutValue)
//
//                , ('fieldName') : i + '$pFeePercentage']), feePercentList[(i - 1)])

//verify the policy details
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'), 25)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DropdownIsTacItRenewal'), 
    findTestData(testData).getValue('IsTacitRenewal', rowNumber), false)
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Cyber War Exclusions']), 25)
WebUI.selectOptionByLabel(findTestObject('Object Repository/NewBusiness/select_DynamicDropDown', [('dropDownLabel') : 'Cyber War Exclusions']), 
    findTestData(testData).getValue('Cyber Coverage', rowNumber), false)
//



//
//
//
//
//
//
//
//
//
//
//


//
//
//

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Continue'), 60)
WebUI.scrollToElement(findTestObject('Object Repository/NewBusiness/button_Continue'), 60)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Continue'))



//
//
//
//
//
//
//
//
//
//
//
//
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), 60)

WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), findTestData(
        testData).getValue('Due Date', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/input_DueDate'), Keys.chord(
        Keys.TAB))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))


//Validate the Installments
//
//
//
//

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'), 
    25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'),
	25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))


WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/webElement_UWQCStatus'), 25)
//Status Validations to be added
String uwQCStatus = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_UWQCStatus'))

GenericUtils.verifyMatch('UW QC Status is', uwQCStatus, 'To Be Approved', 'EQUAL')


//
//
//

WebUI.waitForElementVisible(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']), 
    10, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/webElement_CaseContentsOptions', [('linkToClick') : 'Bind Policy']))
WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'))


WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Finalise'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)


WebUI.click(findTestObject('Object Repository/NewBusiness/button_Finalise'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))


String signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', signedStatus, 'Signed', 'EQUAL')

//
//
//
////Clicking Submission Search option from left side menu
////Clicking Dashboard option from left side menu
//
//
//
//
//
////Wait for the specified element to be visible.
//
////Get the text from a web element on the page and stores it in a variable/
//
//// Verify if the actual policy reference matches with the expected policy quote.
//
