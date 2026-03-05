/**
 * ============================================================================
 * Test Case ID : 259397
 * Title         : Sub Test Case Part1
 * Folder        : Scripts/Worksheets/259397_SubTestCase_Part1
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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.model.FailureHandling


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any exposure larger than 10% of revenue or Assets in high risk countries?'
			, ('option') : option_Yes]))

//Key Financials
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : index3]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Magnitude', ('index') : index2]))

//Key Financials
for (int i = 1; i <= keyFinancialsList.size(); i++) {
	WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/text_FieldName', [('fieldName') : keyFinancialsList[
				(i - 1)]]))
}


for (int i = 1; i < 4; i++) {
	WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' +
		i, ('headerName') : 'FY2022']), 25)
	
	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' +
		i, ('headerName') : 'FY2022']))
	
	
	WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' +
				i, ('headerName') : 'FY2022']))

	
	WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' +
		i, ('headerName') : 'FY2022']), FailureHandling.OPTIONAL)

	
	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('KeyFinancialsData$l' +
				i) + '$pSecondYearValue']))
	WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('KeyFinancialsData$l' +
				i) + '$pSecondYearValue']), keyFinancialInputDataListYear2022[(i - 1)])
	
	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('KeyFinancialsData$l' +
				i) + '$pSecondYearValue']))
	WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('KeyFinancialsData$l' +
				i) + '$pSecondYearValue']), Keys.chord(Keys.TAB))

}

for (int i = 1; i < 5; i++) {
	WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pCapitalAdequecy$l' +
		i, ('headerName') : 'FY2022']), 25)

	
	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pCapitalAdequecy$l' +
				i, ('headerName') : 'FY2022']))

	WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pCapitalAdequecy$l' +
				i, ('headerName') : 'FY2022']))


	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('pCapitalAdequecy$l' +
				i) + '$pSecondYearValue']))
	WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('pCapitalAdequecy$l' +
				i) + '$pSecondYearValue']), keyFinancialInputDataSecondListYear2022[(i - 1)])
	WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('pCapitalAdequecy$l' +
				i) + '$pSecondYearValue']), Keys.chord(Keys.TAB))

}

for (int i = 1; i < 4; i++) {
	WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' +
		i, ('headerName') : 'FY2023']), 25)

	
	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' +
				i, ('headerName') : 'FY2023']))

	WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pKeyFinancialsData$l' +
				i, ('headerName') : 'FY2023']))

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('KeyFinancialsData$l' +
				i) + '$pThirdYearValue']))
	WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('KeyFinancialsData$l' +
				i) + '$pThirdYearValue']), keyFinancialInputDataListYear2023[(i - 1)])
	WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('KeyFinancialsData$l' +
				i) + '$pThirdYearValue']), Keys.chord(Keys.TAB))

}

for (int i = 1; i < 5; i++) {
	WebUI.waitForElementClickable(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pCapitalAdequecy$l' +
		i, ('headerName') : 'FY2023']), 25)
	
	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pCapitalAdequecy$l' +
				i, ('headerName') : 'FY2023']))

	WebUI.doubleClick(findTestObject('Object Repository/UWWorksheet/webElement_ClickDynamicKeyFinancialValue', [('fieldName') : 'pCapitalAdequecy$l' +
				i, ('headerName') : 'FY2023']))


	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('pCapitalAdequecy$l' +
				i) + '$pThirdYearValue']))
	WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('pCapitalAdequecy$l' +
				i) + '$pThirdYearValue']), keyFinancialInputDataSecondListYear2023[(i - 1)])
	WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('pCapitalAdequecy$l' +
				i) + '$pThirdYearValue']), Keys.chord(Keys.TAB))

}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : index4]))

//Performance Ratios List
for (int i = 1; i <= performanceRatiosList.size(); i++) {
	WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/text_FieldName', [('fieldName') : performanceRatiosList[
				(i - 1)]]))
}


WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Close Date'
			, ('index') : index2]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Year', ('index') : index2]))


WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Close Date', ('index') : index1]),
	'3 Months', false)


WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Year', ('index') : index1]),
	'2023', false)


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about profitability?'
			, ('option') : option_Yes]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about profitability?'
			, ('option') : option_Yes]))


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about liquidity?'
			, ('option') : option_Yes]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about liquidity?'
			, ('option') : option_Yes]))


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about solvency?'
			, ('option') : option_Yes]), GlobalVariable.timeoutShort)

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about solvency?'
			, ('option') : option_Yes]))

//M&A Section
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 5]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Magnitude', ('index') : 3]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any significant M&A in the past 2 years?'
			, ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any significant M&A in the past 2 years?'
			, ('option') : option_No]))


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any significant M&A in the past 2 years?'
			, ('option') : option_No]), GlobalVariable.timeoutShort)


for (int i = 1; i <= acquisitionsHeaderList.size(); i++) {
	WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_WithHeader_Div1',
			[('headerName') : 'M&A/ Acquisitions/ Sales/ Divestitures ( EUR - Millions)', ('fieldName') : acquisitionsHeaderList[
				(i - 1)]]))
}

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Any significant M&A in the past 2 years?'
			, ('option') : option_Yes]))


//Corporate Govt Sections
for (int i = 1; i <= corporateGovernanceHeaderList.size(); i++) {
	WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : corporateGovernanceHeaderList[
				(i - 1)]]))
}

for (int i = 1; i <= corporateGovernanceRowList.size(); i++) {
	WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Span', [('fieldName') : corporateGovernanceRowList[
				(i - 1)]]))
}

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
			, ('option') : option_Yes]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
			, ('option') : option_No]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Do you have any comments/concerns about the Corporate Governance? Please refer to the UW Guidelines.'
			, ('option') : option_Yes]))

//LOB Specific
WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Professional Indemnity'
			, ('index') : 1]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Crime'
			, ('index') : 1]))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Directors & Officers´ Liability'
			, ('index') : 1]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Crime', ('index') : 1]))


WebUI.switchToFrame(findTestObject('Object Repository/UWWorksheet/Page_Worksheets/iframe_PegaGadget2Ifr'), GlobalVariable.timeoutShort)

WebUI.verifyTextPresent('The LOB Specific Section is not applicable for this Major Class.', false)

WebUI.switchToDefaultContent()


WebUI.enhancedClick(findTestObject('Object Repository/UWWorksheet/radioButton_DynamicLabelWithIndexTabName', [('labelName') : 'Section Not Applicable'
			, ('tabName') : 'Crime', ('index') : 1]))


WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : 'This action will reveal the fields of this section. Click Continue to proceed.']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_Continue'))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Continue'))


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Crime'
			, ('index') : 1]), GlobalVariable.timeOutValue)


if (WebUI.verifyElementChecked(findTestObject('Object Repository/UWWorksheet/radioButton_DynamicLabelWithIndexTabName',
		[('labelName') : 'Section Not Applicable', ('tabName') : 'Crime', ('index') : 1]), GlobalVariable.timeoutShort)) {
	WebUI.enhancedClick(findTestObject('Object Repository/UWWorksheet/radioButton_DynamicLabelWithIndexTabName', [('labelName') : 'Section Not Applicable'
				, ('tabName') : 'Crime', ('index') : 1]))


	WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : 'This action will reveal the fields of this section. Click Continue to proceed.']))

	WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_Continue'))

	WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Continue'))
}


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLOBSpecificTabs', [('tabName') : 'Blended'
			, ('index') : 1]), GlobalVariable.timeOutValue)


for (int i = 1; i <= crimeSectionRowList.size(); i++) {
	WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_DynamicLabelLOBSpecific', [('labelName') : crimeSectionRowList[
				(i - 1)]]))

	KeywordUtil.logInfo(crimeSectionRowList[(i - 1)])

}

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


WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 6]))


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

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 8]))

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

WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 6]),
	'EUR', false)


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : addItem_Button]),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : addItem_Button]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : addItem_Button]))


for (int i = 1; i < 3; i++) {
	WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLayerLimit']))


	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pLayerLimit']))
	WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pLayerLimit']), layerLimitValueList[(i - 1)])


	WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pUL']))


	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pUL']))
	WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pUL']), pUlValueList[(i - 1)])


	WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLayerGWP']))

	
	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pLayerGWP']))
	
	
	WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pLayerGWP']), pGWPValueList[(i - 1)])


	WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLeadName']))
	WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLeadName']))
	WebUI.clearText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pLeadName']))


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


	WebUI.clearText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pCom']))
	WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pCom']), pComValueList[(i - 1)])


	WebUI.clearText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pLeadName']))


	WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
				'$pLeadName']), pLeadNameValueList[(i - 1)])
}


WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 1 + '$pLayerGWP']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 1 +
			'$pLayerGWP']), Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 1 +
			'$pLayerGWP']), '2000')


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_DynamicRefresh', [('fieldName') : 'Expiring']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_DynamicRefresh', [('fieldName') : 'Expiring']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_DirectorTab'))


String value1 = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDataHeaderWithIndex', [('headerName') : '% of UL'
			, ('index') : 2]))


WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 1 + '$pLayerGWP']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 1 +
			'$pLayerGWP']), Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 1 +
			'$pLayerGWP']), '1000')


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_DynamicRefresh', [('fieldName') : 'Expiring']),
	GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_DynamicRefresh', [('fieldName') : 'Expiring']))


String value2 = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDataHeaderWithIndex', [('headerName') : '% of UL'
			, ('index') : 2]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_ReadDataHeaderWithIndex', [('headerName') : '% of UL'
			, ('index') : 2]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : delete_Button]))

//            , ('index') : 2]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Expiring', ('button') : addItem_Button]))