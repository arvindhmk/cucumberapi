package cucumber.options;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue= {"stepdefinitions"},plugin="json:target/jsonReports/cucumber-report.json")
//tags= {"@DeletePlace"}
public class Testrunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
