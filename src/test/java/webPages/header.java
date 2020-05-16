package webPages;

import org.openqa.selenium.WebDriver;
import webDriver.Steps;

public class header {
    public static boolean stayPresents(WebDriver driver){
    return Steps.findElement(driver,"//*[@id=\"cross-product-bar\"]/div/span").isDisplayed();
    }
    public static boolean flightsPresents(WebDriver driver){
    return Steps.findElement(driver,"//*[@id=\"cross-product-bar\"]/div/a[1]").isDisplayed();
    }
    public static boolean carRentsPresents(WebDriver driver){
    return Steps.findElement(driver,"//*[@id=\"cross-product-bar\"]/div/a[2]").isDisplayed();
    }
    public static boolean attractionsPresents(WebDriver driver){
    return Steps.findElement(driver,"//*[@id=\"cross-product-bar\"]/div/a[3]").isDisplayed();
    }
    public static boolean airportTaxiPresents(WebDriver driver){
    return Steps.findElement(driver,"//*[@id=\"cross-product-bar\"]/div/a[4]").isDisplayed();
    }
    public static boolean logoPresents(WebDriver driver){
    return Steps.findElement(driver,"//*[@id=\"logo_no_globe_new_logo\"]").isDisplayed();
    }
    public static boolean languagePresents(WebDriver driver){
    return Steps.findElement(driver,"//*[@id=\"user_form\"]/ul/li[1]").isDisplayed();
    }
    public static boolean countryPresents(WebDriver driver){
    return Steps.findElement(driver,"//*[@id=\"user_form\"]/ul/li[2]").isDisplayed();
    }
    public static boolean helpPresents(WebDriver driver){
    return Steps.findElement(driver,"//*[@id=\"user_form\"]/ul/li[3]").isDisplayed();
    }
    public static boolean propertyPresents(WebDriver driver){
    return Steps.findElement(driver,"//*[@id=\"add_property_topbar\"]").isDisplayed();
    }
    public static boolean registrationPresents(WebDriver driver){
    return Steps.findElement(driver,"//*[@id=\"current_account_create\"]").isDisplayed();
    }
    public static boolean accountPresents(WebDriver driver){
    return Steps.findElement(driver,"//*[@id=\"current_account\"]").isDisplayed();
    }
}
