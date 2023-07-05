import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class inher3 {

	WebDriver driver;

	@Test(priority = 1)
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

	@Test(priority = 2)
	public void medication() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[normalize-space()='My Medical Chart']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[normalize-space()='Treatments & Medications']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[normalize-space()='Current Treatments']")).click();
	}
}
