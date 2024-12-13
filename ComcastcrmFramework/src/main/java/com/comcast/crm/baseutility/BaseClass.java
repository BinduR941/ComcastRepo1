package com.comcast.crm.baseutility;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.WebDriverUtility.UtilityClassObject;
import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javaUtility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass  {
	public FileUtility fb=new FileUtility();
	public DataBaseUtility db=new DataBaseUtility();
	public ExcelUtility elib=new ExcelUtility();
	public WebDriverUtility wb=new WebDriverUtility();
	public JavaUtility jlib=new JavaUtility();
	public  WebDriver driver=null;
    public static WebDriver sdriver; 
    
  
	@BeforeSuite(alwaysRun = true)
	public void configBS() throws SQLException
	{
		System.out.println("Connnect to DB, Report config");
		db.getDbConnection();
		
	
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void beforeClass(/*String BROWSER*/) throws IOException
	{
		System.out.println("Launch the Browser");

		String BROWSER=fb.getDataFromPropertyFile("browser");
		
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();

		}
		else 
		{
			driver=new ChromeDriver();
			
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		
		wb.waitForPageToLoad(driver);
		String url=fb.getDataFromPropertyFile("url");
		driver.get(url);
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() throws IOException
	{   
		System.out.println("Login to appn");
		
		String Username = fb.getDataFromPropertyFile("username");
		String Password = fb.getDataFromPropertyFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginTOApp(Username, Password);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws InterruptedException
	{
		System.out.println("Logout from appn");
		HomePage hp=new HomePage(driver);
		hp.signout(driver);
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() throws InterruptedException
	{
		System.out.println("close the browser");
	    driver.quit();
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS() throws SQLException
	{
		System.out.println("Close DB, Report Backup");
		db.closedbConnection();


	}
}
