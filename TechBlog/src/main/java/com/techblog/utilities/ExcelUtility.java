package com.techblog.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	
	private static XSSFWorkbook excelWbook;
	private static XSSFSheet excelWSheet; 
	
	public static String getCellData(int row, int col) throws IOException {
		
		FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/TestData.xlsx");
		
		excelWbook = new XSSFWorkbook(ExcelFile);
		excelWSheet = excelWbook.getSheetAt(0);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(excelWSheet.getRow(row).getCell(col));
		//return excelWSheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
}
