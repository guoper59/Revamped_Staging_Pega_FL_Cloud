/**
 * ============================================================================
 * Test Case ID : 259396
 * Title         : Sub Test Case Part1
 * Folder        : Scripts/Worksheets/259396_SubTestCase_Part1
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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.model.FailureHandling


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelected', [('fieldName') : 'Index for Price Change Comparison'
			, ('selected') : 'S&P Euro 350']), GlobalVariable.timeOutValue)


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelectedText', [('fieldName') : 'Currency'
			, ('selected') : 'Euro']), GlobalVariable.timeOutValue)


WebUI.verifyElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_DropDownSelectedText', [('fieldName') : 'Magnitude'
			, ('selected') : 'Millions']), GlobalVariable.timeOutValue)


WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/button_Connect'), 25, FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Connect'), FailureHandling.OPTIONAL)


WebUI.switchToFrame(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/iframe_PegaGadget2Ifr'), GlobalVariable.timeoutShort)


WebUI.verifyTextPresent(status, false)

WebUI.verifyTextPresent('W-', false)

WebUI.switchToDefaultContent()


WebUI.waitForElementVisible(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Insured Name']), 60)
String insuredNameOfWD = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Insured Name']))


WebUI.verifyEqual(insuredNameOfWD, GlobalVariable.insuredName)
WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'NAIC Division']), 60)
String NAICDivision = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'NAIC Division']))


WebUI.verifyEqual(NAICDivision, findTestData(testData).getValue('NAIC Division', rowNumber))

String NAICDescription = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'NAIC Description']))


WebUI.verifyEqual(NAICDescription, findTestData(testData).getValue('NAIC Description', rowNumber))

String country = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Country']))


WebUI.verifyEqual(country, findTestData(testData).getValue('Country', rowNumber))

String publicOrPrivate = WebUI.getText(findTestObject('Object Repository/UWWorksheet/text_FieldText', [('fieldName') : 'Public/Private']))


WebUI.verifyEqual(publicOrPrivate, findTestData(testData).getValue('Public/Private', rowNumber))

String PolicyReference = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Policy Reference']))


WebUI.verifyEqual(PolicyReference, GlobalVariable.PolicyRef)

String Broker = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Broker']))


WebUI.verifyEqual(Broker, findTestData(testData).getValue('Broker', rowNumber))

String BrokerContact = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Broker Contact']))


WebUI.verifyEqual(BrokerContact, findTestData(testData).getValue('Broker Contact', rowNumber))

String Underwriter = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Underwriter']))


WebUI.verifyEqual(Underwriter, findTestData(testData).getValue('Underwriter', rowNumber))

String PlacingType = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Placing Type']))


WebUI.verifyEqual(PlacingType, findTestData(testData).getValue('Placing Type', rowNumber))

String Reinsured = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Reinsured']))


WebUI.verifyEqual(Reinsured, reinsured)

String MajorClass = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Major Class']))


WebUI.verifyEqual(MajorClass, majorClass)

String MinorClass = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Minor Class']))


WebUI.verifyEqual(MinorClass, findTestData(testData).getValue('Minor Class', rowNumber))

String EffectiveDate = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Effective Date']))


WebUI.verifyEqual(EffectiveDate, findTestData(testData).getValue('Inception Date', rowNumber))

String ExpirationDate = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnText', [('fieldName') : 'Expiration Date']))


WebUI.verifyEqual(ExpirationDate, date)

String Entity = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Entity']))


WebUI.verifyEqual(Entity, entity)

String LegalBranch = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Legal Branch']))


WebUI.verifyEqual(LegalBranch, findTestData(testData).getValue('Legal Branch', rowNumber))

String SubmissionStatus = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_TableColumnValue', [('fieldName') : 'Submission Status']))


WebUI.verifyEqual(SubmissionStatus, submissionStatus)

String yearEstablished = WebUI.getAttribute(findTestObject('Object Repository/UWWorksheet/input_FieldText', [('fieldName') : 'Year Established']),
	'value')


WebUI.verifyEqual(yearEstablished, '1852')

String shortCompanyDecsription = WebUI.getText(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Short company description']))

if (shortCompanyDecsription.contains(companyDescription)) {
	KeywordUtil.logInfo('Correct Company Description is present')
}

//LOB Specific
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Professional Indemnity'
			, ('index') : 1]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Crime'
			, ('index') : 1]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Directors & Officers´ Liability'
			, ('index') : 1]))

//Program Structure and Authority
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Blended'
			, ('index') : 1]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Directors & Officers´ Liability'
			, ('index') : 2]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Crime'
			, ('index') : 2]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Professional Indemnity'
			, ('index') : 2]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_DirectorsLiabilityProgramStr'))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 1]))


for (int i = 1; i <= expiringProgramStructureHeaderList.size(); i++) {
	WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_WithHeader_Div',
			[('headerName') : 'Expiring Program Structure', ('fieldName') : expiringProgramStructureHeaderList[(i - 1)]]))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring'
			, ('button') : delete_Button]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring'
			, ('button') : addItem_Button]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName', [('headerName') : 'Pricing Options'
			, ('buttonText') : 'Copy Expiring PS']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Pricing'
			, ('button') : delete_Button]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Pricing'
			, ('button') : addItem_Button]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 2]))

for (int i = 1; i <= pricingOptionsHeaderList.size(); i++) {
	WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_WithHeader_Div',
			[('headerName') : 'Pricing Options', ('fieldName') : pricingOptionsHeaderList[(i - 1)]]))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName', [('headerName') : 'Final Program Structure'
			, ('buttonText') : 'Copy Expiring PS']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName', [('headerName') : 'Final Program Structure'
			, ('buttonText') : 'Copy Pricing Ops']))

for (int i = 1; i <= finalProgramStructureHeaderList.size(); i++) {
	WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_WithHeader_Div',
			[('headerName') : 'Final Program Structure', ('fieldName') : finalProgramStructureHeaderList[(i - 1)]]))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Final', ('button') : delete_Button]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Final', ('button') : addItem_Button]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : addItem_Button]))


WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 1]),
	'EUR', false)


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : addItem_Button]),
	GlobalVariable.timeOutValue)


WebUI.click(findTestObject('Object Repository/UWWorksheet/btn_addItem'))


WebUI.click(findTestObject('Object Repository/UWWorksheet/btn_addItem'))


for (int i = 1; i < 3; i++) {
	WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLayerLimit']))
	WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLayerLimit']))
	
	WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pLayerLimit']), layerLimitValueList[(i - 1)])


	WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pUL']))
	WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pUL']))
	

	WebUI.clearText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pUL']))
	WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pUL']), pUlValueList[(i - 1)])


	WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLayerGWP']))
	WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLayerGWP']))
	

	WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pLayerGWP']), pGWPValueList[(i - 1)])


	WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLeadName']))
	WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLeadName']))
	

	WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pLeadName']), pLeadNameValueList[(i - 1)])


	WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLeadPercent']))
	WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLeadPercent']))
	

	WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pLeadPercent']), pLeadPercentValueList[(i - 1)])


	WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pTMHCCPercnt']))
	WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pTMHCCPercnt']))
	

	WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pTMHCCPercnt']), pTMHCCPercentValueList[(i - 1)])


	WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pCom']))

	WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pCom']))

	WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pCom']), pComValueList[(i - 1)])

}

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
			, ('index') : 1]))

////

WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
			, ('index') : 1]), 'Test test test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
			, ('index') : 1]))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
			, ('index') : 1]), 'Test test test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName', [('headerName') : 'Pricing Options'
			, ('buttonText') : 'Copy Expiring PS']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
			, ('index') : 2]))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
			, ('index') : 2]), 'Test test test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
			, ('index') : 2]))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
			, ('index') : 2]), 'Test test test')
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Within Underwriter´s Authority?'
			, ('option') : option_Yes]))


////WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 3]),

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_DirectorsLiabilityProgramStr'))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName', [('headerName') : 'Final Program Structure'
			, ('buttonText') : 'Copy Pricing Ops']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
			, ('index') : 3]))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
			, ('index') : 3]), 'Test test test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
			, ('index') : 3]))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
			, ('index') : 3]), 'Test test test')
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_HyperLink', [('index') : 19]))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_EnterLink', [('index') : 2]), 'http://ukdoctwpegap004:8080/prweb/app/LiabilityLines/beEBp4uRVTogorRwSwWqbOtn9IL2fwdI*/!STANDARD')


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_OK_Span', [('fieldName') : 'OK', ('index') : 1]))
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on the ESG profile of the company']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on the ESG profile of the company']),
	'Test ESG')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on the ESG profile of the company']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on the ESG profile of the company']),
	'Test ESG')
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_HyperLink', [('index') : 20]))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_EnterLink', [('index') : 12]), 'http://ukdocuwpegap012:8080/prweb/app/Image')
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_OK_Span', [('fieldName') : 'OK', ('index') : 2]))
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on any Cyber exposure']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on any Cyber exposure']),
	'Test Cyber')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on any Cyber exposure']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on any Cyber exposure']),
	'Test Cyber')
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_HyperLink', [('index') : 21]))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_EnterLink', [('index') : 22]), 'http://ukdocuwpegap012:8080/prweb/app/Image')
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_OK_Span', [('fieldName') : 'OK', ('index') : 3]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: Last Year´s comments']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: Last Year´s comments']),
	'Test Last Year´s comments')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: Last Year´s comments']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: Last Year´s comments']),
	'Test Last Year´s comments')
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_HyperLink', [('index') : 22]))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_EnterLink', [('index') : 32]), 'http://ukdocuwpegap012:8080/prweb/app/Image')
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_OK_Span', [('fieldName') : 'OK', ('index') : 4]))
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: This Year´s comments']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: This Year´s comments']),
	'Test This Year´s comments')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: This Year´s comments']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: This Year´s comments']),
	'Test This Year´s comments')
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_HyperLink', [('index') : 23]))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_EnterLink', [('index') : 42]), 'http://ukdocuwpegap012:8080/prweb/app/Image')
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_OK_Span', [('fieldName') : 'OK', ('index') : 5]))
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Points of attention for next renewal, if any']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Points of attention for next renewal, if any']),
	'Test points of attention')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Points of attention for next renewal, if any']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Points of attention for next renewal, if any']),
	'Test points of attention')
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_HyperLink', [('index') : 24]))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_EnterLink', [('index') : 52]), 'http://ukdocuwpegap012:8080/prweb/app/Image')
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_OK_Span', [('fieldName') : 'OK', ('index') : 6]))
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the Worksheet been completed?'
			, ('option') : option_Yes]))
WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Submit', [('index') : 1]))
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : 'Have all the necessary UW Authority Approvals been received? Click Continue to proceed.']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_Continue'))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Continue'))


WebUI.waitForElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : 'Your action has been completed.']),
	GlobalVariable.timeOutValue)
