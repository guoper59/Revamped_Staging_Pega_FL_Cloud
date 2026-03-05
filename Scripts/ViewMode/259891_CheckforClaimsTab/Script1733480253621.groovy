/**
 * ============================================================================
 * Test Case ID : 259891
 * Title         : Checkfor Claims Tab
 * Folder        : Scripts/ViewMode/259891_CheckforClaimsTab
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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import common.WebTableUtils as WebTableUtils
import internal.GlobalVariable as GlobalVariable

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

String testData = 'SearchSubmission'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

String testData1 = 'Credentials'

//Finding Row number from Test Data.
int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

// Navigate to a specified URL.
WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

//Perform a login operation using the provided username, password, and role from test data.
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('emueller', GlobalVariable.Emueller, findTestData(testData1).getValue('Role', rowNumber1))

//Wait for the specified element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue)

// Retrieve the value of 'Policy Reference' from test data using the specified row number.
String policyRef = findTestData(testData).getValue('Policy Reference', rowNumber)
KeywordUtil.logInfo(policyRef.toString())

//Selects an option in a dropdown menu by Years of Account
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_PegaCaseManagerPortal/select_DropdownYearsofAccount'), 
    'Unknown', false)

// Enters the value '1234567890' in the policy reference field on the Pega Case Manager Portal
WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), policyRef)

// Click on the search button in the Pega Case Manager Portal.
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/btn_SubmissionSearch'))

//Get the text from a web element on the page and stores it in a variable/
String policyQuote = WebUI.getText(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_forValidation', 
        [('fieldName') : 'Policy Reference']), FailureHandling.STOP_ON_FAILURE)

// Verify if the actual policy reference matches with the expected policy quote.
GenericUtils.verifyMatch('Search Policy By Reference is Successful', policyRef, policyQuote, 'EQUAL')

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/button_Actions'))

WebUI.scrollToElement(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/WebElement_View'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/WebElement_View'))


List<WebElement> tabs = WebUI.findWebElements(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_VerifyTabHeaders'), 
    GlobalVariable.timeOutValue)

List<WebElement> actualHeaders = new ArrayList<String>()

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget0Ifr'), GlobalVariable.timeoutShort)

for (int i = 0; i < (tabs.size() - 2); i++) {
    actualHeaders.add(tabs.get(i).getAttribute('aria-label'))
}

WebUI.switchToDefaultContent()

//verify tab headers

GenericUtils.compareLists(expectedHeaders, actualHeaders)


WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_CurrentlyOpen0'), 
   GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_CurrentlyOpen0'))



WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_ClickonTab0', [
            ('tabName') : 'Claims']))
            


WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table', 
        [('tableName') : 'Claims']), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.scrollToElement(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), GlobalVariable.timeOutValue)

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget0Ifr'), GlobalVariable.timeoutShort)

WebUI.switchToDefaultContent()

WebElement tableHeader = WebUI.findWebElement(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table', 
        [('tableName') : 'Claims']), GlobalVariable.timeOutValue)

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget0Ifr'), GlobalVariable.timeoutShort)

List<WebElement> headers = tableHeader.findElements(By.xpath('tr/th'))

List<WebElement> actualtableHeaders = new ArrayList<String>()

for (int i = 0; i < headers.size(); i++) {
    actualtableHeaders.add(headers.get(i).getAttribute('data-attribute-name'))
}
WebUI.switchToDefaultContent()

//verify endorsement details

GenericUtils.compareLists(expectedTableHeaders, actualtableHeaders)

//verify claim details

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
		[('tableName') : 'Claims']), 'Claims Status', ClaimValuesRow1.get('ClaimsStatus'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
		[('tableName') : 'Claims']), 'Claims ID', ClaimValuesRow1.get('ClaimsID'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
		[('tableName') : 'Claims']), 'Opened Date', ClaimValuesRow1.get('OpenedDate'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
		[('tableName') : 'Claims']), 'Notified Date', ClaimValuesRow1.get('NotifiedDate'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
		[('tableName') : 'Claims']), 'Claims Title', ClaimValuesRow1.get('ClaimsTitle'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
		[('tableName') : 'Claims']), 'Claims Handler Name', ClaimValuesRow1.get('ClaimsHandlerName'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Date of Loss', ClaimValuesRow1.get('DateofLoss'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Loss Location', ClaimValuesRow1.get('LossLocation'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Last Movement Date', ClaimValuesRow1.get('LastMovementDate'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Description', ClaimValuesRow1.get('Description'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'USD TMHCC Paid Claims amount', ClaimValuesRow1.get('USDTMHCCPaidClaimsamount'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'USD TMHCC Total Claims amount', ClaimValuesRow1.get('USDTMHCCTotalClaimsamount'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Policy Ori. Ccy', ClaimValuesRow1.get('PolicyOri.Ccy'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Exchange Rate', ClaimValuesRow1.get('ExchangeRate'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Ori. TMHCC Paid Claims amount', ClaimValuesRow1.get('Ori.TMHCCPaidClaimsamount'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Ori. TMHCC Out standing Claims Amount', ClaimValuesRow1.get('Ori.TMHCCOutstandingClaimsAmount'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Ori. TMHCC  Total Claims Amount', ClaimValuesRow1.get('Ori.TMHCCTotalClaimsAmount'))
WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
		[('tableName') : 'Claims']), 'Claims Status', ClaimValuesRow2.get('ClaimsStatus'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
		[('tableName') : 'Claims']), 'Claims ID', ClaimValuesRow2.get('ClaimsID'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
		[('tableName') : 'Claims']), 'Opened Date', ClaimValuesRow2.get('OpenedDate'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
		[('tableName') : 'Claims']), 'Notified Date', ClaimValuesRow2.get('NotifiedDate'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
		[('tableName') : 'Claims']), 'Claims Title', ClaimValuesRow2.get('ClaimsTitle'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
		[('tableName') : 'Claims']), 'Claims Handler Name', ClaimValuesRow2.get('ClaimsHandlerName'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Date of Loss', ClaimValuesRow2.get('DateofLoss'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Loss Location', ClaimValuesRow2.get('LossLocation'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Last Movement Date', ClaimValuesRow2.get('LastMovementDate'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Description', ClaimValuesRow2.get('Description'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'USD TMHCC Paid Claims amount', ClaimValuesRow2.get('USDTMHCCPaidClaimsamount'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'USD TMHCC Total Claims amount', ClaimValuesRow2.get('USDTMHCCTotalClaimsamount'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Policy Ori. Ccy', ClaimValuesRow2.get('PolicyOri.Ccy'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Exchange Rate', ClaimValuesRow2.get('ExchangeRate'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Ori. TMHCC Paid Claims amount', ClaimValuesRow2.get('Ori.TMHCCPaidClaimsamount'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Ori. TMHCC Out standing Claims Amount', ClaimValuesRow2.get('Ori.TMHCCOutstandingClaimsAmount'))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table',
	[('tableName') : 'Claims']), 'Ori. TMHCC  Total Claims Amount', ClaimValuesRow2.get('Ori.TMHCCTotalClaimsAmount'))
