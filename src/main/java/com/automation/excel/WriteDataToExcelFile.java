package com.automation.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcelFile {
	public static void main(String[] args) throws Exception {
		File file = new File(System.getProperty("user.dir") + "\\Files\\InputExcel.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet julySheet = workbook.getSheet("JULY2025_1");
		Row firstRow = julySheet.createRow(0);
		Row secondRow = julySheet.createRow(1);
		Row thirdRow = julySheet.createRow(2);
		Cell cell1 = firstRow.createCell(0);
		Cell cell2 = firstRow.createCell(1);
		cell1.setCellValue("Welcome");
		cell2.setCellValue("Python");
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
		fis.close();
	}

}
