package steps.cucumber_steps.booking;

import cucumber.api.java.After;
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
import steps.booking_test_steps.BookingProperties;
import test_objects.booking_test_objects.BookingTestCase;
import utilites.JSONparser;
import web_driver.Driver;
import web_pages.BookingIndexPage;
import web_pages.HotelsPage;

import java.awt.print.Book;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import static web_driver.Config.CHROME;

public class ParisMoscowOsloCucumberSteps {
    WebDriver driver=Driver.initDriver(CHROME);
    BookingIndexPage bookingIndexPage=new BookingIndexPage(driver);
    HotelsPage hotelsPage=new HotelsPage(driver);
    BookingProperties bookingProperties=new BookingProperties();
    static Actions actions;
    static int maxPrice;
private static final Logger LOGGER = LogManager.getLogger(ParisMoscowOsloCucumberSteps.class);
    @Given("I navigate to booking")
    public void iNavigateToBooking() {
        Driver.getURL(bookingProperties.urlBooking);
    }

    @When("I search hotels in case {int}")
    public void iSearchHotelsInCase(Integer caseNumber) throws InterruptedException, FileNotFoundException {
        BookingTestCase bookingTestCase = JSONparser.getBookingTestCase("src/test/resources/bookingTestData").get(caseNumber);
        bookingIndexPage.hotelSearch(bookingTestCase);
        bookingIndexPage.checkPrice();
        TimeUnit.SECONDS.sleep(5);
    }

    @When("define the price of the cheapest hotel")
    public void defineThePriceOfTheCheapestHotel() throws InterruptedException {
        hotelsPage.cheapestHotels();
        TimeUnit.SECONDS.sleep(5);
        maxPrice = hotelsPage.getMinPrice();
        TimeUnit.SECONDS.sleep(3);
    }

    @Then("I check that the price of the cheapest hotel is lower than min filter price")
    public void iVerifyThatThePriceOfTheCheapestHotelIsLowerThanMinFilterPrice() throws InterruptedException {
        hotelsPage.SortExpensiveToCheap();
        TimeUnit.SECONDS.sleep(4);
        int minHotelPrice = hotelsPage.priceOfTheFirstHotelOnTheList();
        Assert.assertTrue(minHotelPrice <= maxPrice);
    }

    @When("define the price of the most expensive hotel")
    public void defineThePriceOfTheMostExpensiveHotel() throws InterruptedException {
        hotelsPage.expensiveHotels();
        maxPrice = hotelsPage.getMaxPrice();
        TimeUnit.SECONDS.sleep(3);
    }

    @Then("I check that the price of the most expensive hotel is higher than max filter price")
    public void iVerifyThatThePriceOfTheMostExpensiveHotelIsHigherThanMaxFilterPrice() throws InterruptedException {
        int ExpHotelPrice = hotelsPage.priceOfTheFirstHotelOnTheList();
        Assert.assertTrue(ExpHotelPrice > maxPrice);
    }

    @When("paint the background of the tenth hotel green and its text red")
    public void paintTheBackgroundOfTheTenthHotelGreenAndItsTextRed() throws InterruptedException {
        hotelsPage.filterHotelClass(3);
        TimeUnit.SECONDS.sleep(5);
        hotelsPage.filterHotelClass(4);
        TimeUnit.SECONDS.sleep(5);
        hotelsPage.scrollToTheHotel(10);
        TimeUnit.SECONDS.sleep(15);
        WebElement address = hotelsPage.getAddress();
        actions.moveToElement(address).build().perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor='green'", address);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color='red'", address);
    }

    @Then("I check that the color of the background is green and the text is red")
    public void iVerifyThatTheColorOfTheBackgroundIsGreenAndTheTextIsRed() {
        WebElement address = hotelsPage.getAddress();
        Assert.assertEquals("rgba(255, 0, 0, 1)", (address.getCssValue("color")));
    }
    @After
    public void doAfterTest() throws InterruptedException {
        Driver.clearCache();
    }
}
