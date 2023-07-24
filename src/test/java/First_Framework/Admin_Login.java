package First_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Login {

	// User name
	
	WebDriver driver;


		@FindBy(xpath = "//input[@placeholder='Username']")
		WebElement Adminusername;

		public By adminusername = By.xpath("//input[@placeholder='Username']");

		// Password

		@FindBy(xpath = "//input[@placeholder='Password']")
		WebElement Adminpassword;

		public By adminpassword = By.xpath("//input[@placeholder='Password']");

		// Login button

		@FindBy(xpath = "//button[normalize-space()='Login']")
		public
		WebElement Adminloginbutton;

		public By adminloginbutton = By.xpath("//button[normalize-space()='Login']");
	}

