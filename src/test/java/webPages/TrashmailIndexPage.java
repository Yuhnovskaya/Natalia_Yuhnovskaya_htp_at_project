package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrashmailIndexPage {
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
        addressManager.click();
    }

    public void enterLogin(String username) {
        login.sendKeys(username);
    }

    public void enterPassword(String psw) {
        password.sendKeys(psw);
    }

    public void signInClick() {
        signIn.click();
    }

    public void newUserClick() {
        newUser.click();
    }

    public void enterNewLogin(String username) {
        newLogin.sendKeys(username);
    }

    public void enterNewPassword(String psw) {
        newPassword.sendKeys(psw);
    }

    public void confirmNewPassword(String psw) {
        confirmPassword.sendKeys(psw);
    }

    public void enterEmail(String mail) {
        email.sendKeys(mail);
    }

    public void confirmButtonClick() {
        confirmButton.click();
    }
}
