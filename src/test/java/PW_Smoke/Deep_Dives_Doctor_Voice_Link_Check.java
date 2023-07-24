package PW_Smoke;

import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Deep_Dives_Doctor_Voice_Link_Check_Framework;
import PW_Page_Factory.Pop_Up_Button;

public class Deep_Dives_Doctor_Voice_Link_Check extends Browser_Origin {

	@Test
	public void deep_dives_doctor_voice_link_Check() {

		Deep_Dives_Doctor_Voice_Link_Check_Framework ddd = new Deep_Dives_Doctor_Voice_Link_Check_Framework(driver);

		ddd.go();

		Pop_Up_Button pop = new Pop_Up_Button(driver);

		pop.popBtn();
		ddd.doctor_voice_sub_cat_Tabs();

		ddd.doctor_voice_sub_cat_tabs_link_Check();
	}

}
