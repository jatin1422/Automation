import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class inher {
	

	WebDriver driver;

	@Test
	public void setup() throws InterruptedException {
		inher in = new inher();

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--start-maximized");
		co.addArguments("--allow-remote-origin=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);

		driver.get("https://prep.dysmd.com/front/user");
	}

}
