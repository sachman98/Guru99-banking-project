package com.qa.Utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Excel2D {

	@DataProvider(name = "loginData")
	public String[][] getdata() throws Exception {
		
		File excelfile = new File("C:\\Users\\Sachit\\OneDrive\\Desktop\\SDET\\Guru99_LiveProject\\src\\test\\java\\com\\qa\\TestData\\UserData.xlsx");
		FileInputStream file= new FileInputStream(excelfile);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheet("Sheet1");
//		System.out.println(sheet.getPhysicalNumberOfRows());
//		System.out.println(sheet.getLastRowNum());
		
		int noOfRows=sheet.getPhysicalNumberOfRows();
		int noOfCols=sheet.getRow(0).getLastCellNum();		
		String[][] data = new String[noOfRows-1][noOfCols];    //excluding headers from row				
		for (int i = 0; i < noOfRows-1; i++) {
			for (int j = 0; j < noOfCols; j++) {
				DataFormatter df= new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));  // all formats of data can be converted
//				String celldata=sheet.getRow(i).getCell(j).getStringCellValue();
//				System.out.println(celldata);
			}			
		}		
		workbook.close();
		file.close();
		for (String[] dataArr : data) {
			System.out.println(Arrays.toString(dataArr));
		}
		return data;
		
	}

}
