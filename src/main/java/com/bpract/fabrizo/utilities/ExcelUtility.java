package com.bpract.fabrizo.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	String projectPath;
	
	public ExcelUtility(String path, String sheetName) {
		try {
			projectPath = System.getProperty("user.dir");
			workbook = new XSSFWorkbook(path);
			sheet = workbook.getSheet(sheetName);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;
	}
	
	public static int getCellCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;
	}
	
	public static String getCellDataString(int nowNum, int colNum) {
		XSSFCell cellData = null;
		String cellValueStr = null;
		try {
//			cellData = sheet.getRow(nowNum).getCell(colNum).getStringCellValue();
			DataFormatter objDefaultFormat = new DataFormatter();
			FormulaEvaluator objFormulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) workbook);
			cellData = sheet.getRow(nowNum).getCell(colNum);
			objFormulaEvaluator.evaluate(cellData);
			cellValueStr = objDefaultFormat.formatCellValue(cellData,objFormulaEvaluator);
			System.out.println(cellData);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellValueStr;
	}
}
