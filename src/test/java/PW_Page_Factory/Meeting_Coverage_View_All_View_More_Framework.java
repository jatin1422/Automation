package PW_Page_Factory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testng.Abst;

public class Meeting_Coverage_View_All_View_More_Framework extends Abst {

	public WebDriver driver;

	public Meeting_Coverage_View_All_View_More_Framework(WebDriver driver) {
		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='secbtn-mre']/a")
	List<WebElement> Viewall;

	By viewall = By.xpath("//div[@class='secbtn-mre']/a");

	@FindBy(xpath = "//a[normalize-space()='Meeting Coverage']")
	WebElement Meeting_coverage_btn;

	By meeting_coverage_btn = By.xpath("//a[normalize-space()='Meeting Coverage']");

	@FindBy(xpath = "//a[@id='tags_load_more']")
	WebElement View_all_btn;

	By view_all_btn = By.xpath("//a[@id='tags_load_more']");

	public void viewAll() {

		waitforappears(viewall);

		for (int i = 0; i < Viewall.size(); i++) {

			try {

				String linkUrl = Viewall.get(i).getAttribute("href");

				if (linkUrl.isEmpty() == true) {
					continue;
				}

				String chordkey = Keys.chord(Keys.CONTROL, Keys.ENTER);

				Viewall.get(i).sendKeys(chordkey);
			} catch (Exception e) {

			}
		}
	}

	public void view_all_Btn() {

		for (String winHandle : driver.getWindowHandles()) {

			try {
				driver.switchTo().window(winHandle);

				waitforappear(By.xpath("//div[@class='module post-module']"));

				waitforappear(view_all_btn);
				if (View_all_btn.isDisplayed() == true) {

					View_all_btn.click();
				}
			} catch (Exception e) {

			}

		}
	}

	public void go() {

		driver.get("https://www.physiciansweekly.com/meeting-coverage/");
	}

}
