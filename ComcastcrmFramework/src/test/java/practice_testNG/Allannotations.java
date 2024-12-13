package practice_testNG;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Allannotations {
	@BeforeSuite
	public void configBS()
	{
		System.out.println("Excec BS");
	}
	
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class");
	}
	@Test
	public void createOrg()
	{
		System.out.println("Excec CC");
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Excec BM");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Excec AM");
	}
	
	@Test
	public void createContactWithDate()
	{
		System.out.println(" Excec CCD");
	}
	
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
	}
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("Excec AS");
	}

}

