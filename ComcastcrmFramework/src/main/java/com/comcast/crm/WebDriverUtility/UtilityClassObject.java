package com.comcast.crm.WebDriverUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();//to share testobject into multiple threads
public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();// to share driver object into multiple threads.

public static ExtentTest getTest(){ //This method will give the extent report object for multiple threads.
	return test.get();
}

public static void setTest(ExtentTest actTest)
{
	test.set(actTest);
}
public static WebDriver getDriver(){//to access the driver object
	return driver.get();
}

public static void setDriver(WebDriver actDriver)//to use the driver object
{
	driver.set(actDriver);
}
}
