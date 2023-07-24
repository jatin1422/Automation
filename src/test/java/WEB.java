import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WEB {

	public static void main(String[] args) throws InterruptedException {
		
	 WebDriver driver;
	 
	 WebDriverManager.chromedriver().setup();
	 
	 driver = new ChromeDriver();
	 
	 driver.get("https://www.google.com/");
	 
	  
		
 WebElement w =	 driver.findElement(By.xpath("//input[@title='Search']"));
  w.sendKeys("Facebook");
   w.sendKeys(Keys.ENTER);
    
   String title = "Facebook - Google Search";
   
   
   if(title.equalsIgnoreCase(driver.getTitle())) {
   driver.quit();
   }
   
   else {
	   
	   System.out.println("fail");
   }
  
	 
	 
	}

}
