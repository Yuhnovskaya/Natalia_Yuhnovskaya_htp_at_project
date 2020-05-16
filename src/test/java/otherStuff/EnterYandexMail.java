package otherStuff;

import org.openqa.selenium.WebDriver;
import webDriver.Steps;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class EnterYandexMail {
    static Properties prop = Prop.getProp();
    public static void enterYandexMail(WebDriver driver) throws InterruptedException {
        driver.get(prop.getProperty("URL_YANDEX"));
        Steps.findClick(driver,"//*[@class=\"HeadBanner-ButtonsWrapper\"]/a[2]");
        TimeUnit.SECONDS.sleep(1);
        Steps.findSendKeysClick(driver,"//*[@id=\"passp-field-login\"]", prop.getProperty("YA_MAIL"));
        TimeUnit.SECONDS.sleep(1);
        Steps.findSendKeysClick(driver,"//*[@id=\"passp-field-passwd\"]", prop.getProperty("YA_PASSWORD"));
        }
}
