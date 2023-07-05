package Testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	WebDriver driver;
	
	 public Screenshot(WebDriver driver) {
		 
		this.driver =driver;
	 }
	
	public String Take(String testname) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Primotech\\eclipse-workspace\\Primo_Maven\\reports" + testname +".png"));
		
		return "C:\\Users\\Primotech\\eclipse-workspace\\Primo_Maven\\reports" + testname +".png";
	}

}
