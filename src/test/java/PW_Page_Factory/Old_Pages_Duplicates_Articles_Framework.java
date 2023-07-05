package PW_Page_Factory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testng.Abst;

public class Old_Pages_Duplicates_Articles_Framework extends Abst {

	public WebDriver driver;

	public Old_Pages_Duplicates_Articles_Framework(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ul[@class='Featured-list']//li//a")
	List<WebElement> Catagories_old_pages_sub_cat_tabs;

	By catagories_old_pages_sub_cat_tabs = By.xpath("//ul[@class='Featured-list']//li//a");

	@FindBy(xpath = "//ul[@class='pagination']")
	WebElement Pagination;

	By pagination = By.xpath("//ul[@class='pagination']");

	@FindBy(xpath = "//section//div//div[@class='article-logo-cnt']//a")
	List<WebElement> Articles_list;

	By articles_list = By.xpath("//section//div//div[@class='article-logo-cnt']//a");

	@FindBy(xpath = "//a[normalize-space()='Next >']")
	WebElement Next_button;

	By next_button = By.xpath("//a[normalize-space()='Next >']");

	@FindBy(xpath = "//ul[@class='pagination']//span")
	WebElement Pagination_total_pages;

	By pagination_total_pages = By.xpath("//ul[@class='pagination']//span");

	public void go(String URL) {

		driver.get(URL);

	}

	public void old_pages_duplicates_Articles() {

		Pop_Up_Button pop = new Pop_Up_Button(driver);

		pop.popBtn();

		for (WebElement subcat : Catagories_old_pages_sub_cat_tabs) {

			String subcatlink = subcat.getAttribute("href");

			if (subcatlink.isEmpty()) {

				continue;
			}

			String chordkey = Keys.chord(Keys.CONTROL, Keys.ENTER);

			subcat.sendKeys(chordkey);
		}

		for (String winHandle : driver.getWindowHandles()) {
			try {

				driver.switchTo().window(winHandle);

				if (Pagination.isDisplayed() == true) {

					waitforappear(pagination_total_pages);

					String totalnum = Pagination_total_pages.getText();

					String[] ist = totalnum.split(" ");

					String num = ist[3].trim();

					int number = Integer.parseInt(num);

					for (int k = 0; k < number; k++) {
						try {

							List<WebElement> d = Articles_list;
							ArrayList<String> ar = new ArrayList<String>();

							for (WebElement dd : d) {

								ar.add(dd.getText());
							}

							for (int i = 0; i < ar.size(); i++) {
								for (int j = i + 1; j < ar.size(); j++) {
									if (ar.get(i).equals(ar.get(j))) {

										System.out.println(ar.get(i));
									}
								}
							}

							waitforClick(Next_button);

						} catch (Exception ss) {

						}
					}

				}

				else {

					driver.switchTo().window(winHandle);

				}

			} catch (Exception e) {

			}

		}

	}
}
