package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataprovider.WebdriverInjector;
import objectrepository.AbstractPage;
import objectrepository.LoginPage;

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

    @Then("^I should be on the Login Page$")
    public void verifyLoginPage() {
        loginPage.verify();
    }

    @When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void enterCredentials(String username, String password) {
        loginPage.loginAttempt(username, password);
    }

    @Then("^I should \"([^\"]*)\" to login$")
    public void verifySuccessfulLogin(String condition) {
        loginPage.verifyLoginSuccess();
    }
}
