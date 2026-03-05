/**
 * ============================================================================
 * Test Case ID : 259397
 * Title         : Sub Test Case Part2
 * Folder        : Scripts/Worksheets/259397_SubTestCase_Part2
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
import com.genericutils.helper.GenericUtils as GenericUtils
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


for (int i = 2; i < 3; i++) {
    WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLayerLimit']))

	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
		'$pLayerLimit']))
    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i + 
                '$pLayerLimit']), layerLimitValueList[(i - 1)])


    WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLayerGWP']))

	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
		'$pLayerGWP']))
    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i + 
                '$pLayerGWP']), pGWPValueList[(i - 1)])


    WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLeadName']))

	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
		'$pLeadName']))
    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i + 
                '$pLeadName']), pLeadNameValueList[(i - 1)])


    WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pLeadPercent']))

	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
		'$pLeadPercent']))
    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i + 
                '$pLeadPercent']), pLeadPercentValueList[(i - 1)])


    WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pTMHCCPercnt']))

	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
		'$pTMHCCPercnt']))
    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i + 
                '$pTMHCCPercnt']), pTMHCCPercentValueList[(i - 1)])


    WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : i + '$pCom']))

	WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i +
		'$pCom']))
    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : i + 
                '$pCom']), pComValueList[(i - 1)])

}

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
            , ('index') : 1]))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
            , ('index') : 1]), 'Test test test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
            , ('index') : 1]))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
            , ('index') : 1]), 'Test test test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName', [('headerName') : 'Pricing Options'
            , ('buttonText') : 'Copy Expiring PS']))

WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Pricing'
            , ('fieldName') : 'Position', ('index') : index2]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Pricing', ('fieldName') : 'Position'
            , ('index') : index2]))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Pricing', ('button') : delete_Button]))
WebUI.verifyElementNotPresent(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Pricing'
            , ('fieldName') : 'Position', ('index') : index2]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Pricing', ('button') : addItem_Button]))


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pLayerLimit']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pLayerLimit']))


WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 'PricingProgStructureList$l2$pLayerLimit']), 
    '200000')


WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pLayerGWP']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pLayerGWP']))


WebUI.clearText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 'PricingProgStructureList$l2$pLayerGWP']))
WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 'PricingProgStructureList$l2$pLayerGWP']), 
    '2500')


WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pLeadName']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pLeadName']))


WebUI.clearText(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pLeadName']))
WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 'PricingProgStructureList$l2$pLeadName']), 
    'AIG')


WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pLeadPercent']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pLeadPercent']))


WebUI.clearText(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pLeadPercent']))
WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 'PricingProgStructureList$l2$pLeadPercent']), 
    '100')


WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pTMHCCPercnt']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pTMHCCPercnt']))


WebUI.clearText(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pTMHCCPercnt']))


WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 'PricingProgStructureList$l2$pTMHCCPercnt']), 
    '0')


WebUI.mouseOver(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pCom']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pCom']))


WebUI.clearText(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l2$pCom']))


WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 'PricingProgStructureList$l2$pCom']), 
    '5')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l1$pLayerGWP']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 'PricingProgStructureList$l1$pLayerGWP']), 
    Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 'PricingProgStructureList$l1$pLayerGWP']), 
    '2000')


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_DynamicRefresh', [('fieldName') : 'Expiring']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_DynamicRefresh', [('fieldName') : 'Expiring']))
String value122 = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDataHeaderWithIndex', [('headerName') : '% of UL'
            , ('index') : 2]))

KeywordUtil.logInfo(value122)


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'PricingProgStructureList$l1$pLayerGWP']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 'PricingProgStructureList$l1$pLayerGWP']), 
    Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 'PricingProgStructureList$l1$pLayerGWP']), 
    '1000')


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_DynamicRefresh', [('fieldName') : 'Expiring']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_DynamicRefresh', [('fieldName') : 'Expiring']))


String value2222 = WebUI.getText(findTestObject('Object Repository/UWWorksheet/webElement_ReadDataHeaderWithIndex', [('headerName') : '% of UL'
            , ('index') : 2]))

KeywordUtil.logInfo(value2222)

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


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_CollapseAll'), 25)


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName', [('headerName') : 'Final Program Structure'
            , ('buttonText') : 'Copy Pricing Ops']), GlobalVariable.timeoutShort)


WebUI.selectOptionByLabel(findTestObject('Object Repository/UWWorksheet/select_DropDown', [('fieldName') : 'Currency', ('index') : 8]), 
    'EUR', false)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_DynamicButtonWithHeaderName', [('headerName') : 'Final Program Structure'
            , ('buttonText') : 'Copy Pricing Ops']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Final Program Structure'
            , ('fieldName') : 'Position', ('index') : index2]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Final', ('button') : delete_Button]))


WebUI.verifyElementNotPresent(findTestObject('Object Repository/UWWorksheet/webElement_DynamicFieldNames', [('headerName') : 'Final Program Structure'
            , ('fieldName') : 'Position', ('index') : index2]), GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_NameOfButton', [('fieldName') : 'Final', ('button') : addItem_Button]))


for (int i = 2; i < 3; i++) {
    WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : ('pFinalProgStructureList$l' + 
                i) + '$pLayerLimit']))


    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('pFinalProgStructureList$l' + 
                i) + '$pLayerLimit']), layerLimitValueList[(i - 1)])


    WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : ('pFinalProgStructureList$l' + 
                i) + '$pLayerGWP']))


    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('pFinalProgStructureList$l' + 
                i) + '$pLayerGWP']), pGWPValueList[(i - 1)])


    WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : ('pFinalProgStructureList$l' + 
                i) + '$pLeadName']))


    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('pFinalProgStructureList$l' + 
                i) + '$pLeadName']), pLeadNameValueList[(i - 1)])


    WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : ('pFinalProgStructureList$l' + 
                i) + '$pLeadPercent']))


    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('pFinalProgStructureList$l' + 
                i) + '$pLeadPercent']), pLeadPercentValueList[(i - 1)])


    WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : ('pFinalProgStructureList$l' + 
                i) + '$pTMHCCPercnt']))


    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('pFinalProgStructureList$l' + 
                i) + '$pTMHCCPercnt']), pTMHCCPercentValueList[(i - 1)])


    WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : ('pFinalProgStructureList$l' + 
                i) + '$pCom']))


    WebUI.setText(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : ('pFinalProgStructureList$l' + 
                i) + '$pCom']), pComValueList[(i - 1)])

}


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_DynamicFieldNames', [('fieldName') : 'pFinalProgStructureList$l1$pLayerGWP']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 'pFinalProgStructureList$l1$pLayerGWP']), 
    Keys.chord(Keys.CONTROL, 'a'))
WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/webElement_EnterDynamicKeyFinancialValue', [('fieldName') : 'pFinalProgStructureList$l1$pLayerGWP']), 
    '2000')


WebUI.scrollToElement(findTestObject('Object Repository/UWWorksheet/button_DynamicRefresh', [('fieldName') : 'FinalProgram']), 
    GlobalVariable.timeOutValue)


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_DynamicRefresh', [('fieldName') : 'FinalProgram']))


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
            , ('index') : 3]))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
            , ('index') : 3]), 'Test test test')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
            , ('index') : 3]))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextAreaWithIndex', [('fieldName') : 'Comments from Underwriter'
            , ('index') : 3]), 'Test test test')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on the ESG profile of the company']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on the ESG profile of the company']), 
    'Test ESG')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on the ESG profile of the company']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on the ESG profile of the company']), 
    'Test ESG')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on any Cyber exposure']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on any Cyber exposure']), 
    'Test Cyber')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on any Cyber exposure']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Please comment on any Cyber exposure']), 
    'Test Cyber')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: Last Year´s comments']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: Last Year´s comments']), 
    'Test Last Year´s comments')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: Last Year´s comments']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: Last Year´s comments']), 
    'Test Last Year´s comments')

WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: This Year´s comments']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: This Year´s comments']), 
    'Test This Year´s comments')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: This Year´s comments']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Rationale: This Year´s comments']), 
    'Test This Year´s comments')
WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Points of attention for next renewal, if any']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Points of attention for next renewal, if any']), 
    'Test points of attention')


WebUI.click(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Points of attention for next renewal, if any']))


WebUI.sendKeys(findTestObject('Object Repository/UWWorksheet/input_TextArea', [('fieldName') : 'Points of attention for next renewal, if any']), 
    'Test points of attention')
WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Rater & Tearsheet Attached?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/checkBox_SelectOptionByFieldName', [('fieldName') : 'Has the Worksheet been completed?'
            , ('option') : option_Yes]))


WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Submit', [('index') : 1]))


WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : 'Have all the necessary UW Authority Approvals been received? Click Continue to proceed.']))

WebUI.verifyElementVisible(findTestObject('Object Repository/UWWorksheet/button_Continue'))

WebUI.click(findTestObject('Object Repository/UWWorksheet/button_Continue'))


WebUI.waitForElementPresent(findTestObject('Object Repository/UWWorksheet/webElement_ReadDynamicFieldName_Div', [('fieldName') : 'Your action has been completed.']), 
    GlobalVariable.timeOutValue)

WebUI.click(findTestObject('Object Repository/UWWorksheet/webElement_ToolsActions', [('actionName') : 'Print this work item'
            , ('index') : 2]))
KeywordUtil.markPassed('PDF version of Policy is generated')