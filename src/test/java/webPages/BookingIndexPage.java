package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webDriver.BaseSteps;

import java.text.SimpleDateFormat;
import java.util.Date;

import static webDriver.BaseSteps.findClick;

public class BookingIndexPage {
    static Actions actions;

    public static void findCity(WebDriver driver, String city) {
        WebElement toCity = driver.findElement(By.xpath("//*[@id='ss']"));
        toCity.clear();
        toCity.sendKeys(city);
    }

    public static void getDatesFromUntil(WebDriver driver, int dateIn, int dateUntil) {
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

    public static void checkPrice(WebDriver driver) {
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Проверить цены')]")))
                .click(driver.findElement(By.xpath("//*[contains(text(),'Проверить цены')]"))).build().perform();
    }

    public static void enterAccaunt(WebDriver driver) throws InterruptedException {
        findClick(driver, "//*[@id=\"current_account\"]");
    }

    public static void wishlist(WebDriver driver) throws InterruptedException {
        enterAccaunt(driver);
        findClick(driver, "//*[contains(@href, \"https://www.booking.com/mywishlist.ru.html?l\")]");
    }

    public static void adultsRoomsChildren(WebDriver driver) {
        BaseSteps.findClick(driver, "//*[@id=\"xp__guests__toggle\"]");
    }

    public static void plusAdult(WebDriver driver, int number) {
        WebElement adults = driver.findElement(By.xpath("//*[@aria-label='Взрослых: увеличить количество']/span"));
        for (int i = 0; i < number; i++) {
            adults.click();
        }
    }
    public static void minusAdults(WebDriver driver, int number) {
        WebElement adults = driver.findElement(By.xpath("//*[@aria-label='Взрослых: уменьшить количество']/span"));
        adults.click();
    }

    public static void plusChildren(WebDriver driver, int number) {
        WebElement children = driver.findElement(By.xpath("//*[@aria-label='Детей: увеличить количество']/span"));
        for (int i = 0; i < number; i++) {
            children.click();
        }
    }
    public static void minusChildren(WebDriver driver, int number) {
        WebElement children = driver.findElement(By.xpath("//*[@aria-label='Детей: уменьшить количество']/span"));
        for (int i = 0; i < number; i++) {
            children.click();
        }
    }

    public static void plusRoom(WebDriver driver, int number) {
        WebElement rooms = driver.findElement(By.xpath("//*[@aria-label='Номера: увеличить количество']/span"));
        for (int i = 0; i < number; i++) {
            rooms.click();
        }
    }
    public static void minusRoom(WebDriver driver, int number) {
        WebElement rooms = driver.findElement(By.xpath("//*[@aria-label='Номера: уменьшить количество']/span"));
        for (int i = 0; i < number; i++) {
            rooms.click();
        }
    }
    public static void hotelSearch(WebDriver driver, String city, int DaysIn, int DaysFor, int adultsNumber, int childrenNumber, int roomNumber) {
        findCity(driver, city);
        getDatesFromUntil(driver, DaysIn, DaysFor);
        adultsRoomsChildren(driver);
        int currentValueAdults=Integer.valueOf(BaseSteps.findElement(driver,"//*[@id=\"group_adults\"]").getAttribute("value"));
        System.out.print(currentValueAdults);
        if (adultsNumber >currentValueAdults) {
            plusAdult(driver, adultsNumber-currentValueAdults);
        }
        if (adultsNumber <currentValueAdults) {
            minusAdults(driver, currentValueAdults-adultsNumber);
        }
        int currentValueChildren=Integer.valueOf(BaseSteps.findElement(driver,"//*[@id=\"group_children\"]").getAttribute("value"));
        if (childrenNumber > currentValueChildren) {
            plusChildren(driver, childrenNumber-currentValueChildren);
        }
        if (childrenNumber<currentValueChildren){
            minusChildren(driver,currentValueChildren-childrenNumber);
        }
        int currentValueRooms=Integer.valueOf(BaseSteps.findElement(driver,"//*[@id=\"no_rooms\"]").getAttribute("value"));
        if (roomNumber >currentValueRooms) {
            plusRoom(driver, roomNumber-currentValueRooms);
        }
        if (roomNumber<currentValueRooms){
            minusRoom(driver,currentValueRooms-roomNumber);
        }
        checkPrice(driver);
    }
}
