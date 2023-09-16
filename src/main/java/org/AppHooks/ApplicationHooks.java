package org.AppHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.Factory.DriverFactory;
import org.Utilities.ConfigReader;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader reader;
    Properties prop;
    private Scenario scenario;


    @Before(order = 0)
    public void getProperty() throws IOException {
        reader = new ConfigReader();
        prop = reader.init_prop();
    }

    @Before(order = 1)
    public void launchBrowser() {
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_browser(browserName);

    }


    @After(order = 1)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            String screenShotName = scenario.getName().replaceAll("", "_");
           byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
           scenario.attach(sourcePath, "image/png", screenShotName);
        }
    }
}

