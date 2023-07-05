package PW_Page_Factory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testng.Abst;

public class Deep_Dives_Peer_to_Peer_View_All_Framework extends Abst {

	public WebDriver driver;

	public Deep_Dives_Peer_to_Peer_View_All_Framework(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@id='tags_load_more']")
	WebElement View_all_btn;

	By view_all_btn = By.xpath("//a[@id='tags_load_more']");

	public void view_all_Btn() {

		waitforappear(view_all_btn);

		View_all_btn.click();
	}
	
	public void go() {
		
		driver.get("https://www.physiciansweekly.com/peer-to-peer/conference/");

	}
}
