package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Login_Steps_Test {

    private WebDriver driver;

    @Before("@login")
    public void setup() {
        /*ChromeOptions options = new ChromeOptions();
        options.addArguments(Stream.of("--no-sandbox", "--disable-dev-smh-usage", "headless").collect(Collectors.toList()));
        options.setBinary("/usr/local/share/chromedriver-linux64");
        driver = new ChromeDriver(options);*/
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After("@login")
    public void tearDown() {
        driver.quit();
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver.get("https://webdriveruniversity.com/Login-Portal/index.html");
    }
    @When("I enter a username {string}")
    public void i_enter_a_username(String username) {
        driver.findElement(By.cssSelector("#text")).sendKeys(username);
    }
    @When("I enter a password {string}")
    public void i_enter_a_password(String password) {
        driver.findElement(By.cssSelector("#password")).sendKeys(password);
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.cssSelector("#login-button")).click();
    }
    @Then("I should bee presented with the successful login message")
    public void i_should_bee_presented_with_the_successful_login_message() {
        String message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(message, "validation succeeded");
    }

    @Then("I should bee presented with the unsuccessful login message")
    public void i_should_bee_presented_with_the_unsuccessful_login_message() {
        String message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(message, "validation failed");
    }
}
