/**
 * ============================================================================
 * Test Case ID : 300727
 * Title         : Validate Endorsement Details
 * Folder        : Scripts/TestData/300727_ValidateEndorsementDetails
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

import java.text.SimpleDateFormat

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.genericutils.helper.GenericUtils
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.submission.helper.SubmissionHelper

import internal.GlobalVariable as GlobalVariable

String testData = 'Endorsements'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

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

GenericUtils.verifyMatch('Verify Effective Date is ::', effectiveDate, findTestData(testData).getValue('Inception Date',
		rowNumber), 'EQUAL')
 
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

//verify settlement schedule details
//verify first row
String type = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].InstalmentType')
 
WebUI.comment(type)
KeywordUtil.logInfo('Instalment Type value is ::' + type)

String originalCurrency = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigCcyISO')
 
WebUI.comment(originalCurrency)
KeywordUtil.logInfo('original Currency value is ::' + originalCurrency)
 
String originalGross = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigGross')
 
WebUI.comment(originalGross)
KeywordUtil.logInfo('original Gross value is ::' + originalGross)
 
String originalNet = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigNet')
 
WebUI.comment(originalNet)
KeywordUtil.logInfo('original Net value is ::' + originalNet)

String postToLedger = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].PostToLedger')
 
WebUI.comment(postToLedger)
KeywordUtil.logInfo('post To Ledger value is ::' + postToLedger)

String completed = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].Completed')

WebUI.comment(completed)
KeywordUtil.logInfo('completed value is ::' + completed)
 
String ledgerAccount = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].LedgerAccountId')

WebUI.comment(ledgerAccount)
KeywordUtil.logInfo('ledger Account value is ::' + ledgerAccount)

//for 2nd Row

String type2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].InstalmentType')
 
WebUI.comment(type2)
KeywordUtil.logInfo('Instalment Type2 value is ::' + type2)
 
String originalCurrency2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigCcyISO')
 
WebUI.comment(originalCurrency2)
KeywordUtil.logInfo('original Currency2 value is ::' + originalCurrency2)
  
String originalGross2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigGross')
 
WebUI.comment(originalGross2)
KeywordUtil.logInfo('original Gross2 value is ::' + originalGross2)
 
String originalNet2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigNet')
 
WebUI.comment(originalNet2)
KeywordUtil.logInfo('original Net2 value is ::' + originalNet2)
 
String postToLedger2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].PostToLedger')
 
WebUI.comment(postToLedger2)
KeywordUtil.logInfo('post To Ledger2 value is ::' + postToLedger2)
 
String completed2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].Completed')
 
WebUI.comment(completed2)
KeywordUtil.logInfo('completed2 value is ::' + completed2)

String ledgerAccount2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].LedgerAccountId')

WebUI.comment(ledgerAccount2)
KeywordUtil.logInfo('ledger Account2 value is ::' + ledgerAccount2)


//In the General Section, check the following information:
String bureauSettled = WS.getElementText(response, 'ResponseWrapper.Policies[0].Detail.BureauSettledInd')

KeywordUtil.logInfo('Bureau Settled ::' + bureauSettled)

String interestValue = WS.getElementText(response, 'ResponseWrapper.Policies[0].Detail.Interest')

KeywordUtil.logInfo('Interest Value is ::' + interestValue)

String placingBasis = WS.getElementText(response, 'ResponseWrapper.Policies[0].Detail.PlacingType')

KeywordUtil.logInfo('Placing Basis Value is ::' + placingBasis)


String assureds = WS.getElementText(response, 'ResponseWrapper.Policies[0].Assureds.Organization[0].LegalName')

KeywordUtil.logInfo('Assured value is ::' + assureds)

String inceptionDateFormat1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].Detail.InceptionDate')

KeywordUtil.logInfo('Inception Date value is ::' + inceptionDateFormat1)

Date date1 = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss').parse(inceptionDateFormat1)

String inceptionDate1 = new SimpleDateFormat('dd/MM/yyyy').format(date1)

KeywordUtil.logInfo('Inception Date value is ::' + inceptionDate1)

String expiryDateFormat1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].Detail.ExpiryDate')

KeywordUtil.logInfo('Expiry Date value is ::' + expiryDateFormat1)

Date date2 = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss').parse(expiryDateFormat1)

String expirationDate1 = new SimpleDateFormat('dd/MM/yyyy').format(date2)

KeywordUtil.logInfo('Expiration Date value is ::' + expirationDate1)

String mainClass1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].Detail.Class4')

KeywordUtil.logInfo('Main Class Value is ::' + mainClass1)

String majorClassName1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].Detail.Class1')

KeywordUtil.logInfo('Major Class Value is ::' + majorClassName1)

String minorClassName1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].Detail.Class2')

KeywordUtil.logInfo('Minor Class Value is ::' + minorClassName1)

String class1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].Detail.Class3')

KeywordUtil.logInfo('Class Value is ::' + class1)

String policyPremium1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyPremiums[0].PolicyPremIncome')

KeywordUtil.logInfo('Policy Premium Value is ::' + policyPremium1)

String originalCurrency1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyPremiums[0].PremCcyISO')

KeywordUtil.logInfo('Original Currency Value is ::' + originalCurrency1)

String producingTeam1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyLines[0].ProducingTeam')

KeywordUtil.logInfo('Producing Team Value is ::' + producingTeam1)

String lineStatus1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyLines[0].LineStatus')

KeywordUtil.logInfo('Line Status Value is ::' + lineStatus1)

String signedOrder1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyLines[0].WrittenOrder')

KeywordUtil.logInfo('Signed Order Value is ::' + signedOrder1)

String signedLine1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyLines[0].WrittenLine')

KeywordUtil.logInfo('Signed Line Value is ::' + signedLine1)

String leaderName1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].CompanyLeaders.Organization[0].LegalName')

KeywordUtil.logInfo('Leader Name Value is ::' + leaderName1)

String brokerName1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].Placers[0].BrokerName')

KeywordUtil.logInfo('Broker Name Value is ::' + brokerName1)

String brokerContactName1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].Placers[0].ContactName')

KeywordUtil.logInfo('Broker Contact Name Value is ::' + brokerContactName1)

//validate 2nd Endorsement values
//Checking response for Endorsement Number 2
String E2Number = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[1].EndorsementNumber')
KeywordUtil.logInfo(E2Number)

WebUI.comment(E2Number)


String EDate02 = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[1].EffectiveDate')
KeywordUtil.logInfo(EDate02)

Date date02 = new SimpleDateFormat('yyyy-MM-dd\'T\'HH:mm:ss').parse(EDate02)
KeywordUtil.logInfo(date02)

String formattedDate02 = new SimpleDateFormat('dd/MM/yyyy').format(date02)

WebUI.comment(formattedDate02)

String E2Status = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[1].EndorsementStatus')
KeywordUtil.logInfo(E2Status)

WebUI.comment(E2Status)

String E2Type = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[1].Type')
KeywordUtil.logInfo(E2Type)

WebUI.comment(E2Type)

String E2Notes = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[1].Notes')
KeywordUtil.logInfo(E2Notes)
WebUI.comment(E2Notes)


//for 2nd Row
String type3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].InstalmentType')
KeywordUtil.logInfo(type3)

String originalCurrency3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].OrigCcyISO')
KeywordUtil.logInfo(originalCurrency3)

String originalGross3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].OrigGross')
KeywordUtil.logInfo(originalGross3)

String originalNet3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].OrigNet')
KeywordUtil.logInfo(originalNet3)

String postToLedger3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].PostToLedger')
KeywordUtil.logInfo(postToLedger3)

String completed3 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[2].Completed')
KeywordUtil.logInfo(completed3)
