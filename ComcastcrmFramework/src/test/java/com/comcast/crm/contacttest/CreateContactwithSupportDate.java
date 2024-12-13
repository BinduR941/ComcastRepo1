package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

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

import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javaUtility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OgranizationInfoPage;
import com.comcast.crm.objectrepositoryutility._CreateContactPage;

public class CreateContactwithSupportDate extends BaseClass {
	OgranizationInfoPage oi=new OgranizationInfoPage(driver); 
	LoginPage lp=new LoginPage(driver);

	CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
@Test
public void createContactWithSupDate() throws EncryptedDocumentException, IOException, Throwable
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
		if(startdate.contains(actstartdatetext))
		{
			System.out.println(startdate+"info is  verified and pass");
		}
		else 
		{
			System.out.println(startdate+"info is not verified and fail");
		}
		
}
}
/*
 * // Date validation/* String Actstartdate =
 * driver.findElement(By.id("dtlview_Support Start Date")).getText(); String
 * Actenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
 * 
 * if(Actstartdate.equals(startdate)) { System.out.println(startdate+" " +
 * "info is verified and pass"); } else {
 * 
 * System.out.println(startdate+" " + "info is not verified and fail"); }
 * 
 * if(Actenddate.equals(enddate)) { System.out.println(enddate+" "+
 * "info is verified and pass"); } else { System.out.println(enddate+" "+
 * "info is not verified and fail"); }
 * 
 */

