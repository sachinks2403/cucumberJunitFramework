package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	WebDriver driver;
	
	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchField = By.id("search-field");
	By productText = By.xpath("//table//tr/td[1]");
	
	
	public void searchProduct(String productName) {
		driver.findElement(searchField).sendKeys(productName);
	}

	public String getProductName() {
		String product =  driver.findElement(productText).getText();
		return product.trim();
	}

}
