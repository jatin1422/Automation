package DYSMD;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register_Page {

	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://prep.dysmd.com/user/register");
		 
	}
	
	@Test(dataProvider="d")
	public void register(String email,String username,String password,String cpassword,String date) throws InterruptedException {
		WebElement A= 	driver.findElement(By.xpath("//input[@id='email']"));
		A.sendKeys(email);
		WebElement B=	driver.findElement(By.xpath("//input[@id='username']"));
		B.sendKeys(username);
		WebElement C=	driver.findElement(By.xpath("//input[@id='password']"));
		C.sendKeys(password);
		WebElement D=	driver.findElement(By.xpath("//input[@id='confirm_password']"));
		D.sendKeys(cpassword);
		WebElement E=		driver.findElement(By.xpath("//input[@id='birthday']"));
		E.sendKeys(date);
		
	WebElement dd =	driver.findElement(By.xpath("//select[@id='lang']"));
	dd.click();
		Select s = new Select(dd);
		s.selectByIndex(0);
		
		driver.findElement(By.xpath("//input[@id='registform']")).click();
		
		A.clear();
		B.clear();
		C.clear();
		D.clear();
		E.clear();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[normalize-space()='Save & Continue']")).click();
		
		

		Thread.sleep(2000);
		
		
	WebElement b = driver.findElement(By.id("dropdownMenuLink"));
	
	b.click();
     Select dd1 = new Select(b);
     
     dd1.selectByIndex(1);
  

	
	
	

	}
	@DataProvider(name="d")
	public Object[][]dp() throws IOException{
		
		String path ="C:\\Users\\Primotech\\Documents\\DYSMD_11.xlsx";
		
		XLUtility util = new XLUtility(path);
		
		int r = util.getRowCount("Sheet1");
		System.out.println(r);
		
		int c = util.getCellCount("Sheet1", 1);
		System.out.println(c);

		Object [][]d= new Object[r][c];                
		for(int i=1;i<=r;i++) {
			for(int j=0;j<c;j++) {
				
		 d[i-1][j]=util.getCellData("Sheet1", i, j);
			}
			}
		
		return d;
		
	}
	
	
	
	
	//a[normalize-space()='Save & Continue']
	//h3[normalize-space()='Initial Information']
}
