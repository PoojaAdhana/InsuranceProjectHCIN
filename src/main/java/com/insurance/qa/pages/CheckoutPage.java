package com.insurance.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.insurance.qa.base.InsuranceBase;
import com.insurance.qa.util.TestUtil;

public class CheckoutPage extends InsuranceBase{
	
	@FindBy(xpath="//div[@class='brderBox']/child::ul/child::li/span[@id='UCSummary1_lbleQuoteNo']")
	WebElement applicationNumber;
	
	@FindBy(xpath="//input[@id='MainContent_btnSaveProceed']")
	WebElement sendPaymentLinkBtn;
	
	@FindBy(xpath="//a[@id='MainContent_linkPaymentUrl']")
	WebElement paymentLink;
	
	public CheckoutPage() {
		super();
	}
	
	public void printApplicationNumber() {
		
		WebElement actualText = driver.findElement(By.xpath("//div[@class='brderBox']/child::ul/child::li/span[@id='UCSummary1_lbleQuoteNo']"));
		String applicationNo = actualText.getText();
		
		System.out.println(applicationNo);
		
		//System.out.println(TestUtil.getTextThroughJS(driver, applicationNumber));
		//System.out.println("Application Number="+applicationNumber.getText());
	}
	
	public void clickOnSendPaymentLink() {
		WebElement sendLink= driver.findElement(By.xpath("//input[@id='MainContent_btnSaveProceed']"));
		sendLink.click();
		//TestUtil.clickThroughJS(driver, sendPaymentLinkBtn);
		//sendPaymentLinkBtn.click();
	}
	
	public void clickOnPaymentLink() {
		WebElement sendPaymentLink= driver.findElement(By.xpath("//a[@id='MainContent_linkPaymentUrl']"));
		sendPaymentLink.click();
	}
	
	

}
