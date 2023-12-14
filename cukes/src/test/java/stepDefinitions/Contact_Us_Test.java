package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Base_PO;

public class Contact_Us_Test extends Base_PO {
    private final WebDriver driver = getDriver();

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        WebElement fistName = driver.findElement(By.name("first_name"));
        fistName.sendKeys("John" + getRandomData(5));
    }

    @When("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        driver.findElement(By.name("last_name")).sendKeys("Doe"  + getRandomData(5));
    }

    @When("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        driver.findElement(By.name("email")).sendKeys("john.doe@test.com");
    }


    @When("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        driver.findElement(By.name("message")).sendKeys("Test Message!"  + getRandomData(5));
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        WebElement fistName = driver.findElement(By.name("first_name"));
        fistName.sendKeys(firstName);
    }

    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        driver.findElement(By.name("last_name")).sendKeys(lastName);
    }

    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        driver.findElement(By.name("email")).sendKeys(email);
    }

    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String message) {
        driver.findElement(By.name("message")).sendKeys(message);
    }

    @When("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        String message = driver.findElement(By.cssSelector("h1")).getText();
        Assert.assertEquals(message, "Thank You for your Message!");
    }
}
