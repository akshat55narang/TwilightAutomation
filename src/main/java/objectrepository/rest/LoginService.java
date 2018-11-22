package objectrepository.rest;

import org.junit.Assert;

public class LoginService extends AbstractService {

    private String baseURI;

    public LoginService(String baseURI) {
        super(baseURI);
        this.baseURI = baseURI;
    }

    public void loginValidCredentials(String username, String password) {
        String sessionCookie = getSessionCookie(username, password);
        Assert.assertTrue(!sessionCookie.equals(null));
    }

    public void loginWithInvalidCredentials(String username, String password) {
        int statusCode = getLoginStatusCode(username, password);
        System.out.println("Status Code Received = " + statusCode);
        Assert.assertTrue(statusCode == 401);
    }
}
