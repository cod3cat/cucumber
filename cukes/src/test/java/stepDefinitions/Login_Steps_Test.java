package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;

public class Login_Steps_Test extends Base_PO {

    private final WebDriver driver = getDriver();

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver.get("https://webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("I enter a username {word}")
    public void i_enter_a_username(String username) {
        sendKeys(By.cssSelector("#text"), username);
    }

    @When("I enter a password {word}")
    public void i_enter_a_password(String password) {
        sendKeys(By.cssSelector("#password"), password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        waitForElementAndClick(By.cssSelector("#login-button"));
    }

    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() {
        String message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(message, "validation succeeded");
    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() {
        String message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(message, "validation failed");
    }

    @Then("I should be presented with the validation message {}")
    public void i_should_be_presented_with_the_validation_message (String expected_message) {
        String actual_message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(actual_message, expected_message);
    }
}
