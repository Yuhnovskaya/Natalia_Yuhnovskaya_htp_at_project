package other_stuff;

import org.openqa.selenium.WebDriver;
import steps.booking_test_steps.BookingProperties;
import web_driver.*;
import web_pages.YandexLoginPage;
import web_pages.YandexMailContеntPage;
import web_pages.YandexMailPage;

import java.util.concurrent.TimeUnit;

public class TrashmailConfirmationByYandex {
    public static void main(String[] avgs) throws InterruptedException {

        Driver.initDriver(Config.CHROME);
        WebDriver driver=Driver.getDriver();
        YandexLoginPage yandexLoginPage = new YandexLoginPage(driver);
        YandexMailContеntPage yandexMailContеntPage=new YandexMailContеntPage(driver);
        YandexMailPage yandexMailPage=new YandexMailPage(driver);
        BookingProperties bookingProperties = new BookingProperties();
        Driver.getURL(bookingProperties.urlYandex);
        yandexLoginPage.enterYandexMail(bookingProperties.yandexMail, bookingProperties.yandexPassword);
        TimeUnit.SECONDS.sleep(10);
        yandexMailPage.findMailfromTrashMail();
        TimeUnit.SECONDS.sleep(15);
        yandexMailContеntPage.confirmTrashmail();
        Driver.destroyDriver();
    }
}
