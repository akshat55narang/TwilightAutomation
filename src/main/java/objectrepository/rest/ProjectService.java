package objectrepository.rest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class ProjectService extends AbstractService {
    private String baseURI;

    public ProjectService(String baseURI) {
        super(baseURI);
        this.baseURI = baseURI;
    }

    public Response getProjects() {
        RequestSpecification request = createBasicRequestWithCookies();
        return request.get("api/2/project");
    }

    public List<String> getExistingProjectsNames() {
        JsonPath jsonPath = getProjects().jsonPath();
        return jsonPath.getList("name");
    }

    public void deleteProjectByName(String projectName) {
        Response response = getProjects();
        List<String> projects = response.jsonPath().getList("name");
        projects.forEach((projName) -> {
            if (projName.equals(projectName)) {

            }
        });

    }

    public void createNewProject(String name) {

    }

    public static void main(String[] args) {
        ProjectService projectService = new ProjectService("http://localhost:8500/rest/");
        projectService.getExistingProjectsNames();
    }
}
