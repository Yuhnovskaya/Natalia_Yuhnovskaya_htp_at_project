package otherStuff;

import org.openqa.selenium.WebDriver;
import webDriver.Steps;

import java.util.concurrent.TimeUnit;

public class LoginBooking {
    public static void login(WebDriver driver, String email, String password) throws InterruptedException {
        Steps.findClick(driver,"//*[@id=\"current_account\"]");
        TimeUnit.SECONDS.sleep(3);
        Steps.findSendKeysClick(driver,"//*[@id=\"username\"]", email);
        TimeUnit.SECONDS.sleep(3);
        Steps.findSendKeysClick(driver,"//*[@id=\"password\"]", password);
    }
}
