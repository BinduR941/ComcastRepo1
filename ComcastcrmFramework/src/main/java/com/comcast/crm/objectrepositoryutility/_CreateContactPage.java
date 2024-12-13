package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class _CreateContactPage {

	//WebDriver driver;
	public _CreateContactPage(WebDriver driver) {
		//this.driver=driver; 
	PageFactory.initElements(driver, this);  //doing the initialization inside the constructor
	}
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement Createorgicon;
	
	@FindBy(linkText = "Organizations")
	private WebElement Orgbtn;
	
	public WebElement getOrgheader() {
		return orgheader;
	}

	@FindBy(xpath = "//img[@alt=\"Create Contact...\"]")
	private WebElement CreateContact;
	
	@FindBy(name = "accountname")
	private WebElement orgnametb;
	
    @FindBy(xpath="//span[@class=\"dvHeaderText\"]")
    private WebElement orgheader;
	
	@FindBy(xpath="(//input[@name=\"button\"])[1]")
	private WebElement contactsavebtn;
	
	@FindBy(name="support_start_date")
	private WebElement verificationstartdate;
	
	@FindBy(name="support_end_date")
	private WebElement verificationenddate;
    
	@FindBy(xpath = "(//input[@type=\"text\"])[1]")
	private WebElement searchtb;
	
	@FindBy(name = "search")
	private WebElement searchbtn;
	
	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement verifysavbtn;
	
	public WebElement getVerifysavbtn() {
		return verifysavbtn;
	}



	public WebElement getSearchtb() {
		return searchtb;
	}



	public WebElement getSearchbtn() {
		return searchbtn;
	}



	public WebElement getVerificationstartdate() {
		return verificationstartdate;
	}



	public WebElement getVerificationenddate() {
		return verificationenddate;
	}



	public WebElement getContactsavebtn() {
		return contactsavebtn;
	}



	public WebElement getOrgnametb() {
		return orgnametb;
	}



	public WebElement getCreateContact() {
		return CreateContact;
	}



	public WebElement getCreateorgicon() {
		return Createorgicon;
	}



	public WebElement getOrgbtn() {
		return Orgbtn;
	}



	public WebElement getContactbtn() {
		return contactbtn;
	}



	public WebElement getExpecsendlastname() {
		return expecsendlastname;
	}






	public WebElement getActlastnametxt() {
		return actlastnametxt;
	}



	public WebElement getLogoutbtn() {
		return logoutbtn;
	}



	public WebElement getSignoutbtn() {
		return signoutbtn;
	}



	public WebElement getCreateorgicon1() {
		return createorgicon1;
	}



	public WebElement getStartdate() {
		return startdate;
	}



	public WebElement getEndate() {
		return endate;
	}



	public WebElement getContactheaderparenwin() {
		return contactheaderparenwin;
	}

	@FindBy(linkText = "Contacts")
	private WebElement contactbtn;
	
	
	

	@FindBy(name = "lastname")
	private WebElement expecsendlastname;
	
	
	


	
	@FindBy(id="dtlview_Last Name")
	private WebElement actlastnametxt;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement logoutbtn;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutbtn;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement createorgicon1;
	
   @FindBy(id="jscal_field_support_start_date")
   private WebElement startdate;
	
	@FindBy(id="jscal_field_support_end_date")
	private WebElement endate;
	
	
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement contactheaderparenwin;
	
	
	
	

	
	

	
	

	
}
