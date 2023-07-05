package PW_Page_Factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testng.Abst;

public class Pop_Up_Button extends Abst {

	public WebDriver driver;

	public Pop_Up_Button(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@class='align-right secondary slidedown-button']")
	WebElement Popbtn;

	By popbtn = By.xpath("//button[@class='align-right secondary slidedown-button']");

	public void popBtn() {

		waitforClick(Popbtn);

	}

}
