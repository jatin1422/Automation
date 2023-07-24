package Testng;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class End_to_End1 {

	WebDriver driver;

	@BeforeTest
	public void num1() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions op = new ChromeOptions();

		op.addArguments("--start-maximized");

		op.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(op);

		driver.get("https://rahulshettyacademy.com/client");

	}

	@Test(priority = 2)
	public void num2() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userEmail']")))
				.sendKeys("hello1@gmail.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userPassword']")))
				.sendKeys("Angel@123");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='btn btn-block login-btn']")))
				.click();

	}

	@Test(priority = 3)
	public void num3() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		List<WebElement> name = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='container']//div[@class='row']/div")));

		WebElement ele = name.stream().filter(n -> n.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3"))
				.findFirst().orElse(null);

		Thread.sleep(2000);

		ele.findElement(By.cssSelector("button:last-of-type")).click();

		String send = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")))
				.getText();

		System.out.println(send);

		Thread.sleep(4000);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[routerlink='/dashboard/cart'] i")))
				.click();

		// Thread.sleep(5000);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Checkout')]"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Select Country']")))
				.sendKeys("ind");

		List<WebElement> countries = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
				By.xpath("//section[@class='ta-results list-group ng-star-inserted']/button/span")));

		for (WebElement country : countries) {

			try {
				if (country.getText().equals("India")) {

					country.click();

				}
			} catch (Exception e) {

			}
		}
	}
}
