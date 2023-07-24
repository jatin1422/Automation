package EMS;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public class Punch_In_Out {

	WebDriver driver;

	@BeforeClass
	public void setup() {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--start-maximized");
		co.addArguments("--allow-remote-origin=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);

		driver.get("https://agencyva.vision/beta/login/agent");
	}

	@Test(priority = 1)
	public void punchin() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@class='m-t']/a[2]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")))
				.sendKeys("agencyvavision.ava@gmail.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")))
				.sendKeys("primo@123");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']"))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@title='Attendance']/a"))).click();

		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='punch_in_btn']"))).click();

		Thread.sleep(3000);

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scr, new File("C:\\Users\\Primotech\\Pictures\\Screenshots\\punchin.png"));

	}

	@Test(priority = 2)
	public void todo_notification() throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.findElement(By.xpath("//a[@href='https://agencyva.vision/beta/todo']//i[@class='fa fa-check-square-o']"))
				.click();

		Thread.sleep(5000);

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scr, new File("C:\\Users\\Primotech\\Pictures\\Screenshots\\Todonotification.png"));

	} 

	@Test(priority = 3)
	public void collapsed() throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-dashboard']"))).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,1500)");

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scr, new File("C:\\Users\\Primotech\\Pictures\\Screenshots\\collapsed.png"));

		Thread.sleep(1800000);

	}

	@Test(priority = 4)
	public void activityscreenshot() throws IOException, InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-tasks']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='feed-activity-list ajax_list']//div//div[1]//div[1]//div[1]//div[1]//a[1]//img[1]")))
				.click();
		
		Thread.sleep(2000);
		
		Actions builder = new Actions(driver);
		 WebElement element = driver.findElement(By.xpath("//a[@aria-label='Next image']"));
		 builder.moveToElement(element).build().perform();
		

		Thread.sleep(2000);

		
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scr, new File("C:\\Users\\Primotech\\Pictures\\Screenshots\\activityscreenshot.png"));

	}
	
	
}