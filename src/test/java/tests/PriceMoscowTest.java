package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;
import settings.BookingProperties;
import test_objects.booking_test_objects.BookingTestCase;
import utilites.JSONparser;
import web_driver.Config;
import web_driver.Driver;
import web_pages.BookingIndexPage;
import web_pages.HotelsPage;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class PriceMoscowTest {
    private static final Logger LOGGER = LogManager.getLogger(PriceMoscowTest.class);

    @Before
    public void beforePriceMoscowTestInfo() {
        LOGGER.info("PriceMoscowTest started running");
    }

    @Test
    public void verifyPriceMoscow() throws InterruptedException, FileNotFoundException {
        Driver.initDriver(Config.CHROME);
        BookingProperties bookingProperties = new BookingProperties();
        BookingIndexPage bookingIndexPage = new BookingIndexPage(Driver.getDriver());
        HotelsPage hotelsPage = new HotelsPage(Driver.getDriver());
        Driver.getURL(bookingProperties.urlBooking);
        BookingTestCase bookingTestCase = JSONparser.getBookingTestCase("src/test/resources/bookingTestData").get(0);
        bookingIndexPage.hotelSearch(bookingTestCase);
        bookingIndexPage.checkPrice();
        TimeUnit.SECONDS.sleep(5);
        hotelsPage.cheapestHotels();
        TimeUnit.SECONDS.sleep(5);
        int maxPrice = hotelsPage.getMinPrice();
        TimeUnit.SECONDS.sleep(3);
        hotelsPage.SortExpensiveToCheap();
        TimeUnit.SECONDS.sleep(4);
        int minHotelPrice = hotelsPage.priceOfTheFirstHotelOnTheList();
        Assert.assertTrue(minHotelPrice <= maxPrice);
    }

    @After
    public void afterPriceMoscowTestInfo() throws InterruptedException {
        Driver.clearCache();
        LOGGER.info("PriceMoscowTest is finfshed");
    }
}
