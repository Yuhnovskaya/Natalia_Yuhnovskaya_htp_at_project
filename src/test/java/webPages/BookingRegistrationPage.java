package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingRegistrationPage {
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
    }

    public void enterPassword(String psw) {
        password.sendKeys(psw);
    }

    public void confirmPassword(String psw) {
        confirmation.sendKeys(psw);
    }

    public void close() {
        closeButton.click();
    }
}

