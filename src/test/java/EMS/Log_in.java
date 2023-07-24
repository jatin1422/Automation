package EMS;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import First_Framework.Admin_Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Log_in extends Admin_Login{

	WebDriver driver;

	

	@BeforeClass
	public void setup() {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--start-maximized");
		co.addArguments("--allow-remote-origin=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);

		driver.get("https://agencyva.vision/beta/login/admin");
	}

	@Test(priority = 1)
	public void login() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@class='m-t']/a[3]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(adminusername))
				.sendKeys("006qatest@gmail.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(adminpassword))
				.sendKeys("primo@123");
		wait.until(ExpectedConditions.elementToBeClickable(adminloginbutton)).click();

	}

}
