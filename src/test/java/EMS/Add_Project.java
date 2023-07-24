package EMS;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Add_Project extends Log_in {

	

	@Test(priority = 2)
	public void add() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Projects']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary margin10']")))
				.click();

	}

	@Test(priority = 3)
	public void form() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='project_name']")))
				.sendKeys("TestAuto1"); // ------- Change the project name from here
		WebElement sel = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-id='is_billable']")));
		sel.click();
		WebElement select01 = driver.findElement(By.xpath("//select[@id='is_billable']"));

		Select d01 = new Select(select01);

		d01.selectByVisibleText("Yes");
		WebElement sel2 = wait

				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-id='client_id']")));

		sel2.click();

		WebElement select0 = driver.findElement(By.xpath("//select[@id='client_id']"));

		Select d0 = new Select(select0);

		d0.selectByVisibleText("Test Client");

		driver.findElement(By.xpath("//input[@id='weekly_hours']")).sendKeys("30");

	}

	@Test(priority = 4)
	public void form2() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement sel3 = wait

				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-id='user_id']")));

		sel3.click();

		WebElement select = driver.findElement(By.xpath("//select[@id='user_id']"));

		Select d = new Select(select);

		d.selectByVisibleText("Test Auto QA");

		WebElement sel4 = wait

				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-id='supervisor_id']")));

		sel4.click();

		WebElement select2 = driver.findElement(By.xpath("//select[@id='supervisor_id']"));

		Select d2 = new Select(select2);

		d2.selectByVisibleText("test Smoke supervisor");

	}

	@Test(priority = 5)
	public void form3() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement sel5 = wait

				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-id='manager_id']")));

		sel5.click();

		WebElement select3 = driver.findElement(By.xpath("//select[@id='manager_id']"));

		Select d3 = new Select(select3);

		d3.selectByVisibleText("test Smoke manager");

		driver.findElement(By.xpath("//button[normalize-space()='Save changes']")).click();
		// driver.findElement(By.xpath("//div[@id='myModal2']//button[@type='button'][normalize-space()='Close']")).click();

	}

	@AfterClass
	public void teardown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement drop = wait

				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//span[@class='block m-t-xs font-bold name_custom']")));

		drop.click();

		WebElement logout = wait

				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Logout']")));

		logout.click();

	}
}
