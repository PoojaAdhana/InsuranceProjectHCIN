package com.insurance.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.insurance.qa.base.InsuranceBase;
import com.insurance.qa.pages.CustomerSearchHome;
import com.insurance.qa.pages.LoginInsurance;

public class LoginInsurancePageTest extends InsuranceBase{
	
	LoginInsurance loginPage;
	CustomerSearchHome customerSearchHome;
	
	public LoginInsurancePageTest() {
		super();
	}
	
	@BeforeMethod()
	public void setup() {
		initialization();
		loginPage=new LoginInsurance();
		System.out.println("Pass");
	}
	
	@Test(priority=1)
	public void loginTest() {
		customerSearchHome=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod()
	public void tearDown() {
		//driver.quit();
	}

}
