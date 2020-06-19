package web_pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        email.sendKeys(newAddress);
        email.submit();
        LOGGER.debug("The method fills email field with newAddress");
    }

    public void enterPassword(String psw) {
        password.sendKeys(psw);
        password.submit();
        LOGGER.debug("The method fills password field with psw");
    }

    public void confirmPassword(String psw) {
        confirmation.sendKeys(psw);
        password.submit();
        LOGGER.debug("The method fills password comformation field with psw");
    }

    public void close() {
        closeButton.click();
        LOGGER.debug("The method clicks close button");
    }
}

