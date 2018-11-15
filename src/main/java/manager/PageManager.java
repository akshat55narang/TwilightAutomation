package manager;

import objectrepository.pages.AbstractPage;
import objectrepository.pages.HomePage;
import objectrepository.pages.LoginPage;
import objectrepository.pages.RegisterPage;
import org.openqa.selenium.WebDriver;

public class PageManager {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public AbstractPage getAbstractPage() {
        return (abstractPage == null) ? abstractPage = new AbstractPage(driver) : abstractPage;
    }

    public HomePage getHomePage() {
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
    }

    public RegisterPage getRegisterPage() {
        return (registerPage == null) ? registerPage = new RegisterPage(driver) : registerPage;
    }

}
