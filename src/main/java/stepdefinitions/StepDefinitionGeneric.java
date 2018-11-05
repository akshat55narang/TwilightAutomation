package stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import dataprovider.WebdriverInjector;
import org.openqa.selenium.WebDriver;

public class StepDefinitionGeneric {
    private WebDriver driver;
    private WebdriverInjector webdriverInjector;

    public StepDefinitionGeneric(WebdriverInjector injector) {
        webdriverInjector = injector;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        System.out.println("************** " + scenario.getName() + "************** ");
    }

    @After
    public void afterScenario() {
        System.out.println("************* Ending Scenario **************");
        if (webdriverInjector.getDriverManager().getDriver() != null) {
            webdriverInjector.getDriverManager().getDriver().close();
        }
    }
}
