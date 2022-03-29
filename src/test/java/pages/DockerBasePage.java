package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DockerBasePage {

    public DockerBasePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//nav[@id='top-menu-nav']/ul[1]/li/a")
    public List<WebElement> headerOptions;

    @FindBy(xpath = "(//a[contains(text(), 'Developers')])[1]")
    public WebElement developersHeaderOption;

    @FindBy(xpath = "//nav[@id='top-menu-nav']/ul[1]/li[3]/ul[1]/li")
    public List<WebElement> developersOptions;

    @FindBy(xpath = "(//input[@name='_sf_submit'])[1]")
    public WebElement searchIcon;

    @FindBy(className = "sf-input-text")
    public WebElement searchInputBox;

    @FindBy(xpath = "//a[contains(text(), 'Sign In')]")
    public WebElement signInButton;
}
