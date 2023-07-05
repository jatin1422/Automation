package PW_Page_Factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testng.Abst;

public class Search_Feed_Articals_ extends Abst {
	public WebDriver driver;

	public Search_Feed_Articals_(WebDriver driver) {
		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//span[@id='divi_search']")
	WebElement Search;

	@FindBy(xpath = "//input[@placeholder='Type a keyword, title or author']")
	WebElement Search_input_box;

	By search = By.xpath("//span[@id='divi_search']");
	By search_input_box = By.xpath("//input[@placeholder='Type a keyword, title or author']");

	@FindBy(xpath = "//div[@class='search-frm']//input[@value='Search']")
	WebElement Search_btn;

	By search_btn = By.xpath("//div[@class='search-frm']//input[@value='Search']");

	public void search_Box() {

		waitforappears(search);

		Search.click();

	}

	public void search_input_Box(String input) {

		waitforappears(search_input_box);

		Search_input_box.sendKeys(input);

	}

	public void search_Btn() {

		waitforappears(search_btn);

		Search_btn.click();

	}

	public void go() {

		driver.get("https://www.physiciansweekly.com/");
	}

}
