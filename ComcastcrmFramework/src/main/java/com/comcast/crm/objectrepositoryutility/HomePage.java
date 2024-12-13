package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.baseutility.BaseClass;


public class HomePage {
//WebDriver driver;
	WebDriverUtility wb=new WebDriverUtility();
public HomePage (WebDriver driver) {
	//this.driver=driver; 
PageFactory.initElements(driver, this);  //doing the initialization inside the constructor
}

@FindBy(linkText = "Organizations")
private WebElement link;


@FindBy(linkText="Sign Out")
private WebElement signoutlink;

@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
private WebElement adminImg;

public WebElement getAdminImg() {
	return adminImg;
}

public WebElement getSignoutlink() {
	return signoutlink;
}




public WebElement getLink() {
	return link;
}

public void orglink()
{
	link.click();
}

public void signout(WebDriver driver) throws InterruptedException
{
	
	wb.mousemoveOnElement(driver, adminImg);
	Thread.sleep(2000);
	getSignoutlink().click();
}
}







