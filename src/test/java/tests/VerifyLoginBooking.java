package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import webDriver.Prop;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webPages.BookingIndexPage;
import webPages.BookingLoginPage;
import webPages.TrashmailAddressManagerPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class VerifyLoginBooking {
    static WebDriver driver= DrManager.getDriver(Config.CHROME);
      static Properties prop = Prop.getProp();
       @BeforeClass
       public static void dobefore() throws InterruptedException {
       String email=TrashmailAddressManagerPage.getTrashmailAddress(driver);
       driver.get(prop.getProperty("URL_BOOKING"));
       BookingLoginPage.login(driver,email,prop.getProperty("BOOKING_PSW"));
           TimeUnit.SECONDS.sleep(10);
   }
        @Test
        public void verifyLoginBookingTest() throws InterruptedException {
           BookingIndexPage.enterAccaunt(driver);
            TimeUnit.SECONDS.sleep(3);
            Assert.assertTrue(BookingLoginPage.logoutLinkPresents(driver));

    }
    @AfterClass
    public static void doafter(){
    DestroyDriver.destroy(driver);
    }
}
