package PW_Smoke;




import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Footer_Link_Check_Framework;
import PW_Page_Factory.Pop_Up_Button;

public class Footer_Link_Check extends Browser_Origin {

	@Test
	public void footer_link_Check() {

		Footer_Link_Check_Framework fli = new Footer_Link_Check_Framework(driver);

		fli.go();

		Pop_Up_Button pop = new Pop_Up_Button(driver);

		pop.popBtn();

		fli.footer_links_Tabs();

	}
}
