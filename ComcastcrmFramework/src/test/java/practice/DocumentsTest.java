package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javaUtility.JavaUtility;


public class DocumentsTest {

	
		public static void main(String[] args) throws IOException, InterruptedException {
			FileUtility flib=new FileUtility();
			ExcelUtility e=new ExcelUtility();
			JavaUtility jlib =new JavaUtility();
			WebDriverUtility wlib=new WebDriverUtility();
			
			String Browser = flib.getDataFromPropertyFile("browser");
			String Url = flib.getDataFromPropertyFile("url");
			String Username =flib.getDataFromPropertyFile("username");
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
			driver.findElement(By.linkText("Documents")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//img[@alt=\"Create Document...\"]")).click();
			Thread.sleep(3000);
			WebElement scrolltoele = driver.findElement(By.xpath("//select[@name=\"filelocationtype\"]"));
			Thread.sleep(3000);
			wlib.scrollToElement(driver, scrolltoele);
			Thread.sleep(3000);
			WebElement dropdown = driver.findElement(By.xpath("//select[@name=\"filelocationtype\"]"));
			Thread.sleep(3000);
			wlib.selectByVisibletext(dropdown, "External");
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//input[@value=\"  Cancel  \"])[2]")).click();
			Thread.sleep(3000);
			String docpage = driver.findElement(By.linkText("Documents")).getText();
			System.out.println(docpage);
	}

}
