package Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practise_framework extends Browser_origin {

	@Test(priority = 1)
	public void first() throws InterruptedException {

		Landingpage page = new Landingpage(driver);

		page.goTo();

		page.Login("hello7@gmail.com", "Angel@123");

		Product_Catalog pc = new Product_Catalog(driver);
		pc.add_to_cart("ZARA COAT 3");
		pc.cart_Button();

		Check_Out od = new Check_Out(driver);

		od.checkout_Btn();

		Place_Order po = new Place_Order(driver);

		po.input("ind");
		po.selectcountry();

		po.placaorder();

	}

}
