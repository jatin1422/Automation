package PW_Smoke;

import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Catagories_Old_Pages_Framework;
import PW_Page_Factory.Pop_Up_Button;

public class Oncology_Hematology_Link_Check extends Browser_Origin {

	@Test

	public void oncology_hematology_link_Check() throws InterruptedException {

		Catagories_Old_Pages_Framework co = new Catagories_Old_Pages_Framework(driver);

		co.go("https://www.physiciansweekly.com/category/oncology-hematology/");
		
		Pop_Up_Button pop = new Pop_Up_Button(driver);

		pop.popBtn();

		co.old_cat_page_Linkcheck();

		co.old_cat_sub_cat_tabs_link_Check();
	}
}
