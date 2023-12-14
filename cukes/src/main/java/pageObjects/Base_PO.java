package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base_PO {
    public Base_PO() {
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
    public String getRandomData(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public void sendKeys(By by, String stringToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(stringToType);
    }

}
