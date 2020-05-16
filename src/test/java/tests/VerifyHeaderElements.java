package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import otherStuff.GetTrashmailAddress;
import otherStuff.LoginBooking;
import otherStuff.Prop;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webPages.header;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class VerifyHeaderElements {
    static WebDriver driver = DrManager.getDriver(Config.CHROME);
   /* public static void dobefore() {
        Properties prop = Prop.getProp();
        String email=GetTrashmailAddress.getTrashmailAddress(driver);
        driver.get(prop.getProperty("URL_BOOKING"));
        LoginBooking.login(driver,email,prop.getProperty("BOOKING_PSW"));
    }*/

@Test
        public void verifyHeaderElementsTest() throws InterruptedException {

        Properties prop = Prop.getProp();
        String email= GetTrashmailAddress.getTrashmailAddress(driver);
        driver.get(prop.getProperty("URL_BOOKING"));
        LoginBooking.login(driver,email,prop.getProperty("BOOKING_PSW"));
        TimeUnit.SECONDS.sleep(5);

        Assert.assertTrue(header.accountPresents(driver));
        Assert.assertTrue(header.airportTaxiPresents(driver));
        Assert.assertTrue(header.attractionsPresents(driver));
        Assert.assertTrue(header.carRentsPresents(driver));
        Assert.assertTrue(header.countryPresents(driver));
        Assert.assertTrue(header.flightsPresents(driver));
        Assert.assertTrue(header.helpPresents(driver));
        Assert.assertTrue(header.languagePresents(driver));
        Assert.assertTrue(header.logoPresents(driver));
        Assert.assertTrue(header.propertyPresents(driver));
       // Assert.assertTrue(header.registrationPresents(driver));
        Assert.assertTrue(header.stayPresents(driver));

        DestroyDriver.destroy(driver);
        }
/*public static void doafter(){
    DestroyDriver.destroy(driver);
    }*/
}
