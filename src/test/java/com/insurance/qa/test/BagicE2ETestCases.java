package com.insurance.qa.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.insurance.qa.base.InsuranceBase;
import com.insurance.qa.pages.Bagic_Info_Page;
import com.insurance.qa.pages.CheckoutPage;
import com.insurance.qa.pages.CustomerSearchHome;
import com.insurance.qa.pages.LoginInsurance;
import com.insurance.qa.pages.NewApplication;
import com.insurance.qa.pages.ProductSelection;
import com.insurance.qa.util.TestUtil;

public class BagicE2ETestCases extends InsuranceBase {
	LoginInsurance loginPage;
	CustomerSearchHome customerSearchHome;
	TestUtil testUtil; 
	NewApplication newApplication;
	ProductSelection productSelection;
	Bagic_Info_Page bagicInfoPage;
	CheckoutPage checkoutPage;
	String sheetName = "CustomerInfo";
	public String TestData_CustomerDetails_Path="C:\\Users\\pooja.adhana\\eclipse-workspace\\Insurance_HCINTest\\src\\main\\java\\com\\insurance\\qa\\testdata\\BagicSelfData.xlsx";
	
	public BagicE2ETestCases() {
		super();
	}
	
	@BeforeTest()
	public void setup() {
		initialization();
		testUtil=new TestUtil();
		loginPage=new LoginInsurance();
		productSelection= new ProductSelection();
		newApplication= new NewApplication();
		productSelection= new ProductSelection();
		bagicInfoPage=new Bagic_Info_Page();
		checkoutPage=new CheckoutPage();
		System.out.println("Initialized successfully");
		
		
	}
	
	@DataProvider
	public Object[][] getCustomerData() {
		Object data[][]=TestUtil.getTestData(sheetName, TestData_CustomerDetails_Path);
		return data;
	}
	
	@Test(dataProvider="getCustomerData")
	public void BagicTestForSelf(String loginId, String	password, String customerId, String phoneNumber, String	email, String monthlyIncome, String sumInsured, String policyTerm, String selfHeightFeet, String selfHeightInches, String selfWeight, String selfOccupation, String selfNominee, String	selfNomineeRelation) {
		customerSearchHome=loginPage.login(loginId, password);
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println("Pass");
		
		customerSearchHome.selectCustomerIdTest();
		customerSearchHome.enterTheValue(customerId);
		newApplication=customerSearchHome.createNewApplication();
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		testUtil.switchToNextTab(driver);
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		productSelection=newApplication.enterDetailsForNewApplication(phoneNumber, email, monthlyIncome);
		bagicInfoPage=productSelection.enterValuesHealth(sumInsured,policyTerm);
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println("Pass till bagic page");
		
		checkoutPage=bagicInfoPage.enterSelfDetails(selfHeightFeet, selfHeightInches, selfWeight, selfOccupation, selfNominee, selfNomineeRelation);
		checkoutPage.printApplicationNumber();
		checkoutPage.clickOnSendPaymentLink();
		checkoutPage.clickOnPaymentLink();
		
	
		
	}
	
	@AfterMethod()
	public void tearDown() {
		//driver.quit();
		
	}
	
	

}
