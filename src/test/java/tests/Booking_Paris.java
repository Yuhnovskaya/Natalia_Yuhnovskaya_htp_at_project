package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Booking_Paris {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver=new ChromeDriver();
        driver.get ("https://www.booking.com/");
        WebElement city=driver.findElement(By.xpath("//*[@id='ss']"));
        city.sendKeys("Париж");

        driver.findElement(By.xpath("//div[@data-calendar2-title='Приезжаю']")).click();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 3);
        Date threeDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date tenDays = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePlusThreeDays = dateFormat.format(threeDays);
        String datePlusTenDays = dateFormat.format(tenDays);

        WebElement dateFrom=driver.findElement(By.xpath(String.format("//td[@data-date='%s']", datePlusThreeDays)));
        dateFrom.click();

        WebElement dateTo=driver.findElement(By.xpath(String.format("//td[@data-date='%s']", datePlusTenDays)));
        dateTo.click();

        driver.findElement(By.id("xp__guests__toggle")).click();

        WebElement adults=driver.findElement(By.xpath("//*[@aria-label='Взрослых: увеличить количество']/span"));
        adults.click();
        adults.click();

        WebElement rooms=driver.findElement(By.xpath("//*[@aria-label='Номера: увеличить количество']/span"));
        rooms.click();
        driver.findElement(By.xpath("//*[contains(text(),'Проверить цены')]")).click();

        Thread.sleep(3000);

        WebElement expensiveHotel=driver.findElement(By.xpath("//*[@id='filter_price']/div[2]/a[5]"));
        expensiveHotel.click();

        String exphot=expensiveHotel.getText();
        System.out.println(exphot);

        exphot=exphot.replaceAll("[^0-9]+","");
        int priceHotelDay=Integer.parseInt(exphot);
        System.out.println(priceHotelDay);

        Thread.sleep(3000);

        WebElement category=driver.findElement((By.xpath("//*[@id='sort_by']/ul/li[3]/a")));
        category.click();;

        Thread.sleep(3000);

        WebElement hotel=driver.findElement(By.xpath("//*[@id='hotellist_inner']//div[contains(@class,'bui-price-display__value')]"));
        exphot=hotel.getText();
        exphot=exphot.replaceAll("[^0-9]+","");
        int priceDay=Integer.parseInt(exphot);
        System.out.println(priceDay);

       Assert.assertTrue(priceDay>=priceHotelDay);
    }
}
//pullrequest