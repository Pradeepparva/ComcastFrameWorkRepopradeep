package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact {
	
	WebDriver driver;
	public CreateNewContact(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//a[text()='Contacts']")
	private WebElement Contactlnk;
	
	@FindBy(xpath ="//img[@alt='Create Contact...']")
	private WebElement Contactimgbtn;
	
	@FindBy(name = "lastname")
	private WebElement LastNameEdt;
	
	@FindBy(id = "mobile")
	private WebElement PhoneNumEdt;
	
	@FindBy(xpath ="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;
	
	public WebElement getContactlnk() {
		return Contactlnk;
	}

	public WebElement getContactimgbtn() {
		return Contactimgbtn;
	}

	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getPhoneNumEdt() {
		return PhoneNumEdt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void createContact(String lastname) {
		Contactlnk.click();
		Contactimgbtn.click();
		LastNameEdt.sendKeys(lastname);
		savebtn.click();
	}
	
	public void createContactWithPhnNum(String lastname, String mobile) {
		Contactlnk.click();
		Contactimgbtn.click();
		LastNameEdt.sendKeys(lastname);
		PhoneNumEdt.sendKeys(mobile);
		savebtn.click();
	}

}
