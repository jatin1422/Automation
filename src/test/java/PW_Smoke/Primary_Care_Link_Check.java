package PW_Smoke;

import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Catagories_New_Pages_Framework;
import PW_Page_Factory.Pop_Up_Button;

public class Primary_Care_Link_Check extends Browser_Origin {

	@Test

	public void primary_care_link_Check() throws InterruptedException {

		Catagories_New_Pages_Framework co = new Catagories_New_Pages_Framework(driver);

		co.go("https://www.physiciansweekly.com/category/primary-care/");
		
		Pop_Up_Button pop = new Pop_Up_Button(driver);

		pop.popBtn();

		co.new_cat_page_Linkcheck();

		co.new_cat_sub_cat_tabs_link_Check();
	}
}
