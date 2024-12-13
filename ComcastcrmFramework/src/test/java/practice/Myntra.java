package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;



public class Myntra {
public static void main(String[] args) {
	WebDriverUtility wb=new WebDriverUtility();
	WebDriver driver=new ChromeDriver();
	wb.maximizepage(driver);
	driver.get("https://www.myntra.com/");
	WebElement element = driver.findElement(By.xpath("//a[text()='Home & Living' and @class=\"desktop-main\"]"));
	wb.mousemoveOnElement(driver, element);
	WebElement dropdwn = driver.findElement(By.xpath("//a[@data-reactid=\"577\" and text()='Home Décor']"));
	List<WebElement> products = driver.findElements(By.xpath("//a[@data-reactid=\"577\" and text()='Home Décor']/ancestor::ul[@class=\"desktop-navBlock\"]/descendant::a[@class=\"desktop-categoryLink\"]"));
	for(WebElement allproducts:products)
	{
		System.out.println(allproducts.getText());
	}
}
}
