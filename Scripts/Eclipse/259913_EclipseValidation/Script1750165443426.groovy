/**
 * ============================================================================
 * Test Case ID : 259913
 * Title         : Eclipse Validation
 * Folder        : Scripts/Eclipse/259913_EclipseValidation
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

String testData = 'Endorsements'

//Finding Row number from Test Data.
int rowNumber = common.FileUtils.findRowNumber('Data Files/' + testData, GlobalVariable.testCaseID)

//Calling Get API to validate response---SBS ECLIPSE
ResponseObject response = WS.callTestCase(findTestCase('Test Cases/Eclipse/GetProgramPackage'), null)

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

String brokerName1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].Placers[0].BrokerName')

KeywordUtil.logInfo('Broker Name Value is ::' + brokerName1)

String brokerContactName1 = WS.getElementText(response, 'ResponseWrapper.Policies[0].Placers[0].ContactName')

KeywordUtil.logInfo('Broker Contact Name Value is ::' + brokerContactName1)
