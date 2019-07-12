package runner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/weatherAPI.feature","src/test/resources/weatherAPI2.feature"}
        ,glue={"stepDefinition"}
)


public class TestRunner {

}
