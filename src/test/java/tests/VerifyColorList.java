package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import otherStuff.Calendar;
import otherStuff.GetTrashmailAddress;
import otherStuff.LoginBooking;
import otherStuff.Prop;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webDriver.Steps;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class VerifyColorList {

        WebDriver driver= DrManager.getDriver(Config.CHROME);
        /* public static void dobefore() {
        Properties prop = Prop.getProp();
        String email=GetTrashmailAddress.getTrashmailAddress(driver);
        driver.get(prop.getProperty("URL_BOOKING"));
        LoginBooking.login(driver,email,prop.getProperty("BOOKING_PSW"));
    }*/

        @Test
        public void verifyLoginBookingTest() throws InterruptedException {
        String email = GetTrashmailAddress.getTrashmailAddress(driver);
        Properties prop = Prop.getProp();
        driver.get(prop.getProperty("URL_BOOKING"));
        LoginBooking.login(driver, email, prop.getProperty("BOOKING_PSW"));

        TimeUnit.SECONDS.sleep(5);
        Steps.findCity(driver, "Мадрид");
        Calendar.getDatesInUntil(driver, 30, 5);
        Steps.checkPrice(driver);
        TimeUnit.SECONDS.sleep(15);
        WebElement firstHeart = Steps.elementFindClick(driver, "//*[@id=\"hotellist_inner\"]/div[1]/div[1]/div/button");
        String firstHotelName = driver.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[1]//span[contains(@class, \"sr-hotel__name\")]")).getText();
        TimeUnit.SECONDS.sleep(10);
        WebElement lastHeart = Steps.elementFindClick(driver, "//*[@id=\"hotellist_inner\"]/div[51]/div[1]/div/button");
        String lastHotelName = driver.findElement(By.xpath("//*[@id=\"hotellist_inner\"]/div[51]//span[contains(@class,\"sr-hotel__name\")]")).getText();
        TimeUnit.SECONDS.sleep(10);

        Assert.assertEquals("rgb(204, 0, 0)", Steps.findElement(driver, "//*[@id=\"hotellist_inner\"]/div[1]//*[contains(@class,'bk-icon -iconset-heart sr-wl-entry-heart-svg')]").getCssValue("fill"));
        Assert.assertEquals("rgb(204, 0, 0)", Steps.findElement(driver, "//*[@id=\"hotellist_inner\"]/div[51]//*[contains(@class,'bk-icon -iconset-heart sr-wl-entry-heart-svg')]").getCssValue("fill"));

        Steps.wishlist(driver);
        TimeUnit.SECONDS.sleep(5);

        Assert.assertEquals(firstHotelName, driver.findElement(By.xpath("//*[contains(text(),'" + firstHotelName + "')]")).getText());
        Assert.assertEquals(lastHotelName, driver.findElement(By.xpath(String.format("//*[contains(text(),'" + lastHotelName + "')]", lastHotelName))).getText());

        Steps.findClick(driver, "//*[@class=\"js-remove-hotel listview__remove_hotel_icon\"]");
        TimeUnit.SECONDS.sleep(5);
        Steps.findClick(driver, "//*[@class=\"js-remove-hotel listview__remove_hotel_icon\"]");
        DestroyDriver.destroy(driver);
        }
        /*public static void doafter(){
        DestroyDriver.destroy(driver);
        }*/
}
