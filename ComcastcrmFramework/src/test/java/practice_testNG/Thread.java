package practice_testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Thread {

	
		@Test(invocationCount = 2,threadPoolSize = 2)
		public void t1()
		{
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.amazon.in/");
			System.out.println("execute");
	}
		public void t2()
		{
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.amazon.in/");
			System.out.println("execute");
	}
		

}
