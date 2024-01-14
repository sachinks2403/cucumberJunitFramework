package stepdifinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LandingPage;
import pages.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepdefinition {

	WebDriver driver;
	String landingPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;
	LandingPage landingPage;

	public LandingPageStepdefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("user is on GreenCart landing page")
	public void user_is_on_green_cart_landing_page() throws InterruptedException {
		String actualTitle = landingPage.getPageTitle();
		Assert.assertEquals(actualTitle, "GreenKart - veg and fruits kart");
		Thread.sleep(5000);

	}

	@When("^user search for short name (.+) and extract actual name of the product$")
	public void user_search_for_short_name_and_extract_actual_name_of_the_product(String product)
			throws InterruptedException {
		landingPage.searchProduct(product);
		Thread.sleep(5000);
		testContextSetup.landingPageProductName = landingPage.getProductName();
		System.out.println("*** Actual product Name ***  " + testContextSetup.landingPageProductName);


	}
	
	@When("user adds {string} items to the cart")
	public void user_adds_items_to_the_cart(String itemNo) throws InterruptedException {
	   int item = Integer.parseInt(itemNo.trim());
	   landingPage.addItemsToCart(item);
	}
	
	@When("user proceeds to checkout")
	public void user_proceeds_to_checkout() throws InterruptedException {
	    landingPage.navigateToCheckoutPage();
	}


	

}
