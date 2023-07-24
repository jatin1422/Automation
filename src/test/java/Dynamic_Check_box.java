
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dynamic_Check_box {
	 
		WebDriver driver;
		

		@BeforeClass
		public void setup() throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Vivek");
			
			driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
			
			Thread.sleep(3000);
	   	 driver.switchTo().alert().accept();
		
			 
		}
		@Test(priority =1)
		 public void main() {
				
				List <WebElement> d =	driver.findElements(By.xpath("//fieldset[contains(.,'Checkbox Example')]/label/input"));
				
				for(WebElement s : d) {
				
					s.click();
				
					Assert.assertEquals(s.isSelected(), true);
				}
		 }
		
		
		@Test(priority =2)
		public void radiobutton() throws InterruptedException {
			
			List <WebElement> r = driver.findElements(By.xpath("//fieldset[contains(.,'Radio Button Example')]/label/input"));
			
		
			for(WebElement a : r) {
				
				System.out.println(a.getAttribute("value"));
				
				String value = a.getAttribute("value");
				
				Thread.sleep(2000);
				
				if(value.equals("radio2")) {
					
					a.click();
					break;
		
				}	
		}		
}
		
		
		
		
		
		
}