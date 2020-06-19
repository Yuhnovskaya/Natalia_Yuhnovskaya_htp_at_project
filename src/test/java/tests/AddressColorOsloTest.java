package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import settings.BookingProperties;
import test_objects.booking_test_objects.BookingTestCase;
import utilites.JSONparser;
import web_driver.Config;
import web_driver.Driver;
import web_pages.BookingIndexPage;
import web_pages.HotelsPage;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class AddressColorOsloTest {

    private static final Logger LOGGER = LogManager.getLogger(AddressColorOsloTest.class);
    @Before
    public void beforeOsloTestInfo() {
        LOGGER.info("AddressColorOsloTest started running");
    }

    @Test
    public void verifyAddressColorOslo() throws InterruptedException, FileNotFoundException {
        Driver.initDriver(Config.CHROME);
        BookingProperties bookingProperties = new BookingProperties();
        Driver.getURL(bookingProperties.urlBooking);
        BookingIndexPage bookingIndexPage = new BookingIndexPage(Driver.getDriver());
        HotelsPage hotelsPage = new HotelsPage(Driver.getDriver());
        Actions actions = new Actions(Driver.getDriver());
        BookingTestCase bookingTestCase = JSONparser.getBookingTestCase("src/test/resources/bookingTestData").get(2);
        bookingIndexPage.hotelSearch(bookingTestCase);
        bookingIndexPage.checkPrice();
        TimeUnit.SECONDS.sleep(5);
        hotelsPage.filterHotelClass(3);
        TimeUnit.SECONDS.sleep(5);
        hotelsPage.filterHotelClass(4);
        TimeUnit.SECONDS.sleep(5);
        hotelsPage.scrollToTheHotel(10);
        TimeUnit.SECONDS.sleep(15);
        WebElement address = hotelsPage.getAddress();
        actions.moveToElement(address).build().perform();

        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].style.backgroundColor='green'", address);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].style.color='red'", address);

        Assert.assertEquals("rgba(255, 0, 0, 1)", (address.getCssValue("color")));
    }

    @After
    public void afterAddressColorOsloTestInfo() {
        LOGGER.info("AddressColorOsloTest is finfshed");
    }
}