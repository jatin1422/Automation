package PW_Page_Factory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testng.Abst;

public class Deep_Dives_Doctor_Voice_Link_Check_Framework extends Abst {

	public WebDriver driver;

	public Deep_Dives_Doctor_Voice_Link_Check_Framework(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//section[@class='category-right-list']//ul//li//a")
	List<WebElement> Doctor_voice_sub_cat_tabs;

	By doctor_voice_sub_cat_tabs = By.xpath("//section[@class='category-right-list']//ul//li//a");

	@FindBy(xpath = "//a")
	List<WebElement> Doctor_voice_sub_cat_tabs_anchor_link;

	By doctor_voice_sub_cat_tabs_anchor_link = By.xpath("//a");
	
	@FindBy(xpath = "//img")
	List<WebElement> Doctor_voice_sub_cat_tabs_img_link;

	By doctor_voice_sub_cat_tabs_img_link = By.xpath("//img");


	public void go() {

		driver.get("https://www.physiciansweekly.com/category/doctors-voice/");

	}

	public void doctor_voice_sub_cat_Tabs() {

		for (WebElement listt : Doctor_voice_sub_cat_tabs) {

			String link = listt.getAttribute("href");

			Java_Scriptexecutor exe = new Java_Scriptexecutor(driver);

			String script = "window.open('" + link + "', '_blank');";

			exe.executescript(script);

		}

	}
	
	
	public void doctor_voice_sub_cat_tabs_link_Check() {
		for (String win : driver.getWindowHandles()) {

			try {
				driver.switchTo().window(win);

			} catch (Exception e) {

			}

				
				System.out.println("Page Title   " + driver.getTitle() + "   CurrentURL is  " + driver.getCurrentUrl()
				+ "   Total [a] links on this " + Doctor_voice_sub_cat_tabs_anchor_link.size());

				for (WebElement listtt : Doctor_voice_sub_cat_tabs_anchor_link) {
					try {
						String link = listtt.getAttribute("href");

						if (link == null) {

						}

						else if (link.contains("https://pwdev2")) {

							System.out.println(link);

						} else if (link.contains("https://staging")) {

							System.out.println(link);

						} else if (link.contains("https://pwga4")) {
							System.out.println(link);

						}

						else if (link.contains("https://dev")) {
							System.out.println(link);

						} else if (link.contains("http://pwdev2")) {

							System.out.println(link);

						} else if (link.contains("http://staging")) {

							System.out.println(link);

						} else if (link.contains("http://pwga4")) {
							System.out.println(link);

						}

						else if (link.contains("http://dev")) {
							System.out.println(link);

						}

					} catch (Exception e) {

						System.out.println(e);
					}
				}
				

				System.out.println("Page Title   " + driver.getTitle() + "   CurrentURL is  " + driver.getCurrentUrl()
						+ "   Total [img] links on this " + Doctor_voice_sub_cat_tabs_img_link.size());

				for (int j = 0; j < Doctor_voice_sub_cat_tabs_img_link.size(); j++) {

					try {

						String link2 = Doctor_voice_sub_cat_tabs_img_link.get(j).getAttribute("src");

						if (link2 == null) {

						}

						else if (link2.contains("https://pwdev2")) {

							System.out.println(link2);

						} else if (link2.contains("https://staging")) {

							System.out.println(link2);

						} else if (link2.contains("https://pwga4")) {
							System.out.println(link2);

						}

					} catch (Exception e) {

						System.out.println(e);
					}

				}

			
		}

	}
	

}
