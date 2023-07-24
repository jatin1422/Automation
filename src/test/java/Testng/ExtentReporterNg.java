package Testng;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNg {

	public static ExtentReports getReport(String path , String reportername, String title, String Reportname) {

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName(reportername);
		reporter.config().setDocumentTitle(title);
		reporter.config().setReportName(Reportname);

		ExtentReports report = new ExtentReports();

		report.attachReporter(reporter);
		return report;
	
	}
	}
