package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	WebDriver driver;

	By searchBox = By.xpath("//input[@type='search']");
	By productName = By.xpath("//h4[@class='product-name']");
	By topDealsLink = By.xpath("//a[text()='Top Deals']");
	By incrementBtn = By.xpath("//a[@class='increment']");
	By addToCartBtn = By.xpath("//button[text()='ADD TO CART']");
	By cartIcon =By.xpath("//img[@alt='Cart']");
	By checkoutBtn = By.xpath("//button[text()='PROCEED TO CHECKOUT']");

	public LandingPage(WebDriver driver) {
		this.driver = driver;

	}

	public void searchProduct(String productName) {
		driver.findElement(searchBox).sendKeys(productName);
	}

	public String getProductName() {
		String product =  driver.findElement(productName).getText();
		product = product.split(" ")[0].trim();
		return product;
	}
	
	public OffersPage clickTopDealsLink() {
		driver.findElement(topDealsLink).click();
		 return new OffersPage(driver);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void addItemsToCart(int itemNo) throws InterruptedException {
		for(int i=1; i<itemNo;i++) {
			driver.findElement(incrementBtn).click();
			Thread.sleep(2000);
		}
		
		driver.findElement(addToCartBtn).click();
	}
	
	
	public void navigateToCheckoutPage() throws InterruptedException {
		driver.findElement(cartIcon).click();
		Thread.sleep(2000);
		driver.findElement(checkoutBtn).click();
		Thread.sleep(2000);
	//	return new CheckoutPage(driver);
	}

}
