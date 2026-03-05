/**
 * ============================================================================
 * Test Case ID : 260078
 * Title         : Eclipse Validation
 * Folder        : Scripts/Eclipse/260078_EclipseValidation
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

import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


//Calling Get API to validate response---SBS ECLIPSE
ResponseObject response1 = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetProgramPackage'), null)

//Retrieve the policy status from the response
String policyStatus = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].LineStatus')

KeywordUtil.logInfo('Policy Status Value is ::' + policyStatus)

//Verify if the policy status matches the expected value 'Signed'
GenericUtils.verifyMatch('Verify Status of Policy', 'Signed', policyStatus, 'EQUAL')

//In the General Section, check the following information:
String bureauSettled = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.BureauSettledInd')

KeywordUtil.logInfo('Bureau Settled Value is ::' + bureauSettled)

String interestValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Interest')

KeywordUtil.logInfo('Intereset Value type is ::' + interestValue)

GenericUtils.verifyMatch('Verify Bureau Settled', bureauSettled, 'false', 'EQUAL')

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

String limitValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[0].Limit')

KeywordUtil.logInfo('Limit value is ::' + limitValue)

String limitBasis = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[0].LimitBasis')

KeywordUtil.logInfo('Limit Basis Value is ::' + limitBasis)

String limitValue1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[1].Limit')

KeywordUtil.logInfo('Limit value is ::' + limitValue1)

String limitBasis1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[1].LimitBasis')

KeywordUtil.logInfo('Limit Basis Value is ::' + limitBasis1)

String limitValue2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[3].Limit')

KeywordUtil.logInfo('Limit Value is ::' + limitValue2)

String limitBasis2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[3].LimitBasis')

KeywordUtil.logInfo('Limit Value is ::' + limitBasis2)

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

String writtenOrder = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].WrittenOrder')

KeywordUtil.logInfo('Signed Order Value is ::' + writtenOrder)

String writtenLine = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].WrittenLine')

KeywordUtil.logInfo('Signed Line Value is ::' + writtenLine)

String entityName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].Synd')

KeywordUtil.logInfo('Entity Name Value is ::' + entityName)

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

//PolicySettlement
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