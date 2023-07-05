package Testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	public WebDriver driver;

	// @Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException {

		ChromeOptions opt = new ChromeOptions();

		opt.addArguments("--start-maximized");

		opt.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(opt);

	}

	public String Take(WebDriver driver, String testname) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "//screenshots/" + testname + ".png"));

		return System.getProperty("user.dir") + "//screenshots/" + testname + ".png";
	}

	public ExtentReports testReports() {

		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports/tod3.html");

		reporter.config().setDocumentTitle("Automation Report");

		reporter.config().setReportName("Todays Report");

		reporter.config().setTimeStampFormat("12-06-2023");

		ExtentReports report = new ExtentReports();

		report.attachReporter(reporter);

		report.setSystemInfo("Tester", "Jatin Passi");

		return report;

	}

}
