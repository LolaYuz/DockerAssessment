package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DockerLogInPage {

    public DockerLogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "signup")
    public WebElement signUpButton;

    @FindBy(id = "username")
    public WebElement usernameInputBox;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(name = "action")
    public WebElement continueButton;

    @FindBy(id = "error-element-password")
    public WebElement errorMessage;
}
