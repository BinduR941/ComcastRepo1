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
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
import com.comcast.crm.objectrepositoryutility.PracticePage;

public class OppurtunityTest extends BaseClass {
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
}

