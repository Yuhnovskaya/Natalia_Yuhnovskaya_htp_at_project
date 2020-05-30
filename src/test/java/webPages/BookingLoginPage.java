package webPages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.bookingTestSteps.BookingSteps;

public class BookingLoginPage {
    private static final Logger LOGGER = LogManager.getLogger(BookingLoginPage.class);
    @FindBy(xpath = "//*[@id=\"current_account\"]")
    private WebElement account;

    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement username;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"profile-menu\"]/form/input[5]")
    private WebElement logoutLink;

    public BookingLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void enterUsername(String email){
        LOGGER.debug("The method fills username field with email");
        username.sendKeys(email);
        username.submit();
    }

    public void enterPassword(String psw){
        LOGGER.debug("The method fills password field with psw");
        password.sendKeys(psw);
        password.submit();
    }

    public void passwordClick(){
        LOGGER.debug("The method clicks Webelement password");
        password.click();
    }

    public boolean logoutLinkPresents() {
        LOGGER.debug("The method comfirms that Webelement logoutLink is present");
        return logoutLink.isDisplayed();
    }
}
