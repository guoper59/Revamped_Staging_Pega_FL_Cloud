/**
 * ============================================================================
 * Test Case ID : 262194
 * Title         : Eclipse Validation
 * Folder        : Scripts/Eclipse/262194_EclipseValidation
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

import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


//Calling Get API to validate response---SBS ECLIPSE
ResponseObject response1 = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetProgramPackage'), null)

//Retrieve the policy status from the response
String policyStatus = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].LineStatus')

KeywordUtil.logInfo('Policy Status Value is ::' + policyStatus)

//Verify if the policy status matches the expected value 'Written'
GenericUtils.verifyMatch('Verify Status of Policy', 'Signed', policyStatus, 'EQUAL')

//In the General Section, check the following information:
String bureauSettled = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.BureauSettledInd')

KeywordUtil.logInfo('Bureau Settled ::' + bureauSettled)

String interestValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Interest')

KeywordUtil.logInfo('Interest Value is ::' + interestValue)

GenericUtils.verifyMatch('Verify Bureau Settled', 'false', bureauSettled, 'EQUAL')

String placingBasis = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.PlacingType')

KeywordUtil.logInfo('Placing Basis Value is ::' + placingBasis)

String assureds = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Assureds.Organization[0].LegalName')

KeywordUtil.logInfo('Assured value is ::' + assureds)

String reAssured = WS.getElementText(response1, 'ResponseWrapper.Policies[0].ReAssureds.Organization[0].LegalName')

KeywordUtil.logInfo('ReAssured value is ::' + reAssured)

String inceptionDateFormat = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.InceptionDate')

KeywordUtil.logInfo('Inception Date value is ::' + inceptionDateFormat)

Date date = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss').parse(inceptionDateFormat)

String inceptionDate = new SimpleDateFormat('dd/MM/yyyy').format(date)

KeywordUtil.logInfo('Inception Date value is ::' + inceptionDate)

GenericUtils.verifyMatch('Verify Inception Date is ::', inceptionDate, findTestData(testData).getValue('Inception Date', 
        rowNumber), 'EQUAL')

String expiryDateFormat = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.ExpiryDate')

KeywordUtil.logInfo('Expiry Date value is ::' + expiryDateFormat)

Date date1 = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss').parse(expiryDateFormat)

String expirationDate = new SimpleDateFormat('dd/MM/yyyy').format(date1)

KeywordUtil.logInfo('Expiration Date value is ::' + expirationDate)

GenericUtils.verifyMatch('Verify Expiry Date is ::', expirationDate, GlobalVariable.ExpirationDate, 'EQUAL')

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

String originalCurrency = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyPremiums[0].PremCcyISO')

KeywordUtil.logInfo('Original Currency Value is ::' + originalCurrency)

String producingTeam = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].ProducingTeam')

KeywordUtil.logInfo('Producing Team Value is ::' + producingTeam)

String lineStatus = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].LineStatus')

KeywordUtil.logInfo('Line Status Value is ::' + lineStatus)

String signedOrder = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].WrittenOrder')

KeywordUtil.logInfo('Signed Order Value is ::' + signedOrder)

String signedLine = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].WrittenLine')

KeywordUtil.logInfo('Signed Line Value is ::' + signedLine)

String brokerName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Placers[0].BrokerName')

KeywordUtil.logInfo('Broker Name Value is ::' + brokerName)

String brokerContactName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Placers[0].ContactName')

KeywordUtil.logInfo('Broker Contact Name Value is ::' + brokerContactName)

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

//Step 64
String settlementType = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].Type')

KeywordUtil.logInfo('Settlement Type Value is ::' + settlementType)

String settlementAdditionIndicator = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].Addition')

KeywordUtil.logInfo('Settlement Indicator Value is ::' + settlementAdditionIndicator)

String settlementTotalAmount = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].TotalAmt')

KeywordUtil.logInfo('Settlement Total Amount Value is ::' + settlementTotalAmount)

String settlementLedgerAccountID = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].LedgerAccountId')

KeywordUtil.logInfo('Settlement Ledger Account ID is ::' + settlementLedgerAccountID)

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