package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreateNewContact;

public class CreateContactTest extends BaseClass{

	@Test
	public void createContact() throws Throwable {
		
		String lastName=elib.getDataFromExcelFile("contact", 1, 2)+jlib.getRandomNumber();
		  
		CreateNewContact cnc=new CreateNewContact(driver);
		cnc.createContact(lastName);
			
		//verify header message with expected result
		String lastnameinfo=driver.findElement(By.id("dtlview_Last Name")).getText();
		Assert.assertEquals(lastnameinfo, lastName);
	}

}
