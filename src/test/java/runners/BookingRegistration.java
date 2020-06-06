package runners;

import org.openqa.selenium.WebDriver;
import steps.bookingTestSteps.TrashMailSteps;
import steps.bookingTestSteps.YandexSteps;
import webDriver.Prop;
import webDriver.Config;
import webDriver.DrManager;
import webPages.*;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BookingRegistration {
    public static void main(String[] avgs) throws InterruptedException {
        Properties prop = Prop.getProp();
        WebDriver driver = DrManager.getDriver(Config.CHROME);

        BookingIndexPage index = new BookingIndexPage(driver);
        TrashMailSteps trashMailSteps=new TrashMailSteps();
        BookingRegistrationPage registrationPage = new BookingRegistrationPage(driver);
        YandexSteps yandexSteps=new YandexSteps();
        YandexMailPage yandexMailPage=new YandexMailPage(driver);
        YandexMailContеntPage yandexMailContеntPage =new YandexMailContеntPage(driver);

        String newAddress = trashMailSteps.createTrashmailAddress(driver);
        driver.get(prop.getProperty("URL_BOOKING"));
        index.clickRegistration();
        TimeUnit.SECONDS.sleep(3);
        registrationPage.enterEmail(newAddress);
        TimeUnit.SECONDS.sleep(3);
        registrationPage.enterPassword(prop.getProperty("BOOKING_PSW"));
        registrationPage.confirmPassword(prop.getProperty("BOOKING_PSW"));
        TimeUnit.SECONDS.sleep(3);
        registrationPage.close();
        yandexSteps.enterYandexMail(driver);
        TimeUnit.SECONDS.sleep(10);
        yandexMailPage.enterSpam();
        TimeUnit.SECONDS.sleep(15);
        yandexMailPage.findMailFromBooking();
        TimeUnit.SECONDS.sleep(5);
        yandexMailContеntPage.getLinks();
        yandexMailContеntPage.confirmBooking();
    }
}
