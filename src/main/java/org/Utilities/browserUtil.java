package org.Utilities;

import org.hooks.hooksForExecution;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public abstract class browserUtil extends hooksForExecution {

    //getting the browser name from config.properties file
    public String br = configProp.getProperty("browser");

    public void browserConfig() {
        //Launching browser
        if (br.equals("chrome")) {
            driver = new ChromeDriver();

        } else if (br.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (br.equals("ie")) {
            driver = new InternetExplorerDriver();
        }
    }
}