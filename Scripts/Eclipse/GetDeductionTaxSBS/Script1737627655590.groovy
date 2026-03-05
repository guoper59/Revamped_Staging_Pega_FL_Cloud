/**
 * ============================================================================
 * Title        : GetDeductionTaxSBS
 * Title         : GetDeductionTaxSBS
 * Folder        : Scripts/Eclipse/GetDeductionTaxSBS
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

ResponseObject response = WS.sendRequest(findTestObject('Eclipse_APIs/GetDeductionTaxSBS'))
WS.verifyResponseStatusCode(response, 200)


// --- Print useful details ---
println "Status: " + response.getStatusCode()
println "Headers: " + response.getHeaderFields()
println "Body:\n" + response.getResponseBodyContent()

// Optional: pretty-print JSON if it is JSON
try {
	def json = new groovy.json.JsonSlurper().parseText(response.getResponseBodyContent())
	println "Pretty JSON:\n" + groovy.json.JsonOutput.prettyPrint(groovy.json.JsonOutput.toJson(json))
} catch (Exception e) {
	println "Body is not JSON (or cannot be parsed as JSON)."
}


return response
