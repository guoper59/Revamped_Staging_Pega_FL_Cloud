/**
 * ============================================================================
 * Test Case ID : 260056
 * Title         : Validate Get Programe Package Response
 * Folder        : Scripts/Endorsements/260056_ValidateGetProgramePackageResponse
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
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import java.text.SimpleDateFormat
import com.kms.katalon.core.testobject.TestObject


String E1Number = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].EndorsementNumber')
KeywordUtil.logInfo(E1Number)

GenericUtils.verifyMatch('Endorsement Number Value is ', E1Number, '1',
	'EQUAL')

String E1Date = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].EffectiveDate')
KeywordUtil.logInfo(E1Date)

SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00", Locale.ENGLISH);

Date date = formatter.parse(E1Date)
KeywordUtil.logInfo(date)

String formattedDate = new SimpleDateFormat('dd/MM/yyyy').format(date)

GenericUtils.verifyMatch('Effective Date Value is ', formattedDate, findTestData(testDataName).getValue('Inception Date', rowNumber),
	'EQUAL')

String E1Status = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].EndorsementStatus')
KeywordUtil.logInfo(E1Status)

GenericUtils.verifyMatch('Endorsement Status Value is ', E1Status, 'Closed',
	'EQUAL')

String E1Type = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].Type')
KeywordUtil.logInfo(E1Type)

GenericUtils.verifyMatch('Endorsement Type Value is ', E1Type, 'RET',
	'EQUAL')

String E1Notes = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[0].Notes')
KeywordUtil.logInfo(E1Notes)

GenericUtils.verifyMatch('Endorsement Notes Value is ', E1Notes, 'Test test test test test test',
	'EQUAL')

String type = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].InstalmentType')
KeywordUtil.logInfo(type)

String originalCurrency = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigCcyISO')
KeywordUtil.logInfo(originalCurrency)

String originalGross = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigGross')
KeywordUtil.logInfo(originalGross)

String originalNet = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].OrigNet')
KeywordUtil.logInfo(originalNet)

String postToLedger = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].PostToLedger')
KeywordUtil.logInfo(postToLedger)

String completed = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[0].Completed')
KeywordUtil.logInfo(completed)

//for 2nd Row
String type2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].InstalmentType')
KeywordUtil.logInfo(type2)

String originalCurrency2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigCcyISO')
KeywordUtil.logInfo(originalCurrency2)

String originalGross2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigGross')
KeywordUtil.logInfo(originalGross2)

String originalNet2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].OrigNet')
KeywordUtil.logInfo(originalNet2)

String postToLedger2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].PostToLedger')
KeywordUtil.logInfo(postToLedger2)

String completed2 = WS.getElementText(response, 'ResponseWrapper.Policies[0].SettlementSchedule.SettlementSchedMarketItems[1].Completed')
KeywordUtil.logInfo(completed2)

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

//Checking response for Endorsement Number 2
String E2Number = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[1].EndorsementNumber')
KeywordUtil.logInfo(E2Number)

GenericUtils.verifyMatch('Endorsement Number Value is ', E2Number, '2',
	'EQUAL')

String EDate02 = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[1].EffectiveDate')
KeywordUtil.logInfo(EDate02)

Date date02 = formatter.parse(EDate02)
KeywordUtil.logInfo(date02)

String formattedDate02 = new SimpleDateFormat('dd/MM/yyyy').format(date02)

GenericUtils.verifyMatch('Effective Date Value is ', formattedDate02, findTestData(testDataName).getValue('Inception Date', rowNumber),
	'EQUAL')

String E2Status = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[1].EndorsementStatus')
KeywordUtil.logInfo(E2Status)

GenericUtils.verifyMatch('Endorsement Status Value is ', E2Status, 'Closed',
	'EQUAL')

String E2Type = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[1].Type')
KeywordUtil.logInfo(E2Type)

GenericUtils.verifyMatch('Endorsement Type Value is ', E2Type, 'RET',
	'EQUAL')

String E2Notes = WS.getElementText(response, 'ResponseWrapper.Policies[0].PolicyEndorsementList[1].Notes')
KeywordUtil.logInfo(E2Notes)

GenericUtils.verifyMatch('Endorsement Notes Value is ', E2Notes, 'Test test test test test test',
	'EQUAL')

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