package PW_Smoke;

import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Business_of_Medicine_Link_Check_Framework;
import PW_Page_Factory.Pop_Up_Button;

public class Business_of_Medicine_Link_Check extends Browser_Origin {

	@Test
	public void business_of_medicine_Linkcheck() {

		Business_of_Medicine_Link_Check_Framework bo = new Business_of_Medicine_Link_Check_Framework(driver);

		bo.go();
		
		Pop_Up_Button pop = new Pop_Up_Button(driver);
		
		pop.popBtn();
		
		bo.business_of_medicine_link_Check();
		
		bo.business_of_medicine_sub_cat_tabs_link_Check();

	}
}