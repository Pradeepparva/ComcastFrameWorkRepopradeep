package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationPage {
	
	WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement selindu;
	
	@FindBy(name="submit")
	private WebElement searchbtn;
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSelindu() {
		return selindu;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
	public void searchDynOrgName(String orgname, String industry) {
		searchEdt.sendKeys(orgname);
		Select sel=new Select(selindu);
		sel.selectByVisibleText(industry);
		searchbtn.click();
	}
	
	
}
