import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHand {
	WebDriver driver;

	@Test
	public void setup() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@id='opentab']")).click();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> u = s.iterator();
		String Parent, Child;
		Parent = u.next();
		Child = u.next();
		driver.switchTo().window(Child);
		System.out.println(driver.findElement(By.xpath("//a[@class='btn btn-theme btn-sm btn-min-block']")).getText());

		String text = driver.findElement(By.xpath("(//strong)[1]")).getText();
		String[] st = text.split("&");
		String ss = st[0].trim();
		;
		String ss2 = st[1].trim();
		System.out.println(ss);
		System.out.println(ss2);
		List<WebElement> ddd = driver.findElements(By.xpath("//div[@class='navbar-collapse collapse clearfix']//li"));
		for (WebElement l : ddd) {

			System.out.println(l.getText());

		}
		driver.switchTo().window(Parent);
	}
}
