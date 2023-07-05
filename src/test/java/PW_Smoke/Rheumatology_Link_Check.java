package PW_Smoke;

import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Catagories_Old_Pages_Framework;
import PW_Page_Factory.Pop_Up_Button;

public class Rheumatology_Link_Check extends Browser_Origin {

	@Test
	public void rheumatology_link_Check() throws InterruptedException {

		Catagories_Old_Pages_Framework co = new Catagories_Old_Pages_Framework(driver);

		co.go("https://www.physiciansweekly.com/category/rheumatology/");
		
		Pop_Up_Button pop = new Pop_Up_Button(driver);

		pop.popBtn();
		
		co.old_cat_page_Linkcheck();

	}
}
