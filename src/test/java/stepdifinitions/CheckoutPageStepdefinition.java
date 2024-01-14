package stepdifinitions;



import org.junit.Assert;

import io.cucumber.java.en.Then;
import pages.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepdefinition {

	TestContextSetup testContextSetup;
	CheckoutPage checkoutPage;

	public CheckoutPageStepdefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}

	@Then("^validates (.+) item in the checkoutpage$")
	public void validates_beet_item_in_the_checkoutpage(String productKey) {

		String productName = checkoutPage.getProductName();
		Assert.assertTrue(productName.contains(productKey));
	}

	@Then("user verifies that he has ability to apply promocode and place order")
	public void user_verifies_that_he_has_ability_to_apply_promocode_and_place_order() {
		Assert.assertTrue(checkoutPage.isPlaceorderBtnEnabled());
		Assert.assertTrue(checkoutPage.isPromoBtnEnabled());
	}

}
