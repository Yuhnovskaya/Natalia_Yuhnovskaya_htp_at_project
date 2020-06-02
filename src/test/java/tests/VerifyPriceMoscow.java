package tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import steps.bookingTestSteps.BookingSteps;
import testObject.BookingTestObjects.BookingTestCase;
import utilites.JSONparser;
import webDriver.Config;
import webDriver.DrManager;
import webDriver.Prop;
import webPages.HotelsPage;

import java.io.FileNotFoundException;
import java.util.Properties;

public class VerifyPriceMoscow {
  /*    static Properties prop = Prop.getProp();
      static WebDriver driver= DrManager.getDriver(Config.CHROME);
   @BeforeClass
      public static void doBeforeClass() throws InterruptedException {
           driver.get(prop.getProperty("URL_BOOKING"));
      }*/
     @Test
     public void verifyPriceMoscow() throws InterruptedException, FileNotFoundException {
         BookingSteps bookingSteps=new BookingSteps();
         Properties prop = Prop.getProp();
         WebDriver driver= DrManager.getDriver(Config.CHROME);
         HotelsPage hotelsPage=new HotelsPage(driver);
         driver.get(prop.getProperty("URL_BOOKING"));
         BookingTestCase bookingTestCase= JSONparser.getBookingTestCase("src/test/resources/bookingTestData").get(0);
         bookingSteps.hotelSearch(driver,bookingTestCase);
         Thread.sleep(5000);
         hotelsPage.cheapestHotels();
         Thread.sleep(5000);
         int maxPrice = bookingSteps.getMinPrice(driver);

         Thread.sleep(3000);
         hotelsPage.SortExpensiveToCheap();
         Thread.sleep(4000);
         int minHotelPrice = bookingSteps.priceOfTheFirstHotelOnTheList(driver);

         Assert.assertTrue(minHotelPrice<=maxPrice);
    }
/*@After
    public static void doAfter(){
        DestroyDriver.destroy(driver);
    }*/
}
