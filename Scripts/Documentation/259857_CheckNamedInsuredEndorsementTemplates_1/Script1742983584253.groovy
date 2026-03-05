/**
 * ============================================================================
 * Test Case ID : 259857
 * Title         : Check Named Insured Endorsement Templates 1
 * Folder        : Scripts/Documentation/259857_CheckNamedInsuredEndorsementTemplates_1
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

import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


String testData = 'Documentation'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)


// Wait for a specific element related to case content options to be visible within 10 seconds.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions',
		[('linkToClick') : 'Bind Policy']), 10, FailureHandling.STOP_ON_FAILURE)

//Click on a link within the case content options.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions', [('linkToClick') : 'Bind Policy']))


if( WebUI.verifyElementVisible(findTestObject('Object Repository/Documentation/btn_Cancel'),  FailureHandling.OPTIONAL)){
	WebUI.click(findTestObject('Object Repository/Documentation/btn_Cancel'))
}


WebUI.waitForElementVisible(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_SubmitPostBind'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CreateUnderwriting'))


// Wait for a specific element related to case content options to be visible within 10 seconds.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions',
		[('linkToClick') : 'Bind Policy']), 10, FailureHandling.STOP_ON_FAILURE)

//Click on a link within the case content options.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_CaseContentOptions', [('linkToClick') : 'Bind Policy']))


// Wait for the finalise policy button to be visible based on a specified timeout value.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)


//Click on the finalise policy button.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_FinalisePolicy'))


// Wait for the 'Finalise Policy' prompt to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_FinalisePolicyPrompt'),
	GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)


//Click on the 'Proceed' button.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/button_Proceed'))


//Get the text of a specific element on the web page.
String signedStatus = WebUI.getText(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_Status'))
KeywordUtil.logInfo(signedStatus)

//Wait for the 'Policy Docs' tab to be visible in the dynamic tab selector.
WebUI.click(findTestObject('Object Repository/Endorsements/button_ExpandItems'))
WebUI.click(findTestObject('Object Repository/Endorsements/webElement_TabSelectorExpansion' , [('tabName') : 'Policy Docs']))


WebUI.verifyElementPresent(findTestObject('Object Repository/Documentation/PolicyCreation/link_WordingList'), GlobalVariable.timeOutValue)

KeywordUtil.logInfo("Wording List link is present")

//Wait for a specific element to be visible within a specified timeout.
WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/link_Generate'), GlobalVariable.timeOutValue,
	FailureHandling.STOP_ON_FAILURE)

//Click on a link to generate something.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/link_Generate'))
WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Verifying Data Validation field names
List<WebElement> policyDocsName = WebUI.findWebElements(findTestObject('Object Repository/Documentation/PolicyCreation/webElement_PolicyDocsOptions'),
	GlobalVariable.timeOutValue)

List<WebElement> policyDocsOptionsList = new ArrayList<String>()

for (WebElement e : policyDocsName) {
	policyDocsOptionsList.add(e.getText())
}

GenericUtils.compareLists(policyDocsOptionsList, expectedPolicyDocsList)

WebUI.switchToDefaultContent()

//Click on a link to generate something.
WebUI.click(findTestObject('Object Repository/Documentation/PolicyCreation/link_Generate'))
WebUI.click(findTestObject('Object Repository/NewBusiness/webElement_PolicyDocType',[('docName') : 'Named Insured']))
WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown',
	[('dropDownLabel') : 'Select Format']), rowNumber)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown',
	[('dropDownLabel') : 'Select Language']), rowNumber)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', [('dropDownLabel') : 'Select Language']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown',
	[('dropDownLabel') : 'Select Language']), findTestData(testData).getValue('Language', rowNumber), false)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown', [('dropDownLabel') : 'Select Template']))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/select_DynamicDropDown',
	[('dropDownLabel') : 'Select Template']), findTestData(testData).getValue('Template', rowNumber), false)

WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/button_Submit'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/NewBusiness/button_Submit'))
WebUI.switchToWindowIndex(1)

WebUI.waitForElementVisible(findTestObject('Object Repository/Documentation/PolicyCreation/button_LogOutPopUp'), GlobalVariable.timeOutValue)
 WebUI.switchToFrame(findTestObject('Object Repository/Documentation/PolicyCreation/iframePdfViewer'),
	GlobalVariable.timeOutValue)
 
 
 WebUI.verifyTextPresent('Tokio Marine', false)
 WebUI.verifyTextPresent('HCC Special Coverages', false)
 WebUI.verifyTextPresent('Endorsement', false)
 WebUI.verifyTextPresent('Endorsement', false)
 WebUI.verifyTextPresent('Nr. 1', false)
 WebUI.verifyTextPresent('POLICY NUMBER', false)
 WebUI.verifyTextPresent(GlobalVariable.PolicyRef, false)
 WebUI.verifyTextPresent('It is agreed that ITEM 1 (Insured) of the Schedule shall read', false)
 WebUI.verifyTextPresent('ITEM 1', false)
 WebUI.verifyTextPresent('NAMED INSURED', false)
 WebUI.verifyTextPresent('Name', false)
 WebUI.verifyTextPresent(findTestData(testData).getValue('ActualInsured', rowNumber),false)
 WebUI.verifyTextPresent('Principal Address:', false)
 WebUI.verifyTextPresent(findTestData(testData).getValue('Addressline', rowNumber),false)
 WebUI.verifyTextPresent(findTestData(testData).getValue('PostCode', rowNumber),false)
 WebUI.verifyTextPresent(findTestData(testData).getValue('City', rowNumber),false)
 WebUI.verifyTextPresent(findTestData(testData).getValue('Country', rowNumber),false)
 WebUI.verifyTextPresent('ALL OTHER TERMS AND CONDITIONS', false)
 WebUI.verifyTextPresent('REMAIN UNCHANGED.', false)
 WebUI.verifyTextPresent('This', false)
 WebUI.verifyTextPresent('Endorsement', false)
 WebUI.verifyTextPresent('01 March 2023', false)
 WebUI.verifyTextPresent('at 00:00 CET.', false)
 WebUI.verifyTextPresent('Insurer: Tokio', false)
 WebUI.verifyTextPresent('Marine Europe, S.', false)
 WebUI.verifyTextPresent('A.', false)
 WebUI.verifyTextPresent('Barcelona,', false)
 
 WebUI.switchToDefaultContent()
 