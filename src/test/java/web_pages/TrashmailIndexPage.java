package web_pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class TrashmailIndexPage {
    private static final Logger LOGGER = LogManager.getLogger(TrashmailIndexPage.class);
    @FindBy(xpath = "//*[@id='tab-mob-create']/li[2]/a")
    private WebElement addressManager;
    @FindBy(xpath = "//*[@id='tab-mob-manager']/form/div[1]/input")
    private WebElement login;
    @FindBy(xpath = "//*[@id='tab-mob-manager']/form/div[2]/input")
    private WebElement password;
    @FindBy(xpath = "//*[@id='tab-mob-manager']/form/div[4]/button")
    private WebElement signIn;
    @FindBy(xpath = "//*[@id='tab-mob-create']/li[3]")
    private WebElement newUser;
    @FindBy(xpath = "//*[@id='tab-mob-register']/form/div[1]/input")
    private WebElement newLogin;
    @FindBy(xpath = "//*[@id='tab-mob-register']/form/div[2]/input")
    private WebElement newPassword;
    @FindBy(xpath = "//*[@id='tab-mob-register']/form/div[3]/input")
    private WebElement confirmPassword;
    @FindBy(xpath = "//*[@id='tab-mob-register']/form/div[4]/input")
    private WebElement email;
    @FindBy(xpath = "//*[@id='tab-mob-register']/form/div[6]/button")
    private WebElement confirmButton;

    public TrashmailIndexPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void addressManagerClick() {
        addressManager.click();
        LOGGER.debug("The method clicks Webelement addressManager");
    }

    public void enterLogin(String username) {
        login.sendKeys(username);
        LOGGER.debug("The method fills login field with username");
    }

    public void enterPassword(String psw) {
        password.sendKeys(psw);
        LOGGER.debug("The method fills password field with psw");
    }

    public void signInClick() {
        signIn.click();
        LOGGER.debug("The method clicks Webelement signIn");
    }

    public void newUserClick() {
        newUser.click();
        LOGGER.debug("The method clicks Webelement newUser");
    }

    public void enterNewLogin(String username) {
        newLogin.sendKeys(username);
        LOGGER.debug("The method fills newLogin field with username");
    }

    public void enterNewPassword(String psw) {
        newPassword.sendKeys(psw);
        LOGGER.debug("The method fills password field with psw");
    }

    public void confirmNewPassword(String psw) {
        confirmPassword.sendKeys(psw);
        LOGGER.debug("The method fills confirmPassword field with psw");
    }

    public void enterEmail(String mail) {
        email.sendKeys(mail);
        LOGGER.debug("The method fills email field with mail");
    }

    public void confirmButtonClick() {
        confirmButton.click();
        LOGGER.debug("The method click confirmButton");
    }
    public void trashmailLogin(String username, String password) throws InterruptedException {
        addressManagerClick();
        TimeUnit.SECONDS.sleep(10);
        enterLogin(username);
        enterPassword(password);
        signInClick();
        LOGGER.debug("The method fills TrashMail login form");
    }

    public void trashmailRegistration(String username, String password, String email) throws InterruptedException {
        newUserClick();
        TimeUnit.SECONDS.sleep(3);
        enterNewLogin(username);
        enterNewPassword(password);
        confirmNewPassword(password);
        enterEmail(email);
        confirmButtonClick();
        LOGGER.debug("The method fills TrashMail registration form");
    }
}
