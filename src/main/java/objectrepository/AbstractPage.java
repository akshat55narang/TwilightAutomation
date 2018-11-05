package objectrepository;

import manager.ConfigFileManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage extends FluentWait {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;

    public AbstractPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, ConfigFileManager.getInstance().getConfigFileReader().getExplicitWait());
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickOnLinkWithText(String text) {
        waitForElementToBeClickable(By.xpath("//a[text()='" + text + "']")).click();
    }

    public WebElement findElementBy(By by) {
        return driver.findElement(by);
    }

    public WebElement waitForElement(By by) {
        wait.until(ExpectedConditions.visibilityOf(findElementBy(by)));
        return findElementBy(by);
    }

    public WebElement waitForElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return findElementBy(by);
    }

    public void clickOnButtonWithText(String text) {
        waitForElementToBeClickable(By.xpath("//span[text()='" + text + "']")).click();
    }
}
