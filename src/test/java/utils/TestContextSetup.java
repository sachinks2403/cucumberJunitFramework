package utils;

import org.openqa.selenium.WebDriver;

import pages.PageObjectManager;



public class TestContextSetup {
	
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	
	public TestContextSetup() {
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.webDriverManager());
		genericUtils = new GenericUtils(testBase.webDriverManager());
	}

}
