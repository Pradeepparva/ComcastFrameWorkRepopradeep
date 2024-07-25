package com.comcast.crm.contacttest;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;

public class CreateContactWithOrgTest extends BaseClass{

	@Test
	public void CreateCOntactWIthOrg() throws Throwable, IOException {

		String orgname=elib.getDataFromExcelFile("org", 1, 2)+jlib.getRandomNumber();
		String lastname=elib.getDataFromExcelFile("contact", 1, 2)+jlib.getRandomNumber();

		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);
			
			//verify header message with expected result
			String headerinfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(headerinfo.contains(orgname)) {
				System.out.println(orgname +" is created == pass");
			}
			else {
				System.out.println(orgname+" is not created == Fail");
			}
			
			//verify the header org name with expected result
			String projid=driver.findElement(By.id("dtlview_Organization Name")).getText();
			if(projid.equals(orgname)) {
				System.out.println(projid+" is visible");
			}
			
			
			//create contact 
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			driver.findElement(By.name("lastname")).sendKeys(lastname);
			
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			
			while(it.hasNext()) {
				String wid = it.next();
				driver.switchTo().window(wid);
				
				String acturl=driver.getCurrentUrl();
				if(acturl.contains("module=Accounts")) {
					break;
				}
			}
			
			driver.findElement(By.name("search_text")).sendKeys(orgname);
			driver.findElement(By.name("search")).click();
			driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
			
			Set<String> set1 = driver.getWindowHandles();
			Iterator<String> it1 = set1.iterator();
			
			while(it1.hasNext()) {
				String wid = it1.next();
				driver.switchTo().window(wid);
				
				String acturl=driver.getCurrentUrl();
				if(acturl.contains("Contacts&action")) {
					break;
				}
			
			
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			//verify header msg with expected result
			String lastnameinfo=driver.findElement(By.id("dtlview_Last Name")).getText();
			if(lastnameinfo.contains(lastname)) {
				System.out.println(lastname +" is created == pass");
			}
			else {
				System.out.println(lastname+" is not created == Fail");
			}
			
			}		
	}

	}
