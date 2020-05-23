package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webDriver.BaseSteps;

import java.util.concurrent.TimeUnit;

public class TrashmailAddressManagerPage {
    public static String createTrashmailAddress(WebDriver driver) throws InterruptedException {
        TrashmailIndexPage.TrashmailLogin(driver);
        TimeUnit.SECONDS.sleep(20);
        BaseSteps.findClick(driver,"//*[@id=\"fe-add-btnIconEl\"]");
        TimeUnit.SECONDS.sleep(5);
        BaseSteps.findClick(driver,"//*[@id=\"fe-save-btnEl\"]");
        String name=driver.findElement(By.xpath("//*[contains(@class,'disposable-name')]/div")).getText();
        String domain=driver.findElement(By.xpath("//*[contains(@class,'disposable-domain')]/div")).getText();
        String trashmailAdress=name+domain;
        return trashmailAdress;
    }

    public static String getTrashmailAddress(WebDriver driver) throws InterruptedException {
    TrashmailIndexPage.TrashmailLogin(driver);
        TimeUnit.SECONDS.sleep(20);
        String name=driver.findElement(By.xpath("//*[contains(@class,'disposable-name')]/div")).getText();
        String domain=driver.findElement(By.xpath("//*[contains(@class,'disposable-domain')]/div")).getText();
        String trashmailAdress=name+domain;
        return trashmailAdress;
    }
}
