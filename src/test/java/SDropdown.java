import java.util.List;

import org.apache.commons.compress.harmony.pack200.IntList;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SDropdown {
	 
	WebDriver driver;
	

	@BeforeClass
	public void setup() {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		 
	}
	
	@Test
	public void main() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("ind");
		Thread.sleep(2000);
		  List<WebElement> d = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
	int count =	  d.size();
	
		 System.out.println(count);
		 d.get(count-2).click();
						
		 System.out.println(driver.findElement(By.xpath("//input[@id='autosuggest']")).getAttribute("value"));
		
	}


}
