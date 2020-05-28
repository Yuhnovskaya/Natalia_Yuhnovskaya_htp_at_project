package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import steps.bookingTestSteps.BookingSteps;
import testObject.BookingTestObjects.BookingTestCase;
import utilites.JSONparser;
import webDriver.*;
import webPages.HotelsPage;

import java.io.FileNotFoundException;
import java.util.Properties;

public class VerifyPriceParis {
  /*  static Properties prop = Prop.getProp();
    static WebDriver driver= DrManager.getDriver(Config.CHROME);
    @BeforeClass
    public static void doBefore() throws InterruptedException {
        driver.get(prop.getProperty("URL_BOOKING"));
    }*/
@Test
public void verifyPriceParis() throws InterruptedException, FileNotFoundException {
    BookingSteps bookingSteps=new BookingSteps();
    Properties prop = Prop.getProp();
    WebDriver driver= DrManager.getDriver(Config.CHROME);
    HotelsPage hotelsPage=new HotelsPage(driver);
   driver.get(prop.getProperty("URL_BOOKING"));
    BookingTestCase bookingTestCase= JSONparser.getBookingTestCase("src/test/resources/bookingTestData").get(1);
    bookingSteps.hotelSearch(driver,bookingTestCase);
    Thread.sleep(5000);
    hotelsPage.expensiveHotels();
    int maxPrice = bookingSteps.getMaxPrice(driver);
    System.out.println(maxPrice);
    Thread.sleep(3000);
   // hotelsPage.SortExpensiveToCheap();
  //  Thread.sleep(3000);
    int ExpHotelPrice = bookingSteps.priceOfTheFirstHotelOnTheList(driver);
    System.out.println(ExpHotelPrice);
       Assert.assertTrue(ExpHotelPrice>=maxPrice);
    }
/*@After
    public void doAfterClass(){
        DestroyDriver.destroy(driver);
    }*/
}
