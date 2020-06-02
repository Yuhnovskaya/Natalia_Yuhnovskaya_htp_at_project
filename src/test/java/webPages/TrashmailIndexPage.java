package webPages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.bookingTestSteps.BookingSteps;

public class TrashmailIndexPage {
    private static final Logger LOGGER = LogManager.getLogger(TrashmailIndexPage.class);
    @FindBy(xpath = "//*[@id=\"tab-mob-create\"]/li[2]/a")
    private WebElement addressManager;
    @FindBy(xpath = "//*[@id=\"tab-mob-manager\"]/form/div[1]/input")
    private WebElement login;
    @FindBy(xpath = "//*[@id=\"tab-mob-manager\"]/form/div[2]/input")
    private WebElement password;
    @FindBy(xpath = "//*[@id=\"tab-mob-manager\"]/form/div[4]/button")
    private WebElement signIn;
    @FindBy(xpath = "//*[@id=\"tab-mob-create\"]/li[3]")
    private WebElement newUser;
    @FindBy(xpath = "//*[@id=\"tab-mob-register\"]/form/div[1]/input")
    private WebElement newLogin;
    @FindBy(xpath = "//*[@id=\"tab-mob-register\"]/form/div[2]/input")
    private WebElement newPassword;
    @FindBy(xpath = "//*[@id=\"tab-mob-register\"]/form/div[3]/input")
    private WebElement confirmPassword;
    @FindBy(xpath = "//*[@id=\"tab-mob-register\"]/form/div[4]/input")
    private WebElement email;
    @FindBy(xpath = "//*[@id=\"tab-mob-register\"]/form/div[6]/button")
    private WebElement confirmButton;

    public TrashmailIndexPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void addressManagerClick() {
        LOGGER.debug("The method clicks Webelement addressManager");
        addressManager.click();
    }

    public void enterLogin(String username) {
        LOGGER.debug("The method fills login field with username");
        login.sendKeys(username);
    }

    public void enterPassword(String psw) {
        LOGGER.debug("The method fills password field with psw");
        password.sendKeys(psw);
    }

    public void signInClick() {
        LOGGER.debug("The method clicks Webelement signIn");
        signIn.click();
    }

    public void newUserClick() {
        LOGGER.debug("The method clicks Webelement newUser");
        newUser.click();
    }

    public void enterNewLogin(String username) {
        LOGGER.debug("The method fills newLogin field with username");
        newLogin.sendKeys(username);
    }

    public void enterNewPassword(String psw) {
        LOGGER.debug("The method fills password field with psw");
        newPassword.sendKeys(psw);
    }

    public void confirmNewPassword(String psw) {
        LOGGER.debug("The method fills confirmPassword field with psw");
        confirmPassword.sendKeys(psw);
    }

    public void enterEmail(String mail) {
        LOGGER.debug("The method fills email field with mail");
        email.sendKeys(mail);
    }

    public void confirmButtonClick() {
        LOGGER.debug("The method click confirmButton");
        confirmButton.click();
    }
}
