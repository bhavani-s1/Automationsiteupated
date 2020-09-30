package com.atmecs.automationsite_demo;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.atmecs.automationsite.helper.Dataloader1;
import com.atmecs.automationsite.helper.FormAutomationPage;
import com.automationsite_demo.constants.Constants;



public class RegistrationFormTest {
WebDriver driver;
Properties prop;
FormAutomationPage formdata;
	
@Test(priority=1)
	public void launchBrowser() throws IOException {
		
		
System.setProperty(Constants.USER_DIR,Constants.CHROME_PATH);
	
 driver= new ChromeDriver();
	
 formdata= new FormAutomationPage(driver);
	 
 prop=new Properties();
	
 Dataloader1 dl=new Dataloader1();
	  
	  prop=dl.Blazeloader();
		
	driver.get(prop.getProperty("url"));
	//driver.get("http://demo.automationtesting.in/Register.html");
	
	driver.manage().window().maximize();
	}
	
	@Test(priority=2)
	
	public void register() {
		
			
		//firstName
		
		formdata.fname(prop.getProperty("fnamexpath"), prop.getProperty("firstname"));
//driver.findElement(By.xpath(prop.getProperty("fnamexpath"))).sendKeys(prop.getProperty("firstname"));
		
		//lastName
		
driver.findElement(By.xpath(prop.getProperty("lnamexpath"))).sendKeys(prop.getProperty("lastname"));
	
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	//Address	
		driver.findElement
        (By.xpath(prop.getProperty("addxpath"))).sendKeys("Bangalore");
		
		
      //textarea[@class='form-control ng-pristine ng-valid ng-touched']
		//email
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.findElement(By.xpath
(prop.getProperty("mailidxpath"))).sendKeys(prop.getProperty("emailid"));
	
//phone

driver.findElement(By.xpath(prop.getProperty("phnoxpath"))).sendKeys(prop.getProperty("phno"));


driver.findElement(By.name("radiooptions")).click(); //radio button

driver.findElement(By.id("checkbox2")).click();  //checkbox

	}

	
	
@Test(priority=3)

public void dropDowns() {
	
		//languages
		 
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  
	WebElement language=driver.findElement(By.id("msdd"));
	
	language.click();
	
	driver.findElement(By.xpath("//a[contains(text(),'Arabic')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
		
	formdata.selectdropdown(prop.getProperty("selectskill"),prop.getProperty("C++"));
	//Select dropdown = new Select(driver.findElement(By.id("Skills")));  //select dropdown
	
	//dropdown.selectByVisibleText("C++");  
	  
		Select country= new Select(driver.findElement(By.xpath(prop.getProperty("countryxpath"))));
		
		country.selectByVisibleText("India");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Select country
		
		WebElement selectcountry=driver.findElement(By.xpath("//span[@aria-labelledby='select2-country-container']"));

		selectcountry.click();
		for(int i=1;i<=5;i++)
		selectcountry.sendKeys(Keys.ARROW_DOWN);
		selectcountry.sendKeys(Keys.ENTER);

		// DOB
		
		WebElement year= driver.findElement(By.id("yearbox"));
		
		WebElement month= driver.findElement(By.xpath("//select[@placeholder='Month']"));
		
		WebElement day=driver.findElement(By.id("daybox"));
		
		Select s1= new Select(year);
		
		s1.selectByVisibleText("2000");
		
		Select s2= new Select(month);
		
		s2.selectByVisibleText("October");
		
		Select s3= new Select(day);
		
		s3.selectByVisibleText("25");
		
		
		//password
		
		driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys(prop.getProperty("firstpwd"));
		
		driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys(prop.getProperty("secpwd"));
		
		driver.findElement(By.xpath("//button[@id='submitbtn']")).click();
		
}

	@Test(priority=4)
public void handlingWindows() throws InterruptedException {
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("http://demo.automationtesting.in/Register.html");
	
	driver.findElement(By.xpath("//a[@class='link facebook']")).click();
	
	Set<String> handler=driver.getWindowHandles();
	
	Iterator<String> i1=handler.iterator();
	
	String pWindow=i1.next();
	
	System.out.println("parent window"+pWindow);
	
	String cWindow=i1.next();
	
	System.out.println("child window"+cWindow);
	
	
	driver.switchTo().window(cWindow);
	Thread.sleep(2000);
	System.out.println("Child window tilt"+driver.getTitle());
	
	driver.close();
	
	
	
	}	
	
}





