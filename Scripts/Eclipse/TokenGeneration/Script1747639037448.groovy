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


import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Reuse token generation test case
WebUI.callTestCase(findTestCase('Eclipse/_GenerateAccessToken'), [:])
