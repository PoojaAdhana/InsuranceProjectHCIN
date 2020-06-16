package com.insurance.qa.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.insurance.qa.base.InsuranceBase;
import com.insurance.qa.pages.Bagic_Info_Page;
import com.insurance.qa.pages.CustomerSearchHome;
import com.insurance.qa.pages.LoginInsurance;
import com.insurance.qa.pages.NewApplication;
import com.insurance.qa.pages.ProductSelection;
import com.insurance.qa.util.TestUtil;

public class ProductSelectionTest extends InsuranceBase{
	
	LoginInsurance loginPage;
	CustomerSearchHome customerSearchHome;
	TestUtil testUtil; 
	NewApplication newApplication;
	ProductSelection productSelection;
	Bagic_Info_Page bagicInfoPage;
	
	public ProductSelectionTest() {
		super();
	}

	@BeforeMethod()
	public void setup() {
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginInsurance();
		productSelection= new ProductSelection();
		newApplication= new NewApplication();
		productSelection= new ProductSelection();
		bagicInfoPage=new Bagic_Info_Page();
		
		customerSearchHome=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println("Pass");
		customerSearchHome.selectCustomerIdTest();
		customerSearchHome.enterTheValue("308675");
		newApplication=customerSearchHome.createNewApplication();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		testUtil.switchToNextTab(driver);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		productSelection=newApplication.enterDetailsForNewApplication("9818115777", "pooja.adhana@homecredit.co.in", "50,001 - 60,000");
	}
	
	@Test()
	public void enterProductDetailsTest() {
		
		bagicInfoPage=productSelection.enterValuesHealth("400000","1");
	}
	
	
	@AfterMethod()
	public void tearDown() {
		//driver.quit();
	}



}
