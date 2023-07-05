package Extent_Report;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	WebDriver driver;

	ExtentReports extent;

	@BeforeTest
	public void config() {
		String path = "C:\\Users\\Primotech\\eclipse-workspace\\Primo_Maven\\reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Demo Report");
		reporter.config().setDocumentTitle("Report2");

		extent = new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Jatin");
	}

	@Test(alwaysRun = true)
	public void setup() throws InterruptedException {

		extent.createTest("setup");

		ChromeOptions opt = new ChromeOptions();

		opt.addArguments("--start-maximized");

		opt.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(opt);

		driver.get("https://rahulshettyacademy.com/client");
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("la")).click();

		extent.flush();

	}

}
