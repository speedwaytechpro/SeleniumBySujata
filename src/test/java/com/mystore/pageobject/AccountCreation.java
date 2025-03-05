package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreation {
	WebDriver ldriver;
	public AccountCreation(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id= "id_gender2")
	WebElement titleMrs;
	
	@FindBy(id= "customer_firstname")
	WebElement firstName;
	
	@FindBy(id= "customer_lastname")
	WebElement lastName;
	
	@FindBy(id= "passwd")
	WebElement password;
	

	@FindBy(id= "submitAccount")
	WebElement register;
	
	
	
	//perform action
	public void clickOnMrs()
	{
		titleMrs.click();
	}
	
	public void enterFirstName(String firstname)
	{
		firstName.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname)
	{
		lastName.sendKeys(lastname);
	}
	
	public void enterPassword(String passwd)
	{
		password.sendKeys(passwd);
	}
	
	public void clickOnRegister()
	{
		register.click();
	}
	
}
