package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class Base_PO {
    public Base_PO() {
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
    public String getRandomData(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

}
