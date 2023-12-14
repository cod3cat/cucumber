package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;

        switch (getBrowserType()) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments(Stream.of("--no-sandbox", "--disable-dev-smh-usage", "headless").collect(Collectors.toList()));
                options.setBinary("/usr/local/share/chromedriver-linux64");
                driver = new ChromeDriver(options);
//                  driver = new ChromeDriver();
            }

            case "firefox" ->
                driver = new FirefoxDriver();
            }

            if (driver != null) driver.manage().window().maximize();
        return driver;
    }

    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }

    private static String getBrowserType() {
        Properties props = new Properties();

        try {
            props.load(new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return props.getProperty("browser").toLowerCase().trim();
    }
}
