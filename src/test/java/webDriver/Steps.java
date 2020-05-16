package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Steps {
    static Actions actions;
    public static WebElement findElement(WebDriver driver,String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    }
    public static void findSendKeysClick(WebDriver driver, String xpath, String text){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys(text);
        element.submit();
    }

    public static  void findSendKeys(WebDriver driver, String xpath, String text){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys(text);
    }

    public static void findClick(WebDriver driver,String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }
    public static WebElement elementFindClick(WebDriver driver,String xpath){
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        return element;
    }

    public static void findCity(WebDriver driver, String city){
        WebElement toCity=driver.findElement(By.xpath("//*[@id='ss']"));
        toCity.clear();
        toCity.sendKeys(city);
    }

    public static void checkPrice(WebDriver driver){
        actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Проверить цены')]")))
                .click(driver.findElement(By.xpath("//*[contains(text(),'Проверить цены')]"))).build().perform();
    }

    public static void enterAccaunt(WebDriver driver) throws InterruptedException {
        findClick(driver,"//*[@id=\"current_account\"]");
           }
    public static void wishlist(WebDriver driver) throws InterruptedException {
        enterAccaunt(driver);
        findClick(driver, "//*[contains(@href, \"https://www.booking.com/mywishlist.ru.html?l\")]");
    }
}
