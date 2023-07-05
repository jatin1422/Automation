import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class New_locators {
	WebDriver driver;

	@Test
	public void setup() throws InterruptedException, IOException {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--start-maximized");
		op.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(op);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
	WebElement s = 	driver.findElement(By.xpath("//div[@class='form-group']/input[@name='name']"));
	String ssss =driver.findElement(with(By.tagName("label")).above(s)).getText();
    System.out.println(ssss);
    WebElement s1 = driver.findElement(By.xpath("//label[@for='dateofBirth']"));
    driver.findElement(with(By.tagName("input")).below(s1)).click();
    
    WebElement s2 =   driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
    driver.findElement(with(By.tagName("input")).toLeftOf(s2)).click();
    
    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(src, new File(""));
    
    
    

    
	
	
	  }
}
