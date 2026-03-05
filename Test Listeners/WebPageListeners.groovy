import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

class WebPageListeners {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def sampleBeforeTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseVariables()
		def TestDatatestCaseId = testCaseContext.getTestCaseId()
		GlobalVariable.testCaseID = TestDatatestCaseId.split('/').last()
		println GlobalVariable.testCaseID
		openBrowserLaunchApplication()
	}

	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		println testCaseContext.getTestCaseId()
		println testCaseContext.getTestCaseStatus()
		WebUI.closeBrowser()
	}

	def openBrowserLaunchApplication() {
		
		WebUI.openBrowser(null)
		WebUI.maximizeWindow()
		WebUI.setViewPortSize(1536, 864)
		
	}
}