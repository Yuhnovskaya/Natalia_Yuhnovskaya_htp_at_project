package other_stuff;


import settings.BookingProperties;
import web_driver.Config;
import web_driver.Driver;
import web_pages.TrashmailIndexPage;


public class TrashmailRegistration {
    public static void main(String[] avgs) throws InterruptedException {
        Driver.initDriver(Config.CHROME);
        TrashmailIndexPage trashmailIndexPage = new TrashmailIndexPage(Driver.getDriver());
        BookingProperties bookingProperties = new BookingProperties();
        Driver.getURL(bookingProperties.urlTrashmail);
        trashmailIndexPage.trashmailRegistration(bookingProperties.userName, bookingProperties.trashmailPassword, bookingProperties.yandexMail);
    }
}
