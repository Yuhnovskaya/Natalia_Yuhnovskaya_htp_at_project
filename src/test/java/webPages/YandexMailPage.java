package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexMailPage {
    @FindBy(xpath ="//*[@href=\"#spam\"]")
    private WebElement spam;

    @FindBy(xpath = "(//*[contains(text(), \"booking\")])[1]")
    private WebElement mailFromBooking;

    public YandexMailPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void enterSpam(){
        spam.click();
    }

    public void findMailFromBooking(){
        mailFromBooking.click();
    }
}
