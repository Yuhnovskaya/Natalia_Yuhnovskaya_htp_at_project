package webPages;

import org.openqa.selenium.WebDriver;
import webDriver.Prop;
import webDriver.BaseSteps;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class YandexLoginPage {
    static Properties prop = Prop.getProp();
    public static void enterYandexMail(WebDriver driver) throws InterruptedException {
        driver.get(prop.getProperty("URL_YANDEX"));
        BaseSteps.findClick(driver,"//*[@class=\"HeadBanner-ButtonsWrapper\"]/a[2]");
        TimeUnit.SECONDS.sleep(1);
        BaseSteps.findSendKeysClick(driver,"//*[@id=\"passp-field-login\"]", prop.getProperty("YA_MAIL"));
        TimeUnit.SECONDS.sleep(1);
        BaseSteps.findSendKeysClick(driver,"//*[@id=\"passp-field-passwd\"]", prop.getProperty("YA_PASSWORD"));
    }
}
