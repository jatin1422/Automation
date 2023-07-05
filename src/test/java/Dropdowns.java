import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdowns 
     {
	 
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	  {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		 
    	}
	
	   @Test(priority=1)
       public void stat() throws InterruptedException
	   {
    	  
		WebElement dd = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']"));

		dd.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR']//a[.=' Bengaluru (BLR)']")).click();
		
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[.=' Hyderabad (HYD)']")).click();
		Thread.sleep(2000);

		
		List<WebElement> dd1 = driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]//td//a"));
		Thread.sleep(2000);

		for(WebElement s : dd1) 
		{
			Thread.sleep(1000);

		if(s.getText().equals("19"))
		{
			
			s.click();
			break;
		}
		
		}	
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).click();
		
		List<WebElement> dd2 =  driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[2]//tr//td//a"));
		
		for(WebElement s1 : dd2)
		{
			
			Thread.sleep(1000); 

		if(s1.getText().equals("2"))
		{
			
		                      	s1.click();
			break;
		}
		
		}	
		  
		driver.findElement(By.id("divpaxinfo")).click();
		
		Thread.sleep(1000); 
          
		for(int i = 1; i<=4; i++)
		{
		
		driver.findElement(By.id("hrefIncAdt")).click();
	    }
        driver.findElement(By.id("btnclosepaxoption")).click();
  
       	Thread.sleep(1000); 

        List<WebElement> dsd = driver.findElements(By.xpath("//div[@class='row1 padding-bottom-3 home-dis-checkboxes']//div"));
     
	 	Thread.sleep(2000); 
		
		System.out.println(dsd.size());
             
         for(WebElement sds : dsd) 
         {	   	 
    	 System.out.println(sds.getText());
    	 if(sds.getText().equalsIgnoreCase("Senior Citizen")) 
    	  { 
    	 sds.click();
    	  }
    	 
         }
         Assert.assertFalse(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_Unmr']")).isSelected());
 
	    }
	   
	   @Test(priority=2)
	   public void next() {
		   
		   driver.findElement(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_0']")).click();
		   
	
		   //	   Assert.assertFalse(driver.findElement(By.xpath("//label[@for='ctl00_mainContent_rbtnl_Trip_0']")).isEnabled());
		  if(( driver.findElement(By.xpath("//div[@id='Div1']")).getAttribute("style")).contains("0.5")) {
			  
			  Assert.assertTrue(true);
		  }
		  else {
			  Assert.assertFalse(false);
		  }
		  
		  driver.close();
	   }
         }