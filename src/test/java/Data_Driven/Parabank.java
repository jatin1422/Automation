package Data_Driven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;

public class Parabank extends Browser_Origin {


	@Test(dataProvider = "data", dataProviderClass = Para_Data.class)
	public void Login(String name, String pass) throws IOException {

		driver.get("https://parabank.parasoft.com/parabank/index.htm");

		driver.findElement(By.cssSelector("input[name$='username']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[name$='password']")).sendKeys(pass);

		driver.findElement(By.cssSelector("input[class$='button']")).click();

	}

}
