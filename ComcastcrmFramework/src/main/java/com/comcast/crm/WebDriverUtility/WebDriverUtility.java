package com.comcast.crm.WebDriverUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//Insert all WebDriver Actions
public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver)// browser session
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// driver.manage().timeouts().pageLoadTimeout()
	}
	
	public void maximizepage(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void navigateback(WebDriver driver)
	{
		driver.navigate().back();
	}
	
//ExplicitWait

	public void waitForElementToBePresent(WebDriver driver, WebElement element)// pass the broswer instance and element,
																				// go to browser and wait for the
																				// element
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForalertIsPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());

	}

	public void waitForelementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForelementToBeSelected(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	

//Switch by Windows
	
	public void switchtoTabBasedOnUrl(WebDriver driver, String partialurl)// pass the parent driver session
	{
		Set<String> allwins = driver.getWindowHandles();
		for (String win : allwins) {
			driver.switchTo().window(win);
			String url = driver.getCurrentUrl();		
			if (url.contains(partialurl)) {
			
				break;

			}
		}
	}

	public void switchoTabBasedonTitle(WebDriver driver, String partialtTitle) {
		Set<String> allwins = driver.getWindowHandles();
		for (String wins : allwins) {
			driver.switchTo().window(wins);
			String Title = driver.getTitle();
			if (Title.contains(partialtTitle)) {
				
				break;

			}
		}
	}

	//Switch by Frames
	public void switchtoFrameWithIndex(WebDriver driver, int index)// Switch to frame based on index
	{
		driver.switchTo().frame(index);
	}

	public void switchtoFrame(WebDriver driver, String nameID)// Switch to frame based on name or id attribute
	{
		driver.switchTo().frame(nameID);
	}

	public void switchtoFrame(WebDriver driver, WebElement element)// Switch to frame based on name or id attribute
	{
		driver.switchTo().frame(element);
	}
	
//Alert
	public void switchtoAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchtoAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

//Select
	public void selectByVisibletext(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);

	}

	public void selectByindex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);

	}

	public void selectByValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);

	}

	public void getallOptionsinSelect(WebElement element) {
		Select sel = new Select(element);
		sel.getOptions();
	}

	public void deselectAllOptionsinSelect(WebElement element) {
		Select sel = new Select(element);
		sel.deselectAll();
	}

//Actions

	public void mousemoveOnElement(WebDriver driver, WebElement element)// which element we want to move a mouse
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();

	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();

	}

public void dragAndDrop(WebDriver driver,WebElement src,WebElement target) {
	Actions act=new Actions(driver);
    act.dragAndDrop(src, target).perform();

}

public void rightClickOnWebpage(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
	
}

public void rightClickOnWebElement(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
    act.contextClick(element).perform();

}

public void sendKeysusingActions(WebDriver driver,WebElement element,CharSequence keys)
{
	Actions act=new Actions(driver);
	act.sendKeys(element, keys).perform();

}



}
