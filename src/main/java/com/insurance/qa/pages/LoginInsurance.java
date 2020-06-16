package com.insurance.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.insurance.qa.base.InsuranceBase;

public class LoginInsurance extends InsuranceBase{
	
	@FindBy(xpath="//input[@id='IDToken1']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='IDToken2']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='kc-login']")
	WebElement button;
	
	public LoginInsurance() {
		PageFactory.initElements(driver, this);
	}
	
	public CustomerSearchHome login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		button.click();
		
		return new CustomerSearchHome();
	}

}
