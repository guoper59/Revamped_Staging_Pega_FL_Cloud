/**
 * ============================================================================
 * Test Case ID : 263886
 * Title         : Programm View Verify Modlifybuttonfrom Programme ID Search Resultsfor Business Admin
 * Folder        : Scripts/SubmissionSearch/263886_ProgrammViewVerifyModlifybuttonfromProgrammeIDSearchResultsforBusinessAdmin
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

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.WebTableUtils
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.TestObject

String testData = 'SearchSubmission'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

int rowNumbertestData = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID + '_1')

int rowNumbertestDataN = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID + '_2')

int rowNumbertestDataN1 = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID + '_3')

int rowNumbertestDataN2 = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID + '_4')

String testData1 = 'Credentials'

//Finding Row number from Test Data.
int rowNumber1 = common.FileUtils.findRowNumber('Data Files/' + testData1, GlobalVariable.testCaseID)

//login to the application
WebUI.navigateToUrl(GlobalVariable.applicationUrl, FailureHandling.STOP_ON_FAILURE)

CustomKeywords.'com.login.helper.LoginHelper.loginToApplication'('llbusinessadmin', GlobalVariable.llbusinessadmin, findTestData(testData1).getValue('Role', rowNumber1))
WebUI.waitForElementClickable(findTestObject('Object Repository/Utilities/btn_SubmissionSearch'), GlobalVariable.timeOutValue)

WebUI.mouseOver(findTestObject('Object Repository/Dashboards/hoverSidebar'))

WebUI.click(findTestObject('Utilities/webElement_Utilities'))

WebUI.click(findTestObject('Utilities/webElement_Program_ID_Utility'))

WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))

//not_created
WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_Insuredname'), findTestData(testData).getValue(
        'Insured Name', rowNumber))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : findTestData(
                testData).getValue('Insured Name', rowNumber)]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : findTestData(
                testData).getValue('Insured Name', rowNumber)]))

WebUI.waitForElementClickable(findTestObject('Object Repository/Utilities/btn_SubmissionSearch'), GlobalVariable.timeOutValue)
//do submission search
WebUI.click(findTestObject('Object Repository/Utilities/btn_SubmissionSearch'))

//enter quote reference and mofidy single ,multi lob id
GenericUtils.filterColumnByValue('Quote Reference', findTestData(testData).getValue('Quote Reference', rowNumber))
WebUI.click(findTestObject('Object Repository/Utilities/btn_Modify'))

WebUI.verifyElementHasAttribute(findTestObject('Object Repository/NewBusiness/button_Update'), 'disabled', GlobalVariable.timeOutValue)

String singleProgrammeID = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ProgrammedIDValues',[('programmeID') : 'Single Programme ID']))

KeywordUtil.logInfo('Single Programmed ID is :' +singleProgrammeID)

String multiProgrammeID = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ProgrammedIDValues',[('programmeID') : 'Multi Programme ID']))

KeywordUtil.logInfo('Multi Programmed ID is :' +multiProgrammeID)

WebUI.setText(findTestObject('Utilities/input_NewSingleProgID'), findTestData(testData).getValue('Single LOB Id', rowNumber))

WebUI.setText(findTestObject('Utilities/input_NewMultiProgID'), findTestData(testData).getValue('Multi LOB Id', rowNumber))

WebUI.click(findTestObject('Utilities/input_Comment'))
WebUI.setText(findTestObject('Utilities/input_Comment'), cmmnt)

WebUI.click(findTestObject('Utilities/input_NewSingleProgID'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Utilities/btn_Update'), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Utilities/btn_Update'), FailureHandling.STOP_ON_FAILURE)

//verify updates
GenericUtils.filterColumnByValue('Quote Reference', findTestData(testData).getValue('Quote Reference', rowNumber))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Utilities/webElement_ResultTable'), 
    'Single LOB Id', findTestData(testData).getValue('Single LOB Id', rowNumber))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Utilities/webElement_ResultTable'), 
    'Multi LOB Id', findTestData(testData).getValue('Multi LOB Id', rowNumber))
     

WebUI.waitForElementClickable(findTestObject('Object Repository/Utilities/btn_SubmissionSearch'), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/Utilities/btn_SubmissionSearch'))

//enter quote reference and mofidy single ,multi lob id
GenericUtils.filterColumnByValue('Quote Reference', findTestData(testData).getValue('Quote Reference', rowNumbertestData))\

WebUI.click(findTestObject('Object Repository/Utilities/btn_Modify'))

WebUI.verifyElementNotClickable(findTestObject('Object Repository/NewBusiness/button_Update'))

String singleProgrammeID2 = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ProgrammedIDValues',[('programmeID') : 'Single Programme ID']))

KeywordUtil.logInfo('Single Programmed ID is :' +singleProgrammeID2)

String multiProgrammeID2 = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ProgrammedIDValues',[('programmeID') : 'Multi Programme ID']))

KeywordUtil.logInfo('Multi Programmed ID is :' +multiProgrammeID2)

WebUI.setText(findTestObject('Utilities/input_NewSingleProgID'), findTestData(testData).getValue('Single LOB Id', rowNumbertestData))

WebUI.setText(findTestObject('Utilities/input_NewMultiProgID'), findTestData(testData).getValue('Multi LOB Id', rowNumbertestData))

WebUI.setText(findTestObject('Utilities/input_Comment'), cmmnt)

WebUI.click(findTestObject('Utilities/input_NewSingleProgID'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Utilities/btn_Update'), GlobalVariable.timeOutValue)

WebUI.waitForElementClickable(findTestObject('Object Repository/Utilities/btn_Cancel'), GlobalVariable.timeOutValue)

WebUI.verifyElementPresent(findTestObject('Object Repository/SubmissionSearch/WebElement_UpdateProgrammeID_ErrorMessage'), 10)

WebUI.click(findTestObject('Object Repository/Utilities/btn_Cancel'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Utilities/btn_SubmissionSearch'), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/Utilities/btn_SubmissionSearch'))

//enter quote reference and mofidy single ,multi lob id
GenericUtils.filterColumnByValue('Quote Reference', findTestData(testData).getValue('Quote Reference', rowNumbertestDataN))

WebUI.click(findTestObject('Object Repository/Utilities/btn_Modify'))

WebUI.setText(findTestObject('Utilities/input_NewSingleProgID'), findTestData(testData).getValue('Single LOB Id', rowNumbertestDataN))

WebUI.setText(findTestObject('Utilities/input_NewMultiProgID'), findTestData(testData).getValue('Multi LOB Id', rowNumbertestDataN))

WebUI.setText(findTestObject('Utilities/input_Comment'), cmmnt)
// Set text of the 'input_Comment' test object to the value of the variable cmmnt

WebUI.click(findTestObject('Utilities/input_NewSingleProgID'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Utilities/btn_Update'), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Utilities/btn_Update'), FailureHandling.STOP_ON_FAILURE)

//verify updates
GenericUtils.filterColumnByValue('Quote Reference', findTestData(testData).getValue('Quote Reference', rowNumbertestDataN))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Utilities/webElement_ResultTable'), 
    'Single LOB Id', findTestData(testData).getValue('Single LOB Id', rowNumbertestDataN))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Utilities/webElement_ResultTable'), 
    'Multi LOB Id', findTestData(testData).getValue('Multi LOB Id', rowNumbertestDataN))

//reset insured name and enter new insuredname
WebUI.click(findTestObject('Object Repository/Utilities/btn_ResetSearch'))

WebUI.sendKeys(findTestObject('Object Repository/Page_PegaCaseManagerPortal/input_Insuredname'), findTestData(testData).getValue(
        'Insured Name', rowNumbertestDataN1))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : findTestData(
                testData).getValue('Insured Name', rowNumbertestDataN1)]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Page_PegaCaseManagerPortal/webElement_InsuredName', [('insuredName') : findTestData(
                testData).getValue('Insured Name', rowNumbertestDataN1)]))

WebUI.waitForElementClickable(findTestObject('Object Repository/Utilities/btn_SubmissionSearch'), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/Utilities/btn_SubmissionSearch'))

//enter quote reference and mofidy single ,multi lob id for new insuredname
GenericUtils.filterColumnByValue('Quote Reference', findTestData(testData).getValue('Quote Reference', rowNumbertestDataN1))

WebUI.click(findTestObject('Object Repository/Utilities/btn_Modify'))

WebUI.verifyElementNotClickable(findTestObject('Object Repository/NewBusiness/button_Update'))

String singleProgrammeID3 = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ProgrammedIDValues',[('programmeID') : 'Single Programme ID']))

KeywordUtil.logInfo('Single Programmed ID is :' +singleProgrammeID3)

String multiProgrammeID3 = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_ProgrammedIDValues',[('programmeID') : 'Multi Programme ID']))

KeywordUtil.logInfo('Multi Programmed ID is :' +multiProgrammeID3)

WebUI.setText(findTestObject('Utilities/input_NewSingleProgID'), findTestData(testData).getValue('Single LOB Id', rowNumbertestDataN1))

WebUI.setText(findTestObject('Utilities/input_NewMultiProgID'), findTestData(testData).getValue('Multi LOB Id', rowNumbertestDataN1))

WebUI.setText(findTestObject('Utilities/input_Comment'), cmmnt)

WebUI.click(findTestObject('Utilities/input_NewSingleProgID'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Utilities/btn_Update'), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Utilities/btn_Update'), FailureHandling.STOP_ON_FAILURE)

//verify updates
GenericUtils.filterColumnByValue('Quote Reference', findTestData(testData).getValue('Quote Reference', rowNumbertestDataN1))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Utilities/webElement_ResultTable'),'Single LOB Id', findTestData(testData).getValue('Single LOB Id', rowNumbertestDataN1))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Utilities/webElement_ResultTable'),'Multi LOB Id', findTestData(testData).getValue('Multi LOB Id', rowNumbertestDataN1))

WebUI.waitForElementClickable(findTestObject('Object Repository/Utilities/btn_SubmissionSearch'), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Object Repository/Utilities/btn_SubmissionSearch'))

GenericUtils.filterColumnByValue('Quote Reference', findTestData(testData).getValue('Quote Reference', rowNumbertestDataN2))

WebUI.click(findTestObject('Object Repository/Utilities/btn_Modify'))

WebUI.setText(findTestObject('Utilities/input_NewSingleProgID'), findTestData(testData).getValue('Single LOB Id', rowNumbertestDataN2))

WebUI.setText(findTestObject('Utilities/input_NewMultiProgID'), findTestData(testData).getValue('Multi LOB Id', rowNumbertestDataN2))

WebUI.setText(findTestObject('Utilities/input_Comment'), cmmnt)

WebUI.click(findTestObject('Utilities/input_NewSingleProgID'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Utilities/btn_Update'), GlobalVariable.timeOutValue)

WebUI.enhancedClick(findTestObject('Utilities/btn_Update'), FailureHandling.STOP_ON_FAILURE)

//verify Updates
GenericUtils.filterColumnByValue('Quote Reference', findTestData(testData).getValue('Quote Reference', rowNumbertestDataN2))

WebTableUtils.verifytableValues(findTestObject('Object Repository/Utilities/webElement_ResultTable'), 
    'Single LOB Id', findTestData(testData).getValue('Single LOB Id', rowNumbertestDataN2))

WebUI.switchToFrame(findTestObject('Object Repository/Utilities/iframe_0'), GlobalVariable.timeOutValue)

String singleLOB = findTestData(testData).getValue('Single LOB Id', rowNumbertestDataN2)

if(WebUI.verifyTextPresent(singleLOB, false)) {
	KeywordUtil.logInfo('Single LOB ID visible is ::'+singleLOB)
}
WebUI.switchToDefaultContent()

WebTableUtils.verifytableValues(findTestObject('Object Repository/Utilities/webElement_ResultTable'), 
    'Multi LOB Id', findTestData(testData).getValue('Multi LOB Id', rowNumbertestDataN2))

WebUI.switchToFrame(findTestObject('Object Repository/Utilities/iframe_0'), GlobalVariable.timeOutValue)

String multiLOB = findTestData(testData).getValue('Multi LOB Id', rowNumbertestDataN2)

if(WebUI.verifyTextPresent(multiLOB, false)) {
	KeywordUtil.logInfo('Multi LOB ID visible is ::'+multiLOB)
}