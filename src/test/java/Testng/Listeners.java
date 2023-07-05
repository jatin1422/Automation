package Testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Browser_origin implements ITestListener {

	ExtentTest test;

	ExtentReports extent = testReports();

	ThreadLocal<ExtentTest> td = new ThreadLocal<ExtentTest>();

	public WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getMethod().getMethodName());

		td.set(test); // unique thread id

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		td.get().log(Status.PASS, "Test is pass");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		td.get().fail(result.getThrowable());

		String path = null;

		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			path = Take(driver, result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		td.get().addScreenCaptureFromPath(path, result.getMethod().getMethodName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();
	}
}
