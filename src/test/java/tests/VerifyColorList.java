package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webDriver.Prop;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webDriver.BaseSteps;
import webPages.BookingIndexPage;
import webPages.BookingLoginPage;
import webPages.TrashmailAddressManagerPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class VerifyColorList {
        static Properties prop = Prop.getProp();
        static WebDriver driver= DrManager.getDriver(Config.CHROME);
        @BeforeClass
        public static void doBefore() throws InterruptedException {
        String email=TrashmailAddressManagerPage.getTrashmailAddress(driver);
        driver.get(prop.getProperty("URL_BOOKING"));
        BookingLoginPage.login(driver,email,prop.getProperty("BOOKING_PSW"));
        TimeUnit.SECONDS.sleep(5);
        BookingIndexPage.findCity(driver, "Мадрид");
        BookingIndexPage.getDatesFromUntil(driver, 30, 5);
        BookingIndexPage.checkPrice(driver);
        TimeUnit.SECONDS.sleep(15);
        WebElement firstHeart = BaseSteps.elementFindClick(driver, "//*[@id=\"hotellist_inner\"]/div[1]/div[1]/div/button");
        TimeUnit.SECONDS.sleep(10);
        WebElement lastHeart = BaseSteps.elementFindClick(driver, "//*[@id=\"hotellist_inner\"]/div[51]/div[1]/div/button");
        TimeUnit.SECONDS.sleep(10);
        }

        @Test
        public void verifyColorTest() throws InterruptedException {
        Assert.assertEquals("rgb(204, 0, 0)", BaseSteps.findElement(driver, "//*[@id=\"hotellist_inner\"]/div[1]//*[contains(@class,'bk-icon -iconset-heart sr-wl-entry-heart-svg')]").getCssValue("fill"));
        Assert.assertEquals("rgb(204, 0, 0)", BaseSteps.findElement(driver, "//*[@id=\"hotellist_inner\"]/div[51]//*[contains(@class,'bk-icon -iconset-heart sr-wl-entry-heart-svg')]").getCssValue("fill"));
        }
        @Test
        public void verifyWishlistTest() throws InterruptedException {
        String firstHotelName = driver.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[1]//span[contains(@class, \"sr-hotel__name\")]")).getText();
        String lastHotelName = driver.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[51]//span[contains(@class,\"sr-hotel__name\")]")).getText();
        BookingIndexPage.wishlist(driver);
        TimeUnit.SECONDS.sleep(5);

        Assert.assertEquals(firstHotelName, driver.findElement(By.xpath("//*[contains(text(),'" + firstHotelName + "')]")).getText());
        Assert.assertEquals(lastHotelName, driver.findElement(By.xpath(String.format("//*[contains(text(),'" + lastHotelName + "')]", lastHotelName))).getText());
        }
        @AfterClass
        public static void doAfter() throws InterruptedException {
                BaseSteps.findClick(driver, "//*[@class=\"js-remove-hotel listview__remove_hotel_icon\"]");
                TimeUnit.SECONDS.sleep(5);
                BaseSteps.findClick(driver, "//*[@class=\"js-remove-hotel listview__remove_hotel_icon\"]");
                DestroyDriver.destroy(driver);
        }
}
