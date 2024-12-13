package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	//WebDriver driver;
	public OrganizationPage(WebDriver driver) {
		//this.driver=driver; 
	PageFactory.initElements(driver, this);  //doing the initialization inside the constructor
	}
	
	
	@FindBy(xpath="//img[@alt=\"Create Organization...\"]")
private WebElement createneworg;
	
	@FindBy(name = "search_field")
	private WebElement searchdp;

	@FindBy(name = "search_text")
	private WebElement searchtf;
	
	@FindBy(name="submit")
	private WebElement searchbtn;
	
	public WebElement getActualind() {
		return getActualind();
	}
	
	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getCreateneworgbtn() {
		return createneworg;
	}

	public WebElement getSearchdp() {
		return searchdp;
	}

	public WebElement getSearchtf() {
		return searchtf;
	}

	
	
}
