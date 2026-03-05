package com.genericutils.helper

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat

import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.entity.global.GlobalVariableEntity
import internal.GlobalVariable as GlobalVariable
import java.util.UUID


public class GenericUtils {

	public static clickWhenReady(TestObject testObject, int timeout = 20) {
		WebUI.waitForElementClickable(testObject, timeout)

		boolean clicked = false
		int waited = 0
		while (!clicked && waited < timeout) {
			try {
				WebUI.click(testObject)
				clicked = true
			} catch (Exception e) {
				Thread.sleep(1000)
				waited++
			}
		}

		if (!clicked) {
			throw new Exception("Failed to click element after ${timeout} seconds: " + testObject.getObjectId())
		}
	}

	/**
	 * To verify if the button is disabled or not
	 */
	public static verifyButtonIsDisabled(TestObject object) {
		try {
			WebUI.scrollToElement(object, 10)
			WebUI.waitForElementPresent(object, 20)

			if(WebUI.verifyElementHasAttribute(object, 'disabled', 10)) {

				KeywordUtil.markPassed("Button is disabled")
			}
			else {

				//KeywordUtil.markFailedAndStop("Button is enabled")
			}
		} catch (Exception e) {
			WebUI.comment("Exception :: " + e.getMessage())
			WebUI.takeScreenshot()
			//KeywordUtil.markFailedAndStop("Exception while verifying if the button is disabled");
		}
	}


	/**
	 * Wait for element to be clickable and click
	 * @param element - TestObject for element to wait for and perform click
	 */
	public static waitForElementAndClick(TestObject element) {
		try {

			WebUI.waitForElementVisible(element, 25)
			WebUI.waitForElementClickable(element, 25)

			WebUI.click(element)

			KeywordUtil.logInfo("Click performed successfully on :: " + element)
		} catch (Exception e) {
			WebUI.comment("Exception :: " + e.getMessage())
			WebUI.takeScreenshot()
			//KeywordUtil.markFailedAndStop("Unable to click on :: " + element);
		}
	}

	/**
	 * Get text of webElement in webElementList, sort it and return sorted array list of Strings.
	 * @webEementsListTestObject - Test object of WebElements List
	 * @sortingOrder - ASC/DESC/NONE (ascending or descending order)
	 */
	public static List<String> convertWebElementsListToStringListAndSort(TestObject webElementsListTestObject, String sortingOrder) {
		try {
			List<WebElement> webElementList = WebUI.findWebElements(webElementsListTestObject,10)

			List<WebElement> webElementStringList = new ArrayList<String>()

			WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget0Ifr'), 10)

			for (WebElement webElement : webElementList) {

				webElementStringList.add(webElement.getText().trim())
			}

			switch(sortingOrder) {
				case 'ASC':
					KeywordUtil.logInfo('Sorting List in Ascending order.')
					Collections.sort(webElementStringList)
					break;

				case 'DESC':
					KeywordUtil.logInfo('List of Dates before Sorting'+webElementStringList)
					KeywordUtil.logInfo('Verifying Results are displayed from Newest to oldest')
					Collections.reverse(webElementStringList)
					break;

				case 'NONE':
					KeywordUtil.logInfo('No sorting needed.')
					break;

				default:
					//KeywordUtil.markFailedAndStop('Incorrect Sorting Order Option :'+sortingOrder)
					break;
			}
			return webElementStringList
		}catch (Exception e) {
			WebUI.comment("Exception :: " + e.getMessage());
			WebUI.takeScreenshot()
			//KeywordUtil.markFailedAndStop("Exception while converting webElementList to sorted arraylist of Strings");
		}
	}

	/**
	 * Compare actual and expected Lists
	 * @expectedList - Expected List object
	 * @actualList - Actual List object
	 */
	public static void compareLists(List<String> expectedList, List<String> actualList) {
		try {

			boolean isEqual;
			String differences = ""; // Initialize empty string

			if (expectedList.equals(actualList)) {
				isEqual=true;
			}  else if(expectedList.size()!=actualList.size())  {
				isEqual = false;
				differences +='Size of Actual and Expected list is not equal :: Actual List : '+expectedList+' | Expected List : '+actualList
			}else {
				isEqual = false;
				for (int i = 0; i < expectedList.size(); i++) {
					if (!expectedList.get(i).equals(actualList.get(i))) {
						differences += "Value mismatch for index :: " + i + " | Actual Value : "+actualList.get(i)+" | Expected Value : " +expectedList.get(i)+"\n";
					}
				}
			}
			// Print result
			if (isEqual) {
				KeywordUtil.markPassed("Lists are equal :: \nActual List : " +actualList+ "\nExpected List : " +expectedList)
			} else {
				//KeywordUtil.markFailedAndStop('Lists are not equal :: '+'\n' +differences)
			}
		}catch (Exception e) {
			WebUI.comment("Exception :: " + e.getMessage());
			//KeywordUtil.markFailedAndStop("Exception while comparing actual and expected Lists");
		}
	}



	/**
	 * Get current time stamp in "MMddyyyy_HHmmss" format
	 * @return current time stamp
	 *
	 */
	public static String getCurrentTimestamp() {
		try {
			String timestamp = new SimpleDateFormat('MMddyyyy_HHmmss').format(new Date());
			return "${timestamp}_${UUID.randomUUID().toString()}";
		}catch (Exception e) {
			WebUI.comment("Exception :: " + e.getMessage());
			//KeywordUtil.markFailedAndStop("Exception while getting current time stamp");
		}
	}


	/**
	 * Click in the input box, then Clear and Enter the text in the input text box.
	 * @inputBoxTestObject - TestObject for Input Text Box
	 * @dataToEnter - Text to be entered in Input Text Box
	 */
	public static void clearAndSendKeys(TestObject inputBoxTestObject, String dataToEnter) {
		try {
			GenericUtils.waitForElementAndClick(inputBoxTestObject)

			WebUI.sendKeys(inputBoxTestObject, dataToEnter)
		}catch (Exception e) {
			WebUI.takeScreenshot()
			WebUI.comment("Exception :: " + e.getMessage());
			//KeywordUtil.markFailedAndStop("Exception while clear text and Send Keys in the Text Box.");
		}
	}



	/**
	 * Get current date in "MM-dd-yyyy" format
	 * @return current date
	 *
	 */
	public static String getCurrentDate() {
		try{
			String currentDate = new SimpleDateFormat('MM-dd-yyyy').format(Calendar.getInstance().time)
			return currentDate;
		}catch (Exception e) {
			WebUI.comment("Exception :: " + e.getMessage());
			//KeywordUtil.markFailedAndStop("Exception while getting current date");
		}
	}

	/**
	 * Compare actual and expected string value based on condition
	 * @logMessage - Log Message - Example : 'Verify cell value'
	 * @actualValue - Actual value
	 * @expectedValue - Expected Value
	 * @valCondition - EQUAL/NOT EQUAL/CONTAINS
	 */
	public static boolean verifyMatch(String logMessage, String actualValue, String expectedValue, String valCondition) {
		try {
			boolean flagResult=false
			switch(valCondition) {
				case 'EQUAL':
					if(actualValue.equalsIgnoreCase(expectedValue)) {
						flagResult=true
					}
					break;
				case 'NOT EQUAL':
					if(!actualValue.equals(expectedValue)) {
						flagResult=true
					}
					break;
				case 'CONTAINS':
					if(actualValue.contains(expectedValue)) {
						flagResult=true
					}
					break;
				default:
					//KeywordUtil.markFailedAndStop('Incorrect :: '+ valCondition)
					break;
			}
			if(flagResult) {
				KeywordUtil.markPassed('PASS : '+logMessage+' | Comparison type : ' +valCondition+' | Actual Value : '+actualValue+' || Expected Value : '+expectedValue);
			}
			else {
				//KeywordUtil.markFailedAndStop('FAIL : '+logMessage+' | Comparison type : ' +valCondition+' | Actual Value : '+actualValue+' || Expected Value : '+expectedValue);
			}
			return flagResult
		}
		catch (Exception e) {
			WebUI.comment("Exception :: " + e.getMessage());
			WebUI.takeScreenshot()
			//KeywordUtil.markFailedAndStop("Exception while comparing actual and expected value");
		}
	}

	/**
	 * Compare actual and expected integer value based on condition
	 * @logMessage - Log Message - Example : 'Verify row count after deleting rows from table'
	 * @actualValue - Actual value
	 * @expectedValue - Expected Value
	 * @valCondition - EQUAL/NOT EQUAL/GREATER THAN/LESS THAN
	 */
	public static boolean verifyMatch(String logMessage, int actualValue, int expectedValue, String valCondition) {
		try {
			boolean flagResult=false
			switch(valCondition) {
				case 'EQUAL':
					if(actualValue==expectedValue) {
						flagResult=true
					}
					break;
				case 'NOT EQUAL':
					if(actualValue!=expectedValue) {
						flagResult=true
					}
					break;
				case 'GREATER THAN':
					if(actualValue>expectedValue) {
						flagResult=true
					}
					break;
				case 'LESS THAN':
					if(actualValue<expectedValue) {
						flagResult=true
					}
					break;
				default:
					//KeywordUtil.markFailedAndStop('Incorrect :: '+ valCondition)
					break;
			}
			if(flagResult) {
				KeywordUtil.markPassed('PASS : '+logMessage+' | Comparison type : ' +valCondition+' | Actual Value : '+actualValue+' || Expected Value : '+expectedValue);
			}
			else {
				//KeywordUtil.markFailedAndStop('FAIL : '+logMessage+' | Comparison type : ' +valCondition+' | Actual Value : '+actualValue+' || Expected Value : '+expectedValue);
			}
			return flagResult
		}
		catch (Exception e) {
			WebUI.comment("Exception :: " + e.getMessage());
			WebUI.takeScreenshot()
			//KeywordUtil.markFailedAndStop("Exception while comparing actual and expected value");
		}
	}

	/**
	 * Get element existence on UI
	 * @testObject - test object to be used
	 */
	@Keyword(keywordObject = "Common")
	public static boolean getElementExistence(TestObject testObject) {
		try {
			boolean flagElementPresent=false
			WebDriver driver= DriverFactory.getWebDriver()
			String xpath=testObject.getSelectorCollection()[SelectorMethod.XPATH]
			List<WebElement> isElementPresent=driver.findElements(By.xpath(xpath))

			if(isElementPresent.size()>0) {
				KeywordUtil.logInfo('Element is present')
				flagElementPresent=true
			}
			else {
				KeywordUtil.logInfo('Element is not present')
				flagElementPresent=false
			}
			return flagElementPresent
		}catch (Exception e) {
			WebUI.comment("Exception :: " + e.getMessage());
			WebUI.takeScreenshot()
			//KeywordUtil.markFailedAndStop("Exception while fetching element existence on UI");
		}
	}


	@Keyword
	public static waitforElementAndClick1(TestObject testObject, TestObject frameTestObject) {
		try {
			WebDriver driver = DriverFactory.getWebDriver()
			String xpath = testObject.getSelectorCollection()[SelectorMethod.XPATH]
			// Switch to the iframe
			WebUI.switchToFrame(frameTestObject, 10)  // No need to call findTestObject here
			// Find the element by XPath
			WebElement element = driver.findElement(By.xpath(xpath))
			// Wait for the element to become refreshed/stable
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
			// Click the element
			element.click()
		} catch (Exception e) {
			WebUI.comment("Exception :: " + e.getMessage())
			//KeywordUtil.markFailedAndStop("Exception while clicking on the element")
		}
	}

	@Keyword
	//Keyword to select date from calendar whereas date format is 01/05/2023 but expected Format is May 01st , 2023
	/*
	 *  Selects a date from a calendar and converts it to the format "Month Dayst, Year".
	 *
	 *  1. Splits the input date into day, month, and year parts.
	 *  2. Converts the numeric month to its corresponding three-letter abbreviation.
	 *  3. Clicks on the input month, clears it, and sends the converted month.
	 *  4. Clicks on the input year and sends the year.
	 *  5. Clicks on the specific day in the calendar.
	 *
	 */
	public static SelectDatefromCalendar(String inputDate, TestObject inputMonth,TestObject Year) {
		try {
			//Convert the selected date to the expected format "May 01st, 2023"
			String[] dateParts = inputDate.split('/')
			String month = dateParts[1]
			String day = dateParts[0]
			String year = dateParts[2]
			WebUI.waitForElementVisible(Year, 25)
			switch (month) {
				case '01':
					month = 'Jan'
					WebUI.delay(2)
					clearAndSendKeys(inputMonth,month)
					break
				case '02':
					month = 'Feb'
					WebUI.delay(2)
					clearAndSendKeys(inputMonth,month)
					break
				case '03':
					month = 'Mar'
					WebUI.delay(2)
					clearAndSendKeys(inputMonth,month)
					break
				case '04':
					month = 'Apr'
					WebUI.delay(2)
					clearAndSendKeys(inputMonth,month)
					break
				case '05':
					month = 'May'
					WebUI.delay(2)
					clearAndSendKeys(inputMonth,month)
					break
				case '06':
					month = 'Jun'
					WebUI.delay(2)
					clearAndSendKeys(inputMonth,month)
					break
				case '07':
					month = 'Jul'
					WebUI.delay(2)
					clearAndSendKeys(inputMonth,month)
					break
				case '08':
					month = 'Aug'
					WebUI.delay(2)
					clearAndSendKeys(inputMonth,month)
					break
				case '09':
					month = 'Sep'
					WebUI.delay(2)
					clearAndSendKeys(inputMonth,month)
					break
				case '10':
					month = 'Oct'
					WebUI.delay(2)
					clearAndSendKeys(inputMonth,month)
					break
				case '11':
					month = 'Nov'
					WebUI.delay(2)
					clearAndSendKeys(inputMonth,month)
					break
				case '12':
					month = 'Dec'
					WebUI.delay(2)
					clearAndSendKeys(inputMonth,month)
					break
			}
			WebUI.click(Year)
			WebUI.delay(5)
			clearAndSendKeys(Year,year)
			WebUI.delay(5)
			WebUI.waitForElementVisible(Year,25)

			if(Integer.parseInt(day)>0 && Integer.parseInt(day)<10) {
				day=day.replace('0','')
			}
			WebUI.delay(5)
			WebUI.waitForElementClickable(findTestObject('Object Repository/Page_Reports/input_Day',[('date'):day]), 25)
			WebUI.scrollToElement(findTestObject('Object Repository/Page_Reports/input_Day',[('date'):day]), 25)
			WebUI.click(findTestObject('Object Repository/Page_Reports/input_Day',[('date'):day]))
			WebUI.comment(day)
		}
		catch (Exception e) {
			WebUI.comment("Exception :: " + e.getMessage())
			//KeywordUtil.markFailedAndStop("Exception while clicking on the element")
		}
	}

	/**
	 * Filter Web Table column by value
	 * @param filterColumnName - Web Table column to filter
	 * @param inputValue - Value to Filter the column
	 */
	@Keyword
	public static void filterColumnByValue(String filterColumnName, String inputValue) {
		try {
			WebUI.takeScreenshotAsCheckpoint('Quote Reference')
			WebUI.delay(GlobalVariable.timeoutShort)
			GenericUtils.waitForElementAndClick(findTestObject('Object Repository/Dashboards/webElement_DynamicFilter', [('columnToSelect') : filterColumnName]))
			//GenericUtils.waitForElementAndClick(findTestObject('Object Repository/Page_Underwriter/linkClear'))
			WebUI.delay(GlobalVariable.timeoutShort)
			GenericUtils.waitForElementAndClick(findTestObject('Object Repository/Page_Underwriter/inputBoxSearch'))
			WebUI.delay(GlobalVariable.timeoutShort)
			WebUI.sendKeys(findTestObject('Object Repository/Page_Underwriter/inputBoxSearch'), inputValue)
			WebUI.delay(GlobalVariable.timeoutShort)
			GenericUtils.waitForElementAndClick(findTestObject("Object Repository/Page_Underwriter/button_Apply"))
			WebUI.delay(GlobalVariable.timeOutValue)
		}
		catch (Exception e) {
			WebUI.takeScreenshot()
			WebUI.comment("Exception :: " + e.getMessage())
			//KeywordUtil.markFailedAndStop("Exception while filter the Web Table column");
		}
	}
	/**
	 * Close window pop-up
	 * Note: To be used after the download button
	 */
	public static void closeWindow() {
		try {
			// Switch to the pop-up window
			WebUI.switchToWindowIndex(1)
			KeywordUtil.logInfo('Switched to the pop-up window.')
			// Wait for the PDF to download
			WebUI.delay(10)
			// Close the pop-up window
			DriverFactory.getWebDriver().close()
			KeywordUtil.logInfo('Pop-up window closed successfully.')
			// Switch back to the main application window
			WebUI.switchToWindowIndex(0)
			KeywordUtil.logInfo('Switched back to the main application window.')
		} catch (Exception e) {
			// Log the exception details
			KeywordUtil.markFailed("An error occurred while handling the pop-up window: " + e.getMessage())
		}
	}
}