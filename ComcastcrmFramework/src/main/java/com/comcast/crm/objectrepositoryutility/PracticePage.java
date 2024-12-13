package com.comcast.crm.objectrepositoryutility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;


public class PracticePage extends BaseClass {
	WebDriverUtility wb=new WebDriverUtility();
	ExcelUtility elib=new ExcelUtility();

	//WebDriver driver;
	public PracticePage(WebDriver driver) {
		//this.driver=driver; 
	PageFactory.initElements(driver, this);  //doing the initialization inside the constructor
	}
	
	@FindBy(xpath = "(//input[@type=\"radio\"])[2]")
	private WebElement  Assignedtoradiobtn;
	
	

	public WebElement getOppurtunitybtn() {
		return oppurtunitybtn;
	}



	public WebElement getOppurchildwin() {
		return oppurchildwin;
	}

	@FindBy(name="assigned_group_id")
	private WebElement dropdown;
	

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgtbx;
	
	@FindBy(name="bill_street")
	private WebElement scrolltoelement;
	
	@FindBy(xpath="(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement orgsavebtn;
	
	@FindBy(linkText = "Support Group")
	private WebElement dropdownactualtxt;
	
	@FindBy(id = "dtlview_Billing Address")
	private WebElement billinadressacttxt;
	
	@FindBy(name = "accountname")
	private WebElement actualorgname;
	
	@FindBy(linkText = "Documents")
	private WebElement doucumentbtn;
	
	@FindBy(xpath ="//img[@alt=\"Create Document...\"]")
	private WebElement createdocplusbtn;
	
	@FindBy(xpath = "//select[@name=\"filelocationtype\"]")
	private WebElement docscrolltoele;
	
	@FindBy(xpath="(//input[@value=\" Search Now \"])[1]")
	private WebElement doscsearchbtn;
	
	@FindBy(xpath="//span[@class=\"genHeaderSmall\"]")
	private WebElement docnotfound;
	
	@FindBy(linkText = "Opportunities")
	private WebElement oppurtunitybtn;
	
	@FindBy(xpath="//input[@id='related_to']/following-sibling::img")
	private WebElement oppurchildwin;
	
	
	
	@FindBy(xpath="//img[@alt=\"Create Opportunity...\"]")
	private WebElement createoppurplusbtn;
	
	@FindBy(name="potentialname")
	private WebElement oppurtunitytb;
	
	@FindBy(xpath = "(//img[@alt=\"Select\"])[1]")
	private WebElement oopurtunitychilwinplubtn;
	
	@FindBy(name = "search_text")
	private WebElement oppurseacrbox;
	
	@FindBy(name="search")
	private WebElement oppurchilwinsearchnowbtn;
	
	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement oppurtsavebtn;
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")
	private WebElement opputunityverifyheader;
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement orgheadertxt;
	
	@FindBy(id="bas_searchfield")
	private WebElement oppurIndropdown;
	
	@FindBy(xpath="(//input[@class=\"crmbutton small create\"])[1]")
	private WebElement oppurtabsearchnowbtn;
	
	@FindBy(xpath = "//input[@name=\"search_text\"]")
	private WebElement oppurtunitysearchforbtn;
	
	@FindBy(linkText = "Products")
	private WebElement productsbtn;
	
	@FindBy(xpath = "//img[@alt=\"Create Product...\"]")
	private WebElement productsplusbtn;
	
	@FindBy(xpath = "//input[@name=\"productname\"]")
	private WebElement productsnametb;
	
	@FindBy(xpath = "(//input[@title=\"Save [Alt+S]\"])[1]")
	private WebElement productsavebtn;
	
	@FindBy(xpath="//span[@class=\"lvtHeaderText\"]")
	private WebElement productverifytxt;
	
	public WebElement getProductverifytxt() {
		return productverifytxt;
	}

     @FindBy(xpath="//input[@class=\"txtBox\"]")
     private WebElement productssearchbtn;
     
     @FindBy(xpath = "//select[@name=\"search_field\"]")
     private WebElement productsdropdwn;
     
     @FindBy(xpath="(//input[@class=\"crmbutton small create\"])[1]")
     private WebElement productseachnowbtn;
     
     public WebElement getProddis() {
		return proddis;
	}

	@FindBy(xpath="//a[@title=\"Products\"]")
     private WebElement proddis;
     
	public WebElement getProductssearchbtn() {
		return productssearchbtn;
	}



	public WebElement getProductseachnowbtn() {
		return productseachnowbtn;
	}



	public void setProductssearchbtn(WebElement productssearchbtn) {
		this.productssearchbtn = productssearchbtn;
	}



	public WebElement getProductsdropdwn() {
		return productsdropdwn;
	}



	public WebElement getProductsbtn() {
		return productsbtn;
	}



	public WebElement getProductsplusbtn() {
		return productsplusbtn;
	}



	public WebElement getProductsnametb() {
		return productsnametb;
	}



	public WebElement getProductsavebtn() {
		return productsavebtn;
	}



	public WebElement getOppurtunitydeletebtn() {
		return oppurtunitydeletebtn;
	}

	@FindBy(xpath = "(//input[@title=\"Delete [Alt+D]\"])[1]")
	private WebElement oppurtunitydeletebtn;

	public WebElement getOppurIndropdown() {
		return oppurIndropdown;
	}



	public WebElement getOppurtabsearchnowbtn() {
		return oppurtabsearchnowbtn;
	}



	public WebElement getOppurtunitysearchforbtn() {
		return oppurtunitysearchforbtn;
	}



	public WebElement getOrgheadertxt() {
		return orgheadertxt;
	}



	public WebElement getOpputunityverifyheader() {
		return opputunityverifyheader;
	}



	public WebElement getOppurtsavebtn() {
		return oppurtsavebtn;
	}



	public WebElement getOppurchilwinsearchnowbtn() {
		return oppurchilwinsearchnowbtn;
	}



	public WebElement getOppurseacrbox() {
		return oppurseacrbox;
	}



	public WebElement getOopurtunitychilwin() {
		return oopurtunitychilwinplubtn;
	}



	public WebElement getOppurtunitytb() {
		return oppurtunitytb;
	}



	public WebElement getCreateoppurplusbtn() {
		return createoppurplusbtn;
	}



	public WebElement getDocnotfound() {
		return docnotfound;
	}



	public WebElement getDoscsearchbtn() {
		return doscsearchbtn;
	}



	public WebElement getDoucumentbtn() {
		return doucumentbtn;
	}



	public WebElement getCreatedocplusbtn() {
		return createdocplusbtn;
	}



	public WebElement getDocdropdown() {
		return docdropdown;
	}



	public WebElement getDoccancelbtn() {
		return doccancelbtn;
	}



	public void setDocscrolltoele(WebElement docscrolltoele) {
		this.docscrolltoele = docscrolltoele;
	}

	@FindBy(xpath="//select[@name=\"filelocationtype\"]")
	private WebElement docdropdown;
	
	@FindBy(xpath="(//input[@value=\"  Cancel  \"])[2]")
    private WebElement doccancelbtn;
	
	
	public WebElement getActualorgname() {
		return actualorgname;
	}



	public WebElement getDropdownactualtxt() {
		return dropdownactualtxt;
	}



	public WebElement getBillinadressacttxt() {
		return billinadressacttxt;
	}



	public WebElement getScrolltoelement() {
		return scrolltoelement;
	}



	public WebElement getOrgsavebtn() {
		return orgsavebtn;
	}



	public void setScrolltoelement(WebElement scrolltoelement) {
		this.scrolltoelement = scrolltoelement;
	}



	public WebElement getOrgtbx() {
		return orgtbx;
	}



	public WebDriverUtility getWb() {
		return wb;
	}

	

	public WebElement getAssignedtoradiobtn() {
		return Assignedtoradiobtn;
	}

	public WebElement getDropdown() {
		return dropdown;
	}
	
	public void rdbtnAndDd()
	{
		Assignedtoradiobtn.click();
		wb.selectByVisibletext(dropdown, "Support Group");
	}
	
	public void docmethod() throws InterruptedException, EncryptedDocumentException, IOException
	{
		getDoucumentbtn().click();
		Thread.sleep(2000);
		getCreatedocplusbtn().click();
		Thread.sleep(2000);
		WebElement docscrolltoele=getDocscrolltoele();
		Thread.sleep(2000);
		wb.scrollToElement(driver, docscrolltoele);
		Thread.sleep(2000);
		WebElement docdropdown=getDocdropdown();
		Thread.sleep(2000);
		String expecteddocdrptext = elib.getDataFromExcel("practice", 3, 1);
		wb.selectByVisibletext(docdropdown, expecteddocdrptext);
		getDoccancelbtn().click();
	}



	public WebElement getDocscrolltoele() {
		return docscrolltoele;
	}
	
}
