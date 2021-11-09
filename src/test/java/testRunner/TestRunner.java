package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\Sachini Nayanathara\\Documents\\Projects\\SQA_Assignment_Test\\src\\test\\resources\\features",
        glue ="stepDef",

        plugin = {"pretty", "json:target/cucumber-report/cucumber.json" }
)


public class TestRunner {

}
