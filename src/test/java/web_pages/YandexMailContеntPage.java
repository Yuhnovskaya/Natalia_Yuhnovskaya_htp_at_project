package web_pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import web_driver.Driver;

public class YandexMailContеntPage {
    private static final Logger LOGGER = LogManager.getLogger(YandexMailContеntPage.class);
    @FindBy(xpath = "//span[contains(text(),'Включить')]")
    private WebElement getLinksButton;
    @FindBy(xpath = "//*[contains(@href,'https://secure.booking.com/login.ru.html?')]")
    private WebElement confirmBookingButton;
    @FindBy(xpath="//*[contains(@href, 'https://trashmail.com/?']")
    private WebElement confirmTrashmailLink;

    public YandexMailContеntPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void getLinks() {
        getLinksButton.click();
        LOGGER.debug("The method clicks Webelement getLinksButton");
    }

    public void confirmBooking() {
        confirmBookingButton.click();
        LOGGER.debug("The method clicks Webelement confirmBookingButton");
    }
    public void confirmTrashmail(){
        confirmTrashmailLink.click();
        LOGGER.debug("The method clicks TrahsMail confirmation link");
    }
}
