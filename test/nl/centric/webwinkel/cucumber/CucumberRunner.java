package nl.centric.webwinkel.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
		format = {"pretty", "json:target/cucumber.json"},
		features = {"test/nl/centric/webwinkel/cucumber/"})
public class CucumberRunner {

}
