import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Windowhandels {
	WebDriver driver;

	@Test
	public void setup() throws InterruptedException, IOException {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--start-maximized");
		op.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(op);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> link = driver.getWindowHandles();

		Iterator<String> links = link.iterator();
		String parent = links.next();
		String child = links.next();
		driver.switchTo().window(child);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		String text = driver
				.findElements(
						By.xpath("//div[@class='left-align']//fieldset//table[@name='courses'" + "]//tbody//tr//td[1]"))
				.get(1).getText();

		driver.switchTo().window(parent);
		WebElement l = driver.findElement(By.xpath("//div[@class='form-group']/input[@name='name']"));
		l.sendKeys(text);
		File sr = l.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sr, new File("screen.png"));
		float s = l.getRect().getDimension().getHeight();
		System.out.println(s);

		System.out.println(l.getRect().getDimension().getWidth());

		// Practice old stuff.

		/*
		 * File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 * FileUtils.copyFile(src, new File(""));
		 * 
		 * String s = null; // For sample HttpURLConnection con = (HttpURLConnection)
		 * new URL(s).openConnection(); con.setRequestMethod("Head"); con.connect(); int
		 * status = con.getResponseCode();
		 * 
		 * List<WebElement> list = driver.findElements(By.xpath("")); // String sk =
		 * Keys.chord(Keys.CONTROL, Keys.ENTER); 
		 * for (WebElement ss : list) {
		 * ss.sendKeys(sk); }
		 * 
		 * Set<String> lp = driver.getWindowHandles(); Iterator<String> tab =
		 * lp.iterator(); // String parent1= tab.next(); // String child1 = tab.next();
		 * 
		 * while (tab.hasNext()) {
		 * 
		 * driver.switchTo().window(tab.next()); }
		 * 
		 * List<WebElement> list1 = driver.findElements(By.xpath("")); // sample for
		 * (WebElement ss : list1) {
		 * 
		 * }
		 * 
		 * driver.switchTo().newWindow(WindowType.TAB);
		 */

	}

}
