package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class Login extends WebDriverUtility{   //Rule no.1: Create class for Every page of application
	
	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Rule 2: Object Creation
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement submitbtn;
	
//	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
//	private WebElement loginbtn;
	
	//object initialization
	
	//rule 4: object encapsulation
	public WebElement getUserName() {
		return usernameEdt;
	}
	
	public WebElement getPassword() {
		return passwordEdt;
	}
	
//	public WebElement getLoginBtn() {
//		return submitbtn;
//	}
	
	//ruel 5: provide Action
	//these are business utility which is specific to the project
	

	public WebElement getLoginbtn() {
		return submitbtn;
	}
	
	public void loginToApp(String url, String username, String password) {
		
		driver.manage().window().maximize();
		waitForPageToLoad(driver);
		driver.get(url);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitbtn.click();
	}
	
	}


