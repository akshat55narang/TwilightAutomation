package manager;

import objectrepository.AbstractPage;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageManager {
    private WebDriver driver;
    private AbstractPage abstractPage;
    private HomePage homePage;
    private LoginPage loginPage;

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

}
