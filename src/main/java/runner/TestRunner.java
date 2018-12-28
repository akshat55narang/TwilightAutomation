package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/Feature"
        ,glue = "stepdefinitions"
        ,monochrome = true
        ,plugin = { "pretty" }
        ,tags = "@reg"
        //,dryRun = true
)
public class TestRunner {

}
