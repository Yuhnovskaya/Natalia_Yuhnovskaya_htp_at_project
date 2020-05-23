package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webDriver.Prop;
import webPages.BookingHeader;
import webPages.BookingLoginPage;
import webPages.TrashmailAddressManagerPage;


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

        Properties prop = Prop.getProp();
        String email= TrashmailAddressManagerPage.getTrashmailAddress(driver);
        driver.get(prop.getProperty("URL_BOOKING"));
        BookingLoginPage.login(driver,email,prop.getProperty("BOOKING_PSW"));
        TimeUnit.SECONDS.sleep(5);

        Assert.assertTrue(BookingHeader.accountPresents(driver));
        Assert.assertTrue(BookingHeader.airportTaxiPresents(driver));
        Assert.assertTrue(BookingHeader.attractionsPresents(driver));
        Assert.assertTrue(BookingHeader.carRentsPresents(driver));
        Assert.assertTrue(BookingHeader.countryPresents(driver));
        Assert.assertTrue(BookingHeader.flightsPresents(driver));
        Assert.assertTrue(BookingHeader.helpPresents(driver));
        Assert.assertTrue(BookingHeader.languagePresents(driver));
        Assert.assertTrue(BookingHeader.logoPresents(driver));
        Assert.assertTrue(BookingHeader.propertyPresents(driver));
       // Assert.assertTrue(header.registrationPresents(driver));
        Assert.assertTrue(BookingHeader.stayPresents(driver));

        DestroyDriver.destroy(driver);
        }
}
