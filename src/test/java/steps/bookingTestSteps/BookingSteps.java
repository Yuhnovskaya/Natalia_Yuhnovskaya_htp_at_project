package steps.bookingTestSteps;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testObject.BookingTestObjects.BookingTestCase;
import webPages.BookingIndexPage;
import webPages.BookingLoginPage;
import webPages.HotelsPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static steps.bookingTestSteps.BaseSteps.findClick;

public class BookingSteps {
    private static final Logger LOGGER = LogManager.getLogger(BookingSteps.class);
    static Actions actions;
    public void login(WebDriver driver, String email, String password) throws InterruptedException {
        BookingIndexPage bookingIndexPage=new BookingIndexPage(driver);
        BookingLoginPage bookingLoginPage=new BookingLoginPage(driver);
        bookingIndexPage.enterAccount();
        TimeUnit.SECONDS.sleep(3);
        bookingLoginPage.enterUsername(email);
        TimeUnit.SECONDS.sleep(3);
        bookingLoginPage.enterPassword(password);
        bookingLoginPage.passwordClick();
    }

    public static void getDatesFromUntil(WebDriver driver, int dateIn, int dateUntil) {
        BookingIndexPage bookingIndexPage=new BookingIndexPage(driver);
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.add(java.util.Calendar.DAY_OF_YEAR, dateIn);
        Date InDate = calendar.getTime();
        calendar.add(java.util.Calendar.DAY_OF_YEAR, dateUntil);
        Date UntilDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String From = dateFormat.format(InDate);
        String Until = dateFormat.format(UntilDate);
        bookingIndexPage.choseDates();
        findClick(driver, String.format("//td[@data-date='%s']", From));
        findClick(driver, String.format("//td[@data-date='%s']", Until));
    }

    public void plusAdult(WebDriver driver, int number) {
        BookingIndexPage bookingIndexPage=new BookingIndexPage(driver);
        for (int i = 0; i < number; i++) {
            bookingIndexPage.plusOneAdult();
        }
    }

    public void minusAdults(WebDriver driver, int number) {
        BookingIndexPage bookingIndexPage=new BookingIndexPage(driver);
        for (int i = 0; i < number; i++) {
            bookingIndexPage.minusOneAdult();
        }
    }

    public void plusChild(WebDriver driver, int number) {
        BookingIndexPage bookingIndexPage=new BookingIndexPage(driver);
        for (int i = 0; i < number; i++) {
            bookingIndexPage.plusOneChild();;
        }
    }

    public void minusChild(WebDriver driver, int number) {
        BookingIndexPage bookingIndexPage=new BookingIndexPage(driver);
        for (int i = 0; i < number; i++) {
            bookingIndexPage.minusOneChild();;
        }
    }

    public void plusRoom(WebDriver driver, int number) {
        BookingIndexPage bookingIndexPage=new BookingIndexPage(driver);
        for (int i = 0; i < number; i++) {
            bookingIndexPage.plusOneRoom();
        }
    }

    public void minusRoom(WebDriver driver, int number) { BookingIndexPage bookingIndexPage=new BookingIndexPage(driver);

        for (int i = 0; i < number; i++) {
            bookingIndexPage.minusOneRoom();
        }
    }

    public void hotelSearch(WebDriver driver, BookingTestCase bookingTestCase) {
        BookingIndexPage bookingIndexPage=new BookingIndexPage(driver);
        bookingIndexPage.findCity(bookingTestCase.getCity());
        getDatesFromUntil(driver, bookingTestCase.getDaysIn(), bookingTestCase.getDaysFor());
        bookingIndexPage.adultsRoomsChildren(driver);
        int currentValueAdults = Integer.valueOf(bookingIndexPage.getAdultsCurrentNumber().getAttribute("value"));
        if (bookingTestCase.getAdultsNumber() > currentValueAdults) {
            plusAdult(driver, bookingTestCase.getAdultsNumber() - currentValueAdults);
        }
        if (bookingTestCase.getAdultsNumber() < currentValueAdults) {
            minusAdults(driver, currentValueAdults - bookingTestCase.getAdultsNumber());
        }
        int currentValueChildren = Integer.valueOf(bookingIndexPage.getChildrenCurrentNumber().getAttribute("value"));
        if (bookingTestCase.getChildrenNumber() > currentValueChildren) {
            plusChild(driver, bookingTestCase.getChildrenNumber() - currentValueChildren);
        }
        if (bookingTestCase.getChildrenNumber() < currentValueChildren) {
            minusChild(driver, currentValueChildren - bookingTestCase.getChildrenNumber());
        }
        int currentValueRooms = Integer.valueOf(bookingIndexPage.getRoomsCurrentNumber().getAttribute("value"));
        if (bookingTestCase.getRoomsNumber() > currentValueRooms) {
            plusRoom(driver, bookingTestCase.getRoomsNumber() - currentValueRooms);
        }
        if (bookingTestCase.getRoomsNumber() < currentValueRooms) {
            minusRoom(driver, currentValueRooms - bookingTestCase.getRoomsNumber());
        }
        bookingIndexPage.checkPrice(driver);
    }

    public static int getFilterPrice(WebElement hotel) {
        //  WebElement hotel = BaseSteps.findElement(driver, xpath);
        String priceHot = hotel.getText();
        int price = BaseSteps.converterStringToDigit(priceHot);
        return price;
    }

    public int getMaxPrice(WebDriver driver) {
        HotelsPage hotelsPage=new HotelsPage(driver);
        int maxPrice = getFilterPrice(hotelsPage.expensiveHotels());
        return maxPrice;
    }

    public int getMinPrice(WebDriver driver) {
        HotelsPage hotelsPage=new HotelsPage(driver);
        int minPrice = getFilterPrice(hotelsPage.cheapestHotels());
        return minPrice;
    }

    public int priceOfTheFirstHotelOnTheList(WebDriver driver) {
        HotelsPage hotelsPage=new HotelsPage(driver);
        WebElement hotel = hotelsPage.getFirstHotelPrice();
        String priceHot = hotel.getText();
        int price = BaseSteps.converterStringToDigit(priceHot);
        return price;
    }

    public static void filterHotelClass(WebDriver driver, int hotelClass) {
        actions = new Actions(driver);
        String hotClass = Integer.toString(hotelClass);
        actions.click(driver.findElement(By.xpath(String.format("//*[@data-id='class-%s']", hotClass)))).build().perform();
    }

    public static void scrollToTheHotel(WebDriver driver, int hotelNumber) {
        String hotNumber = Integer.toString(hotelNumber);
        WebElement tenthhot = driver.findElement(By.xpath(String.format("//*[@id='hotellist_inner']/div[%s]//h3[contains(@class, 'sr-hotel__title')]", hotNumber)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", tenthhot);
        tenthhot.click();
    }
}
