
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
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
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	WebDriver driver;

	@Test
	public void setup() throws MalformedURLException, IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--start-maximized");

		chromeoptions.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(chromeoptions);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get(

				"https://pwdev2.physiciansweekly.com/page/1/?s");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password_protected_pass']")))
				.sendKeys("pw@123!");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='wp-submit']"))).click();

		// wait.until(ExpectedConditions
		// .elementToBeClickable(By.xpath("//button[@class='align-right secondary
		// slidedown-button']"))).click();

		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='SPECIALTIES']"))).click();

		List<WebElement> sss = driver.findElements(By.cssSelector("a"));
		System.out.println(sss.size());

		for (WebElement ss : sss) {

			String link = ss.getAttribute("href");

			// System.out.println(link);

			/*
			 * if (link.equals("https://www.physiciansweekly.com/#\r\n" + "")) { continue; }
			 * 
			 * String script = "window.open('" + link + "', '_blank');";
			 * 
			 * ((JavascriptExecutor) driver).executeScript(script);
			 */

			try {
				HttpURLConnection con = (HttpURLConnection) new URL(link).openConnection();

				con.setRequestMethod("HEAD");

				con.connect();

				int status = con.getResponseCode();

				// System.out.println(status);
				if ((status > 100) && (status < 400)) {
					System.out.println("Actual link: " + ss.getText()+ link + " & Status code: " + status);

					if ((status < 200)) {
						System.out.println("Actual link: " + ss.getText()+ link + " & Status code: " + status);

					}

					else if ((status < 300)) {
						System.out.println("Actual link: " + ss.getText()+ link + " & Status code: " + status);

					}

					else if ((status < 400)) {
						System.out.println("Actual link: " + ss.getText()+ link + " & Status code: " + status);

					}

					else if ((status < 500)) {
						System.out.println("Actual link: " + ss.getText() + link + " & Status code: " + status);

					}

				} else if ((status < 600)) {
					System.out.println("Actual link: " + ss.getText() + link + " & Status code: " + status);

				}

				else if ((status < 700)) {
					System.out.println("Actual link: " + ss.getText() + link + " & Status code: " + status);

				}

				else if (status == 404) {

					System.out.println("Broken link: " + ss.getText() + link + " & Status code: " + status);

				}

				else if (status > 700) {

					System.out.println("Above 404 code : " + ss.getText() + link + " & Status code: " + status);

				}
			} catch (Exception e) {

			}

		}

	}

}
