package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DockerSignUpPage {

    public DockerSignUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".styles__mainTitle___3_abT")
    public WebElement signUpFormMainHeader;
}
