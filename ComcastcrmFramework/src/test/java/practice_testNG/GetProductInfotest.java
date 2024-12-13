package practice_testNG;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfotest {

	@Test(dataProvider="getData")
	public void prod_info(String brandname, String Productname) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in");
		//search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
	Thread.sleep(2000);
		 String path = "(//span[text()='"+Productname+"'])[1]/ancestor::div[@class='puisg-row']/descendant::span[@class=\"a-price\"]";
		Actions actions = new Actions(driver);
		
		Thread.sleep(2000);
		 WebElement price = driver.findElement(By.xpath(path));
		actions.moveToElement(price).perform();
		System.out.println(price.getText());
		driver.quit();
	}
	
	@DataProvider 
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility elib=new ExcelUtility();
		int rowcount = elib.getRowcount("Product");
		Object[][] objarr=new Object[rowcount] [2];
		for(int i=0;i<rowcount;i++) {
		objarr[i][0]=elib.getDataFromExcel("Product", i+1,0);
		objarr[i][1]=elib.getDataFromExcel("Product", i+1,1);
		}

		
		/*
		 * objarr[1][0]="Apple iPhone 15 Pro Max";
		 * objarr[1][1]="Apple iPhone 15 Pro Max (256 GB) - White Titanium";
		 * 
		 * 
		 * objarr[2][0]="Apple iPhone 15 Pro Max";
		 * objarr[2][1]="Apple iPhone 15 Pro Max (512 GB) - Black Titanium";
		 */
		return objarr;
	}
	
}
