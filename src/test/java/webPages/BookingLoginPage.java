package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webDriver.BaseSteps;

import java.util.concurrent.TimeUnit;

public class BookingLoginPage {
public static  void login(WebDriver driver, String email, String password) throws InterruptedException {
        BaseSteps.findClick(driver,"//*[@id=\"current_account\"]");
        TimeUnit.SECONDS.sleep(3);
        BaseSteps.findSendKeysClick(driver,"//*[@id=\"username\"]", email);
        TimeUnit.SECONDS.sleep(3);
        BaseSteps.findSendKeysClick(driver,"//*[@id=\"password\"]", password);
    }
    public static boolean logoutLinkPresents(WebDriver driver){
        return driver.findElement(By.xpath("//*[@id=\"profile-menu\"]/form/input[5]")).isDisplayed();
    }
}
