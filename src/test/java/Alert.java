import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
	 
	WebDriver driver;
	
	@BeforeClass
	public void setup() throws InterruptedException
	  {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
		
		driver .get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		
	  }
}
