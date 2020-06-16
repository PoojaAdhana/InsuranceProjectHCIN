package com.insurance.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.insurance.qa.base.InsuranceBase;

public class ProductSelection extends InsuranceBase{
	
	Select select;
	
	@FindBy(xpath="//a[@id='healthinsurance']")
	WebElement healthTab;
	
	@FindBy(xpath="//input[@id='MainContent_gvLifeQuotes_txtAmountToInvest_0']") 
	WebElement amountToInvest;
	
	@FindBy(xpath="//select[@id='MainContent_gvLifeQuotes_ddlPolicyTerm_0']") 
	WebElement policyTerm;
	
	@FindBy(xpath="//select[@id='MainContent_gvLifeQuotes_ddlPayTerm_0']") 
	WebElement paymentTermLife;
	
	@FindBy(xpath="//input[@id='MainContent_gvLifeQuotes_cmdProceed_0']") 
	WebElement payBtnLife;
	
	@FindBy(xpath="//select[@id='MainContent_gvHealthQuotes_ddlSI_0']")
	WebElement sumInsuredHealth;
	
	@FindBy(xpath="//select[@id='MainContent_gvHealthQuotes_DDLTerm_0']")
	WebElement policyTermHealth;
	
	@FindBy(xpath=" //input[@id='MainContent_gvHealthQuotes_cmdProceed_0']")
	WebElement payBtnHealth;
	
	public ProductSelection() {
		PageFactory.initElements(driver, this);
	}
	
	public Bagic_Info_Page enterValuesHealth(String sum, String term) {
		
		healthTab.click();
		
		select= new Select(sumInsuredHealth);
		select.selectByVisibleText(""+sum+"");
		
		select= new Select(policyTermHealth);
		select.selectByVisibleText(""+term+"");
		
		payBtnHealth.click();
		return new Bagic_Info_Page();
		
	}
	
/*	public Bagic_Info_Page enterValuesLife(String amount, String policyTrm, String payTrm) {
		
		healthTab.click();
		
		amountToInvest.clear();
		amountToInvest.sendKeys(amount);
		
		select= new Select(policyTerm);
		select.selectByVisibleText(""+policyTrm+"");
		
		select= new Select(paymentTermLife);
		select.selectByVisibleText(""+payTrm+"");
		
		payBtnLife.click();
		return new Bagic_Info_Page();
		
	}
	*/
	

}
