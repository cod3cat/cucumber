package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "classpath:features", glue = "classpath:stepDefinitions",
        monochrome = true, plugin = {"pretty", "html:target/cucumber"}, tags = "@regression")
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
