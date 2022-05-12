package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	private static final String TEST_DATA_SHEET = ".\\src\\test\\resources\\testdata\\ExcelData.xlsx";
	private static Workbook book;
	private static Sheet sheet;

	
	public static Object[][] getTestData(String sheetName) {

		Object data[][] = null;

		FileInputStream ip;
		try {
			ip = new FileInputStream(TEST_DATA_SHEET);
			book = WorkbookFactory.create(ip);
			sheet = book.getSheet(sheetName);

			int totalNoOfCols = sheet.getRow(0).getLastCellNum();
			int totalNoOfRows = sheet.getLastRowNum();
			System.out.println("totalNoOfRows:"+totalNoOfRows);
			System.out.println("totalNoOfCols:"+totalNoOfCols);
			data = new Object[totalNoOfRows][totalNoOfCols];

			for (int i = 1; i < totalNoOfRows; i++) {
				for (int j = 0; j <totalNoOfCols; j++) {
					data[i-1][j] = sheet.getRow(i).getCell(j).toString();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
