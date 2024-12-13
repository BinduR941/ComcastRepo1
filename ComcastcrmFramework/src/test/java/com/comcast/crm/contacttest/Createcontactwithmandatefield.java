package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javaUtility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OgranizationInfoPage;
import com.comcast.crm.objectrepositoryutility._CreateContactPage;


@Listeners(com.comcast.crm.listenerutility.ListenerImplementaionClass.class)
public class Createcontactwithmandatefield extends BaseClass {
	WebDriverUtility wlib=new WebDriverUtility();
	ExcelUtility e=new ExcelUtility();
	@Test(groups="smokeTest")
	public void createContactWithManField() throws EncryptedDocumentException, IOException, InterruptedException {

		_CreateContactPage cc = new _CreateContactPage(driver);
		
		HomePage h = new HomePage(driver);
		Thread.sleep(2000);
		cc.getContactbtn().click();
		cc.getCreateContact().click();
		Thread.sleep(2000);
		String expectedlastname = elib.getDataFromExcel("Contact", 1, 2);
		System.out.println(expectedlastname);
		cc.getExpecsendlastname().sendKeys(expectedlastname);
		Thread.sleep(2000);
		CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
		cp.getSavebtn().click();
		String actuallsname = cc.getActlastnametxt().getText();
		System.out.println(actuallsname);
		boolean status=expectedlastname.contains(actuallsname);
		System.out.println("boolean:"+status);
		Assert.assertEquals(status, true);
		/*if (expectedlastname.contains(actuallsname)) {
			System.out.println(expectedlastname + "is verified and pass");
		} else {
			System.out.println(expectedlastname + "is not verified and fail");
		}*/
	}
	
	@Test
	public void createContactWithOrganization() throws EncryptedDocumentException, IOException, InterruptedException
	{
		_CreateContactPage cc = new _CreateContactPage(driver);
	    cc.getOrgbtn().click();
		Thread.sleep(5000);
		cc.getCreateorgicon().click();
		
		String expectedorgname = elib.getDataFromExcel("Contact", 3, 3)+jlib.getRandomno();

		Thread.sleep(2000);
       
        cc.getOrgnametb().sendKeys(expectedorgname);
        cc.getContactsavebtn().click();
        
		
	    String Actualorgnameheadertext = cc.getOrgheader().getText();
	    System.out.println(Actualorgnameheadertext);
	    boolean status1=Actualorgnameheadertext.contains(expectedorgname);
	    System.out.println("boolean:"+status1);
	    Assert.assertEquals(status1, true);
		/*if (Actualorgnameheadertext.contains(expectedorgname)) {
			System.out.println(expectedorgname + "is created and pass");
		} else {
			System.out.println(expectedorgname + "is not created and fail");
		}*/
		
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
				boolean status2 = contact.contains(expectedcontactlastname);
				System.out.println("boolean:"+status2);
				Assert.assertEquals(status2, true);
				/*if(contact.contains(expectedcontactlastname))
				{
					System.out.println("contact is matching and pass" );
				}
				else 
				{
					System.out.println("contact is matching and fail");
				}*/
	}
	

		
		@Test(groups="regressionTest")
		public void createContactWithSupportDate() throws InterruptedException, EncryptedDocumentException, IOException
		{
			FileUtility flib=new FileUtility();
		ExcelUtility e=new ExcelUtility();
		JavaUtility jlib =new JavaUtility();
		_CreateContactPage cc = new _CreateContactPage(driver);
		cc.getContactbtn().click();
		cc.getCreateContact().click();
	String expectedlastname = elib.getDataFromExcel("Contact", 5, 2);
		cc.getExpecsendlastname().sendKeys(expectedlastname);
		String startdate=jlib.getSystemDateYYYYDDMM();
		System.out.println(startdate);
		String enddate=jlib.getRequiredDateyyyMMdd(30);
		System.out.println(enddate);
        cc.getStartdate().clear();
		cc.getStartdate().sendKeys(startdate);
		cc.getEndate().clear();
		cc.getEndate().sendKeys(enddate);
		cc.getContactsavebtn().click();
		
		//oi.getSavebtn().click();

		// Date validation\
		String actstartdatetext =cc.getVerificationstartdate().getText();
		System.out.println(actstartdatetext);
		String actenddatetext = cc.getVerificationenddate().getText();
		System.out.println(actenddatetext);
		boolean status3=startdate.contains(actstartdatetext);
		System.out.println("boolean:"+status3);
		Assert.assertEquals(status3, true);
		/*if(startdate.contains(actstartdatetext))
		{
			System.out.println(startdate+"info is  verified and pass");
		}
		else 
		{
			System.out.println(startdate+"info is not verified and fail");
		}*/
		

	}

}
