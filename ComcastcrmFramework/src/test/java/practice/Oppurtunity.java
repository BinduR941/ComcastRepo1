package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.javaUtility.JavaUtility;


public class Oppurtunity {
	//Go to oppurtunity tab click +btn child window opens click search now verify the message and go back to parent window click save alrt popup comes 
	//click ok.

	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility flib = new FileUtility();
		ExcelUtility e = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String Browser = flib.getDataFromPropertyFile("browser");
		String Url = flib.getDataFromPropertyFile("url");
		String Username = flib.getDataFromPropertyFile("username");
		String Passowrd = flib.getDataFromPropertyFile("password");

		WebDriver driver = null;
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();

		} else {
			driver = new ChromeDriver();

		}
		driver.get(Url);
		Thread.sleep(2000);
		driver.findElement(By.name("user_name")).sendKeys(Username);
		Thread.sleep(2000);
		driver.findElement(By.name("user_password")).sendKeys(Passowrd);
		Thread.sleep(2000);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Opportunity...\"]")).click();
		driver.findElement(By.xpath("//input[@id='related_to']/following-sibling::img")).click();
		wlib.switchtoTabBasedOnUrl(driver, "Accounts&action");
		driver.findElement(By.xpath("//input[@type=\"button\"]")).click();

		Thread.sleep(2000);
		boolean result = driver.findElement(By.xpath("//span[text()='No Organizations Found !']")).isDisplayed();
		if (result == true) {
			System.out.println("No organizations found message is displayed and pass");
		} else {
			System.out.println("No organizations found message is displayed and fail");
		}
		driver.close();

		System.out.println("=============BACK TO ParentWindow================");

		// Back to parent window
		wlib.switchtoTabBasedOnUrl(driver, "Potentials&action");
		// switching to alert and clicking ok
		driver.findElement(By.xpath("(//input[@title=\"Save [Alt+S]\"])[1]")).click();
		wlib.switchtoAlertAndAccept(driver);
	}

}
