package tests;

import org.checkerframework.checker.units.qual.A;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import webDriver.*;
import webPages.BookingIndexPage;
import webPages.BookingLoginPage;
import webPages.HotelsPage;
import webPages.TrashmailAddressManagerPage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class VerifyPriceParis {
    static Properties prop = Prop.getProp();
    static WebDriver driver= DrManager.getDriver(Config.CHROME);
    @BeforeClass
    public static void doBefore() throws InterruptedException {
        driver.get(prop.getProperty("URL_BOOKING"));
    }
@Test
public void verifyPriceParis() throws InterruptedException {
    BookingIndexPage.hotelSearch(driver,"Paris",3,7,4,0,2);
    Thread.sleep(5000);
    HotelsPage.ExpensiveHotelsFilter(driver);
    int maxPrice = HotelsPage.getMaxPrice(driver);
    Thread.sleep(3000);
    HotelsPage.SortExpensiveToCheap(driver);
    Thread.sleep(3000);
    int ExpHotelPrice = HotelsPage.priceOfTheFirstHotelOnTheList(driver);
       Assert.assertTrue(ExpHotelPrice>=maxPrice);
    }
/*@After
    public void doAfterClass(){
        DestroyDriver.destroy(driver);
    }*/
}
