package com.insurance.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.insurance.qa.base.InsuranceBase;
import com.insurance.qa.util.TestUtil;

public class Bagic_Info_Page extends InsuranceBase{
	
	Select select;

	@FindBy(xpath="//input[@id='txtProposerFirstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='txtProposerMiddleName']")
	WebElement middleName;
	
	@FindBy(xpath=" //input[@id='txtProposerLastName']")
	WebElement lastName;
	
	@FindBy(xpath="//select[@id='ddlProposerDay']")
	WebElement date_DOBself;
	
	@FindBy(xpath="//select[@id='ddlProposerMonth']")
	WebElement month_DOBself;
	
	@FindBy(xpath="//select[@id='ddlProposerYear']")
	WebElement year_DOBself;
	
	@FindBy(xpath="//input[@id='txtAnnualIncome']")
	WebElement monthlyIncome;
	
	@FindBy(xpath="//input[@id='txtPanNumber']")
	WebElement panNumber;
	
	@FindBy(xpath="//input[@id='txtApplicationNumber']")
	WebElement addMemberSelect;
	
	@FindBy(xpath="//select[@id='ddlRelation']")
	WebElement addMember;
	
	@FindBy(xpath="//select[@id='ddlDay']")
	WebElement date_DOBAddMember;
	
	@FindBy(xpath="//select[@id='ddlMonth']")
	WebElement month_DOBAddMember;
	
	@FindBy(xpath="//select[@id='ddlYear']")
	WebElement year_DOBAddMember;
	
	@FindBy(xpath="//input[@id='btnAdd']")
	WebElement addBtn;
	
	@FindBy(xpath="//select[@id='ctl00_MainContent_UCLeadDetails1_UCInsuredMember1_ddlInsuredMembersSalutation']")
	@CacheLookup
	WebElement salutationSelf;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_UCLeadDetails1_UCInsuredMember1_txtFirstName']")
	WebElement firstNameSelf;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_UCLeadDetails1_UCInsuredMember1_txtMiddleName']")
	WebElement middleNameSelf;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_UCLeadDetails1_UCInsuredMember1_txtLastName']")
	WebElement lastNameSelf;
	
	@FindBy(xpath="//select[@id='ctl00_MainContent_UCLeadDetails1_UCInsuredMember1_ddlDay']")
	WebElement date_self;
	
	@FindBy(xpath="//select[@id='ctl00_MainContent_UCLeadDetails1_UCInsuredMember1_ddlMonth']")
	WebElement month_self;
	
	@FindBy(xpath="//select[@id='ctl00_MainContent_UCLeadDetails1_UCInsuredMember1_ddlYear']")
	WebElement year_self;
	
	@FindBy(xpath="//select[@id='ctl00_MainContent_UCLeadDetails1_UCInsuredMember1_ddlHeightInFeet']")
	WebElement heightFeet_self;
	
	@FindBy(xpath="//select[@id='ctl00_MainContent_UCLeadDetails1_UCInsuredMember1_ddlHeightInInch']")
	WebElement heightInches_self;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_UCLeadDetails1_UCInsuredMember1_txtWeight']")
	WebElement weight_self;
	
	@FindBy(xpath="//select[@id='ctl00_MainContent_UCLeadDetails1_UCInsuredMember1_ddlOccupation']")
	WebElement occupation_self;
	
	@FindBy(xpath="//input[@id='ctl00_MainContent_UCLeadDetails1_UCInsuredMember1_txtNomineeName']")
	WebElement nominee_self;
	
	@FindBy(xpath="//select[@id='ctl00_MainContent_UCLeadDetails1_UCInsuredMember1_ddlNomineeRelationship']")
	WebElement nomineeRelation_self;
	
	@FindBy(xpath="//input[@id='chkNoForAllMemberCase1']")
	WebElement pedNoForAll;
	
	@FindBy(xpath="//ul[@class='subCheck case1Checkbox']//input[@id='chk_1']")
	WebElement pedSelf;
	
	@FindBy(xpath="//input[@id='chkNoForAlltobacco']")
	WebElement smokeNoAll;
	
	@FindBy(xpath="//ul[@class='subChecktobacco case1Checkboxtobacco']//input[@id='chk_1']")
	WebElement smokeSelf;
	
	@FindBy(xpath="//input[@id='chkNoFordeclined']")
	WebElement criticalIllnessNoAll;
	
	@FindBy(xpath="//ul[@class='subCheckinsurance case1Checkboxdeclined']//input[@id='chk_1']")
	WebElement criticalIllnessSelf;
	
	@FindBy(xpath="//input[@id='btnSaveProceed']")
	WebElement proceedBtn;
	
	
	@FindBy(xpath="//h4[contains(text(),'Additional Details')]")
	WebElement additionalSection;
	
	public Bagic_Info_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public CheckoutPage enterSelfDetails(String heightfeet, String heightinches, String weight, String occupation,
			String nomineename, String nomineerelation) {
		
		select= new Select(heightFeet_self);
		select.selectByVisibleText(""+heightfeet+"");
		
		select= new Select(heightInches_self);
		select.selectByVisibleText(""+heightinches+"");
		
		if(weight_self.isDisplayed()) {
			weight_self.sendKeys(weight);
		}
		
		select=new Select(occupation_self);
		select.selectByVisibleText(""+occupation+"");
		
		nominee_self.sendKeys(nomineename);
		
		select = new Select(nomineeRelation_self);
		select.selectByVisibleText(""+nomineerelation+"");
		
		additionalSection.click();
		
		TestUtil.clickThroughJS(driver, pedNoForAll);
		//TestUtil.clickOn(driver, pedNoForAll, 10);
		
		TestUtil.clickThroughJS(driver, smokeNoAll);
		//TestUtil.clickOn(driver, smokeNoAll, 10);
		
		TestUtil.clickThroughJS(driver, criticalIllnessNoAll);
		//TestUtil.clickOn(driver, criticalIllnessNoAll, 10);
		
		TestUtil.clickThroughJS(driver, proceedBtn);
		//TestUtil.clickOn(driver, proceedBtn, 10);
		
		return new CheckoutPage();
		
		
	}
	
	
	
	public void enterHeightFeetSelf(String str) {
		select= new Select(heightFeet_self);
		select.selectByVisibleText("str");
		System.out.println("height Pass");
	}
	
	public void enterHeightInchesSelf(String str) {
		select= new Select(heightInches_self);
		select.selectByVisibleText("str");
		System.out.println("height Pass");
	}
	
	public void enterWeightSelf(String str) {
		weight_self.sendKeys(str);
	}
	
	public void enterOccupationSelf(String str) {
		select=new Select(occupation_self);
		select.selectByVisibleText("str");
	}
	
	public void enterNomineeNameSelf(String str) {
		nominee_self.sendKeys(str);
	}
	
	public void enterNomineeRelationSelf(String str) {
		select = new Select(nomineeRelation_self);
		select.selectByVisibleText("str");
	}
	
}
