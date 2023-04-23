package automationexercise;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue = {"automationexercise.hooks", "automationexercise.stepdefs"})
public class TestRunner {
}

