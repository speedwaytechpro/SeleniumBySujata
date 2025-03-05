package com.mystore.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
//import org.bouncycastle.util.Properties;

public class ReadConfig {
	
	//create variable for Properties class in java
	Properties properties;
	
	//path for config.properties
    String path="C:\\Users\\Sujeet\\Desktop\\Automation_Framework\\Configuration\\config.properties";
    
    //constructor for read config file
    
    public ReadConfig()
    {
    	try {
    	properties=new Properties();
    	
    	FileInputStream fis=new FileInputStream(path);
    	
    	properties.load(fis);
    	
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    }
    //capture values 
    //get base url value
    public String getBaseUrl()
    {
    	String value=properties.getProperty("baseUrl");
    	
    	if(value!=null)
    		return value;
    	else
    		throw new RuntimeException("Url not specified in config file");
    	
    }
    
    //get browser value
    public String getBrowser()
    {
    	String value=properties.getProperty("browser");
    	
    	if(value!=null)
    		return value;
    	else
    		throw new RuntimeException("Browser not specified in config file");
    	
    }
}
