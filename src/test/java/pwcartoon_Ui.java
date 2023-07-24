
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pwcartoon_Ui {

	WebDriver driver;

	@Test
	public void main() throws InterruptedException {

		ChromeOptions opt = new ChromeOptions();

		opt.addArguments("--start-maximized");

		opt.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(opt);

		driver.get("https://www.physiciansweekly.com/category/cartoons/");

		Thread.sleep(10000);

		List<String> css = new ArrayList<String>();

		css.add("font-size");
		css.add("font-family");
		css.add("font-weight");
		css.add("line-height");
		css.add("letter-spacing");

		for (String cs : css) {

			String size = driver.findElement(By.cssSelector(".is_archive")).getCssValue(cs);
			System.out.println(size);

		}
	}
}
