package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressPage {
	WebDriver ldriver;
	public AddressPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath="//span[normalize-space()='Add my first address']")
	WebElement addressButton;
	
	@FindBy(id= "company")
	WebElement companyName;
	
	@FindBy(id= "address1")
	WebElement address;
	
	@FindBy(id= "city")
	WebElement cityName;
	

	@FindBy(id= "postcode")
	WebElement zipCode;
	
	@FindBy(id= "phone")
	WebElement phoneNum;
	
	@FindBy(id= "phone")
	WebElement phoneNum1;
	
	@FindBy(id= "id_state")
	WebElement stateName;
	
	@FindBy(id= "submitAddress")
	WebElement saveBtn;
	
	
	
	
	
	
	//perform action
	public void clickOnAddressBtn()
	{
		addressButton.click();
	}
	
	public void enterCompanyName(String company)
	{
		companyName.sendKeys(company);
	}
	
	public void enterAddress(String add)
	{
		address.sendKeys(add);
	}
	
	public void enterCity(String city)
	{
		cityName.sendKeys(city);
	}
	
	public void enterZipCode(String zip)
	{
		zipCode.sendKeys(zip);
	}
	
	public void enterPhone(String phn)
	{
		phoneNum.sendKeys(phn);
	}
	
	public void enterPhone1(String phn)
	{
		phoneNum1.sendKeys(phn);
	}
	
	public void enterState(String state)
	{
		 Select obj= new Select(stateName);
		 obj.selectByVisibleText(state);
	}
	
	public void clickOnSave()
	{
		 saveBtn.click();
	}
	
	

}
