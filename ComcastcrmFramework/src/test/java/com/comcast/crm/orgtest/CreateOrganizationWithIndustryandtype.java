package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javaUtility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OgranizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrganizationWithIndustryandtype {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileUtility flib=new FileUtility();
		ExcelUtility e=new ExcelUtility();
		JavaUtility jlib =new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
String Browser = flib.getDataFromPropertyFile("browser");
String Url = flib.getDataFromPropertyFile("url");
String Username = flib.getDataFromPropertyFile("username");
String Passowrd = flib.getDataFromPropertyFile("password");


WebDriver driver=null;
if(Browser.equals("chrome"))
{
	driver=new ChromeDriver();
}
else if(Browser.equals("firefox"))
{
	driver=new FirefoxDriver();
}
else if(Browser.equals("edge"))
{
	driver=new EdgeDriver();

}
else 
{
	driver=new ChromeDriver();
	
}
int randomno = jlib.getRandomno();

driver.get(Url);

wlib.maximizepage(driver);
Thread.sleep(2000);
LoginPage lp=new LoginPage(driver);
lp.loginTOApp(Username,Passowrd);
HomePage h = new HomePage(driver);
h.orglink();
OrganizationPage cn=new OrganizationPage(driver);
cn.getCreateneworgbtn().click();
String orgname = e.getDataFromExcel("org", 1, 2)+jlib.getRandomno();
System.out.println(orgname);
CreateNewOrganizationPage cp=new CreateNewOrganizationPage(driver);
//cp.createOrgName(orgname);
Thread.sleep(2000);
String industry=e.getDataFromExcel("org", 3, 3);
System.out.println(industry);
Thread.sleep(2000);
//wlib.selectByVisibletext(cp.getIndustrydb(),industry);
String type =e.getDataFromExcel("org", 3, 4);
System.out.println(type);
cp.createOrgNameWithindandType(orgname, industry, type);
Thread.sleep(2000);
System.out.println("done");
Thread.sleep(2000);
//String actualind1 = driver.findElement(By.id("dtlview_Industry")).getText();
//System.out.println(actualind1);
cp.getSavebtn().click();
Thread.sleep(2000);

//Verify the dropdown industry and type info
OgranizationInfoPage of=new OgranizationInfoPage(driver);
String actualind = of.getActualind().getText();
System.out.println(actualind);



if(actualind.equals(industry))
{
	System.out.println(industry+"info is verified");
}

else 
{
	System.out.println(industry+"info is not verified");
}
//verify type dropdown 

  String actualtype = driver.findElement(By.id("dtlview_Type")).getText();
  if(actualtype.equals(type)) {
  System.out.println(type+"is verified and pass"); } else {
  System.out.println(type +"is not verified and fail"); }
  Thread.sleep(2000);
  
 

h.signout(driver);
/*
 * String actorgnametextfield =
 * driver.findElement(By.id("mouseArea_Organization Name")).getText();
 * System.out.println(actorgnametextfield);
 * 
 * if(actorgnametextfield.equals(orgname)) { System.out.println(orgname +
 * "is matching and pass"); } else { System.out.println(orgname +
 * "is not matching and fail"); }
 */
 
	}

}
