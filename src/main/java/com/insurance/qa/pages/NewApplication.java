package com.insurance.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.insurance.qa.base.InsuranceBase;

public class NewApplication extends InsuranceBase{
	
	Select select;

	@FindBy(xpath="//input[@id='MainContent_txtMobileNumber']")
	WebElement mobileNumber;
	
	@FindBy(xpath="//input[@id='MainContent_txtEmail']")
	WebElement emailId;
	
	@FindBy(xpath="//select[@id='MainContent_ddlIncome']")
	WebElement monthlyIncome;
	
	@FindBy(xpath="//input[@id='MainContent_txtDob']")
	WebElement dateOfBirth;
	
	@FindBy(xpath="//input[@id='MainContent_cmdProceed']")
	WebElement proceedBtn;
	
	public NewApplication() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterMobileNumber(String str) {
		mobileNumber.sendKeys(str);
	}
	

	public void enterEmailId() {
		
	}
	

	public void enterMonthlyIncome() {
		
	}
	
	public void clickOnProceed() {
		
	}
	
	public ProductSelection enterDetailsForNewApplication(String mobileNum, String email, String income) {
		
		mobileNumber.clear();
		mobileNumber.sendKeys(mobileNum);
		
		emailId.clear();
		emailId.sendKeys(email);
		
		select= new Select(monthlyIncome);
		select.selectByVisibleText(""+income+"");
		
		proceedBtn.click();
		
		return new ProductSelection();
	}
	
	
}
