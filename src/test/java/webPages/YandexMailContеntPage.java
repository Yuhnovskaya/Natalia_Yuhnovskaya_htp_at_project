package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexMailContеntPage {
    @FindBy(xpath = "//span[contains(text(),'Включить')]")
    private WebElement getLinksButton;

    @FindBy(xpath = "//*[contains(@href,\"https://secure.booking.com/login.ru.html?\")]")
    WebElement confirmBookingButton;

    public YandexMailContеntPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void getLinks() {
        getLinksButton.click();
    }

    public void confirmBooking() {
        confirmBookingButton.click();
    }
}
