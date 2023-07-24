package PW_Smoke;

import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Catagories_Old_Pages_Framework;
import PW_Page_Factory.Pop_Up_Button;

public class Urology_Link_Check extends Browser_Origin {

	@Test
	public void urology_link_Check() throws InterruptedException {

		Catagories_Old_Pages_Framework co = new Catagories_Old_Pages_Framework(driver);

		co.go("https://www.physiciansweekly.com/category/urology/");
	

		co.old_cat_page_Linkcheck();

	}

}
