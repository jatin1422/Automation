package PW_Duplicate_Articles;

import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.New_Pages_Duplicates_Articles_Framework;
import PW_Page_Factory.Pop_Up_Button;

public class Duplicate_Gastroenterology_Articles extends Browser_Origin {

	@Test
	public void duplicate_articles_Gastroenterology() throws InterruptedException {

		New_Pages_Duplicates_Articles_Framework dp = new New_Pages_Duplicates_Articles_Framework(driver);

		dp.go("https://www.physiciansweekly.com/category/gastroenterology/");

		Pop_Up_Button pop = new Pop_Up_Button(driver);

		pop.popBtn();

		dp.new_pages_duplicates_Articles();

	}

}



