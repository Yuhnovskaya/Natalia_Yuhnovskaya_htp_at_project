package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import steps.bookingTestSteps.BookingSteps;
import steps.bookingTestSteps.TrashMailSteps;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webDriver.Prop;
import webPages.BookingHeader;


import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class VerifyHeaderElements {
    static WebDriver driver = DrManager.getDriver(Config.CHROME);
  /*public static void dobefore() throws InterruptedException {
        Properties prop = Prop.getProp();
        String email=GetTrashmailAddress.getTrashmailAddress(driver);
        driver.get(prop.getProperty("URL_BOOKING"));
        LoginBooking.login(driver,email,prop.getProperty("BOOKING_PSW"));
    }*/

@Test
        public void verifyHeaderElementsTest() throws InterruptedException {
        BookingHeader bookingHeader=new BookingHeader(driver);
        BookingSteps bookingSteps=new BookingSteps();
        TrashMailSteps trashMailSteps=new TrashMailSteps();
        Properties prop = Prop.getProp();
        String email= trashMailSteps.getTrashmailAddress(driver);
        driver.get(prop.getProperty("URL_BOOKING"));
        bookingSteps.login(driver,email,prop.getProperty("BOOKING_PSW"));
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

        DestroyDriver.destroy(driver);
        }
}
