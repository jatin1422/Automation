package PW_Page_Factory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testng.Abst;

public class Deep_Dives_Conditional_Spotlight_Sub_Cat_View_All_Framework extends Abst {

	public WebDriver driver;

	public Deep_Dives_Conditional_Spotlight_Sub_Cat_View_All_Framework(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='posts-blog-feed-module standard post-module et_pb_extra_module module'] //h2/a")
	List<WebElement> Con_Spotlight_subcats_tabs;

	By con_Spotlight_subcats_tabs = By
			.xpath("//div[@class='posts-blog-feed-module standard post-module et_pb_extra_module module'] //h2/a");

	@FindBy(xpath = "//a[@id='tags_load_more']")
	WebElement View_all_btn;

	By view_all_btn = By.xpath("//a[@id='tags_load_more']");

	String URL = "https://www.physiciansweekly.com/spotlight-all/";

	String URL2 = "https://www.physiciansweekly.com/spotlight/therapeutic-spotlight-allergy/";

	public void con_Spotlight_subcats_Tabs() {

		for (int i = 0; i < Con_Spotlight_subcats_tabs.size(); i++) {

			try {

				if (Con_Spotlight_subcats_tabs.get(i).getText().equals("Therapeutic Spotlight - Osteoporosis")) {

					continue;

				}

				String linkUrl = Con_Spotlight_subcats_tabs.get(i).getAttribute("href");

				if (linkUrl.isEmpty()) {

					continue;

				}

				Java_Scriptexecutor execute = new Java_Scriptexecutor(driver);

				String script = "window.open('" + linkUrl + "', '_blank');";

				execute.executescript(script);

			} catch (Exception e) {

			}

		}
	}

	public void view_all_Btn() {

		for (String winHandle : driver.getWindowHandles()) {

			try {
				driver.switchTo().window(winHandle);

				if (driver.switchTo().window(winHandle).getCurrentUrl().equalsIgnoreCase(URL)) {

					continue;
				}

				waitforappear(By.xpath("//div[@class='module post-module']"));

				// String text = driver.findElement(By.xpath("//div[@class='module
				// post-module']")).getText();

				/*
				 * if(text.contains("Not found!")) {
				 * 
				 * System.out.println(driver.getTitle());
				 * 
				 * System.out.println(driver.getCurrentUrl()); }
				 */

				if (View_all_btn.isDisplayed() == true) {

					View_all_btn.click();
				}
				
				else {
					
					continue;
				}
			} catch (Exception e) {

			}

		}}

	/*	Set<String> tab = driver.getWindowHandles();

		Iterator<String> tabs = tab.iterator();

		while (tabs.hasNext()) {

			driver.switchTo().window(tabs.next());

			if (driver.switchTo().window(tabs.next()).getCurrentUrl().equals(URL2)) {

				View_all_btn.click();

				break;

			}

		}

	}*/

	public void go() {

		driver.get("https://www.physiciansweekly.com/spotlight-all/");
	}

}
