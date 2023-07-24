package Testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Start {

	public WebDriver driver;

	@Test(priority = 1)
	public void bbb() {

		ChromeOptions opt = new ChromeOptions();

		opt.addArguments("--start-maximized");

		opt.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(opt);

		driver.get("https://www.dysmd.com/beta/front/dashboard");
	}

	@Test(priority =1, retryAnalyzer = Retry.class)
	public void aaa() {

		ChromeOptions opt = new ChromeOptions();

		opt.addArguments("--start-maximized");

		opt.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(opt);

		driver.get("https://www.dysmdcom/beta/front/dashboard");

	}

}