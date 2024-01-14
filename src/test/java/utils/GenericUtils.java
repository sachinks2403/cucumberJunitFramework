package utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
public void switchToChildWindow() {
		
		if(!driver.getCurrentUrl().contains("/offers")) {
		String parentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
			
			for(String str: windows) {
				if(!str.equals(parentWindow)) {
					driver.switchTo().window(str);
					break;
				}
			}
			
		}
			
	}

}
