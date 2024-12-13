package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.WebDriverUtility.UtilityClassObject;
import com.comcast.crm.baseutility.BaseClass;




public class ListenerImplementaionClass implements ITestListener,ISuiteListener{
	public ExtentSparkReporter spark;
    public static ExtentReports report; //inorder to use the report in every testscript
    public static ExtentTest test; //To use this testscript it has been made as static
    
	@Override
	public void onStart(ITestContext context) {
         System.out.println("Report config");
         String time=new Date().toString().replace(" ", "_").replace(":", "_");
		
		spark=new ExtentSparkReporter("./Advance_Report/report_"+time+".html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");//Name of the Report 
		spark.config().setTheme(Theme.DARK);//Theme of the report
		
		//add environment info and create test
		report=new  ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	
	

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}
	
	@Override
	public void onTestStart(ITestResult result) { //it gets executed before executing each testcase to insert testcase inside extent report.
		System.out.println(""+result.getMethod().getMethodName()+">=====Start=======");//displays name of the tc
      test=report.createTest(result.getMethod().getMethodName());
       UtilityClassObject.setTest(test);
     test.log(Status.INFO, result.getMethod().getMethodName()+"=====>Started<=====");//before execution of every
     //testcase this message will be inserted
     
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(""+result.getMethod().getMethodName()+">=====END=======");//displays name of the tc
		 test.log(Status.PASS, result.getMethod().getMethodName()+"=====>Completed<=====");
	
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String testcaseName = result.getMethod().getMethodName();
	
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		String srcfile = ts.getScreenshotAs(OutputType.BASE64);
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(srcfile, testcaseName+"_"+time);//for multiple ss.
	
	 /*  File destfile = new File("./Screenshot/"+testcaseName+" + "+time+".png");
		 try {
			FileHandler.copy(srcfile, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
					
		test.addScreenCaptureFromPath(testcaseName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"=====Failed=====");
		test.log(Status.FAIL, result.getThrowable());
		 
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	   String testcasename=result.getMethod().getMethodName();
	   test.log(Status.SKIP, result.getMethod().getMethodName()+"=====>skipped<=====");
	}




	

	
}
