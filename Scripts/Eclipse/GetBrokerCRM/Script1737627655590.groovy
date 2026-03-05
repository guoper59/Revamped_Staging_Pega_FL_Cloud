/**
 * ============================================================================
 * Title        : GetBrokerCRM
 * Title         : GetBrokerCRM
 * Folder        : Scripts/Eclipse/GetBrokerCRM
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

import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


//Calling Token Generation API
ResponseObject responseToken = WS.sendRequest(findTestObject('Object Repository/Eclipse_APIs/BearerTokengeneration'))

assert responseToken.getStatusCode() == 200

WS.verifyResponseStatusCode(responseToken, 200)

String accessToken = WS.getElementText(responseToken, 'access_token')

GlobalVariable.AccessToken = accessToken

WebUI.comment(GlobalVariable.AccessToken)


ResponseObject response = WS.sendRequest(findTestObject('Object Repository/Eclipse_APIs/GetBrokerCRM'))
KeywordUtil.logInfo(response)
KeywordUtil.logInfo(response.getStatusCode())
assert response.getStatusCode() == 200

WS.verifyResponseStatusCode(response, 200)


return response
