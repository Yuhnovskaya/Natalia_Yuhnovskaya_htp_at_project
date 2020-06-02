package steps.bookingTestSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webDriver.Prop;
import webPages.BookingIndexPage;
import webPages.BookingLoginPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class VerifyLoginBookingCucumberSteps {
    static WebDriver driver;
    static BookingIndexPage bookingIndexPage = new BookingIndexPage(driver);
    static BookingLoginPage bookingLoginPage = new BookingLoginPage(driver);
    private static final Logger LOGGER = LogManager.getLogger( VerifyLoginBookingCucumberSteps.class);
    @Given("I get email from Trashmail, navigate booking and login")
    public void iGetEmailFromTrashmailNavigateBookingAndLogin() throws InterruptedException {
        driver = DrManager.getDriver(Config.CHROME);
        Properties prop = Prop.getProp();
        BookingSteps bookingSteps = new BookingSteps();
        TrashMailSteps trashMailSteps = new TrashMailSteps();
        String email = trashMailSteps.getTrashmailAddress(driver);
        driver.get(prop.getProperty("URL_BOOKING"));
        bookingSteps.login(driver, email, prop.getProperty("BOOKING_PSW"));
        TimeUnit.SECONDS.sleep(10);
    }

    @When("I enter my account")
    public void iEnterMyAccount() throws InterruptedException {
        bookingIndexPage.enterAccount();
        TimeUnit.SECONDS.sleep(3);
    }

    @Then("verify that button log out exists")
    public void verifyThatButtonExists() {
        Assert.assertTrue(bookingLoginPage.logoutLinkPresents());
    }

    @Then("close driver")
    public void closeDriver() {
        DestroyDriver.destroy(driver);
    }
}