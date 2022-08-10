package utilities;

import java.io.File;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;


public class ExcelUtilities {
	
	
	public static String[][] getCellData(String FilePath, String SheetName) throws Exception, IOException {
		
		Workbook workbook = Workbook.getWorkbook(new File(FilePath));
		
		Sheet sheet = workbook.getSheet(SheetName);
		
		int rows = sheet.getRows();
		
		int cols = sheet.getColumns();
		
		String[][] tableArray= new String[rows][cols];
		
		int ci, cj;
		
		ci=0;
		
		for (int i=1; i<rows; i++, ci++) {
			
			cj = 0;
			
			for (int j=0; j<cols; j++,cj++) {
				
				String getData= sheet.getCell(j, i).getContents();
				
				tableArray[ci][cj] = getData; 
				
				System.out.println(getData);
				
			}
		}
		
		
		return (tableArray);
		
		
		
	}
	
	

}
