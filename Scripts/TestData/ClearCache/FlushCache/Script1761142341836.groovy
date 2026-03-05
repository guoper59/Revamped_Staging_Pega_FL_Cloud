/**
 * ============================================================================
 * Title        : FlushCache
 * Title         : FlushCache
 * Folder        : Scripts/ClearCache/FlushCache
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
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


WebUI.navigateToUrl(GlobalVariable.applicationCacheClearUrl, FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Object Repository/Page_Login_Page/Page_Login Page/input_User name_txtUserID'), 'SupportAdmin')

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Login_Page/Page_Login Page/input_Password_txtPassword'), 25)
WebUI.setText(findTestObject('Object Repository/Page_Login_Page/Page_Login Page/input_Password_txtPassword'), GlobalVariable.SupportAdmin)

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Login_Page/Page_Login Page/span_Password_loginButtonText'), 25)
WebUI.click(findTestObject('Object Repository/Page_Login_Page/Page_Login Page/span_Password_loginButtonText'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Login_Page/Page_Pega Dev Studio/input_Search text_24dbd519'), 25)
WebUI.click(findTestObject('Object Repository/Page_Login_Page/Page_Pega Dev Studio/input_Search text_24dbd519'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Login_Page/Page_Pega Dev Studio/input_Search text_24dbd519'), 25)
WebUI.setText(findTestObject('Object Repository/Page_Login_Page/Page_Pega Dev Studio/input_Search text_24dbd519'), 'D_MasterRefData')

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Login_Page/Page_Pega Dev Studio/i_Search text_pi pi-search-2'), 25)
WebUI.click(findTestObject('Object Repository/Page_Login_Page/Page_Pega Dev Studio/i_Search text_pi pi-search-2'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Login_Page/Page_Pega Dev Studio/a_Applies to_pzSearchResultName_pySearchRes_4bbed7'), 25)
WebUI.click(findTestObject('Object Repository/Page_Login_Page/Page_Pega Dev Studio/a_Applies to_pzSearchResultName_pySearchRes_4bbed7'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Login_Page/Page_Pega Dev Studio/span_Definition_TABSPAN'), 25)
WebUI.click(findTestObject('Object Repository/Page_Login_Page/Page_Pega Dev Studio/span_Definition_TABSPAN'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Login_Page/Page_Pega Dev Studio/div_Page management_pzbtn-mid'), 25)
WebUI.click(findTestObject('Object Repository/Page_Login_Page/Page_Pega Dev Studio/div_Page management_pzbtn-mid'))

WebUI.switchToWindowTitle('Clear Data Page')

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Login_Page/Page_Clear Data Page/input_Flush All_1806a93e'), 25)
WebUI.click(findTestObject('Object Repository/Page_Login_Page/Page_Clear Data Page/input_Flush All_1806a93e'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Login_Page/Page_Clear Data Page/div_SortByRefCode_pzbtn-mid'), 25)
WebUI.click(findTestObject('Object Repository/Page_Login_Page/Page_Clear Data Page/div_SortByRefCode_pzbtn-mid'))

WebUI.switchToWindowTitle('Flush declarative clipboard page')

WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Login_Page/Page_Flush declarative clipboard page/span_Page successfully removed from clipboa_26c21e'), 25)
WebUI.click(findTestObject('Object Repository/Page_Login_Page/Page_Flush declarative clipboard page/span_Page successfully removed from clipboa_26c21e'))

WebUI.closeBrowser()

