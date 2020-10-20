package com.crm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtilCrm {

	static Workbook book;
	static FileInputStream file;
	static Sheet sheet;
	static String sheetPath = System.getProperty("user.dir") + "/src/main/java/com/crm/qa/testdata/CrmRegister.xlsx";

	public static Object[][] readSheet(String sheetName) {
		try {
			file = new FileInputStream(sheetPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		int row = sheet.getLastRowNum();
		int cell = sheet.getRow(0).getLastCellNum();
		System.out.println("No of rows-->"+row+" No of column-->"+cell);
		Object[][] data = new Object[row][cell];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cell; j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}

		return data;
	}

}
