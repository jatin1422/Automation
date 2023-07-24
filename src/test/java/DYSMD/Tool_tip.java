package DYSMD;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tool_tip {
	WebDriver driver;

	@BeforeClass
	public void setup() throws InterruptedException {

		ChromeOptions ch = new ChromeOptions();

		ch.addArguments("--start-maximized");

		ch.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(ch);

		driver.get("https://www.dysmd.com/beta/front/user");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rashmika");

		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("8930179062");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	}

	@Test
	public void medication() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='My Medical Chart']")))
				.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='medchrt_sub']//ul/li[7]/a")))
				.click();

		List<WebElement> d = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='tooltip']")));

		Actions act = new Actions(driver);

		for (WebElement dd : d) {

			act.moveToElement(dd).build().perform();

			Thread.sleep(5000);

		}
		List<WebElement> dw = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='custom_radio'][2]/input")));

		for (WebElement hj : dw) {

			hj.click();
			Thread.sleep(3000);
		}

	}
}
