package stepdefinitions;

import cucumber.api.java.en.Given;
import dataprovider.WebdriverInjector;
import objectrepository.AbstractPage;
import objectrepository.HomePage;

public class StepDefinitionHome {
    private WebdriverInjector webdriverInjector;
    private AbstractPage abstractPage;
    private HomePage homePage;

    public StepDefinitionHome(WebdriverInjector injector) {
        webdriverInjector = injector;
        abstractPage = injector.getPageManager().getAbstractPage();
        homePage = injector.getPageManager().getHomePage();
    }

    @Given("^I am on the Home Page$")
    public void onHomePage() {
        homePage.verify();
    }
}
