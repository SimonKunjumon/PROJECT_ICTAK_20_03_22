package com.techblog.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	private static      XSSFWorkbook excelWBook; 
	private static      XSSFSheet    excelWSheet; 
	
public static String getCellData(int RowNum, int ColNum) throws IOException {
        
        // Open the Excel file
    	 FileInputStream ExcelFile = new FileInputStream("C:\\Users\\vineetha\\eclipse-workspace\\TechBlog\\src\\main\\resources\\TestData.xlsx");
    	 excelWBook = new XSSFWorkbook(ExcelFile);
         excelWSheet = excelWBook.getSheetAt(0);
         
         return (String)excelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
    	 
    	 
}
    	 
    	 
}
