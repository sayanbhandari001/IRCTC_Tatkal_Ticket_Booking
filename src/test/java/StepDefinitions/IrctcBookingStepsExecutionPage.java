package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.TesseractException;
import org.AppHooks.ApplicationHooks;
import org.Factory.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pagesPerSite.LoginPage;

import java.io.IOException;
import java.time.Duration;

import static org.Factory.DriverFactory.driver;

public class IrctcBookingStepsExecutionPage {

    //private ConfigReader reader;

    public WebDriverWait waitExplicitly = new WebDriverWait(driver, Duration.ofSeconds(10));

    static ApplicationHooks apk = new ApplicationHooks();

    static {
        try {
            apk.getProperty();
        } catch (IOException e) {
            e.printStackTrace();
        }
        apk.launchBrowser();
    }

    public LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
//    private DriverFactory dfr = new DriverFactory ();

    @Given("^User has Logged in successfully with proper login details$")
    public void user_has_logged_in_successfully_with_proper_login_details() throws IOException, TesseractException {
        System.out.println("\n" +
                "------Application started with provided URL--------\n" + loginPage.url + "\n");
        //loginPage.pageLoad();
        loginPage.websiteURL();
        loginPage.loginButton();
        waitExplicitly.until(ExpectedConditions.elementToBeClickable(loginPage.userNameInput()));
        loginPage.enterUserName(apk.getProperties().getProperty("irctcUsername"));
        loginPage.enterPassword(apk.getProperties().getProperty("irctcUserPassword"));

        loginPage.enterCaptcaInput(loginPage.captchaReaderInfo());

        //loginPage.signInIRCTC();

        String title = loginPage.getLoginPageTitle();
        System.out.println("Title of the page is " + title);
        Assert.assertTrue(title.contains("IRCTC Next Generation eTicketing System"));

    }

    @Given("^closed popup of last transaction details if open$")
    public void closed_popup_of_last_transaction_details_if_open() {
        //if popup displayed regarding accept

//        if (!) {
//
//        }
        System.out.println("Hi");
    }

    @Given("I select {string} and {string} destination with next corresponding Date")
    public void i_select_and_destination_with_next_corresponding_date(String string, String string2) {
        System.out.println("Hi");


    }

    @Given("Select {string} and booking {string} at {int} am for {string} or {int} am for {string}")
    public void select_and_booking_at_am_for_or_am_for(String string, String string2, Integer int1, String string3, Integer int2, String string4) {
        System.out.println("Hi");


    }

    @Given("change {string} as required")
    public void change_as_required(String string) {
        System.out.println("Hi");


    }

    @When("I click on search and select correct {string}")
    public void i_click_on_search_and_select_correct(String string) {

        System.out.println("Hi");

    }

    @Then("^As per Class selection select refresh, get the vacancy count$")
    public void as_per_class_selection_select_refresh_get_the_vacancy_count() {
        System.out.println("Hi");


    }

    @Then("validate if vacancy count is more than or equal to {int} in case of single member and vacancy count is more than or equal to {int} in case of family booking")
    public void validate_if_vacancy_count_is_more_than_or_equal_to_in_case_of_single_member_and_vacancy_count_is_more_than_or_equal_to_in_case_of_family_booking(Integer int1, Integer int2) {
        System.out.println("Hi");


    }

    @Then("if count is less then {int} in case of single member or less than or equal to {int} in case of family then click on next available date")
    public void if_count_is_less_then_in_case_of_single_member_or_less_than_or_equal_to_in_case_of_family_then_click_on_next_available_date(Integer int1, Integer int2) {

        System.out.println("Hi");

    }

    @Then("^click on corresponding book now button and if any popup displayed click on yes and proceed further$")
    public void click_on_corresponding_book_now_button_and_if_any_popup_displayed_click_on_yes_and_proceed_further() {

        System.out.println("Hi");

    }

    @Then("^fill individual or family Passenger Details such as Name,age, gender, India as country and preference as No preference for$")
    public void fill_individual_or_family_passenger_details_such_as_name_age_gender_india_as_country_and_preference_as_no_preference_for() {
        System.out.println("Hi");


    }

    @Then("^consider adding customer phone number$")
    public void consider_adding_customer_phone_number() {

        System.out.println("Hi");

    }

    @Then("^Select Payment option as bhim pay$")
    public void select_payment_option_as_bhim_pay() {
        System.out.println("Hi");


    }

    @Then("^click continue$")
    public void click_continue() {
        System.out.println("Hi");


    }

    @Then("validate if vacancy count is still more than {int}")
    public void validate_if_vacancy_count_is_still_more_than(Integer int1) {

        System.out.println("Hi");

    }

    @Then("^Popup with Captcha to fill by user$")
    public void popup_with_captcha_to_fill_by_user() {

        System.out.println("Hi");

    }

    @Then("Click continue and then select {string} and click {string} and clcik {string}")
    public void click_continue_and_then_select_and_click_and_clcik(String string, String string2, String string3) {
        System.out.println("Hi");


    }

}
