package practice_testNG;

import static org.testng.Assert.assertEquals;

import java.sql.SQLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.listenerutility.ListenerImplementaionClass;

@Listeners(com.comcast.crm.listenerutility.ListenerImplementaionClass.class)
public class Sample_reportUsing_ExtentreportAndScreenshot extends BaseClass{
   
	@Test
	public void createContact1Test()
	{
		System.out.println("-- executions starts --");
		//TakesScreenshot ts=(TakesScreenshot)driver;
		//String filepath=ts.getScreenshotAs(OutputType.BASE64);
		//ExtentTest test = report.createTest("createContact1Test");
//	    test.log(Status.INFO, " appn1");
//		test.log(Status.INFO, "navigate");
//		if("hdf".equals("hdfc"))
//		{
//			test.log(Status.PASS, "contact is created");
//		}
//		else 
//		{
//			test.log(Status.FAIL, "contact is not created");
//			test.addScreenCaptureFromBase64String(filepath, "ErrorFile");
//		}
		Assert.fail();
//		test.log(Status.FAIL, "Failed");
		//test.addScreenCaptureFromBase64String(filepath, "ErrorFile");
		System.out.println("-- executions ends --");
	}
	
}
