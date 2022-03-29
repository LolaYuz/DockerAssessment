package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DockerBasePage;
import pages.DockerLogInPage;
import pages.DockerSearchPage;
import pages.DockerSignUpPage;
import utilities.Driver;

import java.util.List;

import static utilities.ElementUtils.isElementDisplayed;
import static utilities.ElementUtils.moveToElement;

public class DockerSteps {
    WebDriver driver;
    DockerBasePage dockerBasePage;
    DockerLogInPage dockerLogInPage;
    DockerSignUpPage dockerSignUpPage;
    DockerSearchPage dockerSearchPage;

    @Before
    public void setUp() {
        driver = Driver.getDriver();
        dockerBasePage = new DockerBasePage(driver);
        dockerLogInPage = new DockerLogInPage(driver);
        dockerSignUpPage = new DockerSignUpPage(driver);
        dockerSearchPage = new DockerSearchPage(driver);
    }

    @And("user should see header options as below")
    public void userShouldSeeHeaderOptionsAsBelow(DataTable dataTable) {
        List<String> headerOptionsTexts = dataTable.asList();

        for (int i = 1; i < dockerBasePage.headerOptions.size(); i++) {
            Assert.assertTrue(dockerBasePage.headerOptions.get(i).isDisplayed());
            Assert.assertEquals(headerOptionsTexts.get(i), dockerBasePage.headerOptions.get(i).getText());
        }
    }

    @When("user clicks on search icon")
    public void userClicksOnSearchIcon() {
       dockerBasePage.searchIcon.click();
    }

    @And("user should see search input box")
    public void userShouldSeeSearchInputBox() {
        isElementDisplayed(dockerBasePage.searchInputBox);
    }

    @And("user searches for {string}")
    public void userSearchesFor(String key) {
        dockerBasePage.searchInputBox.click();
        dockerBasePage.searchInputBox.sendKeys(key);
    }

    @Then("user should see {string} as the first search result")
    public void userShouldSeeAsTheFirstSearchResult(String searchResultText) {
        Assert.assertEquals(searchResultText, dockerSearchPage.firstResult.getText());
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
       switch(button){
           case "Sign In":
               dockerBasePage.signInButton.click();
               break;
           case "Sign Up":
               dockerLogInPage.signUpButton.click();
               break;
           case "Continue":
               dockerLogInPage.continueButton.click();
               break;
        }
    }

    @Then("user should see {string} form")
    public void userShouldSeeForm(String formHeaderText) {
        Assert.assertEquals(formHeaderText, dockerSignUpPage.signUpFormMainHeader.getText());
    }

    @And("user enters his {string}")
    public void userEntersHis(String username) {
        dockerLogInPage.usernameInputBox.click();
        dockerLogInPage.usernameInputBox.sendKeys(username);
    }

    @And("user enters invalid {string}")
    public void userEntersInvalid(String password) {
        dockerLogInPage.passwordInputBox.click();
        dockerLogInPage.passwordInputBox.sendKeys(password);
    }

    @Then("user should see a message starts with {string}")
    public void userShouldSeeAMessageStartsWith(String message) {
        Assert.assertEquals(message, dockerLogInPage.errorMessage.getText());
    }

    @When("user hover over Developers option in the header")
    public void userHoverOverDevelopersOptionInTheHeader() {
       moveToElement(dockerBasePage.developersHeaderOption);
    }

    @Then("user should see developer options are listed in the dropdown as below")
    public void userShouldSeeDeveloperOptionsAreListedInTheDropdownAsBelow(DataTable dataTable) {
        List<String> devOptions = dataTable.asList();

        for (int i = 0; i < dockerBasePage.developersOptions.size(); i++) {
            Assert.assertTrue(dockerBasePage.developersOptions.get(i).isDisplayed());
            Assert.assertEquals(devOptions.get(i), dockerBasePage.developersOptions.get(i).getText());
        }
    }
}
