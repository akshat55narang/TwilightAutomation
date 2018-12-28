package stepdefinitions;

import cucumber.api.java.en.Given;
import manager.ApiManager;
import objectrepository.rest.ProjectService;

public class APIStepDefinitionProject {
    private ApiManager apiManager;
    private ProjectService projectService;

    public APIStepDefinitionProject() {
        apiManager = new ApiManager();
        projectService = apiManager.getProjectService();
    }

    @Given("^a project with name \"([^\"]*)\" doesnot exist$")
    public void removeProjectWithName(String projectName) {
        //projectService.getExistingProjects();
    }

    @Given("^api call to create a new project with name \"([^\"]*)\" should be successful$")
    public void verifyNewProjectCreation(String projectName) {

    }
}
