package Testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orders_Confirmation extends Abst {

	WebDriver driver;

	public Orders_Confirmation(WebDriver driver) {
		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	By ordersbutton = By.xpath("//button[contains(.,'ORDERS')]");

	@FindBy(xpath = "//button[contains(.,'ORDERS')]")

	WebElement Ordersbutton;

	By ordername = By.cssSelector("table tbody tr ");

	@FindBy(css = "table tbody tr")

	List<WebElement> Ordername;

	By productname = By.cssSelector("td:nth-child(3)");

	By viewbutton = By.cssSelector("button.btn.btn-primary");

	By exactordername = By.cssSelector("table tbody tr:first-child td:nth-child(6) .btn.btn-primary");

	@FindBy(css = "table tbody tr:first-child td:nth-child(6) .btn.btn-primary")

	WebElement Exactordername;
	
	@FindBy(css = ".tagline")

	WebElement Confirmationmsg;
	
	By confirmationmsg = By.cssSelector(".tagline");


	public void OrdersButton() {

		waitforappear(ordersbutton);

		Ordersbutton.click();

	}

	public void OrderName() {

		waitforappears(exactordername);

		// WebElement name =
		// Ordername.stream().filter(n->n.findElement(productname).getText().contains("zara
		// coat 3")).findFirst().orElse(null);

		Exactordername.click();
	}
	
	public String cofirmationmessage() {
		
		waitforappear(confirmationmsg);

		String message = Confirmationmsg.getText();
		
		return message;
		

	}
	
	public void teardown () {
		
		driver.close();
	}


}
