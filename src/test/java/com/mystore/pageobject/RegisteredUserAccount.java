package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisteredUserAccount {
	WebDriver ldriver;
	public RegisteredUserAccount(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//for validating username
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement userName;
	
	//for sign out
	@FindBy(linkText= "Sign out")
	WebElement signOut;
	
	//for searchbox
	@FindBy(id="search_query_top")
	WebElement searchBox;
	
	//for search button
	@FindBy(name= "submit_search")
	WebElement submit_search;
	
	public String verifyAcc()
	{
		 String text=userName.getText();
		 return text;
	}
	
	
	//for sign out
	public void clickOnSignout()
	{
		 signOut.click();
	}
	
	//for search
	public void EnterDataInSearchBox(String searchKey)
	{
		searchBox.sendKeys(searchKey);
	}

	public void ClickOnSearchButton()
	{
		submit_search.click();

	}
	
}
