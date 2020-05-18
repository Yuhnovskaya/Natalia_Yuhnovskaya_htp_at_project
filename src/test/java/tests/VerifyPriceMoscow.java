package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webDriver.Prop;
import webPages.BookingIndexPage;
import webPages.HotelsPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class VerifyPriceMoscow {
      static Properties prop = Prop.getProp();
      static WebDriver driver= DrManager.getDriver(Config.CHROME);
      @BeforeClass
      public static void doBeforeClass() throws InterruptedException {
           driver.get(prop.getProperty("URL_BOOKING"));
      }
  /*    @Before
      public void doBeforeTest() throws InterruptedException {
          BookingIndexPage.hotelSearch(driver,"Moscow",10,5,4,0,2);
          Thread.sleep(5000);
          HotelsPage.cheapestHotelsFilter(driver);
          int maxPrice = HotelsPage.getMinPrice(driver);
          Thread.sleep(3000);
          HotelsPage.SortExpensiveToCheap(driver);
          Thread.sleep(4000);
          int minHotelPrice = HotelsPage.priceOfTheFirstHotelOnTheList(driver);
      }*/
     @Test
     public void verifyPriceMoscow() throws InterruptedException {
         BookingIndexPage.hotelSearch(driver,"Moscow",10,5,4,0,2);
         Thread.sleep(5000);
         HotelsPage.cheapestHotelsFilter(driver);
         Thread.sleep(5000);
         int maxPrice = HotelsPage.getMinPrice(driver);
         Thread.sleep(3000);
         HotelsPage.SortExpensiveToCheap(driver);
         Thread.sleep(4000);
         int minHotelPrice = HotelsPage.priceOfTheFirstHotelOnTheList(driver);
          Assert.assertTrue(minHotelPrice<=maxPrice);
    }
/*@After
    public static void doAfter(){
        DestroyDriver.destroy(driver);
    }*/
}
