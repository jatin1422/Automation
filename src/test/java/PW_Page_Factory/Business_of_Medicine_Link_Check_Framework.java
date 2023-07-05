package PW_Page_Factory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testng.Abst;

public class Business_of_Medicine_Link_Check_Framework extends Abst {

	public WebDriver driver;

	public Business_of_Medicine_Link_Check_Framework(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ul[@id='menu-business-of-medicine-subspecialities']//li//a")
	List<WebElement> Business_of_medicine_sub_cat_tabs;

	By business_of_medicine_sub_cat_tabs = By.xpath("//ul[@id='menu-business-of-medicine-subspecialities']//li//a");

	@FindBy(xpath = "//a")
	List<WebElement> Business_of_medicine__anchor_link;

	By business_of_medicine__anchor_link = By.xpath("//a");

	@FindBy(xpath = "//img")
	List<WebElement> Business_of_medicine__img_link;

	By business_of_medicine__img_link = By.xpath("//img");

	public void go() {

		driver.get("https://www.physiciansweekly.com/category/business-of-medicine/");

	}

	public void business_of_medicine_link_Check() {

		System.out.println("Page Title   " + driver.getTitle() + "   CurrentURL is  " + driver.getCurrentUrl()
				+ "   Total cat [a] links on this " + Business_of_medicine__anchor_link.size());

		for (WebElement eles : Business_of_medicine__anchor_link) {
			try {
				String link = eles.getAttribute("href");

				if (link.isEmpty()) {

					continue;
				} else if (link.contains("https://pwdev2")) {

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

			}
		}

		System.out.println("Page Title   " + driver.getTitle() + "   CurrentURL is  " + driver.getCurrentUrl()
				+ "   Total cat [img] links on this " + Business_of_medicine__img_link.size());

		for (int j = 0; j < Business_of_medicine__img_link.size(); j++) {

			try {

				String link2 = Business_of_medicine__img_link.get(j).getAttribute("src");

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

			}

		}
	}

	public void business_of_medicine_sub_cat_tabs_link_Check() {

		for (WebElement subcat : Business_of_medicine_sub_cat_tabs) {

			String subcatlink = subcat.getAttribute("href");

			if (subcatlink.isEmpty()) {

				continue;
			}

			String chordkey = Keys.chord(Keys.CONTROL, Keys.ENTER);

			subcat.sendKeys(chordkey);
		}
		
		for (String winHandle : driver.getWindowHandles()) {

			driver.switchTo().window(winHandle);

			
			System.out.println("Page Title   " + driver.getTitle() + "   CurrentURL is  " + driver.getCurrentUrl()
					+ "   Total subcat [a] links on this " + Business_of_medicine__img_link.size());

			for (WebElement eles2 : Business_of_medicine__img_link) {
				try {
					String link1 = eles2.getAttribute("href");

					if (link1.isEmpty()) {

						continue;
					} else if (link1.contains("https://pwdev2")) {

						System.out.println(link1);

					} else if (link1.contains("https://staging")) {

						System.out.println(link1);

					} else if (link1.contains("https://pwga4")) {
						System.out.println(link1);

					}

					else if (link1.contains("https://dev")) {
						System.out.println(link1);

					} else if (link1.contains("http://pwdev2")) {

						System.out.println(link1);

					} else if (link1.contains("http://staging")) {

						System.out.println(link1);

					} else if (link1.contains("http://pwga4")) {
						System.out.println(link1);

					}

					else if (link1.contains("http://dev")) {
						System.out.println(link1);

					}

				} catch (Exception e) {

				}
			}

			System.out.println("Page Title   " + driver.getTitle() + "   CurrentURL is  " + driver.getCurrentUrl()
					+ "   Total subcat [img] links on this " + Business_of_medicine__anchor_link.size());

			for (int k = 0; k < Business_of_medicine__anchor_link.size(); k++) {

				try {

					String link3 = Business_of_medicine__anchor_link.get(k).getAttribute("src");

					if (link3 == null) {

					}

					else if (link3.contains("https://pwdev2")) {

						System.out.println(link3);

					} else if (link3.contains("https://staging")) {

						System.out.println(link3);

					} else if (link3.contains("https://pwga4")) {
						System.out.println(link3);

					}

				} catch (Exception e) {

				}

			}

		}
	}

}
