package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javaUtility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OgranizationInfoPage;
import com.comcast.crm.objectrepositoryutility._CreateContactPage;

public class CreateContactWithOrganization extends BaseClass{
@Test
public void createContactWithOrg() throws InterruptedException, EncryptedDocumentException, IOException
{

		FileUtility flib=new FileUtility();
		ExcelUtility e=new ExcelUtility();
		JavaUtility jlib =new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		CreateNewOrganizationPage cn=new CreateNewOrganizationPage(driver);
		

		_CreateContactPage cc = new _CreateContactPage(driver);
	    cc.getOrgbtn().click();
		Thread.sleep(5000);
		cc.getCreateorgicon().click();
		
		String expectedorgname = elib.getDataFromExcel("Contact", 3, 3)+jlib.getRandomno();

		Thread.sleep(2000);
       
        cc.getOrgnametb().sendKeys(expectedorgname);
         cn.getSavebtn().click();
        
		
	    String Actualorgnameheadertext = cc.getOrgheader().getText();
	    System.out.println(Actualorgnameheadertext);
		if (Actualorgnameheadertext.contains(expectedorgname)) {
			System.out.println(expectedorgname + "is created and pass");
		} else {
			System.out.println(expectedorgname + "is not created and fail");
		}
		
		// navigate to contact module
		
		// click on create button
		cc.getContactbtn().click();
		cc.getCreateContact().click();
		//cc.createcontactbtn().click();
        Thread.sleep(2000);
		// enter all details and create organization
		String expectedcontactlastname = e.getDataFromExcel("Contact", 3,2);
		Thread.sleep(2000);
        cc.getExpecsendlastname().sendKeys(expectedcontactlastname);
		 Thread.sleep(2000);
	   cc.getCreateorgicon1().click();
		
		//Switching to child window
		wlib.switchtoTabBasedOnUrl(driver, "Accounts&action");
		Thread.sleep(2000);
		cc.getSearchtb().sendKeys(expectedorgname);
		cc.getSearchbtn().click();
		driver.findElement(By.xpath("//a[text()='"+expectedorgname+"']")).click();
		
		//Switching back to parent window
		wlib.switchtoTabBasedOnUrl(driver, "Contacts&action");
		cc.getVerifysavbtn().click();
		Thread.sleep(2000);
		//op.getSavebtn().click();
		Thread.sleep(2000);
			//driver.findElement(By.xpath("//input[@class=\"crmbutton small save\"]")).click();
				String contact=cc.getContactheaderparenwin().getText();
				System.out.println(contact);
				if(contact.contains(expectedcontactlastname))
				{
					System.out.println("contact is matching and pass" );
				}
				else 
				{
					System.out.println("contact is matching and fail");
				}
			
			/*
			 * String actualorgname1= cc.getContactheaderparenwin().getText();
			 * System.out.println(actualorgname1);
			 * if(expectedorgname.contains(actualorgname1)) { System.out.println("pass"); }
			 */
			
			/*
			 * String acorgname =
			 * driver.findElement(By.id("mouseArea_Organization Name")).getText();
			 * System.out.println(acorgname); if(actualorgname.trim().equals(acorgname)) {
			 * System.out.println("passss");*/
			 
			
			
		

	

}
}
