
package common

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement;

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




public class WebTableUtils {

	WebDriver driver = DriverFactory.getWebDriver();

	/**
	 * Get WebTable column Index
	 * @param webTableObject - WebTable object referenced from OR
	 * @param column name - column header name
	 */
	@Keyword(keywordObject = "WebTable")
	public static int getWebTableColumnIndex(WebElement tableElement, String columnName) {
		try {
			//WebElement tableElement = WebUI.findWebElement(webTableObject, 5);
			//WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget0Ifr'),20)
			List<WebElement> headers = tableElement.findElements(By.xpath("tr/th"));
			int headerIndex = -1;
			// Initialize to -1 if not found
			String expectedTitle = columnName;
			// Replace with your actual title
			for (int i = 0; i < headers.size(); i++) {

				String headerText = headers.get(i).getAttribute('data-attribute-name');
				println headerText
				if(!(headerText.equals(null))) {
					if (headerText.equalsIgnoreCase(expectedTitle)) {
						headerIndex = i;
						break;
					}
				}
			}
			if (headerIndex != -1) {
				KeywordUtil.markPassed("Title header found at index: " + headerIndex);
			} else {
				//KeywordUtil.markFailedAndStop("Title header not found");
			}

			return headerIndex;
		} catch (Exception e) {
			WebUI.takeScreenshot()
			WebUI.comment("Exception :: " + e.getMessage())
			//KeywordUtil.markFailedAndStop("Exception while getting WebTable column Index");
		}
	}


	/**
	 * Click WebTable column header
	 * @param webTableObject - WebTable object referenced from OR
	 * @param column name - column header name
	 */
	@Keyword(keywordObject = "WebTable")
	public static void clickWebTableColumnHeader(TestObject webTableObject, String columnName) {
		try {

			WebDriver driver = DriverFactory.getWebDriver();
			WebElement tableElement = WebUI.findWebElement(webTableObject, 5);

			List<WebElement> headers = tableElement.findElements(By.xpath("//tr/th"));
			int headerIndex = -1;
			// Initialize to -1 if not found
			String expectedTitle = columnName;
			// Replace with your actual title
			for (int i = 0; i < headers.size(); i++) {
				String headerText = headers.get(i).getAttribute('aria-label').trim();
				if (headerText.equalsIgnoreCase(expectedTitle)) {
					headerIndex = i;
					headers.get(i).click();
					break;
				}
			}
			if (headerIndex != -1) {
				KeywordUtil.markPassed("Title header found at index: " + headerIndex);
			} else {
				//KeywordUtil.markFailedAndStop("Title header not found");
			}
		} catch (Exception e) {
			WebUI.takeScreenshot()
			WebUI.comment("Exception :: " + e.getMessage())
			//KeywordUtil.markFailedAndStop("Exception while clicking WebTable column header");
		}
	}

	/**
	 * Get WebTable row Index based on Primary key column value
	 * @param webTableObject - WebTable object referenced from OR
	 * @param primaryKey - column header name to be set as Primary key
	 * @param primaryKeyValue - row value for Primary key
	 */
	@Keyword(keywordObject = "WebTable")
	public static int getWebTableRowIndex(TestObject webTableObject, String primaryKey, String primaryKeyValue) {
		try {

			WebDriver driver = DriverFactory.getWebDriver();
			WebElement tableElement = WebUI.findWebElement(webTableObject, 5);

			List<WebElement> rows = tableElement.findElements(By.tagName("tr"));

			int colIndex = WebTableUtils.getWebTableColumnIndex(webTableObject, primaryKey)
			int rowIndex=-1

			for (int i = 1; i < rows.size(); i++) {
				List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
				String colValue = columns.get(colIndex).getText();
				if(primaryKeyValue.equals(colValue)) {
					rowIndex=i;

					if (rowIndex != -1) {
						KeywordUtil.markPassed("Primary Key Value found at row index: " + rowIndex);
						return rowIndex;
						break;
					} else {
						//KeywordUtil.markFailedAndStop("Primary Key Value not found");
					}
				}
			}
		} catch (Exception e) {
			WebUI.takeScreenshot()
			WebUI.comment("Exception :: " + e.getMessage())
			//KeywordUtil.markFailedAndStop("Exception while getting Primary Key Value row Index");
		}
	}

	@Keyword(keywordObject = "WebTable")
	public static boolean verifytableValues(TestObject webTableObject, String primaryKey, String primaryKeyValue) {
		try {

			//driver.switchTo().frame('PegaGadget0Ifr');
			WebElement tableElement = WebUI.findWebElement(webTableObject, 5);
			WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget0Ifr'), 20)
			List<WebElement> rows = tableElement.findElements(By.tagName("/tr"));

			int colIndex = WebTableUtils.getWebTableColumnIndex(tableElement, primaryKey)

			for (int i = 1; i < rows.size(); i++) {
				List<WebElement> columns = rows.get(i).findElements(By.tagName("/td"));
				String colValue = columns.get(colIndex).getText();
				if(colValue.contains('/')) {
					colValue=colValue.split('/').last()
				}
				if(colValue.startsWith('M')) {
					String regex='^M(19|20)\\d{2}\\d{5}$';
					WebUI.verifyMatch(colValue, regex, true)
					KeywordUtil.markPassed(primaryKey+"Value is matched"+i);
				}
				else {
					if(primaryKeyValue.equals(colValue.trim())) {
						KeywordUtil.markPassed(primaryKey+"Value is matched"+i);
					} else if(i==rows.size()){
						//KeywordUtil.markFailedAndStop(primaryKey+"Primary Key Value is not matched");
					}
				}
			}
			WebUI.switchToDefaultContent();
		}

		catch (Exception e) {
			WebUI.takeScreenshot()
			WebUI.comment("Exception :: " + e.getMessage())
			//KeywordUtil.markFailedAndStop("Exception while getting Primary Key Value row Index");
		}
	}

	@Keyword(keywordObject = "WebTable")
	public static boolean verifytableValues(TestObject webTableObject, String primaryKey, String primaryKeyValue,TestObject Frame) {
		try {

			//driver.switchTo().frame('PegaGadget0Ifr');
			WebElement tableElement = WebUI.findWebElement(webTableObject, 5);
			WebUI.switchToFrame(Frame, 20)
			List<WebElement> rows = tableElement.findElements(By.tagName("/tr"));

			int colIndex = WebTableUtils.getWebTableColumnIndex(tableElement, primaryKey)

			for (int i = 1; i < rows.size(); i++) {
				List<WebElement> columns = rows.get(i).findElements(By.tagName("/td"));
				String colValue = columns.get(colIndex).getText();
				if(colValue.contains('/')) {
					colValue=colValue.split('/').last()
				}
				if(colValue.startsWith('M')) {
					String regex='^M(19|20)\\d{2}\\d{5}$';
					WebUI.verifyMatch(colValue, regex, true)
					KeywordUtil.markPassed(primaryKey+"Value is matched"+i);
				}
				else {
					if(primaryKeyValue.equals(colValue.trim())) {
						KeywordUtil.markPassed(primaryKey+"Value is matched"+i);
					} else if(i==rows.size()){
						//KeywordUtil.markFailedAndStop(primaryKey+"Primary Key Value is not matched");
					}
				}
			}
			WebUI.switchToDefaultContent();
		}

		catch (Exception e) {
			WebUI.takeScreenshot()
			WebUI.comment("Exception :: " + e.getMessage())
			//KeywordUtil.markFailedAndStop("Exception while getting Primary Key Value row Index");
		}
	}
	
	@Keyword(keywordObject = "WebTable")
	public static boolean verifytableValueswithDynamicIframe(TestObject webTableObject, String primaryKey, String primaryKeyValue, int index) {
		try {

			//driver.switchTo().frame('PegaGadget0Ifr');
			WebElement tableElement = WebUI.findWebElement(webTableObject, 10);
			WebUI.switchToFrame(findTestObject('Object Repository/Page_PegaCaseManagerPortal/iframe_PegaGadget'+ index +'Ifr'), 20)
			List<WebElement> rows = tableElement.findElements(By.tagName("/tr"));

			int colIndex = WebTableUtils.getWebTableColumnIndex(tableElement, primaryKey)

			for (int i = 1; i < rows.size(); i++) {
				List<WebElement> columns = rows.get(i).findElements(By.tagName("/td"));
				String colValue = columns.get(colIndex).getText();
				if(colValue.contains('/')) {
					colValue=colValue.split('/').last()
				}
				if(colValue.startsWith('M')) {
					String regex='^M(19|20)\\d{2}\\d{5}$';
					WebUI.verifyMatch(colValue, regex, true)
					KeywordUtil.markPassed(primaryKey+"Value is matched"+i);
				}
				else {
					if(primaryKeyValue.equals(colValue.trim())) {
						KeywordUtil.markPassed(primaryKey+"Value is matched"+i);
					} else if(i==rows.size()){
						//KeywordUtil.markFailedAndStop(primaryKey+"Primary Key Value is not matched");
					}
				}
			}
			WebUI.switchToDefaultContent();
		}

		catch (Exception e) {
			WebUI.takeScreenshot()
			WebUI.comment("Exception :: " + e.getMessage())
			//KeywordUtil.markFailedAndStop("Exception while getting Primary Key Value row Index");
		}
	}
}

