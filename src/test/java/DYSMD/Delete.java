package DYSMD;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delete {

	WebDriver driver;

	@BeforeClass
	public void setup() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		

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

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Treatments & Medications']")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='page-content']//li[4]"))).click();
		
		List<WebElement> del = driver.findElements(By.xpath("//tbody//td[2]/span/span/i"));
			for (WebElement d : del) {
			
				wait.until(ExpectedConditions.elementToBeClickable(d)).click();
				
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes']"))).click();
				wait.until(ExpectedConditions.visibilityOfAllElements(del));
			}

		

	}
}
