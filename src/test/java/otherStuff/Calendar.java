package otherStuff;

import org.hamcrest.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webDriver.Steps;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar {
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
        Steps.findClick(driver, String.format("//td[@data-date='%s']", From));
        Steps.findClick(driver, String.format("//td[@data-date='%s']", Until));
    }
}
