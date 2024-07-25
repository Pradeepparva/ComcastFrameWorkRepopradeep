package com.comcast.crm.BaseTest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.Login;

import comcast.crm.generic.databaseutilities.DataBaseUtility;


public class BaseClass {
	
	public DataBaseUtility dblib=new DataBaseUtility();
	public FileUtility flib=new FileUtility();
	public ExcelUtility elib=new ExcelUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println("===Connect DB , Report Config====");
		dblib.getDbConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		
	}
	@BeforeClass
	public void configBC() throws IOException {
			System.out.println("===Launch the browser===");
			String BROWSER = flib.getDataFromPropertiesFile("browser");
			
			  if(BROWSER.equals("chrome")) { 
				  driver=new ChromeDriver(); 
		     } else if(BROWSER.equals("firefox")) {
			 driver=new FirefoxDriver(); 
			 }
		     else {
			  driver=new ChromeDriver(); 
			  }
			  sdriver=driver;
	}
	
	@BeforeMethod
	public void configBM() throws IOException {
		System.out.println("===Login===");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		Login lp=new Login(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("===Logout===");
		Home hp=new Home(driver);
		hp.logOut();
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("===Close the browser===");
		driver.close();
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("==== close the DB, Report backup====");
		dblib.closeDbConnection();
		
	}

}
