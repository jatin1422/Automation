package PW_Page_Factory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testng.Abst;

public class Footer_Link_Check_Framework extends Abst {

	public WebDriver driver;

	public Footer_Link_Check_Framework(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//footer//a")
	List<WebElement> Footer_links_tabs;

	By footer_links_tabs = By.xpath("//footer//a");

	String Skip_tab_url = "https://www.physiciansweekly.com/contact-us/";

	public void footer_links_Tabs() {

		for (WebElement footer_link : Footer_links_tabs) {

			String link = footer_link.getAttribute("href");

			if (link.equals(Skip_tab_url)) {

				continue;
			}

			String Key_chord = Keys.chord(Keys.CONTROL, Keys.ENTER);

			footer_link.sendKeys(Key_chord);

		}

	}

	public void go() {

		driver.get("https://www.physiciansweekly.com/");
	}

}
