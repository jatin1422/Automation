package Data_Driven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Supplier_Framework {

	@DataProvider()
	public Object[][] data(String sheetname, String path) throws IOException {

		DataFormatter format = new DataFormatter();

		FileInputStream fi = new FileInputStream(path);

		XSSFWorkbook wb = new XSSFWorkbook(fi);

		XSSFSheet sheet = wb.getSheet(sheetname);

		int rowcount = sheet.getPhysicalNumberOfRows();

		XSSFRow row = sheet.getRow(0);

		int cellcount = row.getLastCellNum();

		Object all_data[][] = new Object[rowcount - 1][cellcount];

		for (int i = 0; i < rowcount - 1; i++) {

			row = sheet.getRow(i + 1);

			for (int j = 0; j < cellcount; j++) {

				XSSFCell cell = row.getCell(j);

				all_data[i][j] = format.formatCellValue(cell);

			}
		}

		return all_data;
	}
}
