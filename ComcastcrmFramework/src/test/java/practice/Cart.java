package practice;

import java.io.IOException;
import java.util.List;

import javax.swing.JComboBox.KeySelectionManager;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.WebDriverUtility.WebDriverUtility;



public class Cart {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		WebDriverUtility wb=new WebDriverUtility();
		WebDriver driver=new ChromeDriver();
		wb.maximizepage(driver);
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
	   driver.findElement(By.xpath("//input[contains(@placeholder,\"Search for Products,\")]")).sendKeys("iphone 15");
	   driver.findElement(By.xpath("//input[contains(@placeholder,\"Search for Products,\")]")).sendKeys(Keys.ENTER);
	  
	   List<WebElement> price = driver.findElements(By.xpath("//div[contains(text(),\"Apple iPhone 15\")]/ancestor::div[@class=\"yKfJKb row\"]/descendant::div[@class=\"Nx9bqj _4b5DiR\"]"));
	   java.io.FileInputStream fis=new java.io.FileInputStream("./testdata/Testcriptdata.xlsx");
	   Workbook wb1 = WorkbookFactory.create(fis);
	   Sheet sheet = wb1.getSheet("P");
	   int rownum=0;
	   for(WebElement prices:price)
	   {
		Row row = sheet.createRow(rownum++); 
	Cell cell = row.createCell(0);
		//Cell cell = row.createCell(1);
		cell.setCellValue(prices.getText());
	
		
		
		
	   }
	  
	 java.io.FileOutputStream fos=new java.io.FileOutputStream("./testdata/Testcriptdata.xlsx");
	 wb1.write(fos);
	   
}
}

/*Workbook wb = WorkbookFactory.create(fis);
wb.getSheet("WriteData").getRow(1).getCell(1).setCellValue("Manager");
FileOutputStream fos=new FileOutputStream("./Data3/Testscrip1.xlsx");
wb.write(fos);*/
