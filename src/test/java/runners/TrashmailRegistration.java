package runners;

import org.openqa.selenium.WebDriver;
import webDriver.Prop;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webDriver.BaseSteps;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TrashmailRegistration {
    public static WebDriver driver;

    public static void main(String[] avgs) throws InterruptedException {
        driver = DrManager.getDriver(Config.CHROME);
        Properties prop = Prop.getProp();

        driver.get(prop.getProperty("URL_TRASHMAIL"));
        BaseSteps.findClick(driver,"//*[@id=\"tab-mob-create\"]/li[3]");
        TimeUnit.SECONDS.sleep(3);
        BaseSteps.findSendKeysClick(driver,"//*[@id=\"tab-mob-register\"]/form/div[1]/input", prop.getProperty("USER_NAME"));
        BaseSteps.findSendKeysClick(driver,"//*[@id=\"tab-mob-register\"]/form/div[2]/input", prop.getProperty("PSW"));
        BaseSteps.findSendKeysClick(driver,"//*[@id=\"tab-mob-register\"]/form/div[3]/input",prop.getProperty("PSW"));
        BaseSteps.findSendKeysClick(driver,"//*[@id=\"tab-mob-register\"]/form/div[4]/input",prop.getProperty("YA_MAIL"));
        BaseSteps.findClick(driver,"//*[@id=\"tab-mob-register\"]/form/div[6]/button");
        DestroyDriver.destroy(driver);
        }
 }