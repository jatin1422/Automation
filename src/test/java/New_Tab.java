import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class New_Tab {

	WebDriver driver;

	@Test

	public void main() throws InterruptedException {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get(

				"https://www.physiciansweekly.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='align-right secondary slidedown-button']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='SPECIALTIES']"))).click();

		List<WebElement> sss = driver
				.findElements(By.cssSelector("ul[class$='mega-sub-menu'] li[id$='mega-menu-420087-0-0'] ul li a"));

		System.out.println(sss.size());

		for (WebElement ss : sss) {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

			// wait1.until(ExpectedConditions.visibilityOf(ss));

			String linkUrl = ss.getAttribute("href");

			System.out.println(linkUrl);

			if (linkUrl.equals("https://www.physiciansweekly.com/#\r\n" + "")) {
				continue;
			}

		
			
			String script = "window.open('" + linkUrl + "', '_blank');";
			((JavascriptExecutor) driver).executeScript(script);

		}
	}
}
