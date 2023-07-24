package Testng;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Check_Out extends Abst{

	
	public Check_Out(WebDriver driver) {
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	

	WebDriver driver;

	By checkoutbutton = By.xpath("//button[.='Checkout']");

	@FindBy(xpath = "//button[.='Checkout']")
	WebElement Checkoutbutton;
	
	public void checkout_Btn() {
		
		waitforappear(checkoutbutton);
		
		Checkoutbutton.click();
		
		
		
		
		
	}
	
      
}
