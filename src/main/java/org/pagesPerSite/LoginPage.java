package org.pagesPerSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public WebDriver driver;

    //1. By locators -- Object Repository
    private By loginAlertPopupBeforeSignin = By.xpath("//button[text()='ok'");
    private By loginButton = By.xpath("//a[@aria-label='Click here to Login in application']");
    private By userInfo = By.xpath("//input[@formcontrolname='userid' and @placeholder='User Name']");
    private By password = By.xpath("//input[@formcontrolname='password' and @placeholder='Password']");
    private By signInButton = By.xpath("//button[@type='submit' and contains(text(),'SIGN IN')]");
    private By captaFill = By.xpath("//div[@class='captcha_div']");
    private String url = "https://www.irctc.co.in/nget/train-search";

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
        System.out.println("driver " + driver );
        System.out.println("loginButton" + loginButton);
        System.out.println("findelement " + driver.findElement(loginButton));
        driver.findElement(loginButton).click();
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

}