package settings;

import utilites.MyProperties;

import java.util.Properties;

public class BookingProperties {

    static Properties properties = MyProperties.getProperties("src/test/resources/booking.properties");
    public String urlTrashmail = properties.getProperty("URL_TRASHMAIL");
    public String userName = properties.getProperty("USER_NAME");
    public String trashmailPassword = properties.getProperty("TRASHMAIL_PASSWORD");
    public String urlYandex = properties.getProperty("URL_YANDEX");
    public String yandexMail = properties.getProperty("YANDEX_MAIL");
    public String yandexPassword = properties.getProperty("YANDEX_PASSWORD");
    public String bookingPassword = properties.getProperty("BOOKING_PASSWORD");
    public String urlBooking = properties.getProperty("URL_BOOKING");
}

