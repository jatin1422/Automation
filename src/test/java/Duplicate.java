import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Duplicate {

	WebDriver driver;

	@Test
	public void main() {

		ChromeOptions opt = new ChromeOptions();

		opt.addArguments("--start-maximized");

		opt.addArguments("--remote-allow-origins=*");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver(opt);

		driver.get("https://www.physiciansweekly.com/category/allergy-immunology/");

		List<WebElement> d = driver.findElements(By.xpath("//section//div//div[@class='article-logo-cnt']//a"));
		ArrayList<String> ar = new ArrayList<String>();

		Set<String> data = new HashSet<String>();

		for (WebElement dd : d) {

			ar.add(dd.getText());
		}

		for (String ddd : ar) {

			if (data.add(ddd) == false) {

				System.out.println("Duplicate Articles " + ddd);
			}

		}

		

		/*
		 * for (int i = 0; i < ar.size(); i++) { // outer loop for (int j = i + 1; j <
		 * ar.size(); j++) { // inner loop if (ar.get(i).equals(ar.get(j))) {
		 * System.out.println("Duplicate element found: " + ar.get(i)); } }
		 */

	}
}

/*
 * if (dd.getText().equalsIgnoreCase(
 * "Trends in the Prevalence of Chronic Non-Communicable Diseases and Multimorbidity across Socioeconomic Gradients in Rural Southwest China."
 * )) { duplicate++;
 * 
 * System.out.println(dd.getText()); }
 */
