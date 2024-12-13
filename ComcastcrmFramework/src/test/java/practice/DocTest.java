package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.baseutility.BaseClass;

import com.comcast.crm.objectrepositoryutility.PracticePage;

public class DocTest extends BaseClass {
@Test
public void Docmethod() throws EncryptedDocumentException, InterruptedException, IOException
{
	WebDriverUtility wb=new WebDriverUtility();
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
}
