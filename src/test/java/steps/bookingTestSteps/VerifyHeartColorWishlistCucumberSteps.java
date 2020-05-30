package steps.bookingTestSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testObject.BookingTestObjects.BookingTestCase;
import utilites.JSONparser;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webDriver.Prop;
import webPages.BookingIndexPage;
import webPages.HotelsPage;
import webPages.WishlistPage;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class VerifyHeartColorWishlistCucumberSteps {
    static Properties prop = Prop.getProp();
    static WebDriver driver = DrManager.getDriver(Config.CHROME);
    static BookingIndexPage bookingIndexPage = new BookingIndexPage(driver);
    static HotelsPage hotelsPage = new HotelsPage(driver);
    static WishlistPage wishlistPage = new WishlistPage(driver);
    static BookingSteps bookingSteps = new BookingSteps();
    private static final Logger LOGGER = LogManager.getLogger(VerifyHeartColorWishlistCucumberSteps.class);
    @Given("I get email from Trashmail and navigate to booking")
    public void iGetEmailFromTrashmailAndNavigateToBooking() throws InterruptedException {
        TrashMailSteps trashMailSteps = new TrashMailSteps();
        String email = trashMailSteps.getTrashmailAddress(driver);
        driver.get(prop.getProperty("URL_BOOKING"));
        bookingSteps.login(driver, email, prop.getProperty("BOOKING_PSW"));
        TimeUnit.SECONDS.sleep(5);
    }

    @When("search hotels by case {int}")
    public void searchHotelsByCase(Integer int1) throws FileNotFoundException, InterruptedException {
        BookingTestCase bookingTestCase = JSONparser.getBookingTestCase("src/test/resources/bookingTestData").get(int1);
        bookingSteps.hotelSearch(driver, bookingTestCase);
        TimeUnit.SECONDS.sleep(15);
    }

    @When("mark first and last hotel as selected")
    public void markFirstAndLastHotelAsSelected() throws InterruptedException {
        hotelsPage.firstHeartClick();
        TimeUnit.SECONDS.sleep(15);
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
        Assert.assertEquals(firstHotelName, driver.findElement(By.xpath("//*[contains(text(),'" + firstHotelName + "')]")).getText());
        Assert.assertEquals(lastHotelName, driver.findElement(By.xpath(String.format("//*[contains(text(),'" + lastHotelName + "')]", lastHotelName))).getText());
    }
}
