package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

import com.mystore.utilities.ReadConfig;

public class BaseClass {

	ReadConfig  readConfig=new ReadConfig();
	
	String url=readConfig.getBaseUrl();
	String browser=readConfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{
		
        driver=new ChromeDriver();
        
		
        //wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        logger=LogManager.getLogger("MyStoreV1");   
        
    	//openurl
		driver.get(url);
		logger.info("urlopen");
		
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	
	public void captureScreenShot(WebDriver driver,String testName) throws IOException
	{
		//step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot)driver);
		
		//step2: call getScreenshotAs method to create image file
		
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
	
		//step3: copy image file to destination
		FileUtils.copyFile(src, dest);
	}
	
	
}
