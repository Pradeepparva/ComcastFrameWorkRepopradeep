package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws Throwable, IOException {
		
		FileInputStream fis = new FileInputStream("./ConfigAppData/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		
		return data;
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./ConfigAppData/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int data=wb.getSheet(sheetName).getLastRowNum();
		
		return data;
	}
	
	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("./ConfigAppData/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos = new FileOutputStream("./ConfigAppData/TestData.xlsx");
		wb.write(fos);
		wb.close();
	}

}
