package Testng;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Supplier extends Browser_origin {

	@DataProvider(name = "data")
	public Object[][] data() throws IOException {

		List<HashMap<String, String>> da = getdata(
				"C:\\Users\\Primotech\\eclipse-workspace\\Primo_Maven\\src\\test\\java\\Testng\\purchase.json");

		Object[][] ad = { { da.get(0) }, { da.get(1) }, { da.get(2) }, { da.get(3) }, { da.get(4) } };

		return ad;

	}

}
