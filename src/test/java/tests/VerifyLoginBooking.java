package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import steps.bookingTestSteps.BookingSteps;
import steps.bookingTestSteps.TrashMailSteps;
import webDriver.Prop;
import webDriver.Config;
import webDriver.DrManager;
import webPages.BookingIndexPage;
import webPages.BookingLoginPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class VerifyLoginBooking {
    /*   static WebDriver driver= DrManager.getDriver(Config.CHROME);
         static Properties prop = Prop.getProp();

          @BeforeClass
          public static void dobefore() throws InterruptedException {
              BookingSteps bookingSteps=new BookingSteps();
              TrashMailSteps trashMailSteps=new TrashMailSteps();
          String email=trashMailSteps.getTrashmailAddress(driver);
          driver.get(prop.getProperty("URL_BOOKING"));
          bookingSteps.login(driver,email,prop.getProperty("BOOKING_PSW"));
              TimeUnit.SECONDS.sleep(10);
      }*/
    @Test
    public void verifyLoginBookingTest() throws InterruptedException {
        WebDriver driver = DrManager.getDriver(Config.CHROME);
        Properties prop = Prop.getProp();
        BookingIndexPage bookingIndexPage = new BookingIndexPage(driver);
        BookingLoginPage bookingLoginPage = new BookingLoginPage(driver);
        BookingSteps bookingSteps = new BookingSteps();
        TrashMailSteps trashMailSteps = new TrashMailSteps();
        String email = trashMailSteps.getTrashmailAddress(driver);
        driver.get(prop.getProperty("URL_BOOKING"));
        bookingSteps.login(driver, email, prop.getProperty("BOOKING_PSW"));
        TimeUnit.SECONDS.sleep(10);
        bookingIndexPage.enterAccount();
        TimeUnit.SECONDS.sleep(3);
        Assert.assertTrue(bookingLoginPage.logoutLinkPresents());
    }
/*    @AfterClass
    public static void doafter(){
    DestroyDriver.destroy(driver);
    }*/
}
