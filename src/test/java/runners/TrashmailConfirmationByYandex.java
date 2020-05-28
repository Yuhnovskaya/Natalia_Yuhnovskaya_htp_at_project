package runners;

import org.openqa.selenium.WebDriver;
import steps.bookingTestSteps.YandexSteps;
import webDriver.Prop;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import steps.bookingTestSteps.BaseSteps;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TrashmailConfirmationByYandex {
    public static void main(String[] avgs) throws InterruptedException {
        YandexSteps yandexSteps=new YandexSteps();
        WebDriver driver = DrManager.getDriver(Config.CHROME);
        Properties prop = Prop.getProp();

        yandexSteps.enterYandexMail(driver);
        TimeUnit.SECONDS.sleep(10);
        BaseSteps.findClick(driver,"//*[contains(text(), \""+prop.getProperty("SENDER")+"\")]");
        TimeUnit.SECONDS.sleep(15);
        BaseSteps.findClick(driver,"//*[contains(@href, \"https://trashmail.com/?\"]");
        DestroyDriver.destroy(driver);
    }
}
