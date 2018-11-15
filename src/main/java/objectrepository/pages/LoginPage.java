package objectrepository.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verify(String title) {
        Assert.assertTrue(getTitle().contains(title));
    }

    public void loginAttempt(String username, String password) {
        waitForElement(By.xpath("//input[@id='input-email']")).sendKeys(username);
        waitForElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
        waitForElementToBeClickable(By.xpath("//input[@value='Login']")).click();
    }

    public void verifyLoginSuccess() {
        Assert.assertTrue(waitForElement(By.xpath("//a[text()='Edit Account']")).getText().equals("Edit Account"));
    }

    public void verifyInvalidCredentialsMessage(String message) {
        Assert.assertTrue(waitForElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().equals(message));
    }
}
