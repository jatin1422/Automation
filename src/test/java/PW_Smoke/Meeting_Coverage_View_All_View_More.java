package PW_Smoke;

import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Meeting_Coverage_View_All_View_More_Framework;
import PW_Page_Factory.Pop_Up_Button;

public class Meeting_Coverage_View_All_View_More extends Browser_Origin {

	@Test
	public void meeting_Coverage() {

		Meeting_Coverage_View_All_View_More_Framework mcvv = new Meeting_Coverage_View_All_View_More_Framework(driver);

		mcvv.go();
		Pop_Up_Button pop = new Pop_Up_Button(driver);

		pop.popBtn();

		mcvv.viewAll();

	}

}
//Pop_Up_Button pop = new Pop_Up_Button(driver);

//pop.popBtn();