package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;
import steps.booking_test_steps.BookingProperties;
import test_objects.booking_test_objects.BookingTestCase;
import utilites.JSONparser;
import web_driver.*;
import web_pages.BookingIndexPage;
import web_pages.HotelsPage;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class PriceParisTest {
    private static final Logger LOGGER = LogManager.getLogger(PriceParisTest.class);

    @Before
    public void beforePriceParisTestInfo() {
        LOGGER.info("PriceParisTest started running");
    }

    @Test
    public void parisTest() throws InterruptedException, FileNotFoundException {
        BookingProperties bookingProperties = new BookingProperties();
        Driver.getURL(bookingProperties.urlBooking);
        BookingIndexPage bookingIndexPage = new BookingIndexPage(Driver.getDriver());
        HotelsPage hotelsPage = new HotelsPage(Driver.getDriver());
        BookingTestCase bookingTestCase = JSONparser.getBookingTestCase("src/test/resources/bookingTestData").get(1);
        bookingIndexPage.hotelSearch(bookingTestCase);
        bookingIndexPage.checkPrice();
        TimeUnit.SECONDS.sleep(7);
        hotelsPage.expensiveHotels();
        int maxPrice = hotelsPage.getMaxPrice();
        TimeUnit.SECONDS.sleep(3);
        int ExpHotelPrice = hotelsPage.priceOfTheFirstHotelOnTheList();
        Assert.assertTrue(ExpHotelPrice >= maxPrice);
    }

    @After
    public void afterPriceParisTestInfo() throws InterruptedException {
        Driver.clearCache();
        LOGGER.info("PriceParisTest is finfshed");
    }
}

