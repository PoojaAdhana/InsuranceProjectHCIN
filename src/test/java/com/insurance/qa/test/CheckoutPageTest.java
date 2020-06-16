package com.insurance.qa.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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

public class CheckoutPageTest extends InsuranceBase{
	LoginInsurance loginPage;
	CustomerSearchHome customerSearchHome;
	TestUtil testUtil; 
	NewApplication newApplication;
	ProductSelection productSelection;
	Bagic_Info_Page bagicInfoPage;
	CheckoutPage checkoutPage;
	String sheetName = "CustomerInfo";
	public static String TestData_CustomerDetails_Path="C:\\Users\\pooja.adhana\\eclipse-workspace\\Insurance_HCINTest\\src\\main\\java\\com\\insurance\\qa\\testdata\\CustomerDetails.xlsx";
	
	public CheckoutPageTest() {
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
		checkoutPage=new CheckoutPage();
		
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
		bagicInfoPage=productSelection.enterValuesHealth("400000","1");
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		System.out.println("Pass till bagic page");
		
	
	}

	@DataProvider
	public Object[][] getCustomerData() {
		Object data[][]=TestUtil.getTestData(sheetName, TestData_CustomerDetails_Path);
		return data;
	}
	
	@Test(dataProvider="getCustomerData")
	public void enterSelfDetailsTest(String heightfeet, String heightinches, String weight, String occupation,
			String nomineename, String nomineerelation) {
		
		checkoutPage=bagicInfoPage.enterSelfDetails(heightfeet, heightinches, weight, occupation, nomineename, nomineerelation);
		
		checkoutPage.printApplicationNumber();
		checkoutPage.clickOnSendPaymentLink();
		checkoutPage.clickOnPaymentLink();
	}
	
	
	@AfterMethod()
	public void tearDown() {
		//driver.quit();
	}

}


