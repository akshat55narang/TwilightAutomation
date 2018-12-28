package objectrepository.pages;

import customwait.AssertEventually;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends AbstractPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterRegistrationDetails(String placeholder) {

    }

    public void enterMandatoryFields() {
        sendTextToFieldByPlaceholder("First Name", "tester");
        sendTextToFieldByPlaceholder("Last Name", "user111");
        sendTextToFieldByPlaceholder("E-Mail", "tester.user111@test.com");
        sendTextToFieldByPlaceholder("Telephone", "12344567");
        sendTextToFieldByPlaceholder("Password", "password");
        sendTextToFieldByPlaceholder("Password Confirm", "password");
    }

    public void acceptPrivacyPolicy() {
        By locator = By.xpath("//input[@name='agree']");
        AssertEventually.assertEventually(10, 2, () -> {
            waitForElementToBeClickable(locator).click();
            Assert.assertTrue(waitUntilElementIsSelected(locator));
        });
    }

    public void subscribeToNewsLetter() {
        By locator = By.xpath("//input[@name='newsletter']");
        AssertEventually.assertEventually(10, 2, () -> {
            waitForElementToBeClickable(locator).click();
            Assert.assertTrue(waitUntilElementIsSelected(locator));
        });
    }

    public void clickContinueButton(String text) {
        waitForElementToBeClickable(By.xpath("//input[@value='" + text + "']")).click();
    }

    public void verifyAccountRegistrationSuccess(String message) {
        Assert.assertTrue(waitUntilElementAppears(By.xpath("//p[text()='" + message + "']")).getAttribute("value")
                .equals(message));
    }
}
