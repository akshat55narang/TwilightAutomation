package manager;

import io.restassured.RestAssured;
import objectrepository.rest.AbstractService;
import objectrepository.rest.LoginService;
import objectrepository.rest.ProjectService;
import objectrepository.rest.UserService;

public class ApiManager {
    private static final String BASE_URI = ConfigFileManager.getInstance().getConfigFileReader().getBaseUri();
    private RestAssured restAssured;
    private AbstractService abstractService;
    private LoginService loginService;
    private UserService userService;
    private ProjectService projectService;

    public ApiManager() {
        restAssured.baseURI = BASE_URI;
    }

    public AbstractService getAbstractService() {
        return (abstractService == null) ? abstractService = new AbstractService(restAssured.baseURI) : abstractService;
    }

    public LoginService getLoginService() {
        return (loginService == null) ? loginService = new LoginService(restAssured.baseURI) : loginService;
    }

    public UserService getUserService() {
        return (userService == null) ? userService = new UserService(restAssured.baseURI) : userService;
    }

    public ProjectService getProjectService() {
        return (projectService == null) ? projectService = new ProjectService(restAssured.baseURI) : projectService;
    }
}
