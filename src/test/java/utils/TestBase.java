package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	WebDriver driver;

	public WebDriver webDriverManager() {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(new File("config.properties")));
		} catch (Exception e) {
			e.printStackTrace();
		}

		String browser_prop = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		String browser = (browser_maven!=null) ? browser_maven : browser_prop;
		
		
		if (driver == null) {

			if (browser.equalsIgnoreCase("CHROME")) {
				driver = new ChromeDriver();		
			} else if (browser.equalsIgnoreCase("FIREFOX")) {
				driver = new FirefoxDriver();	
			}
			
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
		}
		return driver;
	}

	public void closeAllTabs() {
		driver.quit();
	}

}
