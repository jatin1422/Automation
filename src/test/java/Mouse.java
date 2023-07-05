
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse {
	WebDriver driver;

	@Test
	public void setup() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

		driver.get(
				"https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_7hz2t19t5c_e&adgrpid=58355126069&hvpone=&hvptwo=&hvadid=486458706470&hvpos=&hvnetw=g&hvrand=11095094161052949774&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9300670&hvtargid=kwd-10573980&hydadcr=14453_2154373");
		driver.manage().window().maximize();

		WebElement a = driver.findElement(By.xpath("(//a[@class='nav-a nav-a-2   nav-progressive-attribute'])[1]"));

		Actions action = new Actions(driver);

		action.moveToElement(a).contextClick().build().perform();

		action.moveToElement(driver.findElement(By.xpath("//form[@id='nav-search-bar-form']"))).click()
				.keyDown(Keys.SHIFT).sendKeys("health products").doubleClick().build().perform();
		

	}
}
