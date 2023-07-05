package PW_Smoke;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Java_Scriptexecutor;
import PW_Page_Factory.Pop_Up_Button;
import PW_Page_Factory.Search_Feed_Articals_;

public class Search_Feed_Articles extends Browser_Origin {

	@Test(priority = 1)
	public void Homepage() throws InterruptedException, IOException {

		Search_Feed_Articals_ sfa = new Search_Feed_Articals_(driver);

		sfa.go();

		Pop_Up_Button popup = new Pop_Up_Button(driver);

		popup.popBtn();

	}

	@Test(priority = 2)
	public void _2mm() throws InterruptedException, IOException {

		Search_Feed_Articals_ sfa = new Search_Feed_Articals_(driver);

		sfa.go();

		Pop_Up_Button popup = new Pop_Up_Button(driver);

		popup.popBtn();

		sfa.search_Box();

		sfa.search_input_Box("2mm");

		sfa.search_Btn();

	}

	@Test(priority = 3)
	public void Pubmed() throws InterruptedException, IOException {

		Search_Feed_Articals_ sfa = new Search_Feed_Articals_(driver);

		sfa.go();

		Pop_Up_Button popup = new Pop_Up_Button(driver);

		popup.popBtn();

		Java_Scriptexecutor execute = new Java_Scriptexecutor(driver);

		sfa.search_Box();

		sfa.search_input_Box("pubmed");

		sfa.search_Btn();

		execute.executescript("window.scrollBy(0,300)");

	}
}
