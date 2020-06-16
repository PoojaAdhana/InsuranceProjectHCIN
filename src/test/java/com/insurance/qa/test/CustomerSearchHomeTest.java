package com.insurance.qa.test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.insurance.qa.base.InsuranceBase;
import com.insurance.qa.pages.CustomerSearchHome;
import com.insurance.qa.pages.LoginInsurance;
import com.insurance.qa.util.TestUtil;

public class CustomerSearchHomeTest extends InsuranceBase {
	
	LoginInsurance loginPage;
	CustomerSearchHome customerSearchHome;
	TestUtil testUtil; 
	
	public CustomerSearchHomeTest() {
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
	}
	
	@Test()
	public void selectFromCustomerIdTest() {
		customerSearchHome.selectCustomerIdTest();
		customerSearchHome.enterTheValue("12345");
		customerSearchHome.createNewApplication();
		
	}
	
	
	@AfterMethod()
	public void tearDown() {
		//driver.quit();
	}
}
