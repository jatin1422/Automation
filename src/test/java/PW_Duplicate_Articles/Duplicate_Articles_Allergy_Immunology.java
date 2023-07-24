package PW_Duplicate_Articles;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Old_Pages_Duplicates_Articles_Framework;
import PW_Page_Factory.Pop_Up_Button;

public class Duplicate_Articles_Allergy_Immunology extends Browser_Origin {

	@Test
	public void duplicate_articles_allergy_Immunology() {
		Old_Pages_Duplicates_Articles_Framework dp = new Old_Pages_Duplicates_Articles_Framework(driver);

		dp.go("https://www.physiciansweekly.com/category/allergy-immunology/");

		Pop_Up_Button btn = new Pop_Up_Button(driver);

		btn.popBtn();

		dp.old_pages_duplicates_Articles();

	}

}