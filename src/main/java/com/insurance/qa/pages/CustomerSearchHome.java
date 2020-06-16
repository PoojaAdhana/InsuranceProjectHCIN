package com.insurance.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.Set;

import com.insurance.qa.base.InsuranceBase;

public class CustomerSearchHome extends InsuranceBase{
	
	Select select;
	
	@FindBy(xpath="//select[@id='MainContent_ddlFilter']")
	WebElement selectOption;
	
	@FindBy(xpath="//input[@id='MainContent_txtFilter']")
	WebElement input;
	
	@FindBy(xpath="//input[@id='MainContent_Search']")
	WebElement searchBtn;
	
	@FindBy(xpath="//input[@id='MainContent_CreateApp']")
	WebElement createNewApplicationBtn;
	
	
	public CustomerSearchHome() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyTitleTest() {
		return driver.getTitle();
	}
	
	public void selectCustomerIdTest() {
		
		select= new Select(selectOption);
		select.selectByVisibleText("CustomerId");
		System.out.println("customerId Pass");
	}
	
	public void selectMobileNumberTest() {
		select= new Select(selectOption);
		select.selectByVisibleText("Mobile Number");
	}
	
	public void selectPanNumberTest() {
		select= new Select(selectOption);
		select.selectByVisibleText("PAN");
	}
	
	public void selectApplicationNumberTest() {
		select= new Select(selectOption);
		select.selectByVisibleText("Application Number");
	}
	
	public void enterTheValue(String str) {
		input.sendKeys(str);
	}
	
	public void selectPolicynNumberTest() {
		select= new Select(selectOption);
		select.selectByVisibleText("Policy Number");
	}

	public CustomerSearch clickSearchMobileTest() {
		searchBtn.click();
		return new CustomerSearch();
	}
	
	public CustomerSearch clickSearchTest() {
		searchBtn.click();
		
		return new CustomerSearch();
	}
	
	public NewApplication createNewApplication() {
		createNewApplicationBtn.click();
		return new NewApplication();
	}

}
