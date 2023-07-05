import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read {


		public Object [][]data(String sheetname) throws IOException {
		String path = "C:\\Users\\Primotech\\Documents\\Book1.xlsx";
        
	XLUtility util = new XLUtility(path);
	
	int row =  util.getRowCount(sheetname);
	int cell = util.getCellCount(sheetname,1);
	
	Object[][]dat = new Object[row][cell];
	
	for(int i=0;i<row;i++) {
		for(int j=0;j<cell;j++) {
		
		System.out.print(dat[i][j] = util.getCellData(sheetname, i, j)+"  ");
			
		}
		System.out.println();
	}
	return dat;
	}public static void main(String[] args) throws InterruptedException, IOException {
		
		read r = new read();
		r.data("sheet1");
	}}


