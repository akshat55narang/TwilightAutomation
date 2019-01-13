package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataprovider.WebdriverInjector;
import objectrepository.pages.AbstractPage;
import objectrepository.pages.DesktopPage;

public class StepDefinitionDesktopPage {
    private WebdriverInjector webdriverInjector;
    private DesktopPage desktopPage;
    private AbstractPage abstractPage;

    public StepDefinitionDesktopPage(WebdriverInjector injector) {
        webdriverInjector = injector;
        abstractPage = injector.getPageManager().getAbstractPage();
        desktopPage = webdriverInjector.getPageManager().getDesktopPage();
    }

    @When("^I select select the option \"([^\"]*)\" from the tab \"([^\"]*)\"$")
    public void selectOptionFromProductTab(String product, String arg2) throws Throwable {
        desktopPage.hoverOnMultipleElementsAndClick();
    }

    @Then("^I should be able to view the items related to the option \"([^\"]*)\"$")
    public void verifyProductsRelatedToCategory(String arg1) throws Throwable {

    }
}
