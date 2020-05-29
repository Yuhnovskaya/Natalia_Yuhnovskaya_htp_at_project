package webPages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.bookingTestSteps.BookingSteps;

public class BookingIndexPage {
    private static final Logger LOGGER = LogManager.getLogger(BookingIndexPage.class);
    static Actions actions;

    @FindBy(xpath = "//*[@id='ss']")
    private WebElement toCity;

    @FindBy(xpath = "//*[contains(text(),'Проверить цены')]")
    private WebElement checkPrice;

    @FindBy(xpath = "//*[@id=\"current_account\"]")
    private WebElement account;

    @FindBy(xpath = "//*[contains(@href, \"https://www.booking.com/mywishlist.ru.html?l\")]")
    private WebElement wishlist;

    @FindBy(xpath = "//*[@id=\"xp__guests__toggle\"]")
    private WebElement adultsRoomsChildren;

    @FindBy(xpath = "//*[@aria-label='Взрослых: увеличить количество']/span")
    private WebElement plusAdults;

    @FindBy(xpath = "//*[@aria-label='Взрослых: уменьшить количество']/span")
    private WebElement minusAdults;

    @FindBy(xpath = "//*[@aria-label='Детей: увеличить количество']/span")
    private WebElement plusChild;

    @FindBy(xpath = "//*[@aria-label='Детей: уменьшить количество']/span")
    private WebElement minusChild;

    @FindBy(xpath = "//*[@aria-label='Номера: увеличить количество']/span")
    private WebElement plusRoom;

    @FindBy(xpath = "//*[@aria-label='Номера: уменьшить количество']/span")
    private WebElement minusRoom;

    @FindBy(xpath = "(//*[@class=\"sign_in_wrapper\"])[1]")
    private WebElement registration;

    @FindBy(xpath = "//*[@id=\"group_adults\"]")
    private WebElement adultsCurrentNumber;

    @FindBy(xpath = "//*[@id=\"group_children\"]")
    private WebElement childrenCurrentNumber;

    @FindBy(xpath = "//*[@id=\"no_rooms\"]")
    private WebElement roomsCurrentNumber;

    @FindBy(xpath = "//div[@data-calendar2-title='Приезжаю']")
    private WebElement bookingCalendar;

   public BookingIndexPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void findCity(String city) {
      toCity.clear();
        toCity.sendKeys(city);
    }

    public void choseDates() {
        LOGGER.debug("The method clicks Webelement 'bookingCalendar'");
        bookingCalendar.click();
    }

    public WebElement getAdultsCurrentNumber() {
        LOGGER.debug("The method returns currrent number of addults");
        return adultsCurrentNumber;
    }

    public WebElement getChildrenCurrentNumber() {
        LOGGER.debug("The method returns current number of children");
        return childrenCurrentNumber;
    }

    public WebElement getRoomsCurrentNumber() {
        LOGGER.debug("The method returns current number of rooms");
        return roomsCurrentNumber;
    }

    public void checkPrice(WebDriver driver) {
        LOGGER.debug("The method clicks checkPrice button");
        actions = new Actions(driver);
        actions.moveToElement(checkPrice).click(checkPrice).build().perform();
    }

    public void enterAccount() {
        LOGGER.debug("The method clicks account button");
        account.click();
    }

    public void wishlist() {
        LOGGER.debug("The method clicks wishlist link");
        enterAccount();
        wishlist.click();
    }

    public void adultsRoomsChildren(WebDriver driver) {
        adultsRoomsChildren.click();
    }

    public void plusOneAdult() {
        LOGGER.debug("The method adds 1 adult");
        plusAdults.click();
    }

    public void minusOneAdult() {
        LOGGER.debug("The method delete 1 adult");
        minusAdults.click();
    }

    public void plusOneChild() {
        LOGGER.debug("The method adds 1 children");
        plusChild.click();
    }

    public void minusOneChild() {
        LOGGER.debug("The method delete 1 children");
        minusChild.click();
    }

    public void plusOneRoom() {
        LOGGER.debug("The method adds 1 room");
        plusRoom.click();
    }

    public void minusOneRoom() {
        LOGGER.debug("The method delete 1 room");
        minusRoom.click();
    }

    public void clickRegistration() {
        LOGGER.debug("The method clicks registration button");
        registration.click();
    }
}
