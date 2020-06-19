package web_pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test_objects.booking_test_objects.BookingTestCase;
import web_driver.Driver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingIndexPage {
    private static final Logger LOGGER = LogManager.getLogger(BookingIndexPage.class);
    private static final String DATE = "//td[@data-date='%s']";
    private static final int CURRENT_ADULTS = 2;
    private static final int CURRENT_CHILDREN = 0;
    private static final int CURRENT_ROOMS = 1;

    @FindBy(xpath = "//*[@id='ss']")
    private WebElement toCity;

    @FindBy(xpath = "//*[contains(text(),'Проверить цены')]")
    private WebElement checkPrice;

    @FindBy(xpath = "//*[@id=\"current_account\"]")
    private WebElement account;

    @FindBy(xpath = "//*[contains(@href, 'https://www.booking.com/mywishlist.ru.html?l')]")
    private WebElement wishlist;

    @FindBy(xpath = "//*[@id='xp__guests__toggle']")
    private WebElement adultsRoomsChildren;

    @FindBy(xpath = "//*[@aria-label='Взрослых: увеличить количество']/span")
    private WebElement plusAdults;

    @FindBy(xpath = "//*[@aria-label='Взрослых: уменьшить количество']/span")
    private WebElement minusAdults;

    @FindBy(xpath = "//*[@aria-label='Детей: увеличить количество']/span")
    private WebElement plusChild;

    @FindBy(xpath = "//*[@aria-label='Номера: увеличить количество']/span")
    private WebElement plusRoom;

    @FindBy(xpath = "(//*[@class=\"sign_in_wrapper\"])[1]")
    private WebElement registration;

    @FindBy(xpath = "//div[@data-calendar2-title='Приезжаю']")
    private WebElement bookingCalendar;

    Actions actions;

    public BookingIndexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    public void findCity(String city) {
        toCity.clear();
        toCity.sendKeys(city);
    }

    public void checkPrice() {
        actions.moveToElement(checkPrice).click(checkPrice).build().perform();
        LOGGER.debug("The method clicks checkPrice button");
    }

    public void wishlist() {
        account.click();
        wishlist.click();
        LOGGER.debug("The method clicks wishlist link");
    }

    public void clickRegistration() {
        registration.click();
        LOGGER.debug("The method clicks registration button");
    }

    public void enterAccount() {
        account.click();
        LOGGER.debug("The method clicks Webelement 'accounr'");
    }

    public void plusAdult(int number) {
        for (int i = 0; i < number; i++) {
            plusAdults.click();
        }
        LOGGER.debug("The method adds one adult");

    }

    public void minusAdults(int number) {
        if (number == 1) {
            minusAdults.click();
        }
        LOGGER.debug("The method deletes one adult");

    }

    public void plusChild(int number) {
        for (int i = 0; i < number; i++) {
            plusChild.click();
        }
        LOGGER.debug("The method adds one child");
    }

    public void plusRoom(int number) {
        for (int i = 0; i < number; i++) {
            plusRoom.click();
        }
        LOGGER.debug("The method adds one room");
    }

    public void getDatesInUntil(int dateIn, int dateUntil) throws InterruptedException {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.add(java.util.Calendar.DAY_OF_YEAR, dateIn);
        Date InDate = calendar.getTime();
        calendar.add(java.util.Calendar.DAY_OF_YEAR, dateUntil);
        Date UntilDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String in = dateFormat.format(InDate);
        String until = dateFormat.format(UntilDate);
        bookingCalendar.click();
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath(String.format(DATE, in))).click();
        Driver.getDriver().findElement(By.xpath(String.format(DATE, until))).click();
        LOGGER.debug("The method choses arrival and departure dates");
    }

    public void hotelSearch(BookingTestCase bookingTestCase) throws InterruptedException {
        findCity(bookingTestCase.getCity());
        getDatesInUntil(bookingTestCase.getDaysIn(), bookingTestCase.getDaysFor());
        adultsRoomsChildren.click();
        if (bookingTestCase.getAdultsNumber() > CURRENT_ADULTS) {
            plusAdult(bookingTestCase.getAdultsNumber() - CURRENT_ADULTS);
        }
        if (bookingTestCase.getAdultsNumber() < CURRENT_ADULTS) {
            minusAdults(CURRENT_ADULTS - bookingTestCase.getAdultsNumber());
        }
        if (bookingTestCase.getChildrenNumber() > CURRENT_CHILDREN) {
            plusChild(bookingTestCase.getChildrenNumber() - CURRENT_CHILDREN);
        }
        if (bookingTestCase.getRoomsNumber() > CURRENT_ROOMS) {
            plusRoom(bookingTestCase.getRoomsNumber() - CURRENT_ROOMS);
        }
        LOGGER.debug("The method completes registration form");
    }
}
