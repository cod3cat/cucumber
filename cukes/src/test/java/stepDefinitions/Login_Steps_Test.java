package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Login_PO;

public class Login_Steps_Test extends Login_PO {

    private final WebDriver driver = getDriver();
//    Login_PO login_po = new Login_PO();

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        navigateTo("https://webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("I enter a username {word}")
    public void i_enter_a_username(String username) {
        setUserName(username);
    }

    @When("I enter a password {word}")
    public void i_enter_a_password(String password) {
        setPassword(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        clickLogin();
    }

    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() {
        switchToAlertAndAssertText("validation succeeded");
        driver.switchTo().alert().accept();
    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() {
        switchToAlertAndAssertText("validation failed");
        driver.switchTo().alert().accept();
    }

    @Then("I should be presented with the validation message {}")
    public void i_should_be_presented_with_the_validation_message (String expected_message) {
        switchToAlertAndAssertText(expected_message);
        driver.switchTo().alert().accept();
    }
}
