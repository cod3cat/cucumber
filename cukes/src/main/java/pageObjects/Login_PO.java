package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO {

    private @FindBy(css = "#text") WebElement UserName_textField;
    private @FindBy(id = "password") WebElement Password_textField;
    private @FindBy(id = "login-button") WebElement Login_button;

    public Login_PO() {
        super();
    }

    public void setUserName(String userName) {
        sendKeys(UserName_textField, userName);
    }

    public void setPassword(String password) {
        sendKeys(Password_textField, password);
    }

    public void clickLogin() {
        waitForElementAndClick(Login_button);
    }

}
