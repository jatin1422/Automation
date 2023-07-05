package PW_Smoke;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverAction;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.checkerframework.common.reflection.qual.NewInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PW_Page_Factory.Browser_Origin;
import PW_Page_Factory.Deep_Dives_Conditional_Spotlight_Sub_Cat_View_All_Framework;
import PW_Page_Factory.Java_Scriptexecutor;
import PW_Page_Factory.Pop_Up_Button;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Deep_Dives_Conditional_Spotlight_Sub_Cat_View_All extends Browser_Origin{


	@Test
	public void deep_dives_conditional_spotlight_sub_cat_view_All() throws InterruptedException {

		
		Deep_Dives_Conditional_Spotlight_Sub_Cat_View_All_Framework dd = new Deep_Dives_Conditional_Spotlight_Sub_Cat_View_All_Framework(driver);
		
		dd.go();
		
		Pop_Up_Button pop = new Pop_Up_Button(driver);

		pop.popBtn();
		
		dd.con_Spotlight_subcats_Tabs();
		
		dd.view_all_Btn();
		
	}

}
