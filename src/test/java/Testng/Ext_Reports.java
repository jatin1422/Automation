package Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ext_Reports {

	ExtentReports report;
	WebDriver driver;

	@BeforeMethod
	public void setup() {

		String path = "C:\\Users\\Primotech\\eclipse-workspace\\Primo_Maven\\reports\\indeed.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Jatin");
		reporter.config().setDocumentTitle("Todays Report");
		reporter.config().setReportName("Demo report");

		report = new ExtentReports();

		report.attachReporter(reporter);

		report.setSystemInfo("Manager Name", "Rahul Sharma");
 
 }

	@Test()
	public void setup1() throws InterruptedException {

		ExtentTest test = report.createTest("setup4");
	
		ChromeOptions opt = new ChromeOptions();

		opt.addArguments("--start-maximized");

		opt.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(opt);

		driver.get("https://rahulshettyacademy.com/client");

		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("la")).click();

		test.fail("Results not match");

		report.flush();

	}

}
