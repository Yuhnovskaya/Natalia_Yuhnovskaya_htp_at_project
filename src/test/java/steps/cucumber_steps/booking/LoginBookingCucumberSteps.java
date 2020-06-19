package steps.cucumber_steps.booking;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import steps.booking_test_steps.BookingProperties;
import web_driver.*;
import web_pages.*;

import java.util.concurrent.TimeUnit;


public class LoginBookingCucumberSteps {
    WebDriver driver = Driver.initDriver(Config.CHROME);
    BookingProperties bookingProperties = new BookingProperties();
    BookingIndexPage bookingIndexPage = new BookingIndexPage(driver);
    BookingLoginPage bookingLoginPage = new BookingLoginPage(driver);
    TrashmailAddressManagerPage trashmailAddressManagerPage = new TrashmailAddressManagerPage(driver);
    TrashmailIndexPage trashmailIndexPage = new TrashmailIndexPage(driver);
    static String email;
    private static final Logger LOGGER = LogManager.getLogger(LoginBookingCucumberSteps.class);

    @Given("I get email from Trashmail, navigate booking and login")
    public void iGetEmailFromTrashmailNavigateBookingAndLogin() throws InterruptedException {
        Driver.getURL(bookingProperties.urlTrashmail);
        trashmailIndexPage.trashmailLogin(bookingProperties.userName, bookingProperties.trashmailPassword);
        TimeUnit.SECONDS.sleep(20);
        email = trashmailAddressManagerPage.getTrashmailAddress();
        Driver.getURL(bookingProperties.urlBooking);
    }

    @When("I enter my account")
    public void iEnterMyAccount() throws InterruptedException {
        bookingIndexPage.enterAccount();
        bookingLoginPage.login(email, bookingProperties.bookingPassword);
        TimeUnit.SECONDS.sleep(10);
        bookingIndexPage.enterAccount();
        TimeUnit.SECONDS.sleep(3);
    }

    @Then("verify that button log out exists")
    public void verifyThatButtonExists() {
        Assert.assertTrue(bookingLoginPage.logoutLinkPresents());
    }
}