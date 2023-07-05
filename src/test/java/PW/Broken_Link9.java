package PW;

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

public class Broken_Link9 {

	WebDriver driver;

	@Test
	public void setup() throws MalformedURLException, IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions chromeoptions = new ChromeOptions();

		chromeoptions.addArguments("--start-maximized");

		chromeoptions.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(chromeoptions);

		driver.get(

				"https://www.physiciansweekly.com/page/8183/?s");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='align-right secondary slidedown-button']"))).click();

		for (int id = 8183; id < 9000; id++) {

			WebElement rightarrow = wait

					.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".next.page-numbers")));

			rightarrow.click();

			Thread.sleep(20000);


			List<WebElement> sss = driver.findElements(By.xpath("//a"));
			
			 System.out.println("Page number "+id+" //a tag totallinks"+sss.size());


			for (int i = 0; i < sss.size(); i++) {

				try {

					String link = sss.get(i).getAttribute("href");

					if (link == null) {

					}

					else if (link.contains("https://pwdev2")) {

						System.out.println(link);

					} else if (link.contains("https://staging")) {

						System.out.println(link);

					} else if (link.contains("https://pwga4")) {
						System.out.println(link);

					}

					
				} catch (Exception e) {

					System.out.println(e);
				}
			}
				List<WebElement> sss2 = driver.findElements(By.xpath("//img"));
				
				 System.out.println("Page number "+id+" //img tag totallinks"+sss2.size());


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
