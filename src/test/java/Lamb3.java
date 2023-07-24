import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lamb3 {
	WebDriver driver;

	@Test
	public void setup() throws InterruptedException {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--start-maximized");
		op.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(op);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
		List <WebElement>vegies = driver.findElements(By.xpath("//tr/td[1]"));
		System.out.println(vegies.size());
		List <WebElement> es=vegies.stream().filter(vegie->vegie.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(vegies.size(), es.size());
	}
}
