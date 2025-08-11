package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"steps"},
    plugin = {
    		"pretty",
	        "html:reports/cucumber-reports/cucumber.html",
	        "json:reports/cucumber-reports/cucumber.json",
	        "junit:reports/cucumber-reports/cucumber.xml"
    		
    },
    monochrome = true
)
public class TestRunner { }

//this is updated to check push.