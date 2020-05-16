package runners;

import org.openqa.selenium.WebDriver;
import otherStuff.EnterYandexMail;
import otherStuff.CreateTrashmailAddress;
import otherStuff.Prop;
import webDriver.Config;
import webDriver.DrManager;
import webDriver.Steps;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BookingRegistration {
    public static void main(String[] avgs) throws InterruptedException {
        Properties prop = Prop.getProp();
        WebDriver driver= DrManager.getDriver(Config.CHROME);
        String newAddress= CreateTrashmailAddress.createTrashmailAddress(driver);
        driver.get("https://www.booking.com/");
        Steps.findClick(driver,"(//*[@class=\"sign_in_wrapper\"])[1]");
        TimeUnit.SECONDS.sleep(3);
        Steps.findSendKeysClick(driver, "//*[@type='email']", newAddress);
        TimeUnit.SECONDS.sleep(3);
        Steps.findSendKeysClick(driver, " //*[@id='password']", prop.getProperty("BOOKING_PSW"));
        Steps.findSendKeysClick(driver, "//*[@id='confirmed_password']", prop.getProperty("BOOKING_PSW"));
        TimeUnit.SECONDS.sleep(3);
        Steps.findClick(driver, "//*[contains(@class,'closeBtn')]");
        EnterYandexMail.enterYandexMail(driver);
        TimeUnit.SECONDS.sleep(10);
        Steps.findClick(driver,"//*[@href=\"#spam\"]");
        TimeUnit.SECONDS.sleep(15);
        Steps.findClick(driver,"(//*[contains(text(), \"booking\")])[1]");
        TimeUnit.SECONDS.sleep(5);
        Steps.findClick(driver,"//span[contains(text(),'Включить')]");
        Steps.findClick(driver,"//*[contains(@href,\"https://secure.booking.com/login.ru.html?\")]");
    }
}
