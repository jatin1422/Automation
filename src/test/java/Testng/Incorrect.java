package Testng;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Incorrect extends Abst {

	public Incorrect(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	WebElement Incorrecttext;

	By incorrecttext = By.xpath("//div[@aria-label='Incorrect email or password.']");

	public String incorrectText() {
		
	waitforappear(incorrecttext);
	
	String tex = Incorrecttext.getText();
		return tex;

	}
}
