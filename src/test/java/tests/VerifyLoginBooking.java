package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import otherStuff.GetTrashmailAddress;
import otherStuff.Prop;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webDriver.Steps;
import webPages.loginPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class VerifyLoginBooking {
    WebDriver driver= DrManager.getDriver(Config.CHROME);
    /* public static void dobefore() {
       Properties prop = Prop.getProp();
       String email=GetTrashmailAddress.getTrashmailAddress(driver);
       driver.get(prop.getProperty("URL_BOOKING"));
       LoginBooking.login(driver,email,prop.getProperty("BOOKING_PSW"));
   }*/


        @Test
        public void verifyLoginBookingTest() throws InterruptedException {
            String email= GetTrashmailAddress.getTrashmailAddress(driver);
            Properties prop = Prop.getProp();
            driver.get("https://www.booking.com/");
            loginPage.login(driver,email, prop.getProperty("BOOKING_PSW"));
            TimeUnit.SECONDS.sleep(10);
            Steps.enterAccaunt(driver);
            TimeUnit.SECONDS.sleep(3);

            Assert.assertTrue(loginPage.logoutLinkPresents(driver));

            DestroyDriver.destroy(driver);
    }
    /*public static void doafter(){
    DestroyDriver.destroy(driver);
    }*/
}
