package webPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelsPage {
    static WebDriver driver;
    static Actions actions;

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
    @FindBy(xpath ="//*[@id=\"hotellist_inner\"]/div[1]//span[contains(@class, \"sr-hotel__name\")]")
            private WebElement firstHotelName;
    @FindBy(xpath = "//*[@id=\"hotellist_inner\"]/div[51]//span[contains(@class,\"sr-hotel__name\")]")
    private WebElement lastHotelName;
    @FindBy(xpath = "//p[@id=\"showMap2\"]")
    private WebElement address;

    public HotelsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public WebElement expensiveHotels() {
        return expHotels;
    }
    public WebElement cheapestHotels() {
        return cheapHotels;
    }
    public WebElement getFirstHotelPrice() {
        return firstHotelPrice;
    }
    public void SortExpensiveToCheap() {
        sort.click();
    }
    public void firstHeartClick(){
       firstHeart.click();
    }
    public void lastHeartClick(){
        lastHeart.click();
    }
    public WebElement getFirstHeartIcon(){
        return firstHeartIcon;
    }
    public WebElement getLastHeartIcon(){
        return lastHeartIcon;
    }
    public String getFistHotelName(){
        String firstHotName=firstHotelName.getText();
        return firstHotName;
    }
    public String getFistlastName(){
        String lastHotName=lastHotelName.getText();
        return lastHotName;
    }
    public WebElement getAddress(){
      return  address;
    }
}

