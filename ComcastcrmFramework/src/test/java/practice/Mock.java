package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mock {

	public static void main(String[] args) throws InterruptedException {
WebDriver driver=new ChromeDriver();
driver.manage().deleteAllCookies();
driver.manage().window().maximize();
driver.get("https://olympics.com/en/olympic-games/tokyo-2020");
Thread.sleep(5000);
//WebElement scrollele = driver.findElement(By.xpath("//a[@href=\"/en/olympic-games/tokyo-2020/athletes\" and @class=\"primary\"]"));
WebElement scrollele =driver.findElement(By.xpath("//h2[text()=\"Featured Athletes\"]/ancestor::div[@class=\"sc-330a00-2 esscjO\"]/descendant::a[text()=\"All Athletes\"]"));
Thread.sleep(2000);
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
wait.until(ExpectedConditions.visibilityOf(scrollele)).click();
//wait.until(ExpectedConditions.elementToBeClickable(scrollele));

/*Actions a=new Actions(driver);
a.scrollToElement(scrollele).click().perform();*/

	}

}
