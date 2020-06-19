package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import steps.booking_test_steps.BookingProperties;
import web_driver.*;
import web_pages.*;


import java.util.concurrent.TimeUnit;


public class HeaderElementsTest {
    private static final Logger LOGGER = LogManager.getLogger(HeaderElementsTest.class);

    @Before
    public void beforeHeaderElementTestInfo() {
        LOGGER.info("HeaderElementsTest started running");
    }

    @Test
    public void verifyHeaderElementsTest() throws InterruptedException {
        WebDriver driver=Driver.initDriver(Config.CHROME);
        BookingHeader bookingHeader = new BookingHeader(driver);
        BookingIndexPage bookingIndexPage=new BookingIndexPage(driver);
        BookingLoginPage bookingLoginPage=new BookingLoginPage(driver);
        TrashmailIndexPage trashmailIndexPage=new TrashmailIndexPage(driver);
        TrashmailAddressManagerPage trashmailAddressManagerPage=new TrashmailAddressManagerPage(driver);
        BookingProperties bookingProperties=new BookingProperties();

        trashmailIndexPage.trashmailLogin(bookingProperties.userName,bookingProperties.trashmailPassword);
        String email=trashmailAddressManagerPage.getTrashmailAddress();
        Driver.getURL(bookingProperties.urlBooking);
        bookingIndexPage.enterAccount();
        bookingLoginPage.login(email, bookingProperties.bookingPassword);
        TimeUnit.SECONDS.sleep(5);

        Assert.assertTrue(bookingHeader.accountPresents(driver));
        Assert.assertTrue(bookingHeader.airportTaxiPresents(driver));
        Assert.assertTrue(bookingHeader.attractionsPresents(driver));
        Assert.assertTrue(bookingHeader.carRentsPresents(driver));
        Assert.assertTrue(bookingHeader.countryPresents(driver));
        Assert.assertTrue(bookingHeader.flightsPresents(driver));
        Assert.assertTrue(bookingHeader.helpPresents(driver));
        Assert.assertTrue(bookingHeader.languagePresents(driver));
        Assert.assertTrue(bookingHeader.logoPresents(driver));
        Assert.assertTrue(bookingHeader.propertyPresents(driver));
        Assert.assertTrue(bookingHeader.stayPresents(driver));

        Driver.destroyDriver();
    }

    @After
    public void afterHeaderElementTestInfo() {
        LOGGER.info("HeaderElementTest is finfshed");
    }
}
