package runners;

import org.openqa.selenium.WebDriver;
import webDriver.Prop;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webDriver.BaseSteps;
import webPages.YandexLoginPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TrashmailConfirmByYandex {
    public static void main(String[] avgs) throws InterruptedException {
        WebDriver driver = DrManager.getDriver(Config.CHROME);
        Properties prop = Prop.getProp();

        YandexLoginPage.enterYandexMail(driver);
        TimeUnit.SECONDS.sleep(10);
        BaseSteps.findClick(driver,"//*[contains(text(), \""+prop.getProperty("SENDER")+"\")]");
        TimeUnit.SECONDS.sleep(15);
        BaseSteps.findClick(driver,"//*[contains(@href, \"https://trashmail.com/?\"]");
        DestroyDriver.destroy(driver);
    }
}
