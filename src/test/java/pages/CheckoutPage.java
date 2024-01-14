package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	WebDriver driver;
	
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By promoBtn = By.xpath("//button[@class='promoBtn']");
	By placeOrderBtn = By.xpath("//button[text()='Place Order']");
	By productName = By.xpath("//p[@class='product-name']");
	
	
	public boolean isPlaceorderBtnEnabled() {
		return driver.findElement(placeOrderBtn).isEnabled();
	}
	
	public boolean isPromoBtnEnabled() {
		return driver.findElement(promoBtn).isEnabled();
	}
	
	public String getProductName() {
		String product = driver.findElement(productName).getText();
		product = product.split(" ")[0].trim();
		return product;
	}

}
