package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;



public class CreateNewOrganizationPage  {
   WebDriverUtility wb=new WebDriverUtility();

	//WebDriver driver;
	public CreateNewOrganizationPage(WebDriver driver) {
		//this.driver=driver; 
	PageFactory.initElements(driver, this);  //doing the initialization inside the constructor
	}
	
	@FindBy(name = "accountname")
	private WebElement orgnametb;
	
	@FindBy(xpath="(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement orgsavebtn;
	
	@FindBy(name = "industry")
	private WebElement industrydb;
	
	@FindBy(name = "accounttype")
	private WebElement typedp;
	
	@FindBy(id="phone")
	private WebElement phno;

	@FindBy(id="dtlview_Phone")
	private WebElement actualphno;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement actualorgname;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement actualorgnameheader;


	
	
	public WebElement getActualorgnameheader() {
		return actualorgnameheader;
	}

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createneworgbtn;
	
	public WebElement getCreateneworgbtn() {
		return createneworgbtn;
	}

	public WebElement getActualorgname() {
		return actualorgname;
	}

	public WebElement getActualphno() {
		return actualphno;
	}

	public WebElement getPhno() {
		return phno;
	}

	public WebElement getTypedp() {
		return typedp;
	}

	public WebElement getOrgnameedit() {
		return orgnametb;
	}

	public WebElement getSavebtn() {
		return orgsavebtn;
	}
	
	public WebElement getIndustrydb() {
		return industrydb;
	}
	
	

	public void createOrgName(String orgname)
	{
		
		orgnametb.sendKeys(orgname);
		orgsavebtn.click();
	}
	
	public void createOrgNameWithindandType(String Orgname,String Industry,String Type)
	{
		orgnametb.sendKeys(Orgname);
		wb.selectByVisibletext(industrydb, Industry);
		wb.selectByVisibletext(typedp, Type);
		 
			/*
			 * WebDriverUtility eb=new WebDriverUtility();
			 * eb.selectByVisibletext(industrydb, Industry );
			 */
	
	}
	
	

	

	


}
