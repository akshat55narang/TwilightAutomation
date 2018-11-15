package stepdefinitions;

import cucumber.api.java.en.Given;
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

    @Given("^I enter the \"([^\"]*)\" as \"([^\"]*)\"$")
    public void enterRegistrationDetails(String placeholder, String text) {
        registerPage.enterRegistrationDetails(placeholder, text);
    }
}