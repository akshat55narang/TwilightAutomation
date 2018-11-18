package objectrepository.rest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;
import manager.ConfigFileManager;

public class AbstractService {
    private String baseURI;
    public static final String AUTH_API = ConfigFileManager.getInstance().getConfigFileReader().getAuthApi();

    public AbstractService(String baseURI) {
        this.baseURI = baseURI;
    }

    public RequestSpecification given() {
        RestAssured.baseURI = baseURI;
        return RestAssured.given();
    }

    public RequestSender when() {
        return RestAssured.when();
    }

    public Response get(String resource) {
        return RestAssured.get(resource);
    }

    public Response post(RequestSpecification request, String resource) {
        return request.post(resource);
    }

    public JsonPath rawToJson(Response response) {
        JsonPath jsonPath = response.jsonPath();
        return jsonPath;
    }

    public String getSessionCookie(String username, String password) {
        Response response = doLogin(username, password);
        JsonPath jsonPath = rawToJson(response);
        return jsonPath.getString("session.value");
    }

    public String getDefaultUserSessionCookie() {
        String username = ConfigFileManager.getInstance().getConfigFileReader().getDefaultUser();
        String password = ConfigFileManager.getInstance().getConfigFileReader().getDefaultPassword();
        Response response = doLogin(username, password);
        JsonPath jsonPath = rawToJson(response);
        return jsonPath.getString("session.value");
    }

    public int getLoginStatusCode(String username, String password) {
       Response response = doLogin(username, password);
       return response.getStatusCode();
    }

    public Response doLogin(String username, String password) {
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.body("{ \"username\": \"" + username + "\", \"password\": \""+ password + "\" }");
        Response response = post(request,AUTH_API);
        return response;
    }

}
