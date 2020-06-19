package web_pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BookingLoginPage {
    private static final Logger LOGGER = LogManager.getLogger(BookingLoginPage.class);
    @FindBy(xpath = "//*[@id='current_account']")
    private WebElement account;

    @FindBy(xpath = "//*[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//*[@id='profile-menu']/form/input[5]")
    private WebElement logoutLink;

    public BookingLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String email) {
        username.sendKeys(email);
        username.submit();
        LOGGER.debug("The method fills username field with email");
    }

    public void enterPassword(String psw) {
        password.sendKeys(psw);
        password.submit();
        LOGGER.debug("The method fills password field with psw");
    }

    public void passwordClick() {
        password.click();
        LOGGER.debug("The method clicks Webelement password");
    }

    public boolean logoutLinkPresents() {
        return logoutLink.isDisplayed();
    }

    public void login(String email, String password) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        enterUsername(email);
        TimeUnit.SECONDS.sleep(3);
        enterPassword(password);
        LOGGER.debug("The method completes login form");
    }
}
