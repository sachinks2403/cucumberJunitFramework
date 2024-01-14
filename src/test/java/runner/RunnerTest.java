package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/", 
glue = "stepdifinitions", 
monochrome = true,
plugin = { "pretty",
	"html:target/cucumber.html",
	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	"rerun:target/failed_scenarios.txt"})

public class RunnerTest {
	
	

}
