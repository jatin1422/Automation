import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames_Drag_Drop {
	WebDriver driver;

	@Test
	public void setup() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement cl = driver.findElement(By.xpath("//div[@id='draggable']"));
		Actions act = new Actions(driver);

		Thread.sleep(3000);
		act.dragAndDrop(cl, driver.findElement(By.xpath("//div[@id='droppable']"))).build().perform();

	}
}