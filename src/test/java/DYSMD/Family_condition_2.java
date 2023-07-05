package DYSMD;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Family_condition_2 {

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

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='medchrt_sub']//ul/li[4]/a")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='med_tab_list']/ul/li[2]/a")))
				.click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[normalize-space()='Add New Conditions']\r\n" + ""))).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search via Keyword or Category']")))
				.sendKeys("ana");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Search']"))).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[normalize-space()='Abnormal retinal function studies']"))).click();

		WebElement ss = driver.findElement(By.xpath("//select[@id='condName']"));

		ss.click();

		Select s = new Select(ss);

		s.selectByValue("2");

		WebElement num = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@placeholder='Age at Diagnosis']\r\n" + "")));
		num.sendKeys("nine");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='who']")))
				.sendKeys("Grandmother");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='actions']/span/button[.='Save']")))
				.click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@class='sa-button-container']/div[@class='sa-confirm-button-container']/button")))
				.click();

		List<WebElement> ele = wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='weight']//table/tbody/tr/td[1]")));

		for (WebElement sss : ele) {

			System.out.println(sss.getText());
			
			if(sss.getText().endsWith("of nine")||(sss.getText().equalsIgnoreCase("Abnormal retinal function studies: Father"))) {
				
				System.out.println("Fail");
			}
		}
		
		
	}
}
