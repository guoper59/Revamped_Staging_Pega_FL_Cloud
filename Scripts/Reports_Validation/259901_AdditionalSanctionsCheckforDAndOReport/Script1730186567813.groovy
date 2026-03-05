/**
 * ============================================================================
 * Test Case ID : 259901
 * Title         : Additional Sanctions Checkfor D And O Report
 * Folder        : Scripts/Reports_Validation/259901_AdditionalSanctionsCheckforDAndOReport
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
import org.openqa.selenium.WebElement as WebElement
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

//Verify Report

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

String CredentialstestData = credentialsTestData

int credrowNumber = common.FileUtils.findRowNumber('Data Files/' + CredentialstestData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + credrowNumber)

//Navigating to Pega Financial Lines

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('llbusinessadmin', GlobalVariable.llbusinessadmin, findTestData(CredentialstestData).getValue(
		'Role', credrowNumber))

//Loggedin to Pega with valid Business Admin credentials
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), 25)

KeywordUtil.logInfo('Loggedin to Pega with valid Business Admin credentials')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

//navigate to Additional Sanctions check for D&O Report and enter the details
WebUI.click(findTestObject('Object Repository/Page_Reports/webElement_Reports'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Reports/webElement_ReportName', [('ReportName') : 'Additional Sanctions check for D&O Report']),
	25)

WebUI.click(findTestObject('Object Repository/Page_Reports/webElement_ReportName', [('ReportName') : 'Additional Sanctions check for D&O Report']))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Reports/webElement_VerifyReportName', [('ReportName') : 'Additional Sanctions check for D&O Report']),
	25, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Reports/webElement_Loader'), 25)

WebUI.click(findTestObject('Object Repository/Page_Reports/input_DateFilters', [('fieldName') : 'CreatedFrom']))

GenericUtils.SelectDatefromCalendar(findTestData(testData).getValue('Created From Date', rowNumber), findTestObject('Object Repository/Page_Reports/input_Month'),
	findTestObject('Object Repository/Page_Reports/input_Year'))


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Reports/input_DateFilters', [('fieldName') : 'CreatedTo']),
	 GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_Reports/input_DateFilters', [('fieldName') : 'CreatedTo']))

GenericUtils.SelectDatefromCalendar(findTestData(testData).getValue('Created To Date', rowNumber), findTestObject('Object Repository/Page_Reports/input_Month'),
	findTestObject('Object Repository/Page_Reports/input_Year'))
WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Reports/webElement_Loader'), 25)


try {
	WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Reports/button_ExportToExcel'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
}
catch (Exception e) {
}

List<WebElement> headerElements = WebUI.findWebElements(findTestObject('Object Repository/Page_Reports/webElement_Headers'),
	GlobalVariable.timeOutValue)

List<WebElement> actualHeaderList = new ArrayList<String>()

WebUI.switchToFrame(findTestObject('Object Repository/Page_Reports/iframe_PegaGadget0Ifr'), GlobalVariable.timeoutShort)

for (int i = 0; i < headerElements.size(); i++) {
	if (!(headerElements.get(i).getText().equals(' '))) {
		actualHeaderList.add(headerElements.get(i).getText().trim())
	}
}
WebUI.switchToDefaultContent()

GenericUtils.compareLists(expectedHeaderList, actualHeaderList)


//export report details to excel

WebUI.click(findTestObject('Object Repository/Page_Reports/button_ExportToExcel'))

WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Reports/webElement_Loader'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_Reports/button_ExportToExcel'))
String windowIndex = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(1)

KeywordUtil.markPassed('Export to Excel is Successful')

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

//validate the status values after export

WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Reports/webElement_Loader'),  GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_Reports/webElement_VerifyReportName', [('ReportName') : 'Status']))


String caseID = WebUI.getText(findTestObject('Object Repository/Page_Reports/webElement_CaseID'))

WebUI.click(findTestObject('Object Repository/Page_Reports/webElement_CaseID'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Reports/webElement_InsuredOrQuoteReference'),  GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

List<WebElement> elements = WebUI.findWebElements(findTestObject('Object Repository/Page_Reports/webElement_InsuredOrQuoteReference'),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_Reports/webElement_CreateDirectorsSanctionsCheck'))


WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Reports/input_UWComments'),  GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Page_Reports/input_UWComments'), 'Test')
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Reports/select_DropdownUWAction'), 'False Positive', false)
WebUI.clearText(findTestObject('Object Repository/Page_Reports/input_UWComments'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Reports/select_DropdownUWAction'), 'Select...', false)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Reports/button_Close'), 25)
WebUI.click(findTestObject('Object Repository/Page_Reports/button_Close'))
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Reports/input_DateFilters', [('fieldName') : 'CreatedFrom']),
	GlobalVariable.timeOutValue)

String selectedDate = WebUI.getText(findTestObject('Object Repository/Page_Reports/input_DateFilters', [('fieldName') : 'CreatedFrom']))

KeywordUtil.logInfo('Selected Date is :::' + selectedDate)

if (selectedDate.equals(findTestData(testData).getValue('Created From Date', rowNumber))) {
	KeywordUtil.markPassed('Created On date is as expected.')
}

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Reports/webElement_ResetDates'), 25)
WebUI.click(findTestObject('Object Repository/Page_Reports/webElement_ResetDates'))


WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Reports/input_DateFilters', [('fieldName') : 'CreatedFrom']),
	 GlobalVariable.timeOutValue)

String selectedDate1 = WebUI.getText(findTestObject('Object Repository/Page_Reports/input_DateFilters', [('fieldName') : 'CreatedFrom']))

//validate the selected date

KeywordUtil.logInfo('Selected Date is :::' + selectedDate1)

if (selectedDate1.equals(' ')) {
	KeywordUtil.markPassed('Dates are set to blank.')
}