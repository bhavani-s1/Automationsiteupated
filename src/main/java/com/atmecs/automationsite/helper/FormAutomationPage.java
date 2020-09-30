package com.atmecs.automationsite.helper;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FormAutomationPage {

	WebDriver driver;
	
	Properties prop;
	
	public FormAutomationPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
public void fname(String xpath,String value) {
		
		driver.findElement(By.xpath(xpath)).sendKeys(value);
	}
	
public void selectdropdown(String xpath, String value) {
	
	Select skills = new Select(driver.findElement(By.xpath(xpath))); 		
		skills.selectByValue(value); 	
		

}
}
