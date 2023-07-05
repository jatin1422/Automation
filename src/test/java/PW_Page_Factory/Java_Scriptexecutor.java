package PW_Page_Factory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Java_Scriptexecutor {

	WebDriver driver;

	public Java_Scriptexecutor(WebDriver driver) {

		this.driver = driver;
	}

	public void executescript(String input) {

		JavascriptExecutor execute = (JavascriptExecutor) driver;

		execute.executeScript(input);

	}
}
