/**
 * ============================================================================
 * Test Case ID : 262213
 * Title         : Eclipse Validation
 * Folder        : Scripts/Eclipse/262213_EclipseValidation
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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//Calling Get API to validate response---SBS ECLIPSE
ResponseObject response = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetProgramPackage'), null)


//Verify all endorsement details in response
String ENumber = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].EndorsementNumber')

WebUI.comment(ENumber)

KeywordUtil.logInfo('Endorsement Number value is ::' + ENumber)

GenericUtils.verifyMatch('Endorsement Number Value is ', ENumber, '1', 'EQUAL')

String EDate = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].EffectiveDate')

Date date = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss').parse(EDate)

String effectiveDate = new SimpleDateFormat('dd/MM/yyyy').format(date)

WebUI.comment(effectiveDate)

KeywordUtil.logInfo('Effective Date value is ::' + effectiveDate)

String EStatus = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].EndorsementStatus')

WebUI.comment(EStatus)

KeywordUtil.logInfo('Endorsement Status value is ::' + EStatus)

GenericUtils.verifyMatch('Endorsement Status Value is ', EStatus, 'Closed', 'EQUAL')

String EType = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].Type')

WebUI.comment(EType)

GenericUtils.verifyMatch('Endorsement Type Value is ', EType, 'ADP', 'EQUAL')

String ENotes = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].Notes')

WebUI.comment(ENotes)

KeywordUtil.logInfo('Notes value is ::' + ENotes)

GenericUtils.verifyMatch('Endorsement Notes Value is ', ENotes, 'Test test test test test test', 'EQUAL')

String installmentType = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].InstalmentType')

KeywordUtil.logInfo('Installment Type Value is ::' + installmentType)

String completed = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].Completed')

KeywordUtil.logInfo('Completed Value is ::' + completed)

String OrigCcyISO = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigCcyISO')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigCcyISO)

String OrigGross = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigGross')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigGross)

String OrigNet = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigNet')

KeywordUtil.logInfo('Original Net Value is ::' + OrigNet)

String PostToLedger = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].PostToLedger')

KeywordUtil.logInfo('Post to ledger Value is ::' + PostToLedger)

String LedgeAccountID = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].LedgerAccountId')

KeywordUtil.logInfo('Ledger Account Value is ::' + LedgeAccountID)

String installmentType1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].InstalmentType')

KeywordUtil.logInfo('Installment Type Value is ::' + installmentType1)

String completed1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].Completed')

KeywordUtil.logInfo('Completed Value is ::' + completed1)

String OrigCcyISO1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigCcyISO')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigCcyISO1)

String OrigGross1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigGross')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigGross1)

String OrigNet1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigNet')

KeywordUtil.logInfo('Original Net Value is ::' + OrigNet1)

String PostToLedger1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].PostToLedger')

KeywordUtil.logInfo('Post to ledger Value is ::' + PostToLedger1)

String LedgeAccountID1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].LedgerAccountId')

KeywordUtil.logInfo('Ledger Account Value is ::' + LedgeAccountID1)

String installmentType2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].InstalmentType')

KeywordUtil.logInfo('Installment Type Value is ::' + installmentType2)

String completed2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].Completed')

KeywordUtil.logInfo('Completed Value is ::' + completed2)

String OrigCcyISO2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].OrigCcyISO')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigCcyISO2)

String OrigGross2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].OrigGross')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigGross2)

String OrigNet2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].OrigNet')

KeywordUtil.logInfo('Original Net Value is ::' + OrigNet2)

String PostToLedger2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].PostToLedger')

KeywordUtil.logInfo('Post to ledger Value is ::' + PostToLedger2)

String LedgeAccountID2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].LedgerAccountId')

KeywordUtil.logInfo('Ledger Account Value is ::' + LedgeAccountID2)

String installmentType3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].InstalmentType')

KeywordUtil.logInfo('Installment Type Value is ::' + installmentType3)

String completed3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].Completed')

KeywordUtil.logInfo('Completed Value is ::' + completed3)

String OrigCcyISO3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].OrigCcyISO')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigCcyISO3)

String OrigGross3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].OrigGross')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigGross3)

String OrigNet3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].OrigNet')

KeywordUtil.logInfo('Original Net Value is ::' + OrigNet3)

String PostToLedger3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].PostToLedger')

KeywordUtil.logInfo('Post to ledger Value is ::' + PostToLedger3)

String LedgeAccountID3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].LedgerAccountId')

KeywordUtil.logInfo('Ledger Account Value is ::' + LedgeAccountID3)

//PolicySettlement
String settlementType = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].Type')

KeywordUtil.logInfo('Settlement Type Value is ::' + settlementType)

String settlementAdditionIndicator = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].Addition')

KeywordUtil.logInfo('Settlement Indicator Value is ::' + settlementAdditionIndicator)

String settlementTotalAmount = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].TotalAmt')

KeywordUtil.logInfo('Settlement Total Amount Value is ::' + settlementTotalAmount)

String settlementLedgerAccountID = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].LedgerAccountId')

KeywordUtil.logInfo('Settlement Ledger Account ID is ::' + settlementLedgerAccountID)

String settlementType1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].SettlementSchedMarketDeductions[0].Type')

KeywordUtil.logInfo('Settlement Type Value is ::' + settlementType1)

String settlementAdditionIndicator1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].SettlementSchedMarketDeductions[0].Addition')

KeywordUtil.logInfo('Settlement Indicator Value is ::' + settlementAdditionIndicator1)

String settlementTotalAmount1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].SettlementSchedMarketDeductions[0].TotalAmt')

KeywordUtil.logInfo('Settlement Total Amount Value is ::' + settlementTotalAmount1)

String settlementLedgerAccountID1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].SettlementSchedMarketDeductions[0].LedgerAccountId')

KeywordUtil.logInfo('Settlement Ledger Account ID is ::' + settlementLedgerAccountID1)

String settlementType2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].SettlementSchedMarketDeductions[0].Type')

KeywordUtil.logInfo('Settlement Type Value is ::' + settlementType2)

String settlementAdditionIndicator2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].SettlementSchedMarketDeductions[0].Addition')

KeywordUtil.logInfo('Settlement Indicator Value is ::' + settlementAdditionIndicator2)

String settlementTotalAmount2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].SettlementSchedMarketDeductions[0].TotalAmt')

KeywordUtil.logInfo('Settlement Total Amount Value is ::' + settlementTotalAmount2)

String settlementLedgerAccountID2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].SettlementSchedMarketDeductions[0].LedgerAccountId')

KeywordUtil.logInfo('Settlement Ledger Account ID is ::' + settlementLedgerAccountID2)

String settlementType3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[0].Type')

KeywordUtil.logInfo('Settlement Type Value is ::' + settlementType3)

String settlementAdditionIndicator3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[0].Addition')

KeywordUtil.logInfo('Settlement Indicator Value is ::' + settlementAdditionIndicator3)

String settlementTotalAmount3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[0].TotalAmt')

KeywordUtil.logInfo('Settlement Total Amount Value is ::' + settlementTotalAmount3)

String settlementLedgerAccountID3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[0].LedgerAccountId')

KeywordUtil.logInfo('Settlement Ledger Account ID is ::' + settlementLedgerAccountID3)