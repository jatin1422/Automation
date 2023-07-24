package PW;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	WebDriver driver;

	public Screenshot(WebDriver driver2) {

		this.driver = driver2;
	}

	public void takescreenshot(String method) throws IOException {

		String path = System.getProperty("user.dir") + ("//PWPassScreenshot/" + method + ".png");

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File(path));

	}
}
