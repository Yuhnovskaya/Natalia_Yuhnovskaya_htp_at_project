package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingIndexPage {
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
        bookingCalendar.click();
    }

    public WebElement getAdultsCurrentNumber() {
        return adultsCurrentNumber;
    }

    public WebElement getChildrenCurrentNumber() {
        return childrenCurrentNumber;
    }

    public WebElement getRoomsCurrentNumber() {
        return roomsCurrentNumber;
    }

    public void checkPrice(WebDriver driver) {
        actions = new Actions(driver);
        actions.moveToElement(checkPrice).click(checkPrice).build().perform();
    }

    public void enterAccount() {
        account.click();
    }

    public void wishlist() {
        enterAccount();
        wishlist.click();
    }

    public void adultsRoomsChildren(WebDriver driver) {
        adultsRoomsChildren.click();
    }

    public void plusOneAdult() {
        plusAdults.click();
    }

    public void minusOneAdult() {
        minusAdults.click();
    }

    public void plusOneChild() {
        plusChild.click();
    }

    public void minusOneChild() {
        minusChild.click();
    }

    public void plusOneRoom() {
        plusRoom.click();
    }

    public void minusOneRoom() {
        minusRoom.click();
    }

    public void clickRegistration() {
        registration.click();
    }
}
