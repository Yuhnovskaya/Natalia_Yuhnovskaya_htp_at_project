package steps.bookingTestSteps;

import org.openqa.selenium.WebDriver;
import webDriver.Prop;
import webPages.YandexLoginPage;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class YandexSteps {
    public void enterYandexMail(WebDriver driver) throws InterruptedException {
        YandexLoginPage yandexLoginPage=new YandexLoginPage(driver);
        Properties prop = Prop.getProp();
        driver.get(prop.getProperty("URL_YANDEX"));
        yandexLoginPage.signInClick();
        TimeUnit.SECONDS.sleep(1);
        yandexLoginPage.enterEmail(prop.getProperty("YA_MAIL"));
        TimeUnit.SECONDS.sleep(1);
        yandexLoginPage.enterPassword(prop.getProperty("YA_PASSWORD"));
    }

}


