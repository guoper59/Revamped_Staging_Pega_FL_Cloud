package com.testdata.helper

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

/**
 * TestDataHelper
 * Utility methods for reading and accessing test data in Katalon Studio.
 */
public class TestDataHelper {

    /**
     * Retrieve all test case data for a given case ID from a data file,
     * returned as a HashMap<columnName, value>.
     *
     * @param strDataFileName  Path to the test data file (e.g. 'Data Files/Dashboards')
     * @param strCaseId        Test case ID to filter rows by
     * @return HashMap<String, HashMap<String,String>> keyed by test case ID
     */
    @Keyword
    def retrieveTestCaseData(String strDataFileName, String strCaseId) {
        com.kms.katalon.core.testdata.TestData testData = findTestData(strDataFileName)
        String[] columnNames = testData.getColumnNames()
        int dataRowsCount = testData.getRowNumbers()
        HashMap<String, HashMap> hash_map = new HashMap<String, HashMap>()

        for (def iRow : 1..dataRowsCount) {
            String strTestCaseID = testData.getValue(1, iRow)
            if (strTestCaseID.startsWith(strCaseId)) {
                HashMap<String, String> innerMap = new HashMap<String, String>()
                for (String col in columnNames) {
                    if (col != null && !col.equalsIgnoreCase('TestCaseId')) {
                        innerMap.put(col, testData.getValue(col, iRow))
                    }
                }
                hash_map.put(strTestCaseID, innerMap)
            }
        }
        return hash_map
    }

    /**
     * Shorthand: read a single field value from a test data file for the current test case row.
     *
     * @param dataFile   Test data file name (without 'Data Files/' prefix)
     * @param fieldName  Column name in the data file
     * @param rowNumber  Row number identified via FileUtils.findRowNumber
     * @return String value from the data file
     */
    @Keyword
    static String getValue(String dataFile, String fieldName, int rowNumber) {
        return findTestData(dataFile).getValue(fieldName, rowNumber)
    }

    /**
     * Log a key:value pair in a standardised format for Katalon Reports.
     *
     * @param label  Description label
     * @param value  The value to log
     */
    @Keyword
    static void logField(String label, String value) {
        KeywordUtil.logInfo("${label}: ${value}")
    }
}
