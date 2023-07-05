package PW_Page_Factory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testng.Abst;

public class Homepage_Viewmore_Viewall_Clickability_Framework extends Abst {
	public WebDriver driver;

	public Homepage_Viewmore_Viewall_Clickability_Framework(WebDriver driver) {
		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@id='main-content']//div/span/a")
	List<WebElement> Viewall;

	By viewall = By.xpath("//div[@id='main-content']//div/span/a");

	@FindBy(xpath = "//div[@id='main-content']//div/a[.='View More']")
	List<WebElement> Viewmore;

	By viewmore = By.xpath("//div[@id='main-content']//div/a[.='View More']");

	public void viewAll() {


		for (int i = 0; i < Viewall.size(); i++) {

			try {

				String linkUrl = Viewall.get(i).getAttribute("href");

				if (linkUrl.isEmpty() == true) {
					continue;
				}

				Java_Scriptexecutor execute = new Java_Scriptexecutor(driver);

				String script = "window.open('" + linkUrl + "', '_blank');";

				execute.executescript(script);

			} catch (Exception e) {

			}
		}
	}

	public void viewMore() {


		for (int j = 0; j < Viewmore.size(); j++) {
			try {

				String linkUrl2 = Viewmore.get(j).getAttribute("href");

				if (linkUrl2.isEmpty() == true) {
					continue;
				}

				Java_Scriptexecutor execute = new Java_Scriptexecutor(driver);

				String script = "window.open('" + linkUrl2 + "', '_blank');";

				execute.executescript(script);

			} catch (Exception e) {

			}
		}
	}

	public void go() {
		driver.get(

				"https://www.physiciansweekly.com/");
	}

}
