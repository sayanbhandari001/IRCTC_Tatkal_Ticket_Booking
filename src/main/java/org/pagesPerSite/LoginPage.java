package org.pagesPerSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.Factory.DriverFactory.driver;

public class LoginPage {

    public WebDriver driver;

    //1. By locators -- Object Repository
    private By loginAlertPopupBeforeSignin = By.xpath("//button[text()='ok'");
    private By loginButton = By.xpath("//a[@aria-label='Click here to Login in application']");
    private By userInfo = By.xpath("//input[@formcontrolname='userid' and @placeholder='User Name']");
    private By password = By.xpath("//input[@formcontrolname='password' and @placeholder='Password']");
    private By signInButton = By.xpath("//button[@type='submit' and contains(text(),'SIGN IN')]");
    private By captaFill = By.xpath("//div[@class='captcha_div']");
    public String url = "https://www.irctc.co.in/nget/train-search";



//    public static void waitForElement(WebDriver driver, WebElement element) {
//    FluentWait<WebDriver> wait = new FluentWait<>(driver)
//            .withTimeout(Duration.ofSeconds(30))
//            .pollingEvery(Duration.ofMillis(500))
//            .ignoring(NoSuchElementException.class);
//
//    wait.until(ExpectedConditions.visibilityOf(element));
//}


    //2. Constructor of the page class:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. page actions: features(behavior) of the page the form of methods:
    public void websiteURL() {
        driver.get(url);

    }

    public void loginAlertPopupFirstScreen() {
        driver.findElement(loginAlertPopupBeforeSignin).click();
    }

    public String getLoginPageTitle() {
        return driver.getTitle();
    }

    public void loginButton() {
        driver.findElement(loginButton).click();
    }

    public By userNameInput(){
        driver.findElement(userInfo);
        return userInfo;
    }

    public void enterUserName(String userLoginData) {
        driver.findElement(userInfo).clear();
        driver.findElement(userInfo).sendKeys(userLoginData);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pwd);
    }

    public void userCaptcaInput(String captcha) {
        driver.findElement(captaFill).sendKeys(captcha);
    }

    public void signInIRCTC() {
        driver.findElement(signInButton).click();
    }



    //600 sec -- for 10 mins

}