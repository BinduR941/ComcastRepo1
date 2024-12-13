package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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


public class CreateOrgWithAssignedtoradiobtndropdownscroll {


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
			Random r=new Random();
			int randomnum=r.nextInt(1000);
			driver.get(Url);
			Thread.sleep(2000);
			driver.findElement(By.name("user_name")).sendKeys(Username);
			Thread.sleep(2000);
			driver.findElement(By.name("user_password")).sendKeys(Passowrd);
			Thread.sleep(2000);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
			String expectedorgname = e.getDataFromExcel("org", 1,2)+jlib.getRandomno();
			System.out.println(expectedorgname);
			driver.findElement(By.name("accountname")).sendKeys(expectedorgname);
			driver.findElement(By.xpath("(//input[@type=\"radio\"])[2]")).click();
			Thread.sleep(2000);
			WebElement rdbtn = driver.findElement(By.name("assigned_group_id"));
			wlib.selectByVisibletext(rdbtn, "Support Group");
			Thread.sleep(2000);
			WebElement scroll = driver.findElement(By.xpath("//textarea[@name=\"bill_street\"]"));
		     wlib.scrollToElement(driver, scroll);
		     wlib.sendKeysusingActions(driver, scroll, "Bangalore");
			/*
			 * Actions a=new Actions(driver); //Thread.sleep(2000);
			 * a.scrollToElement(scroll).sendKeys(scroll, "Bangalore").perform();
			 */
			driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
			Thread.sleep(2000);
			String actualheadername =driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
			System.out.println(actualheadername);
			String actualorgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(actualheadername.contains(expectedorgname))
			{
				System.out.println(expectedorgname +"is created and pass");
			}
			else {
				System.out.println(expectedorgname+"is not created and fail");
			}
			
	}

}
