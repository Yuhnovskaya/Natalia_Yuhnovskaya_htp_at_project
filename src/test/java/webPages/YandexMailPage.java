package webPages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.bookingTestSteps.BookingSteps;

public class YandexMailPage {
    private static final Logger LOGGER = LogManager.getLogger(YandexMailPage.class);
    @FindBy(xpath ="//*[@href=\"#spam\"]")
    private WebElement spam;

    @FindBy(xpath = "(//*[contains(text(), \"booking\")])[1]")
    private WebElement mailFromBooking;

    public YandexMailPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void enterSpam(){
        LOGGER.debug("The method clicks Webelement spam");
        spam.click();
    }

    public void findMailFromBooking(){
        LOGGER.debug("The method clicks Webelement mailFromBooking");
        mailFromBooking.click();
    }
}
