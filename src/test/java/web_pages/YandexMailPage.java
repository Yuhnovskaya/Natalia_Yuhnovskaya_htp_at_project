package web_pages;

import com.google.gson.JsonParseException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web_driver.Driver;

public class YandexMailPage {
    private static final Logger LOGGER = LogManager.getLogger(YandexMailPage.class);
    @FindBy(xpath = "//*[contains(text(), 'trashmail')]")
    private WebElement mailFromTrashmail;
    @FindBy(xpath ="//*[@href='#spam']")
    private WebElement spam;

    @FindBy(xpath = "(//*[contains(text(), 'booking')])[1]")
    private WebElement mailFromBooking;


    public YandexMailPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void enterSpam(){
        spam.click();
        LOGGER.debug("The method clicks Webelement spam");
    }
    public void findMailfromTrashMail(){
        mailFromTrashmail.click();
    }
    public void findMailFromBooking(){
        mailFromBooking.click();
        LOGGER.debug("The method clicks Webelement mailFromBooking");
    }
}
