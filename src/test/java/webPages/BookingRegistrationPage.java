package webPages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.bookingTestSteps.BookingSteps;

public class BookingRegistrationPage {
    private static final Logger LOGGER = LogManager.getLogger(BookingRegistrationPage.class);
    @FindBy(xpath = "//*[@type='email']")
    private WebElement email;

    @FindBy(xpath = " //*[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//*[@id='confirmed_password']")
    private WebElement confirmation;

    @FindBy(xpath = "//*[contains(@class,'closeBtn')]")
    private WebElement closeButton;

    public BookingRegistrationPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void enterEmail(String newAddress) {
        LOGGER.debug("The method fills email field with newAddress");
        email.sendKeys(newAddress);
    }

    public void enterPassword(String psw) {
        LOGGER.debug("The method fills password field with psw");
        password.sendKeys(psw);
    }

    public void confirmPassword(String psw) {
        LOGGER.debug("The method fills password comformation field with psw");
        confirmation.sendKeys(psw);
    }

    public void close() {
        LOGGER.debug("The method clicks close button");
        closeButton.click();
    }
}

