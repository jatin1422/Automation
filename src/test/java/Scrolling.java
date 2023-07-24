import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrolling {
	WebDriver driver;

	@Test
	public void setup() throws InterruptedException {
		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(3000);
		// js.executeScript("window.scrollBy(0,-9000)");

		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500\r\n" + "");

		List<WebElement> text = driver
				.findElements(By.cssSelector("div[class$='tableFixHead'] table tbody td:nth-child(4)"));
		int sum = 0;
		if (text.size() == 9) {

			for (int i = 0; i < text.size(); i++) {
				sum = sum + Integer.parseInt(text.get(i).getText());

			}
			System.out.println(sum);

		}
		String te = driver.findElement(By.cssSelector("div[class$='totalAmount'] ")).getText();
		String ss[] = te.split(":");
		String ss1 = ss[1].trim();
		int ss2 = Integer.parseInt(ss1);
		Assert.assertEquals(sum, ss2);
	}
}
