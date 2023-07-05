package PW_Duplicate_Articles;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PW_Page_Factory.Pop_Up_Button;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	public WebDriver driver;

//	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException, BrokenBarrierException, TimeoutException {

		Properties prop = new Properties();

		FileInputStream fi = new FileInputStream(
				"C:\\Users\\Primotech\\eclipse-workspace\\Primo_Maven\\src\\test\\java\\PW\\browser.properties");

		prop.load(fi);

		String browsername = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("Chrome")) {

			ChromeOptions opt = new ChromeOptions();

			opt.addArguments("--start-maximized");

			opt.addArguments("--remote-allow-origins=*");

			opt.addArguments("--incognito");

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(opt);

		}

		else if (browsername.equalsIgnoreCase("Edge")) {

			EdgeOptions opt = new EdgeOptions();

			opt.addArguments("--start-maximized");

			opt.addArguments("--remote-allow-origins=*");

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver(opt);

		} else if (browsername.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}

	}

	@Test
	public void te() {

		driver.get("https://www.physiciansweekly.com/category/nephrology/general-nephrology/page/43/");

		Pop_Up_Button btn = new Pop_Up_Button(driver);

		btn.popBtn();

		if (driver.findElement(By.xpath("//ul[@class='pagination']")).isDisplayed() == true) {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			String totalnum = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='pagination']//span")))
					.getText();

			String[] ist = totalnum.split(" ");

			String num = ist[3].trim();

			int number = Integer.parseInt(num);

			for (int k = 0; k < number; k++) {
				try {

					List<WebElement> d = driver
							.findElements(By.xpath("//section//div//div[@class='article-logo-cnt']//a"));
					ArrayList<String> ar = new ArrayList<String>();

					for (WebElement dd : d) {

						ar.add(dd.getText());
					}

					for (int i = 0; i < ar.size(); i++) {
						for (int j = i + 1; j < ar.size(); j++) {
							if (ar.get(i).equals(ar.get(j))) {

								System.out.println(ar.get(i));
							}
						}
					}

					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Next >']")))
							.click();

				} catch (Exception ss) {

				}
			}

		}

	}
}
