/**
 * ============================================================================
 * Test Case ID : 262218
 * Title         : Eclipse Validation
 * Folder        : Scripts/Eclipse/262218_EclipseValidation
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

import java.text.SimpleDateFormat

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//Calling Get API to validate response---SBS ECLIPSE
ResponseObject response = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetProgramPackage'), null)

String ENumber = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].EndorsementNumber')

WebUI.comment(ENumber)

GenericUtils.verifyMatch('Endorsement Number Value is ', ENumber, '1', 'EQUAL')

String EDate = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].EffectiveDate')

WebUI.comment(EDate)

SimpleDateFormat formatter = new SimpleDateFormat('yyyy-MM-dd\'T\'00:00:00', Locale.ENGLISH)

Date date = formatter.parse(EDate)

KeywordUtil.logInfo(date)

String formattedDate = new SimpleDateFormat('dd/MM/yyyy').format(date)

GenericUtils.verifyMatch('Effective Date Value is ', formattedDate, findTestData(testData).getValue('Inception Date', rowNumber), 
    'EQUAL')

String EStatus = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].EndorsementStatus')

WebUI.comment(EStatus)

GenericUtils.verifyMatch('Endorsement Status Value is ', EStatus, 'Closed', 'EQUAL')

String EType = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].Type')

WebUI.comment(EType)

GenericUtils.verifyMatch('Endorsement Type Value is ', EType, 'RET', 'EQUAL')

String ENotes = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].Notes')

WebUI.comment(ENotes)

GenericUtils.verifyMatch('Endorsement Notes Value is ', ENotes, 'Test test test test test test', 'EQUAL')

String type = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].InstalmentType')

WebUI.comment(type)

String originalCurrency = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigCcyISO')

WebUI.comment(originalCurrency)

String originalGross = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigGross')

WebUI.comment(originalGross)

String originalNet = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigNet')

WebUI.comment(originalNet)

String postToLedger = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].PostToLedger')

WebUI.comment(postToLedger)

String completed = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].Completed')

WebUI.comment(completed)

//for 2nd Row
String type2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].InstalmentType')

WebUI.comment(type2)

String originalCurrency2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigCcyISO')

WebUI.comment(originalCurrency2)

String originalGross2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigGross')

WebUI.comment(originalGross2)

String originalNet2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigNet')

WebUI.comment(originalNet2)

String postToLedger2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].PostToLedger')

WebUI.comment(postToLedger2)

String completed2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].Completed')

WebUI.comment(completed2)

//for 3rd Row
String type3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].InstalmentType')

WebUI.comment(type3)

String originalCurrency3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigCcyISO')

WebUI.comment(originalCurrency3)

String originalGross3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigGross')

WebUI.comment(originalGross3)

String originalNet3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigNet')

WebUI.comment(originalNet3)

String postToLedger3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].PostToLedger')

WebUI.comment(postToLedger3)

String completed3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].Completed')

WebUI.comment(completed3)

//for 4th Row
String type4 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].InstalmentType')

WebUI.comment(type4)

String originalCurrency4 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigCcyISO')

WebUI.comment(originalCurrency4)

String originalGross4 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigGross')

WebUI.comment(originalGross4)

String originalNet4 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigNet')

WebUI.comment(originalNet4)

String postToLedger4 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].PostToLedger')

WebUI.comment(postToLedger4)

String completed4 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].Completed')

WebUI.comment(completed4)

//for 5th Row
String type5 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].InstalmentType')

WebUI.comment(type5)

String originalCurrency5 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigCcyISO')

WebUI.comment(originalCurrency5)

String originalGross5 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigGross')

WebUI.comment(originalGross5)

String originalNet5 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigNet')

WebUI.comment(originalNet5)

String postToLedger5 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].PostToLedger')

WebUI.comment(postToLedger5)

String completed5 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].Completed')

WebUI.comment(completed5)

//for 6th Row
String type6 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].InstalmentType')

WebUI.comment(type6)

String originalCurrency6 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigCcyISO')

WebUI.comment(originalCurrency6)

String originalGross6 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigGross')

WebUI.comment(originalGross6)

String originalNet6 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigNet')

WebUI.comment(originalNet6)

String postToLedger6 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].PostToLedger')

WebUI.comment(postToLedger6)

String completed6 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].Completed')

WebUI.comment(completed6)