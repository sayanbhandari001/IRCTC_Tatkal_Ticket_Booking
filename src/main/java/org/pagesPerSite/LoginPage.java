package org.pagesPerSite;

import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class LoginPage {

    public WebDriver driver;
    public String captchaResult;
    public String url = "https://www.irctc.co.in/nget/train-search";
    public String jOptionAction;

    //1. By locators -- Object Repository
    private By loginAlertPopupBeforeSignin = By.xpath("//button[text()='ok'");
    private By loginButton = By.xpath("//a[@aria-label='Click here to Login in application']");
    private By userInfo = By.xpath("//input[@formcontrolname='userid' and @placeholder='User Name']");
    private By password = By.xpath("//input[@formcontrolname='password' and @placeholder='Password']");
    private By captchaimage = By.xpath("//img[@class='captcha-img' and contains(@src, 'data:image/jpg')]");
    private By signInButton = By.xpath("//button[normalize-space()='SIGN IN']");
    private By captaFill = By.xpath("//input[@placeholder='Enter Captcha']");
    public By captcaRefreshButton = By.xpath("//a[@aria-label='Click to refresh Captcha']");
    public By invalidCaptchaInput = By.xpath("//div[@class='loginError' and contains(text(),'Invalid Captcha')]");
    public By loginSuccessful = By.xpath("//span[contains(text(),'Welcome')]");


    //2. Constructor of the page class:
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. page actions: features(behavior) of the page the form of methods:
    public void websiteURL() {
        driver.get(url);
    }

    public void pageLoad() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
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

    public By userNameInput() {
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

    public String enterCaptcaInput(String captcha) {
        driver.findElement(captaFill).click();
        driver.findElement(captaFill).clear();
        driver.findElement(captaFill).sendKeys(captcha);
        return captcha;
    }

    public boolean signInIRCTC() {
        driver.findElement(signInButton).click();
        return false;
    }

    public By captcaRefresh() {
        driver.findElement(captcaRefreshButton).click();
        return null;
    }

    public String captchaReaderInfo() throws IOException, TesseractException {

        WebElement captchaImageFile = driver.findElement(captchaimage);
        File src = captchaImageFile.getScreenshotAs(OutputType.FILE);
        String captchaPath = "captchaImage\\captcha.png";
        FileHandler.copy(src, new File(captchaPath));

        try {
            ImageIcon icon = new ImageIcon(captchaPath);
            JFrame j = new JFrame();
            j.setAlwaysOnTop(true);
            j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            j.setVisible(true);
            j.setVisible(false);
            jOptionAction = (String) JOptionPane.showInputDialog(j, "Enter the Captcha Value", "Prove that you are a Human", JOptionPane.QUESTION_MESSAGE, icon, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Closed popup or input Faliure");
        }

//        ITesseract imageCaptchaScrappedFile = new Tesseract();
//        String stringImageCaptchaScrappedFile = imageCaptchaScrappedFile.doOCR(new File(path));
//        System.out.println("imageCaptchaScrappedFile" + stringImageCaptchaScrappedFile);
//        try {
//            File imageFile = new File(path);
//            Tesseract instance = new Tesseract();
//            instance.setDatapath("D:\\01.eclipse-jee-2022-09-R-win32-x86_64\\eclipse-workspace\\IRCTC_Tatkal_Ticket_Booking\\tessdata");
//            captchaResult = instance.doOCR(imageFile);
//            captchaResult.trim();
//            //System.out.println(captchaResult);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return jOptionAction;
    }

    public boolean verifyLoginUnsuccessful() {

        //invalidCaptchaFound.isDisplayed();
        try {
            WebElement invalidCaptchaFound = driver.findElement(invalidCaptchaInput);
            invalidCaptchaFound.isDisplayed();
            System.out.println("Captcha Input UnSuccessful");
            return true;
        }catch (NoSuchElementException e){
            System.out.println("Captcha Input Successful");
        }
        return false;
    }

    public boolean verifuLoginSucessful() {


        return true;
    }
}