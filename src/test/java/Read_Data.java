import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Data {

	public static void main(String[] args) throws Exception {
         
		String path  = "C:\\Users\\Primotech\\Documents\\Book1.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<row;i++) {
			
			XSSFRow rows =sheet.getRow(i);
			
			for(int j=0;j<col;j++) {
			
				XSSFCell cols = rows.getCell(j);
				
				
				
			System.out.print(cols+" | ");
		}
		System.out.println();
     

	}}}


