package com.atmecs.dataprovider.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataprovider {

	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\bhavani.kore\\Drivers\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
	}

	
	@DataProvider(name="testdata")
	
	public Object[][] getdata(){
		
		Object[][] mydata= new Object[3][2];
		
		 mydata[0][0]="bhavani";
		 mydata[0][1]="pwd1";
		 mydata[1][0]="user2";
		 mydata[1][1]="pwd2";
		 mydata[2][0]="user3";
		 mydata[2][1]="pwd3";
		 
		 return mydata;

		
	}
	
	@Test(dataProvider="testdata")
	
	public void Fblogin(String username,String password) 
	{
		
		//username
		
		driver.findElement(By.xpath("//input[@aria-label='Email address or phone number']")).sendKeys(username);
		
		//pwd
		
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
		
		//submit
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
}


