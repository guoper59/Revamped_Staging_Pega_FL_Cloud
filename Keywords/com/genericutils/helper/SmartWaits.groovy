package com.genericutils.helper

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject

import internal.GlobalVariable

/**
 * SmartWaits
 * Reusable smart-click and smart-wait helpers for Katalon Studio.
 * Wraps standard WebUI waits with retry logic and better error messages.
 */
public class SmartWaits {

    /**
     * Wait for an element to be clickable, then click it with retry logic.
     * Retries every second up to the given timeout before throwing.
     *
     * @param testObject  The target element
     * @param timeout     Max wait in seconds (default: GlobalVariable.timeOutValue)
     */
    @Keyword
    static void clickWhenReady(TestObject testObject, int timeout = 20) {
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
            KeywordUtil.markFailedAndStop("Failed to click element after ${timeout}s: " + testObject.getObjectId())
        }
    }

    /**
     * Wait for an element to be visible, then return its text.
     *
     * @param testObject  The target element
     * @param timeout     Max wait in seconds
     * @return            The trimmed text of the element
     */
    @Keyword
    static String getTextWhenVisible(TestObject testObject, int timeout = 20) {
        WebUI.waitForElementVisible(testObject, timeout, FailureHandling.STOP_ON_FAILURE)
        return WebUI.getText(testObject, FailureHandling.STOP_ON_FAILURE)
    }

    /**
     * Wait for an element to be clickable, select an option by label, log the selection.
     *
     * @param testObject  The dropdown element
     * @param label       The option label to select
     * @param timeout     Max wait in seconds
     */
    @Keyword
    static void selectOptionWhenReady(TestObject testObject, String label, int timeout = 20) {
        WebUI.waitForElementClickable(testObject, timeout)
        WebUI.selectOptionByLabel(testObject, label, false)
        KeywordUtil.logInfo("Selected option: ${label}")
    }
}