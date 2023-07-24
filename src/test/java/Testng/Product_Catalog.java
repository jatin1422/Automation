package Testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Product_Catalog extends Abst {

	WebDriver driver;

	@FindBy(xpath = "//div[@class='container']//div[@class='row']/div")
	List<WebElement> Products;

	By products = By.xpath("//div[@class='container']//div[@class='row']/div");

	By addtocart = By.cssSelector("button:last-of-type");

	@FindBy(css = "#toast-container")
	WebElement Container;

	By container = By.cssSelector("#toast-container");

	@FindBy(css = "button[routerlink='/dashboard/cart'] i")
	WebElement Addtocartbutton;

	By addtocartbutton = By.cssSelector("button[routerlink='/dashboard/cart'] i");

	Place_Order po = new Place_Order(driver);

	public Product_Catalog(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action Method

	public List<WebElement> productlist() {

		waitforappears(products);
		return Products;

	}

	public WebElement product(String productname) {

		WebElement prod = productlist().stream()
				.filter(n -> n.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);

		return prod;
	}

	public void add_to_cart(String product) {

		waitforappear(addtocart);
		product(product).findElement(addtocart).click();

	}

	public void containertext() {

		waitforappear(container);

		System.out.print(Container.getText());

	}

	public void cart_Button() {

		waitfordisappear(container);

		waitforappear(addtocartbutton);

		Addtocartbutton.click();
	}

}
