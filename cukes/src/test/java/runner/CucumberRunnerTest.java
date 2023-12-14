package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", glue = "stepDefinitions",
        monochrome = true, plugin = {"pretty", "html:target/cucumber"}, tags = "@outline")
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
