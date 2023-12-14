package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public WebDriver driver;

    @Before("@login")
    public void setup() {
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments(Stream.of("--no-sandbox", "--disable-dev-smh-usage", "headless").collect(Collectors.toList()));
        options.setBinary("/usr/local/share/chromedriver-linux64");
        driver = new ChromeDriver(options);*/
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After("@login")
    public void tearDown() {
        driver.quit();
    }
}
