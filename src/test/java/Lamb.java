import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lamb {
	WebDriver driver;
	@Test
	public void setup() throws InterruptedException {
		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
		List<String> listele = elements.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(listele);
		List<String> sorted = listele.stream().sorted().collect(Collectors.toList());
		System.out.println(sorted);
		Assert.assertTrue(listele.equals(sorted));
		
	}
}

