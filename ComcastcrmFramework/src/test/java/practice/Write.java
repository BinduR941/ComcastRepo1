package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Write {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fis =new FileInputStream("C:\\Users\\bindu\\eclipse-workspace\\ComcastcrmFramework\\testdata\\Testcriptdata.xlsx");
	Workbook wb = WorkbookFactory.create(fis);

	Sheet sh = wb.getSheet("write");
	//int rowcount=sh.getLastRowNum();
	FileOutputStream fos=new FileOutputStream("C:\\\\Users\\\\bindu\\\\eclipse-workspace\\\\ComcastcrmFramework\\\\testdata\\\\Testcriptdata.xlsx");
	for(int i=0;i<=5;i++)
	{
		Cell cell = sh.getRow(i).createCell(0);
		cell.setCellValue("pass");
	
	}
	wb.write(fos);
	wb.close();
}
}
