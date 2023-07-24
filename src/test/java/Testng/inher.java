package Testng;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class inher {
	

	WebDriver driver;

	@Test()
	public void setup() throws InterruptedException {

	/*	ChromeOptions co = new ChromeOptions();
		co.addArguments("--start-maximized");
		co.addArguments("--allow-remote-origin=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co); */
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();


		driver.get("https://prep.dysmd.com/front/user");
		
		System.out.println(" inher" + Thread.currentThread().getId());

	}	
	

}
