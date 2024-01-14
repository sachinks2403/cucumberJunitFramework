package stepdifinitions;



import org.junit.Assert;

import io.cucumber.java.en.Then;
import pages.LandingPage;
import pages.OffersPage;
import utils.TestContextSetup;

public class OfferPageStepdefinition {
	
	
	
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	OffersPage offerPage;
	
	public OfferPageStepdefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
		this.offerPage = testContextSetup.pageObjectManager.getOffersPage();
	}

	@Then("^user search for short name (.+) in offers page to check if product exists$")
	public void user_search_for_same_short_name_in_offers_page_to_check_if_product_exists(String keyToSearch) throws InterruptedException {
		offerPage = landingPage.clickTopDealsLink();
		testContextSetup.genericUtils.switchToChildWindow();
		offerPage.searchProduct(keyToSearch);
		Thread.sleep(5000);
		String productName = offerPage.getProductName();
		System.out.println("** Product name in Offer Page ***  " + productName);
		Assert.assertEquals(productName, testContextSetup.landingPageProductName);
		System.out.println("***********************");
	
	}

	
	
}
