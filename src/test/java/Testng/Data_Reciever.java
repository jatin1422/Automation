package Testng;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

public class Data_Reciever {

	@Test(dataProvider = "data", dataProviderClass = Data_Supplier.class)
	public void main(HashMap<String, String> datt) {

		System.out.println(datt.get("Screenshot"));
		System.out.println(datt.get("Name"));
		System.out.println(datt.get("Number"));

	}

}
