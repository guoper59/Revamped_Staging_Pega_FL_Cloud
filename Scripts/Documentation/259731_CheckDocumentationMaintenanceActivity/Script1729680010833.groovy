/**
 * ============================================================================
 * Test Case ID : 259731
 * Title         : Check Documentation Maintenance Activity
 * Folder        : Scripts/Documentation/259731_CheckDocumentationMaintenanceActivity
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
import com.kms.katalon.core.testobject.TestObject

    

    //Finding Row number from Test Data.
    int rowNumber = common.FileUtils.findRowNumber(testDataFilePath, GlobalVariable.testCaseID)
	

    WebUI.comment('RowNumber: ' + rowNumber)
	
	//Navigating to Pega Financial Lines

    KeywordUtil.logInfo('Navigating to Pega Financial Lines')

    WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

    CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('llbusinessadmin', GlobalVariable.llbusinessadmin, findTestData(testData).getValue('Role', rowNumber))

    KeywordUtil.logInfo('Loggedin to Pega with valid Business Admin credentials ')
	WebUI.waitForElementClickable(findTestObject('Object Repository/Utilities/btn_SubmissionSearch'), GlobalVariable.timeOutValue)
	
	WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))
	
	
	WebUI.click(findTestObject('Utilities/webElement_Utilities'))
	

    WebUI.click(findTestObject('Object Repository/Documentation/TemplateRules/WebElement_DocumentMaintenance'))
    WebUI.click(findTestObject('Object Repository/Documentation/TemplateRules/WebElement_TemplateRules'))
	//Selected Template Rules option from Utilities list
	
	KeywordUtil.logInfo('Selected Template Rules option from Utilities list')
	WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))
	
    WebUI.click(findTestObject('Object Repository/Documentation/TemplateRules/select_DocumentType'))
    WebUI.selectOptionByLabel(findTestObject('Object Repository/Documentation/TemplateRules/select_DocumentType'), 
        findTestData(testData).getValue('DocumentType', rowNumber), false)
	KeywordUtil.logInfo('Selected the required document type')

    WebUI.sendKeys(findTestObject('Object Repository/Documentation/TemplateRules/input_TemplateID'), findTestData(
            testData).getValue('TemplateID', rowNumber))
    WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/TemplateRules/input_AutoCompleteTemplateIdValue', 
            [('TemplateID') : findTestData(testData).getValue('TemplateID', rowNumber)]), GlobalVariable.timeOutValue)

    WebUI.mouseOver(findTestObject('Object Repository/Documentation/TemplateRules/input_AutoCompleteTemplateIdValue', [('TemplateID') : findTestData(
                    testData).getValue('TemplateID', rowNumber)]))

    WebUI.click(findTestObject('Object Repository/Documentation/TemplateRules/input_AutoCompleteTemplateIdValue', [('TemplateID') : findTestData(
                    testData).getValue('TemplateID', rowNumber)]))
    WebUI.switchToFrame(findTestObject('Object Repository/Documentation/TemplateRules/iframe_PegaGadget0Ifr'), 
        GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
	
	//Verifying if expected values are present or not
	
	KeywordUtil.logInfo('Verifying if expected values are present or not')

    List<WebElement> headers = WebUI.findWebElements(findTestObject('Object Repository/Documentation/TemplateRules/WebElement_TemplateTableHeader'), 
        GlobalVariable.timeOutValue)

    List<WebElement> elementsList = new ArrayList<String>()

    for (WebElement e : headers) {
        elementsList.add(e.getAttribute('data-attribute-name'))
    }
    
    GenericUtils.compareLists(elementsList, expectedList)

    List<WebElement> actualLinks = WebUI.findWebElements(findTestObject('Object Repository/Documentation/TemplateRules/WebElement_ButtonLinks'), 
        10)

    List<WebElement> actualListLinks = new ArrayList<String>()

    for (WebElement f : actualLinks) {
        actualListLinks.add(f.getText())
    }
    
    GenericUtils.compareLists(actualListLinks, expectedListLinks)

    WebUI.switchToDefaultContent()

    WebUI.selectOptionByLabel(findTestObject('Object Repository/Documentation/TemplateRules/select_DocumentType'), 
        findTestData(testData).getValue('DocumentType2', rowNumber), false)
	
	//Selected the required document type
	
	KeywordUtil.logInfo('Selected the required document type')

    WebUI.sendKeys(findTestObject('Object Repository/Documentation/TemplateRules/input_TemplateID'), findTestData(
            testData).getValue('TemplateID2', rowNumber))
    WebUI.waitForElementClickable(findTestObject('Object Repository/Documentation/TemplateRules/input_AutoCompleteTemplateIdValue', 
            [('TemplateID') : findTestData(testData).getValue('TemplateID2', rowNumber)]), GlobalVariable.timeOutValue)

    WebUI.mouseOver(findTestObject('Object Repository/Documentation/TemplateRules/input_AutoCompleteTemplateIdValue', [('TemplateID') : findTestData(
                    testData).getValue('TemplateID2', rowNumber)]))

    WebUI.click(findTestObject('Object Repository/Documentation/TemplateRules/input_AutoCompleteTemplateIdValue', [('TemplateID') : findTestData(
                    testData).getValue('TemplateID2', rowNumber)]))
   

    WebUI.switchToFrame(findTestObject('Object Repository/Documentation/TemplateRules/iframe_PegaGadget0Ifr'), 
        GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
	
	//Verifying if correct values are displayed or not
	
	KeywordUtil.logInfo('Verifying if correct values are displayed or not')
	
    List<WebElement> headersNew = WebUI.findWebElements(findTestObject('Object Repository/Documentation/TemplateRules/WebElement_TemplateTableHeader'), 
        GlobalVariable.timeOutValue)
    List<WebElement> newList = new ArrayList<String>()

    for (WebElement n : headersNew) {
        newList.add(n.getAttribute('data-attribute-name'))
    }
    
    GenericUtils.compareLists(newList, expectedList)
    List<WebElement> actualNewLinks = WebUI.findWebElements(findTestObject('Object Repository/Documentation/TemplateRules/WebElement_ButtonLinks'), 
        10)
    List<WebElement> actualNewListLinks = new ArrayList<String>()

    for (WebElement f : actualNewLinks) {
        actualNewListLinks.add(f.getText())
    }
    
    GenericUtils.compareLists(actualNewListLinks, expectedListLinks)
