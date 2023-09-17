package org.Factory;

import org.AppHooks.ApplicationHooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory extends ApplicationHooks {

    public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
    public WebDriver driver;

    /*
        this is used to get the driver with threadlocal
     */
    public static synchronized WebDriver getDriver() {
        return tldriver.get();
    }

    //initializing the browser using provided browser details in Config file
    public WebDriver init_driver(String browser) {

        //Launching browser
        System.out.println("Browser Started is " + browser);
        if (browser.equals("chrome")) {
            tldriver.set(new ChromeDriver());
        } else if (browser.equals("firefox")) {
            tldriver.set(new FirefoxDriver());
        } else if (browser.equals("ie")) {
            tldriver.set(new InternetExplorerDriver());
        } else if (browser.equals("safari")) {
            tldriver.set(new SafariDriver());
        } else {
            throw new RuntimeException("Please pass Browser Data in Config file " + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }
}