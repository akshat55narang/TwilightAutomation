package manager;

import dataprovider.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private WebDriver driver;
    private ConfigFileReader fileReader = ConfigFileManager.getInstance().getConfigFileReader();

    public DriverManager() {
    }

    public WebDriver getDriver() {
        return (driver == null) ? createDriver() : driver;
    }

    private WebDriver createDriver() {
        String browser = fileReader.getBrowser();
        String appUrl = fileReader.getApplicationUrl();
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.get(appUrl);
        //driver.manage().window().maximize();
        return driver;
    }
}
