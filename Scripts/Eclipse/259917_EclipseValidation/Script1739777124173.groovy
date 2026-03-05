/**
 * ============================================================================
 * Test Case ID : 259917
 * Title         : Eclipse Validation
 * Folder        : Scripts/Eclipse/259917_EclipseValidation
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

KeywordUtil.logInfo(policyStatus)

//Verify if the policy status matches the expected value 'Written'
GenericUtils.verifyMatch('Verify Status of Policy', 'Written', policyStatus, 'EQUAL')

//In the General Section, check the following information:
String bureauSettled = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.BureauSettledInd')

KeywordUtil.logInfo(bureauSettled)

String interestValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.Interest')

KeywordUtil.logInfo(interestValue)

//Verify if the policy status matches the expected value 'Written'
GenericUtils.verifyMatch('Verify Bureau Settled', 'true', bureauSettled, 'EQUAL')

//Verify Placing Type Value
GenericUtils.verifyMatch('Verify Placing Type', 'F', WS.getElementText(response1, 'ResponseWrapper.Policies[0].Detail.PlacingType'), 
    'EQUAL')

String assureds = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Assureds.Organization[0].LegalName')

KeywordUtil.logInfo('Assured value is ::' + assureds)

GenericUtils.verifyMatch('Verify Assured Value is ::', assureds, GlobalVariable.insuredName, 'EQUAL')

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

GenericUtils.verifyMatch('Verify Expiration Date is ::', expirationDate, GlobalVariable.ExpirationDate, 'EQUAL')

String limitValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[0].Limit')

KeywordUtil.logInfo('Limit value is ::' + limitValue)

GenericUtils.verifyMatch('Verify Limit value is ::', limitValue, limitValue, 'EQUAL')

String limitBasis = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[0].LimitBasis')

KeywordUtil.logInfo('Limit Basis Value is ::' + limitBasis)

GenericUtils.verifyMatch('Verify Limit Basis value is ::', limitBasis,limitBasisExpected, 'EQUAL')

String excessLimit = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLimits[0].Xs')

KeywordUtil.logInfo('Excess Limit Value is ::' + excessLimit)

GenericUtils.verifyMatch('Verify Excess Limit value is ::', excessLimit, excessLimitValue, 'EQUAL')

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

String componentType = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyUWInfos[0].ComponentType')

GenericUtils.verifyMatch('Verify Component Type value is ::', componentType, componentTypeExpectedValue, 'EQUAL')

String componentName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyUWInfos[0].ComponentName')

GenericUtils.verifyMatch('Verify Component Name value is ::', componentName, componentNameExpectedValue, 'EQUAL')

String premiumPercent = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyUWInfos[0].PremiumPcnt')

GenericUtils.verifyMatch('Verify Premium Percent value is ::', premiumPercent, premiumPercentExpectedValue, 'EQUAL')

String componentType1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyUWInfos[1].ComponentType')

GenericUtils.verifyMatch('Verify Component Type value is ::', componentType1, componentTypeExpectedValueOne, 'EQUAL')

String componentName1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyUWInfos[1].ComponentName')

GenericUtils.verifyMatch('Verify Component Name value is ::', componentName1, componentNameExpectedValueOne, 'EQUAL')

String premiumPercent1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyUWInfos[1].PremiumPcnt')

GenericUtils.verifyMatch('Verify Premium Percent value is ::', premiumPercent1, premiumPercentExpectedValueOne, 'EQUAL')

String codeValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].RiskCodes[0].CodeValue')

GenericUtils.verifyMatch('Verify Code value is ::', codeValue, codeExpectedValue, 'EQUAL')

String premiumSplit = WS.getElementText(response1, 'ResponseWrapper.Policies[0].RiskCodes[0].PremSplit')

GenericUtils.verifyMatch('Verify Premium Split value is ::', premiumSplit, premiumSplitExpectedValue, 'EQUAL')

String codeValue1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].RiskCodes[1].CodeValue')

GenericUtils.verifyMatch('Verify Code value is ::', codeValue1, codeExpectedValueOne, 'EQUAL')

String premiumSplit1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].RiskCodes[1].PremSplit')

GenericUtils.verifyMatch('Verify Premium Split value is ::', premiumSplit1, premiumSplitExpectedValueOne, 'EQUAL')

String installmentType = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].InstalmentType')

GenericUtils.verifyMatch('Verify Installment Type value is ::', installmentType, installmentTypeExpectedValue, 'EQUAL')

String completed = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].Completed')

GenericUtils.verifyMatch('Verify Completed flag value is ::', completed, completedExpectedValue, 'EQUAL')

String OrigCcyISO = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigCcyISO')

GenericUtils.verifyMatch('Verify Orig Ccy value is ::', OrigCcyISO, origCcyExpectedValue, 'EQUAL')

String OrigGross = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigGross')

GenericUtils.verifyMatch('Verify Orig Gross value is ::', OrigGross, origGrossExpectedValue, 'EQUAL')

String OrigNet = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigNet')

GenericUtils.verifyMatch('Verify Orig Net value is ::', OrigNet, origNetExpectedValue, 'EQUAL')

String PostToLedger = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].PostToLedger')

GenericUtils.verifyMatch('Verify Post To Ledger flag is ::', PostToLedger, postToLedgerExpectedValue, 'EQUAL')

String LedgerAccountID = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].LedgerAccountId')

GenericUtils.verifyMatch('Verify Ledger Account value is ::', LedgerAccountID, ledgerAccountExpectedValue, 'EQUAL')

String installmentType1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].InstalmentType')

GenericUtils.verifyMatch('Verify Installment Type value is ::', installmentType1, installmentTypeExpectedValueOne, 'EQUAL')

String completed1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].Completed')

GenericUtils.verifyMatch('Verify Completed flag value is ::', completed1, completedExpectedValueOne, 'EQUAL')

String OrigCcyISO1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigCcyISO')

GenericUtils.verifyMatch('Verify Orig Ccy value is ::', OrigCcyISO1, origCcyExpectedValueOne, 'EQUAL')

String OrigGross1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigGross')

GenericUtils.verifyMatch('Verify Orig Gross value is ::', OrigGross1, origGrossExpectedValueOne, 'EQUAL')

String OrigNet1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigNet')

GenericUtils.verifyMatch('Verify Orig Net value is ::', OrigNet1, origNetExpectedValueOne, 'EQUAL')

String PostToLedger1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].PostToLedger')

GenericUtils.verifyMatch('Verify Post To Ledger flag is ::', PostToLedger1, postToLedgerExpectedValueOne, 'EQUAL')

String LedgeAccountID1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].LedgerAccountId')

GenericUtils.verifyMatch('Verify Ledger Account value is ::', LedgeAccountID1, ledgerAccountExpectedValueOne, 'EQUAL')
//
String installmentType2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].InstalmentType')

GenericUtils.verifyMatch('Verify Installment Type value is ::', installmentType2, installmentTypeExpectedValueTwo, 'EQUAL')

String completed2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].Completed')

GenericUtils.verifyMatch('Verify Completed flag value is ::', completed2, completedExpectedValueTwo, 'EQUAL')

String OrigCcyISO2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].OrigCcyISO')

GenericUtils.verifyMatch('Verify Orig Ccy value is ::', OrigCcyISO2, origCcyExpectedValueTwo, 'EQUAL')

String OrigGross2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].OrigGross')

GenericUtils.verifyMatch('Verify Orig Gross value is ::', OrigGross2, origGrossExpectedValueTwo, 'EQUAL')

String OrigNet2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].OrigNet')

GenericUtils.verifyMatch('Verify Orig Net value is ::', OrigNet2, origNetExpectedValueTwo, 'EQUAL')

String PostToLedger2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].PostToLedger')

GenericUtils.verifyMatch('Verify Post To Ledger flag is ::', PostToLedger2, postToLedgerExpectedValueTwo, 'EQUAL')

String LedgeAccountID2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].LedgerAccountId')

GenericUtils.verifyMatch('Verify Ledger Account value is ::', LedgeAccountID2, ledgerAccountExpectedValueTwo, 'EQUAL')

String installmentType3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].InstalmentType')

GenericUtils.verifyMatch('Verify Installment Type value is ::', installmentType3, installmentTypeExpectedValueThree, 'EQUAL')

String completed3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].Completed')

GenericUtils.verifyMatch('Verify Completed flag value is ::', completed3, completedExpectedValueThree, 'EQUAL')

String OrigCcyISO3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].OrigCcyISO')

GenericUtils.verifyMatch('Verify Orig Ccy value is ::', OrigCcyISO3, origCcyExpectedValueThree, 'EQUAL')

String OrigGross3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].OrigGross')

GenericUtils.verifyMatch('Verify Orig Gross value is ::', OrigGross3, origGrossExpectedValueThree, 'EQUAL')

String OrigNet3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].OrigNet')

GenericUtils.verifyMatch('Verify Orig Net value is ::', OrigNet3, origNetExpectedValueThree, 'EQUAL')

String PostToLedger3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].PostToLedger')

GenericUtils.verifyMatch('Verify Post To Ledger flag is ::', PostToLedger3, postToLedgerExpectedValueThree, 'EQUAL')

String LedgeAccountID3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].LedgerAccountId')

GenericUtils.verifyMatch('Verify Ledger Account value is ::', LedgeAccountID3, ledgerAccountExpectedValueThree, 'EQUAL')

String installmentType4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].InstalmentType')

GenericUtils.verifyMatch('Verify Installment Type value is ::', installmentType4, installmentTypeExpectedValueFour, 'EQUAL')

String completed4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].Completed')

GenericUtils.verifyMatch('Verify Completed flag value is ::', completed4, completedExpectedValueFour, 'EQUAL')

String OrigCcyISO4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].OrigCcyISO')

GenericUtils.verifyMatch('Verify Orig Ccy value is ::', OrigCcyISO4, origCcyExpectedValueFour, 'EQUAL')

String OrigGross4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].OrigGross')

GenericUtils.verifyMatch('Verify Orig Gross value is ::', OrigGross4, origGrossExpectedValueFour, 'EQUAL')

String OrigNet4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].OrigNet')

GenericUtils.verifyMatch('Verify Orig Net value is ::', OrigNet4, origNetExpectedValueFour, 'EQUAL')

String PostToLedger4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].PostToLedger')

GenericUtils.verifyMatch('Verify Post To Ledger flag is ::', PostToLedger4, postToLedgerExpectedValueFour, 'EQUAL')

String LedgeAccountID4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].LedgerAccountId')

GenericUtils.verifyMatch('Verify Ledger Account value is ::', LedgeAccountID4, ledgerAccountExpectedValueFour, 'EQUAL')

String installmentType5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].InstalmentType')

GenericUtils.verifyMatch('Verify Installment Type value is ::', installmentType5, installmentTypeExpectedValueFive, 'EQUAL')

String completed5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].Completed')

GenericUtils.verifyMatch('Verify Completed flag value is ::', completed5, completedExpectedValueFive, 'EQUAL')

String OrigCcyISO5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].OrigCcyISO')

GenericUtils.verifyMatch('Verify Orig Ccy value is ::', OrigCcyISO5, origCcyExpectedValueFive, 'EQUAL')

String OrigGross5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].OrigGross')

GenericUtils.verifyMatch('Verify Orig Gross value is ::', OrigGross5, origGrossExpectedValueFive, 'EQUAL')

String OrigNet5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].OrigNet')

GenericUtils.verifyMatch('Verify Orig Net value is ::', OrigNet5, origNetExpectedValueFive, 'EQUAL')

String PostToLedger5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].PostToLedger')

GenericUtils.verifyMatch('Verify Post To Ledger flag is ::', PostToLedger5, postToLedgerExpectedValueFive, 'EQUAL')

String LedgeAccountID5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].LedgerAccountId')

GenericUtils.verifyMatch('Verify Ledger Account value is ::', LedgeAccountID5, ledgerAccountExpectedValueFive, 'EQUAL')

String producingTeam = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].ProducingTeam')

GenericUtils.verifyMatch('Verify Producing team value is ::', producingTeam, producingTeamValue, 'EQUAL')

String lineStatus = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].LineStatus')

GenericUtils.verifyMatch('Verify Line Status value is ::', lineStatus, lineStatusExpectedValue, 'EQUAL')

String entityName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].Synd')

KeywordUtil.logInfo(entityName)

GenericUtils.verifyMatch('Verify Entity Name value is ::', entityName, entityNameExpectedValue, 'EQUAL')

String writtenOrder = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].WrittenOrder')

GenericUtils.verifyMatch('Verify Written Order value is ::', writtenOrder, writtenOrderExpectedValue, 'EQUAL')

String writtenLine = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyLines[0].WrittenLine')

GenericUtils.verifyMatch('Verify Written Line value is ::', writtenLine, writtenLineExpectedValue, 'EQUAL')

String brokerName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Placers[0].BrokerName')


String brokerContactName = WS.getElementText(response1, 'ResponseWrapper.Policies[0].Placers[0].ContactName')


//Deductions 
String deductionsValue = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyDeductions[0].DeductionValue')

GenericUtils.verifyMatch('Verify Deductions value is ::', deductionsValue, deductionExpectedValue, 'EQUAL')

String deductionsIndicator = WS.getElementText(response1, 'ResponseWrapper.Policies[0].PolicyDeductions[0].DeductionInd')

GenericUtils.verifyMatch('Verify Deductions Indicator value is ::', deductionsIndicator, deductionsIndicaorExpectedValue, 'EQUAL')

//PolicySettlement

String level = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].Level')

GenericUtils.verifyMatch('Verify Level value is ::', level, levelExpectedValue, 'EQUAL')

String settlementType = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].Type')

GenericUtils.verifyMatch('Verify Settlement Type value is ::', settlementType, settlementTypeExpectedValue, 'EQUAL')

String settlementAdditionIndicator = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].Addition')

GenericUtils.verifyMatch('Verify Settlement Indcator value is ::', settlementAdditionIndicator, settlementIndicatorExpectedValue, 'EQUAL')

String settlementTotalAmount = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].AmtPct')

GenericUtils.verifyMatch('Verify Settlement Amount value is ::', settlementTotalAmount, settlementTotalAmountExpectedValue, 'EQUAL')

String settlementLedgerAccountID = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[0].LedgerAccountId')

GenericUtils.verifyMatch('Settlement Ledger Account ID is ::',settlementLedgerAccountID, settlementLedgerAccountIDExpectedValue , 'EQUAL')

String level1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[1].Level')

GenericUtils.verifyMatch('Verify Level value is ::', level1, levelExpectedValue, 'EQUAL')

String settlementType1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[1].Type')

GenericUtils.verifyMatch('Verify Settlement Type value is ::', settlementType1, settlementTypeExpectedValueOne, 'EQUAL')

String settlementAdditionIndicator1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[1].Addition')

GenericUtils.verifyMatch('Verify Settlement Indicator value is ::', settlementAdditionIndicator1, settlementIndicatorExpectedValueOne, 'EQUAL')

String settlementTotalAmount1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[1].AmtPct')

GenericUtils.verifyMatch('Verify Settlement Amount value is ::', settlementTotalAmount1, settlementTotalAmountExpectedValueOne, 'EQUAL')

String settlementLedgerAccountID1 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[1].LedgerAccountId')

GenericUtils.verifyMatch('Settlement Ledger Account ID is ::',settlementLedgerAccountID1, settlementLedgerAccountIDExpectedValueOne , 'EQUAL')

String level2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[2].Level')

GenericUtils.verifyMatch('Verify Level value is ::', level2, levelExpectedValue, 'EQUAL')

String settlementType2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[2].Type')

GenericUtils.verifyMatch('Verify Settlement Type value is ::', settlementType2, settlementTypeExpectedValueTwo, 'EQUAL')

String settlementAdditionIndicator2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[2].Addition')

GenericUtils.verifyMatch('Verify Settlement Indcator value is ::', settlementAdditionIndicator2, settlementIndicatorExpectedValueTwo, 'EQUAL')

String settlementTotalAmount2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[2].AmtPct')

GenericUtils.verifyMatch('Verify Settlement Amount value is ::', settlementTotalAmount2, settlementTotalAmountExpectedValueTwo, 'EQUAL')

String settlementLedgerAccountID2 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].SettlementSchedMarketDeductions[2].LedgerAccountId')

GenericUtils.verifyMatch('Settlement Ledger Account ID is ::',settlementLedgerAccountID2, settlementLedgerAccountIDExpectedValueTwo , 'EQUAL')

String level3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].SettlementSchedMarketDeductions[0].Level')

GenericUtils.verifyMatch('Verify Level value is ::', level3, levelExpectedValue, 'EQUAL')

String settlementType3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].SettlementSchedMarketDeductions[0].Type')

GenericUtils.verifyMatch('Verify Settlement Type value is ::', settlementType3, settlementTypeExpectedValueThree, 'EQUAL')

String settlementAdditionIndicator3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].SettlementSchedMarketDeductions[0].Addition')

GenericUtils.verifyMatch('Verify Settlement Indcator value is ::', settlementAdditionIndicator3, settlementIndicatorExpectedValueThree, 'EQUAL')

String settlementTotalAmount3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].SettlementSchedMarketDeductions[0].AmtPct')

GenericUtils.verifyMatch('Verify Settlement Amount value is ::', settlementTotalAmount3, settlementTotalAmountExpectedValueThree, 'EQUAL')

String settlementLedgerAccountID3 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].SettlementSchedMarketDeductions[0].LedgerAccountId')

GenericUtils.verifyMatch('Settlement Ledger Account ID is ::',settlementLedgerAccountID3, settlementLedgerAccountIDExpectedValueThree , 'EQUAL')

String level4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].SettlementSchedMarketDeductions[0].Level')

GenericUtils.verifyMatch('Verify Level value is ::', level4, levelExpectedValue, 'EQUAL')

String settlementType4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].SettlementSchedMarketDeductions[0].Type')

GenericUtils.verifyMatch('Verify Settlement Type value is ::', settlementType4, settlementTypeExpectedValueFour, 'EQUAL')

String settlementAdditionIndicator4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].SettlementSchedMarketDeductions[0].Addition')

GenericUtils.verifyMatch('Verify Settlement Indcator value is ::', settlementAdditionIndicator4, settlementIndicatorExpectedValueFour, 'EQUAL')

String settlementTotalAmount4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].SettlementSchedMarketDeductions[0].AmtPct')

GenericUtils.verifyMatch('Verify Settlement Amount value is ::', settlementTotalAmount4, settlementTotalAmountExpectedValueFour, 'EQUAL')

String settlementLedgerAccountID4 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].SettlementSchedMarketDeductions[0].LedgerAccountId')

GenericUtils.verifyMatch('Settlement Ledger Account ID is ::',settlementLedgerAccountID4, settlementLedgerAccountIDExpectedValueFour , 'EQUAL')

String level5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[0].Level')

GenericUtils.verifyMatch('Verify Level value is ::', level5, levelExpectedValue, 'EQUAL')

String settlementType5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[0].Type')

GenericUtils.verifyMatch('Verify Settlement Type value is ::', settlementType5, settlementTypeExpectedValueFive, 'EQUAL')

String settlementAdditionIndicator5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[0].Addition')

GenericUtils.verifyMatch('Verify Settlement Indcator value is ::', settlementAdditionIndicator5, settlementIndicatorExpectedValueFive, 'EQUAL')

String settlementTotalAmount5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[0].AmtPct')

GenericUtils.verifyMatch('Verify Settlement Amount value is ::', settlementTotalAmount5, settlementTotalAmountExpectedValueFive, 'EQUAL')

String settlementLedgerAccountID5 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[0].LedgerAccountId')

GenericUtils.verifyMatch('Settlement Ledger Account ID is ::',settlementLedgerAccountID5, settlementLedgerAccountIDExpectedValueFive , 'EQUAL')

String level6 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[1].Level')

GenericUtils.verifyMatch('Verify Level value is ::', level6, levelExpectedValue, 'EQUAL')

String settlementType6 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[1].Type')

GenericUtils.verifyMatch('Verify Settlement Type value is ::', settlementType6, settlementTypeExpectedValueSix, 'EQUAL')

String settlementAdditionIndicator6 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[1].Addition')

GenericUtils.verifyMatch('Verify Settlement Indcator value is ::', settlementAdditionIndicator6, settlementIndicatorExpectedValueSix, 'EQUAL')

String settlementTotalAmount6 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[1].AmtPct')

GenericUtils.verifyMatch('Verify Settlement Amount value is ::', settlementTotalAmount6, settlementTotalAmountExpectedValueSix, 'EQUAL')

String settlementLedgerAccountID6 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[1].LedgerAccountId')

GenericUtils.verifyMatch('Settlement Ledger Account ID is ::',settlementLedgerAccountID6, settlementLedgerAccountIDExpectedValueSix , 'EQUAL')

String level7 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[2].Level')

GenericUtils.verifyMatch('Verify Level value is ::', level6, levelExpectedValue, 'EQUAL')

String settlementType7 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[2].Type')

GenericUtils.verifyMatch('Verify Settlement Type value is ::', settlementType7, settlementTypeExpectedValueSeven, 'EQUAL')

String settlementAdditionIndicator7 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[2].Addition')

GenericUtils.verifyMatch('Verify Settlement Indcator value is ::', settlementAdditionIndicator7, settlementIndicatorExpectedValueSeven, 'EQUAL')

String settlementTotalAmount7 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[2].AmtPct')

GenericUtils.verifyMatch('Verify Settlement Amount value is ::', settlementTotalAmount7, settlementTotalAmountExpectedValueSeven, 'EQUAL')

String settlementLedgerAccountID7 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[3].SettlementSchedMarketDeductions[2].LedgerAccountId')

GenericUtils.verifyMatch('Settlement Ledger Account ID is ::',settlementLedgerAccountID7, settlementLedgerAccountIDExpectedValueSeven , 'EQUAL')

String level8 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].SettlementSchedMarketDeductions[0].Level')

GenericUtils.verifyMatch('Verify Level value is ::', level8, levelExpectedValue, 'EQUAL')

String settlementType8 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].SettlementSchedMarketDeductions[0].Type')

GenericUtils.verifyMatch('Verify Settlement Type value is ::', settlementType8, settlementTypeExpectedValueEight, 'EQUAL')

String settlementAdditionIndicator8 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].SettlementSchedMarketDeductions[0].Addition')

GenericUtils.verifyMatch('Verify Settlement Indcator value is ::', settlementAdditionIndicator8, settlementIndicatorExpectedValueEight, 'EQUAL')

String settlementTotalAmount8 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].SettlementSchedMarketDeductions[0].AmtPct')

GenericUtils.verifyMatch('Verify Settlement Amount value is ::', settlementTotalAmount8, settlementTotalAmountExpectedValueEight, 'EQUAL')

String settlementLedgerAccountID8 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[4].SettlementSchedMarketDeductions[0].LedgerAccountId')

GenericUtils.verifyMatch('Settlement Ledger Account ID is ::',settlementLedgerAccountID8, settlementLedgerAccountIDExpectedValueEight , 'EQUAL')

String level9 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].SettlementSchedMarketDeductions[0].Level')

GenericUtils.verifyMatch('Verify Level value is ::', level9, levelExpectedValue, 'EQUAL')

String settlementType9 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].SettlementSchedMarketDeductions[0].Type')

GenericUtils.verifyMatch('Verify Settlement Type value is ::', settlementType9, settlementTypeExpectedValueNine, 'EQUAL')

String settlementAdditionIndicator9 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].SettlementSchedMarketDeductions[0].Addition')

GenericUtils.verifyMatch('Verify Settlement Indcator value is ::', settlementAdditionIndicator9, settlementIndicatorExpectedValueNine, 'EQUAL')

String settlementTotalAmount9 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].SettlementSchedMarketDeductions[0].AmtPct')

GenericUtils.verifyMatch('Verify Settlement Amount value is ::', settlementTotalAmount9, settlementTotalAmountExpectedValueNine, 'EQUAL')

String settlementLedgerAccountID9 = WS.getElementText(response1, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[5].SettlementSchedMarketDeductions[0].LedgerAccountId')

GenericUtils.verifyMatch('Settlement Ledger Account ID is ::',settlementLedgerAccountID9, settlementLedgerAccountIDExpectedValueNine , 'EQUAL')
