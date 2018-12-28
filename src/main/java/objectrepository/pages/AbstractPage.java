package objectrepository.pages;

import dataprovider.PropertyInput;
import manager.ConfigFileManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class AbstractPage extends FluentWait {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;

    public AbstractPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, ConfigFileManager.getInstance().getConfigFileReader().getLongProperty(
                PropertyInput.EXPLICIT_WAIT.getProperty())).ignoring(StaleElementReferenceException.class);
    }

    public Duration timeoutInSeconds(Long timeout) {
        return Duration.ofSeconds(timeout);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public WebElement findElementBy(By by) {
        return driver.findElement(by);
    }

    public WebElement waitForElement(By by) {
        return wait.until(ExpectedConditions.visibilityOf(findElementBy(by)));
    }

    public WebElement waitForElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitForElementToBeClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public boolean waitUntilElementIsSelected(By by) {
        return wait.until(ExpectedConditions.elementToBeSelected(by));
    }

    public void clickOnButtonWithText(String text) {
        waitForElementToBeClickable(By.xpath("//span[text()='" + text + "']")).click();
    }

    public WebElement waitUntilElementAppears(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitUntilElementAppears(Long timeout, By by) {
        return wait.withTimeout(timeoutInSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void sendTextToFieldByPlaceholder(String placeholder, String text) {
        By fieldLocator = By.xpath("//input[@placeholder='" + placeholder + "']");
        waitForElement(fieldLocator).click();
        findElementBy(fieldLocator).clear();
        findElementBy(fieldLocator).sendKeys(text);
        Assert.assertTrue(waitForElement(fieldLocator).getAttribute("value").equals(text));
    }

    public void clickOnLinkWithText(String text) {
        waitForElementToBeClickable(By.xpath("//a[text()='" + text + "']")).click();
    }


}
