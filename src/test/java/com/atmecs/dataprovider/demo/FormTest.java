package com.atmecs.dataprovider.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationsite_demo.constants.Constants;

//import com.automationsite_demo.constants.Constants;

public class FormTest {

	WebDriver driver;
	
	Properties prop;
	
	@DataProvider(name="getdata")
	
	public Object[][] getdata() throws InvalidFormatException, IOException {
	
    FileInputStream fis= new FileInputStream(Constants.EXCELPATH);
	
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	
	XSSFSheet sheet=workbook.getSheetAt(0);
	
	//row count
	
	int rowNum=sheet.getLastRowNum()+1;
	
	System.out.println("rowcount" +rowNum);
	
	//column count
	
	int colcount=sheet.getRow(0).getLastCellNum();
	
	System.out.println("column count"+colcount);
	
	Object[][]data= new String[rowNum][colcount];
	
	//iterating
	
	for(int i=0;i<rowNum;i++) {
		
		//XSSFRow row= sheet.getRow(i);//current row
		
		XSSFRow currentrow=sheet.getRow(i);	
		
		for(int j=0;j<colcount;j++) {
			
			//getting cell values
			
			String value=currentrow.getCell(j).toString(); //read the value from cell
			
			data[i][j]=value;
			
			System.out.print("the value is:\n" +data);
			
		
	}
		
		System.out.println();
		workbook.close();
	}
	return data;
	
	
	}
	
	@Test(dataProvider="getdata")
	
	public void login(String FirstName,String LastName,String Address, String Email)
	
	 {
		
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\bhavani.kore\\Drivers\\chromedriver.exe");
		
		System.setProperty(Constants.USER_DIR, Constants.CHROME_PATH);
		
		driver= new ChromeDriver();
		prop=new Properties();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		//driver.get(prop.getProperty("autourl"));
		driver.get("http://demo.automationtesting.in/Register.html");
		 
		
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(FirstName);
		
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(LastName);
		
		driver.findElement(By.xpath("//textarea[@ng-model='Adress']")).sendKeys(Address);
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Email);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//input[@ng-model='Phone']]")).sendKeys(phno);
		
		driver.findElement(By.name("radiooptions")).click(); //radio button

		driver.findElement(By.id("checkbox2")).click();  //checkbox

	 }	
}
	
