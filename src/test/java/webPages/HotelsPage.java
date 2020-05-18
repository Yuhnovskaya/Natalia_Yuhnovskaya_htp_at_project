package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webDriver.BaseSteps;

public class HotelsPage {
    static WebDriver driver;
    static Actions actions;
   // public static WebElement ExpensiveHotels=driver.findElement(By.xpath("//*[@id='filter_price']/div[2]/a[5]"));
  //  public static  WebElement CheapestHotels=driver.findElement(By.xpath("//*[@id='filter_price']/div[2]/a[1]"));

    public static void ExpensiveHotelsFilter(WebDriver driver) throws InterruptedException {
        BaseSteps.findClick(driver,("//*[@id='filter_price']/div[2]/a[5]"));
    }
    public static void cheapestHotelsFilter(WebDriver driver){
        BaseSteps.findClick(driver,("//*[@id='filter_price']/div[2]/a[1]"));
    }
    public static int getFilterPrice(WebDriver driver, String xpath){
        WebElement hotel=BaseSteps.findElement(driver, xpath);
        String priceHot=hotel.getText();
        int price=BaseSteps.converterStringToDigit(priceHot);
        return price;
    }
    public static int getMaxPrice(WebDriver driver){
        int maxPrice=getFilterPrice(driver, "//*[@id='filter_price']/div[2]/a[5]");
        return maxPrice;
    }
    public static int getMinPrice(WebDriver driver){
        int minPrice=getFilterPrice(driver, "//*[@id='filter_price']/div[2]/a[1]");
        return minPrice;
    }
    public static void SortExpensiveToCheap(WebDriver driver){
        BaseSteps.elementFindClick(driver,"//*[@id='sort_by']/ul/li[3]/a");
    }
    public static int priceOfTheFirstHotelOnTheList(WebDriver driver){
        WebElement hotel=driver.findElement(By.xpath("//*[@id='hotellist_inner']//div[contains(@class,'bui-price-display__value')]"));
        String priceHot=hotel.getText();
        int price=BaseSteps.converterStringToDigit(priceHot);
        return price;
    }
    public static void filterHotelClass(WebDriver driver,int hotelClass){
        actions=new Actions(driver);
        String hotClass=Integer.toString(hotelClass);
        actions.click(driver.findElement(By.xpath(String.format("//*[@data-id='class-%s']", hotClass)))).build().perform();
    }
    public static void scrollToTheHotel(WebDriver driver, int hotelNumber){
        String hotNumber=Integer.toString(hotelNumber);
        WebElement tenthhot=driver.findElement(By.xpath(String.format("//*[@id='hotellist_inner']/div[%s]//h3[contains(@class, 'sr-hotel__title')]",hotNumber)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",tenthhot);
        tenthhot.click();
    }
}
