import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {

	WebDriver driver;

	@BeforeClass
	public void setup() throws InterruptedException {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--start-maximized");
		op.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(op);

		driver.get("https://www.dysmd.com/beta/front/user");

		driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rashmika");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("8930179062");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	}

	@Test
	public void medication() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='My
		// Medical Chart']")))
		// .click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Tools']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Reports']"))).click();
		List<WebElement> name = driver.findElements(By.xpath("//form//div[contains(@class,'content_med')]"));
		List<WebElement> texts = name.stream().filter(r->r.getText().contains("NewTest (March 2023)")).map(r->getprice(r)).collect(Collectors.toList());
	

	}
	public WebElement getprice(WebElement r) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.findElement(By.xpath("//button[@class='align-right secondary slidedown-button']")).click();

		WebElement tx = r.findElement(By.xpath("//div//div//child::span/a[2]"));
		
		wait.until(ExpectedConditions.elementToBeClickable(tx)).click();
		return tx;
	}
	
}