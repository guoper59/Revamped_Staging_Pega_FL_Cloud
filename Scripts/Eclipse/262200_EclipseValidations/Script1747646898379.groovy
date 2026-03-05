/**
 * ============================================================================
 * Test Case ID : 262200
 * Title         : Eclipse Validations
 * Folder        : Scripts/Eclipse/262200_EclipseValidations
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

//Calling Get API to validate response---SBS ECLIPSE
ResponseObject response1 = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetProgramPackage'), null)

//Retrieve the policy status from the response
String policyStatus = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].LineStatus')

KeywordUtil.logInfo('Policy Status Value is ::' + policyStatus)

//Verify if the policy status matches the expected value 'Signed'

//In the General Section, check the following information:
String bureauSettled = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.BureauSettledInd')

KeywordUtil.logInfo('Bureau Settled Value is ::' + bureauSettled)

String interestValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Interest')

KeywordUtil.logInfo('Intereset Value type is ::' + interestValue)

GenericUtils.verifyMatch('Verify Bureau Settled', bureauSettled, 'false', 'EQUAL')

String assureds = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Assureds.Organization[0].LegalName')

KeywordUtil.logInfo('Assured value is ::' + assureds)

String limit = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[0].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit)

String limitBasis = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[0].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis)

//
String limit1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[1].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit1)

String limitBasis1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[1].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis1)

//
String limit2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[2].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit2)

String limitBasis2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[2].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis2)

//
String limit3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[3].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit3)

String limitBasis3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[3].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis3)

//
String limit4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[4].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit4)

String limitBasis4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[4].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis4)

//
String limit5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[5].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit5)

String limitBasis5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[5].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis5)

//
String limit6 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[6].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit6)

String limitBasis6 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[6].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis6)

////
String limit7 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[7].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit7)

String limitBasis7 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[7].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis7)

//////
String limit8 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[8].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit8)

String limitBasis8 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[8].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis8)

//////
String limit9 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[9].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit9)

String limitBasis9 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[9].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis9)

////////
String limit10 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[10].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit10)

String limitBasis10 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[10].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis10)

////////
String limit11 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[11].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit11)

String limitBasis11 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[11].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis11)

//////////
String limit12 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[12].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit12)

String limitBasis12 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[12].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis12)

///////////////
String limit13 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[13].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit13)

String limitBasis13 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[13].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis13)

/////////////
String limit14 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[14].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit14)

String limitBasis14 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[14].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis14)

/////////////
String limit15 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[15].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit15)

String limitBasis15 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[15].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis15)

/////////////
String limit16 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[16].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit16)

String limitBasis16 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[16].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis16)

////////////
String limit17 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[17].Limit')

KeywordUtil.logInfo('Limit value is ::' + limit17)

String limitBasis17 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[17].LimitBasis')

KeywordUtil.logInfo('Limit Basis value is ::' + limitBasis17)

String inceptionDateFormat = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.InceptionDate')

KeywordUtil.logInfo('Inception Date value is ::' + inceptionDateFormat)

Date date = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss').parse(inceptionDateFormat)

String inceptionDateValue = new SimpleDateFormat('dd/MM/yyyy').format(date)

KeywordUtil.logInfo('Inception Date value is ::' + inceptionDateValue)

GenericUtils.verifyMatch('Verify Inception Date is ::', inceptionDateValue, findTestData(testData).getValue('Inception Date', 
        rowNumber), 'EQUAL')

String expiryDateFormat = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.ExpiryDate')

KeywordUtil.logInfo('Expiry Date value is ::' + expiryDateFormat)

Date date1 = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss').parse(expiryDateFormat)

String expirationDate = new SimpleDateFormat('dd/MM/yyyy').format(date1)

KeywordUtil.logInfo('Expiration Date value is ::' + expirationDate)

String mainClass = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Class4')

KeywordUtil.logInfo('Main Class Value is ::' + mainClass)

String majorClassName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Class1')

KeywordUtil.logInfo('Major Class Value is ::' + majorClassName)

String minorClassName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Class2')

KeywordUtil.logInfo('Minor Class Value is ::' + minorClassName)

String class1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Class3')

KeywordUtil.logInfo('Class Value is ::' + class1)

String policyPremium = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyPremiums[0].PolicyPremIncome')

KeywordUtil.logInfo('Policy Premium Value is ::' + policyPremium)

String originalCurrencyValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyPremiums[0].PremCcyISO')

KeywordUtil.logInfo('Original Currency Value is ::' + originalCurrencyValue)

String producingTeam = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].ProducingTeam')

KeywordUtil.logInfo('Producing Team Value is ::' + producingTeam)

String lineStatus = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].LineStatus')

KeywordUtil.logInfo('Line Status Value is ::' + lineStatus)

String writtenOrder = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].WrittenOrder')

KeywordUtil.logInfo('Written Order Value is ::' + writtenOrder)

String writtenLine = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].WrittenLine')

KeywordUtil.logInfo('Written Line Value is ::' + writtenLine)

String entityValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].LegalBranch')

KeywordUtil.logInfo('Entity Value is ::' + entityValue)

String brokerName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Placers[0].BrokerName')

KeywordUtil.logInfo('Broker Name Value is ::' + brokerName)

String brokerContactName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Placers[0].ContactName')

KeywordUtil.logInfo('Broker Contact Name Value is ::' + brokerContactName)

//Deductions Type
String deductionType1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyDeductions[0].ID')

KeywordUtil.logInfo('Deduction Type Value is ::' + deductionType1)

String deductionValue1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyDeductions[0].DeductionValue')

KeywordUtil.logInfo('Deduction Value is ::' + deductionValue1)

String deductionType2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyDeductions[1].ID')

KeywordUtil.logInfo('Deduction Type Value is ::' + deductionType2)

String deductionValue2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyDeductions[1].DeductionValue')

KeywordUtil.logInfo('Deduction Value is ::' + deductionValue2)

String deductionType3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyDeductions[2].ID')

KeywordUtil.logInfo('Deduction Type Value is ::' + deductionType3)

String deductionValue3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyDeductions[2].DeductionValue')

KeywordUtil.logInfo('Deduction Type Value is ::' + deductionValue3)





//
String installmentType = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].InstalmentType')

KeywordUtil.logInfo('Installment Type Value is ::' + installmentType)

String completed = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].Completed')

KeywordUtil.logInfo('Completed Value is ::' + completed)

String OrigCcyISO = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigCcyISO')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigCcyISO)

String OrigGross = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigGross')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigGross)

String OrigNet = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigNet')

KeywordUtil.logInfo('Original Net Value is ::' + OrigNet)

String PostToLedger = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].PostToLedger')

KeywordUtil.logInfo('Post to ledger Value is ::' + PostToLedger)

String LedgeAccountID = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].LedgerAccountId')

KeywordUtil.logInfo('Ledger Account Value is ::' + LedgeAccountID)

//
String installmentType1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].InstalmentType')

KeywordUtil.logInfo('Installment Type Value is ::' + installmentType1)

String completed1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].Completed')

KeywordUtil.logInfo('Completed Value is ::' + completed1)

String OrigCcyISO1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigCcyISO')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigCcyISO1)

String OrigGross1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigGross')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigGross1)

String OrigNet1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigNet')

KeywordUtil.logInfo('Original Net Value is ::' + OrigNet1)

String PostToLedger1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].PostToLedger')

KeywordUtil.logInfo('Post to ledger Value is ::' + PostToLedger1)

String LedgeAccountID1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].LedgerAccountId')

KeywordUtil.logInfo('Ledger Account Value is ::' + LedgeAccountID1)

//
String installmentType2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].InstalmentType')

KeywordUtil.logInfo('Installment Type Value is ::' + installmentType2)

String completed2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].Completed')

KeywordUtil.logInfo('Completed Value is ::' + completed2)

String OrigCcyISO2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].OrigCcyISO')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigCcyISO2)

String OrigGross2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].OrigGross')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigGross2)

String OrigNet2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].OrigNet')

KeywordUtil.logInfo('Original Net Value is ::' + OrigNet2)

String PostToLedger2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].PostToLedger')

KeywordUtil.logInfo('Post to ledger Value is ::' + PostToLedger2)

String LedgeAccountID2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].LedgerAccountId')

KeywordUtil.logInfo('Ledger Account Value is ::' + LedgeAccountID2)

//
String installmentType3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].InstalmentType')

KeywordUtil.logInfo('Installment Type Value is ::' + installmentType3)

String completed3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].Completed')

KeywordUtil.logInfo('Completed Value is ::' + completed3)

String OrigCcyISO3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].OrigCcyISO')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigCcyISO3)

String OrigGross3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].OrigGross')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigGross3)

String OrigNet3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].OrigNet')

KeywordUtil.logInfo('Original Net Value is ::' + OrigNet3)

String PostToLedger3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].PostToLedger')

KeywordUtil.logInfo('Post to ledger Value is ::' + PostToLedger3)

String LedgeAccountID3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].LedgerAccountId')

KeywordUtil.logInfo('Ledger Account Value is ::' + LedgeAccountID3)

//
String settlementType1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].SettlementSchedMarketDeductions[0].Type')

KeywordUtil.logInfo('Settlement Type Value is ::' + settlementType1)

String settlementAdditionIndicator1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].SettlementSchedMarketDeductions[0].Addition')

KeywordUtil.logInfo('Settlement Indicator Value is ::' + settlementAdditionIndicator1)

String settlementTotalAmount1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].SettlementSchedMarketDeductions[0].TotalAmt')

KeywordUtil.logInfo('Settlement Total Amount Value is ::' + settlementTotalAmount1)

String settlementLedgerAccountID1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].SettlementSchedMarketDeductions[0].LedgerAccountId')

KeywordUtil.logInfo('Settlement Ledger Account ID is ::' + settlementLedgerAccountID1)

String settlementType2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].SettlementSchedMarketDeductions[0].Type')

KeywordUtil.logInfo('Settlement Type Value is ::' + settlementType2)

String settlementAdditionIndicator2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].SettlementSchedMarketDeductions[0].Addition')

KeywordUtil.logInfo('Settlement Indicator Value is ::' + settlementAdditionIndicator2)

String settlementTotalAmount2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].SettlementSchedMarketDeductions[0].TotalAmt')

KeywordUtil.logInfo('Settlement Total Amount Value is ::' + settlementTotalAmount2)

String settlementLedgerAccountID2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].SettlementSchedMarketDeductions[0].LedgerAccountId')

KeywordUtil.logInfo('Settlement Ledger Account ID is ::' + settlementLedgerAccountID2)

//
String settlementType3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[0].Type')

KeywordUtil.logInfo('Settlement Type Value is ::' + settlementType3)

String settlementAdditionIndicator3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[0].Addition')

KeywordUtil.logInfo('Settlement Indicator Value is ::' + settlementAdditionIndicator3)

String settlementTotalAmount3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[0].TotalAmt')

KeywordUtil.logInfo('Settlement Total Amount Value is ::' + settlementTotalAmount3)

String settlementLedgerAccountID3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[0].LedgerAccountId')

KeywordUtil.logInfo('Settlement Ledger Account ID is ::' + settlementLedgerAccountID3)

String settlementType4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].SettlementSchedMarketDeductions[0].Type')

KeywordUtil.logInfo('Settlement Type Value is ::' + settlementType4)

String settlementAdditionIndicator4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].SettlementSchedMarketDeductions[0].Addition')

KeywordUtil.logInfo('Settlement Indicator Value is ::' + settlementAdditionIndicator4)

String settlementTotalAmount4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].SettlementSchedMarketDeductions[0].TotalAmt')

KeywordUtil.logInfo('Settlement Total Amount Value is ::' + settlementTotalAmount4)

String settlementLedgerAccountID4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].SettlementSchedMarketDeductions[0].LedgerAccountId')

KeywordUtil.logInfo('Settlement Ledger Account ID is ::' + settlementLedgerAccountID4)

//
String settlementType5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].SettlementSchedMarketDeductions[0].Type')

KeywordUtil.logInfo('Settlement Type Value is ::' + settlementType5)

String settlementAdditionIndicator5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].SettlementSchedMarketDeductions[0].Addition')

KeywordUtil.logInfo('Settlement Indicator Value is ::' + settlementAdditionIndicator5)

String settlementTotalAmount5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].SettlementSchedMarketDeductions[0].TotalAmt')

KeywordUtil.logInfo('Settlement Total Amount Value is ::' + settlementTotalAmount5)

String settlementLedgerAccountID5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].SettlementSchedMarketDeductions[0].LedgerAccountId')

KeywordUtil.logInfo('Settlement Ledger Account ID is ::' + settlementLedgerAccountID5)

