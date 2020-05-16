package runners;

import org.openqa.selenium.WebDriver;
import otherStuff.Prop;
import webDriver.Config;
import webDriver.DestroyDriver;
import webDriver.DrManager;
import webDriver.Steps;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TrashmailRegistration {
    public static WebDriver driver;

    public static void main(String[] avgs) throws InterruptedException {
        driver = DrManager.getDriver(Config.CHROME);
        Properties prop = Prop.getProp();

        driver.get(prop.getProperty("URL_TRASHMAIL"));
        Steps.findClick(driver,"//*[@id=\"tab-mob-create\"]/li[3]");
        TimeUnit.SECONDS.sleep(3);
        Steps.findSendKeysClick(driver,"//*[@id=\"tab-mob-register\"]/form/div[1]/input", prop.getProperty("USER_NAME"));
        Steps.findSendKeysClick(driver,"//*[@id=\"tab-mob-register\"]/form/div[2]/input", prop.getProperty("PSW"));
        Steps.findSendKeysClick(driver,"//*[@id=\"tab-mob-register\"]/form/div[3]/input",prop.getProperty("PSW"));
        Steps.findSendKeysClick(driver,"//*[@id=\"tab-mob-register\"]/form/div[4]/input",prop.getProperty("YA_MAIL"));
        Steps.findClick(driver,"//*[@id=\"tab-mob-register\"]/form/div[6]/button");
        DestroyDriver.destroy(driver);
        }
 }