package com.dashboard.helper

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.genericutils.helper.GenericUtils

import org.openqa.selenium.WebElement

import internal.GlobalVariable

/**
 * DashboardHelper
 *
 * Reusable keyword methods for Dashboard script interactions.
 * Encapsulates the repetitive navigate → verify sections → switch iframe
 * pattern shared across all Dashboard test cases.
 */
public class DashboardHelper {

    /**
     * Navigate to the Dashboard from the sidebar.
     * Hovers the sidebar, clicks Dashboard, and waits for the iframe to load.
     */
    @Keyword
    static void navigateToDashboard() {
        KeywordUtil.logInfo('Navigating to Dashboard')
        WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/hoverSidebar'), GlobalVariable.timeoutShort)
        WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
        WebUI.waitForElementVisible(
            findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
                [('optionToSelect'): 'Dashboard']),
            GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)
        WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options',
            [('optionToSelect'): 'Dashboard']))
        WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue)
        KeywordUtil.logInfo('Dashboard loaded')
    }

    /**
     * Verify the three Dashboard sections (Workflow, Data Validation, Renewal/WorkFlow links)
     * by comparing actual rendered text lists against expected lists.
     * Switches into and back out of the Dashboard iframe automatically.
     *
     * @param expectedWorkflowList       Expected workflow field labels
     * @param expectedDataValidationList Expected data validation field labels
     * @param expectedRenewalList        Expected renewal / workflow link labels
     */
    @Keyword
    static void verifySections(List<String> expectedWorkflowList,
                                List<String> expectedDataValidationList,
                                List<String> expectedRenewalList) {
        WebUI.switchToFrame(
            findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'),
            GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

        List<WebElement> workflowElements = WebUI.findWebElements(
            findTestObject('Object Repository/Dashboards/webElement_ListOfFields'), GlobalVariable.timeOutValue)
        List<String> workflowList = workflowElements.collect { it.getText() }
        GenericUtils.compareLists(workflowList, expectedWorkflowList)
        KeywordUtil.logInfo('Workflow section verified')

        List<WebElement> dvElements = WebUI.findWebElements(
            findTestObject('Object Repository/Dashboards/webElement_ListOfFieldsUnderDataValidation'), GlobalVariable.timeOutValue)
        List<String> dvList = dvElements.collect { it.getText() }
        GenericUtils.compareLists(dvList, expectedDataValidationList)
        KeywordUtil.logInfo('Data Validation section verified')

        List<WebElement> renewalElements = WebUI.findWebElements(
            findTestObject('Object Repository/Dashboards/webElement_ListOfFieldsRenewal'), GlobalVariable.timeOutValue)
        List<String> renewalList = renewalElements.collect { it.getText() }
        GenericUtils.compareLists(renewalList, expectedRenewalList)
        KeywordUtil.logInfo('Renewal section verified')

        WebUI.switchToDefaultContent()
    }

    /**
     * Click a named link in the Workflow section of the Dashboard,
     * wait for the results table to load, then verify table column headers.
     *
     * @param linkName           The visible text of the workflow link to click
     * @param expectedHeaderList Expected column header labels (first and last are trimmed automatically)
     */
    @Keyword
    static void clickWorkflowLinkAndVerifyHeaders(String linkName, List<String> expectedHeaderList) {
        KeywordUtil.logInfo("Clicking Dashboard workflow link: ${linkName}")
        WebUI.waitForElementVisible(
            findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect'): linkName]),
            GlobalVariable.timeoutShort, FailureHandling.STOP_ON_FAILURE)
        WebUI.click(findTestObject('Object Repository/Dashboards/webElement_WorkFlowLinks', [('optionToSelect'): linkName]))

        WebUI.waitForElementPresent(findTestObject('Object Repository/Dashboards/button_ExportToExcel'), GlobalVariable.timeOutValue)

        WebUI.switchToFrame(
            findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'),
            GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

        List<WebElement> headerElements = WebUI.findWebElements(
            findTestObject('Object Repository/Dashboards/webElement_ListOfHeaders'), GlobalVariable.timeOutValue)
        List<String> headerList = headerElements.collect { it.getText() }
        // Remove first (checkbox col) and last (actions col) which are not data columns
        if (headerList.size() > 1) headerList.remove(0)
        if (headerList.size() > 0) headerList.remove(headerList.size() - 1)

        GenericUtils.compareLists(headerList, expectedHeaderList)
        KeywordUtil.logInfo("Headers verified for: ${linkName}")

        WebUI.switchToDefaultContent()
    }

    /**
     * Open the filter panel, type a search term, apply it, and return.
     *
     * @param searchText  Text to type into the Search Text field
     */
    @Keyword
    static void filterByText(String searchText) {
        KeywordUtil.logInfo("Applying Dashboard filter: ${searchText}")
        WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/webElement_Filter'), GlobalVariable.timeOutValue)
        WebUI.click(findTestObject('Object Repository/Dashboards/webElement_Filter'))
        WebUI.waitForElementVisible(findTestObject('Object Repository/Dashboards/webElement_ClearFilter'),
            GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
        WebUI.sendKeys(
            findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName'): 'Search Text']),
            searchText)
        WebUI.waitForElementClickable(findTestObject('Object Repository/Dashboards/button_Apply'), GlobalVariable.timeOutValue)
        WebUI.click(findTestObject('Object Repository/Dashboards/button_Apply'))
    }
}
