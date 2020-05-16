package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Booking_Oslo {
    static WebDriver driver;
    public static void main(String[] avgs) throws InterruptedException {
        System.setProperty("webdriver.chrome.silentOutput", "true");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver=new ChromeDriver();
        driver.get ("https://www.booking.com/");
        WebElement city=driver.findElement(By.xpath("//*[@id=\"ss\"]"));
        city.sendKeys("Осло");

        driver.findElement(By.xpath("//div[@data-calendar2-title='Приезжаю']")).click();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date threeDays = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
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
        actions.click(driver.findElement(By.xpath("//*[@aria-label='Детей: увеличить количество']/span"))).build().perform();

        actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Проверить цены')]")))
                .click(driver.findElement(By.xpath("//*[contains(text(),'Проверить цены')]"))).build().perform();

        Thread.sleep(1000);

        actions.click(driver.findElement(By.xpath("//*[@data-id='class-3']"))).build().perform();
        Thread.sleep(1000);
        actions.click(driver.findElement(By.xpath("//*[@data-id='class-4']"))).build().perform();

        Thread.sleep(3000);

        WebElement tenthhot=driver.findElement(By.xpath("//*[@id='hotellist_inner']/div[11]//h3[contains(@class, 'sr-hotel__title')]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",tenthhot);
        tenthhot.click();

       Thread.sleep(50000);

        //driver.get ("https://www.booking.com/hotel/no/forenom-apartments-city-hall.ru.html?aid=397643;label=yan104jc-1FCAEoggI46AdIM1gDaCWIAQGYASG4ARfIAQzYAQHoAQH4AQmIAgGoAgO4AsPKyfUFwAIB;dest_id=-273837;dest_type=city;dist=0;group_adults=2;group_children=0;hapos=10;hpos=10;nflt=class%3D2%3Bclass%3D3%3B;no_rooms=1;room1=A%2CA;sb_price_type=total;sr_order=popularity;srepoch=1588749648;srpvid=bc8133a748680023;type=total;ucfs=1&#hotelTmpl");
        //Actions actions=new Actions(driver);

        WebElement address=driver.findElement(By.xpath("//*[@id='showMap2']/span[1]"));
        actions.moveToElement(address).build().perform();

        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor='green'", address);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color='red'", address);

        Assert.assertEquals("rgba(255, 0, 0, 1)", (address.getCssValue("color")));
    }
}
//pullrequest