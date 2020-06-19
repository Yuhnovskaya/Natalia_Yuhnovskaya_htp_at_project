package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;

import settings.BookingProperties;
import test_objects.booking_test_objects.BookingTestCase;
import utilites.JSONparser;
import web_driver.Config;
import web_driver.Driver;
import web_pages.*;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

public class ColorWishlistTest {
    /*BookingProperties bookingProperties=new BookingProperties();
        WebDriver driver = Driver.initDriver(Config.CHROME);
        BookingIndexPage bookingIndexPage = new BookingIndexPage(driver);
        HotelsPage hotelsPage = new HotelsPage(driver);
        WishlistPage wishlistPage = new WishlistPage(driver);*/
   static WebDriver driver = Driver.initDriver(Config.CHROME);;
   static BookingIndexPage bookingIndexPage=new BookingIndexPage(driver);
   static HotelsPage hotelsPage=new HotelsPage(driver);
    private static final Logger LOGGER = LogManager.getLogger(ColorWishlistTest.class);

    @Before
    public void beforeColorWishlistTestInfo() {
        LOGGER.info("ColorWishlistTest started running");
    }

    @BeforeClass
    public static void doBefore() throws InterruptedException, FileNotFoundException {
        BookingProperties bookingProperties = new BookingProperties();
        WishlistPage wishlistPage = new WishlistPage(driver);
        TrashmailIndexPage trashmailIndexPage = new TrashmailIndexPage(driver);
        TrashmailAddressManagerPage trashmailAddressManagerPage = new TrashmailAddressManagerPage(driver);
        BookingLoginPage bookingLoginPage = new BookingLoginPage(driver);
        Driver.getURL(bookingProperties.urlTrashmail);
        trashmailIndexPage.trashmailLogin(bookingProperties.userName, bookingProperties.trashmailPassword);
        TimeUnit.SECONDS.sleep(20);
        String email = trashmailAddressManagerPage.getTrashmailAddress();
        Driver.getURL(bookingProperties.urlBooking);
        bookingIndexPage.enterAccount();
        bookingLoginPage.login(email, bookingProperties.bookingPassword);
        TimeUnit.SECONDS.sleep(5);
        BookingTestCase bookingTestCase = JSONparser.getBookingTestCase("src/test/resources/bookingTestData").get(3);
        bookingIndexPage.hotelSearch(bookingTestCase);
        bookingIndexPage.checkPrice();
        TimeUnit.SECONDS.sleep(15);
        hotelsPage.firstHeartClick();
        TimeUnit.SECONDS.sleep(10);
        hotelsPage.lastHeartClick();
        TimeUnit.SECONDS.sleep(10);
    }

    @Test
    public void verifyColorTest() throws InterruptedException {
        Assert.assertEquals("rgb(204, 0, 0)", hotelsPage.getFirstHeartIcon().getCssValue("fill"));
        Assert.assertEquals("rgb(204, 0, 0)", hotelsPage.getLastHeartIcon().getCssValue("fill"));
    }

    @Test
    public void verifyWishlistTest() throws InterruptedException {
        String firstHotelName = hotelsPage.getFistHotelName();
        String lastHotelName = hotelsPage.getFistlastName();
        TimeUnit.SECONDS.sleep(5);
        bookingIndexPage.wishlist();
        TimeUnit.SECONDS.sleep(5);
        Assert.assertEquals(firstHotelName, hotelsPage.firstHotelName(firstHotelName).getText());
        Assert.assertEquals(lastHotelName, hotelsPage.lastHotelName(lastHotelName).getText());
    }

    /*  @AfterClass
  public static void doAfter() throws InterruptedException {

      wishlistPage.removeHotelClick();
      TimeUnit.SECONDS.sleep(5);
      wishlistPage.removeHotelClick();
      DestroyDriver.destroy(driver);
  }*/
    @After
    public void afterColorWishlistTestInfo() {
        LOGGER.info("ColorWishlistTest is finfshed");
    }
}

