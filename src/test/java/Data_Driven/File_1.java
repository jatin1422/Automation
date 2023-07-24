package Data_Driven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class File_1 {

	@Test
	public ArrayList<String> getdata() throws IOException {

		ArrayList<String> list = new ArrayList<String>();

		FileInputStream fi = new FileInputStream("C:\\Users\\Primotech\\Desktop\\6EBE0B10.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fi);

		for (int i = 0; i < wb.getNumberOfSheets(); i++) {

			if (wb.getSheetName(i).equals("Sheet2")) {

				XSSFSheet sheet = wb.getSheetAt(i);

				Iterator<Row> row = sheet.iterator();

				while (row.hasNext()) {

					Row firstrow = row.next();

					if (firstrow.getCell(0).getStringCellValue().equalsIgnoreCase("sachin")) {

						Iterator<Cell> cell = firstrow.cellIterator();

						while (cell.hasNext()) {

							Cell value = cell.next();

							if (value.getCellType() == CellType.STRING) {

								list.add(value.getStringCellValue());
							} else {

								String text = NumberToTextConverter.toText(value.getNumericCellValue());
								list.add(text);

							}

						}
					}
					System.out.println();
				}
			}

		}
		return list;

	}
}
