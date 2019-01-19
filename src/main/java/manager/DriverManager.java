package manager;

import dataprovider.ConfigFileReader;
import dataprovider.PropertyInput;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static Logger logger = Logger.getLogger(DriverManager.class);

    private WebDriver driver;
    private ConfigFileReader fileReader = ConfigFileManager.getInstance().getConfigFileReader();

    public DriverManager() {
    }

    public WebDriver getDriver() {
        return (driver == null) ? createDriver() : driver;
    }

    private WebDriver createDriver() {
        String browser = fileReader.getProperty(PropertyInput.BROWSER.getProperty());
        String appUrl = fileReader.getProperty(PropertyInput.URL.getProperty());
        if (browser.equals("chrome")) {
            logger.debug("Opening Chrome Browser!");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.get(appUrl);
        //driver.manage().window().maximize();
        return driver;
    }
}
