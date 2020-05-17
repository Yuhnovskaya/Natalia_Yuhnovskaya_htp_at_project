package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Date;

import static webDriver.BaseSteps.findClick;

public class BookingIndexPage {
    static Actions actions;
    public static void findCity(WebDriver driver, String city){
        WebElement toCity=driver.findElement(By.xpath("//*[@id='ss']"));
        toCity.clear();
        toCity.sendKeys(city);
    }

    public static void getDatesInUntil(WebDriver driver, int dateIn, int dateUntil){
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.add(java.util.Calendar.DAY_OF_YEAR, dateIn);
        Date InDate = calendar.getTime();
        calendar.add(java.util.Calendar.DAY_OF_YEAR, dateUntil);
        Date UntilDate = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String From = dateFormat.format(InDate);
        String Until = dateFormat.format(UntilDate);
        driver.findElement(By.xpath("//div[@data-calendar2-title='Приезжаю']")).click();
        findClick(driver, String.format("//td[@data-date='%s']", From));
        findClick(driver, String.format("//td[@data-date='%s']", Until));
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
