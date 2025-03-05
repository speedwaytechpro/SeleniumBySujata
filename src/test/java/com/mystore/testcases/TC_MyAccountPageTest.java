package com.mystore.testcases;

import java.io.IOException;

//import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.AccountCreation;
import com.mystore.pageobject.AddressPage;
import com.mystore.pageobject.IndexPage;
import com.mystore.pageobject.MyAccount;
import com.mystore.pageobject.RegisteredUserAccount;


public class TC_MyAccountPageTest extends BaseClass{
	
	@Test(enabled=false)
	public void verifyRegistrationAndLogin()
	{
	
		IndexPage pg=new IndexPage(driver);
		pg.clickOnSignIn(); 
		logger.info("clicked on signin");
		
		MyAccount myAcpg=new MyAccount(driver);
		myAcpg.enterCreateEmailAddress("sujata.s@gmail.com");
		logger.info("entered email addresss in create acc.");
		
		myAcpg.clickSubmit();
		logger.info("clicked on create account");
		
		AccountCreation ac=new AccountCreation(driver);
		
		ac.clickOnMrs();
		ac.enterFirstName("sujata");
		ac.enterLastName("saund");
		ac.enterPassword("$ujata7744");
		ac.clickOnRegister();
		
		AddressPage ap=new AddressPage(driver);
		ap.clickOnAddressBtn();
		ap.enterCompanyName("abc");
		ap.enterAddress("nanded city");
		ap.enterCity("pune");
		ap.enterZipCode("12345");
		ap.enterPhone("1234567890");
		ap.enterPhone1("1234509876");
		ap.enterState("Alaska");
		ap.clickOnSave();
		
		logger.info("clicked on save");
		
		
		RegisteredUserAccount regAcc=new RegisteredUserAccount (driver);
		String userName=regAcc.verifyAcc();
		Assert.assertEquals("Sujata saund", userName);
		logger.info("Account verified");	
		
	}
	
	@Test
	public void verifyLogin() throws IOException
	{
		IndexPage pg=new IndexPage(driver);
		pg.clickOnSignIn(); 
		logger.info("clicked on signin");
		
		MyAccount myAcpg = new MyAccount(driver);
		myAcpg.enterRegisteredEmail("sujata.so@gmail.com");
		myAcpg.enterRegisteredepwd("$ujata7744");
		myAcpg.clickonRegisteredLogin();
		logger.info("entered registered email and password");
		
        //verify user name is correct or not
		RegisteredUserAccount regAcc=new RegisteredUserAccount (driver);
		String userName=regAcc.verifyAcc();
		if(userName.equals("Sujata saund"))
		{
			logger.info("Account verified");	
			Assert.assertTrue(true);
		}
		else 
		{
			logger.info("Account not verified");
			captureScreenShot(driver,"verifyLogin");
			
			logger.info("screenshot captured");
			Assert.assertTrue(false);
			
		} 	
		
	}
	
	
	@Test(enabled=false)
	public void VerifySignOut() throws IOException 
	{

		logger.info("***************TestCase Verify Sign out starts*****************"); 

		IndexPage pg = new IndexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		MyAccount myAcpg = new MyAccount(driver);

		myAcpg.enterRegisteredEmail("sujata.so@gmail.com");
		logger.info("Entered email address");

		myAcpg.enterRegisteredepwd("$ujata7744");
		logger.info("Entered password");

		myAcpg.clickonRegisteredLogin();
		logger.info("Clicked on sign in link..");


		RegisteredUserAccount regUser = new RegisteredUserAccount(driver);
		regUser.clickOnSignout();

		if(pg.getPageTitle().equals("Login - My Store"))
		{
			logger.info("VerifySignOut - Passed");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("VerifySignOut - Failed");
			captureScreenShot(driver,"VerifySignOut");
			Assert.assertTrue(false);
		}

	
		logger.info("***************TestCase Verify Sign out ends*****************"); 

	}
	
	
}
