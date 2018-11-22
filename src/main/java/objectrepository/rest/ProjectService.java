package objectrepository.rest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProjectService extends AbstractService {
    private String baseURI;

    public ProjectService(String baseURI) {
        super(baseURI);
        this.baseURI = baseURI;
    }

    public void getExistingProjects() {
        RequestSpecification request = createBasicRequestWithCookies();
        Response response = request.get("api/2/project");
        response.then().log().all();
    }


}
