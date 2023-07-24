import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar {
	WebDriver driver;

	@Test
	public void setup() throws InterruptedException {
		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='onward_cal']"))).click();

		while (true) {
			driver.findElement(By.xpath("//button[normalize-space()='>']")).click();

			if (driver.findElement(By.xpath("//td[@class='monthTitle']")).getText().equalsIgnoreCase("Mar 2028")) {

				break;
			}
		}

		List<WebElement> da = driver.findElements(By.xpath("//tbody//tr//td"));
		for (int i = 0; i < da.size(); i++) {

			if (da.get(i).getText().equalsIgnoreCase("15")) {
				da.get(i).click();
				break;
			}
		}
	}
}