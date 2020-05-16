package otherStuff;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webDriver.Steps;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CreateTrashmailAddress {
    public static String createTrashmailAddress(WebDriver driver) throws InterruptedException {
        Properties prop = Prop.getProp();
        driver.get(prop.getProperty("URL_TRASHMAIL"));
        TimeUnit.SECONDS.sleep(3);
        Steps.findClick(driver,"//*[@id=\"tab-mob-create\"]/li[2]/a");
        TimeUnit.SECONDS.sleep(10);
        Steps.findSendKeys(driver, "//*[@id=\"tab-mob-manager\"]/form/div[1]/input", prop.getProperty("USER_NAME"));
        Steps.findSendKeys(driver,"//*[@id=\"tab-mob-manager\"]/form/div[2]/input", prop.getProperty("PSW"));
        Steps.findClick(driver,"//*[@id=\"tab-mob-manager\"]/form/div[4]/button");
        TimeUnit.SECONDS.sleep(20);
        Steps.findClick(driver,"//*[@id=\"fe-add-btnIconEl\"]");
        TimeUnit.SECONDS.sleep(5);
        Steps.findClick(driver,"//*[@id=\"fe-save-btnEl\"]");
        String name=driver.findElement(By.xpath("//*[contains(@class,'disposable-name')]/div")).getText();
        String domain=driver.findElement(By.xpath("//*[contains(@class,'disposable-domain')]/div")).getText();
        String trashmailAdress=name+domain;
        return trashmailAdress;}
}
