package PW_Duplicate_Articles;

import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Duplicate_Cat_Without_Sub_Cat;
import PW_Page_Factory.Pop_Up_Button;

public class Duplicate_Articles_Urology  extends Browser_Origin {

	@Test
	public void duplicate_articles_Urology() {

		Duplicate_Cat_Without_Sub_Cat dp = new Duplicate_Cat_Without_Sub_Cat(driver);

		dp.go("https://www.physiciansweekly.com/category/pain/");

		Pop_Up_Button pop = new Pop_Up_Button(driver);

		pop.popBtn();

		dp.new_cat_duplicates_Articles();

	}
}
