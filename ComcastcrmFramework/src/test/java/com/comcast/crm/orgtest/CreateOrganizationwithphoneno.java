package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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

import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javaUtility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OgranizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrganizationwithphoneno {

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

driver.get(Url);
Thread.sleep(2000);
LoginPage lp=new LoginPage(driver);
lp.loginTOApp(Username,Passowrd);
HomePage h = new HomePage(driver);
h.orglink();
OrganizationPage cn=new OrganizationPage(driver);
cn.getCreateneworgbtn().click();
String expectedorgname = e.getDataFromExcel("org", 1,2)+jlib.getRandomno();
System.out.println(expectedorgname);
CreateNewOrganizationPage cp=new CreateNewOrganizationPage(driver);
cp.createOrgName(expectedorgname);
String expectedphno = e.getDataFromExcel("org", 4, 3);
System.out.println(expectedorgname);
cp.getPhno().sendKeys(expectedphno);
OgranizationInfoPage of=new OgranizationInfoPage(driver);
Thread.sleep(2000);
String actualphno = cp.getActualphno().getText();
//Verify Header phoneno
if(actualphno.equals(expectedphno))
{
	System.out.println(expectedphno+"is created and pass");
}
else
{
	System.out.println(expectedphno+"is not created and fail");
}

String actualorgname = cp.getActualorgname().getText();
 if(actualorgname.equals(expectedorgname)){
  System.out.println(expectedorgname + "is matching and pass");
  }
 else {
  System.out.println(expectedorgname + "is not matching and fail");
  }
 
	}

}
