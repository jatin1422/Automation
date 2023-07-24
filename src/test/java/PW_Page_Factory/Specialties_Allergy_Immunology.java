package PW_Page_Factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testng.Abst;

public class Specialties_Allergy_Immunology extends Abst {

	public WebDriver driver;

	public Specialties_Allergy_Immunology(WebDriver driver) {
		super(driver);
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[normalize-space()='SPECIALTIES']")
	WebElement Specialitiesbtn;

	@FindBy(xpath = "//a[normalize-space()='Allergy & Immunology']")
	WebElement Allergy_immunology_btn;

	By specialitiesbtn = By.xpath("//a[normalize-space()='SPECIALTIES']");
	By allergy_immunology_btn = By.xpath("//a[normalize-space()='Allergy & Immunology']");

	@FindBy(xpath = "//a[@class='et_pb_button et_pb_button_0_tb_header header-subscribe et_pb_bg_layout_light']")
	WebElement Subcribe_to_button;

	By subcribe_to_button = By
			.xpath("//a[@class='et_pb_button et_pb_button_0_tb_header header-subscribe et_pb_bg_layout_light']");
	
	@FindBy(xpath = "//input[@id='field1']")
	WebElement Allergy_immunology_first_sub_cat_link_email_box;

	By allergy_immunology_first_sub_cat_link_email_box = By.xpath("//input[@id='field1']");

	@FindBy(xpath = "//div[@class='textwidget']//input[@id='subscription_form_submit']")
	WebElement Allergy_immunology_first_sub_cat_link_email_submit_btn;

	By allergy_immunology_first_sub_cat_link_email_submit_btn = By
			.xpath("//div[@class='textwidget']//input[@id='subscription_form_submit']");

	@FindBy(xpath = "//input[@id='field2']")
	WebElement Newsletters_contact_us_form_firstname;

	By newsletters_contact_us_form_firstname = By.xpath("//input[@id='field2']");

	@FindBy(xpath = "//input[@id='field3']")
	WebElement Newsletters_contact_us_form_lasttname;

	By newsletters_contact_us_form_lastname = By.xpath("//input[@id='field3']");

	@FindBy(xpath = "//input[@id='field4']")
	WebElement Newsletters_contact_us_form_zipcode;

	By newsletters_contact_us_form_zipcode = By.xpath("//input[@id='field4']");

	@FindBy(xpath = "//input[@id='field6']")
	WebElement Specialties_choose_firstcolunm_checkbox;

	By specialties_choose_firstcolunm_checkbox = By.xpath("//input[@id='field6']");

	@FindBy(xpath = "//input[@id='field7']")
	WebElement Specialties_choose_secondcolunm_checkbox;

	By specialties_choose_secondcolunm_checkbox = By.xpath("//input[@id='field7']");

	@FindBy(xpath = "//input[@id='field8']")
	WebElement Specialties_choose_thirdcolunm_checkbox;

	By specialties_choose_thirdcolunm_checkbox = By.xpath("//input[@id='field8']");

	@FindBy(xpath = "//input[@id='field9']")
	WebElement Specialties_choose_fourthcolunm_checkbox;

	By specialties_choose_fourthcolunm_checkbox = By.xpath("//input[@id='field9']");

	@FindBy(xpath = "//input[@id='field27']")
	WebElement Pw_podcast_checkbox;

	By pw_podcast_checkbox = By.xpath("//input[@id='field27']");

	@FindBy(xpath = "//input[@id='field29']")
	WebElement Terms_privacypolicy_checkbox;

	By terms_privacypolicy_checkbox = By.xpath("//input[@id='field29']");

	@FindBy(xpath = "//button[@id='button1']")
	WebElement Form_signup_btn;

	By form_signup_btn = By.xpath("//button[@id='button1']");

	@FindBy(xpath = "//button[@id='thxbutton1']")
	WebElement Thnx_btn;

	By thnx_btn = By.xpath("//button[@id='thxbutton1']");

	public void specialitiesBtn() {

		waitforappear(specialitiesbtn);

		Specialitiesbtn.click();

	}

	public void allergy_immunology_Btn() {

		waitforappear(allergy_immunology_btn);

		Allergy_immunology_btn.click();

	}

	public void subcribe_to_Button() {

		waitforappear(subcribe_to_button);

		Subcribe_to_button.click();

	}

	public void allergy_immunology_first_sub_cat_link_email_Box(String email) {

		waitforappear(allergy_immunology_first_sub_cat_link_email_box);

		Allergy_immunology_first_sub_cat_link_email_box.sendKeys(email);
	}

	

	public void newsletters_contact_us_form_Firstname(String firstname) {

		waitforappear(newsletters_contact_us_form_firstname);

		Newsletters_contact_us_form_firstname.sendKeys(firstname);

	}

	public void newsletters_contact_us_form_Lastname(String lastname) {

		waitforappear(newsletters_contact_us_form_lastname);

		Newsletters_contact_us_form_lasttname.sendKeys(lastname);

	}

	public void newsletters_contact_us_form_Zipcode(String zipcode) {

		waitforappear(newsletters_contact_us_form_zipcode);

		Newsletters_contact_us_form_zipcode.sendKeys(zipcode);

	}

	public void specialties_choose_firstcolunm_Checkbox() {

		waitforappear(specialties_choose_firstcolunm_checkbox);

		Specialties_choose_firstcolunm_checkbox.click();

	}

	public void specialties_choose_secondcolunm_Checkbox() {

		waitforappear(specialties_choose_secondcolunm_checkbox);

		Specialties_choose_secondcolunm_checkbox.click();

	}

	public void specialties_choose_thirdcolunm_Checkbox() {

		waitforappear(specialties_choose_thirdcolunm_checkbox);

		Specialties_choose_thirdcolunm_checkbox.click();

	}

	public void specialties_choose_fourthcolunm_Checkbox() {

		waitforappear(specialties_choose_fourthcolunm_checkbox);

		Specialties_choose_fourthcolunm_checkbox.click();

	}

	public void pw_podcast_Checkbox() {

		waitforappear(pw_podcast_checkbox);

		Pw_podcast_checkbox.click();

	}

	public void terms_privacypolicy_Checkbox() {

		waitforappear(terms_privacypolicy_checkbox);

		Terms_privacypolicy_checkbox.click();
	}

	public void form_signup_Btn() {

		waitforappear(form_signup_btn);

		Form_signup_btn.click();

	}

	public void thnx_Btn() {

		waitforappear(thnx_btn);

		Thnx_btn.click();

	}

	public void go() {

		driver.get("https://www.physiciansweekly.com/");
	}

	

}
