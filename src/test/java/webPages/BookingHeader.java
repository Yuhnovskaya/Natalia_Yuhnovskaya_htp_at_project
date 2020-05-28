package webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingHeader {
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
        return stay.isDisplayed();
    }

    public boolean flightsPresents(WebDriver driver) {
        return flights.isDisplayed();
    }

    public boolean carRentsPresents(WebDriver driver) {
        return carRent.isDisplayed();
    }

    public boolean attractionsPresents(WebDriver driver) {
        return attractions.isDisplayed();
    }

    public boolean airportTaxiPresents(WebDriver driver) {
        return airportTaxi.isDisplayed();
    }

    public boolean logoPresents(WebDriver driver) {
        return logo.isDisplayed();
    }

    public boolean languagePresents(WebDriver driver) {
        return language.isDisplayed();
    }

    public boolean countryPresents(WebDriver driver) {
        return country.isDisplayed();
    }

    public boolean helpPresents(WebDriver driver) {
        return help.isDisplayed();
    }

    public boolean propertyPresents(WebDriver driver) {
        return property.isDisplayed();
    }

    public boolean registrationPresents(WebDriver driver) {
        return registration.isDisplayed();
    }

    public boolean accountPresents(WebDriver driver) {
        return account.isDisplayed();
    }
}
