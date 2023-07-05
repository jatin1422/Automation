package PW_Page_Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_Origin {

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

	public ExtentReports extentReports() {

		String path = System.getProperty("user.dir") + ("//PWReports/pw6.html");

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setDocumentTitle("PW Report");

		reporter.config().setReportName("Jatin's Report");

		ExtentReports report = new ExtentReports();

		report.attachReporter(reporter);

		report.setSystemInfo("Tester Name", "Jatin Tester");

		return report;

	}

	public String take_Screenshot(String failmethodname, WebDriver driver) throws IOException {

		String path = System.getProperty("user.dir") + ("//Allscreenshots/" + failmethodname + ".png");

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File(path));

		return path;

	}

	@AfterMethod
	public void delete_Cookies() {
		driver.manage().deleteAllCookies();

	}

}
