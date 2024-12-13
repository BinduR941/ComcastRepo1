package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.javaUtility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.objectrepositoryutility.PracticePage;

public class CreateOrgwithRadbtntbdpTest extends BaseClass {
	CreateNewOrganizationPage cp = new CreateNewOrganizationPage(driver);
//	PracticePage pj=new PracticePage(driver);
	ExcelUtility elib=new ExcelUtility();
	JavaUtility jlib =new JavaUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	@Test
	public void createOrgwithRadbtntbdpTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
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
        
        
		
//		Thread.sleep(2000);
//		//Click createneworg btn
//		OrganizationPage cn = new OrganizationPage(driver);
//		cn.getCreateneworgbtn().click();
//		//driver.quit();
//
//		//to read testscript data from excel file
//		//ExcelUtility elib = new ExcelUtility();
//
//		//JavaUtility jlib = null;
//		//	//generate random number along with orgname
//		//	String expectedorgname = elib.getDataFromExcel("org", 1, 2) + jlib.getRandomno();
//		//	System.out.println(expectedorgname);
//		//	System.out.println(expectedorgname);
//		//enter orgname and create organization
//		pj.getOrgnametb1().sendKeys("hiiii");
//		//	
	}
}
