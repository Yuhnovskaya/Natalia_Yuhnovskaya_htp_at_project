package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webDriver.DrManager;
import webDriver.Steps;

import java.util.concurrent.TimeUnit;

public class loginPage {
public static  void login(WebDriver driver, String email, String password) throws InterruptedException {
        Steps.findClick(driver,"//*[@id=\"current_account\"]");
        TimeUnit.SECONDS.sleep(3);
        Steps.findSendKeysClick(driver,"//*[@id=\"username\"]", email);
        TimeUnit.SECONDS.sleep(3);
        Steps.findSendKeysClick(driver,"//*[@id=\"password\"]", password);
    }
    public static boolean logoutLinkPresents(WebDriver driver){
        return driver.findElement(By.xpath("//*[@id=\"profile-menu\"]/form/input[5]")).isDisplayed();
    }
}
