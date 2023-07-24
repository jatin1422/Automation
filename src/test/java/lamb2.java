import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class lamb2 {
	WebDriver driver;

	@Test
	public void setup() throws InterruptedException {
		WebDriverManager.edgedriver().setup();

		driver = new EdgeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();

		List<String> price;
		do {
			List<WebElement> elements = driver
					.findElements(By.xpath("//table[@class='table table-bordered']/tbody/tr/td[1]"));
			price = elements.stream().filter(s -> s.getText().contains("Beans")).map(s -> getprice(s))

					.collect(Collectors.toList());
			price.forEach(s -> System.out.println(s));
			if (price.size() < 1) {
				driver.findElement(By.xpath("(//a[@role='button'])[7]")).click();
			}
		} while (price.size() < 1);

	}

	private static String getprice(WebElement s) {

		String tx = s.findElement(By.xpath("//following-sibling::td[1]")).getText();

		return tx;
	}
}
