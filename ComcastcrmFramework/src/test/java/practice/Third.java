package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Third {	
	public static void main(String[] args) throws InterruptedException {

	

	
WebDriver driver=new ChromeDriver();
driver.get("https://www.amazon.in/");
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15 pro max");
driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);

	}

}
