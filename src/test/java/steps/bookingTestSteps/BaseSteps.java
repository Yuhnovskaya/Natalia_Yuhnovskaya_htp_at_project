package steps.bookingTestSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BaseSteps {
    static Actions actions;

    public static WebElement findElement(WebDriver driver, String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        return element;
    }

    public static void findSendKeysClick(WebDriver driver, String xpath, String text) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys(text);
        element.submit();
    }

    public static void findSendKeys(WebDriver driver, String xpath, String text) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.sendKeys(text);
    }

    public static void findClick(WebDriver driver, String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    public static WebElement elementFindClick(WebDriver driver, String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
        return element;
    }
    public static int converterStringToDigit(String string){
        string=string.replaceAll("[^0-9]+","");
        int digit=Integer.parseInt(string);
        return digit;
    }
}