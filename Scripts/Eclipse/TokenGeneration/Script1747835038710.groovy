/**
 * ============================================================================
 * Title        : TokenGeneration
 * Title         : TokenGeneration
 * Folder        : Scripts/Eclipse/TokenGeneration
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

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


//Calling Token Generation API
ResponseObject response = WS.sendRequest(findTestObject('Eclipse_APIs/BearerTokengeneration'))

assert response.getStatusCode() == 200

WS.verifyResponseStatusCode(response, 200)

GlobalVariable.AccessToken = WS.getElementText(response, 'access_token')

WebUI.comment(GlobalVariable.AccessToken)

