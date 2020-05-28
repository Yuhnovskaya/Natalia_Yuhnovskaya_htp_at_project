package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexLoginPage {
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
        signIn.click();
    }

    public void enterEmail(String email) {
        mail.sendKeys(email);
    }

    public void enterPassword(String psw) {
        password.sendKeys(psw);
    }
}
