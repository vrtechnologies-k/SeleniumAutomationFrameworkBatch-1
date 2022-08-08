package utilities;

import java.io.File;
import java.io.IOException;

import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtils {
	
	public static void main(String[] args) throws Exception {
		
		readExcelData();
	}
	
	
	public static Object[][] readExcelData() throws Exception {
		
		String getData = null;
		
		File file = new File(".\\");

		System.out.println(file.getCanonicalPath());
		
		Workbook workbook = Workbook.getWorkbook(new File(file.getCanonicalPath()+"\\TestData\\formData.xls"));
		
		Sheet sheet = workbook.getSheet("fillForm");
		
		int rows = sheet.getRows();
		
		int cols = sheet.getColumns();
		
		String[][] tableArray = new String[rows][cols];
		
		int ci, cj;
		
		ci=0;
		
		for (int i = 1; i<rows; i++,ci++) {
			cj= 0;
			for (int j= 0; j<cols; j++,cj++) {
				
				getData = sheet.getCell(j, i).getContents();
				
				System.out.println(getData);
				
				tableArray[ci][cj] = getData;
				
			}
			
		}
		System.out.println(tableArray);
		
		
		
		return (tableArray);
		
		
		
	}

}
