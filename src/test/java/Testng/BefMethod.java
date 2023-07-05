package Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BefMethod {

	WebDriver driver;

//	@Parameters("browser")
	@BeforeMethod
	public void setup() throws InterruptedException {

		ChromeOptions opt = new ChromeOptions();

		opt.addArguments("--start-maximized");

		opt.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(opt);

	}

	@Test()
	public void first() {

		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("hello7@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Angel@123");
		driver.findElement(By.xpath("//input[@class='btn btn-block login-btn']")).click();

	}

	@Test()
	public void first2() {

		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("helo1@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Angel@123");
		driver.findElement(By.xpath("//input[@class='btn btn-block login-btn']")).click();

	}

	@Test()
	public void first3() {

		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("hell1@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Angel@123");
		driver.findElement(By.xpath("//input[@class='btn btn-block login-btn']")).click();

	}

	@Test()
	public void first4() {

		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("hello1@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Agel@123");
		driver.findElement(By.xpath("//input[@class='btn btn-block login-btn']")).click();

	}
}
