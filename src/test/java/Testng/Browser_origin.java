package Testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_origin {

	public WebDriver driver;

//	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException {

		Properties pr = new Properties();

		FileInputStream fi = new FileInputStream(
				"C:\\Users\\Primotech\\eclipse-workspace\\Primo_Maven\\src\\test\\java\\Testng\\browser.properties");

		pr.load(fi);

		String browsername = System.getProperty("browser") != null ? System.getProperty("browser")
				: pr.getProperty("browser");

		if (browsername.equalsIgnoreCase("Chrome")) {

			ChromeOptions opt = new ChromeOptions();

			opt.addArguments("--start-maximized");

			opt.addArguments("--remote-allow-origins=*");

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
	public List<HashMap<String, String>> getdata(String path) throws IOException {

		// read json to string
		String entire = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);

		// String to Hashmap

		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(entire, new TypeReference<List<HashMap<String, String>>>(){});
		return data;

	}



	public String Take(WebDriver driver, String testname) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "//screenshots/" + testname + ".png"));

		return System.getProperty("user.dir") + "//screenshots/" + testname + ".png";
	}

	public ExtentReports testReports() {

		ExtentSparkReporter reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//reports//Client.html");

		reporter.config().setDocumentTitle("Automation Report");

		reporter.config().setReportName("Todays Report");

		reporter.config().setTimeStampFormat("12-06-2023");

		ExtentReports report = new ExtentReports();

		report.attachReporter(reporter);

		report.setSystemInfo("Tester", "Jatin Passi");

		return report;

	}

	public void go(String URL) {

		driver.get(URL);
	}

}
