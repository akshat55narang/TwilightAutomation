package objectrepository.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class
HomePage extends AbstractPage{
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verify() {
        Assert.assertTrue(getTitle().equals("The Ninja Store"));
    }
}
