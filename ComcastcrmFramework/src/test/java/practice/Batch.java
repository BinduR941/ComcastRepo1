package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;

import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.objectrepositoryutility.PracticePage;

public class Batch extends BaseClass {
	@Test
	public void createOrgwithRadbtntbdpTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		WebDriverUtility wlib=new WebDriverUtility();
	    wlib.maximizepage(driver);
		PracticePage pj=new PracticePage(driver);
		HomePage h = new HomePage(driver);
		h.orglink();
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.getCreateneworgbtn().click();
		String expectedorgname = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomno();
		System.out.println(expectedorgname);
        pj.getOrgtbx().sendKeys(expectedorgname);
        pj.getAssignedtoradiobtn().click();
        WebElement dd = pj.getDropdown();
        String dptxt = elib.getDataFromExcel("practice", 1, 1);
        wlib.selectByVisibletext(dd,dptxt);
        WebElement scrolltoelement = pj.getScrolltoelement();
        wlib.scrollToElement(driver, scrolltoelement);
        Thread.sleep(2000);
        
        String place = elib.getDataFromExcel("practice", 1,2);
        wlib.sendKeysusingActions(driver, scrolltoelement, place);
        pj.getOrgsavebtn().click();
        String Dropdownactualtxt = pj.getDropdownactualtxt().getText();
        System.out.println(Dropdownactualtxt);
        String Billinadressacttxt = pj.getBillinadressacttxt().getText();
        System.out.println(Billinadressacttxt);
        String Actualorgname = pj.getActualorgname().getText();
        System.out.println(Actualorgname);
        if(Dropdownactualtxt.equals(dptxt))
        {
        	System.out.println(Dropdownactualtxt+  "is matching and pass");
        }
        else 
        {
        	System.out.println(Dropdownactualtxt+  "is not matching and fail");
        }
        if(Billinadressacttxt.equals(place))
        {
        	System.out.println(Billinadressacttxt+  "is matching and pass");
        }
        else 
        {
        	System.out.println(Billinadressacttxt+"is not matching and fail");
        }
        if(expectedorgname.contains(Actualorgname))
        {
        	System.out.println(Actualorgname+  "is matching and pass");
        }
        else 
        {
        	System.out.println(Actualorgname+ "is not matching and fail");
        }
        
}
	@Test
	public void op() throws EncryptedDocumentException, IOException, InterruptedException
	{  
		String oppurtunityname = elib.getDataFromExcel("practice", 5, 3);
	   ExcelUtility elib=new ExcelUtility();
	   WebDriverUtility wlib=new WebDriverUtility();
	   wlib.maximizepage(driver);
	   PracticePage pnp=new PracticePage(driver);
		HomePage h = new HomePage(driver);
		h.orglink();
		OrganizationPage cn=new OrganizationPage(driver);
		cn.getCreateneworgbtn().click();
		String expectedorgname = elib.getDataFromExcel("practice", 5,1)+jlib.getRandomno();
		System.out.println(expectedorgname);
		CreateNewOrganizationPage cp=new CreateNewOrganizationPage(driver);
		cp.createOrgName(expectedorgname);
		Thread.sleep(2000);
		pnp.getOppurtunitybtn().click();
		Thread.sleep(2000);
		pnp.getCreateoppurplusbtn().click();
		String oppurname = elib.getDataFromExcel("practice", 5, 2);
		pnp.getOppurtunitytb().sendKeys(oppurname);
		Thread.sleep(2000);
		pnp.getOopurtunitychilwin().click();
		Thread.sleep(3000);
		wlib.switchtoTabBasedOnUrl(driver, "Accounts&action");
		Thread.sleep(2000);
		pnp.getOppurseacrbox().sendKeys(expectedorgname);
		pnp.getOppurchilwinsearchnowbtn().click();
		driver.findElement(By.xpath("//a[text()='"+expectedorgname+"']")).click();
		wlib.switchtoTabBasedOnUrl(driver, "Potentials&action");
	    pnp.getOppurtsavebtn().click();
	    String Opputunityverifyheadertxt = pnp.getOpputunityverifyheader().getText();
	    System.out.println(Opputunityverifyheadertxt);
	    if(Opputunityverifyheadertxt.contains(oppurname))
	    {
	    	System.out.println(oppurname+"is verified and pass");
	    }
	    else 
	    {
	    	System.out.println(oppurname+"is not verified and fail");
	    }
	  String actualorgname = pnp.getOrgheadertxt().getText();
	  System.out.println(actualorgname);
	  if(actualorgname.contains(expectedorgname))
	  {
		  System.out.println(expectedorgname+"is verified and pass");
	  }
	  else 
	  {
		  System.out.println(expectedorgname+"not verified and fail");
	  }
	  pnp.getOppurtunitybtn().click();
	  pnp.getOppurtunitysearchforbtn().sendKeys(oppurname);
	  WebElement OppurIndropdown = pnp.getOppurIndropdown();
	  Thread.sleep(2000);
	  wb.selectByVisibletext(OppurIndropdown, oppurtunityname);
	  pnp.getOppurtabsearchnowbtn().click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath(" //table[@class=\"lvt small\"]/tbody/tr[*]/td/a[text()='"+expectedorgname+"']")).click();
	  pnp.getOppurtunitydeletebtn().click();
	  wlib.switchtoAlertAndAccept(driver);
	}
	
	@Test
	public void Docmethod() throws EncryptedDocumentException, InterruptedException, IOException
	{
		
		WebDriverUtility wb=new WebDriverUtility();
		wb.maximizepage(driver);
		PracticePage pnp=new PracticePage(driver);
		pnp.getDoucumentbtn().click();
		pnp.getCreatedocplusbtn().click();
		WebElement scrolltoele = pnp.getDocscrolltoele();
		wb.scrollToElement(driver, scrolltoele);
		WebElement docdropdown=pnp.getDocdropdown();
		String expecteddocdrptext = elib.getDataFromExcel("practice", 3, 1);
		wb.selectByVisibletext(docdropdown, expecteddocdrptext);
		Thread.sleep(2000);
		pnp.getDoccancelbtn().click();
		Thread.sleep(2000);
		pnp.getDoscsearchbtn().click();
		boolean txt  = pnp.getDocnotfound().isDisplayed();
		String doc = pnp.getDocnotfound().getText();
		System.out.println(doc);
		if(txt==true)
		{
			System.out.println(doc + "message is displayed");
		}
		
		
	}
	
	@Test
	public void productTest () throws EncryptedDocumentException, IOException, InterruptedException
	{
		ExcelUtility elib=new ExcelUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		wlib.maximizepage(driver);
		PracticePage pnp=new PracticePage(driver);
		String dropdowntxt = elib.getDataFromExcel("practice", 7, 2);
		pnp.getProductsbtn().click();
		pnp.getProductsplusbtn().click();
		String expectedprodname = elib.getDataFromExcel("practice", 7, 1);
		pnp.getProductsnametb().sendKeys(expectedprodname);
		pnp.getProductsavebtn().click();
		String Actualproductverifytxt = pnp.getProductverifytxt().getText();
		System.out.println(Actualproductverifytxt);
		if(Actualproductverifytxt.contains(expectedprodname))
		{
			System.out.println(Actualproductverifytxt+"is matching and pass");
		}
		else
		{
			System.out.println(Actualproductverifytxt+"is not matching and fail");
		}
		
		wlib.navigateback(driver);
		wlib.navigateback(driver);
		pnp.getProductssearchbtn().sendKeys(expectedprodname);
		WebElement Productsdropdwn = pnp.getProductsdropdwn();
	    Thread.sleep(2000);
		wlib.selectByVisibletext(Productsdropdwn, dropdowntxt);
	    pnp.getProductseachnowbtn().click();
	  
	    
		
		
		
	}
}
