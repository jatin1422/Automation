package First_Framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Admin_To_Do {

	public WebDriver driver;

	public Admin_To_Do(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	// To_Do Button

	@FindBy(xpath = "//div[@class='sidebar-collapse']//ul/li[3]/a/i")
	WebElement Todobutton;

	protected By todobutton = By.xpath("//div[@class='sidebar-collapse']//ul/li[3]/a/i");

	// Add to-do button

	@FindBy(xpath = "//button[contains(.,'Add New')]")
	WebElement Addtodobutton;

	By addtodobutton = By.xpath("//button[contains(.,'Add New')]");

	// ADD TO DO Form

	// 1. To do title

	@FindBy(xpath = "//div[@class='form-group']/input[@name='todo_title']")
	WebElement Todotitle;

	By todotitle = By.xpath("//div[@class='form-group']/input[@name='todo_title']");

	// 2. Select project

	@FindBy(xpath = "//select[@id='projectId']")
	WebElement Selectproject;

	By selectproject = By.xpath("//select[@id='projectId']");

	// 3. Select member button

	@FindBy(xpath = "//div[@id='show_members_tab']/div/button")
	WebElement Selectmemberbutton;

	By selectmemeberbutton = By.xpath("//div[@id='show_members_tab']/div/button");

	// 3.1 Search for member

	@FindBy(xpath = "//div[@class='dropdown-menu show']//input[@aria-label='Search']")
	WebElement Searchmember;

	By searchmember = By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']");

	// 3.2 Member List

	@FindAll(@FindBy(xpath = "//div[@aria-expanded='true']/ul/li/a"))
	List<WebElement> Memberlist;

	By memberlist = By.xpath("//div[@aria-expanded='true']/ul/li/a");

	// 4 Enter Date

	@FindBy(xpath = "//input[@id='due_date']")
	WebElement Enterdate;

	By enterdate = By.xpath("//input[@id='due_date']");

	// 5 Select Priorty

	@FindBy(xpath = "//select[@id='task_priority']")
	WebElement Selectpriorty;

	By selectpriorty = By.xpath("//select[@id='task_priority']");

	// 6 Enter Notes

	@FindBy(xpath = "//textarea")
	WebElement Notes;

	By notes = By.xpath("//textarea");

}
