/**
 * ============================================================================
 * Title        : New Test Case
 * Title         : New Test Case
 * Folder        : Scripts/Dashboards/New Test Case
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

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//write a code for pallindrome
// Define the string to check for palindrome
String inputString = "madam"
// Reverse the string
String reversedString = inputString.reverse()
// Verify if the original string is equal to the reversed string
assert inputString == reversedString : "The string is not a palindrome"

//Write a code for pallindrome without using reverse method
/ *
 * Check if a given string is a palindrome without using the reverse method
 *
 * @param inputString The string to check
 * @return true if the string is a palindrome, false otherwise
 * /
def isPalindrome(String inputString) {
    // Initialize pointers for start and end of the string
    int start = 0
    int end = inputString.length() - 1

    // Loop until the pointers meet in the middle
    while (start < end) {
        // Compare characters at start and end pointers
        if (inputString.charAt(start) != inputString.charAt(end)) {
            // Characters do not match, not a palindrome
            return false
        }
        // Move pointers towards the center
        start++
        end--
    }
    // All characters matched, it is a palindrome
    return true
}
// Check if a string is a palindrome by comparing characters from both ends without using the reverse method