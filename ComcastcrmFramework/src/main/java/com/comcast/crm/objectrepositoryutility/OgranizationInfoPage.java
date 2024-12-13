package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OgranizationInfoPage {
	
	//WebDriver driver;
	public OgranizationInfoPage (WebDriver driver) {
		//this.driver=driver; 
	PageFactory.initElements(driver, this);  //doing the initialization inside the constructor
	}
	
public WebElement getActualorgtf() {
		return actualorgtf;
	}

public WebElement getHeadermsg() {
		return headermsg;
	}

@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement headermsg;


@FindBy(id="mouseArea_Organization Name")
private WebElement actualorgtf;

@FindBy(xpath="//span[@id=\"dtlview_Industry\"]")
private WebElement actualind;

@FindBy(xpath ="//input[@class=\"crmButton small save\"]")
private WebElement savebtn;


public WebElement getSavebtn() {
	return savebtn;
}

public WebElement getActualind() {
	return actualind;
}


}






