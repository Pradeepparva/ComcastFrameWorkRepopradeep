package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
	WebDriver driver;
	public Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orglink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignlnk;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	
	public WebElement getSignoutLink() {
		return signoutLink;
	}


	public WebElement getAdminimg() {
		return adminimg;
	}

	public WebElement getContactlnk() {
		return contactlnk;
	}


	public WebElement getCampaignlnk() {
		return campaignlnk;
	}


	public WebElement getOrglink() {
		return orglink;
	}


	public WebElement getMoreLink() {
		return moreLink;
	}
	
	public void navigateToCampaignPage() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignlnk.click();
	}
	
	public void logOut() {
		Actions act = new Actions(driver);
		act.moveToElement(adminimg).perform();
		signoutLink.click();
	}

}
