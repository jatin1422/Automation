package Testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Place_Order extends Abst {

	public Place_Order(WebDriver driver) {
		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);
		
	}

	WebDriver driver;

	By countries = By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button/span");

	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']/button/span")

	List<WebElement> Countries;

	By text = By.xpath("//input[@placeholder='Select Country']");

	@FindBy(xpath = "//input[@placeholder='Select Country']")

	WebElement Text;

	By plaorder = By.xpath("//a[normalize-space()='Place Order']");

	@FindBy(xpath = "//a[normalize-space()='Place Order']")

	WebElement Plaorder;

	public void input(String keys) {

		waitforappear(text);
		Text.sendKeys(keys);

	}

	
	public WebElement Countrylist() {

		waitforappears(countries);

		WebElement country = Countries.stream().filter(n -> n.getText().equals("India")).findFirst().orElse(null);

		return country;

	}

	public void selectcountry() {

		waitforappearele(Countrylist());
		Countrylist().click();

	}

	public void placaorder() {

		waitforappear(plaorder);
		Plaorder.click();

	}
	

}
