package practice_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.protobuf.Method;



public class IfElseDoesntFailTc {
	@Test
	public void verifyIfelse(){
		WebDriver driver=new ChromeDriver();
		String expectedPageName = "Home";
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String acttext = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		//HardAssert 
	Assert.assertEquals(acttext, expectedPageName);
		driver.close();
		//System.out.println(mtd.getName()+"Test end");
	}
		
	@Test
	public void verifyLogoInHomePage()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean logo = driver.findElement(By.xpath("//img[@title=\"vtiger-crm-logo.gif\"]")).isEnabled();
		//Hard assert
		Assert.assertTrue(logo);
		driver.close();
		//System.out.println(mtd.getName()+"Test end");
	}
	
		
	

}
