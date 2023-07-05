package Testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

  public class Abst {
	
	public WebDriver driver;
	
	public Abst(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void waitforappear(By findby) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitforappears(By findby2) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findby2));
	}
	
	public void waitfordisappear(By name) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(name));
	}
	public void waitforClick(WebElement next_button) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(next_button)).click();
		
	}
	public void waitforappearele(WebElement findby) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOf(findby));
	}
}
