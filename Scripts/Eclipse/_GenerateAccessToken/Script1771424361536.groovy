/**
 * ============================================================================
 * Title        :  GenerateAccessToken
 * Title         :  GenerateAccessToken
 * Folder        : Scripts/Eclipse/_GenerateAccessToken
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
import internal.GlobalVariable

// Calling Token Generation API
ResponseObject tokenRes = WS.sendRequest(findTestObject('Eclipse_APIs/BearerTokengeneration'))
WS.verifyResponseStatusCode(tokenRes, 200)

GlobalVariable.AccessToken = WS.getElementText(tokenRes, 'access_token')

return GlobalVariable.AccessToken
