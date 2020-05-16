package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Booking_Moscow {
    static WebDriver driver;
   public static void main(String[] avgs) throws InterruptedException {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver= new ChromeDriver();
        driver.get ("https://www.booking.com/");
        WebElement city=driver.findElement(By.xpath("//*[@id='ss']"));
        city.sendKeys("Москва");

        driver.findElement(By.xpath("//div[@data-calendar2-title='Приезжаю']")).click();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        Date threeDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date tenDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays = dateFormat.format(threeDays);
        String datePlusTenDays = dateFormat.format(tenDays);

        WebElement dateFrom=driver.findElement(By.xpath(String.format("//td[@data-date='%s']", datePlusThreeDays)));
        dateFrom.click();

        WebElement dateTo=driver.findElement(By.xpath(String.format("//td[@data-date='%s']", datePlusTenDays)));
        dateTo.click();

        driver.findElement(By.id("xp__guests__toggle")).click();
        Actions actions=new Actions(driver);
        actions.doubleClick(driver.findElement(By.xpath("//*[@aria-label='Взрослых: увеличить количество']/span"))).build().perform();;
        actions.click(driver.findElement(By.xpath("//*[@aria-label='Номера: увеличить количество']/span"))).build().perform();

        actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Проверить цены')]")))
                .click(driver.findElement(By.xpath("//*[contains(text(),'Проверить цены')]"))).build().perform();

        Thread.sleep(3000);

        WebElement cheapHotel=driver.findElement(By.xpath("//*[@id='filter_price']/div[2]/a[1]"));
        cheapHotel.click();

        String cheaphot=cheapHotel.getText();
        System.out.println(cheaphot);

        cheaphot=cheaphot.replaceAll("[^0-9]+","");
        int maxPriceHotelDay=Integer.parseInt(cheaphot);
        System.out.println(maxPriceHotelDay);

        Thread.sleep(3000);

        WebElement category=driver.findElement((By.xpath("//*[@id='sort_by']/ul/li[3]/a")));
        category.click();;

        Thread.sleep(4000);

        WebElement hotel=driver.findElement(By.xpath("//*[@id='hotellist_inner']//div[contains(@class,'bui-price-display__value')]"));
        cheaphot=hotel.getText();
        cheaphot=cheaphot.replaceAll("[^0-9]+","");
        int minPriceDay=Integer.parseInt(cheaphot);
        System.out.println(minPriceDay);

      Assert.assertTrue(minPriceDay<=maxPriceHotelDay);
    }
}
//pullrequest