/**
 * ============================================================================
 * Title        : GetProgramPackage
 * Title         : GetProgramPackage
 * Folder        : Scripts/Eclipse/GetProgramPackage
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

// Generate token (sets GlobalVariable.AccessToken)
WebUI.callTestCase(findTestCase('Eclipse/_GenerateAccessToken'), [:])

ResponseObject response = WS.sendRequest(findTestObject('Eclipse_APIs/GetProgramPackage'))
WS.verifyResponseStatusCode(response, 200)

return response
