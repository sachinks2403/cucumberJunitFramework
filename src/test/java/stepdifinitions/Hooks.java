package stepdifinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	
	TestContextSetup testContextSteup;
	
	public Hooks(TestContextSetup testContextSteup) {
		this.testContextSteup = testContextSteup;
	}
	
	@After
	public void tearDown() {
		testContextSteup.testBase.closeAllTabs();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		
		WebDriver driver = testContextSteup.testBase.webDriverManager();
		
		if(scenario.isFailed()) {
		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] byteFileContent = FileUtils.readFileToByteArray(srcFile);
		scenario.attach(byteFileContent, "image/png", "image");
		}
		
	}

}
