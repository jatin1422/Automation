package Testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Landingpage extends Abst {

	WebDriver driver;

	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement username;

	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement Password;

	@FindBy(xpath = "//input[@class='btn btn-block login-btn']")
	WebElement Signin;

	By password = By.xpath("//input[@id='userPassword']");
	By signin = By.xpath("//input[@class='btn btn-block login-btn']");

	@FindBy(xpath = "//div[@class='overlay-container']/div/div/div")
	WebElement Toast;

	By toast = By.xpath("//div[@class='overlay-container']/div/div/div");

	public Landingpage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Action Method

	public void Login(String email, String pass) {

		username.sendKeys(email);
		Password.sendKeys(pass);
		Signin.click();

	}

	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client");
	}

	public String toastText() {

		waitforappearele(Toast);

		String toasttex = Toast.getText();
		
		return toasttex;

	}
	
	                     
}
