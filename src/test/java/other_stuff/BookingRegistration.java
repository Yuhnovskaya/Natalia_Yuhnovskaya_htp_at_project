package other_stuff;

import org.openqa.selenium.WebDriver;
import steps.booking_test_steps.BookingProperties;
import web_driver.Driver;
import web_pages.*;

import java.util.concurrent.TimeUnit;

import static web_driver.Config.CHROME;

public class BookingRegistration {
    public static void main(String[] avgs) throws InterruptedException {
        Driver.initDriver(CHROME);
        WebDriver driver = Driver.getDriver();
        BookingProperties bookingProperties = new BookingProperties();
        TrashmailIndexPage trashmailIndexPage = new TrashmailIndexPage(driver);
        TrashmailAddressManagerPage trashmailAddressManagerPage = new TrashmailAddressManagerPage(driver);
        BookingIndexPage index = new BookingIndexPage(driver);
        BookingRegistrationPage registrationPage = new BookingRegistrationPage(driver);
        YandexLoginPage yandexLoginPage = new YandexLoginPage(driver);
        YandexMailPage yandexMailPage = new YandexMailPage(driver);
        YandexMailContеntPage yandexMailContеntPage = new YandexMailContеntPage(driver);

        Driver.getURL(bookingProperties.urlTrashmail);
        trashmailIndexPage.trashmailLogin(bookingProperties.userName, bookingProperties.trashmailPassword);
        TimeUnit.SECONDS.sleep(20);
        String newAddress = trashmailAddressManagerPage.createTrashmailAddress();
        Driver.getURL(bookingProperties.urlBooking);
        index.clickRegistration();
        TimeUnit.SECONDS.sleep(3);
        registrationPage.enterEmail(newAddress);
        TimeUnit.SECONDS.sleep(3);
        registrationPage.enterPassword(bookingProperties.bookingPassword);
        registrationPage.confirmPassword(bookingProperties.bookingPassword);
        TimeUnit.SECONDS.sleep(3);
        registrationPage.close();
        Driver.getURL(bookingProperties.urlYandex);
        yandexLoginPage.enterYandexMail(bookingProperties.yandexMail, bookingProperties.yandexPassword);
        TimeUnit.SECONDS.sleep(10);
        yandexMailPage.enterSpam();
        TimeUnit.SECONDS.sleep(15);
        yandexMailPage.findMailFromBooking();
        TimeUnit.SECONDS.sleep(5);
        yandexMailContеntPage.getLinks();
        yandexMailContеntPage.confirmBooking();
    }
}
