package stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import manager.ApiManager;
import objectrepository.rest.LoginService;

public class APIStepDefinitionLogin {
    private ApiManager apiManager;
    private LoginService loginService;

    public APIStepDefinitionLogin() {
        apiManager = new ApiManager();
        loginService = apiManager.getLoginService();
    }

   @When("^api call with \"([^\"]*)\" and \"([^\"]*)\" should be successful$")
    public void apiLoginValidCredentials(String username, String password) {
        loginService.loginValidCredentials(username, password);
    }

    @Then("^api call with \"([^\"]*)\" or \"([^\"]*)\" should not be successful$")
    public void verifyInvalidCredentialsLoginFailure(String username, String password) {
        loginService.loginWithInvalidCredentials(username, password);
    }

    
}
