package EMS;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class To_Do extends Log_in {

	@Test(priority = 2)
	public void todo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sidebar-collapse']//ul/li[3]/a/i")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Add New')]"))).click();
	}

	@Test(priority = 3)
	public void member_project() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='form-group']/input[@name='todo_title']")))
				.sendKeys("Today task8"); //Title changed from here

		WebElement selects0 = driver.findElement(By.xpath("//select[@id='projectId']"));

		Select ds0 = new Select(selects0);

		ds0.selectByVisibleText("Test auto");

		WebElement sel2 = wait

				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@id='show_members_tab']/div/button")));
		sel2.click();

		WebElement textholder = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")));

		textholder.sendKeys("qa");

		List<WebElement> li = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@aria-expanded='true']/ul/li/a")));

		for (WebElement mem : li) {

			if (mem.getText().equals("qa10 tester")) {

				mem.click();
			}
		}

		driver.findElement(By.xpath("//div[@class='form-group']/input[@name='todo_title']")).click();

		LocalDate currentDate = LocalDate.now();

		// Format the date as per your requirements
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		String formattedDate = currentDate.format(formatter);

		WebElement date = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='due_date']")));
		date.sendKeys(formattedDate);

	}

	@Test(priority = 4)
	public void priorty() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement selects1 = driver.findElement(By.xpath("//select[@id='task_priority']"));

		Select ds1 = new Select(selects1);

		ds1.selectByVisibleText("High");

		WebElement text = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea")));

		text.sendKeys("Today test.");

		driver.findElement(By.xpath("//button[@id='add_todo']")).click();

	}

}
