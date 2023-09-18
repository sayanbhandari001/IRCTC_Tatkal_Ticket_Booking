package org.Factory;

import org.AppHooks.ApplicationHooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory  {

    //public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
    public static WebDriver driver;

    /*
        this is used to get the driver with threadlocal
     */
    public static WebDriver getDriver() {
        return driver;
    }

    //initializing the browser using provided browser details in Config file
    public static WebDriver init_driver(String browser) {

        //Launching browser
        System.out.println("Browser Started is " + browser);
        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            System.setProperty("webdriver.chrome.driver", "src/test/browserfiles/chromedriver.exe");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equals("ie")) {
            driver = new InternetExplorerDriver();
        } else if (browser.equals("safari")) {
            driver = new SafariDriver();
        } else {
            throw new RuntimeException("Please pass Browser Data in Config file " + browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }
}