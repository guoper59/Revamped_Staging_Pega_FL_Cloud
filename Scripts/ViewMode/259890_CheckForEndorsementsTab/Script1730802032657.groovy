/**
 * ============================================================================
 * Test Case ID : 259890
 * Title         : Check For Endorsements Tab
 * Folder        : Scripts/ViewMode/259890_CheckForEndorsementsTab
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


//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)


//Finding Row number from Test Data.
int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

// Navigate to a specified URL.
WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

//Perform a login operation using the provided username, password, and role from test data.
CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('llbusinessadmin', GlobalVariable.llbusinessadmin, findTestData(testData1).getValue('Role', rowNumber1))
//Wait for the specified element to be visible.
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_PolicyReference'), GlobalVariable.timeOutValue, 
    FailureHandling.STOP_ON_FAILURE)

// Retrieve the value of 'Policy Reference' from test data using the specified row number.
String policyRef = findTestData(testData).getValue('Policy Reference', rowNumber)

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

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_StatusFilter'))
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_ApplyFilter'))
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_SignedStatus'))
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/button_Apply'))

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/button_Actions'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/WebElement_View'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/WebElement_View'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_VerifyTabHeaders'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

List<WebElement> tabs = WebUI.findWebElements(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_VerifyTabHeaders'), 
    GlobalVariable.timeOutValue)

List<WebElement> actualHeaders = new ArrayList<String>()

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget0Ifr'), GlobalVariable.timeoutShort)

for (int i = 0; i < tabs.size(); i++) {
    actualHeaders.add(tabs.get(i).getAttribute('aria-label'))
}

WebUI.switchToDefaultContent()

//verify tab headers

GenericUtils.compareLists(expectedHeaders, actualHeaders)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_CurrentlyOpen0'), 
    GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_CurrentlyOpen0'))
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_ClickonTab0', [
          ('tabName') : 'Endorsements']))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table', 
        [('tableName') : 'Endorsement']), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget0Ifr'), GlobalVariable.timeoutShort)

//verify text present 'This tab only shows the fields that have been newly filled out or amended on the Endorsements.'

WebUI.verifyTextPresent('This tab only shows the fields that have been newly filled out or amended on the Endorsements.', 
    false)

WebUI.switchToDefaultContent()
WebElement tableHeader = WebUI.findWebElement(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table', 
        [('tableName') : 'Endorsement']), GlobalVariable.timeOutValue)

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget0Ifr'), GlobalVariable.timeoutShort)
List<WebElement> headers = tableHeader.findElements(By.xpath('tr/th'))

List<WebElement> actualtableHeaders = new ArrayList<String>()
for (int i = 1; i < headers.size(); i++) {
    actualtableHeaders.add(headers.get(i).getAttribute('data-attribute-name'))
}

WebUI.switchToDefaultContent()

//verify endorsement details

GenericUtils.compareLists(expectedTableHeaders, actualtableHeaders)

WebTableUtils.verifytableValueswithDynamicIframe(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table', 
        [('tableName') : 'Endorsement']), 'Endorsement Number', endorsementValues.get('endorsementNumber'),0)

WebTableUtils.verifytableValueswithDynamicIframe(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table', 
        [('tableName') : 'Endorsement']), 'Endorsement Type', endorsementValues.get('endorsementType'),0)

WebTableUtils.verifytableValueswithDynamicIframe(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table', 
        [('tableName') : 'Endorsement']), 'Endorsement Creation date', endorsementValues.get('endorsementCreationDate'),0)

WebTableUtils.verifytableValueswithDynamicIframe(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table', 
        [('tableName') : 'Endorsement']), 'Endorsement Inception Date', endorsementValues.get('endorsementInceptionDate'),0)

WebTableUtils.verifytableValueswithDynamicIframe(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table', 
        [('tableName') : 'Endorsement']), 'Endorsement Expiry Date', endorsementValues.get('endorsementExpiryDate'),0)

WebTableUtils.verifytableValueswithDynamicIframe(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table', 
        [('tableName') : 'Endorsement']), 'Endorsement Status', endorsementValues.get('endorsementStatus'),0)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_expandRow0'))

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget0Ifr'), GlobalVariable.timeoutShort)

WebUI.verifyTextPresent('broker contact to be change to Nicolas Bongoat', false)

WebUI.switchToDefaultContent()

WebElement tableHeaders = WebUI.findWebElement(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table', 
        [('tableName') : 'FieldTrackingStageName']), GlobalVariable.timeOutValue)

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget0Ifr'), GlobalVariable.timeoutShort)

List<WebElement> headerValues = tableHeaders.findElements(By.xpath('tr/th'))

List<WebElement> actualtableHeaderValues = new ArrayList<String>()

for (int i = 0; i < headerValues.size(); i++) {
    actualtableHeaderValues.add(headerValues.get(i).getAttribute('data-attribute-name'))
}

WebUI.switchToDefaultContent()

//verify actual header values

GenericUtils.compareLists(expectedendorsementTableHeaders, actualtableHeaderValues)

List<WebElement> actualtableValues = WebUI.findWebElements(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_tableValues0', 
        [('tableName') : 'Field']), GlobalVariable.timeoutShort)

List<WebElement> actualtableFieldValues = new ArrayList<String>()

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget0Ifr'), GlobalVariable.timeoutShort)

for (int i = 0; i < actualtableValues.size(); i++) {
    if (!(actualtableValues.get(i).getText().equals(''))) {
        actualtableFieldValues.add(actualtableValues.get(i).getText())
    }
}

WebUI.switchToDefaultContent()

//verify actual field values

GenericUtils.compareLists(expectedendorsmentTableValues, actualtableFieldValues)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_Instalments0'))

WebElement instaltableHeaders = WebUI.findWebElement(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_table', 
        [('tableName') : 'InstalmentsList']), GlobalVariable.timeOutValue)

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget0Ifr'), GlobalVariable.timeoutShort)

List<WebElement> installmentHeaderValues = instaltableHeaders.findElements(By.xpath('tr/th'))

List<WebElement> actualtableInstallmentHeaderValues = new ArrayList<String>()

for (int i = 0; i < installmentHeaderValues.size(); i++) {
    if (installmentHeaderValues.get(i).getAttribute('data-attribute-name').contains('&')) {
        String[] instalmentAmount = installmentHeaderValues.get(i).getAttribute('data-attribute-name').split('&')

        actualtableInstallmentHeaderValues.add(instalmentAmount[0])
    } else {
        actualtableInstallmentHeaderValues.add(installmentHeaderValues.get(i).getAttribute('data-attribute-name'))
    }
}

WebUI.switchToDefaultContent()

//verify Installment header values

GenericUtils.compareLists(expectedInstalmentHeaders, actualtableInstallmentHeaderValues)
WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_Instalments0'))
List<WebElement> actualInstalment = WebUI.findWebElements(findTestObject('Object Repository/Page_PegaCaseManagerPortal/Pega_SubmissionSearch/webElement_tblValue0', 
        [('tableName') : 'InstalmentsList']), GlobalVariable.timeoutShort)
List<WebElement> actualInstalmentValues = new ArrayList<String>()

WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget0Ifr'), GlobalVariable.timeoutShort)
for (int i = 0; i < actualInstalment.size(); i++) {
    String value = actualInstalment.get(i).getText().trim() // Trim spaces

    if (!(value.equals(''))) {
        actualInstalmentValues.add(value)
    }
}
WebUI.switchToDefaultContent()
GenericUtils.compareLists(expectedInstallmentValues, actualInstalmentValues)