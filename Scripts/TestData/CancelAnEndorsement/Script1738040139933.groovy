/**
 * ============================================================================
 * Title        : CancelAnEndorsement
 * Title         : CancelAnEndorsement
 * Folder        : Scripts/TestData/CancelAnEndorsement
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

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

String testData = 'Endorsements'

//Finding Row number from Test Data.

int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

WebUI.comment('RowNumber: ' + rowNumber)

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_CreateEndorsement'))


WebUI.switchToFrame(findTestObject('Object Repository/Endorsements/CancelEndorsement/iframe_PegaGadget2Ifr'), GlobalVariable.timeOutValue,

   FailureHandling.STOP_ON_FAILURE)

////Verifying Data Validation field names

List<WebElement> endorsementTabs = WebUI.findWebElements(findTestObject('Object Repository/Endorsements/webElement_EndorsementTabs'),

   GlobalVariable.timeOutValue)

List<WebElement> endorsementTabsList = new ArrayList<String>()

for (WebElement e : endorsementTabs) {


   endorsementTabsList.add(e.getText())

}

KeywordUtil.logInfo(endorsementTabsList)

WebUI.switchToDefaultContent()


WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Requested By']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Requested By']),

   findTestData(testData).getValue('EndorsementRequested', rowNumber), false)


WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Type']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_DynamicDropDown', [('dropDownLabel') : 'Endorsement Type']),

   findTestData(testData).getValue('EndorsementType', rowNumber), false)


WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/text_CommentsSection', [('commentField') : 'Endorsement Notes']),

   'Test test test test test test')

String endorsmentInceptionDate = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_FieldName', [('fieldName') : 'Endorsement Inception Date ']),

   'value')

KeywordUtil.logInfo(endorsmentInceptionDate)

String endorsmentExpiryDate = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_FieldName', [('fieldName') : 'Endorsement Expiry Date ']),

   'value')

KeywordUtil.logInfo(endorsmentExpiryDate)

String endorsmentPeriod = WebUI.getText(findTestObject('Object Repository/Endorsements/CancelEndorsement/webElement_ReadDynamicValues', [('headerName') : 'Endorsement Period']))

KeywordUtil.logInfo(endorsmentPeriod)

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))




//

////Verifying Data Validation field names



//


//


//



//



//





//


//



//


//


//



//



//





//


//


WebUI.verifyElementChecked(findTestObject('Object Repository/Endorsements/CancelEndorsement/radio_DynamicRadioButton', [('radioButtonLabel') : 'Yes']),

   GlobalVariable.timeOutValue)


WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))


String country = WebUI.getText(findTestObject('Object Repository/Endorsements/CancelEndorsement/webElement_SelectedDropDownValue', [('dropDownName') : 'Country']))


String brokerContactNameInsuredDetails = WebUI.getText(findTestObject('Object Repository/Endorsements/CancelEndorsement/webElement_SelectedDropDownValue',

	   [('dropDownName') : 'AgentId']))


String selectedBroker = WebUI.getAttribute(findTestObject('Object Repository/Endorsements/CancelEndorsement/webElement_ReadBrokerSelectedAutoComplete'),

   'value')


WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))


WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))


WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_DynamicDropDown', [('dropDownLabel') : 'Premium Type']))

WebUI.selectOptionByLabel(findTestObject('Object Repository/Endorsements/CancelEndorsement/select_DynamicDropDown', [('dropDownLabel') : 'Premium Type']),

   findTestData(testData).getValue('EndorsementType', rowNumber), false)


WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_FieldName', [('fieldName') : 'Layer Gross Premium ']),

   findTestData(testData).getValue('EndorsementGrossPremium', rowNumber))

WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_FieldName', [('fieldName') : 'Layer Gross Premium ']),

   Keys.chord(Keys.TAB))



//


//



//



WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/button_CompleteQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/button_CompleteQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Endorsements/button_CompleteQuote'))


String quotedStatus = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', quotedStatus, 'Quoted', 'EQUAL')

WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_FinalTakeUpQuote'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_FinalTakeUpQuote'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/NewBusiness/Endorsements/CancelEndorsement'))

String openBoundStatus = WebUI.getText(findTestObject('Object Repository/OutwardsPolicy/webElement_Status'))

GenericUtils.verifyMatch('Status Value is', openBoundStatus, 'Open Bound', 'EQUAL')


//



//



//


//



//


//



//


//



//


//



//


//



//


//



//


//



//


//



//


//



//


//



//


//



//


//



//


//



//


//



//


//



//


//



//


//



//


//



//


//

//



//


//




//




//






//




//

//




//




//

//




//

//




//

//




//










//







//

//



//



//



//



//



//



//



//



//

//



//



//



//



//



//

////GenericUtils.verifyMatch('Target Name Is : ', actualTargetName, findTestData(testData).getValue('TargetName', rowNumber),

////	'EQUAL')

//



//

////GenericUtils.verifyMatch('Target Domicile Is : ', actualTargetDomicile, findTestData(testData).getValue('TargetDomicile',

////		rowNumber), 'EQUAL')

//



//

////GenericUtils.verifyMatch('Target NAIC Is : ', actualTargetNAIC, findTestData(testData).getValue('TargetNAIC', rowNumber),

////	'EQUAL')

//
 

//

 
 
 
WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))
 
String brokerBinderMessage = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_BrokerBindMessage'))
 
KeywordUtil.logInfo(brokerBinderMessage)
 
 
WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))
 
String taxApplicable = WebUI.getText(findTestObject('Object Repository/Endorsements/CancelEndorsement/webElement_SelectedDropDownValue', [('dropDownName') : 'TaxApplicable']))

KeywordUtil.logInfo(taxApplicable)
 
WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_DueDate'), findTestData(

		testData).getValue('Due Date', rowNumber))
 
WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_DueDate'), Keys.chord(

		Keys.TAB))
 
 

WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

 
String actualGenerateInstallmentMessage = WebUI.getText(findTestObject('Object Repository/Endorsements/CancelEndorsement/webElement_GenerateInstallmentsMessage'))
 

 


//


//


//


//


//



//


//


//


//


//


//


//



//


//



//


//

 
WebUI.click(findTestObject('Object Repository/Endorsements/button_OtherActions'))
 
WebUI.click(findTestObject('Object Repository/Endorsements/webElement_OtherActionsOption', [('optionToSelect') : 'Cancel Endorsement']))
 
 
String warningMessage = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_CancelEndorsementMessage'))
 
KeywordUtil.logInfo(warningMessage)

 

WebUI.click(findTestObject('Object Repository/Endorsements/button_OK'))

 
WebUI.click(findTestObject('Object Repository/Endorsements/webElement_HeaderTabSelector',[('tabName') : 'Bind']))
 
 
WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_FieldName', [('fieldName') : 'Layer Gross Premium ']),

	Keys.chord(Keys.CONTROL, 'a'))
 
WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_FieldName', [('fieldName') : 'Layer Gross Premium ']),

	findTestData(testData).getValue('UpdatedEndorsementGrossPremium', rowNumber))
 
WebUI.sendKeys(findTestObject('Object Repository/Endorsements/CancelEndorsement/input_FieldName', [('fieldName') : 'Layer Gross Premium ']),

	Keys.chord(Keys.TAB))

 


//


////

////GenericUtils.verifyMatch('TMHCC Gross Premium Value is', tmhccGrossPremiumEndorsement, '5,512.35', 'EQUAL')

////



//


//

 
 
 
WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))


 
WebUI.click(findTestObject('Object Repository/Endorsements/CancelEndorsement/button_Continue'))
 


WebUI.waitForElementClickable(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), 25)
WebUI.scrollToElement(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'), GlobalVariable.timeOutValue)
WebUI.click(findTestObject('Object Repository/Pega_CreateInsured/Page_PegaCaseManagerPortal/btn_GenerateInstallments'))

 


WebUI.waitForElementClickable(findTestObject('Object Repository/Endorsements/button_OtherActions'), 25)

WebUI.click(findTestObject('Object Repository/Endorsements/button_OtherActions'))
 
WebUI.click(findTestObject('Object Repository/Endorsements/webElement_OtherActionsOption', [('optionToSelect') : 'Cancel Endorsement']))
 


 
WebUI.click(findTestObject('Object Repository/Endorsements/webElement_DynamicTabSelector', [('tabName') : 'Endorsements']))
 
String endorsementNumber = WebUI.getText(findTestObject('Object Repository/Endorsements/webElement_EndorsementNumber'))
return endorsementNumber
 