package practice;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class MM {

	/*public static void main(String[] args) throws InterruptedException {
		WebDriverUtility wb=new WebDriverUtility();
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
     WebElement Sortbydd = driver.findElement(By.xpath("//span[text()=\"Recommended\"]"));
     a.moveToElement(Sortbydd).perform();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//input[@type=\"radio\" or @value=\"Customer Rating\"]")).click();

    //Thread.sleep(2000);
   // a.moveToElement(Customerrating).click().perform();
	}*/
	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.myntra.com/");
	WebElement men = driver.findElement(By.xpath("//a[@class=\"desktop-main\" and text()='Men']"));
    Actions a=new Actions(driver);
    a.moveToElement(men).perform();
    driver.findElement(By.xpath("//a[text()='Jackets']")).click();
    WebElement ele = driver.findElement(By.xpath("//div[@class=\"sort-sortBy\"]"));
    Actions a1=new Actions(driver);
    a1.moveToElement(ele).perform();
    Thread.sleep(1000);
    //driver.findElement(By.xpath("//input[@type=\"radio\" and @value=\"Customer Rating\"]")).click();
    List<WebElement> ele2 = driver.findElements(By.xpath("//ul[@class=\"sort-list\"]/ancestor::div[@class=\"sort-sortBy\"]/descendant::li"));
    for(WebElement rec:ele2)
    {
    	String text = rec.getText();
    	if(text.equalsIgnoreCase("Customer Rating"))
    	{
    		rec.click();
    	}
    }
    driver.findElement(By.xpath("//input[@class=\"desktop-searchBar\" and @placeholder=\"Search for products, brands and more\"]")).sendKeys("Mango Men");
    driver.findElement(By.xpath("//input[@data-reactid=\"907\"]")).sendKeys(Keys.ENTER);
   // driver.findElement(By.xpath("(//div[@class=\"product-productMetaInfo\"])[6]"));
    Thread.sleep(2000);
    driver.findElement(By.xpath("//img[@alt=\"MANGO MAN V-Neck Pure Cotton Slim Fit T-shirt\" and @src=\"https://assets.myntassets.com/dpr_2,q_60,w_210,c_limit,fl_progressive/assets/images/30239181/2024/8/2/5026e102-aa57-46fa-abea-f322c5bfe3db1722599465229-MANGO-MAN-V-Neck-Pure-Cotton-Slim-Fit-T-shirt-83817225994649-1.jpg\"]")).click();
    Thread.sleep(2000);
    //driver.findElement(By.xpath("//p[@class=\"size-buttons-unified-size\" and text()=\"S\"]")).click();
     //driver.findElement(By.xpath("//p[text()=\"S\"]/ancestor::div[@class=\"size-buttons-size-buttons\"]/descendant::button[@class=\"size-buttons-size-button-selected size-buttons-size-button size-buttons-size-button-default\"]")).click();
    //driver.findElement(By.xpath("//button[@class=\"size-buttons-show-size-chart\"]/ancestor::div[@id=\"sizeButtonsContainer\"]/descendant::p[text()=\"S\"]")).click();
   Set<String> allwin = driver.getWindowHandles();
   for(String win:allwin)
   {
	   
	   driver.switchTo().window(win);
	  String expectedurl = driver.getCurrentUrl();
	  if(expectedurl.contains("mango-man-v-neck-pure"))
	  {
	
	   driver.findElement(By.xpath("(//button[@class=\"size-buttons-size-button size-buttons-size-button-default\"])[1]")).click();     
	   driver.findElement(By.xpath("//span[@class=\"myntraweb-sprite pdp-whiteBag sprites-whiteBag pdp-flex pdp-center\"]")).click();
	   driver.findElement(By.xpath("//span[text()=\"Bag\"]")).click();
	   boolean addeditemisdisplyedincart = driver.findElement(By.xpath("//span[text()=\"1/1 ITEMS SELECTED\"]")).isDisplayed();
	   if(addeditemisdisplyedincart==true)
	   {
		   System.out.println("Item is displayed");
	   }
	   
	   else 
	   {
		   System.out.println("Item is not displayed");
	   }
   }
   

}
   driver.quit();
	}
}

