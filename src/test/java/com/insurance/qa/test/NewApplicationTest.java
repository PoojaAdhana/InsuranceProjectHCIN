package com.insurance.qa.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.insurance.qa.base.InsuranceBase;
import com.insurance.qa.pages.CustomerSearchHome;
import com.insurance.qa.pages.LoginInsurance;
import com.insurance.qa.pages.NewApplication;
import com.insurance.qa.util.TestUtil;

public class NewApplicationTest extends InsuranceBase{
	LoginInsurance loginPage;
	CustomerSearchHome customerSearchHome;
	TestUtil testUtil; 
	NewApplication newApplication;
	
	public NewApplicationTest() {
		super();
	}

	@BeforeMethod()
	public void setup() {
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginInsurance();
		
		loginPage=new LoginInsurance();
		customerSearchHome=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println("Pass");
		customerSearchHome.selectCustomerIdTest();
		customerSearchHome.enterTheValue("12345");
		newApplication=customerSearchHome.createNewApplication();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		testUtil.switchToNextTab(driver);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
	@Test()
	public void enterCustomerDetailsTest() {
		
		newApplication.enterDetailsForNewApplication("9818115777", "pooja.adhana@homecredit.co.in", "50,001 - 60,000");
	}
	
	
	@AfterMethod()
	public void tearDown() {
		//driver.quit();
	}


}
