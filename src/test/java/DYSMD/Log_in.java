package DYSMD;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Log_in {

	WebDriver driver;

	@Test(priority=1)
	public void setup() throws InterruptedException {
		
	/*	WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		*/
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.dysmd.com/beta/front/user");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='Log In']")).click();
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rashmika");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

		
		/*	 
		String [] t = text.split(" ");
		String u []= t[0].split("o");
		System.out.println(u[0]);
		System.out.println(u[1]);
		*/	 
	}
	}


	
//driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
