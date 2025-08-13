package com.automation.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public List<Map<String, String>> readDataFromExcel(String excelFilePath, String SheetName) {
		try {
			List<Map<String, String>> listOfMaps = new ArrayList<Map<String, String>>();
			File file = new File(excelFilePath);
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet languagesSheet = workbook.getSheet(SheetName);
			List<String> allHeaders = getColumnHeaders(languagesSheet);
			int allRowsCount = languagesSheet.getLastRowNum();
			for (int i = 1; i < allRowsCount; i++) {
				Map<String, String> eachRowMap = new LinkedHashMap<String, String>();
				Row eachRow = languagesSheet.getRow(i);
				int columnCount = eachRow.getLastCellNum();
				for (int j = 0; j < columnCount; j++) {
					Cell eachCell = eachRow.getCell(j);
					switch (eachCell.getCellType()) {
					case STRING:
						String strData = eachCell.getStringCellValue();
						eachRowMap.put(allHeaders.get(j), strData);
						break;
					default:
						break;
					}
				}
				listOfMaps.add(eachRowMap);
			}
			fis.close();
			return listOfMaps;
		} catch (Exception e) {
			System.out.println("Exception occurred while reading the data from excel: " + e.getMessage());
			return null;
		}
	}

	public List<String> getColumnHeaders(XSSFSheet languagesSheet) {
		List<String> allHeaders = new ArrayList<>();
		Row firstRows = languagesSheet.getRow(0);

		Iterator<Cell> allCells = firstRows.cellIterator();
		while (allCells.hasNext()) {
			Cell eachCell = allCells.next();
			if (eachCell.getCellType().equals(CellType.STRING)) {
				allHeaders.add(eachCell.getStringCellValue().trim());
			}
		}
		return allHeaders;
	}

	public static void main(String[] args) throws Exception {
		ExcelUtils excelUtil = new ExcelUtils();
		String excelFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Files\\InputExcel.xlsx";
		String sheetName = "Languages";

		List<Map<String, String>> excelData = excelUtil.readDataFromExcel(excelFilePath, sheetName);
//		System.out.println(excelData);
//		excelData.forEach(System.out::println);

		List<Map<String, String>> filteredList = excelData.stream()
				.filter(eachMap -> eachMap.get("Language").equalsIgnoreCase("Java")).collect(Collectors.toList());
		
		if(filteredList.size() > 0) {
			if(filteredList.get(0).get("TypeOfLanguage").equals("Object Oriendted Programming1")) {
				System.out.println("Pass");
			}else {
				System.out.println("Fail");
			}
		}else {
			System.out.println("Fail");
		}
		
		System.out.println("Execution ended");
	}

}
