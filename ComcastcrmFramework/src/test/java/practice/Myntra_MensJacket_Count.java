package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.baseutility.BaseClass;

public class Myntra_MensJacket_Count extends BaseClass {

	
public static void main(String[] args) throws InterruptedException {
	

	
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.myntra.com/");
	Thread.sleep(2000);
	driver.manage().window().maximize();
	Thread.sleep(2000);
	Actions a=new Actions(driver);
	WebElement Men =driver.findElement(By.xpath("//a[@class=\"desktop-main\" and text()=\"Men\"]"));
	a.moveToElement(Men).perform();
	Thread.sleep(5000);
  WebElement jackets = driver.findElement(By.xpath("//a[@href=\"/men-jackets\" and text()=\"Jackets\"]"));
  a.moveToElement(jackets).click().perform();
List<WebElement> jackets1 = driver.findElements(By.xpath("//h4[@class=\"product-product\"]"));
int totaljackets = jackets1.size();
System.out.println(totaljackets);
/* WebElement Sortbydd = driver.findElement(By.xpath("//span[text()=\"Recommended\"]"));
 a.moveToElement(Sortbydd).perform();
 Thread.sleep(2000);
 driver.findElement(By.xpath("//input[@type=\"radio\" or @value=\"Customer Rating\"]")).click();*/

		
	}
	
	

}
