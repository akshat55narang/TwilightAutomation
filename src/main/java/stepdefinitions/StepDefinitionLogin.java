package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionLogin {

    @Given("^I am on the Home Page$")
    public void onHomePage() throws Throwable {

    }

    @When("^I click on the \"([^\"]*)\" button$")
    public void clickOnButton(String arg1) {

    }

    @Then("^I should be redirected to the Login Page$")
    public void verifyLoginPage() {

    }

    @When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void etnerCredentials(String arg1, String arg2) {

    }

    @Then("^I should \"([^\"]*)\" to login$")
    public void verifySuccessfulLogin(String arg1) {

    }
}
