package com.atmecs.automationsite.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.automationsite_demo.constants.Constants;

public class Dataloader1 {

	
	WebDriver driver;
	Properties prop;

	public Properties Blazeloader() throws IOException  {
		
		
	//FileInputStream locator = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\newfile\\data.properties");
		
	FileInputStream locator = new FileInputStream(System.getProperty("user.dir") + Constants.LOCATORS);
	
	
	prop = new Properties(); 					
	prop.load(locator); 
	
	return prop;
	
	}

}

	

