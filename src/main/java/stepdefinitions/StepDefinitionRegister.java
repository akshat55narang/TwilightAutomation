package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataprovider.WebdriverInjector;
import objectrepository.pages.AbstractPage;
import objectrepository.pages.RegisterPage;

public class StepDefinitionRegister {
    private WebdriverInjector webdriverInjector;
    private RegisterPage registerPage;
    private AbstractPage abstractPage;


    public StepDefinitionRegister(WebdriverInjector injector) {
        webdriverInjector = injector;
        registerPage = webdriverInjector.getPageManager().getRegisterPage();
        abstractPage = webdriverInjector.getPageManager().getAbstractPage();
    }

    @When("^I do not enter the mandatory values in the \"([^\"]*)\"$")
    public void skipnterRegistrationDetails(String field) {
        registerPage.enterRegistrationDetails(field);
    }

    @When("^I fill all the mandatory values$")
    public void fillMandatoryFields() {
        registerPage.enterMandatoryFields();
    }

    @When("^I agree to the Privacy Policy$")
    public void agreePrivacyPolicy() {
        registerPage.acceptPrivacyPolicy();
    }

    @When("^I subscribe to the Newsletter$")
    public void subscribeNewsLetter() {
        registerPage.subscribeToNewsLetter();
    }

    @When("^I click on \"([^\"]*)\" to complete registration$")
    public void continueRegistration(String buttonText) {
        registerPage.clickContinueButton(buttonText);
    }

    @Then("^I should receive a message \"([^\"]*)\"$")
    public void verifyAccountRegistration(String message) {
        registerPage.verifyAccountRegistrationSuccess(message);
    }
}