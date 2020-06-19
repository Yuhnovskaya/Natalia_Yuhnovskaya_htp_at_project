package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import settings.BookingProperties;
import web_driver.Config;
import web_driver.Driver;
import web_pages.BookingIndexPage;
import web_pages.BookingLoginPage;
import web_pages.TrashmailAddressManagerPage;
import web_pages.TrashmailIndexPage;
import java.util.concurrent.TimeUnit;

public class LoginBookingTest {
    private static final Logger LOGGER = LogManager.getLogger(ColorWishlistTest.class);

    @Before
    public void beforeLoginBookingTestInfo() {
        LOGGER.info("LoginBookingTest started running");
    }

    @Test
    public void verifyLoginBookingTest() throws InterruptedException {
        WebDriver driver = Driver.initDriver(Config.CHROME);
        BookingProperties bookingProperties = new BookingProperties();
        BookingIndexPage bookingIndexPage = new BookingIndexPage(driver);
        BookingLoginPage bookingLoginPage = new BookingLoginPage(driver);
        TrashmailAddressManagerPage trashmailAddressManagerPage=new TrashmailAddressManagerPage(driver);
        TrashmailIndexPage trashmailIndexPage=new TrashmailIndexPage(driver);
        Driver.getURL(bookingProperties.urlTrashmail);
        trashmailIndexPage.trashmailLogin(bookingProperties.userName,bookingProperties.trashmailPassword);
        TimeUnit.SECONDS.sleep(20);
        String email = trashmailAddressManagerPage.getTrashmailAddress();
        Driver.getURL(bookingProperties.urlBooking);
        bookingIndexPage.enterAccount();
        bookingLoginPage.login( email, bookingProperties.bookingPassword);
        TimeUnit.SECONDS.sleep(10);
        bookingIndexPage.enterAccount();
        TimeUnit.SECONDS.sleep(3);
        Assert.assertTrue(bookingLoginPage.logoutLinkPresents());
    }

    /*    @AfterClass
        public static void doafter(){
        DestroyDriver.destroy(driver);
        }*/
    @After
    public void afterLoginBookingTestInfo() {
        LOGGER.info("LoginBookingTest is finfshed");
    }
}
