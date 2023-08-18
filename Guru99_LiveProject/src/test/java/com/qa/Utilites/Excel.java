package com.qa.Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static void main(String arg[]) throws IOException {
		File file = new File("C:\\Users\\Sachit\\OneDrive\\Desktop\\SDET\\Guru99_LiveProject\\UserData.xlsx");
		FileInputStream fileInput = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		XSSFSheet sheet=workbook.getSheetAt(0);
//		String cellvalue = sheet.getRow(0).getCell(1).getStringCellValue();
//		System.out.println(cellvalue);
		int rowCount=sheet.getPhysicalNumberOfRows();
		
		for (int i = 0; i < rowCount; i++) {
			XSSFRow row= sheet.getRow(i);
			
			int cellCount=row.getPhysicalNumberOfCells();
			String[][] data= new String[rowCount-1][cellCount];
			for (int j = 0; j < cellCount; j++) {
				XSSFCell cell=row.getCell(j);
				String cellValue=getCellValue(cell);
				System.out.println(" "+ cellValue);
			}
			System.out.println();
		}
		
		workbook.close();
		fileInput.close();
		}
	
	public static String getCellValue(XSSFCell cell) {
		switch (cell.getCellType()) {
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
			
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
			
		case STRING:
			 return cell.getStringCellValue();
			
		default:
			return cell.getStringCellValue();
			
		}
	}
}
