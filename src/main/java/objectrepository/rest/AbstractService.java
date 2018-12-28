package objectrepository.rest;

import dataprovider.ApiResource;
import dataprovider.PropertyInput;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;
import manager.ConfigFileManager;

import java.util.List;

public class AbstractService {
    private String baseURI;

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

    public Response get(RequestSpecification request, String resource) {
        return request.get(resource);
    }

    public Response post(RequestSpecification request, String resource) {
        return request.post(resource);
    }

    public JsonPath rawToJson(Response response) {
        JsonPath jsonPath = response.jsonPath();
        return jsonPath;
    }

    public RequestSpecification createBasicRequestWithCookies() {
        RequestSpecification request = createBasicRequest();
        List<String> cookies = getDefaultUserSessionContext();
        cookies.forEach(cookie -> {
            request.header("Cookie", cookie);
        });
        return request;
    }

    public RequestSpecification createBasicRequest() {
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        return request;
    }

    public String getSessionCookie(String username, String password) {
        Response response = doLogin(username, password);
        JsonPath jsonPath = rawToJson(response);
        return jsonPath.getString("session.value");
    }

    public List<String> getSessionContext(String username, String password) {
        Response response = doLogin(username, password);
        Headers headers = response.getHeaders();
        return headers.getValues("Set-Cookie");
    }

    public List<String> getDefaultUserSessionContext() {
        String username = ConfigFileManager.getInstance().getConfigFileReader().getProperty(PropertyInput.DEFAULT_USERNAME.getProperty());
        String password = ConfigFileManager.getInstance().getConfigFileReader().getProperty(PropertyInput.DEFAULT_PASSWORD.getProperty());
        Response response = doLogin(username, password);
        Headers headers = response.getHeaders();
        return headers.getValues("Set-Cookie");
    }

    public int getLoginStatusCode(String username, String password) {
        Response response = doLogin(username, password);
        return response.getStatusCode();
    }

    public Response doLogin(String username, String password) {
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        request.body("{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }");
        Response response = post(request, ApiResource.AUTH_API);
        return response;
    }

}
