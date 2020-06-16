package com.insurance.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.insurance.qa.base.InsuranceBase;

public class TestUtil extends InsuranceBase{
	
	public static long PAGE_LOAD_TIMEOUT = 40 ;
	public static long IMPLICIT_WAIT=20;
	//public static String TestData_CustomerDetails_Path="C:\\Users\\pooja.adhana\\eclipse-workspace\\Insurance_HCINTest\\src\\main\\java\\com\\insurance\\qa\\testdata\\CustomerDetails.xlsx";
	static Workbook book;
	static Sheet sheet;
	static  ArrayList<String> windowHandles;
	
	public void switchToFrame() {
		driver.switchTo().frame("");
	}
	
	public void switchToNextTab(WebDriver driver) {
		windowHandles= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	//Explicit wait for input fields
	public static void sendKeys1(WebDriver driver, WebElement locator, int timeout, String value) {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(locator));
		locator.sendKeys(value);
	}
	
	//Explicit wait for Buttons
	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable((locator)));
		locator.click();
	}
	
	//Click through JS
	public static void clickThroughJS(WebDriver driver,WebElement locator) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", locator);
	}
	
	//Get text through JS
	public static String getTextThroughJS(WebDriver driver,WebElement locator) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		String text=(String)executor.executeScript("return arguments[0].text;", locator);
		return text;
	}
	
	public static Object[][] getTestData(String sheetName, String TestData_CustomerDetails_Path) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TestData_CustomerDetails_Path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} 
		//catch (InvalidFormatException e) {
		//	e.printStackTrace();
		//} 
		catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}



}
