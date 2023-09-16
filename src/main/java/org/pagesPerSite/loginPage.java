package org.pagesPerSite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

    private WebDriver driver;

    //1. By locators -- Object Repository
    private By loginAlertPopupBeforeSignin = By.xpath("");
    private By loginButton = By.linkText("LOGIN");
    private By userInfo = By.xpath("//input[@formcontrolname='userid' and @placeholder='User Name']");
    private By password = By.xpath("//input[@formcontrolname='password' and @placeholder='Password']");
    private By signInButton = By.xpath("//button[@type='submit' and contains(text(),'SIGN IN')]");
    private By captaFill = By.xpath("//div[@class='captcha_div']");

    //2. Constructor of the page class:
    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. page actions: features(behavior) of the page the form of methods:

    public void loginAlertPopupFirstScreen(){
        driver.findElement(loginAlertPopupBeforeSignin).click();
    }

    public String getLoginPageTitle(){
        return driver.getTitle();
    }

    public void enterUserName(String username){
        driver.findElement(userInfo).sendKeys(username);
    }

    public void enterPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);

    }

    public void userCaptcaInput(String captcha){
        driver.findElement(captaFill).sendKeys(captcha);
    }


}