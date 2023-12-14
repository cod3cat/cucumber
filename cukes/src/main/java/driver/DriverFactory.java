package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;

        String browserType = "chrome";

        switch (browserType) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments(Stream.of("--no-sandbox", "--disable-dev-smh-usage", "headless").collect(Collectors.toList()));
                options.setBinary("/usr/local/share/chromedriver-linux64");
                driver = new ChromeDriver(options);
//                driver = new ChromeDriver();
                break;
            }

            case "firefox" -> {
                driver = new FirefoxDriver();
                break;
            }
        }

        driver.manage().window().maximize();
        return driver;
    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
