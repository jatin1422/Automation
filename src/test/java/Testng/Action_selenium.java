package Testng;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action_selenium {

	WebDriver driver;

	public Action_selenium(WebDriver driver) {

		this.driver = driver;

	}

	public void click( WebDriver driver) {

		Actions act = new Actions(driver);

		act.click();

	}
	public void sendkeys(WebElement ele, WebDriver driver, String text) {

		Actions act = new Actions(driver);

		act.sendKeys(ele , text).build().perform();

	}
	public void movetoelement(WebElement ele, WebDriver driver) {

		Actions act = new Actions(driver);

		act.moveToElement(ele).build().perform();

	}

}
