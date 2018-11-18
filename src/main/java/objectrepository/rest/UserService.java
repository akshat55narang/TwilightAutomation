package objectrepository.rest;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import manager.ConfigFileManager;

public class UserService extends AbstractService{
    private String baseURI;
    private static final String USER_API = ConfigFileManager.getInstance().getConfigFileReader().getUserApi();
    public UserService(String baseURI) {
        super(baseURI);
        this.baseURI = baseURI;
    }

    public boolean isUserExisting(String username) {
        String cookie = getDefaultUserSessionCookie();
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.header("Cookie", cookie);
        request.param("username", username);
        request.param("startAt", "0");
        request.param("maxResults", "10");
        Response response = get(USER_API);
        return (response.getStatusCode() == 200);
    }



}
