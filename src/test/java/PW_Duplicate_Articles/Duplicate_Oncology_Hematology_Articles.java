package PW_Duplicate_Articles;

import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.New_Pages_Duplicates_Articles_Framework;
import PW_Page_Factory.Old_Pages_Duplicates_Articles_Framework;
import PW_Page_Factory.Pop_Up_Button;

public class Duplicate_Oncology_Hematology_Articles extends Browser_Origin {

	@Test
	public void duplicate_articles_Oncology_Hematology_Articles() {

		Old_Pages_Duplicates_Articles_Framework dp = new Old_Pages_Duplicates_Articles_Framework(driver);

		dp.go("https://www.physiciansweekly.com/category/oncology-hematology/");

		Pop_Up_Button btn = new Pop_Up_Button(driver);

		btn.popBtn();

		dp.old_pages_duplicates_Articles();

	}

}
	

