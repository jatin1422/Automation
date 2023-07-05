package Testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Cucumber_Purchase_Order extends Browser_origin {

	public Orders_Confirmation oc;
	public Check_Out check;
	public Product_Catalog pc;
	public Landingpage lp;

	@Given("I landed on the Ecommerce page with this {string}")
	public void Ecommerce_Page(String string) {

		go(string);

	}

	@Given("^I login with (.+) and (.+)$")
	public void i_login_with_and(String name, String password) {
		lp = new Landingpage(driver);

		lp.Login(name, password);
		throw new io.cucumber.java.PendingException();
	}

	@When("^I add a (.+)$")
	public void i_add_a(String product) {
		pc = new Product_Catalog(driver);

		pc.add_to_cart(product);
		pc.cart_Button();
		throw new io.cucumber.java.PendingException();
	}

	@When("check out")
	public void check_out() {
		check = new Check_Out(driver);

		check.checkout_Btn();
		throw new io.cucumber.java.PendingException();
	}

	@Then("I got the {string} confirmation message")
	public void i_got_the_confirmation_message(String string) {
		oc = new Orders_Confirmation(driver);

		oc.OrderName();

		Assert.assertEquals(string, oc.cofirmationmessage());
		throw new io.cucumber.java.PendingException();
	}

}
