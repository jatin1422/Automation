package PW_Page_Factory;

import java.util.List;

import org.openqa.selenium.By;
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

	
	public void viewAll() {

		waitforappears(viewall);

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

	public void go() {

		driver.get("https://www.physiciansweekly.com/meeting-coverage/");
	}

}
