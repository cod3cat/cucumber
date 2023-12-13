package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Test {

    private WebDriver driver;
    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        options.setBinary("/usr/local/share/chromedriver-linux64/chromedriver");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        WebElement fistName = driver.findElement(By.name("first_name"));
        fistName.sendKeys("John");
    }
    @When("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        driver.findElement(By.name("last_name")).sendKeys("Doe");

    }
    @When("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        driver.findElement(By.name("email")).sendKeys("john.doe@test.com");
    }
    @When("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        driver.findElement(By.name("message")).sendKeys("Test Message!");
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
