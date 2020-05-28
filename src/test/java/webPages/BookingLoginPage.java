package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingLoginPage {
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
        username.sendKeys(email);
        username.submit();
    }

    public void enterPassword(String psw){
        password.sendKeys(psw);
        password.submit();
    }

    public void passwordClick(){
        password.click();
    }

    public boolean logoutLinkPresents() {
        return logoutLink.isDisplayed();
    }
}
