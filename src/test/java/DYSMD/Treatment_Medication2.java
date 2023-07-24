package DYSMD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Treatment_Medication2 {
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

		Thread.sleep(2000);

	}

	@Test
	public void medication() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[normalize-space()='My Medical Chart']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[normalize-space()='Treatments & Medications']")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[normalize-space()='Past Treatments']")).click();

		driver.findElement(By.xpath("//button[normalize-space()='Add New Treatments']")).click();

		driver.findElement(By.xpath("//input[@id='autocom']")).sendKeys("ana");

		Thread.sleep(3000);

		// driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

		driver.findElement(By.xpath("//a[@id='ui-id-2']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//tbody//div[2]//input[1]")).click();

		driver.findElement(By.xpath("//input[@id='now_since']")).click();
		WebElement month = driver.findElement(By.xpath("//select[@aria-label='Select month']"));

		Select mon = new Select(month);
		mon.selectByIndex(2);

		WebElement year = driver.findElement(By.xpath("//select[@aria-label='Select year']"));

		Select yer = new Select(year);
		yer.selectByValue("2022");

		java.util.List<WebElement> date = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td"));

		// System.out.println(date.size());
		
		Thread.sleep(1000);

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

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='frequency']")).sendKeys("Once a week");

		driver.findElement(By.xpath(
				"//body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[2]/input[1]"))
				.click();

		driver.findElement(By.xpath("//textarea[@id='describe_side_effects']")).sendKeys("Skin allergies");

		driver.findElement(By.xpath("//button[@id='SendDataAdd']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
		Thread.sleep(5000);
		driver.quit();
	}
}
