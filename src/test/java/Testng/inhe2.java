package Testng;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class inhe2 {

	WebDriver driver;

	@BeforeClass
	public void setup1() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

		driver.get("https://www.dysmd.com/beta/front/user");
		
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rashmika");
		
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("8930179062");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		
	}

	@Test(priority = 2)
	public void medication() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='My Medical Chart']")))
				.click();

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Treatments & Medications']")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='page-content']//li[5]"))).click();
		
		System.out.println(" inher2" + Thread.currentThread().getId());

		driver.quit();

	}
}