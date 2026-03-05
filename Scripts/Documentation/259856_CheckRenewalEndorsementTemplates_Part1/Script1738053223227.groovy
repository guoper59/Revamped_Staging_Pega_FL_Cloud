/**
 * ============================================================================
 * Test Case ID : 259856
 * Title         : Check Renewal Endorsement Templates Part1
 * Folder        : Scripts/Documentation/259856_CheckRenewalEndorsementTemplates_Part1
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

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable


String testData = 'Documentation'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

rowNumberforTestData = rowNumber

KeywordUtil.logInfo(GlobalVariable.testCaseID)


WebUI.switchToWindowIndex(1)


WebUI.switchToFrame(findTestObject('Object Repository/Pega_CreateInsured/iframePdfViewer'), GlobalVariable.timeOutValue)


WebUI.verifyTextPresent('Vertragsnummer:', false)

WebUI.verifyTextPresent(GlobalVariable.PolicyRef, false)

WebUI.verifyTextPresent('Verlängerung von:', false)

WebUI.verifyTextPresent(GlobalVariable.PolicyRef, false)

WebUI.verifyTextPresent('Versicherungsnehmerin', false)

WebUI.verifyTextPresent('und', false)

WebUI.verifyTextPresent('Anschrift:', false)

WebUI.verifyTextPresent(findTestData(testData).getValue('Addressline', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('PostCode', rowNumber), false)

WebUI.verifyTextPresent(findTestData(testData).getValue('City', rowNumber), false)

WebUI.verifyTextPresent('Versicherungsvermittler:', false)

WebUI.verifyTextPresent('OSKAR SCHUNCK GmbH & Co. KG', false)

WebUI.verifyTextPresent('Englschalkinger Str. 12', false)

WebUI.verifyTextPresent('81925 München', false)

WebUI.verifyTextPresent('Vertragsbeginn:', false)

WebUI.verifyTextPresent('Datum der Rückwärts', false)

WebUI.verifyTextPresent('versicherung:', false)

WebUI.verifyTextPresent('Unbegrenzt', false)

WebUI.verifyTextPresent('Kontinuitätsdatum:', false)

WebUI.verifyTextPresent('Versicherungsperiode:', false)

WebUI.verifyTextPresent('Beginn:', false)

WebUI.verifyTextPresent('Ende:', false)

WebUI.verifyTextPresent('01.03.2023', false)

WebUI.verifyTextPresent('um 12.00 Uhr mittags, MEZ', false)

WebUI.verifyTextPresent('29.02.2024', false)

WebUI.verifyTextPresent('Vertragsbeginn:', false)

WebUI.verifyTextPresent('Deckungssumme:', false)

WebUI.verifyTextPresent('1.000.000,', false)

WebUI.verifyTextPresent('EUR', false)

WebUI.verifyTextPresent('Kontinuitätsdatum:', false)

WebUI.verifyTextPresent('Versicherungsperiode:', false)

WebUI.verifyTextPresent('Beginn:', false)

WebUI.verifyTextPresent('jeweils', false)

WebUI.verifyTextPresent('pro', false)

WebUI.verifyTextPresent('Versicherungs', false)

WebUI.verifyTextPresent('und', false)

WebUI.verifyTextPresent('insgesamt', false)

WebUI.verifyTextPresent('Höchst', false)

WebUI.verifyTextPresent('ersatz', false)

WebUI.verifyTextPresent('leistung f', false)

WebUI.verifyTextPresent('ür die', false)

WebUI.verifyTextPresent('Versicherungsperiode', false)

WebUI.verifyTextPresent('Jahresprämie:', false)

WebUI.verifyTextPresent('EUR', false)

WebUI.verifyTextPresent('10.000,', false)

WebUI.verifyTextPresent('zzgl. gesetzlicher Versicherungssteuer', false)

WebUI.verifyTextPresent('Versicherer:', false)

WebUI.verifyTextPresent('Tokio Marine Europe S.A.', false)

WebUI.verifyTextPresent('(im Folgenden „Tokio Marine Europe” bzw.', false)

WebUI.verifyTextPresent('„TME“)', false)

WebUI.verifyTextPresent('26,', false)

WebUI.verifyTextPresent('venue de la Liberté L', false)

WebUI.verifyTextPresent('A', false)

WebUI.verifyTextPresent('1930', false)

WebUI.verifyTextPresent('Luxemburg', false)

WebUI.verifyTextPresent('S&P Rating: AA', false)

WebUI.verifyTextPresent('zugelassen und beauf', false)

WebUI.verifyTextPresent('sichtigt vom Finanzminister des Staates', false)

WebUI.verifyTextPresent('Luxemburg, beauf', false)

WebUI.verifyTextPresent('sichtigt vom Commissariat aux Assurances', false)

WebUI.verifyTextPresent('(CAA)', false)

WebUI.verifyTextPresent('handelnd durch die Zweigniederlassung für Deutschland', false)

WebUI.verifyTextPresent('Berliner Allee 26, 40212 Düsseldorf', false)

WebUI.verifyTextPresent('Niederlassung München', false)

WebUI.verifyTextPresent('leistung f', false)

WebUI.verifyTextPresent('ür die', false)

WebUI.verifyTextPresent('Rindermarkt 16, 80331 München', false)

WebUI.verifyTextPresent('Bedingungen dieses', false)

WebUI.verifyTextPresent('Grundvertrags:', false)

WebUI.verifyTextPresent('Tokio Marine Europe Versicherungsbedingungen', false)

WebUI.verifyTextPresent('zur', false)

WebUI.verifyTextPresent('Vermögensschaden', false)

WebUI.verifyTextPresent('Haftpflichtversicherung', false)

WebUI.verifyTextPresent('von Unternehmensleitern (Directors', false)

WebUI.verifyTextPresent('Versicherung)', false)

WebUI.verifyTextPresent('(TMHCC_D&O', false)

WebUI.verifyTextPresent('Bedingungen_Schunck_01', false)

WebUI.verifyTextPresent('2019)', false)

WebUI.switchToDefaultContent()

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)