package steps.cucumber_steps.booking;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import settings.BookingProperties;
import test_objects.booking_test_objects.BookingTestCase;
import utilites.JSONparser;
import web_driver.Config;
import web_driver.Driver;
import web_pages.*;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class HeartColorWishlistCucumberSteps {
    WebDriver driver = Driver.initDriver(Config.CHROME);
    BookingIndexPage bookingIndexPage = new BookingIndexPage(driver);
    HotelsPage hotelsPage = new HotelsPage(driver);
    BookingProperties bookingProperties = new BookingProperties();
    WishlistPage wishlistPage = new WishlistPage(driver);
    TrashmailIndexPage trashmailIndexPage = new TrashmailIndexPage(driver);
    TrashmailAddressManagerPage trashmailAddressManagerPage = new TrashmailAddressManagerPage(driver);
    BookingLoginPage bookingLoginPage = new BookingLoginPage(driver);
    private static final Logger LOGGER = LogManager.getLogger(HeartColorWishlistCucumberSteps.class);

    @Given("I get email from Trashmail and navigate to booking")
    public void iGetEmailFromTrashmailAndNavigateToBooking() throws InterruptedException {
        Driver.getURL(bookingProperties.urlTrashmail);
        trashmailIndexPage.trashmailLogin(bookingProperties.userName, bookingProperties.trashmailPassword);
        TimeUnit.SECONDS.sleep(20);
        String email = trashmailAddressManagerPage.getTrashmailAddress();
        Driver.getURL(bookingProperties.urlBooking);
        bookingIndexPage.enterAccount();
        bookingLoginPage.login(email, bookingProperties.bookingPassword);
        TimeUnit.SECONDS.sleep(5);
    }

    @When("search hotels by case {int}")
    public void searchHotelsByCase(Integer int1) throws FileNotFoundException, InterruptedException {
        BookingTestCase bookingTestCase = JSONparser.getBookingTestCase("src/test/resources/bookingTestData").get(3);
        bookingIndexPage.hotelSearch(bookingTestCase);
        bookingIndexPage.checkPrice();
        TimeUnit.SECONDS.sleep(15);
    }

    @When("mark first and last hotel as selected")
    public void markFirstAndLastHotelAsSelected() throws InterruptedException {
        hotelsPage.firstHeartClick();
        TimeUnit.SECONDS.sleep(10);
        hotelsPage.lastHeartClick();
        TimeUnit.SECONDS.sleep(10);
    }

    @Then("I verify that hotel's icon is red")
    public void iVerifyThatHotelSIconIsRed() {
        Assert.assertEquals("rgb(204, 0, 0)", hotelsPage.getFirstHeartIcon().getCssValue("fill"));
        Assert.assertEquals("rgb(204, 0, 0)", hotelsPage.getLastHeartIcon().getCssValue("fill"));
    }

    @Then("wishlist contains selected hotels")
    public void wishlistContainsSelectedHotels() throws InterruptedException {
        String firstHotelName = hotelsPage.getFistHotelName();
        String lastHotelName = hotelsPage.getFistlastName();
        TimeUnit.SECONDS.sleep(5);
        bookingIndexPage.wishlist();
        TimeUnit.SECONDS.sleep(5);
        Assert.assertEquals(firstHotelName, hotelsPage.firstHotelName(firstHotelName).getText());
        Assert.assertEquals(lastHotelName, hotelsPage.lastHotelName(lastHotelName).getText());
    }
}
