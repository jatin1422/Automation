package Testng;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Runfile extends Browser_origin {
	String path = "C:\\Users\\Primotech\\Pictures\\Saved Pictures\\";

	@Test(dataProvider = "getdata", groups = { "purchase" })
	public void main(HashMap<String, String> input) throws IOException {

		Landingpage lp = new Landingpage(driver);

		lp.goTo();
		lp.Login(input.get("User-mail"), input.get("Pass"));
		System.out.println(lp.toastText());

		Product_Catalog pc = new Product_Catalog(driver);

		pc.add_to_cart(input.get("Product"));
		pc.cart_Button();

		Check_Out co = new Check_Out(driver);

		co.checkout_Btn();

		Orders_Confirmation oc = new Orders_Confirmation(driver);

		oc.OrdersButton();
		oc.OrderName();
		System.out.println(oc.cofirmationmessage());
		
		    
	}
	


	@DataProvider
	public Object[][] getdata() throws IOException {

		List<HashMap<String, String>> data = getdata(
				"C:\\Users\\Primotech\\eclipse-workspace\\Primo_Maven\\src\\test\\java\\Testng\\purchase.json");

		/*
		 * HashMap<String, String> has = new HashMap<String, String>();
		 * 
		 * has.put("Usermail", "hello7@gmail.com"); has.put("Pass", "Angel@123");
		 * has.put("Productname", "ZARA COAT 3");
		 * 
		 * HashMap<String, String> has1 = new HashMap<String, String>();
		 * 
		 * has1.put("Usermail", "hello7@gmail.com"); has1.put("Pass", "Angel@12");
		 * has1.put("Productname", "ZARA COAT 3");
		 */

		return new Object[][] { { data.get(0) }, { data.get(1) }, { data.get(2) }, { data.get(3) } };

	}

}
