package org.Factory;

import org.Utilities.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory extends ElementUtil {

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
            //ChromeOptions for disabling notification
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            //Wait system for just 2 sec for every element to get it loaded
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
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