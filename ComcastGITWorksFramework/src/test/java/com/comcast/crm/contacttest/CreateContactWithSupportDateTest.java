package com.comcast.crm.contacttest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws Throwable {
		
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		ExcelUtility elib = new ExcelUtility();
		
		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");

		String value = elib.getDataFromExcelFile("contact", 1, 2)+jlib.getRandomNumber();
		
		WebDriver driver=null;
		
		  if(BROWSER.equals("chrome")) { 
			  driver=new ChromeDriver(); 
	} else if(BROWSER.equals("firefox")) {
		driver=new FirefoxDriver(); 
		}
	else {
		  driver=new ChromeDriver(); 
		  }
		  
		    driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			
			String actdate = jlib.getSystemDateDDMMYYYY();
			String dateRequired = jlib.getRequiredDateDDMMYYYY(30);
			
			driver.findElement(By.name("lastname")).sendKeys(value);
			
			driver.findElement(By.id("jscal_field_support_start_date")).clear();
			driver.findElement(By.id("jscal_field_support_start_date")).sendKeys(actdate);
			driver.findElement(By.id("jscal_field_support_end_date")).clear();
			driver.findElement(By.id("jscal_field_support_end_date")).sendKeys(dateRequired);
			
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			//verify header msg with expected result
			String lastnameinfo=driver.findElement(By.id("dtlview_Last Name")).getText();
			if(lastnameinfo.contains(value)) {
				System.out.println(value +" is created == pass");
			}
			
			String actstrtdate=driver.findElement(By.id("dtlview_Support Start Date")).toString();
			String supenddate=driver.findElement(By.id("dtlview_Support End Date")).toString();
			
			if(actstrtdate.equals(actdate)) {
				System.out.println(actstrtdate +" is created == pass");
			}
			
			if(supenddate.equals(dateRequired)) {
				System.out.println(supenddate +" is created == pass");
			}
			
			driver.quit();

	}

}
