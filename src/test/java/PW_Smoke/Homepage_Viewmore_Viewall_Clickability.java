package PW_Smoke;


import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Homepage_Viewmore_Viewall_Clickability_Framework;
import PW_Page_Factory.Pop_Up_Button;

public class Homepage_Viewmore_Viewall_Clickability extends Browser_Origin {

	@Test
	public void homepage_viewmore_viewall_Clickability() throws InterruptedException {

		Homepage_Viewmore_Viewall_Clickability_Framework hvvc = new Homepage_Viewmore_Viewall_Clickability_Framework(
				driver);

		hvvc.go();

		Pop_Up_Button pop = new Pop_Up_Button(driver);

		pop.popBtn();
		hvvc.viewAll();
		hvvc.viewMore();

	}

}
