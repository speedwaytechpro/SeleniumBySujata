package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
	

	//create object of webdriver
	WebDriver ldriver;
	public MyAccount(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
    //identify webelement...in page object model with page factory we use @FindBy anno..
	
	//new account
	
	@FindBy(id= "email_create")
	WebElement createEmailId;
	
	@FindBy(name= "SubmitCreate")
	WebElement submitCreate;
	
	////registered details
	
	@FindBy(id= "email")
	WebElement registeredUserEmail;
	
	@FindBy(id= "passwd")
	WebElement registeredUserPwd;
	
	@FindBy(name= "SubmitLogin")
	WebElement login;
	
	
	
	//perform action
	public void enterCreateEmailAddress(String emailAdd)
	{
		createEmailId.sendKeys(emailAdd);
	}
	
	public void clickSubmit()
	{
		submitCreate.click();
	}
	
	///methods for registered details access
	
	public void enterRegisteredEmail(String emailAdd)
	{
		registeredUserEmail.sendKeys(emailAdd);
	}
	
	public void enterRegisteredepwd(String pwd)
	{
		registeredUserPwd.sendKeys(pwd);
	}
	
	public void clickonRegisteredLogin()
	{
		login.click();
	}

}
