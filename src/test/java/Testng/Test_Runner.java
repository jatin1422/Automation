package Testng;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/Cucumber", glue = "Testng.Cucumber_Purchase_Order",
monochrome = true, plugin = {"html:target/cucumber.html" })
public class Test_Runner extends AbstractTestNGCucumberTests {
	
}
