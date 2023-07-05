package PW;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Catlinks {

	WebDriver driver;

	@Test

	public void main() throws InterruptedException {
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebDriverManager.chromedriver().setup();

		ChromeOptions chromeoptions = new ChromeOptions();

		chromeoptions.addArguments("--start-maximized");

		chromeoptions.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(chromeoptions);

		driver.get(

				"https://www.physiciansweekly.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='align-right secondary slidedown-button']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='SPECIALTIES']"))).click();

		List<WebElement> sss = driver.findElements(By.cssSelector("ul[class$='mega-sub-menu'] ul li a"));

		System.out.println(sss.size());

		for (WebElement ss : sss) {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

			// wait1.until(ExpectedConditions.visibilityOf(ss));

			String linkUrl = ss.getAttribute("href");

			// System.out.println(linkUrl);

			if (linkUrl == null) {
				continue;
			}

			String script = "window.open('" + linkUrl + "', '_blank');";
			((JavascriptExecutor) driver).executeScript(script);

		}

		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);

			Thread.sleep(10000);

			List<WebElement> sss1 = driver.findElements(By.xpath("//a"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			String currentURL = (String) js.executeScript("return window.location.href;");

			System.out.println("Page Title   " + driver.getTitle() + "   CurrentURL is  " + currentURL
					+ "   Total [a] links on this " + sss1.size());

			for (int i = 0; i < sss1.size(); i++) {

				try {
					String link = sss1.get(i).getAttribute("href");

					if (link == null) {

					}

					else if (link.contains("https://pwdev2")) {

						System.out.println(link);

					} else if (link.contains("https://staging")) {

						System.out.println(link);

					} else if (link.contains("https://pwga4")) {
						System.out.println(link);

					}

					else if (link.contains("https://dev")) {
						System.out.println(link);

					} else if (link.contains("http://pwdev2")) {

						System.out.println(link);

					} else if (link.contains("http://staging")) {

						System.out.println(link);

					} else if (link.contains("http://pwga4")) {
						System.out.println(link);

					}

					else if (link.contains("http://dev")) {
						System.out.println(link);

					}

				} catch (Exception e) {

					System.out.println(e);
				}
			}
			List<WebElement> sss2 = driver.findElements(By.xpath("//img"));

			System.out.println("Page Title   " + driver.getTitle() + "   CurrentURL is  " + currentURL
					+ "   Total [img] links on this " + sss2.size());

			for (int j = 0; j < sss2.size(); j++) {

				try {

					String link2 = sss2.get(j).getAttribute("src");

					if (link2 == null) {

					}

					else if (link2.contains("https://pwdev2")) {

						System.out.println(link2);

					} else if (link2.contains("https://staging")) {

						System.out.println(link2);

					} else if (link2.contains("https://pwga4")) {
						System.out.println(link2);

					}

				} catch (Exception e) {

					System.out.println(e);
				}

			}

		}
	}
}
