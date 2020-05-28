package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import steps.bookingTestSteps.BookingSteps;
import testObject.BookingTestObjects.BookingTestCase;
import utilites.JSONparser;
import webDriver.Config;
import webDriver.DrManager;
import webDriver.Prop;
import webPages.HotelsPage;

import java.io.FileNotFoundException;
import java.util.Properties;

public class VerifyAddressColorOslo {
 /*   static Properties prop = Prop.getProp();
    static WebDriver driver = DrManager.getDriver(Config.CHROME);
    Actions actions=new Actions(driver);
    @BeforeClass
    public static void doBefore() throws InterruptedException {
        driver.get(prop.getProperty("URL_BOOKING"));
    }*/

    @Test
    public void verifyAddressColorOslo() throws InterruptedException, FileNotFoundException {
        Properties prop = Prop.getProp();
        WebDriver driver = DrManager.getDriver(Config.CHROME);
        Actions actions=new Actions(driver);
        driver.get(prop.getProperty("URL_BOOKING"));
        BookingSteps bookingSteps=new BookingSteps();
        HotelsPage hotelsPage=new HotelsPage(driver);
        BookingTestCase bookingTestCase= JSONparser.getBookingTestCase("src/test/resources/bookingTestData").get(2);
        bookingSteps.hotelSearch(driver,bookingTestCase);
        Thread.sleep(5000);
        bookingSteps.filterHotelClass(driver,3);
        Thread.sleep(5000);
        bookingSteps.filterHotelClass(driver, 4);
        Thread.sleep(5000);
        bookingSteps.scrollToTheHotel(driver, 10);
        Thread.sleep(15000);
        WebElement address = hotelsPage.getAddress();
        actions.moveToElement(address).build().perform();

        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='green'", address);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color='red'", address);

        Assert.assertEquals("rgba(255, 0, 0, 1)", (address.getCssValue("color")));
    }

   /* @AfterClass
    public static void doafter() {
        DestroyDriver.destroy(driver);
    }*/
}