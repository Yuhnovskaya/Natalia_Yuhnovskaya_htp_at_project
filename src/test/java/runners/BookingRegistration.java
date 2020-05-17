package runners;

import org.openqa.selenium.WebDriver;
import webDriver.Prop;
import webDriver.Config;
import webDriver.DrManager;
import webDriver.BaseSteps;
import webPages.TrashmailAddressManagerPage;
import webPages.YandexLoginPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BookingRegistration {
    public static void main(String[] avgs) throws InterruptedException {
        Properties prop = Prop.getProp();
        WebDriver driver= DrManager.getDriver(Config.CHROME);
        String newAddress= TrashmailAddressManagerPage.createTrashmailAddress(driver);
        driver.get("https://www.booking.com/");
        BaseSteps.findClick(driver,"(//*[@class=\"sign_in_wrapper\"])[1]");
        TimeUnit.SECONDS.sleep(3);
        BaseSteps.findSendKeysClick(driver, "//*[@type='email']", newAddress);
        TimeUnit.SECONDS.sleep(3);
        BaseSteps.findSendKeysClick(driver, " //*[@id='password']", prop.getProperty("BOOKING_PSW"));
        BaseSteps.findSendKeysClick(driver, "//*[@id='confirmed_password']", prop.getProperty("BOOKING_PSW"));
        TimeUnit.SECONDS.sleep(3);
        BaseSteps.findClick(driver, "//*[contains(@class,'closeBtn')]");
        YandexLoginPage.enterYandexMail(driver);
        TimeUnit.SECONDS.sleep(10);
        BaseSteps.findClick(driver,"//*[@href=\"#spam\"]");
        TimeUnit.SECONDS.sleep(15);
        BaseSteps.findClick(driver,"(//*[contains(text(), \"booking\")])[1]");
        TimeUnit.SECONDS.sleep(5);
        BaseSteps.findClick(driver,"//span[contains(text(),'Включить')]");
        BaseSteps.findClick(driver,"//*[contains(@href,\"https://secure.booking.com/login.ru.html?\")]");
    }
}
