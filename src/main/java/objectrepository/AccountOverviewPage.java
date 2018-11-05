package objectrepository;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AccountOverviewPage extends AbstractPage {
    private WebDriver driver;

    public AccountOverviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verify() {
        Assert.assertTrue(getTitle().contains("My Account"));
    }
}
