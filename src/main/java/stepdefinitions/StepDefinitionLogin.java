package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataprovider.WebdriverInjector;
import objectrepository.pages.AbstractPage;
import objectrepository.pages.LoginPage;

public class StepDefinitionLogin {
    private WebdriverInjector webdriverInjector;
    private AbstractPage abstractPage;
    private LoginPage loginPage;

    public StepDefinitionLogin(WebdriverInjector injector) {
        webdriverInjector = injector;
        abstractPage = injector.getPageManager().getAbstractPage();
        loginPage = injector.getPageManager().getLoginPage();
    }

    @When("^I click on the \"([^\"]*)\" button$")
    public void clickOnButton(String buttonText) {
        abstractPage.clickOnButtonWithText(buttonText);
    }

    @When("^I click on the \"([^\"]*)\" link$")
    public void clickOnLink(String buttonText) {
        abstractPage.clickOnLinkWithText(buttonText);
    }

    @Then("^I should be on the \"([^\"]*)\" Page$")
    public void verifyLoginPage(String module) {
        loginPage.verify(module);
    }

    @When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterCredentials(String username, String password) {
        loginPage.loginAttempt(username, password);
    }

    @When("^I enter invalid \"([^\"]*)\" or \"([^\"]*)\"$")
    public void enterInValidCredentials(String username, String password) {
        loginPage.loginAttempt(username, password);
    }

    @Then("^I should be able to login$")
    public void doLoginWithValidCredentials() {
        loginPage.verifyLoginSuccess();
    }

    @Then("^I should be able to see the message \"([^\"]*)\"$")
    public void verifyInValidCredentailsMessage(String message) {
        loginPage.verifyInvalidCredentialsMessage(message);
    }
}
