package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "stepsDefinition" }, monochrome = true, plugin = {
		"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json","json:target/rapport.json",
		"junit:target/cucumber-results.xml" }, tags = "")
public class Runner {

}
