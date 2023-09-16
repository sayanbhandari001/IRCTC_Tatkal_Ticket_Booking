package org.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.StepDefinitions.baseClass;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class hooksForExecution extends baseClass {

    @Before
    public void beforeExecutionsofIRCTC() throws IOException {

        //Logging
        logger = Logger.getLogger("nopCommerceSDET");
        PropertyConfigurator.configure("Log4j.properties");
        logger.setLevel(Level.DEBUG);

        //Load properties File
        configProp = new Properties();
        FileInputStream configPropfile = new FileInputStream("config.properties");
        configProp.load(configPropfile);

        //delete all Cookies
        driver.manage().deleteAllCookies();

    }

    @After
    public void afterExecutionofIRCTC() {

        driver.quit();
    }
}
