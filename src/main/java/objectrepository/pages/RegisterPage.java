package objectrepository.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends AbstractPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterRegistrationDetails(String placeholder, String text) {
        sendTextToFieldByPlaceholder(placeholder, text);
    }
}
