package common

import static com.kms.katalon.core.testdata.TestDataFactory.findTestData

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI




public class FileUtils {

	/*
	 * Function to get the row number from Data file
	 * testDataFilePath: Data File Path
	 * testCaseID: Test CaseId
	 *  return row number
	 */
	public static int findRowNumber(String testDataFilePath, String testCaseID) {
		try {
			com.kms.katalon.core.testdata.TestData testData = findTestData(testDataFilePath)
			int dataRowsCount = testData.getRowNumbers();

			int iRow=1;

			for(iRow=1;iRow<dataRowsCount;iRow++) {
				String strTestCaseID=testData.getValue(1,iRow)
				if(strTestCaseID.equals(testCaseID)) {
					break;
				}
			}
			return iRow
		}
		catch (Exception e) {
			WebUI.comment('Exception ::' + e.getMessage())

			//KeywordUtil.markFailedAndStop('Exception while executing TC')
		}
	}
}
