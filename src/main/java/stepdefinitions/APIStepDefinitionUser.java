package stepdefinitions;

import cucumber.api.java.en.Given;
import manager.ApiManager;
import objectrepository.rest.UserService;

public class APIStepDefinitionUser {
    private ApiManager apiManager;
    private UserService userService;

    public APIStepDefinitionUser() {
        apiManager = new ApiManager();
        userService = apiManager.getUserService();
    }

    @Given("^a user with name \"([^\"]*)\" exists$")
    public void an_account_with_name_exists(String username) {
        userService.isUserExisting(username);
    }



}
