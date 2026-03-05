/**
 * ============================================================================
 * Test Case ID : 262200
 * Title         : Field Validations
 * Folder        : Scripts/TestData/262200_FieldValidations
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
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.model.FailureHandling as FailureHandling

WebUI.switchToFrame(findTestObject('Object Repository/Dashboards/iframe_PegaGadget1Ifr'), GlobalVariable.timeOutValue, FailureHandling.STOP_ON_FAILURE)
//Verifying Data Validation field names
List<WebElement> layerSublimitValue = WebUI.findWebElements(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicTableValues', 
        [('headerName') : 'Layer Sublimit']), GlobalVariable.timeOutValue)
List<WebElement> layerSublimitList = new ArrayList<String>()

for (WebElement e : layerSublimitValue) {

    layerSublimitList.add(e.getAttribute('value'))
}

GenericUtils.compareLists(layerSublimitList, expectedLayerSublimitList)

List<WebElement> sublimitPercentValue = WebUI.findWebElements(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicTableValues', 
        [('headerName') : 'Sublimit %']), GlobalVariable.timeOutValue)
List<WebElement> sublimitPercentList = new ArrayList<String>()

for (WebElement e : sublimitPercentValue) {

    sublimitPercentList.add(e.getAttribute('value'))
}

GenericUtils.compareLists(sublimitPercentList, expectedSublimitPercentList)

List<WebElement> perInsuredEventValue = WebUI.findWebElements(findTestObject('Object Repository/NewBusiness/webElement_CAEndorsementValue', 
        [('headerName') : 'Per Insured Event']), GlobalVariable.timeOutValue)
List<WebElement> perInsuredEventList = new ArrayList<String>()

for (WebElement e : perInsuredEventValue) {

    perInsuredEventList.add(e.getAttribute('value'))
}

GenericUtils.compareLists(perInsuredEventList, expectedPerInsuredEventList)
List<WebElement> inTheAggValue = WebUI.findWebElements(findTestObject('Object Repository/NewBusiness/webElement_ReadDynamicTableValues', 
        [('headerName') : 'In the AGG']), GlobalVariable.timeOutValue)
List<WebElement> aggValueList = new ArrayList<String>()

for (WebElement e : inTheAggValue) {

    aggValueList.add(e.getAttribute('value'))
}

GenericUtils.compareLists(aggValueList, expectedAggValueList)

WebUI.switchToDefaultContent()
String deductibleBasis = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_DeductibleSelectedDropDown', 
        [('dropDownName') : 'DeductibleBasis']))
GenericUtils.verifyMatch('Deductibles Basis Value is', deductibleBasis, expectedDeductibleBasis, 'EQUAL')

String deductibleType = WebUI.getText(findTestObject('Object Repository/NewBusiness/webElement_DeductibleSelectedDropDown', 
        [('dropDownName') : 'DeductibleType']))

GenericUtils.verifyMatch('Deductibles Type Value is', deductibleType, expectedDeductibleType, 'EQUAL')

String actualDeductiblesAmount = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_FeeTextArea', 
        [('fieldName') : 'Deductibles Amount']), 'value')

GenericUtils.verifyMatch('Deductibles Amount Value is', actualDeductiblesAmount, findTestData(testData).getValue('DeductiblesAmountValue', 
        rowNumber), 'EQUAL')

String actualAATpercentage = WebUI.getAttribute(findTestObject('Object Repository/NewBusiness/webElement_ReadKRExpenseValues', 
        [('fieldName') : 'AAT Percentage (%)']), 'value')

GenericUtils.verifyMatch('AAT Percentage Value is', actualAATpercentage, findTestData(testData).getValue('AatPercentage', 
        rowNumber), 'EQUAL')