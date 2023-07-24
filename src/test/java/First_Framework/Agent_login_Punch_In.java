package First_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Agent_login_Punch_In  {

         WebDriver driver;

	public Agent_login_Punch_In(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	// User name

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement Agentusername;

	By  agentusername = By.xpath("//input[@placeholder='Username']");

	// Password

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement Agentpassword;

	By agentpassword = By.xpath("//input[@placeholder='Password']");

	// Login button

	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement Agentloginbutton;
	
	By agentloginbutton= By.xpath("//button[normalize-space()='Login']");
	
	//Attendance Button
	
	@FindBy(xpath = "//li[@title='Attendance']/a")
	WebElement Agentattendancebutton;

	By  agentattendancebutton = By.xpath("//li[@title='Attendance']/a");
	
	//Punch in Button
	
	@FindBy(xpath = "//button[@id='punch_in_btn']")
	WebElement Agentpunchinbutton;

	By  agentpunchinbutton = By.xpath("//button[@id='punch_in_btn']");
	
	//Punch out Button
	
	@FindBy(xpath = "")
	WebElement Agentpunchoutbutton;

	By  agentpunchoutbutton = By.xpath("");

}
