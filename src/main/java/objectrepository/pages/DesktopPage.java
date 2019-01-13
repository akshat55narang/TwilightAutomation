package objectrepository.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DesktopPage extends AbstractPage {
    private WebDriver driver;

    public DesktopPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void hoverOnMultipleElementsAndClick(WebElement...elements) {
        WebElement first = findElementBy(By.xpath("//a[text()='Desktops']"));
        WebElement second = findElementBy(By.xpath(
                "//a[text()='Desktops']/following-sibling::div//a[contains(text(),'Mac')]"));
        moveToSequenceOfElementsAndClick(first, second);

    }
}
