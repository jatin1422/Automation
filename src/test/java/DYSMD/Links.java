package DYSMD;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {
	WebDriver driver;

	@Test
	public void setup() throws InterruptedException {
		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		int s = driver.findElements(By.xpath("//a")).size();

		System.out.println(s);

		WebElement d = driver.findElement(By.xpath("//div[@id='gf-BIG']"));

		System.out.println(d.findElements(By.cssSelector("a")).size());

		WebElement f = driver.findElement(By.xpath("//ul[contains(.,'Discount Coupons')]"));
		wait.until(ExpectedConditions.visibilityOfAllElements(f));
		System.out.println(f.getText());
		System.out.println(f.findElements(By.tagName("a")).size());
		for (int i = 1; i < f.findElements(By.tagName("a")).size(); i++) {

			String clickontab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			wait.until(ExpectedConditions.visibilityOfAllElements(f.findElements(By.tagName("a")))).get(i)
					.sendKeys(clickontab);
			Thread.sleep(3000);
		}
		Set<String> sss = driver.getWindowHandles();
		Iterator<String> ss = sss.iterator();
		while (ss.hasNext()) {

			driver.switchTo().window(ss.next());
			System.out.println(driver.getTitle());
		}

	}
}
