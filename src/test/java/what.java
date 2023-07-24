import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class what {
	
	WebDriver driver;
	@BeforeTest
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
	
		driver = new ChromeDriver();
		 driver.get("https://www.google.com/");
           		
	}
    @Test
	public void Run() {
		
	WebElement s = 	driver.findElement(By.xpath("//input[@title='Search']"));
    s.sendKeys("Facebook");
    s.sendKeys(Keys.ENTER);
    
	}
	@AfterTest
	public void  done (){
		driver.quit();
	}
}
