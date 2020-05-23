package tests;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webDriver.Prop;
import webPages.BookingIndexPage;
import webPages.HotelsPage;

import java.util.Properties;

public class VerifyAddressColorOslo {
    static Properties prop = Prop.getProp();
    static WebDriver driver = DrManager.getDriver(Config.CHROME);
    Actions actions=new Actions(driver);
    @BeforeClass
    public static void doBefore() throws InterruptedException {
        driver.get(prop.getProperty("URL_BOOKING"));
    }

    @Test
    public void verifyAddressColorOslo() throws InterruptedException {
        BookingIndexPage.hotelSearch(driver,"Oslo",1,1,2,1,1);
        Thread.sleep(5000);
        HotelsPage.filterHotelClass(driver,3);
        Thread.sleep(5000);
        HotelsPage.filterHotelClass(driver, 4);
        Thread.sleep(5000);
        HotelsPage.scrollToTheHotel(driver, 10);

        Actions actions=new Actions(driver);
        Thread.sleep(15000);
        WebElement address = driver.findElement(By.xpath("//p[@id=\"showMap2\"]"));

        actions.moveToElement(address).build().perform();

        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='green'", address);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color='red'", address);

        Assert.assertEquals("rgba(255, 0, 0, 1)", (address.getCssValue("color")));
    }

   // @AfterClass
    public static void doafter() {
        DestroyDriver.destroy(driver);
    }
}