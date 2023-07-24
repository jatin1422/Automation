package Data_Driven;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class Para_Data {

	@DataProvider(name = "data")
	public Object[][] data() throws IOException {

		Data_Supplier_Framework dat = new Data_Supplier_Framework();

		Object[][] da = dat.data("MyData", "C:\\Users\\Primotech\\Documents\\Para_Bank_Data.xlsx");
		
		return da;

	}
}
