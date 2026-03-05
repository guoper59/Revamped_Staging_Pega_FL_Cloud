/**
 * ============================================================================
 * Title        : GetSearchPartyCRM
 * Title         : GetSearchPartyCRM
 * Folder        : Scripts/Eclipse/GetSearchPartyCRM
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

ResponseObject response = WS.sendRequest(findTestObject('Object Repository/Eclipse_APIs/GetProgramPackage'))

assert response.getStatusCode() == 200

WS.verifyResponseStatusCode(response, 200)

return response