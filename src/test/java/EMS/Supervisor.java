package EMS;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import First_Framework.Admin_Login;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Supervisor {

	WebDriver driver;

	@Test
	public void setup() {

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--start-maximized");
		co.addArguments("--allow-remote-origin=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);

		driver.get("https://agencyva.vision/beta/login/admin");
	}

	@Test(priority = 1)
	public void login() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@class='m-t']/a[3]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")))
				.sendKeys("005qatest@gmail.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")))
				.sendKeys("primo@123");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']"))).click();

	}
	
	  @Test(priority = 2) public void activites() throws InterruptedException,
	  IOException {
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.
	  xpath("//i[@class='fa fa-tasks']"))).click();
	  
	  WebElement projectid =
	  driver.findElement(By.xpath("//select[@name='project_id']"));
	  
	  Select select = new Select(projectid);
	  
	  select.selectByVisibleText("Test auto");
	  
	  Thread.sleep(2000);
	  
	  WebElement memberid = wait
	  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	  "//select[@name='user_id']")));
	  
	  Select select1 = new Select(memberid);
	  
	  select1.selectByVisibleText("qa10 tester");
	  
	  WebElement ssstatus = wait
	  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	  "//select[@name='status']")));
	  
	  Select select2 = new Select(ssstatus);
	  
	  select2.selectByVisibleText("Approved");
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	  "//input[@id='search_btn']"))).click();
	  
	  Thread.sleep(3000);
	  
	  File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  
	  FileUtils.copyFile(scr, new File(
	  "C:\\Users\\Primotech\\Pictures\\Screenshots\\supervisoractivityyscreenshot.png"
	  ));
	  
	  }
	  
	  @Test(priority = 3) public void approvetodo() throws IOException,
	  InterruptedException { WebDriverWait wait = new WebDriverWait(driver,
	  Duration.ofSeconds(20));
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	  "//div[@class='sidebar-collapse']//ul/li[3]/a/i"))) .click();
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.
	  xpath("//a[normalize-space()='To Be Reviewed']"))) .click();
	  
	  List<WebElement> projectnames = wait
	  .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
	  "//table//tr")));
	  
	  for (WebElement projectname : projectnames) {
	  
	  try { if (projectname.getText().contains("Test auto")) {
	  
	  // projectname.findElement(By.xpath("//td[13]")).click();
	  
	  WebElement action =
	  projectname.findElement(By.xpath("//select[@id='action']"));
	  
	  Select select3 = new Select(action);
	  
	  select3.selectByVisibleText("Approve/Review"); Thread.sleep(3000);
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
	  "//button[normalize-space()='Yes']"))) .click();
	  
	  Thread.sleep(3000);
	  
	  File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  
	  FileUtils.copyFile(scr, new File(
	  "C:\\Users\\Primotech\\Pictures\\Screenshots\\Manager_and_supervisorapprovetodo.png"
	  )); } } catch (Exception e) {
	  
	  }
	  
	  }
	  
	  }
	  
	  @Test(priority = 4) public void reports() throws InterruptedException,
	  IOException {
	  
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	  
	  WebElement rep1 = wait
	  
	  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	  "//span[normalize-space()='Reports']")));
	  
	  rep1.click();
	  
	  WebElement rep2 = wait
	  
	  .until(ExpectedConditions .visibilityOfElementLocated(By.
	  xpath("//a[normalize-space()='Member Reports']")));
	  
	  rep2.click();
	  
	  WebElement rep3 = wait
	  
	  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	  "//select[@id='userDropdown']")));
	  
	  Select drop = new Select(rep3); drop.selectByVisibleText("qa10 tester");
	  
	  WebElement rep11 = wait
	  
	  .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
	  "//input[@name='submit']")));
	  
	  rep11.click();
	  
	  Thread.sleep(3000);
	  
	  File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  
	  FileUtils.copyFile(src, new
	  File("C:\\Users\\Primotech\\Pictures\\Screenshots\\Memberreport.png"));
	  
	  }
	 

	@Test(priority = 5)
	public void approveprojectreport() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement report = wait

				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Reports']")));

		report.click();

		WebElement projectreport = wait

				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Project Reports']")));

		projectreport.click();

		WebElement projectid = driver.findElement(By.xpath("//select[@name='project_id']"));

		Select sel99 = new Select(projectid);

		sel99.selectByVisibleText("Test auto");

		Thread.sleep(2000);

		WebElement memid = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='user_id']")));

		Select sel1 = new Select(memid);

		sel1.selectByVisibleText("qa10 tester");

		driver.findElement(By.xpath("//input[@id='search_btn']")).click();

		try {

			Thread.sleep(2000);

			WebElement action7 = driver.findElement(By.xpath("//select[@class=' selectpicker ul_projectreport'][1]"));

			action7.click();

			Select select4 = new Select(action7);

			select4.selectByVisibleText("View");

			Thread.sleep(3000);

			Set<String> s = driver.getWindowHandles();

			Iterator<String> ss = s.iterator();

			String first = ss.next();

			String Second = ss.next();

			driver.switchTo().window(Second);

			WebElement action6 = driver.findElement(By.xpath("//select[@id='action']"));

			Select select5 = new Select(action6);

			select5.selectByVisibleText("Approve");

			Thread.sleep(3000);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='confirm']"))).click();

			Thread.sleep(3000);

			File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scr, new File("C:\\Users\\Primotech\\Pictures\\Screenshots\\projectreportapproved.png"));
		} catch (Exception e) {

		}

	}

	@Test(priority = 6)
	public void reportcheck_in_client_summary() throws InterruptedException, IOException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		Set<String> s = driver.getWindowHandles();

		Iterator<String> ss = s.iterator();

		String first = ss.next();

		String Second = ss.next();

		driver.switchTo().window(first);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//img[@src='https://agencyva.vision/beta/ui/img/clinet-report.png']"))).click();

		Thread.sleep(5000);

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scr, new File("C:\\Users\\Primotech\\Pictures\\Screenshots\\supervisorclient_summary.png"));

	}

}
