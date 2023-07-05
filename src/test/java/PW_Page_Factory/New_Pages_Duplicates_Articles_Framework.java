package PW_Page_Factory;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.util.Integers;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testng.Abst;

public class New_Pages_Duplicates_Articles_Framework extends Abst {

	public WebDriver driver;

	public New_Pages_Duplicates_Articles_Framework(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//ul[@class='et-menu nav']//li//a")
	List<WebElement> Catagories_new_pages_sub_cat_tabs;

	By catagories_new_pages_sub_cat_tabs = By.xpath("//ul[@class='et-menu nav']//li//a");

	@FindBy(xpath = "//div[@role='navigation']//div[@role='navigation']")
	WebElement Pagination;

	By pagination = By.xpath("//div[@role='navigation']//div[@role='navigation']");

	@FindBy(xpath = "//div[@class='el-dbe-blog-extra box_extended ']//article")
	List<WebElement> Articles_list;

	By articles_list = By.xpath("//div[@class='el-dbe-blog-extra box_extended ']//article");

	@FindBy(xpath = "//div[@id='manage-ajax-response']//div//div//a")
	List<WebElement> Cat_articles_list;

	By cat_articles_list = By.xpath("//div[@id='manage-ajax-response']//div//div//a");

	// div[@id='manage-ajax-response']//article//a

	@FindBy(xpath = "//a[@aria-label='Next Page']")
	WebElement Next_button;

	By next_button = By.xpath("//a[@aria-label='Next Page']");

	@FindBy(xpath = "//a[normalize-space()='>']")
	WebElement Next_arrow_button;

	By next_arrow_button = By.xpath("//a[normalize-space()='>']");

	@FindBy(xpath = "(//a[@class='page-numbers'])[3]")
	WebElement Pagination_total_pages;

	By pagination_total_pages = By.xpath("(//a[@class='page-numbers'])[3]");

	@FindBy(xpath = "//div[@id='manage-ajax-response']")
	WebElement Article_box;

	By article_box = By.xpath("//div[@id='manage-ajax-response']");

	@FindBy(xpath = "//div[@id='caf-post-layout-container']")
	WebElement Caf;

	By caf = By.xpath("//div[@id='caf-post-layout-container']");

	public void go(String URL) {

		driver.get(URL);

	}

	public void new_pages_duplicates_Articles() {

		for (WebElement subcat : Catagories_new_pages_sub_cat_tabs) {
			try {
				String subcatlink = subcat.getAttribute("href");

				if (subcatlink.isEmpty()) {

					continue;
				}

				String chordkey = Keys.chord(Keys.CONTROL, Keys.ENTER);

				subcat.sendKeys(chordkey);
				Pop_Up_Button pop = new Pop_Up_Button(driver);

				pop.popBtn();
			} catch (Exception ss) {

			}
		}

		for (String winHandle : driver.getWindowHandles()) {
			try {

				driver.switchTo().window(winHandle);

				if (Pagination.isDisplayed() == true) {

					while (Next_button.isDisplayed() == true) {
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

				else if ((Next_arrow_button.isDisplayed() == true) && (Article_box.isDisplayed() == true)) {

					String num = Pagination_total_pages.getText();

					int numbers = Integers.parseInt(num);

					System.out.println(numbers);

					for (int x = 0; x < numbers; x++) {

						try {

							List<WebElement> d = Cat_articles_list;
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

							waitforappear(caf);

							waitforClick(Next_arrow_button);

							Thread.sleep(5000);

						} catch (Exception ss) {

						}
					}

				}

				else {

					driver.switchTo().window(winHandle);

				}

			} catch (

			Exception e) {

			}

		}

	}
}
