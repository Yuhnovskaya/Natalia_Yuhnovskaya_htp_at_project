package webPages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.bookingTestSteps.BookingSteps;

public class BookingHeader {
    private static final Logger LOGGER = LogManager.getLogger(BookingHeader.class);
    @FindBy(xpath = "//*[@id=\"cross-product-bar\"]/div/span")
    private WebElement stay;

    @FindBy(xpath = "//*[@id=\"cross-product-bar\"]/div/a[1]")
    private WebElement flights;

    @FindBy(xpath = "//*[@id=\"cross-product-bar\"]/div/a[2]")
    private WebElement carRent;

    @FindBy(xpath = "//*[@id=\"cross-product-bar\"]/div/a[3]")
    private WebElement attractions;

    @FindBy(xpath = "//*[@id=\"cross-product-bar\"]/div/a[4]")
    private WebElement airportTaxi;

    @FindBy(xpath = "//*[@id=\"logo_no_globe_new_logo\"]")
    private WebElement logo;

    @FindBy(xpath = "//*[@id=\"user_form\"]/ul/li[1]")
    private WebElement language;

    @FindBy(xpath = "//*[@id=\"user_form\"]/ul/li[2]")
    private WebElement country;

    @FindBy(xpath = "//*[@id=\"user_form\"]/ul/li[3]")
    private WebElement help;

    @FindBy(xpath = "//*[@id=\"add_property_topbar\"]")
    private WebElement property;

    @FindBy(xpath = "//*[@id=\"current_account_create\"]")
    private WebElement registration;

    @FindBy(xpath = "//*[@id=\"current_account\"]")
    private WebElement account;

    public BookingHeader(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public boolean stayPresents(WebDriver driver) {
        LOGGER.debug("The method confirm that Webelement 'stay' is present");
        return stay.isDisplayed();
    }

    public boolean flightsPresents(WebDriver driver) {
        LOGGER.debug("The method confirm that Webelement 'flights' is present");
        return flights.isDisplayed();
    }

    public boolean carRentsPresents(WebDriver driver) {
        LOGGER.debug("The method confirm that Webelement 'carRents' is present");
        return carRent.isDisplayed();
    }

    public boolean attractionsPresents(WebDriver driver) {
        LOGGER.debug("The method confirm that Webelement 'attractions' is present");
        return attractions.isDisplayed();
    }

    public boolean airportTaxiPresents(WebDriver driver) {
        LOGGER.debug("The method confirm that Webelement 'airportTaxi' is present");
        return airportTaxi.isDisplayed();
    }

    public boolean logoPresents(WebDriver driver) {
        LOGGER.debug("The method confirm that Webelement 'logo' is present");
        return logo.isDisplayed();
    }

    public boolean languagePresents(WebDriver driver) {
        LOGGER.debug("The method confirm that Webelement 'languege' is present");
        return language.isDisplayed();
    }

    public boolean countryPresents(WebDriver driver) {
        LOGGER.debug("The method confirm that Webelement 'country' is present");
        return country.isDisplayed();
    }

    public boolean helpPresents(WebDriver driver) {
        LOGGER.debug("The method confirm that Webelement 'help' is present");
        return help.isDisplayed();
    }

    public boolean propertyPresents(WebDriver driver) {
        LOGGER.debug("The method confirm that Webelement 'property' is present");
        return property.isDisplayed();
    }

    public boolean registrationPresents(WebDriver driver) {
        LOGGER.debug("The method confirm that Webelement 'registration' is present");
        return registration.isDisplayed();
    }

    public boolean accountPresents(WebDriver driver) {
        LOGGER.debug("The method confirm that Webelement 'account' is present");
        return account.isDisplayed();
    }
}
