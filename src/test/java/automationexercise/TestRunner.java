package automationexercise;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue = {"automationexercise.hooks", "automationexercise.stepdefs"})
public class TestRunner {
}

