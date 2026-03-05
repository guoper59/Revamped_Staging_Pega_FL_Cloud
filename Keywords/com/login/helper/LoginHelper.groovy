package com.login.helper

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


public class LoginHelper {
	/*
	 * Login with specific users
	 * accept login from the global variable
	 * @return logged in to the page
	 */
	@Keyword
	public void loginToApplication(String userName,String password,String role) {

		try {

			WebUI.sendKeys(findTestObject('Object Repository/Page_Login_Page/input_Username'), userName)

			WebUI.sendKeys(findTestObject('Object Repository/Page_Login_Page/input_Username'), Keys.chord(Keys.TAB))

			WebUI.sendKeys(findTestObject('Object Repository/Page_Login_Page/input_Password'), password)

			WebUI.click(findTestObject('Object Repository/Page_Login_Page/button_Login'))

			KeywordUtil.logInfo('Logged in with' + role + 'user')
			
		}
		catch (Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())

			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}

	@Keyword
	public void logOffApplication() {

		try {


			WebUI.click(findTestObject('Object Repository/OutwardsPolicy/button_UserName'))
			WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Login_Page/button_Logoff'), GlobalVariable.timeOutValue)
			WebUI.click(findTestObject('Object Repository/Page_Login_Page/button_Logoff'))

			
			KeywordUtil.logInfo('Logged off Successfully')
		}
		catch (Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())

			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
}
