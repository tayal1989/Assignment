package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature/Assignment.feature", // path of the feature file
		glue = {"stepdefinition"}, // path of the step definition file
		format = {"pretty", "html:test-output", "junit:junit_xml/cucumber.xml"},	// to generate different types of report
		monochrome = true // display the console output more readable
//		dryRun = false	// validating steps are glued to step definition
		)
public class TestRunner {

}
