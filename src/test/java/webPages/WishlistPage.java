package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {
    @FindBy(xpath = "//*[@class=\"js-remove-hotel listview__remove_hotel_icon\"]")
    private WebElement removeHotel;
    public WishlistPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void removeHotelClick(){
        removeHotel.click();
    }
}
