package EMS;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Manager {
	WebDriver driver;

	@BeforeClass
	public void setup() {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--start-maximized");
		co.addArguments("--allow-remote-origin=");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);

		driver.get("https://agencyva.vision/beta/login/admin");
	}

	@Test(priority = 1)
	public void login() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")))
				.sendKeys("006qatest@gmail.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")))
				.sendKeys("primo@123");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-file-text']"))).click();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//img[@src='https://agencyva.vision/beta/ui/img/clinet-report.png']")))
				.click();

		Thread.sleep(3000);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("C:\\Users\\Primotech\\Pictures\\\\Screenshots\\ManagerClientsummary.png"));

	}

	@Test(priority = 2)
	public void Manager_screenshotarrow() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-tasks']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='feed-activity-list ajax_list']//div//div[1]//div[1]//div[1]//div[1]//a[1]//img[1]")))
				.click();

		Thread.sleep(2000);

		Actions builder = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//a[@aria-label='Next image']"));
		builder.moveToElement(element).build().perform();

		Thread.sleep(2000);

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scr, new File("C:\\Users\\Primotech\\Pictures\\Screenshots\\Manager_screenshotarrow.png"));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='lb-close']"))).click();
	}

	@Test(priority = 3)
	public void Manager_check_member_report_date_time() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='fa fa-clock-o']"))).click();

		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//img[@src='https://agencyva.vision/beta/ui/img/member_time_sheet.png']"))).click();

		Thread.sleep(2000);

		WebElement memdropdown = driver.findElement(By.xpath("//select[@id='userDropdown']"));

		Select selectmem = new Select(memdropdown);

		selectmem.selectByVisibleText("qa10 tester");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='submit']"))).click();

		Thread.sleep(2000);

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scr,
				new File("C:\\Users\\Primotech\\Pictures\\Screenshots\\Manager_check_member_report_date_time.png"));

	}

	@Test(priority = 4)
	public void Manager_add_and_assign_todo() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='sidebar-collapse']//ul/li[3]/a/i")))
				.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Add New')]"))).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='form-group']/input[@name='todo_title']")))
				.sendKeys("Today task"); // Title changed from here

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

			try {

				if (mem.getText().equals("qa10 tester")) {

					mem.click();
				}
			} catch (Exception e) {

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
		WebElement selects1 = driver.findElement(By.xpath("//select[@id='task_priority']"));

		Select ds1 = new Select(selects1);

		ds1.selectByVisibleText("High");

		WebElement text = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea")));

		text.sendKeys("Today test.");

		Thread.sleep(2000);

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scr,
				new File("C:\\Users\\Primotech\\Pictures\\Screenshots\\Manager_add_and_assign_todo.png"));

		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='modal-content animated fadeIn']//button[@type='button'][normalize-space()='Close']")))
				.click();

	}

	@Test(priority = 5)
	public void Manager_report() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement rep1 = wait

				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Reports']")));

		rep1.click();

		WebElement rep2 = wait

				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Member Reports']")));

		rep2.click();

		WebElement rep3 = wait

				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='userDropdown']")));

		Select drop = new Select(rep3);
		drop.selectByVisibleText("qa10 tester");

		WebElement rep4 = wait

				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='submit']")));

		rep4.click();

		Thread.sleep(3000);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("C:\\Users\\Primotech\\Pictures\\Screenshots\\Manager_report.png"));
	}

	@Test(priority = 5)
	public void Manager_screenshot_view_button() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement rep = wait

				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Reports']")));

		rep.click();

		WebElement rep3 = wait

				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//img[@src='https://agencyva.vision/beta/ui/img/clinet-report.png']")));

		rep3.click();

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody/tr[@role='row']/td[8]/a[1][1]/i[1]")))
				.click();

		Set<String> window = driver.getWindowHandles();
		Iterator<String> windows = window.iterator();

		String first = windows.next();

		String second = windows.next();

		driver.switchTo().window(second);

		Thread.sleep(2000);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//label[normalize-space()='Select All Screenshots']"))).click();

		WebElement selects2 = driver.findElement(By.xpath("//select[@id='action']"));

		Select ds2 = new Select(selects2);

		ds2.selectByVisibleText("Visible to Client");

		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes']")))
				.click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//img[@src='https://agencyva.vision/beta/ui/img/clinet-report.png']"))).click();

		Thread.sleep(2000);

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("// tbody/tr[@role='row']/td[9]/a[1][1]/i[1]")))
				.click();

		Set<String> window2 = driver.getWindowHandles();
		Iterator<String> windows2 = window2.iterator();

		String first2 = windows2.next();

		String second2 = windows2.next();

		String third2 = windows2.next();

		driver.switchTo().window(third2);

		Thread.sleep(3000);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src, new File("C:\\Users\\Primotech\\Pictures\\Screenshots\\clientscreenshot.png"));

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//img[@src='https://agencyva.vision/beta/ui/img/clinet-report.png']"))).click();

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Preview']"))).click();

		Set<String> window1 = driver.getWindowHandles();
		Iterator<String> windows1 = window1.iterator();

		String first1 = windows1.next();

		String second1 = windows1.next();
		String third1 = windows1.next();

		String fourth1 = windows1.next();

		driver.switchTo().window(fourth1);

		Thread.sleep(2000);

		File src2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src2, new File("C:\\Users\\Primotech\\Pictures\\Screenshots\\previewcreenshot.png"));

		Thread.sleep(2000);

		driver.switchTo().window(first1);

		WebElement selects5 = driver.findElement(By.xpath("//select[@id='userDropdown']"));

		Select ds5 = new Select(selects5);

		ds5.selectByVisibleText("Test_client");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Search']"))).click();

		Thread.sleep(5000);

		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//label[normalize-space()='Select All Reports']"))).click()
				.perform();

		WebElement selects6 = driver.findElement(By.xpath("//select[@onchange='return approve_reports(this);']"));

		Select ds6 = new Select(selects6);

		ds6.selectByVisibleText("Approve/Send report");

		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Yes']")))

				.click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='confirm']"))).click();

		Thread.sleep(300000);

	}

}
