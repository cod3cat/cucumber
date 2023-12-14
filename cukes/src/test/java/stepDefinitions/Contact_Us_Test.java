package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.ContactUs_PO;
import pageObjects.Login_PO;
import utils.Global_Vars;

public class Contact_Us_Test extends ContactUs_PO {
    private final WebDriver driver = getDriver();

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        navigateTo(Global_Vars.BASE_URL + "/Contact-Us/contactus.html");
    }

    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        setFirstName("John" + getRandomData(5));
    }

    @When("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        setLastName("Doe"  + getRandomData(5));
    }

    @When("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        setEmail("john.doe@test.com");
    }


    @When("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        setMessage("Test Message!"  + getRandomData(5));
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        setFirstName(firstName);
    }

    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        setLastName(lastName);
    }

    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        setEmail(email);
    }

    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String message) {
        setMessage(message);
    }

    @When("I click on the submit button")
    public void i_click_on_the_submit_button() {
        click_Submit();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        validateSubmitMessage("Thank You for your Message!");
    }
}
