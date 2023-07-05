package DYSMD;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkboxes {
	
	WebDriver driver;

	@Test(priority=1)
	public void setup() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver .get("https://www.dysmd.com/beta/front/user");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rashmika");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("8930179062");

		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		Thread.sleep(2000);

		/*
		driver.findElement(By.xpath("//ul/li[3]/a[contains(text(),'Health Inventory')]")).click();

		Thread.sleep(1000);
		
	List <WebElement> d =	driver.findElements(By.xpath("//form/div[1]/div/div/div/div/span/label/input"));
	Thread.sleep(1000);
	for(WebElement s : d) {
	
		s.click();
	}
	List <WebElement> n =	driver.findElements(By.xpath("//form/div[1]/div/div/div/input"));
	Thread.sleep(2000);
	for(WebElement m : n) {
	 Thread.sleep(1000);
		m.click();
	}*/

	}
	 
	@Test(priority=2)
	public void Abs() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//a[normalize-space()='My Medical Chart']")).click();
			Thread.sleep(2000);

		driver.findElement(By.xpath("//ul/li[4]/a[contains(.,'Family History')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='med_tab_list']/ul//li[2]")).click();
	
	List<WebElement> uk = driver.findElements(By.xpath("//tbody/tr/td/span/i"));
	
	String su = "Intestinal infections due to other anaerobes: Father at age of 12";
	for(WebElement sd : uk) {
		Thread.sleep(1000); 
		
		sd.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
		Thread.sleep(1000);
	
		try {
		driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
		Thread.sleep(2000);}
		catch(StaleElementReferenceException e) {
		
		}
	    }
	    }
	  
	@AfterClass
	public void teardown() throws InterruptedException {
		
  Thread.sleep(2000);
  //Log out
		
 driver.findElement(By.xpath("//div[@class='right-content']/div/div/div/div/div/div/div/a")).click();
 Thread.sleep(2000);
 
 driver.findElement(By.xpath("//div[@class='right-content']/div/div/div/div/div/div/div/a")).click();

 Thread.sleep(2000);

	driver.findElement(By.xpath("//div[@class='right-content']/div/div/div/div/div/div/div/div/ul/li[4]")).click();
	
	Thread.sleep(4000);
		driver.quit(); 
}}
