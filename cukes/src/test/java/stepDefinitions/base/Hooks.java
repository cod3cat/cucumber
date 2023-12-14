package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.messages.types.Timestamp;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static driver.DriverFactory.getDriver;
import static driver.DriverFactory.cleanupDriver;
public class Hooks {
    @Before
    public void setup() {
        getDriver();
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName() + Long.toString(System.currentTimeMillis()));
        }
    }

    @After
    public void tearDown() {
        cleanupDriver();
    }
}
