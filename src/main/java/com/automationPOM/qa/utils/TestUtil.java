package com.automationPOM.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.Select;

import com.automationPOM.qa.base.TestBase;

public class TestUtil extends TestBase {
//common global variables,common methods etc. are defined here, these variables are used in our Baseclass, check it out
	static FileUtils fileUtils;

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String emailAddress = "Ankushvij1@gmail.com";

//If frme is there inside our webpages, we can write this common utility method here
	public void switchToFrame() {
		driver.switchTo().frame("NameOFTheFrameGoesHere"); // we can call these methods from other classes by creating
															// object of this class in those
		// classes
	}

	public static void selectElement() {
		new Select(driver.findElement(By.id("id_contact")));

	}

	// Below code utility is used for loading test data from excel file, excel file
	// is put in TestData package//

	public static String TESTDATA_SHEET_PATH = "C:/Users/Ankush/eclipse-workspace/AutomationTestDemo/src/main/java/com/automationPOM/qa/testdata/AutomationPracticeTestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	public static Object[][] getTestData(String sheetName) throws InvalidFormatException { // Imp: the sheetName is the
																							// name of the worksheet
																							// inside our excel file
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) { // iterating through rows and columns with 2D
																			// arraylist
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		fileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));// adds
																													// screenshot
																													// to
																													// current
																													// directory
																													// of
																													// eclipse

	}
}
