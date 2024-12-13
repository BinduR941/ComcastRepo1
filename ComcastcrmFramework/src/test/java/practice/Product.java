package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javaUtility.JavaUtility;


public class Product {
	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility flib = new FileUtility();
		ExcelUtility e = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String Browser = flib.getDataFromPropertyFile("browser");
		String Url = flib.getDataFromPropertyFile("url");
		String Username = flib.getDataFromPropertyFile("username");
		String Passowrd = flib.getDataFromPropertyFile("password");


		WebDriver driver=null;
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(Browser.equals("edge"))
		{
			driver=new EdgeDriver();

		}
		else 
		{
			driver=new ChromeDriver();

		}
		driver.get(Url);
		Thread.sleep(2000);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		Thread.sleep(2000);
		driver.findElement(By.name("user_password")).sendKeys(Passowrd);
		Thread.sleep(2000);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Product...\"]")).click();
		driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys("Bluetooth");
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		driver.navigate().back();
		driver.navigate().back();
		WebElement Select = driver.findElement(By.xpath("//select[@name=\"search_field\"]"));
		wlib.selectByVisibletext(Select, "Product Name");
         driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys("Lap1");
         driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys(Keys.ENTER);
         String actualtext = driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td/a[text()='Bluetooth']")).getText();
        System.out.println(actualtext);
		driver.findElement(By.xpath("//input[@onclick=\"callSearch('Basic');\"]")).click();
		//String actualtext = driver.findElement(By.linkText("Board")).getText();
}
}
