package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUs_PO extends Base_PO {

    private @FindBy(name = "first_name") WebElement firstName_textField;
    private @FindBy(name = "last_name") WebElement lastName_textField;
    private @FindBy(name = "email") WebElement email_textField;
    private @FindBy(name = "message") WebElement message_textField;
    private @FindBy(xpath = "//input[@type='submit']") WebElement submit_Button;

    private @FindBy(css = "h1") WebElement submit_Message;

    public ContactUs_PO() {
        super();
    }

    public void setFirstName(String firstName) {
        sendKeys(firstName_textField, firstName);
    }

    public void setLastName(String lastName) {
        sendKeys(lastName_textField, lastName);
    }

    public void setEmail(String email) {
        sendKeys(email_textField, email);
    }

    public void setMessage(String message) {
        sendKeys(message_textField, message);
    }

    public void click_Submit() {
        waitForElementAndClick(submit_Button);
    }

    public void validateSubmitMessage(String message) {
        validateText(submit_Message, message);
    }

}
