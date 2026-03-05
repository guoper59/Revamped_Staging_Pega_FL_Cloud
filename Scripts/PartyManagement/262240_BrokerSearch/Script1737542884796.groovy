/**
 * ============================================================================
 * Test Case ID : 262240
 * Title         : Broker Search
 * Folder        : Scripts/PartyManagement/262240_BrokerSearch
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

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.random.RandomGenerator as RandomGenerator
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber(testDataFilePath, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

String timeStamp = GenericUtils.getCurrentTimestamp()

String updatedFirstName = 'Auto_' + timeStamp
KeywordUtil.logInfo(updatedFirstName)

KeywordUtil.logInfo('Navigating to Pega Financial Lines')

WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('dnouser', GlobalVariable.Dnouser, findTestData(testData).getValue('Role', rowNumber))

KeywordUtil.logInfo('Loggedin to Pega with valid DNO User credentials ')

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
// Clicking on partyManagement
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : partyManagementLink]))

KeywordUtil.logInfo('Navigated to Party Management')
WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
//clicking on Broker link
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_SubmissionSearchCreation/webElement_Options', [('optionToSelect') : brokerLink]))
KeywordUtil.logInfo('Navigated to Broker Search')

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

// Entered data for broker
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : labelName.getAt(
                'countryDropDown')]))
WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
        [('dropDownLabel') : labelName.getAt('countryDropDown')]), findTestData(testData).getValue('SelectCountry', rowNumber), 
    false)
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'brokerName')]), findTestData(testData).getValue('FirstName', rowNumber))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_Search'))
WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/webElement_NoItemsMessage'), 
    GlobalVariable.timeOutValue)

String actualNoItemsMessage = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_InsuredSearch/webElement_NoItemsMessage'))

WebUI.verifyMatch(findTestData(testData).getValue('ExpectedNoItemsMessage', rowNumber), actualNoItemsMessage, false)

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_Reset'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_Reset'))

String countryType = WebUI.getText(findTestObject('Object Repository/Dashboards/webElement_SelectedOption', [('labelName') : 'Country']))

if (GenericUtils.verifyMatch('Country Type Value is', countryType, 'Please Select...', 'EQUAL')) {
    KeywordUtil.logInfo('All the fields are cleared')
}

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
        [('dropDownLabel') : labelName.getAt('countryDropDown')]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : labelName.getAt(
                'countryDropDown')]))
WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
        [('dropDownLabel') : labelName.getAt('countryDropDown')]), findTestData(testData).getValue('SelectCountry', rowNumber), 
    false)
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'brokerName')]), findTestData(testData).getValue('ProjectName', rowNumber))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_Search'))

String brokerCompanyName = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Broker Company Name', ('rowNumber') : 1, ('columnNumber') : 2]))

KeywordUtil.logInfo('Broker Company name displayed is ::' + brokerCompanyName)

String pseudoName = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Pseudo Name', ('rowNumber') : 1, ('columnNumber') : 3]))

KeywordUtil.logInfo('Pseudo name displayed is ::' + pseudoName)

String pseudoCode = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Pseudo Code', ('rowNumber') : 1, ('columnNumber') : 4]))

KeywordUtil.logInfo('Pseudo Code displayed is ::' + pseudoCode)

String addressLine1 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Address line 1', ('rowNumber') : 1, ('columnNumber') : 5]))

KeywordUtil.logInfo('Address Line 1 displayed is ::' + addressLine1)

String addressLine2 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Address line 2', ('rowNumber') : 1, ('columnNumber') : 6]))

KeywordUtil.logInfo('Address Line 2 displayed is ::' + addressLine2)

String addressLine3 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Address Line 3', ('rowNumber') : 1, ('columnNumber') : 7]))

KeywordUtil.logInfo('Address Line 3 displayed is ::' + addressLine3)

String city = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'City', ('rowNumber') : 1, ('columnNumber') : 8]))

KeywordUtil.logInfo('City Name displayed is ::' + city)

String postCode = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'PostCode', ('rowNumber') : 1, ('columnNumber') : 9]))

KeywordUtil.logInfo('Post Code Value displayed is ::' + postCode)

String country = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Country', ('rowNumber') : 1, ('columnNumber') : 10]))

KeywordUtil.logInfo('Country Value displayed is ::' + country)

String telephone = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Telephone', ('rowNumber') : 1, ('columnNumber') : 11]))

KeywordUtil.logInfo('Telephone Value displayed is ::' + telephone)

String website = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Website', ('rowNumber') : 1, ('columnNumber') : 12]))

KeywordUtil.logInfo('Website Value displayed is ::' + website)

String indicator = WebUI.getAttribute(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_DynamicReadValues', 
        [('fieldName') : 'Bureau Indicator', ('rowNumber') : 1, ('columnNumber') : 13]), 'alt')

KeywordUtil.logInfo('Bureau Indicator displayed is ::' + indicator)

if (indicator.equals('True')) {
    KeywordUtil.markPassed('Bureau Indicator is ticked')
}

String companyGroup = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Broker Company Group', ('rowNumber') : 1, ('columnNumber') : 14]))

KeywordUtil.logInfo('Company Group Value displayed is ::' + companyGroup)

String status = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Broker Status', ('rowNumber') : 1, ('columnNumber') : 15]))

KeywordUtil.logInfo('Status Value displayed is ::' + status)

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_Reset'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_Reset'))

WebUI.waitForPageLoad(GlobalVariable.timeOutValue)

if (GenericUtils.verifyMatch('Country Type Value is', countryType, 'Please Select...', 'EQUAL')) {
    KeywordUtil.logInfo('All the fields are cleared')
}

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
        [('dropDownLabel') : labelName.getAt('countryDropDown')]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : labelName.getAt(
                'countryDropDown')]))
WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
        [('dropDownLabel') : labelName.getAt('countryDropDown')]), findTestData(testData).getValue('SelectCountry', rowNumber), 
    false)

WebUI.waitForPageLoad(GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'pseudoCode')]), findTestData(testData).getValue('PseudoCode', rowNumber))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_Search'))

String brokerCompanyName1 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Broker Company Name', ('rowNumber') : 1, ('columnNumber') : 2]))

KeywordUtil.logInfo('Broker Company name displayed is ::' + brokerCompanyName1)

String pseudoName1 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Pseudo Name', ('rowNumber') : 1, ('columnNumber') : 3]))

KeywordUtil.logInfo('Pseudo name displayed is ::' + pseudoName1)

String pseudoCode1 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Pseudo Code', ('rowNumber') : 1, ('columnNumber') : 4]))

KeywordUtil.logInfo('Pseudo Code displayed is ::' + pseudoCode1)

String newaddressLine1 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Address line 1', ('rowNumber') : 1, ('columnNumber') : 5]))

KeywordUtil.logInfo('Address Line 1 displayed is ::' + newaddressLine1)

String newaddressLine2 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Address line 2', ('rowNumber') : 1, ('columnNumber') : 6]))

KeywordUtil.logInfo('Address Line 2 displayed is ::' + newaddressLine2)

String newaddressLine3 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Address Line 3', ('rowNumber') : 1, ('columnNumber') : 7]))

KeywordUtil.logInfo('Address Line 3 displayed is ::' + newaddressLine3)

String city1 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'City', ('rowNumber') : 1, ('columnNumber') : 8]))

KeywordUtil.logInfo('City Name displayed is ::' + city1)

String postCode1 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'PostCode', ('rowNumber') : 1, ('columnNumber') : 9]))

KeywordUtil.logInfo('Post Code Value displayed is ::' + postCode1)

String country1 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Country', ('rowNumber') : 1, ('columnNumber') : 10]))

KeywordUtil.logInfo('Country Value displayed is ::' + country1)

String telephone1 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Telephone', ('rowNumber') : 1, ('columnNumber') : 11]))

KeywordUtil.logInfo('Telephone Value displayed is ::' + telephone1)

String website1 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Website', ('rowNumber') : 1, ('columnNumber') : 12]))

KeywordUtil.logInfo('Website Value displayed is ::' + website1)

String indicator1 = WebUI.getAttribute(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_DynamicReadValues', 
        [('fieldName') : 'Bureau Indicator', ('rowNumber') : 1, ('columnNumber') : 13]), 'alt')

KeywordUtil.logInfo('Bureau Indicator displayed is ::' + indicator1)

if (indicator1.equals('True')) {
    KeywordUtil.markPassed('Bureau Indicator is ticked')
}

String companyGroup1 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Broker Company Group', ('rowNumber') : 1, ('columnNumber') : 14]))

KeywordUtil.logInfo('Company Group Value displayed is ::' + companyGroup1)

String status1 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Broker Status', ('rowNumber') : 1, ('columnNumber') : 15]))

KeywordUtil.logInfo('Status Value displayed is ::' + status1)

WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_Reset'), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_Reset'))

if (GenericUtils.verifyMatch('Country Type Value is', countryType, 'Please Select...', 'EQUAL')) {
    KeywordUtil.logInfo('All the fields are cleared')
}

WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
        [('dropDownLabel') : labelName.getAt('countryDropDown')]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', [('dropDownLabel') : labelName.getAt(
                'countryDropDown')]))
WebUI.selectOptionByLabel(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/select_DynamicDropDown', 
        [('dropDownLabel') : labelName.getAt('countryDropDown')]), findTestData(testData).getValue('SelectCountry', rowNumber), 
    false)
WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'pseudoName')]), GlobalVariable.timeOutValue)

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'pseudoName')]), findTestData(testData).getValue('PseudoName', rowNumber))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : labelName.getAt(
                'cityName')]), findTestData(testData).getValue('CityName', rowNumber))
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_Search'))

String brokerCompanyName2 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Broker Company Name', ('rowNumber') : 1, ('columnNumber') : 2]))

KeywordUtil.logInfo('Broker Company name displayed is ::' + brokerCompanyName2)

String pseudoName2 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Pseudo Name', ('rowNumber') : 1, ('columnNumber') : 3]))

KeywordUtil.logInfo('Pseudo name displayed is ::' + pseudoName2)

String pseudoCode2 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Pseudo Code', ('rowNumber') : 1, ('columnNumber') : 4]))

KeywordUtil.logInfo('Pseudo Code displayed is ::' + pseudoCode2)

String latestaddressLine1 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Address line 1', ('rowNumber') : 1, ('columnNumber') : 5]))

KeywordUtil.logInfo('Address Line 1 displayed is ::' + latestaddressLine1)

String latestaddressLine2 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Address line 2', ('rowNumber') : 1, ('columnNumber') : 6]))

KeywordUtil.logInfo('Address Line 2 displayed is ::' + latestaddressLine2)

String latestaddressLine3 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Address Line 3', ('rowNumber') : 1, ('columnNumber') : 7]))

KeywordUtil.logInfo('Address Line 3 displayed is ::' + latestaddressLine3)

String city2 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'City', ('rowNumber') : 1, ('columnNumber') : 8]))

KeywordUtil.logInfo('City Name displayed is ::' + city2)

String postCode2 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'PostCode', ('rowNumber') : 1, ('columnNumber') : 9]))

KeywordUtil.logInfo('Post Code Value displayed is ::' + postCode2)

String country2 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Country', ('rowNumber') : 1, ('columnNumber') : 10]))

KeywordUtil.logInfo('Country Value displayed is ::' + country2)

String telephone2 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Telephone', ('rowNumber') : 1, ('columnNumber') : 11]))

KeywordUtil.logInfo('Telephone Value displayed is ::' + telephone2)

String website2 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Website', ('rowNumber') : 1, ('columnNumber') : 12]))

KeywordUtil.logInfo('Website Value displayed is ::' + website2)

String indicator2 = WebUI.getAttribute(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_DynamicReadValues', 
        [('fieldName') : 'Bureau Indicator', ('rowNumber') : 1, ('columnNumber') : 13]), 'alt')

KeywordUtil.logInfo('Bureau Indicator displayed is ::' + indicator2)

if (indicator2.equals('True')) {
    KeywordUtil.markPassed('Bureau Indicator is ticked')
}

String companyGroup2 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Broker Company Group', ('rowNumber') : 1, ('columnNumber') : 14]))

KeywordUtil.logInfo('Company Group Value displayed is ::' + companyGroup2)

String status2 = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ReadValues', 
        [('fieldName') : 'Broker Status', ('rowNumber') : 1, ('columnNumber') : 15]))

KeywordUtil.logInfo('Status Value displayed is ::' + status2)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ArrowIcon', [('fieldName') : 'Broker Company Name']))
WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget0Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)

//Verifying Search Filter field names
List<WebElement> fieldNames = WebUI.findWebElements(findTestObject('Object Repository/Dashboards/webElement_ListOfBrokerSearchResults'), 
    GlobalVariable.timeOutValue)

List<WebElement> fieldList = new ArrayList<String>()

for (WebElement f : fieldNames) {
    fieldList.add(f.getAttribute('data-attribute-name'))
}

KeywordUtil.logInfo(fieldList)

GenericUtils.compareLists(fieldList, expectedList)

WebUI.switchToDefaultContent()

WebUI.waitForElementPresent(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/label_SelectAll'), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/radioButton_SelectName', [('name') : 'Abigail']))

WebUI.waitForPageLoad(GlobalVariable.timeOutValue)

// Updating the first name
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_expandIcon', [('name') : 'Abigail']))
String fName = WebUI.getAttribute(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', 
        [('fieldName') : 'First Name']), 'value')

String name = fName + updatedFirstName

WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'First Name']), 
    Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', [('fieldName') : 'First Name']), 
    name)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_Update'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ArrowIcon', [('fieldName') : 'Broker Company Name']))

WebUI.enhancedClick(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/radioButton_SelectName', [('name') : fName]))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_expandIcon', [('name') : fName]))

String updatedName = WebUI.getAttribute(findTestObject('Object Repository/PartyManagement/Page_CreateNewInsured/input_FieldName', 
        [('fieldName') : 'First Name']), 'value')

KeywordUtil.logInfo('Updated Name is ::' + updatedName)

if (!(updatedName.isEmpty())) {
    KeywordUtil.markPassed('User is able to update the name')
} else {
}

WebUI.waitForPageLoad(GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_expandIcon', [('name') : updatedName]))

// Created new broker
WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_CreateNew'))
WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/input_firstName'), GlobalVariable.timeOutValue)

WebUI.setText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/input_firstName'), findTestData(testData).getValue(
        'FirstName', rowNumber))

WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/input_surName'), GlobalVariable.timeOutValue)

String updatedSurname = findTestData(testData).getValue('Surname', rowNumber) + timeStamp

WebUI.setText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/input_surName'), updatedSurname)
WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/input_JobPossition'), GlobalVariable.timeOutValue)

WebUI.setText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/input_JobPossition'), findTestData(testData).getValue(
        'JobPossition', rowNumber))
WebUI.waitForElementVisible(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/input_Email'), GlobalVariable.timeOutValue)

WebUI.setText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/input_Email'), findTestData(testData).getValue(
        'Email', rowNumber))
WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_Create'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_Create'))

String creationSuccessMessage = WebUI.getText(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_CreatedSuccessMessage'))

KeywordUtil.logInfo(creationSuccessMessage)

if (WebUI.verifyElementVisible(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_CreatedSuccessMessage'))) {
    KeywordUtil.markPassed('User is able to create new Broker Contact')
} else {
}

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_ArrowIcon', [('fieldName') : 'Broker Company Name']))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_Name'))

WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_SortByName'))

KeywordUtil.logInfo(findTestData(testData).getValue('FirstName', rowNumber) + updatedSurname)

//TODO: maxNumber, let's do just the first 5
for (int i = 0; i < 5; i++) {
    if (WebUI.verifyElementVisible(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/webElement_FullName', 
            [('name') : (findTestData(testData).getValue('FirstName', rowNumber) + ' ') + updatedSurname]), FailureHandling.OPTIONAL)) {
        KeywordUtil.markPassed('Created Broker contact is visible')

        break
    }
	WebUI.waitForElementClickable(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_PaginationNext'), 10)
	WebUI.scrollToElement(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_PaginationNext'), 10)
	
    WebUI.click(findTestObject('Object Repository/PartyManagement/Page_BrokerSearch/button_PaginationNext'))

}