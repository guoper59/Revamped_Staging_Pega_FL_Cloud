/**
 * ============================================================================
 * Test Case ID : 259909
 * Title         : Eclipse Validation
 * Folder        : Scripts/Eclipse/259909_EclipseValidation
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


import java.text.SimpleDateFormat

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


//Calling Get API to validate response---SBS ECLIPSE
ResponseObject response1 = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetProgramPackage'), null)

//In the General Section, check the following information:
String bureauSettled = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.BureauSettledInd')

KeywordUtil.logInfo(bureauSettled)

String interestValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Interest')

KeywordUtil.logInfo(interestValue)

//Verify if the policy status matches the expected value 'Written'
GenericUtils.verifyMatch('Verify Bureau Settled', 'true', bureauSettled, 'EQUAL')

//Verify Placing Type Value
GenericUtils.verifyMatch('Verify Placing Type', 'BF', WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.PlacingType'), 
    'EQUAL')

String uniqueMarketRef = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.UniqueMarketRef')

KeywordUtil.logInfo('Unique Market Reference Value is ::' + uniqueMarketRef)

String assureds = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Assureds.Organization[0].LegalName')

KeywordUtil.logInfo('Assured value is ::' + assureds)

String coverHolderValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].CoverHolders.Organization[0].LegalName')

KeywordUtil.logInfo('Cover Holder value is ::' + coverHolderValue)

String inceptionDateFormat = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.InceptionDate')

KeywordUtil.logInfo('Inception Date value is ::' + inceptionDateFormat)

Date date = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss').parse(inceptionDateFormat)

String inceptionDate = new SimpleDateFormat('dd/MM/yyyy').format(date)

KeywordUtil.logInfo('Inception Date value is ::' + inceptionDate)

String expiryDateFormat = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.ExpiryDate')

KeywordUtil.logInfo('Expiry Date value is ::' + expiryDateFormat)

Date date1 = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss').parse(expiryDateFormat)

String expirationDate = new SimpleDateFormat('dd/MM/yyyy').format(date1)

KeywordUtil.logInfo('Expiration Date value is ::' + expirationDate)

String mainClass = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Class4')

GenericUtils.verifyMatch('Verify Main Class value is ::', mainClass, mainClassExpectedValue, 'EQUAL')

String majorClassName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Class1')

GenericUtils.verifyMatch('Verify Major Class value is ::', majorClassName, majorClassExpectedValue, 'EQUAL')

String minorClassName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Class2')

GenericUtils.verifyMatch('Verify Minor Class value is ::', minorClassName, minorClassExpectedValue, 'EQUAL')

String class1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Class3')

GenericUtils.verifyMatch('Verify Minor Class value is ::', class1, classExpectedValue, 'EQUAL')

String policyPremium = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyPremiums[0].PolicyPremIncome')

GenericUtils.verifyMatch('Verify Policy Premium value is ::', policyPremium, policyPremiumValue, 'EQUAL')

String originalCurrency = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyPremiums[0].PremCcyISO')

GenericUtils.verifyMatch('Verify Original Currency value is ::', originalCurrency, originalCurrencyValue, 'EQUAL')

String producingTeam = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].ProducingTeam')

GenericUtils.verifyMatch('Verify Producing team value is ::', producingTeam, producingTeamValue, 'EQUAL')

String lineStatus = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].LineStatus')

GenericUtils.verifyMatch('Verify Line Status value is ::', lineStatus, lineStatusExpectedValue, 'EQUAL')

String entityName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].Synd')

GenericUtils.verifyMatch('Verify Entity Name value is ::', entityName, entityNameExpectedValue, 'EQUAL')

String signedOrder = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].SignedOrder')

GenericUtils.verifyMatch('Verify Signed Order value is ::', signedOrder, signedOrderExpectedValue, 'EQUAL')

String signedLine = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].SignedLine')

GenericUtils.verifyMatch('Verify Signed Line value is ::', signedLine, signedLineExpectedValue, 'EQUAL')

String riskCode1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].RiskCodes[0].CodeValue')

GenericUtils.verifyMatch('Verify Risk Code value is ::', riskCode1, riskCodeValue, 'EQUAL')

String premiumSplit1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].RiskCodes[0].PremSplit')

GenericUtils.verifyMatch('Verify Premium Split value is ::', premiumSplit1, premiumSplitValue, 'EQUAL')

String riskCode2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].RiskCodes[1].CodeValue')

GenericUtils.verifyMatch('Verify Risk Code value is ::', riskCode2, riskCodeValue1, 'EQUAL')

String premiumSplit2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].RiskCodes[1].PremSplit')

GenericUtils.verifyMatch('Verify Premium Split value is ::', premiumSplit2, premiumSplitValue1, 'EQUAL')

String brokerName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Placers[0].BrokerName')

KeywordUtil.logInfo('Broker Name Value is ::' + brokerName)

String brokerContactName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Placers[0].ContactName')

KeywordUtil.logInfo('Broker Contact Name Value is ::' + brokerContactName)

String riskCodeValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].RiskCode')

KeywordUtil.logInfo('Risk Code Value is ::' + riskCodeValue)

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
String riskCodeValue1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].RiskCode')

KeywordUtil.logInfo('Risk Code Value is ::' + riskCodeValue)

String installmentType1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].InstalmentType')

KeywordUtil.logInfo('Installment Type Value is ::' + installmentType)

String completed1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].Completed')

KeywordUtil.logInfo('Completed Value is ::' + completed)

String OrigCcyISO1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigCcyISO')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigCcyISO)

String OrigGross1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigGross')

KeywordUtil.logInfo('Original Currency Value is ::' + OrigGross)

String OrigNet1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigNet')

KeywordUtil.logInfo('Original Net Value is ::' + OrigNet)

String PostToLedger1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].PostToLedger')

KeywordUtil.logInfo('Post to ledger Value is ::' + PostToLedger)

String LedgeAccountID1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].LedgerAccountId')

KeywordUtil.logInfo('Ledger Account Value is ::' + LedgeAccountID)

//
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