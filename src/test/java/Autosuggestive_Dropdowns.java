import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autosuggestive_Dropdowns {
	
	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.manage().window().maximize();
		 
	}
	
	@Test
      public void stat() throws InterruptedException {
		
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);

		
		List<WebElement> s = driver.findElements(By.xpath("//li[@class='ui-menu-item']//a"));
		System.out.println(s.size());
		
		for(WebElement u : s) {
			
			Thread.sleep(1000);

			if(u.getText().equalsIgnoreCase("India")) {
				
				u.click();
				break;
			}
		}
	}
}
