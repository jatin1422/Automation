package PW_Smoke;

import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Deep_Dives_Peer_to_Peer_View_All_Framework;
import PW_Page_Factory.Pop_Up_Button;

public class Deep_Dives_Peer_to_Peer_View_All extends Browser_Origin {

	@Test
	public void deep_dives_peer_to_peer_view_All() {

		Deep_Dives_Peer_to_Peer_View_All_Framework ddp = new Deep_Dives_Peer_to_Peer_View_All_Framework(driver);

		ddp.go();

		Pop_Up_Button pop = new Pop_Up_Button(driver);

		pop.popBtn();

		ddp.view_all_Btn();

	}

}
