package web_pages;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.StringToDigitsConverter;
import web_driver.Driver;

public class HotelsPage {

    private static final Logger LOGGER = LogManager.getLogger(HotelsPage.class);
    private static final String FIRST_HOTEL = "//*[contains(text(),'%s')]";
    private static final String LAST_HOTEL = "//*[contains(text(),'%s')]";
    private static final String TARGET_HOTEL="//*[@id='hotellist_inner']/div[%s]//h3[contains(@class, 'sr-hotel__title')]";
    @FindBy(xpath = "//*[@id='filter_price']/div[2]/a[5]/label/div/span[1]")
    private WebElement expHotels;

    @FindBy(xpath = "//*[@id=\"filter_price\"]/div[2]/a[1]/label/div/span[1]")
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

    Actions actions;

    public HotelsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
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
        sort.click();
        LOGGER.debug("The method clicks Webelement sort");
    }

    public void firstHeartClick() {
        firstHeart.click();
        LOGGER.debug("The method clicks Webelement firstHeart");
    }

    public void lastHeartClick() {
        lastHeart.click();
        LOGGER.debug("The method clicks Webelement lastHeart");
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
        String firstHotName = firstHotelName.getText();
        LOGGER.debug("The method returns text in Webelement firstHotelName");
        return firstHotName;
    }

    public String getFistlastName() {
        String lastHotName = lastHotelName.getText();
        LOGGER.debug("The method returns text in Webelement lastHotelName");
        return lastHotName;
    }

    public WebElement getAddress() {
        LOGGER.debug("The method finds Webelement address");
        return address;
    }

    public static int getFilterPrice(WebElement hotel) {
        String priceHot = hotel.getText();
        int price = StringToDigitsConverter.converterStringToDigit(priceHot);
        LOGGER.debug("The method returns price of the hotel");
        return price;
    }

    public int getMaxPrice() {
        int maxPrice = getFilterPrice(expensiveHotels());
        LOGGER.debug("The method returns price of the most expensive hotel");
        return maxPrice;
    }

    public int getMinPrice() {
        int minPrice = getFilterPrice(cheapestHotels());
        LOGGER.debug("The method returns price of the most cheapest hotel");
        return minPrice;
    }

    public int priceOfTheFirstHotelOnTheList() {
        WebElement hotel = getFirstHotelPrice();
        String priceHot = hotel.getText();
        int price = StringToDigitsConverter.converterStringToDigit(priceHot);
        LOGGER.debug("The method returns price of the first hotel of the list");
        return price;
    }

    public void filterHotelClass(int hotelClass) {
        String hotClass = Integer.toString(hotelClass);
        actions.click(Driver.getDriver().findElement(By.xpath(String.format("//*[@data-id='class-%s']", hotClass)))).build().perform();
        LOGGER.debug("The method searches for the hotels of the class "+hotelClass);
    }

    public void scrollToTheHotel(int hotelNumber) {
        String hotNumber = Integer.toString(hotelNumber);
        WebElement tenthhot = Driver.getDriver().findElement(By.xpath(String.format(TARGET_HOTEL, hotNumber)));
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true)", tenthhot);
        tenthhot.click();
        LOGGER.debug("The method scrolls to the hotel number "+hotelNumber);
    }

    public WebElement firstHotelName(String name) {
        LOGGER.debug("The method returns name of the first hotel of the list");
        return Driver.getDriver().findElement(By.xpath(String.format(FIRST_HOTEL, name)));
    }

    public WebElement lastHotelName(String name) {
        LOGGER.debug("The method returns name of the last hotel of the list");
        return Driver.getDriver().findElement(By.xpath(String.format(LAST_HOTEL, name)));
    }
}


