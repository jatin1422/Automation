package PW_Page_Factory;

import java.net.URI;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testng.Abst;

public class Broke_404 extends Abst {

	public WebDriver driver;

	public Broke_404(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ul[@class='et-menu nav']//li//a")
	List<WebElement> Catagories_new_pages_sub_cat_tabs;

	By catagories_new_pages_sub_cat_tabs = By.xpath("//ul[@class='et-menu nav']//li//a");

	@FindBy(xpath = "//a")
	List<WebElement> Anchor_link;

	By anchor_link = By.xpath("//a");

	@FindBy(xpath = "//img")
	List<WebElement> Img_link;

	By img_link = By.xpath("//img");

	public void go(String URL) {

		driver.get(URL);

	}

	public void new_cat_page_Linkcheck() {

		System.out.println("Page Title   " + driver.getTitle() + "   CurrentURL is  " + driver.getCurrentUrl()
				+ "   Total cat [a] links on this " + Anchor_link.size());

		for (WebElement eles : Anchor_link) {
			{

				try {
					String link = eles.getAttribute("href");

					HttpsURLConnection ht = (HttpsURLConnection) new URL(link).openConnection();

					ht.setRequestMethod("HEAD");

					ht.connect();

					int Status = ht.getResponseCode();

					if (Status == 404) {

						System.out.println(link + " " + Status);

					}

					else if (Status > 400) {

						System.out.println(link + " " + Status);

					}
				} catch (Exception e) {

				}
			}

		}

		for (int j = 0; j < Img_link.size(); j++) {

			try {
				String link2 = Img_link.get(j).getAttribute("src");

				HttpsURLConnection ht = (HttpsURLConnection) new URL(link2).openConnection();

				ht.setRequestMethod("HEAD");

				ht.connect();

				int Status = ht.getResponseCode();

				if (Status == 404) {

					System.out.println(link2 + " " + Status);

				}

				else if (Status > 400) {

					System.out.println(link2 + " " + Status);

				}
			} catch (Exception e) {

			}
		}

	}
}
