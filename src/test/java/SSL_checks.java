import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSL_checks {
	WebDriver driver;

	@Test
	public void setup() throws InterruptedException {
		WebDriverManager.edgedriver().setup();

		EdgeOptions op = new EdgeOptions();
		op.setAcceptInsecureCerts(true);
	//capabilites of the browsers.
		driver = new EdgeDriver(op);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

	}

}
