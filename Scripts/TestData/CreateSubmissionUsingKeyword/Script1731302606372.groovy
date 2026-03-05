/**
 * ============================================================================
 * Title        : CreateSubmissionUsingKeyword
 * Title         : CreateSubmissionUsingKeyword
 * Folder        : Scripts/TestData/CreateSubmissionUsingKeyword
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
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper as SubmissionHelper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject


String testData = 'CreateSubmission'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Create'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))


WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Insured'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

SubmissionHelper.enterInsuredDetails(testData, rowNumber)

SubmissionHelper.selectReinsured(testData, rowNumber)


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 
    60, FailureHandling.OPTIONAL)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
SubmissionHelper.enterBrokerDetails(testData, rowNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'), 60)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
SubmissionHelper.enterGeneralData(testData, rowNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 60)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'), 
    60, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'), 180)
String policyRef = WebUI.getText(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_sPolicyReference'))

KeywordUtil.logInfo(policyRef)
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'), 60)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_OK'))
//Uw Worksheet
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/webElement_Continue'))
SubmissionHelper.enterDetailsUWSheet(testData, rowNumber)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_CompleteQuote'))


//TODO: 540274: Remove the Quote Doc and Broker Bind Doc stage from the Pega data entry workflow
////Click on takeup the quote.
WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))
//TODO: 540276 Generate a Quote Letter document and to Take Up a Quote version to the Bind stage to be amended and moved to the Underwriting stage
WebUI.waitForElementClickable(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'), 25)

WebUI.click(findTestObject('Object Repository/NewBusiness/select_QuoteCheckbox'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'), 25)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_TakeUpQuote'))


SubmissionHelper.enterDetailsUW(testData, rowNumber)

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'), 180)

WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_Continue'))





SubmissionHelper.enterDetailsinPostBindStage(testData, rowNumber)


WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/button_Close'))


return policyRef
