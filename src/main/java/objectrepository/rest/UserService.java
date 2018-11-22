package objectrepository.rest;

import dataprovider.ApiResource;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class UserService extends AbstractService {
    private String baseURI;

    public UserService(String baseURI) {
        super(baseURI);
        this.baseURI = baseURI;
    }

    public void isUserExisting(String username) {
        RequestSpecification request = createBasicRequestWithCookies();
        request.queryParam("username", "anarang");
        request.queryParam("startAt", "0");
        request.queryParam("maxResults", "10");
        Response response = get(request, ApiResource.USER_API);
        if (response.getStatusCode() == 200) {
            Assert.assertTrue(true);
            return;
        }
        Assert.assertTrue(false);
    }


}
