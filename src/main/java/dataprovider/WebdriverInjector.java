package dataprovider;

import io.github.bonigarcia.wdm.WebDriverManager;
import manager.DriverManager;
import manager.PageManager;

public class WebdriverInjector {
    private DriverManager driverManager;
    private PageManager pageManager;

    public WebdriverInjector() {
        WebDriverManager.chromedriver().setup();
        driverManager = new DriverManager();
        pageManager = new PageManager(driverManager.getDriver());
    }

    public DriverManager getDriverManager() {
        return driverManager;
    }

    public PageManager getPageManager() {
        return pageManager;
    }
}
