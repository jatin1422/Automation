package PW_Smoke;

import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Pop_Up_Button;
import PW_Page_Factory.Specialties_Allergy_Immunology;

public class Allergy_Articals_Subscribe_letter extends Browser_Origin {

	@Test
	public void subscribe_letter_Form() throws InterruptedException {

		Specialties_Allergy_Immunology sai = new Specialties_Allergy_Immunology(driver);

		sai.go();

		Pop_Up_Button popup = new Pop_Up_Button(driver);

		popup.popBtn();

		sai.specialitiesBtn();

		sai.allergy_immunology_Btn();

		sai.subcribe_to_Button();

		sai.allergy_immunology_first_sub_cat_link_email_Box("006qatest@gmail.com");

		sai.newsletters_contact_us_form_Firstname("Test");

		sai.newsletters_contact_us_form_Lastname("QA");

		sai.newsletters_contact_us_form_Zipcode("19904");

		sai.specialties_choose_firstcolunm_Checkbox();

		sai.specialties_choose_secondcolunm_Checkbox();
		sai.specialties_choose_thirdcolunm_Checkbox();
		sai.specialties_choose_fourthcolunm_Checkbox();

		sai.pw_podcast_Checkbox();
		sai.terms_privacypolicy_Checkbox();

		sai.form_signup_Btn();

		sai.thnx_Btn();

	}

}
