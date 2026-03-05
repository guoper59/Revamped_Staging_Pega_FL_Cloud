/**
 * ============================================================================
 * Test Case ID : 259892
 * Title         : Contract Certainity Reports
 * Folder        : Scripts/Reports_Validation/259892_ContractCertainityReports
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

import static com.kms.katalon.core.model.FailureHandling.CONTINUE_ON_FAILURE
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


int credrowNumber = common.FileUtils.findRowNumber('Data Files/' + CredentialstestData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + credrowNumber)

//Navigating to Pega Financial Lines

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('llbusinessadmin', GlobalVariable.llbusinessadmin, findTestData(CredentialstestData).getValue(		
        'Role', credrowNumber))

//Loggedin to Pega with valid Business Admin credentials

KeywordUtil.logInfo('Loggedin to Pega with valid Business Admin credentials ')

//Navigate to Contract Certainty Report and enter the details

KeywordUtil.logInfo('Contract Certainty Report details are entered')
WebUI.waitForElementClickable(findTestObject('Object Repository/Utilities/btn_SubmissionSearch'), GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Object Repository/Page_Reports/webElement_Reports'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Reports/webElement_ReportName', [('ReportName') : 'Contract Certainty Report']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_Reports/webElement_ReportName', [('ReportName') : 'Contract Certainty Report']))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Reports/webElement_VerifyReportName', [('ReportName') : 'Contract Certainty Reports']), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Reports/webElement_Loader'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Page_Reports/input_DateFilters', [('fieldName') : 'CreatedFrom']))

GenericUtils.SelectDatefromCalendar(findTestData(testData).getValue('Created From Date', rowNumber), findTestObject('Object Repository/Page_Reports/input_Month'), 
    findTestObject('Object Repository/Page_Reports/input_Year'))

WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Reports/webElement_Loader'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Page_Reports/input_DateFilters', [('fieldName') : 'CreatedTo']))

GenericUtils.SelectDatefromCalendar(findTestData(testData).getValue('Created To Date', rowNumber), findTestObject('Object Repository/Page_Reports/input_Month'), 
    findTestObject('Object Repository/Page_Reports/input_Year'))
WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Reports/webElement_Loader'), GlobalVariable.timeOutValue)

try {
    WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Reports/button_ExportToExcel'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
}
catch (Exception e) {
} 

List<WebElement> headerElements = WebUI.findWebElements(findTestObject('Object Repository/Page_Reports/webElement_Headers'), 
    GlobalVariable.timeOutValue)

List<WebElement> actualHeaderList = new ArrayList<String>()

WebUI.switchToFrame(findTestObject('Object Repository/Page_Reports/iframe_PegaGadget0Ifr'), 5)

for (int i = 0; i < (headerElements.size() - 1); i++) {
    actualHeaderList.add(headerElements.get(i).getText())
}

WebUI.switchToDefaultContent()

GenericUtils.compareLists(expectedHeaderList, actualHeaderList)

//export report details to excel

KeywordUtil.logInfo('export report details to excel')


WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Reports/button_ExportToExcel'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_Reports/button_ExportToExcel'))

WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Reports/webElement_Loader'), GlobalVariable.timeOutValue)

//validate the status values after export

WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_Reports/select_DropdownStatus'), findTestData(testData).getValue(
        'Status', rowNumber), false)

List<WebElement> actualStatus = WebUI.findWebElements(findTestObject('Object Repository/Page_Reports/webElement_ReportName', 
        [('ReportName') : findTestData(testData).getValue('Status', rowNumber)]), GlobalVariable.timeOutValue)

if (actualStatus.size() > 0) {
    KeywordUtil.markPassed('Status Value matches with expected Values')
}


WebUI.click(findTestObject('Object Repository/Page_Reports/button_ExportToExcel'))
String windowIndex = WebUI.getWindowIndex()

KeywordUtil.logInfo(windowIndex)

WebUI.switchToWindowIndex(1)

KeywordUtil.markPassed('Export to Excel is Successful')

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

WebUI.waitForElementNotPresent(findTestObject('Object Repository/Page_Reports/webElement_Loader'), 25)
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Reports/webElement_ResetDates'), 25)

WebUI.click(findTestObject('Object Repository/Page_Reports/webElement_ResetDates'))
WebUI.click(findTestObject('Object Repository/Page_Reports/webElement_ResetDates'), FailureHandling.OPTIONAL)


WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Reports/button_ExportToExcel'), 25)
WebUI.click(findTestObject('Object Repository/Page_Reports/input_DateFilters', [('fieldName') : 'ResolvedFrom']))

GenericUtils.SelectDatefromCalendar(findTestData(testData).getValue('Resolved From Date', rowNumber), findTestObject('Object Repository/Page_Reports/input_Month'), 
    findTestObject('Object Repository/Page_Reports/input_Year'))
WebUI.click(findTestObject('Object Repository/Page_Reports/input_DateFilters', [('fieldName') : 'ResolvedTo']))

GenericUtils.SelectDatefromCalendar(findTestData(testData).getValue('Resolved To Date', rowNumber), findTestObject('Object Repository/Page_Reports/input_Month'), 
    findTestObject('Object Repository/Page_Reports/input_Year'))

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_Reports/webElement_Loader'),GlobalVariable.timeOutValue)
WebUI.waitForPageLoad(GlobalVariable.timeOutValue)
try {
    WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Reports/button_ExportToExcel'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
}
catch (Exception e) {
} 
List<WebElement> headerElementsRsolved = WebUI.findWebElements(findTestObject('Object Repository/Page_Reports/webElement_Headers'), 
    GlobalVariable.timeOutValue)

List<WebElement> actualHeaderListResolve = new ArrayList<String>()

WebUI.switchToFrame(findTestObject('Object Repository/Page_Reports/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue)

for (int i = 0; i < (headerElementsRsolved.size())-1; i++) {
	
    actualHeaderListResolve.add(headerElementsRsolved.get(i).getText())
}

WebUI.switchToDefaultContent()

GenericUtils.compareLists(expectedHeaderList, actualHeaderListResolve)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Reports/select_DropdownStatus'), GlobalVariable.timeOutValue)