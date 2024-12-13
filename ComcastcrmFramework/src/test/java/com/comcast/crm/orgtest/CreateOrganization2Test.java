package com.comcast.crm.orgtest;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.WebDriverUtility.UtilityClassObject;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.listenerutility.ListenerImplementaionClass;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OgranizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

@Listeners(com.comcast.crm.listenerutility.ListenerImplementaionClass.class)
public class CreateOrganization2Test extends BaseClass {
	WebDriverUtility wlib=new WebDriverUtility();
	@Test(groups="smokeTest")
	public void createOrgTest() throws InterruptedException, IOException {
		
		
		System.out.println("createcon");
		

		// FileUtility fb=new FileUtility();
		// String url=fb.getDataFromPropertyFile("url");
		// WebDriver driver=new ChromeDriver();

//driver.get(url);
		
//LoginPage lp = PageFactory.initElements(driver, LoginPage.class);//driver-pagefactory should know which browser it has to initialize ele 

//LoginPage lp=new LoginPage(driver);

		/*
		 * lp.getUserName().sendKeys("admin"); lp.getPassword().sendKeys("admin");
		 * lp.getLoginbtn().click(); driver.quit();
		 */
		// OR

		
		//WebDriver driver = null;
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to organization page");
		HomePage h = new HomePage(driver);
		h.orglink();
		Thread.sleep(2000);
//Click createneworg btn
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to create organization page");
		OrganizationPage cn = new OrganizationPage(driver);
		cn.getCreateneworgbtn().click();
//driver.quit();

//to read testscript data from excel file
		//ExcelUtility elib = new ExcelUtility();

//JavaUtility jlib = null;
		//generate random number along with orgname
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String expectedorgname = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomno();
		
//enter orgname and create organization
		UtilityClassObject.getTest().log(Status.INFO,"create organization page");
		CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
		cp.createOrgName(expectedorgname);
		UtilityClassObject.getTest().log(Status.INFO,expectedorgname+"===>Create a New Organization");
		OgranizationInfoPage of = new OgranizationInfoPage(driver);
		Thread.sleep(2000);
		String actualorgname = of.getHeadermsg().getText();
		System.out.println(actualorgname);
		boolean status=actualorgname.contains(expectedorgname);
		//Assert.assertEquals(status, true);
		Assert.assertTrue(status);
		
//String actualorgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		/*if (actualorgname.contains(expectedorgname)) {
			System.out.println(expectedorgname + "is created and pass");
		} else {
			System.out.println(expectedorgname + "is not created and fail");
		}*/
		String actorgnametextfield = of.getActualorgtf().getText();
		System.out.println(actorgnametextfield);
		boolean status1=actorgnametextfield.contains(expectedorgname);
		Assert.assertEquals(status, true);

	/*	if (actorgnametextfield.contains(expectedorgname)) {
			System.out.println(expectedorgname + "is matching and pass");
		} else {
			System.out.println(expectedorgname + "is not matching and fail");
		}*/
		Thread.sleep(2000);

		// Go back to organization page
		h.orglink();
		//search for organization in dynamic web table
		cn.getSearchtf().sendKeys(expectedorgname);

// select and delete org
		WebDriverUtility wb=new WebDriverUtility();
		wb.selectByVisibletext(cn.getSearchdp(), "Organization Name");
		cn.getSearchbtn().click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[text()='" + expectedorgname + "']/../..)[2]/td/a[text()='del']")).click();
		wb.switchtoAlertAndAccept(driver);

	}
	
	@Test(groups="regressionTest")
	public void createOrgwithIndustryAndTypeTest() throws Throwable, Throwable
	{
		//LoginPage lp=new LoginPage(driver);
		//lp.loginTOApp(Username,Passowrd);
		HomePage h = new HomePage(driver);
		h.orglink();
		OrganizationPage cn=new OrganizationPage(driver);
		cn.getCreateneworgbtn().click();
		String orgname = elib.getDataFromExcel("org", 1, 2)+jlib.getRandomno();
		System.out.println(orgname);
		CreateNewOrganizationPage cp=new CreateNewOrganizationPage(driver);
		//cp.createOrgName(orgname);
		Thread.sleep(2000);
		String industry=elib.getDataFromExcel("org", 3, 3);
		System.out.println(industry);
		Thread.sleep(2000);
		//wlib.selectByVisibletext(cp.getIndustrydb(),industry);
		String type =elib.getDataFromExcel("org", 3, 4);
		System.out.println(type);
		cp.createOrgNameWithindandType(orgname, industry, type);
		Thread.sleep(2000);
		System.out.println("done");
		Thread.sleep(2000);
		/*String actualind1 = driver.findElement(By.id("dtlview_Industry")).getText();
		System.out.println(actualind1);*/
		cp.getSavebtn().click();
		Thread.sleep(2000);

		//Verify the dropdown industry and type info
		OgranizationInfoPage of=new OgranizationInfoPage(driver);
		String actualind = of.getActualind().getText();
		System.out.println(actualind);
		Assert.assertEquals(actualind,industry);


		/*if(actualind.equals(industry))
		{
			System.out.println(industry+"info is verified");
		}

		else 
		{
			System.out.println(industry+"info is not verified");
		}*/
		//verify type dropdown 

		  String actualtype = driver.findElement(By.id("dtlview_Type")).getText();
		  Assert.assertEquals(actualtype, type);
		  /*if(actualtype.equals(type)) {
		  System.out.println(type+"is verified and pass"); } else {
		  System.out.println(type +"is not verified and fail"); } */

	}
	@Test(groups="regressionTest")
	public void createOrganizationWithPhoneNumber() throws EncryptedDocumentException, IOException, InterruptedException
	{
		HomePage h = new HomePage(driver);
		h.orglink();
		OrganizationPage cn=new OrganizationPage(driver);
		cn.getCreateneworgbtn().click();
		String expectedorgname = elib.getDataFromExcel("org", 1,2)+jlib.getRandomno();
		System.out.println(expectedorgname);
		CreateNewOrganizationPage cp=new CreateNewOrganizationPage(driver);
		cp.createOrgName(expectedorgname);
		String expectedphno = elib.getDataFromExcel("org", 4, 3);
		System.out.println(expectedorgname);
		cp.getPhno().sendKeys(expectedphno);
		OgranizationInfoPage of=new OgranizationInfoPage(driver);
		Thread.sleep(2000);
		String actualphno = cp.getActualphno().getText();
		//Verify Header phoneno
		Assert.assertEquals(actualphno, expectedphno);
		/*{
			System.out.println(expectedphno+"is created and pass");
		}
		{
			System.out.println(expectedphno+"is not created and fail");
		}*/

		String actualorgname1 = cp.getActualorgname().getText();
		Assert.assertEquals(actualorgname1, expectedorgname);
		/* if(actualorgname.equals(expectedorgname)){
		  System.out.println(expectedorgname + "is matching and pass");
		  }
		 else {
		  System.out.println(expectedorgname + "is not matching and fail");
		  }*/
		 
	}
	
	

}
