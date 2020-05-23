package webPages;

import org.openqa.selenium.WebDriver;
import webDriver.Prop;
import webDriver.BaseSteps;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TrashmailIndexPage {

    public static void TrashmailLogin(WebDriver driver) throws InterruptedException {
        Properties prop = Prop.getProp();
        driver.get(prop.getProperty("URL_TRASHMAIL"));
        TimeUnit.SECONDS.sleep(5);
        BaseSteps.findClick(driver, "//*[@id=\"tab-mob-create\"]/li[2]/a");
        TimeUnit.SECONDS.sleep(10);
        BaseSteps.findSendKeys(driver, "//*[@id=\"tab-mob-manager\"]/form/div[1]/input", prop.getProperty("USER_NAME"));
        BaseSteps.findSendKeys(driver, "//*[@id=\"tab-mob-manager\"]/form/div[2]/input", prop.getProperty("PSW"));
        BaseSteps.findClick(driver, "//*[@id=\"tab-mob-manager\"]/form/div[4]/button");
    }
}
