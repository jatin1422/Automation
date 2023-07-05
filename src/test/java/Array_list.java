import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Array_list {

	WebDriver driver;

	@Test
	public void setup() throws InterruptedException {

		int j = 0;
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		https://rahulshettyacademy.com/greenkart/#/offers
		driver.manage().window().maximize();

		java.util.List<WebElement> product = driver.findElements(By.xpath("//h4[@class='product-name']"));
		String li[] = { "Brocolli", "Tomato" };

		List s = Arrays.asList(li);

		for (int i = 0; i < product.size(); i++) {

			String[] name = product.get(i).getText().split("-");
			String ss = name[0].trim();

			// System.out.println(product.get(i).getText());

			if (s.contains(ss)) {
				j++;
				driver.findElements(By.xpath("//button[.='ADD TO CART']")).get(i).click();

				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[text()='✔ ADDED']")));
				if (j == li.length) {
					break;
				}
			}
		}
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter promo code']")))
				.sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();

		System.out.println(
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")))
						.getText());

		driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();

	}
}
