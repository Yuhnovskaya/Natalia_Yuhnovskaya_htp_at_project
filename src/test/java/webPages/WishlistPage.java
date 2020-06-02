package webPages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.bookingTestSteps.BookingSteps;

public class WishlistPage {
    private static final Logger LOGGER = LogManager.getLogger(WishlistPage.class);
    @FindBy(xpath = "//*[@class=\"js-remove-hotel listview__remove_hotel_icon\"]")
    private WebElement removeHotel;
    public WishlistPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void removeHotelClick(){
        LOGGER.debug("The method clicks Webelement removeHotel");
        removeHotel.click();
    }
}
