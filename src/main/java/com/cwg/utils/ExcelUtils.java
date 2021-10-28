package com.cwg.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public Object[][] gerData() throws FileNotFoundException, IOException {

		String fileName = System.getProperty("user.dir") + BaseUtils.getConfigValue("datapath");
		FileInputStream file = new FileInputStream(fileName);
		Workbook wb = null;
		if (fileName.toLowerCase().endsWith(".xlsx")) {
			wb = new XSSFWorkbook(file);
		} else if (fileName.toLowerCase().endsWith(".xls")) {
			wb = new HSSFWorkbook(file);
		}
		Sheet sheet = wb.getSheet(BaseUtils.getConfigValue("sheetname"));
		int noOfRows = sheet.getLastRowNum();
		int noOfColumns = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[noOfRows][noOfColumns];

		for (int i = 1; i < noOfRows; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;

	}

	public static List<Map<String, String>> getTestData(String sheetName) {

		List<Map<String, String>> list = null;
		try {
			String fileName = System.getProperty("user.dir") + BaseUtils.getConfigValue("datapath");
			FileInputStream file = new FileInputStream(fileName);
			Workbook wb = null;

			if (fileName.toLowerCase().endsWith(".xlsx")) {
				wb = new XSSFWorkbook(file);
			} else if (fileName.toLowerCase().endsWith(".xls")) {
				wb = new HSSFWorkbook(file);
			}

			Sheet sheet = wb.getSheet(sheetName);
			int noOfRows = sheet.getLastRowNum();
			int noOfColumns = sheet.getRow(0).getLastCellNum();

			Map<String, String> map;
			list = new ArrayList<>();

			for (int i = 1; i <= noOfRows; i++) {
				map = new HashMap<>();
				for (int j = 0; j < noOfColumns; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}

		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;

	}

}
