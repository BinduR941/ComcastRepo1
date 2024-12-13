package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\bindu\\eclipse-workspace\\ComcastcrmFramework\\testdata\\Testcriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum);
		DataFormatter d=new DataFormatter();
		String digits = d.formatCellValue(cell);
		return digits; //connects to excel sheet and returns the data
	}
	
	public int getRowcount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\bindu\\eclipse-workspace\\ComcastcrmFramework\\testdata\\Testcriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowcount=wb.getSheet(sheetName).getLastRowNum();
		return rowcount;
	}
	
	public void setDatatIntoExcel(String sheetName,int rowNum,int cellNum,String setdata) throws IOException
	{

		FileInputStream fis1=new FileInputStream("C:\\Users\\bindu\\eclipse-workspace\\ComcastcrmFramework\\testdata\\Testcriptdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(setdata);
		FileOutputStream fos=new FileOutputStream("C:\\Users\\bindu\\eclipse-workspace\\ComcastcrmFramework\\testdata\\Testcriptdata.xlsx");//open excel in write mode
		wb.write(fos);
		wb.close(); //In the excelresource the object will be open and it gets crashed when we open it manually

}
}
