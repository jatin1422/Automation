package DYSMD;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Treat_medication4 {

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
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='page-content']//li[5]"))).click();
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add New Medications']")))
				.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='autocom']"))).sendKeys("ana");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='ui-id-2']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody//div[2]//input[1]"))).click();

		driver.findElement(By.xpath("//input[@id='now_since']")).click();
		WebElement month = driver.findElement(By.xpath("//select[@aria-label='Select month']"));

		Select mon = new Select(month);
		mon.selectByIndex(2);

		WebElement year = driver.findElement(By.xpath("//select[@aria-label='Select year']"));

		Select yer = new Select(year);
		yer.selectByValue("2022");

		java.util.List<WebElement> date = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td"));

		System.out.println(date.size());

		for (WebElement da : date) {

			if (da.getText().equals("14")) {

				da.click();
				break;
			}
		}
		WebElement dd = driver.findElement(By.xpath("//select[@name='how_long']"));

		dd.click();

		Select d = new Select(dd);
		d.selectByValue("4");

		WebElement dd1 = driver.findElement(By.xpath("//select[@name='how_long_unit']"));

		dd1.click();

		Select d1 = new Select(dd1);

		d1.selectByValue("d");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='strength']"))).sendKeys("20ml");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='how_take']")))
				.sendKeys("Once a week");

		driver.findElement(By.xpath("//tbody/tr[6]/td[2]/input[1]")).click();

		driver.findElement(By.xpath("//textarea[@id='describe_side_effects']")).sendKeys("Skin allergies");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[7]/td[2]/input[1]"))).click();

		driver.findElement(By.xpath("//input[@id='brand_name']")).sendKeys("Amoxicilin");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='SendDataAdd']"))).click();
		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes']"))).click();
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table/tbody//tr")));
		Thread.sleep(3000);
  
		 driver.quit();
	}

}
