package pageObjects;

import driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Base_PO {
    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
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

    public void sendKeys(WebElement element, String stringToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(stringToType);
    }

    public void waitForElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void navigateTo(String url) {
        getDriver().get(url);
    }

    public void switchToAlertAndAssertText(String expectedMessage) {
        String message = getDriver().switchTo().alert().getText();
        Assert.assertEquals(message, expectedMessage);
    }

    public void validateText(WebElement element, String expected) {
        String message = element.getText();
        Assert.assertEquals(message, "Thank You for your Message!");
    }

}
