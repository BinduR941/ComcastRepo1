package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.baseutility.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;

import com.comcast.crm.objectrepositoryutility.PracticePage;

public class ProductTest extends BaseClass {
@Test
public void productTest () throws EncryptedDocumentException, IOException, InterruptedException
{
	ExcelUtility elib=new ExcelUtility();
	WebDriverUtility wlib=new WebDriverUtility();
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
