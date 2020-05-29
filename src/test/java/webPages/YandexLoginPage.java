package webPages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.bookingTestSteps.BookingSteps;

public class YandexLoginPage {
    private static final Logger LOGGER = LogManager.getLogger(YandexLoginPage.class);
    @FindBy(xpath = "//*[@class=\"HeadBanner-ButtonsWrapper\"]/a[2]")
    private WebElement signIn;

    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    private WebElement mail;

    @FindBy(xpath = "//*[@id=\"passp-field-passwd\"]")
    private WebElement password;

    public YandexLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void signInClick() {
        LOGGER.debug("The method clicks Webelement signIn");
        signIn.click();
    }

    public void enterEmail(String email) {
        LOGGER.debug("The method fills mail field with email");
        mail.sendKeys(email);
    }

    public void enterPassword(String psw) {
        LOGGER.debug("The method fills password field with psw");
        password.sendKeys(psw);
    }
}
