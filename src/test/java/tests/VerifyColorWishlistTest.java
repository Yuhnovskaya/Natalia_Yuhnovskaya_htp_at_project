package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import steps.bookingTestSteps.BookingSteps;
import steps.bookingTestSteps.TrashMailSteps;
import testObject.BookingTestObjects.BookingTestCase;
import utilites.JSONparser;
import webDriver.Prop;
import webDriver.Config;
import webDriver.DrManager;
import webPages.BookingIndexPage;
import webPages.HotelsPage;
import webPages.WishlistPage;

import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class VerifyColorWishlistTest {
    static Properties prop = Prop.getProp();
    static WebDriver driver = DrManager.getDriver(Config.CHROME);
    static BookingIndexPage bookingIndexPage = new BookingIndexPage(driver);
    static HotelsPage hotelsPage = new HotelsPage(driver);
    static WishlistPage wishlistPage = new WishlistPage(driver);
    private static final Logger LOGGER = LogManager.getLogger(VerifyColorWishlistTest.class);

    @Before
    public void beforeColorWishlistTestInfo() {
        LOGGER.info("ColorWishlistTest started running");
    }
    @BeforeClass
    public static void doBefore() throws InterruptedException, FileNotFoundException {
        TrashMailSteps trashMailSteps = new TrashMailSteps();
        BookingSteps bookingSteps = new BookingSteps();

        String email = trashMailSteps.getTrashmailAddress(driver);
        driver.get(prop.getProperty("URL_BOOKING"));
        bookingSteps.login(driver, email, prop.getProperty("BOOKING_PSW"));
        TimeUnit.SECONDS.sleep(5);
        BookingTestCase bookingTestCase = JSONparser.getBookingTestCase("src/test/resources/bookingTestData").get(3);
        bookingSteps.hotelSearch(driver, bookingTestCase);
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

        Assert.assertEquals(firstHotelName, driver.findElement(By.xpath("//*[contains(text(),'" + firstHotelName + "')]")).getText());
        Assert.assertEquals(lastHotelName, driver.findElement(By.xpath(String.format("//*[contains(text(),'" + lastHotelName + "')]", lastHotelName))).getText());
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
