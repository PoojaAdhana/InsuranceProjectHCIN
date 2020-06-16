package com.insurance.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.insurance.qa.base.InsuranceBase;

public class PaymentProcess extends InsuranceBase{
	public PaymentProcess() {
		super();
	}
	
	public static void clickOnPayment() {
		WebElement clickBtn=driver.findElement(By.xpath("//input[@id='MainContent_btnSaveProceed']"));
		clickBtn.click();
	}
	
	public static void acceptAlert() {
		
		System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

	}
	
	public static void clickOnAmex() {
		
	}

}
