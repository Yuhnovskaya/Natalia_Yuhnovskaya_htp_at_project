package webPages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.bookingTestSteps.BookingSteps;

public class YandexMailContеntPage {
    private static final Logger LOGGER = LogManager.getLogger(YandexMailContеntPage.class);
    @FindBy(xpath = "//span[contains(text(),'Включить')]")
    private WebElement getLinksButton;

    @FindBy(xpath = "//*[contains(@href,\"https://secure.booking.com/login.ru.html?\")]")
    WebElement confirmBookingButton;

    public YandexMailContеntPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void getLinks() {
        LOGGER.debug("The method clicks Webelement getLinksButton");
        getLinksButton.click();
    }

    public void confirmBooking() {
        LOGGER.debug("The method clicks Webelement confirmBookingButton");
        confirmBookingButton.click();
    }
}
