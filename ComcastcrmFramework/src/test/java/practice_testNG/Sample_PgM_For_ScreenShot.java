package practice_testNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;


@Listeners(com.comcast.crm.listenerutility.ListenerImplementaionClass.class)
public class Sample_PgM_For_ScreenShot extends BaseClass {
	@Test
	public void createInvoiceTest()
	{
		System.out.println("execute createinvoicetest");
		//String acttitle=driver.getTitle();
		//System.out.println(acttitle);
		Assert.assertEquals(true, true);
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");
		
}
	@Test
	public void createInvoiceWithContactTest()
	{
		System.out.println("execute createInvoiceWithContactTest");
		//String acttitle=driver.getTitle();
		Assert.assertEquals(true, false);
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");
	}
	
	
	//@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImplementation.class)
/*	public void activateSim()
	{
		System.out.println("execute createInvoiceWithContactTest");
		String acttitle=driver.getTitle();
		Assert.assertEquals(acttitle, "Home");
		//Assert.assertEquals("", "login");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");*/
	}
	

