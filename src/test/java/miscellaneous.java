import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class miscellaneous {
	WebDriver driver;

	@Test
	public void setup() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--start-maximized");
		chromeoptions.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(chromeoptions);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// driver.manage().window().maximize();

		driver.get("https://www.redbus.in/");
		// driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("");
	}
}