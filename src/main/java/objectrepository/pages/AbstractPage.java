package objectrepository.pages;

import dataprovider.PropertyInput;
import manager.ConfigFileManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Consumer;

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

    public Actions actions() {
        return new Actions(driver);
    }

    /**
     * hover on an element. Should be invoked by other methods to perform action on a single or multiple elements
     */

    public Actions moveToElement(WebElement element) {
        return actions().moveToElement(element);
    }

    public void moveToElementAndClick(WebElement element) {
        moveToElement(element).click().build().perform();
    }

    public void moveToElement(Actions actions, WebElement element) {
        actions.moveToElement(element);
    }

    public void moveToSequenceOfElementsAndClick(WebElement ...elements) {
        Actions actions = actions();
        Arrays.asList(elements).forEach(element -> {
            moveToElement(actions, element);
        });
        buildAndPerformActions(actions.click());
    }

    private void buildAndPerformActions(Actions actions) {
        Consumer<Actions> actionsConsumer = action -> action.build().perform();
        actionsConsumer.accept(actions);
    }
}
