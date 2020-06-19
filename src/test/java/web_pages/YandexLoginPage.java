package web_pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilites.MyProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class YandexLoginPage {
    private static final Logger LOGGER = LogManager.getLogger(YandexLoginPage.class);
    @FindBy(xpath = "//*[@class='HeadBanner-ButtonsWrapper']/a[2]")
    private WebElement signIn;

    @FindBy(xpath = "//*[@id='passp-field-login']")
    private WebElement mail;

    @FindBy(xpath = "//*[@id='passp-field-passwd']")
    private WebElement password;

    public YandexLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void signInClick() {
        signIn.click();
        LOGGER.debug("The method clicks Webelement signIn");
    }

    public void enterEmail(String email) {
        mail.sendKeys(email);
        mail.submit();
        LOGGER.debug("The method fills mail field with email");
    }

    public void enterPassword(String psw) {
        password.sendKeys(psw);
        password.submit();
        LOGGER.debug("The method fills password field with psw");
    }
    public void enterYandexMail(String email, String password) throws InterruptedException {
        signInClick();
        TimeUnit.SECONDS.sleep(1);
        enterEmail(email);
        TimeUnit.SECONDS.sleep(1);
        enterPassword(password);
        LOGGER.debug("The method fills Yandex login form");
    }
}
