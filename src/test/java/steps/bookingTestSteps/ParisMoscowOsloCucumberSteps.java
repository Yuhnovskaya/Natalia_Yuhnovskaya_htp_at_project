package steps.bookingTestSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testObject.BookingTestObjects.BookingTestCase;
import utilites.JSONparser;
import webDriver.Config;
import webDriver.DrManager;
import webDriver.Prop;
import webPages.HotelsPage;

import java.io.FileNotFoundException;
import java.util.Properties;

public class ParisMoscowOsloCucumberSteps {
    static BookingSteps bookingSteps = new BookingSteps();
    static Properties prop = Prop.getProp();
    static WebDriver driver = DrManager.getDriver(Config.CHROME);
    static Actions actions;
    static HotelsPage hotelsPage = new HotelsPage(driver);
    private static final Logger LOGGER = LogManager.getLogger(ParisMoscowOsloCucumberSteps.class);
    @Given("I navigate to booking")
    public void iNavigateToBooking() {
        driver.get("https://silverscreen.by/");
    }

    @When("I search hotels in case {int}")
    public void iSearchHotelsInCase(Integer int1) throws InterruptedException, FileNotFoundException {
        BookingTestCase bookingTestCase = JSONparser.getBookingTestCase("src/test/resources/bookingTestData").get(int1);
        bookingSteps.hotelSearch(driver, bookingTestCase);
        Thread.sleep(5000);
    }

    @When("define the price of the cheapest hotel")
    public void defineThePriceOfTheCheapestHotel() throws InterruptedException {
        hotelsPage.cheapestHotels();
        Thread.sleep(5000);
    }

    @Then("I verify that the price of the cheapest hotel is lower than min filter price")
    public void iVerifyThatThePriceOfTheCheapestHotelIsLowerThanMinFilterPrice() throws InterruptedException {
        int minPrice = bookingSteps.getMinPrice(driver);
        Thread.sleep(3000);
        hotelsPage.SortExpensiveToCheap();
        Thread.sleep(4000);
        int minHotelPrice = bookingSteps.priceOfTheFirstHotelOnTheList(driver);
        Assert.assertTrue(minHotelPrice < minPrice);
    }

    @When("define the price of the most expensive hotel")
    public void defineThePriceOfTheMostExpensiveHotel() throws InterruptedException {
        hotelsPage.expensiveHotels();
    }

    @Then("I verify that the price of the most expensive hotel is higher than max filter price")
    public void iVerifyThatThePriceOfTheMostExpensiveHotelIsHigherThanMaxFilterPrice() throws InterruptedException {
        int maxPrice = bookingSteps.getMaxPrice(driver);
        Thread.sleep(3000);
        int ExpHotelPrice = bookingSteps.priceOfTheFirstHotelOnTheList(driver);
        Assert.assertTrue(ExpHotelPrice > maxPrice);
    }

    @When("paint the background of the tenth hotel green and its text red")
    public void paintTheBackgroundOfTheTenthHotelGreenAndItsTextRed() throws InterruptedException {
        bookingSteps.filterHotelClass(driver, 3);
        Thread.sleep(5000);
        bookingSteps.filterHotelClass(driver, 4);
        Thread.sleep(5000);
        bookingSteps.scrollToTheHotel(driver, 10);
        Thread.sleep(15000);
        WebElement address = hotelsPage.getAddress();
        actions.moveToElement(address).build().perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='green'", address);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color='red'", address);
    }

    @Then("I verify that the color of the background is green and the text is red")
    public void iVerifyThatTheColorOfTheBackgroundIsGreenAndTheTextIsRed() {
        WebElement address = hotelsPage.getAddress();
        Assert.assertEquals("rgba(255, 0, 0, 1)", (address.getCssValue("color")));
    }
}
