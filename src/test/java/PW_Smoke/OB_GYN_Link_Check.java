package PW_Smoke;


import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Catagories_New_Pages_Framework;
import PW_Page_Factory.Pop_Up_Button;

public class OB_GYN_Link_Check extends Browser_Origin {

	@Test

	public void oB_gyn_link_Check() throws InterruptedException {

		Catagories_New_Pages_Framework cod = new Catagories_New_Pages_Framework(driver);

		cod.go("https://www.physiciansweekly.com/category/obgyn/");

		Pop_Up_Button pop = new Pop_Up_Button(driver);

		pop.popBtn();
		cod.new_cat_page_Linkcheck();
		cod.new_cat_sub_cat_tabs_link_Check();
	}
}
