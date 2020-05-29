package webPages;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.bookingTestSteps.BookingSteps;

public class HotelsPage {
    static WebDriver driver;
    static Actions actions;
    private static final Logger LOGGER = LogManager.getLogger(HotelsPage.class);
    @FindBy(xpath = "//*[@id='filter_price']/div[2]/a[5]/label/div/span[1]")
    private WebElement expHotels;

    @FindBy(xpath = "//*[@id='filter_price']/div[2]/a[1]/label/div/span[1]")
    private WebElement cheapHotels;

    @FindBy(xpath = "//*[@id='sort_by']/ul/li[3]/a")
    private WebElement sort;

    @FindBy(xpath = "//*[@id='hotellist_inner']//div[contains(@class,'bui-price-display__value')]")
    private WebElement firstHotelPrice;

    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[1]/div[1]/div/button")
    private WebElement firstHeart;
    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[51]/div[1]/div/button")
    private WebElement lastHeart;
    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[1]//*[contains(@class,'bk-icon -iconset-heart sr-wl-entry-heart-svg')]")
    private WebElement firstHeartIcon;
    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[51]//*[contains(@class,'bk-icon -iconset-heart sr-wl-entry-heart-svg')]")
    private WebElement lastHeartIcon;
    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[1]//span[contains(@class, \"sr-hotel__name\")]")
    private WebElement firstHotelName;
    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[51]//span[contains(@class,\"sr-hotel__name\")]")
    private WebElement lastHotelName;
    @FindBy(xpath = "//p[@id=\"showMap2\"]")
    private WebElement address;

    public HotelsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement expensiveHotels() {
        LOGGER.debug("The method finds Webelement expHotels");
        return expHotels;
    }

    public WebElement cheapestHotels() {
        LOGGER.debug("The method finds Webelement cheapHotels");
        return cheapHotels;
    }

    public WebElement getFirstHotelPrice() {
        LOGGER.debug("The method finds Webelement firstHotelPrice");
        return firstHotelPrice;
    }

    public void SortExpensiveToCheap() {
        LOGGER.debug("The method clicks Webelement sort");
        sort.click();
    }

    public void firstHeartClick() {
        LOGGER.debug("The method clicks Webelement firstHeart");
        firstHeart.click();
    }

    public void lastHeartClick() {
        LOGGER.debug("The method clicks Webelement lastHeart");
        lastHeart.click();
    }

    public WebElement getFirstHeartIcon() {
        LOGGER.debug("The method clicks Webelement firstHeartIcon");
        return firstHeartIcon;
    }

    public WebElement getLastHeartIcon() {
        LOGGER.debug("The method clicks Webelement lastHeartIcon");
        return lastHeartIcon;
    }

    public String getFistHotelName() {
        LOGGER.debug("The method returns text in Webelement firstHotelName");
        String firstHotName = firstHotelName.getText();
        return firstHotName;
    }

    public String getFistlastName() {
        LOGGER.debug("The method returns text in Webelement lastHotelName");
        String lastHotName = lastHotelName.getText();
        return lastHotName;
    }

    public WebElement getAddress() {
        LOGGER.debug("The method finds Webelement address");
        return address;
    }
}

