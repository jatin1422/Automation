package Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class End_page extends Abst {

	public End_page(WebDriver driver) {
		super(driver);

		this.driver = driver;

		PageFactory.initElements(driver, this);
		
	}

	WebDriver driver;

	By confirmationtext = By.xpath("//h1[normalize-space()='Thankyou for the order.']");

	@FindBy(xpath = "//h1[normalize-space()='Thankyou for the order.']")
	
	WebElement Confirmationtext;

	
	public String confirmationText() {
		
		waitforappear(confirmationtext);
		
		return Confirmationtext.getText();
		
		
	}
	
}
