package practice_testNG;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.javaUtility.JavaUtility;


public class Sample_Report_Using_ExtentReport {

	
	
	@Test 
	public void createContactTest()
	{
//		JavaUtility jb=new JavaUtility();
//		//spark report config
//		ExtentReports report= new ExtentReports();
//		String time=new Date().toString().replace(" ", "_").replace(":", "_");
//		
//		ExtentSparkReporter spark=new ExtentSparkReporter("./Advance_Report/report"+time+".html");
//		report.attachReporter(spark);
//		spark.config().setDocumentTitle("CRM Test Suite Result");
//		spark.config().setReportName("CRM Report"+time);//Name of the Report 
//		ExtentTest test = report.createTest("createContactTest");
//	     test.log(Status.INFO,"login to app");//test.log using instead of sopln statement and it is mandate to provide status i.e.,Status.INFO 
//	     test.log(Status.INFO,"naviagte to co");
//	     test.log(Status.INFO,"create contact");
//		if("hdfc".equals("hdfc"))
//		{
//			 test.log(Status.PASS,"contact is created");
//		}
//		else 
//		{
//			 test.log(Status.FAIL,"contact is not created");
//		}
//		report.flush();
		
	}
	
	@Test
	public void createContactWithOrgTest()
	{
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		ExtentReports report= new ExtentReports();
//		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		JavaUtility jlib = new JavaUtility();
		String time = jlib.getSystemDateYYYYDDMM();
		
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReport/report_"+time+".html");
		
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report"+time);//Name of the Report 
		report.attachReporter(spark);
		
		System.out.println("create report");
		
		ExtentTest test = report.createTest("createContactWithOrgTest");
	     test.log(Status.INFO,"login to app");//test.log using instead of sopln statement and it is mandate to provide status i.e.,Status.INFO 
	     test.log(Status.INFO,"naviagte to co");
	     test.log(Status.INFO,"create contact");
	     
	     Assert.assertEquals("1234", "12");
	     test.log(Status.FAIL,"create contact --> failed");
	     
	     report.flush();
	
	}
	
	@Test
	public void createContactWithPhoneNoTest()
	{
//		ExtentReports report= new ExtentReports();
//		ExtentTest test = report.createTest("createContactWithPhoneNoTest");
//	     test.log(Status.INFO,"login to app");//test.log using instead of sopln statement and it is mandate to provide status i.e.,Status.INFO 
//	     test.log(Status.INFO,"naviagte to co");
//	     test.log(Status.INFO,"create contact");
//		Assert.assertEquals("777", "yyy");
		
	}
		
	}


